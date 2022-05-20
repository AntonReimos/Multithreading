import core.Line;
import core.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "ExceptionsDebuggingAndTesting/homework_2/SPBMetro/src/main/resources/map.json";
    private static final Marker search = MarkerManager.getMarker("SEARCH"); //добавил
    private static final Marker errors = MarkerManager.getMarker("ERRORS");//добавил
    private static final Marker debugs = MarkerManager.getMarker("DEBUG");//добавил
    private static Logger rootLogger;//добавил
    private static Scanner scanner;
    private static Logger loggerSearch;
    private static Logger loggerErrors;
    private static Logger loggerExceptions;



    private static StationIndex stationIndex;

    public static void main(String[] args) {
        loggerSearch = LogManager.getLogger("SPB_Search_Log");
        loggerErrors = LogManager.getLogger("SPB_Error_Log");
        loggerExceptions = LogManager.getLogger("SPB_Debug_Log");

        rootLogger = LogManager.getRootLogger();
        RouteCalculator calculator = getRouteCalculator();


        System.out.println("Программа расчёта маршрутов метрополитена Санкт-Петербурга\n");
        scanner = new Scanner(System.in);
        for (; ; ) {
            Station from = takeStation("Введите станцию отправления:");
            Station to = takeStation("Введите станцию назначения:");

            List<Station> route = calculator.getShortestRoute(from, to);
            System.out.println("Маршрут:");
            printRoute(route);

            System.out.println("Длительность: " +
                    RouteCalculator.calculateDuration(route) + " минут");


        }

    }

    private static RouteCalculator getRouteCalculator() {
        try {
            createStationIndex();

        } catch (Exception ex) {
            //loggerExceptions.debug(ex + " - " + "Не удалось создать stationIndex");
        }
        return new RouteCalculator(stationIndex);
    }

    private static void printRoute(List<Station> route) {
        Station previousStation = null;
        for (Station station : route) {
            if (previousStation != null) {
                Line prevLine = previousStation.getLine();
                Line nextLine = station.getLine();
                if (!prevLine.equals(nextLine)) {
                    System.out.println("\tПереход на станцию " +
                            station.getName() + " (" + nextLine.getName() + " линия)");
                }
            }
            System.out.println("\t" + station.getName());
            previousStation = station;
        }
    }

    private static Station takeStation(String message) {
        for (; ; ) {
            System.out.println(message);
            String line = scanner.nextLine().trim();
            Station station = stationIndex.getStation(line);
            if (station != null) {
                //loggerSearch.info("Найдена станция \"" + line + "\"");
                rootLogger.info(search, "Найдена станция \"" + line + "\" с маркером" );//добавил
                return station;
            }
            //loggerErrors.error("Станция \"" + line + "\" не найдена!");
            rootLogger.error(errors,"Станция \"" + line + "\" не найдена! с маркером" );//добавил
            System.out.println("Станция не найдена :(");
        }
    }

    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            //loggerExceptions.debug(ex + " - " + "Невозможно прочитать файл");
            rootLogger.debug(debugs, ex + " - " + "Невозможно прочитать файл с маркером");//добавил
        }
    }

    private static void parseConnections(JSONArray connectionsArray) {
        try {
            connectionsArray.forEach(connectionObject ->
            {
                JSONArray connection = (JSONArray) connectionObject;
                List<Station> connectionStations = new ArrayList<>();

                connection.forEach(item ->
                {
                    JSONObject itemObject = (JSONObject) item;
                    int lineNumber = ((Long) itemObject.get("line")).intValue();
                    String stationName = (String) itemObject.get("station");

                    Station station = stationIndex.getStation(stationName, lineNumber);
                    if (station == null) {
                        throw new IllegalArgumentException("core.Station " +
                                stationName + " on line " + lineNumber + " not found");
                    }
                    connectionStations.add(station);

                });
                stationIndex.addConnection(connectionStations);

            });
        } catch (Exception ex) {
            //loggerExceptions.debug(ex + " - " + "Невозмоно прочитать пересадки");
            rootLogger.debug(debugs,ex + " - " + "Невозмоно прочитать пересадки с маркером" );// добавил
            ex.getMessage();
        }
    }

    private static void parseStations(JSONObject stationsObject) {
        try {
            stationsObject.keySet().forEach(lineNumberObject ->
            {
                int lineNumber = Integer.parseInt((String) lineNumberObject);
                Line line = stationIndex.getLine(lineNumber);
                JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
                stationsArray.forEach(stationObject ->
                {
                    Station station = new Station((String) stationObject, line);
                    stationIndex.addStation(station);
                    line.addStation(station);
                });
            });
        } catch (Exception ex) {
            //loggerExceptions.debug(ex + " - " + "Невозмоно прочитать станции");
            rootLogger.debug(debugs,ex + " - " + "Невозмоно прочитать пересадки с маркером" );// добавил
        }
    }

    private static void parseLines(JSONArray linesArray) {
        try {


        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }catch (Exception ex){
            //loggerExceptions.debug(ex + " - " + "Невозмоно прочитать линии");
            rootLogger.debug(debugs,ex + " - " + "Невозмоно прочитать пересадки с маркером" );// добавил
        }
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            //loggerExceptions.debug(ex + " - " + "Неправильный путь к файлу");
            rootLogger.debug(debugs,ex + " - " + "Невозмоно прочитать пересадки с маркером" );// добавил
        }
        return builder.toString();
    }

}
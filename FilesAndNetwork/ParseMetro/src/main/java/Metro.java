import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TODO: Напишите программу, которая:
// Читает файл и выводит в консоль количество станций на каждой линии.

public class Metro {
    private static HashMap<String, List<String>> stationMap = new HashMap<>();
    private static HashMap<String, String> linesName = new HashMap<>();
    private static List<Line> lines = new ArrayList<>();

    public void metro(String url) throws IOException {
        Metro.createObjects(Metro.HTML(url));
        Metro.createJSON();
    }

    public static Document HTML(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc;
    }

    public static void createObjects(Document doc) {
        Elements Parslines = doc.select("div");
        for (Element e : Parslines) {
            // создаем лист линий по номерам и названиям.
            if (e.attr("class").equals("js-toggle-depend s-depend-control-single  ")
                    | e.attr("class").
                    equals("js-toggle-depend s-depend-control-single  s-depend-control-active")) {
                String num = e.select("span").attr("data-line");
                String name = e.select("span").text();
                linesName.put(num, name);
            }
            // Создаем лист элементов со станциями на каждую линию.
            if (e.attr("class").equals("js-metro-stations t-metrostation-list-table")) {
                if (!e.select("p").isEmpty()) {
                    List<String> station = new ArrayList<>();
                    String stationOfLine = e.select("p").text();
                    String[] stringArray = stationOfLine.split("\\d+.");
                    for (String s : stringArray) {
                        if (!s.equals("")) {
                            station.add(s);
                        }
                    }
                    stationMap.put(e.attr("data-line"), station);
                }
            }
        }
        Set<String> keys = linesName.keySet();
        for (String k : keys) {
            Line l = new Line();
            l.setNumber(k);
            l.setName(linesName.get(k));
            lines.add(l);
        }
    }

    public static void createJSON() throws IOException {
        Stations stations = new Stations();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStation = "";
        String jsonLine = "";
        stations.setStations(stationMap);
        stations.setLines(lines);
        jsonStation = objectMapper.writeValueAsString(stations);
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("FilesAndNetwork\\ParseMetro\\src\\main\\resources\\map2.json"));
        writer.write(jsonStation);
        writer.write(jsonLine);
        writer.flush();
        writer.close();
    }
}
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Parse {
    private static HashMap<String, List<String>> stationsOfLines = new HashMap<>();
    private static List<String> keyset = new ArrayList<>();

    private static String getFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void ParseStationsCount(String path) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonData = (JSONObject) jsonParser.parse(getFile(path));
        JSONArray linesArray = (JSONArray) jsonData.get("lines");
        linesArray.forEach(lineObject -> {
            JSONObject lineJSONObject = (JSONObject) lineObject;
            keyset.add(lineJSONObject.get("number").toString());
        });

        JSONObject stationObject = (JSONObject) jsonData.get("stations");

        stationObject.keySet().forEach(lineNumberOblect ->
        {
            String lineNumber = lineNumberOblect.toString();
            JSONArray stationsArray = (JSONArray) stationObject.get(lineNumber);
            stationsOfLines.put(lineNumber, stationsArray);
        });
        Set<String> key2 = stationsOfLines.keySet();
        for (String k : key2){
            String info = "На линии: " + k + " количество станций равно: " + stationsOfLines.get(k).size();
            System.out.println(info);
        }
    }

}

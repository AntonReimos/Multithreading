import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Metro metro = new Metro();
        metro.metro("https://skillbox-java.github.io/",
                "src/main/resources/MOSmap.json");
        Parse.ParseStationsCount("src/main/resources/MOSmap.json");
    }
}

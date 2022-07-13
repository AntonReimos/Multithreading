import java.util.HashMap;
import java.util.List;

public class Stations {
    private HashMap<String, List<String>> stations;
    private List<Line> lines;

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public HashMap<String, List<String>> getStations() {
        return stations;
    }

    public void setStations(HashMap<String, List<String>> stations) {
        this.stations = stations;
    }

}

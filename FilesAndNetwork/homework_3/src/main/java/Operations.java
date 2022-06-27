import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    private String typeOfAccaunt;
    private String numberOfAccaunt;
    private String currency;
    private String Date;
    private String ref;
    private String description;
    private String coming;
    private String consumption;

    private String regex = "[^\\w]";


    public Operations(String typeOfAccaunt, String numberOfAccaunt, String currency,
                      String date, String ref, String description, String coming, String consumption) {
        this.typeOfAccaunt = typeOfAccaunt;
        this.numberOfAccaunt = numberOfAccaunt;
        this.currency = currency;
        this.Date = date;
        this.ref = ref;
        this.description = description;
        this.coming = coming;
        this.consumption = consumption;
    }

    public static List<Operations> loadOperationsFromFile(String path) {
        List<Operations> operations = new ArrayList<>();
        String out = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length > 8) {
                    String[] l = line.split("\\\"");
                    for (String s : l) {
                        String tmp = "";
                        if (s.matches("\\d+\\,\\d+")) {

                            tmp = s.replace(",", ".");
                        }
                        out = l[0] + tmp;
                    }
                    String[] f = out.split(",");
                    operations.add(new Operations(f[0], f[1],
                            f[2], f[3], f[4],
                            f[5], f[6], f[7]));
                } else {
                    operations.add(new Operations(fragments[0], fragments[1],
                            fragments[2], fragments[3], fragments[4],
                            fragments[5], fragments[6], fragments[7]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operations;
    }


    public String getTypeOfAccaunt() {
        return typeOfAccaunt;
    }

    public String getNumberOfAccaunt() {
        return numberOfAccaunt;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDate() {
        return Date;
    }

    public String getRef() {
        return ref;
    }

    public String getDescription() {
        return description;
    }

    public double getComing() {
        if (coming.equals("Приход")) {
            return 0;
        }
        return Double.valueOf(coming.replaceAll("[\\,]", ".")
                .replaceAll("[\\,]", ""));
    }

    public double getConsumption() {
        if (!consumption.equals("Расход")) {
            String s = "";
            return Double.valueOf(consumption.replaceAll("[\\,]", ".")
                    .replaceAll("[\"]", ""));
        }
        return 0;
    }

    public String test() {
        if (!consumption.equals("Расход")) {
            String s = "";
            return s = consumption;
        }
        return "Ошибка";
    }


    public String toString() {
        return typeOfAccaunt + " - " + numberOfAccaunt + " - " +
                currency + " - " + Date + " - " + ref + " - " +
                description + " - " + coming + " - " + consumption + "\n";
    }
}

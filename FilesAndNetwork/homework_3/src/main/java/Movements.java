import java.util.*;

public class Movements {
    List<Operations> operations = new ArrayList<>();
    static Map<String, List<Operations>> firmMap = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        for (Operations o : Operations.loadOperationsFromFile(pathMovementsCsv)) {
            operations.add(o);
            getCompany(operations);
        }
    }


    public double getExpenseSum() {
        double sumOf = 0;
        for (Operations o : operations) {
            sumOf += o.getConsumption();
        }
        return sumOf;
    }

    public double getIncomeSum() {
        double sumOf = 0;
        for (Operations o : operations) {
            sumOf += o.getComing();
        }
        return sumOf;
    }

    // Собирает все траты по компании в отдельный Map
    private static Map<String, List<Operations>> getCompany(List<Operations> operations) {

        for (Operations o : operations) {
            List<Operations> oneFirm = new ArrayList<>();
            for (Operations d : operations) {
                if (getClearName(o.getDescription()).equals(getClearName(d.getDescription()))) {
                    oneFirm.add(d);
                }
                firmMap.put(getClearName(o.getDescription()), oneFirm);
            }
        }
        return firmMap;
    }

    public void getSumCompany() {
        //getCompany(operations);
        System.out.println("Суммы расходов по организациям:" + "\n");
        Set<String> setKey = firmMap.keySet();
        for (String s1 : setKey) {
            if (s1.equals("Описание операции")) {
                continue;
            }
            double consum = 0;
            for (Operations o : firmMap.get(s1)) {
                consum += o.getConsumption();
            }
            System.out.println(s1 + ": " + consum + " Руб.");
        }
    }


    //Выводин чистое имя компании
    public static String getClearName(String s) {
        String regex1 = "[\\d]{6}[\\+]{6}[\\d]{4}[\\s]+";
        String regex2 = "^\\w+";
        String regexEnd = "\\s\\s[\\d.\\s\\w()-]++";
        return s.replaceAll(regex1, "")
                .replaceFirst(regex2, "")
                .replaceAll(regexEnd, "")
                .strip();
    }

}

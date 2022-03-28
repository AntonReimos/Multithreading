import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetName {
    public static String setName(String name) {
        String regex = "[А-Я]{1}[а-я]+[\\s]{1}[А-Я]{1}[\\.][А-Я]{1}[\\.]";
        String correctedName = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            correctedName = matcher.group();
        }
        return correctedName;
    }}

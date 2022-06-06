
public class Main {
    public static void main(String[] args) {
        String path = "C:/users/antonturov/Desktop/java_tes";
        System.out.println("Размер папки: " + path + " составляет "
                + HumanReadable.humanReadable(FileUtils.calculateFolderSize(path)));
    }
}
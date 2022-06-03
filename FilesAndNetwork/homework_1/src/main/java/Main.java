
public class Main {
    public static void main(String[] args) {
        String path = "C:/users/antonturov/Desktop/java_test";
        System.out.println("Размер папки: " + path + " составляет "
                + FileUtils.calculateFolderSize(path) + " Byte");

    }



}

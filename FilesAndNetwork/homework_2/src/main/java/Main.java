import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "C:\\Users\\antonturov\\Desktop\\java_test";
        String target = "C:\\Users\\antonturov\\Desktop\\java_test_2";

        FileUtils.copyFolder(source, target);
    }
}

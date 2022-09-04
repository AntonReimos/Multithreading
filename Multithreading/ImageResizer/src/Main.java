import java.io.File;
public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\antonturov\\Desktop\\java_test/input";
        String dstFolder = "C:\\Users\\antonturov\\Desktop\\java_test/output";
        File srcDir = new File(srcFolder);


        File[] files = srcDir.listFiles();
        int size = files.length / Runtime.getRuntime().availableProcessors();
        System.out.println("Ядер: " + Runtime.getRuntime().availableProcessors());
        int countOfCore = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < countOfCore; i++) {
            long start = System.currentTimeMillis();
            File[] newFiles = new File[size];
            System.arraycopy(files, i * size, newFiles, 0, newFiles.length);
            ImageResizer imageResizer = new ImageResizer(newFiles, newWidth, dstFolder, start);
            new Thread(imageResizer).start();
        }
    }
}

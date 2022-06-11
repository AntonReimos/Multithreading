import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    private static String defSouPath = "";
    private static String defDestPath = "";


    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        if (defSouPath.isEmpty()) {
            defSouPath = sourceDirectory;
            defDestPath = destinationDirectory;
        }
        File sourceDir = new File(sourceDirectory);
        File destDir = new File(destinationDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
            if (sourceDir.isDirectory()) {
                File[] files = sourceDir.listFiles();
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println("Копируем: " + f.getPath() + " - > " + path(f.getPath()).toPath());
                        Files.copy(f.toPath(), path(f.getPath()).toPath());
                    } else {
                        copyFolder(f.getPath(), path(f.getPath()).getPath());
                    }
                }
            }
        }
    }

    private static File path(String s) {
        String filePath = s.replace(defSouPath, defDestPath);
        File f = new File(filePath);
        return f;
    }
}

import java.io.File;

public class FileUtils {
    private static long size;

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        if (folder.isFile()) {
            return folder.length();
        }
        size = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            size += calculateFolderSize(file.getPath());
        }
        return size;
    }
}


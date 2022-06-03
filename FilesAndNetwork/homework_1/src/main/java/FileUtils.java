import java.io.File;

public class FileUtils {
    private static long size;

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        size = 0;
        if (folder.isFile()) {
            return folder.length();
        } else {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        calculateFolderSize(file.getAbsolutePath());
                    } else {
                        size += file.length();
                    }
                }
            }
            return size;
        }
    }

}


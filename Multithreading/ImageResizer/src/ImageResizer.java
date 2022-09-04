import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizer implements Runnable {
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;


    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }


    @Override
    public void run() {
        for (File file : files) {
            try {
                BufferedImage image = ImageIO.read(file);
                BufferedImage image1 = Scalr.resize(image,
                        Scalr.Method.SPEED,
                        Scalr.Mode.FIT_TO_WIDTH,
                        newWidth);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(image1, "jpg", newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}

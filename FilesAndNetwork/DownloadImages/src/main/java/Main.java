import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        org.jsoup.nodes.Document doc = Jsoup.connect("https://lenta.ru").get();
        Elements element = doc.select("img");
        Set<String> link = new TreeSet<>();
        int count = 0;
        int count1 = 0;
        for (Element e : element) {

            if (!e.attr("src").isBlank() | !e.attr("data-src").isBlank()) {
                count += 1;
            }

            //System.out.println(e.attr("src"));
            if (e.attr("src").matches("https://[\\D\\d]+((.jpg)|(.jpeg))")) {
                downloadImg(e.attr("src"));
                count1 += 1;
                link.add(e.attr("src"));

            }

            if (e.attr("data-src").matches("https://[\\D\\d]+((.jpg)|(.jpeg))")) {
                downloadImg(e.attr("data-src"));
                count1 += 1;
                link.add(e.attr("data-src"));
            }
        }
        System.out.println(link.size());
        System.out.println(count);
        System.out.println(count1);
    }

    public static void downloadImg(String inUrl) throws IOException {
        URL url = new URL(inUrl);
        String filename = inUrl.substring(inUrl.lastIndexOf('/') + 1, inUrl.lastIndexOf('.'));
        String suffix = inUrl.substring(inUrl.lastIndexOf('.'));
        InputStream inputStream = url.openStream();
        Path imgDir = Path.of("FilesAndNetwork/DownloadImages/IMG");
        Path tempFile = Files.createTempFile(filename, suffix);
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path target = Paths.get(imgDir + "/" + filename + suffix);
        String path = target.toString();
        File isFile = new File(path);
        if (!isFile.exists()) {
            Files.move(tempFile, target);
        }
    }

    //TODO: Напишите программу, которая:
    //  получает с помощью библиотеки jsoup HTML-код страницы https://lenta.ru;
    //  находит в HTML-коде теги <img> и получает абсолютные ссылки на изображения
    //  из атрибутов src тегов <a>;
    //  скачивает изображения в папку images проекта, при этом сохраняя оригинальные названия файлов;
    //  выводит в консоль список с названиями скачанных файлов.
}

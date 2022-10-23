import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args){
        String url = "https://lenta.ru/";
        PageTest pageTest = new PageTest(url);
        new ForkJoinPool().invoke(new NewParser(pageTest));
    }
}



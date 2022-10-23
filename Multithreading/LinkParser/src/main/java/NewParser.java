import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NewParser extends RecursiveTask<List<PageTest>> {

    private PageTest page;
    private List<PageTest> stringList = new ArrayList<>();


    public NewParser(PageTest page) {
        this.page = page;
    }

    @Override
    protected List<PageTest> compute() {
        try {
            Document document = Jsoup.connect(page.getName()).timeout(100_000).get();
            Elements elements = document.select("body").select("a");
            for (Element e : elements) {
                String eString = e.absUrl("href");
                if (eString.contains(page.getName()) && !eString.equals(page.getName())) {
                    if (!stringList.contains(page)) {
                        System.out.println("Создаем страницу " + eString + " - " + Thread.activeCount());
                        stringList.add(new PageTest(eString));
                    } else {
                        System.out.println("Не добавляем: " + eString);
                        continue;
                    }
                }
            }
            page.setPageTestList(stringList);

            List<NewParser> tasks = new ArrayList<>();

            for(PageTest p : page.getPageTestList()){
                NewParser task = new NewParser(p);
                task.fork();
                tasks.add(task);
            }
            for(NewParser task : tasks){
                task.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return page.getPageTestList();
    }


    public void showLinks(PageTest test){
        for(PageTest p : test.getPageTestList()){
            if(p.getPageTestList().isEmpty()){
                System.out.println(p.getName());
            }else {
                showLinks(p);
            }
        }
    }
}

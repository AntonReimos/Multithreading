import java.util.List;
import java.util.Set;

public class PageTest {
    public PageTest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PageTest> getPageTestList() {
        return pageTestList;
    }

    public void setPageTestList(List<PageTest> pageTestList) {
        this.pageTestList = pageTestList;
    }

    private String name;
    private List<PageTest> pageTestList;

}

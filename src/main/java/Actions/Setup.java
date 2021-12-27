package Actions;

import Actions.Pages.DragAndDrop;
import Actions.Pages.HoverAndSelect;
import Actions.Pages.Sortable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Setup {
    WebDriver driver;

    DragAndDrop PgDragAndDrop;
    HoverAndSelect PgHoverAndSelect;
    Sortable PgSortable;

    @BeforeTest
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
    }

    @Test(priority = 1)
    public void drag() throws Exception{
        PgDragAndDrop = new DragAndDrop(driver);

        PgDragAndDrop.locateAndDrag();
    }

    @Test(priority = 3)
    public void hover() throws Exception{
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        PgHoverAndSelect = new HoverAndSelect(driver);

        PgHoverAndSelect.hoverOver();
    }

    @Test(priority = 2)
    public void sortThis() throws Exception{
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        PgSortable = new Sortable(driver);

        PgSortable.goToTestPage();
        PgSortable.sortIt();
    }

}

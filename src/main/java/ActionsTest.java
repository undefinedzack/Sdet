import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {

    WebDriver driver  = null;

//    static String dragWindowTilesXpath = "h5[class='ui-widget-header']";

    @BeforeTest
    void setup(){
        WebDriverInit driverInit = new WebDriverInit("https://www.globalsqa.com/demo-site/draganddrop/");
        driver = driverInit.getDriver();

    }

    @Test(priority = 1)
    void test1() throws Exception{
        //drag and drop
        Thread.sleep(5000);
        List <WebElement> source = driver.findElements(By.xpath("h5[class='ui-widget-header']"));
//        WebElement destination = driver.findElement(By.cssSelector("h4.ui-widget-header"));
        Actions action = new Actions(driver);
        for (WebElement win:source
             ) {
            action.dragAndDropBy(win,1000,0).build().perform();
        }

    }

    @Test(priority = 2)
    void test2(){
        //sortable
    }

    @Test(priority = 3)
    void test3(){
        //nav bar tooltip kinda thing
    }
}

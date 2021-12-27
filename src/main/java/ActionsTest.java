import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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
    void test1() throws Exception {
        //drag and drop
        
        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        List <WebElement> sources = driver.findElements(By.xpath("//h5[@class='ui-widget-header']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='trash']"));
        for (WebElement src:sources
             ) {
            action.dragAndDrop(src, destination).build().perform();
            Thread.sleep(1000);

        }

        Thread.sleep(2000);
        List <WebElement> dragged = driver.findElements(By.xpath("//div[@id='trash']//h5[@class='ui-widget-header']"));
        System.out.println(sources.size() + " - "+ dragged.size());
        Assert.assertEquals(sources.size(),dragged.size());

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

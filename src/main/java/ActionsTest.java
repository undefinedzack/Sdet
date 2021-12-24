import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {

    WebDriver driver;
    Actions action;


    @BeforeMethod
    public void sort(){
        WebDriverInit driverInit = new WebDriverInit("https://www.globalsqa.com/demo-site/draganddrop/");
        driver = driverInit.getDriver();
        action = new Actions(driver);
    }

    @Test(priority = 2)
    void test2(){
        //drag and drop
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement from = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='trash']"));
        action.dragAndDrop(from,to).perform();
        from = driver.findElement(By.xpath("//h5[text()='High Tatras 2']"));
        action.dragAndDrop(from,to).perform();
    }

    @Test(priority = 1)
    void test1(){
        //sortable
        //What to do when there is advt when opening new page
        //driver.findElement(By.xpath("//span[text()='Sortable']")).click();
        driver.navigate().to("https://www.globalsqa.com/demo-site/sorting/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement from = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]"));
        WebElement to = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]"));
        action.dragAndDrop(from,to).perform();


    }

    @Test(priority = 3)
    void test3(){
        //tooltip
        WebElement tst = driver.findElement(By.xpath("//a[text()='Free Ebooks' and @class='no_border']"));
        action.moveToElement(tst).build().perform();
        driver.findElement(By.xpath("//li[@id='menu-item-7132']")).click();
    }
}

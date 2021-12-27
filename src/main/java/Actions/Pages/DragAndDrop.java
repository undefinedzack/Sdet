package Actions.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DragAndDrop {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public DragAndDrop(WebDriver driver){
        this.driver = driver;
    }

    public void locateAndDrag() throws Exception{
        //locating
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement from = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='trash']"));

        //the drag
        Actions action = new Actions(driver);
        action.dragAndDrop(from, to).build().perform();

        Thread.sleep(5000);

        //checking a.k.a asserting
        String imgAfterDrag = "//img[@alt='The peaks of High Tatras']";
        String imgAlt = to.findElement(By.xpath(imgAfterDrag)).getAttribute("alt");

        softAssert.assertEquals(imgAlt, "The peaks of High Tatras");
        softAssert.assertAll();
        Assert.assertEquals(imgAlt, "The peaks of High Tatras");
//        driver.close();
    }
}

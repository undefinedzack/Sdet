package Actions.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverAndSelect {
    WebDriver driver;

    public HoverAndSelect(WebDriver driver){
        this.driver = driver;
    }

    public void hoverOver() throws Exception{
        //hovering over
        WebElement hoverTo = driver.findElement(By.xpath("//a[@class='no_border'][normalize-space()='Free Ebooks']"));

        Actions action = new Actions(driver);
        action.moveToElement(hoverTo);

        WebElement dest = driver.findElement(By.xpath("//span[normalize-space()='Free Machine Learning Ebooks']"));
        action.moveToElement(dest);

        action.click().build().perform();

        Thread.sleep(5000);
//        driver.close();


    }
}

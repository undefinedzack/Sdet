package Actions.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sortable {
    WebDriver driver;
    WebDriverWait wait;

    public Sortable(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goToTestPage(){
        driver.findElement(By.xpath("//span[normalize-space()='Sortable']")).click();
    }

    public void sortIt() throws Exception{
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//div[1]")));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement from =  driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]"));
        WebElement to = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]"));

        //the drag
        Actions action = new Actions(driver);
        action.dragAndDrop(from, to);

        action.build().perform();

        Thread.sleep(5000);
//        driver.close();

    }
}

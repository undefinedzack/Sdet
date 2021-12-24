import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    WebDriver driver = null;
    String url;

    WebDriverInit(String url){
        this.url = url;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    WebDriver getDriver(){
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}

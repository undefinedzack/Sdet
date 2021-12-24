import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver  = null;

    @BeforeTest
    void setup(){
        WebDriverInit driverInit = new WebDriverInit("https://www.google.com");
        driver = driverInit.getDriver();

    }

    @Test(priority = 1)
    void test1(){
        //drag and drop
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

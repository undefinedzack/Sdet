import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    WebDriver driver;

    @Test(enabled = false)
    void test1(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(true, false);

        softAssert.assertEquals(true, true);
        softAssert.assertEquals(true, false);
        softAssert.assertEquals(true, false);
        softAssert.assertEquals(false, false);

        softAssert.assertAll();
    }

    @Test
    void hardAssertion(){
        Assert.assertEquals(true, false);

        Assert.assertEquals(true, true);

    }


}

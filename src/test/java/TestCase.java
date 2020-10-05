import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {
    private WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        // 1. 取得一個WebDriver的Instance

        // Chrome Web Driver For Mac (須將Driver放置此處)
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        // Firefox web driver
        // System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
        // driver = new FirefoxDriver();
    }

    @Test
    public void testSunnet(){
        String baseUrl = "https://rdel-ctms-vs.elearn.com.tw/cltcms_o/unlogin-action.do?go=https%3A%2F%2Frdel-ctms-vs.elearn.com.tw%2Fcltcms_o%2Fsitemap-page.do%3Fnid%3D4088";
        String account = "adm";
        String password = "1111";
        WebElement element;
        driver.get(baseUrl);

        element = driver.findElement(By.id("account"));
        element.click();
        element.sendKeys(account);

        element = driver.findElement(By.id("password"));
        element.click();
        element.sendKeys(password);

        element = driver.findElement(By.id("submit_button"));
        element.click();

        driver.switchTo().frame("topFrame");
//
//
//
//        element = driver.findElement(By.linkText("選擇"));
//        element.click();


    }


//    @AfterClass
//    public void afterTest() {
//        // close webdriver
//        // driver.close();	// 只關閉目前焦點視窗
//        driver.quit();      // 關閉所有已開啟的視窗
//    }
}

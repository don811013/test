import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        // Chrome Web Driver For Mac (須將Driver放置此處)
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // Chrome Web Driver For Windows (須將Driver放置此處)
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        String parentWindow = driver.getWindowHandle();

        driver.get("https://rdel-ctms-vs.elearn.com.tw/cltcms_o/");
        driver.findElement(By.id("account")).click();
        driver.findElement(By.id("account")).clear();
        driver.findElement(By.id("account")).sendKeys("adm");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.id("submit_button")).click();
        Thread.sleep(3000);

        driver.switchTo().frame("topFrame");
        driver.findElement(By.name("menu_function_CourseManagement")).click();

        Thread.sleep(1000);
        driver.switchTo().frame("rightContentFrame");
        driver.findElement(By.xpath("//td/table/tbody/tr/td")).click();
        driver.findElement(By.xpath("//a[@id='otherActions']/span/span/span")).click();
        driver.findElement(By.xpath("//div[@id='adjusting_menu']/div/div")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for(String curWindow : allWindows){
            driver.switchTo().window(curWindow);
        }

        driver.findElement(By.xpath("//tr[3]/td")).click();
        driver.findElement(By.name("courseName")).click();
        driver.findElement(By.name("courseName")).clear();
        driver.findElement(By.name("courseName")).sendKeys("Test_20201004");
        driver.findElement(By.id("finish_button")).click();
        driver.switchTo().window(parentWindow);
        Thread.sleep(1000);
        driver.switchTo().frame(7);
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//*/button[text()='選擇']")).click();

        Set<String> allWindows2 = driver.getWindowHandles();
        for(String curWindow : allWindows2){
            driver.switchTo().window(curWindow);
        }
        driver.findElement(By.xpath("//*[@id='tree']/ul/li/ul/li[1]/a/input[1]")).click();
        driver.findElement(By.name("ok")).click();

        driver.switchTo().window(parentWindow);

        driver.switchTo().frame(7);
        driver.switchTo().frame(1);
        driver.findElement(By.name("creditCategory")).click();
        new Select(driver.findElement(By.name("creditCategory"))).selectByVisibleText("aa");
//        driver.findElement(By.name("creditCategory")).click();


        driver.findElement(By.name("btn_apply")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(3);
        driver.findElement(By.partialLinkText("課程內容")).click();

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("rightContentFrame");
        driver.switchTo().frame("itemInfoDown");
//        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*/button[text()='新增課程內容']")).click();

        Set<String> allWindows3 = driver.getWindowHandles();
        for(String curWindow : allWindows3){
            driver.switchTo().window(curWindow);
        }

        driver.findElement(By.id("add_button")).click();
        driver.findElement(By.id("uploadTitle")).click();
        driver.findElement(By.id("uploadTitle")).sendKeys("JPG");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[@name=File_Document]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("File_Document")).sendKeys("C:\\fakepath\\簡報1.jpg");
        Thread.sleep(2000);
        driver.findElement(By.name("continue_button")).click();
        driver.findElement(By.id("next_button")).click();
        //tbody/tr[2]/td[2]/input/[@name=File_Document]


    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }



}
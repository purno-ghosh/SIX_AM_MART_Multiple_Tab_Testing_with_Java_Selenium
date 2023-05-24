import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class TEST_CLASS {
    private static String getParentTabHandle(WebDriver driver) {
        return driver.getWindowHandles().iterator().next();
    }

    WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        //Disable all the push notifications from chrome browser
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void getTitle() throws InterruptedException {

        driver.get("https://6ammart.sixamtech.com/dev/admin");
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'login')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-secondary'][contains(.,'End tour')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
        Thread.sleep(2000);

        //User Overview Page Verify

        String UserOverview = driver.findElement(By.xpath("//h1[@class='page-header-title mb-0'][contains(.,'User Overview')]")).getText();
        System.out.println("TEST 01 DONE " + UserOverview);

        //Vehicles category Page Verify

        WebElement Vehicles_cat = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Vehicles category')]"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(Vehicles_cat).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Vehicle_Title = driver.findElement(By.xpath("//h1[@class='page-header-title'][contains(.,'Vehicles category list 2')]")).getText();
        System.out.println("TEST 02 DONE " + Vehicle_Title);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(5000);

        //Add Delivery Man Page Verify

        WebElement Add_Delivery = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Add Delivery Man')]"));
        Actions actions1 = new Actions(driver);
        actions1.keyDown(Keys.CONTROL).click(Add_Delivery).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Add_Delivery_Man = driver.findElement(By.xpath("//span[contains(.,'Add New Delivery Man')]")).getText();
        System.out.println("TEST 03 DONE " + Add_Delivery_Man);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(5000);

        // New Delivery Man Page Verify

        WebElement New_Delivery = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'New delivery man')]"));
        Actions actions2 = new Actions(driver);
        actions1.keyDown(Keys.CONTROL).click(New_Delivery).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String New_Delivery_Man = driver.findElement(By.xpath("//h1[@class='page-header-title'][contains(.,'New joining requests')]")).getText();
        System.out.println("TEST 04 DONE " + New_Delivery_Man);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(5000);

        //Delivery Man List Page Verify

        WebElement Delivery_Man = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Deliveryman List')]"));
        Actions actions3 = new Actions(driver);
        actions1.keyDown(Keys.CONTROL).click(Delivery_Man).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Delivery_Man_lIst = driver.findElement(By.xpath("(//span[contains(.,'Delivery Man')])[2]")).getText();
        System.out.println("TEST 05 DONE " + Delivery_Man_lIst);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(5000);


        // Reviews Page Verify

        WebElement Reviews = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Reviews')]"));
        Actions actions4 = new Actions(driver);
        actions1.keyDown(Keys.CONTROL).click(Reviews).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Reviews_page = driver.findElement(By.xpath("//span[contains(.,'Delivery Man Reviews1')]")).getText();
        System.out.println("TEST 06 DONE " + Reviews_page);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(5000);

    }

    private static String getNewTabHandle(WebDriver driver) {
        String parentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                return handle;
            }
        }
        return parentHandle;
    }
//    @After
//    public void finishTest(){
//        driver.close();

}




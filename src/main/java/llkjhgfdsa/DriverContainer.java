package llkjhgfdsa;

import llkjhgfdsa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverContainer {
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);
    private static final Duration EXTRA_LAG = Duration.ofSeconds(0);

    private static WebDriver driver;
   // private static WebDriverWait wait;

    private static ChromeDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        ChromiumNetworkConditions conditions = new ChromiumNetworkConditions();
        conditions.setLatency(EXTRA_LAG);
        driver.setNetworkConditions(conditions);
        return driver;
    }

    private static WebDriver getInstance() {
        if (driver == null) {
            driver = createChromeDriver();
        }
        return driver;
    }

//    private static WebDriverWait getWait() {
//        if (wait == null) {
//            wait = new WebDriverWait(getInstance(), IMPLICIT_WAIT);
//        }
//        return wait;
//    }

    public static void quitInstance() {
        if (driver == null) return;
        driver.quit();
        driver = null;
    }

//    public static void waitForUrl(String url) {
//        wait = getWait();
//        wait.until(ExpectedConditions.urlToBe(url));
//    }

    public static void waitForUrl(String url) {
        long timeoutMilliseconds = IMPLICIT_WAIT.toMillis();
        long startTime = System.currentTimeMillis();
        boolean urlChanged = false;
        while (System.currentTimeMillis() - startTime < timeoutMilliseconds) {
            String currentUrl = getInstance().getCurrentUrl();
            if (currentUrl.equals(url)) {
                urlChanged = true;
                break;
            }
        }
        if (urlChanged) {
            System.out.println("URL is correct: " + url);
        } else {
            System.out.println("URL is incorrect: " + getInstance().getCurrentUrl() + " Expected: " + url);
        }
    }

    public static void get(String url) {
        getInstance().get(url);
    }

    public static String getCurrentUrl() {
        return getInstance().getCurrentUrl();
    }

    public static LoginPage createLoginPage() {
        return new LoginPage(getInstance());
    }
    public static boolean isAlertPresent() {
        try{
            WebElement alertPopup = getInstance().findElement(By.xpath("//*[@role='alert']"));
            String alertText = alertPopup.getText();
            System.out.println("Alert found: "+alertText);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

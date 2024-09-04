package llkjhgfdsa;

import llkjhgfdsa.pages.MainPage;
import llkjhgfdsa.pages.PageTemplate;
import llkjhgfdsa.pages.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StateContainer {
    private static final Duration WAIT_DURATION = Duration.ofSeconds(5);
    private static final Duration EXTRA_LAG = Duration.ofSeconds(0);

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static MainPage mainPage;
    private static SignupPage signupPage;

    private static ChromeDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_DURATION);
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

    private static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getInstance(), WAIT_DURATION);
        }
        return wait;
    }

    public static void quitInstance() {
        if (driver == null) return;
        driver.quit();
        driver = null;
        wait = null;
        mainPage = null;
        signupPage = null;
    }

    public static void waitForUrl(String url) {
        wait = getWait();
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void get(String url) {
        getInstance().get(url);
    }

    public static String getCurrentUrl() {
        return getInstance().getCurrentUrl();
    }

    public static MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(getInstance());
        }
        return mainPage;
    }

    public static SignupPage getSignupPage() {
        if (signupPage == null) {
            signupPage = new SignupPage(getInstance());
        }
        return signupPage;
    }
}

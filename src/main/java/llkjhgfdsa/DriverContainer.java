package llkjhgfdsa;

import llkjhgfdsa.pages.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;

import java.time.Duration;

public class DriverContainer {
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);
    private static final Duration EXTRA_LAG = Duration.ofSeconds(0);

    private static WebDriver driver;

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

    public static void quitInstance() {
        if (driver == null) return;
        driver.quit();
        driver = null;
    }

    public static void get(String url) {
        getInstance().get(url);
    }

    public static String getCurrentUrl() {
        return getInstance().getCurrentUrl();
    }

    public static SignupPage createLoginPage() {
        return new SignupPage(getInstance());
    }
}

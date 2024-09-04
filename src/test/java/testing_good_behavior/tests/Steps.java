package testing_good_behavior.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing_good_behavior.DriverProvider;

import java.time.Duration;

public class Steps {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public Steps() {
        driver = DriverProvider.createChromeDriver();
        wait = new WebDriverWait(driver, driver.manage().timeouts().getImplicitWaitTimeout());
        actions = new Actions(driver);
    }
}

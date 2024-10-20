package stringsAutomatedTests;

import stringsAutomatedTests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private static LoginPage loginPage;
    private static AdminPage adminPage;

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

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createChromeDriver();
        }
        return driver;
    }

    private static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), WAIT_DURATION);
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
        loginPage = null;
        adminPage = null;
    }

    public static void waitForUrl(String url) {
        wait = getWait();
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlToBe(url),
            ExpectedConditions.urlToBe(url+"/")
        ));
    }

    public static void get(String url) {
        getDriver().get(url);
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage(getDriver(), getWait());
        }
        return mainPage;
    }
    public static PostCreationPage getPostCreationPage(){
        return new PostCreationPage(getDriver(), getWait());
    }

    public static SignupPage getSignupPage() {
        if (signupPage == null) {
            signupPage = new SignupPage(getDriver(), getWait());
        }
        return signupPage;
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(getDriver(), getWait());
        }
        return loginPage;
    }

    public static AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage(getDriver(), getWait());
        }
        return adminPage;
    }

    public static boolean isAlertPresent() {
        try{
            WebElement alertPopup = getDriver().findElement(By.xpath("//*[@role='alert']"));
            String alertText = alertPopup.getText();
            System.out.println("Alert found: "+alertText);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void refreshPage() {
        if (driver == null) throw new RuntimeException("Driver not initialized");
        driver.navigate().refresh();
    }
}

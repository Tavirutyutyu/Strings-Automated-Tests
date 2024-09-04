package testing_good_behavior.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTemplate {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public PageTemplate(String url, WebDriver driver, WebDriverWait wait, Actions actions) {
        wait.until(ExpectedConditions.urlContains(url));
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }
}
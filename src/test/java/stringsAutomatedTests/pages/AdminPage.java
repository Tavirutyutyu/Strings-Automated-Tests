package stringsAutomatedTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage extends PageTemplate{
    @FindBy(xpath = "//*[text()='Posts']")
    private WebElement postsLink;
    @FindBy(xpath = "//button[@class='delete-button']")
    private List<WebElement> deleteButtons;
    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void deleteAllPosts(){
        postsLink.click();
        deleteButtons.forEach(WebElement::click);
    }
}

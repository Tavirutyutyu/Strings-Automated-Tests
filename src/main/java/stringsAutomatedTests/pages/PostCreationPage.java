package stringsAutomatedTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostCreationPage extends PageTemplate{
    @FindBy(id = "description")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[text()='Create Post']")
    private WebElement createPostButton;

    public PostCreationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void makePost(String description) {
        descriptionField.sendKeys(description);
        createPostButton.click();
    }
}

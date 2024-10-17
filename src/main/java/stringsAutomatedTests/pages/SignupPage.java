package stringsAutomatedTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends PageTemplate {

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "formBtn")
    private WebElement submit;

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void signUp(String firstName, String lastName, String email, String username, String password) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();
    }



}

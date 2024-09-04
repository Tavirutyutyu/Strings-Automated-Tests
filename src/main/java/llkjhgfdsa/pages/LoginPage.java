package llkjhgfdsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageTemplate{
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(), 'Sign up now')]")
    private WebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignUp(){
        signUpBtn.click();
    }
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}

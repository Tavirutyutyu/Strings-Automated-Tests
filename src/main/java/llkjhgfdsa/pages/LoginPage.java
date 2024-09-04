package llkjhgfdsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageTemplate{
    @FindBy(xpath = "//a[contains(text(), 'Sign up now')]")
    WebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignUp(){
        signUpBtn.click();
    }
}

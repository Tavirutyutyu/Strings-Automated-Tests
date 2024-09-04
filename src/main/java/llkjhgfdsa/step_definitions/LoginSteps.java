package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @AfterAll
    public static void tearDown() {
        DriverContainer.quitInstance();
    }
}

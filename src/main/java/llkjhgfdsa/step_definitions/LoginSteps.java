package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("The user enters valid credentials")
    public void enterValidCredentials() {
        DriverContainer.createLoginPage().login("asd", "12345");
    }

    @When("The user enters invalid credentials")
    public void enterInvalidCredentials() {
        DriverContainer.createLoginPage().login("invalidUsername", "invalidPassword");
    }
    @Then("The page stays on login page")
    public void pageStaysOnLoginPage() {
        Assert.assertTrue("An alert should pop up when user tries to log in with invalid credentials.", DriverContainer.isAlertPresent());
    }

    @Then("The page navigates to the main page")
    public void navigatesToMainPage() {
        String expected = URL.ROOT;
        DriverContainer.waitForUrl(expected);
        String actual = DriverContainer.getCurrentUrl();
        Assert.assertEquals(expected, actual);
    }

    @AfterAll
    public static void tearDown() {
        DriverContainer.quitInstance();
    }
}

package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;
import llkjhgfdsa.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("The user enters valid credentials")
    public void enterValidCredentials() {
        DriverContainer.createLoginPage().login("asd", "12345");
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

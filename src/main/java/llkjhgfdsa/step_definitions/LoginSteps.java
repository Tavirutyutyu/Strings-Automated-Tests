package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.StateContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        StateContainer.getLoginPage().goToSignUp();
    }

    @When("The user enters valid credentials")
    public void enterValidCredentials() {
        StateContainer.getLoginPage().login("asd", "password");
    }

    @When("The user enters invalid credentials")
    public void enterInvalidCredentials() {
        StateContainer.getLoginPage().login("invalidUsername", "invalidPassword");
    }

    @When("The user leaves username or password field empty")
    public void leaveUsernameOrPasswordFieldEmpty() {
        StateContainer.getLoginPage().login("", "");
    }

    @Then("The site puts cursor in first empty input field")
    public void cursorInFirstEmptyInputField() {
        String message = "When the user leaves empty an input field and try to submit, the site throw the cursor into the first empty input field.";
        Assert.assertTrue(message, StateContainer.getLoginPage().isFieldInFocus("username"));
    }

    @Then("The page shows a popup")
    public void pageShowsPopup() {
        Assert.assertTrue("An alert should pop up when user tries to log in with invalid credentials.", StateContainer.isAlertPresent());
    }

    @Then("The page navigates to the main page")
    public void navigatesToMainPage() {
        String expected = URL.MAIN.getUrl();
        StateContainer.waitForUrl(expected);
        String actual = StateContainer.getCurrentUrl();
        Assert.assertEquals(expected, actual);
    }
}

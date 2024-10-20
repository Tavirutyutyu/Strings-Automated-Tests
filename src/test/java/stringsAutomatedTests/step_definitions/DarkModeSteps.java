package stringsAutomatedTests.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stringsAutomatedTests.StateContainer;
import org.junit.Assert;

public class DarkModeSteps {
    @Given("We are in dark mode")
    public void inDarkMode() {
        StateContainer.getMainPage().setDarkMode();
    }
    @Given("We are in light mode")
    public void inLightMode() {
        StateContainer.getMainPage().setLightMode();
    }

    @When("We click dark mode button")
    public void clickDarkMode() {
        StateContainer.getMainPage().clickDarkModeButton();
    }

    @Then("Page changes to dark mode")
    public void verifyDarkMode() {
        Assert.assertTrue(StateContainer.getMainPage().isDark());
    }

    @Then("Page changes to light mode")
    public void verifyLightMode() {
        Assert.assertFalse(StateContainer.getMainPage().isDark());
    }
}

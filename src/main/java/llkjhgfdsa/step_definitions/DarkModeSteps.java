package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import llkjhgfdsa.StateContainer;
import llkjhgfdsa.pages.DarkModePage;

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
}

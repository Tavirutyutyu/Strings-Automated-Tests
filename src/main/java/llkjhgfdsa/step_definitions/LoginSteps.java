package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;

public class LoginSteps {
    @When("We click signup button")
    public void clickSignupButton() {
        DriverContainer.get(URL.SIGNUP);
    }

    @AfterAll
    public static void tearDown() {
        DriverContainer.quitInstance();
    }
}

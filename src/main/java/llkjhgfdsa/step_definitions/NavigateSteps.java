package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.sk.A;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class NavigateSteps {
    @Given("We are on the login page")
    public void we_are_on_the_login_page() {
        DriverContainer.get(URL.LOGIN);
    }

    @Then("Page changes to signup page")
    public void page_changes_to_signup_page() {
        Assert.assertEquals(URL.SIGNUP, DriverContainer.getCurrentUrl());
    }

    @AfterAll
    public static void tearDown() {
        DriverContainer.quitInstance();
    }
}

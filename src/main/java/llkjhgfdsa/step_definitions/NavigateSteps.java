package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import llkjhgfdsa.StateContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class NavigateSteps {
    @Given("We are on the {string} page")
    public void weAreOnPage(String page) {
        String url = URL.getUrlByName(page);
        StateContainer.get(url);
    }

    @Then("Page changes to {string} page")
    public void pageChangesTo(String page) {
        Assert.assertEquals(URL.getUrlByName(page), StateContainer.getCurrentUrl());
    }
}

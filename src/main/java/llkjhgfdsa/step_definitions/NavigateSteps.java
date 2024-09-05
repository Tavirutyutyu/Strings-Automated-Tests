package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import llkjhgfdsa.StateContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class NavigateSteps {
    @Given("We are on the {word} page")
    public void weAreOnPage(String page) {
        String url = URL.getUrlByName(page);
        StateContainer.get(url);
    }

    @Then("Page changes to {word} page")
    public void pageChangesTo(String page) {
        String expectedUrl = URL.getUrlByName(page);
        StateContainer.waitForUrl(expectedUrl);
        String actualUrl = StateContainer.getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl) || actualUrl.equals(expectedUrl + "/"));
    }
}

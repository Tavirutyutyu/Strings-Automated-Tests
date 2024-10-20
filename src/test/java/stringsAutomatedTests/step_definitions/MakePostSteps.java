package stringsAutomatedTests.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stringsAutomatedTests.StateContainer;
import stringsAutomatedTests.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MakePostSteps {
    @When("The user makes a post with text {string}")
    public void the_user_makes_a_post_with_text(String text) {
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostCreationPage().makePost(text);
    }

    @Then("The post {string} appears on the feed")
    public void thePostAppearsOnTheFeed(String text) {
        assertTrue(StateContainer.getMainPage().isPostInFeed(text));
    }

    @Then("The site stays on post creation page")
    public void theSiteStaysOnPostCreationPage() {
        String url = StateContainer.getCurrentUrl();
        assertEquals(URL.CREATE.getUrl(), url);
    }

    @After("@DeletePost")
    public void tearDown() {
        StateContainer.getMainPage().reportAllPosts();
        StateContainer.get(String.valueOf(URL.ADMIN.getUrl()));
        StateContainer.getAdminPage().deleteAllPosts();
    }
}

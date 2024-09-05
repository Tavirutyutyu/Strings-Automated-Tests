package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.StateContainer;
import org.junit.Assert;

public class LikePostSteps {
    @Given("A post {string} is made")
    public void a_post_has_been_made(String post) {
        StateContainer.getMainPage().clickCreatePostButton();
        StateContainer.getPostCreationPage().makePost(post);
    }
    @When("The user likes an unliked post {string}")
    public void the_user_likes_an_unliked_post(String post) {
        StateContainer.getMainPage().likePost(post);
    }
    @Then("The hearth icon becomes red at post {string}")
    public void the_hearth_icon_becomes_red(String post) {
        Assert.assertTrue(StateContainer.getMainPage().isPostLiked(post));
    }
}

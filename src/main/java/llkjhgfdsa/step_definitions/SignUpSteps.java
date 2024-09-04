package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class SignUpSteps {

    @Given("User on the signup page")
    public void user_on_the_signup_page() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("the user enters valid values to fields")
    public void the_user_enters_valid_values_to_fields() {
        DriverContainer.createSignupPage().signUp(
                "John",
                "Doe",
                "john.doe@gmail.com",
                "johnDoe",
                "1234"
        );

    }

    @Then("user sees login page")
    public void user_sees_login_page() {
        DriverContainer.waitForUrl(URL.LOGIN);
        Assert.assertEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }


    @Given("email field filled without hashtag")
    public void email_field_filled_without_hashtag() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("User enters email address without hashtag")
    public void user_enters_email_address_without_hashtag() {
        DriverContainer.waitForUrl(URL.SIGNUP);
        DriverContainer.createSignupPage().signUp(
                "John",
                "Doe",
                "john.doegmail.com",
                "johnDoe",
                "1234"
        );
    }

    @Then("User can not see login page")
    public void user_can_not_see_login_page() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }

    @Given("email field filled without dot")
    public void email_field_filled_without_dot() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("User enters email address without dot")
    public void user_enters_email_address_without_dot() {
        DriverContainer.waitForUrl(URL.SIGNUP);
        DriverContainer.createSignupPage().signUp(
                "John",
                "Doe",
                "johndoe@gmailcom",
                "johnDoe",
                "1234"
        );
    }

    @Then("User can not reach login page")
    public void user_can_not_reach_login_page() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }

    @Given("user is on the sign up page no fields filled")
    public void user_is_on_the_sign_up_page_no_fields_filled() {
        DriverContainer.createLoginPage().goToSignUp();
    }

    @When("user presses signup button")
    public void user_presses_signup_button() {
        DriverContainer.waitForUrl(URL.SIGNUP);
        DriverContainer.createSignupPage().signUp(
                "",
                "",
                "",
                "",
                ""
        );
    }

    @Then("user not forwarded to login page")
    public void user_not_forwarded_to_login_page() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }

}

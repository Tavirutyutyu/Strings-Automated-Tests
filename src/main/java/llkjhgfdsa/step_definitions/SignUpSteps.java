package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import llkjhgfdsa.DriverContainer;
import llkjhgfdsa.URL;
import org.junit.Assert;

public class SignUpSteps {

    String lastName = "";
    String email = "";
    String username = "";

    @Given("User on the signup page")
    public void user_on_the_signup_page() {
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("the user enters valid values to fields")
    public void the_user_enters_valid_values_to_fields() {
        lastName = "Doe" + System.currentTimeMillis();
        email = "email"+ "@" + System.currentTimeMillis();
        username = "username" + System.currentTimeMillis();
        DriverContainer.createSignupPage().signUp(
                "Jane",
                lastName,
                email,
                username,
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
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("User enters email address without hashtag")
    public void user_enters_email_address_without_hashtag() {
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
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("User enters email address without dot")
    public void user_enters_email_address_without_dot() {
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
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("user presses signup button")
    public void user_presses_signup_button() {
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


    @Given("user gets to signup page")
    public void user_gets_to_signup_page() {
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("user signs up with same credentials")
    public void user_signs_up_with_same_credentials() {
        DriverContainer.createSignupPage().signUp(
                "Jane",
                lastName,
                "jane.doe@gmail.com",
                "janeDoe",
                "1234"
        );
    }

    @Then("user will not see login page")
    public void user_will_not_see_login_page() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }


    @Given("user is at signup page")
    public void user_is_at_signup_page() {
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("user types already used email")
    public void user_types_already_used_email() {
        email = "email" + System.currentTimeMillis();
        DriverContainer.createSignupPage().signUp(
                "Jane",
                lastName,
                email,
                "janeDoe",
                "1234"
        );
    }

    @Then("login page not shown")
    public void login_page_not_shown() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }

    @Given("signup page renders")
    public void signup_page_renders() {
        DriverContainer.get(URL.SIGNUP);
        DriverContainer.waitForUrl(URL.SIGNUP);
    }

    @When("user types already used username")
    public void user_types_already_used_username() {
        username = "janeDoe" + System.currentTimeMillis();
        email += "!";
        DriverContainer.createSignupPage().signUp(
                "Jane",
                lastName,
                "jane.doe@gmail.com",
                username,
                "1234"
        );
    }

    @Then("login page not rendered")
    public void login_page_not_rendered() {
        Assert.assertNotEquals(URL.LOGIN, DriverContainer.getCurrentUrl());
    }




}

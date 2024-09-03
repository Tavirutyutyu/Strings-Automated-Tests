package llkjhgfdsa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import llkjhgfdsa.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefinition {

    private final WebDriver driver;


    public StepDefinition() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);

    }


    @Given("We are on the login page")
    public void we_are_on_the_login_page() {
        driver.get("http://localhost:5173/login");
    }

    @When("We click signup button")
    public void we_click_signup_button() {
        BasePage basePage = new BasePage(driver);
        basePage.goToSignUp();
    }

    @Then("Page changes to signup page")
    public void page_changes_to_signup_page() {
        Assert.assertEquals("http://localhost:5173/signup", driver.getCurrentUrl());
    }

}

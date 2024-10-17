package stringsAutomatedTests.step_definitions;

import io.cucumber.java.en.Given;
import stringsAutomatedTests.StateContainer;
import stringsAutomatedTests.URL;

public class CredentialSteps {
    @Given("We are logged in with {string} : {string} credentials")
    public void loginAs(String username, String password) {
        StateContainer.get(URL.LOGIN.getUrl());
        StateContainer.getLoginPage().login(username, password);
        StateContainer.waitForUrl(URL.MAIN.getUrl()+"/");
    }
}

package stringsAutomatedTests.step_definitions;

import io.cucumber.java.AfterAll;
import stringsAutomatedTests.StateContainer;

public class TeardownStep {

    @AfterAll
    public static void tearDown() {
        System.out.println("teardown");
        StateContainer.quitInstance();
    }
}

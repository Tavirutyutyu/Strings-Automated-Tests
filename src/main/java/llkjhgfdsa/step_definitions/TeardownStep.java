package llkjhgfdsa.step_definitions;

import io.cucumber.java.AfterAll;
import llkjhgfdsa.StateContainer;

public class TeardownStep {

    @AfterAll
    public static void tearDown() {
        System.out.println("teardown");
        StateContainer.quitInstance();
    }
}

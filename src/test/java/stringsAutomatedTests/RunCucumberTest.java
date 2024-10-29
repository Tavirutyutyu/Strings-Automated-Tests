package stringsAutomatedTests;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features") // Points to the feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stringsAutomatedTests.step_definitions") // Points to step definitions
public class RunCucumberTest {
}

package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty","json:target/cucumber-json/cucumber.json",
			"junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports/Cucumber.html"},
		monochrome = false,
		features = "src/test/resources/functionalTests",
        glue = {"/stepDefinitions"}
		)
public class TestRunner {

}

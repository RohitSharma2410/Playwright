package runnerClasses;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "/Users/rohitsharma/eclipse-workspace/user/specs" }, glue = { "Hooks" }, plugin = {
		"html:target/CompleteAutomationReport" + ".html", "json:target/webjsonreport.json" }, tags = "@Api or @Web")
public class RunnerClass extends AbstractTestNGCucumberTests {
	public static int totalThreads = -1;

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:/Users/febin/eclipse-workspace/CrmBDDFramework/src/test/resource/Features",
		glue= {"StepDefinitions"},
		monochrome = true,
		tags="@smoke",
		plugin={"pretty","html:target/HtmlReports.html","json:target/JSONReports/report.json","junit:target/JUnitReports/report.xml"},
		dryRun=false
		
		)


public class TestRunner {

}

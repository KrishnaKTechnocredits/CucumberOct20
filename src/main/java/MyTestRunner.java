import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featureFiles/", 
		glue = "steps", 
		tags = "@Demo11", 
		dryRun = false, 
		monochrome = true, 
		strict = true,
		plugin = {"pretty", "html:report\\cucumber.html", "json:report/cucumber.json",
		"junit:report/cucumber.xml"} )
public class MyTestRunner {

}

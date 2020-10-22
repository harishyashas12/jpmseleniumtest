package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utility.WebDriverUtils;

@RunWith(Cucumber.class)

@CucumberOptions(
		         plugin = {"html:target/html-report" }, 
                 features = "src/test/resources/features/ValJPMorganlogo.feature", 
                 glue = {"stepdefinitions" },
                 monochrome = true,
                 dryRun = false, 
                 tags = {"@searchandvalidatelogo","@regression"}
		         )

public class RunnerTest extends WebDriverUtils {
 
	@AfterClass
 	public static void close() {
		driver.quit();
	}
}

package cucumber.examples.java.testNG.runners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/feature/MozillaFirefox.feature",
        glue = {"cucumber.examples.java.testNG.stepDefinitions"},
        format = {"pretty",
                "html:target/cucumber-report/firefox",
                "json:target/cucumber-report/firefox/cucumber.json",
                "junit:target/cucumber-report/firefox/cucumber.xml"}
        //dryRun = true
)

public class FirefoxBrowserRunner extends AbstractTestNGCucumberTests{}
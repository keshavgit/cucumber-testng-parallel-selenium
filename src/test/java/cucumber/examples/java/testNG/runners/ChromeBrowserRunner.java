package cucumber.examples.java.testNG.runners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/feature/GoogleChrome.feature",
        glue = {"cucumber.examples.java.testNG.stepDefinitions"},
        format = {"pretty",
                "html:target/cucumber-report/chrome",
                "json:target/cucumber-report/chrome/cucumber.json",
                "junit:target/cucumber-report/chrome/cucumber.xml"}
        //dryRun = true
)

public class ChromeBrowserRunner extends AbstractTestNGCucumberTests{}

package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "14-FrameWork/src/test/java/cucumber"
        , glue = "rahulshettyacademy.stepDefinition"
        , monochrome = true
        , plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}

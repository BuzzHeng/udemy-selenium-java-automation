package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "14-FrameWork/src/test/resources/cucumber" // refers to resources/cucumber/
        , glue = "rahulshettyacademy.stepDefinition"
        , monochrome = true
        , plugin = {"html:target/cucumber.html"}
        , tags = "@Regression")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    static {
        System.out.println(">>> TestNGTestRunner loaded <<<");
    }
}

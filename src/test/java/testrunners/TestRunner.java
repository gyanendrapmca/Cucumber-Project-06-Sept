package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/functionalTests/E2ETests.feature",
		glue="stepdefinitions"
	)
public class TestRunner {

}
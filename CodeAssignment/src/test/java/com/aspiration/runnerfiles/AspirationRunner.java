package com.aspiration.runnerfiles;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// path of feature file
		features = "src/test/java/Features/AspirationUI.feature",
		// path of step definition file
		glue = "stepDefinitions",
		//report format
		plugin = {"pretty","html:reports/test-report"},
		//to verify the step definitions are created for each step
		// dryRun=true,
		//print the console with clear info
		monochrome = true
		)
public class AspirationRunner {

}

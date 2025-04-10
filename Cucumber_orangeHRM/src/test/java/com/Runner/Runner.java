package com.Runner;


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    plugin = {
	        "pretty",
	        "json:target/cucumber-reports/Cucumber.json",
	        
	    },
	    features = {
	        "src/test/resources/com/features/Login.feature",
	        "src/test/resources/com/features/TimePunchoutDashboard.feature",
	    },
	    glue = "com.Definations",
	    monochrome = false,
	    dryRun = false
	)
	public class Runner extends AbstractTestNGCucumberTests {
	}


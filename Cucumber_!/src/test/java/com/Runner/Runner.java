package com.Runner;


	import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    plugin = {
	        "pretty",
	        "json:target/cucumber-reports/Cucumber.json",
	        
	    },
	    features = {
	       "src/test/resources/com/features/A_Login.feature",
	       "src/test/resources/com/features/PIM.feature",
	       "src/test/resources/com/features/TimePunchoutDashboard.feature",
	       "src/test/resources/com/features/Configuration.feature",
	       "src/test/resources/com/features/Q_UserManagement.feature",
	       "src/test/resources/com/features/Performance.feature",
	       "src/test/resources/com/features/Performance2.feature",
	       "src/test/resources/com/features/Buzz.feature",
	       //"src/test/resources/com/features/U_Configure.feature",
	       "src/test/resources/com/features/Admin.feature",
	    },
	    glue = "com.Definations",
	    monochrome = false,
	    dryRun = false
	)
	public class Runner extends AbstractTestNGCucumberTests {
		@Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	}

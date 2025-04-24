package com.Runner;


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    plugin = {
	        "pretty",
	        "json:target/cucumber-reports/Cucumber.json",
	        "html:target/cucumber-reports/Cucumber.html",
//	        "",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        
	    },
	    features = {
	       "src/test/resources/com/features/01_Karan_08APR2025_OrangeHRM_Login.feature",
	       "src/test/resources/com/features/02_Dharani_10APR2025_OrangeHRM_PIM.feature",
	       "src/test/resources/com/features/03_Karan_08APR2025_OrangeHRM_Dashboard.feature",
	       "src/test/resources/com/features/04_Dharani_13APR2025_OrangeHRM_Configuration.feature",
	       "src/test/resources/com/features/05_Dharani_12APR2025_OrangeHRM_Q_UserManagement.feature",
	       "src/test/resources/com/features/06_Thoushika_13APR2025_OrangeHRM_Performance.feature",
	       "src/test/resources/com/features/07_Thoushika_14APR2025_OrangeHRM_Performance2.feature",
	       "src/test/resources/com/features/08_Thoushika_15APR2025_OrangeHRM_Buzz.feature",
	       "src/test/resources/com/features/09_Thoushika_12APR2025_OrangeHRM_Admin.feature",
	       "src/test/resources/com/features/10_Chandru_11APR2025_OrangeHRM_TimePage.feature",
	       "src/test/resources/com/features/11_Chandru_11APR2025_OrangeHRM_Claim.feature"
	    },
	    glue = "com.Definations",
	    monochrome = false,
	    dryRun = false
	)
	public class Runner extends AbstractTestNGCucumberTests {
	}

  package TestRunner;
  import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests; 
  import io.cucumber.testng.CucumberOptions;
import reports.GenerateCucumberReport;

  
  @CucumberOptions
  (tags="", features= {"src/test/resources/Features"}, glue=
  {"StepDefinitions"}, plugin = {
	        "pretty",
	        "json:target/cucumber-reports/Cucumber.json",
	        "junit:target/cucumber-reports/Cucumber.xml",
	        "html:target/cucumber-reports/cucumber-html-report.html"
	    })
  
  public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	  @AfterSuite
	    public void generateReport() {
		  GenerateCucumberReport.generateJVMReport("target/cucumber-reports/Cucumber.json");
  
  }}
 
package lims.testrunner.Deltacheck;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lims.DcStepdefinition.JvmReport;

@RunWith(Cucumber.class)
@CucumberOptions(features= "C:\\Users\\xvd71\\eclipse-workspace\\DeltaCheck\\src\\test\\resources\\Feature\\Deltacheck.feature",glue= "lims.DcStepdefinition",
dryRun=false,monochrome=true,plugin= {"json:C:\\Users\\xvd71\\eclipse-workspace\\DeltaCheck\\Report\\JsonReport\\DCResult.json"})

public class TestRunner {
	@AfterClass
	public static void report() {
    JvmReport.generateJvmReport("C:\\Users\\xvd71\\eclipse-workspace\\DeltaCheck\\Report\\JsonReport\\DCResult.json");

	}

}

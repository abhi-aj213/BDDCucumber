package Base;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

//import com.cucumber.listener.Reporter;
//import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/main/resources/Features/",
	glue= "StepDefinations",
	tags = {"@Case1,@Case2"},
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},	
	strict = true,
    monochrome = true
	)


public class CucumberRunnerTest {
	
	/*@AfterClass
	public static void runTest() throws IOException {
		SendEmail se=new SendEmail();
		se.triggerEmail();
		}*/
	
}


	

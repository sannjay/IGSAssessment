package StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/Features", glue= {"StepDefinations"},
monochrome = true,   
plugin = {"pretty", "html:target/reports.html"} ) 


public class runTest { 
	
}

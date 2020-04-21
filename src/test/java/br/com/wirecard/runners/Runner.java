package br.com.wirecard.runners;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", 
plugin = {"pretty"},
glue = "br.com.wirecard.stepDefs", monochrome = true, dryRun = false)
public class Runner {

	
}

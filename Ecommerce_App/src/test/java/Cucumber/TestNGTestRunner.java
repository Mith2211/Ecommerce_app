package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="C:\\Users\\mithilesh.kharche\\eclipse-workspace\\Ecommerce_App\\src\\test\\java\\Cucumber", glue="automation.stepDefinition",
tags = "@ErrorValidation",
monochrome = true, 
plugin = {"html: target/cucumber.html"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
}

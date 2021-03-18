package com.ITFiles;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/harsh/OneDrive/Desktop/New folder/BDD_AutomationPractice/src/test/java/featureFiles/e2e.feature:26"},
        plugin = {"json:C:/Users/harsh/OneDrive/Desktop/New folder/BDD_AutomationPractice/target/cucumber/1.json"},
        monochrome = false,
        glue = {"steps"})
public class Parallel01IT {
}

package com.test;

import com.test.baseClass.baseClass;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        features = {"src/test/resources/features"},
        glue = {"helpers", "com.test.definitions"},
        tags = "@regression"
)
public class TestRunner extends baseClass {

    public TestRunner() {
    }

    @BeforeClass
    public static void setup() {
        baseClass.setup();
    }

    @AfterClass
    public static void tearDown() {

    }

}

package runner;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(publish= true,
features= {"src/test/resources/features"},
tags=("@home_page"),
glue= {"steps"},
plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
dryRun = false,
monochrome= true)
@DirtiesContext(classMode =DirtiesContext.ClassMode.AFTER_CLASS)
@RunWith(Cucumber.class)
public class Google_Home_Runner {

}

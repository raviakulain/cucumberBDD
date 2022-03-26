package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources"},
        glue = {"steps"},
        tags = "@ui or @regression",
        plugin = {"pretty","html:target/report.html"},
        monochrome = true
        //tags = "@regression or @sanity",
        //tags = "@regression and @sanity",
)

public class TestRunner
{
}

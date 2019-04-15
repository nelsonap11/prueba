package stageSet;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definition",
        plugin = {"pretty:target/reportes/pretty/pretty.txt",
                "html:target/reportes/html",
                "json:target/reportes/json/report.json",
                "junit:target/reportes/junit/junit.xml",
                "usage:target/reportes/usage/usage.json",
                "rerun:target/reportes/rerun/rerun.txt"}
)
public class StageSet {
}

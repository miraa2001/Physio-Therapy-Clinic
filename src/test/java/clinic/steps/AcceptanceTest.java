package clinic.steps ;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="use_cases",
plugin= {"html: target/cucumber.html"},
monochrome=true,
snippets=SnippetType.CAMELCASE,
glue={"clinic.steps"})
public class AcceptanceTest{
	AcceptanceTest()
	{
	}
}
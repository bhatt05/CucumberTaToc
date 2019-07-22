package TaToc.CucumberTaTOC;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {"Feature"}
 ,glue={"src/test/java/TaToc/CucumberTaTOC"} //,"src/test/java/TaToc/CucumberTaTOC/AdavanceTest.java"
 
)
 
public class App {
 
}
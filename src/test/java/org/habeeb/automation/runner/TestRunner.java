package org.habeeb.automation.runner;

import io.cucumber.testng.*;
import org.habeeb.automation.drivermanager.Driver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "C:\\Users\\habeeb_mohamed\\Desktop\\Habeeb\\Frameworks\\UiTest\\UiTest\\src\\test\\resources\\features\\",
        glue = {"org.habeeb.automation.stepdefinitions"},
        snippets = CAMELCASE,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    private final ThreadLocal<String> browser = new ThreadLocal<>();
    private XmlTest currentXmlTest;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        // Here we put the current context in the test class.
        // This context is distinct for each class/test so classes/tests can run in parallel.
        currentXmlTest = context.getCurrentXmlTest();

        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);

        Driver.initializeDriver();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(parallel = false) // This make cucumber feature file to run in parallel
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();

        Driver.quitDriver();
    }


}



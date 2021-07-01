package automationcraft.delivery.runners.lineal;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Created by Karthik on 21/09/2019.
 */
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/petclinic/features"},
        glue = {"automationcraft.testcreation.petclinic.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread"},
        tags = "@demo"
)
public class RunnerPetClinic extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}

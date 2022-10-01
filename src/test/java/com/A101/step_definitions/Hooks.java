package com.A101.step_definitions;

import com.A101.utilities.AppiumSingleton;
import com.A101.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println("screenshot was taken");
        }
        Driver.close();
        AppiumSingleton.close();
    }

}

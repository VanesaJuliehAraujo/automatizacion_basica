package cucumberHooks;

import baseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        BaseTest.setup();
    }

    @AfterAll
    public static void tearDown() {
        BaseTest.teardown();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            final byte[] screenshot = BaseTest.page.screenshot(
                    new com.microsoft.playwright.Page.ScreenshotOptions()
                            .setPath(Paths.get(screenshotName + ".png"))
                            .setFullPage(true)
            );
            scenario.attach(screenshot, "image/png", screenshotName + "_error.png");
        }
    }
}

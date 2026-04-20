package baseTest;

import com.microsoft.playwright.*;

public class BaseTest {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setTimeout(40000)
        );
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1279, 720)
        );
        page = context.newPage();
    }

    public static void teardown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

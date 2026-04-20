package driverSetup;

import com.microsoft.playwright.*;

public class driver {
    public static Page page;
    public static Browser browser;
    public static BrowserContext context;
    private static Playwright playwright;
    private static boolean initialized = false;

    public static void closeDriver() {
        // No-op: el browser se cierra al terminar la JVM via shutdown hook
    }

    public static void startDriver() {
        if (initialized) return;
        initialized = true;
        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setTimeout(40000)
            );
            context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(1279, 720));
            page = context.newPage();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    if (browser != null) browser.close();
                    if (playwright != null) playwright.close();
                } catch (Exception e) {
                    // ignorar errores al cerrar
                }
            }));
        } catch (Exception e) {
            System.out.println("Something went wrong with driverSetup.");
            System.out.println("\n" + e);
        }
    }
}

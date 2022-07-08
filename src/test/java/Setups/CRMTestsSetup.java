package Setups;

import Pages.NotePadPage;
import Pages.SaucePage;
import WebDriver.WebDriverComponents;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class CRMTestsSetup {
    private static WebDriverComponents webDriverComponents;
    public static SaucePage saucePage;
    public static NotePadPage notePadPage;

    @BeforeClass
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        saucePage = new SaucePage(webDriverComponents);
        notePadPage = new NotePadPage(webDriverComponents);
    }

    @AfterClass
    public static void tearDown() {
        webDriverComponents.exit();
    }
}

package Setups;

import Pages.GooglePage;
import Pages.LeetCodePage;
import WebDriver.WebDriverComponents;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class MySiteTestsSetup {
    private static WebDriverComponents webDriverComponents;
    public static LeetCodePage leetCodePage;
    public static GooglePage googlePage;

    @BeforeClass
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        leetCodePage = new LeetCodePage(webDriverComponents);
        googlePage = new GooglePage(webDriverComponents);
    }

    @AfterClass
    public static void tearDown() {
        webDriverComponents.exit();
    }
}

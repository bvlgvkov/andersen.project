package Setups;

import Pages.GooglePage;
import Pages.LeetCodePage;
import WebDriver.WebDriverComponents;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class MySiteTestsSetup {
    public static WebDriverComponents webDriverComponents;
    public static LeetCodePage leetCodePage;
    public static GooglePage googlePage;

    @BeforeAll
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        leetCodePage = new LeetCodePage(webDriverComponents);
        googlePage = new GooglePage(webDriverComponents);
    }

    @AfterAll
    public static void tearDown() {
        webDriverComponents.exit();
    }
}

package Setups;

import PageObjects.GooglePage;
import PageObjects.LeetCodePage;
import WebDriver.WebDriverComponents;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static Utils.PrintLogger.printWebLogger;

public class MySiteTestsSetup {
    private static WebDriverComponents webDriverComponents;
    public static LeetCodePage leetCodePage;
    public static GooglePage googlePage;

    @BeforeAll
    @DisplayName("Установка основных настроек")
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        leetCodePage = new LeetCodePage(webDriverComponents);
        googlePage = new GooglePage(webDriverComponents);
    }

    @AfterAll
    @DisplayName("Закрытие компонентов Драйвера")
    public static void tearDown() {
        printWebLogger();

        webDriverComponents.exit();
    }
}

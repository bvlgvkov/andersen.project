package Setups;

import Pages.NotePadPage;
import Pages.SaucePage;
import WebDriver.WebDriverComponents;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class CRMTestsSetup {
    private static WebDriverComponents webDriverComponents;
    public static SaucePage saucePage;
    public static NotePadPage notePadPage;

    @BeforeAll
    @DisplayName("Установка основных настроек")
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        saucePage = new SaucePage(webDriverComponents);
        notePadPage = new NotePadPage(webDriverComponents);
    }

    @AfterAll
    @DisplayName("Закрытие компонентов Драйвера")
    public static void tearDown() {
        webDriverComponents.exit();
    }
}

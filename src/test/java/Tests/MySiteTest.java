package Tests;

import Helpers.ScreenshotExtension;
import Setups.MySiteTestsSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ScreenshotExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MySiteTest extends MySiteTestsSetup {

    @Test
    @Order(1)
    @Description("Вход на сайт LeetCode")
    @DisplayName("LoginToLeetCodeWebsite")
    @Feature("LeetCode Test")
    @Severity(SeverityLevel.CRITICAL)
    public void oneTest() {
        leetCodePage.openPage();

        assertEquals("Account Login - LeetCode", leetCodePage.getMainTitleText());

        assertEquals("or you can sign in with", leetCodePage.findElementSignInWith());

        assertNotNull(leetCodePage.loginPage());

        assertNotNull(leetCodePage.clickSignInBotton());
    }

    @Test
    @Order(2)
    @Description("Открытие основной задачи по алгоритмам")
    @DisplayName("MainTaskOnLeetCode")
    @Feature("LeetCode Test")
    @Severity(SeverityLevel.CRITICAL)
    public void twoTest() {
        leetCodePage.waitContributePromo();

        WebElement elem = leetCodePage.getElemProblem();

        assertTrue(leetCodePage.isLogoDisplayed());

        elem.click();

        assertNotNull(leetCodePage.clickTwoSum());

        assertEquals("Easy", leetCodePage.getEasyText());
    }

    @Test
    @Order(3)
    @Description("Открытие Google страницы с последующий поиском и проверкой на корректность основного лого")
    @DisplayName("GoogleRequestAndCheckingLogo")
    @Feature("Google Test")
    @Severity(SeverityLevel.CRITICAL)
    public void threeTest() {
        assertNotNull(googlePage.openGoogle().clickEndSendMassage());

        assertTrue(googlePage.isFirstImageDisplayed());

        googlePage.pressEnter();

        assertTrue(googlePage.getLogo());

        assertEquals("Картинки по запросу Let's Write The code ! :)", googlePage.getTextInsideImageEntity());
    }

    @Test
    @Order(4)
    @Description("Отправка нового запроса в гугл и проверка на раскрытие-скрытие вложенного текста")
    @DisplayName("SecondGoogleRequestAndCheckingText")
    @Feature("Google Test")
    @Severity(SeverityLevel.CRITICAL)
    public void fourTest() {
        googlePage.sendNewMassage();

        assertEquals("visible", googlePage.checkToVisible());

        assertEquals("hidden", googlePage.checkToHidden());

        assertTrue(googlePage.isSecondImageDisplayed());
    }
}
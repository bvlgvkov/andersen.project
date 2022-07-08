package Tests;

import Helpers.ScreenshotExtension;
import Setups.CRMTestsSetup;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ScreenshotExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("CRM Tests")
class CRMTest extends CRMTestsSetup {

    @Test
    @Order(1)
    @Description("Создание и оформление заказа на Sauce Labs")
    @DisplayName("PurchaseOnSaucePage")
    @Feature("Sauce Page Test")
    @Severity(SeverityLevel.CRITICAL)
    public void oneTest() {
        saucePage.openPage();

        assertNotNull(saucePage.loginPage().clickButton());

        assertTrue(saucePage.isFirstImageDisplayed());

        assertNotNull(saucePage.findObjectOne());

        assertEquals("1", saucePage.getShoppingCard());

        assertNotNull(saucePage.acceptPurchase());

        assertNotNull(saucePage.fillPersonalData());

        assertEquals("FINISH", saucePage.getFinish());

        assertNotNull(saucePage.clickFinishIdButton());
    }

    @Test
    @Order(2)
    @Description("Создает Закладку для пользователя с временной ссылкой")
    @DisplayName("LinkCreationToNotePad")
    @Feature("NotePad Page Test")
    @Severity(SeverityLevel.CRITICAL)
    public void twoTest() {
        notePadPage.openWebsite();

        assertEquals("Создать временную ссылку для текущего текста", notePadPage.getTabNav());

        assertEquals("Удалить", notePadPage.getDeleteDraft());

        assertNotNull(notePadPage.setPassword());

        assertNotNull(notePadPage.createUrl());

        assertEquals("text", notePadPage.getTempAttribute());
    }
}
package Tests;

import ScreenshotExtension.ScreenshotExtension;
import Setups.CRMTestsSetup;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenshotExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic(value = "CRM Tasks")
class CRMTests extends CRMTestsSetup {
    @Test
    @Order(1)
    @Description("Создание и оформление заказа на Sauce Labs")
    @DisplayName("PurchaseInSaucePage")
    @Feature(value = "SaucePage Tasks")
    @Severity(SeverityLevel.CRITICAL)
    public void oneTest() {
        saucePage.openPage();

        saucePage.loginPage().clickButton();

        saucePage.imageOneIsDisplayed();

        saucePage.findObjectOne();

        saucePage.getShoppingCard();

        saucePage.acceptPurchase();

        saucePage.imageTwoIsDisplayed();

        saucePage.fillPersonalData();

        saucePage.getFinish();

        saucePage.clickFinishIdButton();
    }

    @Test
    @Order(2)
    @Description("Создает Закладку для пользователя с временной ссылкой")
    @DisplayName("LinkCreationInNotePad")
    @Feature(value = "NotePad Tasks")
    @Severity(SeverityLevel.CRITICAL)
    public void twoTest() {
        notePadPage.openWebsite();

        notePadPage.getTabNav();

        notePadPage.getDeleteDraft();

        notePadPage.setPassword();

        notePadPage.createUrl();

        notePadPage.getTempAttribute();
    }
}
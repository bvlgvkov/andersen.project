package Tests;

import Setups.CRMTestsSetup;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lombok.NoArgsConstructor;
import org.junit.Test;

//@ExtendWith(ScreenshotExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Web Application Regression Testing using JUnit4")
@Feature("Login Page Tests")
@NoArgsConstructor
public class CRMTest extends CRMTestsSetup {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("Test Description : After successful login to application opens Dashboard page")
    @Story("Successful login of application opens Dashboard Page")
    public void oneTest() {
        saucePage.openPage();

        saucePage.loginPage().clickButton();

        saucePage.imageOneIsDisplayed();

        saucePage.findObjectOne();

/*        saucePage.getShoppingCard();

        saucePage.acceptPurchase();

        saucePage.imageTwoIsDisplayed();

        saucePage.fillPersonalData();

        saucePage.getFinish();

        saucePage.clickFinishIdButton();*/
    }

    @Test
    @Description("Создание Закладки для пользователя с временной ссылкой")
    @DisplayName("LinkCreationInNotePad")
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
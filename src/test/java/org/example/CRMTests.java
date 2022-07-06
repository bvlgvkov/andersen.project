package org.example;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRMTests {
    private static WebDriverComponents webDriverComponents;
    private static SaucePage saucePage;
    private static NotePadPage notePadPage;

    @BeforeAll
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
        saucePage = new SaucePage(webDriverComponents);
        notePadPage = new NotePadPage(webDriverComponents);
    }

    @AfterAll
    public static void tearDown() {
        webDriverComponents.exit();
    }

    @Test
    @Order(1)
    public void oneTest() {
        saucePage.openPage();

        saucePage.loginPage().clickButton();

        boolean checkImage = saucePage.imageOneIsDisplayed();
        Assertions.assertTrue(checkImage);

        saucePage.findObjectOne();

        String expectedElem = saucePage.getShoppingCard();
        String actualElem = "1";
        Assertions.assertEquals(actualElem, expectedElem);

        saucePage.acceptPurchase();

        boolean checkLogo = saucePage.imageTwoIsDisplayed();
        Assertions.assertTrue(checkLogo);

        saucePage.fillPersonalData();

        expectedElem = saucePage.getFinish();
        actualElem = "FINISH";
        Assertions.assertEquals(actualElem, expectedElem);

        saucePage.clickFinishIdButton();
    }

    @Test
    @Order(2)
    public void twoTest() {
        notePadPage.openWebsite();

        String expectedText = notePadPage.getTabNav().getText();
        String actualText = "Создать временную ссылку для текущего текста";
        Assertions.assertEquals(actualText, expectedText);

        expectedText = notePadPage.getDeleteDraft().getText();
        actualText = "Удалить";
        Assertions.assertEquals(actualText, expectedText);

        notePadPage.setPassword();

        notePadPage.createUrl();

        actualText = notePadPage.getTempAttribute();
        expectedText = "text";
        Assertions.assertEquals(actualText, expectedText);
    }
}
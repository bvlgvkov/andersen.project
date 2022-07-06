package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MySiteTests {

    private static WebDriverComponents webDriverComponents;
    private static LeetCodePage leetCodePage;
    private static GooglePage googlePage;

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

    @Test
    @Order(1)
    public void oneTest() {
        leetCodePage.openPage();

        String ActualTitle = leetCodePage.presenceOfElementLocatedByXPath().getTitle();
        String ExpectedTitle = "Account Login - LeetCode";
        Assertions.assertEquals(ExpectedTitle, ActualTitle);

        String actualText = leetCodePage.findElementSignInWith().getText();
        String expectedText = "or you can sign in with";
        Assertions.assertEquals(expectedText, actualText);

        leetCodePage.loginPage();
        leetCodePage.clickSignInBottom();
    }

    @Test
    @Order(2)
    public void twoTest() {
        WebElement elem = leetCodePage.getElemProblem();

        boolean logoPresent = leetCodePage.getLogo().isDisplayed();
        Assertions.assertTrue(logoPresent);

        elem.click();

        leetCodePage.clickTwoSum();

        String actualText = leetCodePage.getEasy().getText();
        String expectedText = "Easy";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    @Order(3)
    public void threeTest() {
        googlePage.openGoogle().clickEndSendMassage();

        boolean logoPresent = googlePage.getMainElem().isDisplayed();
        Assertions.assertTrue(logoPresent);

        googlePage.pressEnter();

        logoPresent = googlePage.getLogo().isDisplayed();
        Assertions.assertTrue(logoPresent);

        String actualText = googlePage.getImageOne().getText();
        String expectedText = "Картинки по запросу Let's Write The code ! :)";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    @Order(4)
    public void fourTest() {
        googlePage.sendNewMassage();

        String actualText = googlePage.checkToVisible().getCssValueByVisibility();
        String expectedText = "visible";
        Assertions.assertEquals(expectedText, actualText);

        actualText = googlePage.checkToHidden().getCssValueByVisibility();
        expectedText = "hidden";
        Assertions.assertEquals(expectedText, actualText);

        boolean logoPresent = googlePage.getImageTwo().isDisplayed();
        Assertions.assertTrue(logoPresent);
    }
}
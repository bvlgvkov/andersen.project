package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MySiteTests {

    private static WebDriverComponents webDriverComponents;

    @BeforeAll
    public static void setupAll() {
        webDriverComponents = new WebDriverComponents();
    }

    @AfterAll
    public static void tearDown() {
        webDriverComponents.exit();
    }

    @Test
    @Order(1)
    public void oneTest() {
        webDriverComponents.openWebsite("https://leetcode.com/accounts/login/");

        String ActualTitle = webDriverComponents
                .presenceOfElementLocated("xPath", "/html/body/div[4]/iframe")
                .getTitle();
        String ExpectedTitle = "Account Login - LeetCode";
        Assertions.assertEquals(ExpectedTitle, ActualTitle);

        String actualText = webDriverComponents.findElement("className", "tips__3UvI").getText();
        String expectedText = "or you can sign in with";
        Assertions.assertEquals(expectedText, actualText);

        webDriverComponents.visibilityOfElementLocated("xPath", "//*[@id=\"id_login\"]")
                .clickAndSendKeys("andersentest@mail.ru")
                .visibilityOfElementLocated("xPath", "//*[@id=\"id_password\"]")
                .clickAndSendKeys("Chess_1995@");

        webDriverComponents.presenceOfElementLocated("xPath", "//*[@id=\"signin_btn\"]/div")
                .visibilityOfElementLocated("xPath", "//*[@id=\"signin_btn\"]/div")
                .findAndClick("xPath", "//*[@id=\"signin_btn\"]/div");
    }

    @Test
    @Order(2)
    public void twoTest() {
        WebElement elem = webDriverComponents.visibilityOfElementLocated("partialLinkText", "Problems")
                .getElement();

        boolean logoPresent = webDriverComponents.findElement("className", "logo__3xn0").isDisplayed();
        Assertions.assertTrue(logoPresent);

        elem.click();

        webDriverComponents.visibilityOfElementLocated("partialLinkText", "Two Sum")
                .clickElement()
                .presenceOfElementLocated("xPath", "/html/body/div[4]/iframe");

        String actualText = webDriverComponents.findElement("className", "css-14oi08n").getText();
        String expectedText = "Easy";
        Assertions.assertEquals(expectedText, actualText);

        webDriverComponents.changeSite("https://www.google.com/")
                .visibilityOfElementLocated("name", "q")
                .clickAndSendKeys("Let's Write The code ! :)");

        logoPresent = webDriverComponents.findElement("className", "lnXdpd").isDisplayed();
        Assertions.assertTrue(logoPresent);
    }

    @Test
    @Order(3)
    public void threeTest() {
        webDriverComponents.visibilityOfElementLocated("name", "q").sendKeys(Keys.RETURN);

        boolean logoPresent = webDriverComponents.findElement("xpath", "//*[@id=\"logo\"]/img")
                .isDisplayed();
        Assertions.assertTrue(logoPresent);

        String actualText = webDriverComponents.findElement("className", "GmE3X").getText();
        String expectedText = "Картинки по запросу Let's Write The code ! :)";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    @Order(4)
    public void fourTest() {
        webDriverComponents.visibilityOfElementLocated("name", "q")
                .clear()
                .sendKeys("Webdriver tests example")
                .sendKeys(Keys.RETURN);

        String actualText = webDriverComponents.findElement("className", "r21Kzd")
                .getCssValue("visibility");
        String expectedText = "visible";
        Assertions.assertEquals(expectedText, actualText);

        actualText = webDriverComponents.clickElement().attributeContain("className", "r21Kzd", "visibility", "hidden")
                .getCssValue("visibility");
        expectedText = "hidden";
        Assertions.assertEquals(expectedText, actualText);

        boolean logoPresent = webDriverComponents
                .findElement("xPath", "//img[@src='https://encrypted-tbn0.gstatic.com/images?q=" +
                        "tbn:ANd9GcTE5q1QSDORlXiZIyVaeNB4JqMv1kQs2G9B2rPuAcptcw&s']")
                .isDisplayed();
        Assertions.assertTrue(logoPresent);
    }
}
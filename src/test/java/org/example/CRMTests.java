package org.example;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRMTests {
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
        webDriverComponents.openWebsite("https://www.saucedemo.com/checkout-complete.html");
        webDriverComponents.visibilityOfElementLocated("name", "user-name")
                .clickAndSendKeys("standard_user");

        webDriverComponents.findElement("name", "password")
                .clickAndSendKeys("secret_sauce")
                .findAndClick("xPath", "//*[@id=\"login-button\"]");

        boolean checkImage = webDriverComponents.isDisplayed("className", "inventory_item_img");
        Assertions.assertTrue(checkImage);

        webDriverComponents.findAndClick("xPath", "//*[@id=\"add-to-cart-sauce-labs-backpack\"]");

        String expectedElem = webDriverComponents.findAndGetText("className", "shopping_cart_badge");
        String actualElem = "1";
        Assertions.assertEquals(actualElem, expectedElem);

        webDriverComponents.findAndClick("xPath", "//*[@id=\"shopping_cart_container\"]/a");

        boolean checkLogo = webDriverComponents.isDisplayed("className", "footer_robot");
        Assertions.assertTrue(checkLogo);

        webDriverComponents.findAndClick("xPath", "//*[@id=\"checkout\"]")
                .findAndSendKeys("xPath", "//*[@id=\"first-name\"]", "Anatoliy")
                .findAndSendKeys("xPath", "//*[@id=\"last-name\"]", "Bulgakov")
                .findAndSendKeys("xPath", "//*[@id=\"postal-code\"]", "050051")
                .findAndClick("xPath", "//*[@id=\"continue\"]");

        expectedElem = webDriverComponents.findAndGetText("id", "finish");
        actualElem = "FINISH";
        Assertions.assertEquals(actualElem, expectedElem);

        webDriverComponents.findAndClick("xPath", "//*[@id=\"finish\"]");
    }

    @Test
    @Order(2)
    public void twoTest() {
        webDriverComponents.changeSite("http://justnotepad.com/ru/")
                .visibilityOfElementLocated("name", "editable_text")
                .clickAndSendKeys("Bulgakov Anatoliy")
                .findAndClick("id", "temp_url_nav");

        String expectedText = webDriverComponents.findElement("id", "temp_url_nav").getText();
        String actualText = "Создать временную ссылку для текущего текста";
        Assertions.assertEquals(actualText, expectedText);

        expectedText = webDriverComponents.findElement("id", "delete_draft").getText();
        actualText = "Удалить";
        Assertions.assertEquals(actualText, expectedText);

        webDriverComponents.findElement("name", "password")
                .presenceOfElementLocated("name", "password")
                .visibilityOfElementLocated("name", "password")
                .clickAndSendKeys("12345678");

        webDriverComponents.findAndClick("id", "create_url");

        actualText = webDriverComponents.presenceOfElementLocated("id", "temp_url")
                .visibilityOfElementLocated("id", "temp_url")
                .findElement("id", "temp_url").getAttribute("type");
        expectedText = "text";
        Assertions.assertEquals(actualText, expectedText);
    }
}
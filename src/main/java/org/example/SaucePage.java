package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaucePage {
    WebDriverComponents webDriverComponents;
    private static final String LOGIN_BUTTON = "//*[@id=\"login-button\"]";
    private static final String IMAGE_ONE = "inventory_item_img";
    private static final String IMAGE_TWO = "footer_robot";
    private static final String BACKPACK = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]";
    private static final String SHOPPING_CARD = "shopping_cart_badge";
    private static final String CONTAINER = "//*[@id=\"shopping_cart_container\"]/a";
    private static final String CHECKOUT_ID = "//*[@id=\"checkout\"]";
    private static final String NAME = "Anatoliy";
    private static final String SURNAME = "Bulgakov";
    private static final String POSTCODE = "050051";
    private static final String CONTINUE = "//*[@id=\"continue\"]";
    private static final String POSTAL_CODE = "//*[@id=\"postal-code\"]";
    private static final String LAST_NAME = "//*[@id=\"last-name\"]";
    private static final String FIRST_NAME = "//*[@id=\"first-name\"]";
    private static final String FINISH_ID = "//*[@id=\"finish\"]";
    private static final String WEBSITE = "https://www.saucedemo.com/checkout-complete.html";
    private static final String LOGIN = "user-name";
    private static final String LOGIN_NAME = "standard_user";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_NAME = "secret_sauce";
    private static final String FINISH = "finish";

    public void openPage() {
        webDriverComponents.openWebsite(WEBSITE);
    }

    public SaucePage loginPage() {
        webDriverComponents.visibilityOfElementLocatedByName(LOGIN).clickAndSendKeys(LOGIN_NAME);

        webDriverComponents = webDriverComponents.findElementByName(PASSWORD).clickAndSendKeys(PASSWORD_NAME);

        return this;
    }

    public void clickButton() {
        webDriverComponents.findAndClickByXpath(LOGIN_BUTTON);
    }

    public boolean imageOneIsDisplayed() {
        return webDriverComponents.isDisplayedByClassName(IMAGE_ONE);
    }

    public boolean imageTwoIsDisplayed() {
        return webDriverComponents.isDisplayedByClassName(IMAGE_TWO);
    }

    public void findObjectOne() {
        webDriverComponents.findAndClickByXpath(BACKPACK);
    }

    public String getShoppingCard() {
        return webDriverComponents.findAndGetTextByClassName(SHOPPING_CARD);
    }

    public void acceptPurchase() {
        webDriverComponents.findAndClickByXpath(CONTAINER);
    }

    public void fillPersonalData() {
        webDriverComponents.findAndClickByXpath(CHECKOUT_ID)
                .findAndSendKeysByXPath(FIRST_NAME, NAME)
                .findAndSendKeysByXPath(LAST_NAME, SURNAME)
                .findAndSendKeysByXPath(POSTAL_CODE, POSTCODE)
                .findAndClickByXpath(CONTINUE);
    }

    public String getFinish() {
        return webDriverComponents.findAndGetTextById(FINISH);
    }

    public void clickFinishIdButton() {
        webDriverComponents.findAndClickByXpath(FINISH_ID);
    }
}

package Pages;


import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Data
@AllArgsConstructor
@DisplayName("Тестирование класса SaucePage")
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

    @Step("Открыть страницу")
    public void openPage() {
        webDriverComponents.openWebsite(WEBSITE);
    }

    @Step("Залогиниться")
    public SaucePage loginPage() {
        webDriverComponents.visibilityOfElementLocatedByName(LOGIN).clickAndSendKeys(LOGIN_NAME);
        webDriverComponents = webDriverComponents.findElementByName(PASSWORD).clickAndSendKeys(PASSWORD_NAME);

        return this;
    }

    @Step("Нажать логин button")
    public void clickButton() {
        webDriverComponents.findAndClickByXpath(LOGIN_BUTTON);
    }

    @Step("Проверка на отображение картинку N1")
    public void imageOneIsDisplayed() {
        Assertions.assertTrue(webDriverComponents.isDisplayedByClassName(IMAGE_ONE));
    }
    @Step("Проверка на отображение картинку N2")
    public void imageTwoIsDisplayed() {
        Assertions.assertTrue(webDriverComponents.isDisplayedByClassName(IMAGE_TWO));
    }
    @Step("Поиск и нажатие специализированного товара")
    public void findObjectOne() {
        webDriverComponents.findAndClickByXpath(BACKPACK);
    }

    @Step("Проверка на регистрацию магазинной карты")
    public void getShoppingCard() {
        String expectedElem = webDriverComponents.findAndGetTextByClassName(SHOPPING_CARD);
        String actualElem = "1";
        Assertions.assertEquals(actualElem, expectedElem);
    }

    @Step("Подтверждение добавления покупки в контейнер")
    public void acceptPurchase() {
        webDriverComponents.findAndClickByXpath(CONTAINER);
    }

    @Step("Заполнение персональных данных")
    public void fillPersonalData() {
        webDriverComponents.findAndClickByXpath(CHECKOUT_ID)
                .findAndSendKeysByXPath(FIRST_NAME, NAME)
                .findAndSendKeysByXPath(LAST_NAME, SURNAME)
                .findAndSendKeysByXPath(POSTAL_CODE, POSTCODE)
                .findAndClickByXpath(CONTINUE);
    }

    @Step("Поиск кнопки Подтверждения окончательной покупки")
    @Story(value = "Check To Correct Existing")
    public void getFinish() {
        String expectedElem = webDriverComponents.findAndGetTextById(FINISH);
        String actualElem = "FINISH";
        assertEquals(actualElem, expectedElem);
    }

    @Step("Подтверждение окончательной покупки")
    @Story(value = "Click Button")
    public void clickFinishIdButton() {
        webDriverComponents.findAndClickByXpath(FINISH_ID);
    }
}

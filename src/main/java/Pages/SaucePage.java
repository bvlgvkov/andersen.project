package Pages;


import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;

import static WebDriver.WebDriverComponents.*;

@Data
@AllArgsConstructor
@DisplayName("Тестирование класса SaucePage")
public class SaucePage {
    WebDriverComponents webDriverComponents;
    private static final String LOGIN_BUTTON = "//*[@id=\"login-button\"]";
    private static final String IMAGE_ONE = "inventory_item_img";
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
        webDriverComponents.visibilityOfElementLocated(ID, LOGIN).clickAndSendKeys(LOGIN_NAME);
        webDriverComponents = webDriverComponents.findElement(ID, PASSWORD).clickAndSendKeys(PASSWORD_NAME);

        return this;
    }

    @Step("Нажать логин кнопку")
    public WebDriverComponents clickButton() {
        return webDriverComponents.findElement(X_PATH, LOGIN_BUTTON).clickElement();
    }

    @Step("Проверка на отображение картинки №1")
    public boolean isFirstImageDisplayed() {
        return webDriverComponents.findElement(CLASS_NAME, IMAGE_ONE).isDisplayed();
    }

    @Step("Поиск и нажатие специализированного товара")
    public WebDriverComponents findObjectOne() {
        return webDriverComponents.findElement(X_PATH, BACKPACK).clickElement();
    }

    @Step("Проверка на регистрацию магазинной карты")
    public String getShoppingCard() {
        return webDriverComponents.findElement(CLASS_NAME, SHOPPING_CARD).getText();
    }

    @Step("Подтверждение добавления покупки в контейнер")
    public WebDriverComponents acceptPurchase() {
        return webDriverComponents.findElement(X_PATH, CONTAINER).clickElement();
    }

    @Step("Заполнение персональных данных")
    public WebDriverComponents fillPersonalData() {
        return webDriverComponents.findElement(X_PATH, CHECKOUT_ID).clickElement()
                .findAndSendKeys(X_PATH, FIRST_NAME, NAME)
                .findAndSendKeys(X_PATH, LAST_NAME, SURNAME)
                .findAndSendKeys(X_PATH, POSTAL_CODE, POSTCODE)
                .findElement(X_PATH, CONTINUE).clickElement();
    }

    @Step("Поиск кнопки подтверждения окончательной покупки")
    public String getFinish() {
        return webDriverComponents.findElement(ID, FINISH).getText();
    }

    @Step("Подтверждение окончательной покупки")
    public WebDriverComponents clickFinishIdButton() {
        return webDriverComponents.findElement(X_PATH, FINISH_ID).clickElement();
    }
}

package PageObjects;


import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.Keys;

import static WebDriver.WebDriverComponents.*;

@Data
@AllArgsConstructor
public class GooglePage {
    WebDriverComponents webDriverComponents;
    private static final String MESSAGE = "Let's Write The code ! :)";
    private static final String MAIN_ELEM = "lnXdpd";
    private static final String IMAGE_1 = "GmE3X";
    private static final String WEB_DRIVER_TESTS_EXAMPLE = "Webdriver tests example";
    private static final String ELEMENT = "r21Kzd";
    private static final String HIDDEN = "hidden";
    private static final String WEBSITE = "https://www.google.com/";
    private static final String Q = "q";
    private static final String LOGO = "//*[@id=\"logo\"]/img";
    private static final String IMAGE_2 = "//img[@src='https://encrypted-tbn0.gstatic.com" +
            "/images?q=tbn:ANd9GcRIY8JPwCXoc07namcTeejeTUJcZfwx1l_DI96TuPPGEQ&s']";

    @Step("Открыть гугл страницу")
    public GooglePage openGoogle() {
        webDriverComponents = webDriverComponents.changeSite(WEBSITE).visibilityOfElementLocated(NAME, Q);

        return this;
    }

    @Step("Ввод сообщения в строку ввода")
    public WebDriverComponents clickEndSendMassage() {
        return webDriverComponents.clickAndSendKeys(MESSAGE);
    }

    @Step("Проверка отображения временного логотипа")
    public boolean isFirstImageDisplayed() {
        return webDriverComponents.findElement(CLASS_NAME, MAIN_ELEM).isDisplayed();
    }

    @Step("Отправка запроса в строку ввода")
    public void pressEnter() {
        webDriverComponents.visibilityOfElementLocated(NAME, Q).sendKeys(Keys.RETURN);
    }

    @Step("Проверка отображения главного логотипа")
    public Boolean getLogo() {
        return webDriverComponents.findElement(X_PATH, LOGO).isDisplayed();
    }

    @Step("Проверка корректности текста внутри директивы картинки")
    public String getTextInsideImageEntity() {
        return webDriverComponents.findElement(CLASS_NAME, IMAGE_1).getText();
    }

    @Step("Проверка отображения второй картинки")
    public boolean isSecondImageDisplayed() {
        return webDriverComponents.findElement(X_PATH, IMAGE_2).isDisplayed();
    }

    @Step("Отправка нового запроса в гугл и его подтверждение")
    public void sendNewMassage() {
        webDriverComponents.visibilityOfElementLocated(NAME, Q).clear().sendKeys(WEB_DRIVER_TESTS_EXAMPLE)
                .sendKeys(Keys.RETURN);
    }

    @Step("Проверка видимости вложенной сущности на видимость")
    public String checkToVisible() {
        return webDriverComponents.findElement(CLASS_NAME, ELEMENT).getCssValueByVisibility();
    }

    @Step("Проверка видимости вложенной сущности на скрытность")
    public String checkToHidden() {
        return webDriverComponents.clickElement()
                .attributeContain(CLASS_NAME, ELEMENT, VISIBILITY, HIDDEN)
                .getCssValueByVisibility();
    }
}

package Pages;

import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;

@Data
@AllArgsConstructor
@DisplayName("Тестирование класса NotePadPage")
public class NotePadPage {
    WebDriverComponents webDriverComponents;
    private static final String TEXT = "editable_text";
    private static final String FULL_NAME = "Bulgakov Anatoliy";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_NUMBER = "12345678";
    private static final String CREATE_URL = "create_url";
    private static final String TEMP_URL = "temp_url";
    private static final String TYPE = "type";
    private static final String DELETE_DRAFt = "delete_draft";
    private static final String WEBSITE = "http://justnotepad.com/ru/";
    private static final String TEMP_URL_NAV = "temp_url_nav";

    @Step("Поиск кнопки на создание временной ссылки")
    public String getTabNav() {
        return webDriverComponents.findElementById(TEMP_URL_NAV).getText();
    }

    @Step("Поиск на кнопку удаления черновика")
    public String getDeleteDraft() {
        return webDriverComponents.findElementById(DELETE_DRAFt).getText();
    }

    @Step("Открытие website")
    public void openWebsite() {
        webDriverComponents.changeSite(WEBSITE)
                .visibilityOfElementLocatedByName(TEXT)
                .clickAndSendKeys(FULL_NAME)
                .findAndClickById(TEMP_URL_NAV);
    }

    @Step("Установка пароля")
    public WebDriverComponents setPassword() {
        return webDriverComponents.findElementByName(PASSWORD)
                .presenceOfElementLocatedByName(PASSWORD)
                .visibilityOfElementLocatedByName(PASSWORD)
                .clickAndSendKeys(PASSWORD_NUMBER);
    }

    @Step("Поиск и нажатие на URL")
    public WebDriverComponents createUrl() {
        return webDriverComponents.findAndClickById(CREATE_URL);
    }

    @Step("Получение специализированного атрибута")
    public String getTempAttribute() {
        return webDriverComponents.presenceOfElementLocatedById(TEMP_URL)
                .visibilityOfElementLocatedById(TEMP_URL)
                .findElementById(TEMP_URL).getAttribute(TYPE);

    }
}

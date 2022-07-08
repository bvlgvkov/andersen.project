package Pages;

import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;

import static WebDriver.WebDriverComponents.ID;
import static WebDriver.WebDriverComponents.NAME;

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
        return webDriverComponents.findElement(ID, TEMP_URL_NAV).getText();
    }

    @Step("Поиск на кнопку удаления черновика")
    public String getDeleteDraft() {
        return webDriverComponents.findElement(ID, DELETE_DRAFt).getText();
    }

    @Step("Открытие website")
    public void openWebsite() {
        webDriverComponents.changeSite(WEBSITE)
                .visibilityOfElementLocated(NAME, TEXT)
                .clickAndSendKeys(FULL_NAME)
                .findElement(ID, TEMP_URL_NAV).clickElement();
    }

    @Step("Установка пароля")
    public WebDriverComponents setPassword() {
        return webDriverComponents.findElement(NAME, PASSWORD)
                .presenceOfElementLocated(NAME, PASSWORD)
                .visibilityOfElementLocated(NAME, PASSWORD)
                .clickAndSendKeys(PASSWORD_NUMBER);
    }

    @Step("Поиск и нажатие на URL")
    public WebDriverComponents createUrl() {
        return webDriverComponents.findElement(ID, CREATE_URL).clickElement();
    }


    @Step("Получение специализированного атрибута")
    public String getTempAttribute() {
        return webDriverComponents.presenceOfElementLocated(ID, TEMP_URL)
                .visibilityOfElementLocated(ID, TEMP_URL)
                .findElement(ID, TEMP_URL).getAttribute(TYPE);

    }
}

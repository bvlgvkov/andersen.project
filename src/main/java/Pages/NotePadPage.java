package Pages;

import WebDriver.WebDriverComponents;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lombok.AllArgsConstructor;
import lombok.Data;

import static org.junit.Assert.assertEquals;

@Data
@AllArgsConstructor
@DisplayName("Тестирование класса NotePadPage")
@Feature("NotePad Page Test")
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
    @Description("Проверяет наличие временной сслыки по ID и вытаскивает внутренний текст")
    public void getTabNav() {
        String expectedText = webDriverComponents.findElementById(TEMP_URL_NAV).getText();
        String actualText = "Создать временную ссылку для текущего текста";
        assertEquals(actualText, expectedText);
    }

    @Step("Поиск на кнопку удаления черновика")
    public void getDeleteDraft() {
        String expectedText = webDriverComponents.findElementById(DELETE_DRAFt).getText();
        String actualText = "Удалить";
        assertEquals(actualText, expectedText);
    }

    @Step("Открытие website")
    public void openWebsite() {
        webDriverComponents.changeSite(WEBSITE)
                .visibilityOfElementLocatedByName(TEXT)
                .clickAndSendKeys(FULL_NAME)
                .findAndClickById(TEMP_URL_NAV);
    }

    @Step("Установка пароля")
    public void setPassword() {
        webDriverComponents.findElementByName(PASSWORD)
                .presenceOfElementLocatedByName(PASSWORD)
                .visibilityOfElementLocatedByName(PASSWORD)
                .clickAndSendKeys(PASSWORD_NUMBER);
    }

    @Step("Поиск и нажатие на URL")
    public void createUrl() {
        webDriverComponents.findAndClickById(CREATE_URL);
    }

    @Step("Получение специализированного атрибута")
    public void getTempAttribute() {
        String actualText = webDriverComponents.presenceOfElementLocatedById(TEMP_URL)
                .visibilityOfElementLocatedById(TEMP_URL)
                .findElementById(TEMP_URL).getAttribute(TYPE);
        String expectedText = "text";
        assertEquals(actualText, expectedText);
    }
}

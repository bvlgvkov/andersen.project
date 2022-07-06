package Pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import WebDriver.WebDriverComponents;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Data
@AllArgsConstructor
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

    public void getTabNav() {
        String expectedText = webDriverComponents.findElementById(TEMP_URL_NAV).getText();
        String actualText = "Создать временную ссылку для текущего текста";
        Assertions.assertEquals(actualText, expectedText);
    }

    public void getDeleteDraft() {
        String expectedText = webDriverComponents.findElementById(DELETE_DRAFt).getText();
        String actualText = "Удалить";
        Assertions.assertEquals(actualText, expectedText);
    }

    public void openWebsite() {
        webDriverComponents.changeSite(WEBSITE)
                .visibilityOfElementLocatedByName(TEXT)
                .clickAndSendKeys(FULL_NAME)
                .findAndClickById(TEMP_URL_NAV);
    }

    public void setPassword() {
        webDriverComponents.findElementByName(PASSWORD)
                .presenceOfElementLocatedByName(PASSWORD)
                .visibilityOfElementLocatedByName(PASSWORD)
                .clickAndSendKeys(PASSWORD_NUMBER);
    }

    public void createUrl() {
        webDriverComponents.findAndClickById(CREATE_URL);
    }

    public void getTempAttribute() {
        String actualText = webDriverComponents.presenceOfElementLocatedById(TEMP_URL)
                .visibilityOfElementLocatedById(TEMP_URL)
                .findElementById(TEMP_URL).getAttribute(TYPE);
        String expectedText = "text";
        assertEquals(actualText, expectedText);
    }
}

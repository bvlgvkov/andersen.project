package Pages;


import WebDriver.WebDriverComponents;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

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

    public GooglePage openGoogle() {
        webDriverComponents = webDriverComponents.changeSite(WEBSITE).visibilityOfElementLocatedByName(Q);

        return this;
    }

    public void clickEndSendMassage() {
        webDriverComponents.clickAndSendKeys(MESSAGE);
    }

    public void getMainElem() {
        Assertions.assertTrue(webDriverComponents.findElementByClassName(MAIN_ELEM).isDisplayed());
    }

    public void pressEnter() {
        webDriverComponents.visibilityOfElementLocatedByName(Q).sendKeys(Keys.RETURN);
    }

    public void getLogo() {
        Assertions.assertTrue(webDriverComponents.findElementByXpath(LOGO).isDisplayed());
    }

    public void getImageOne() {
        String actualText = webDriverComponents.findElementByClassName(IMAGE_1).getText();
        String expectedText = "Картинки по запросу Let's Write The code ! :)";
        Assertions.assertEquals(expectedText, actualText);
    }

    public void getImageTwo() {
        Assertions.assertTrue(webDriverComponents.findElementByXpath(IMAGE_2).isDisplayed());
    }

    public void sendNewMassage() {
        webDriverComponents.visibilityOfElementLocatedByName(Q).clear().sendKeys(WEB_DRIVER_TESTS_EXAMPLE)
                .sendKeys(Keys.RETURN);
    }

    public void checkToVisible() {
        String actualText = webDriverComponents.findElementByClassName(ELEMENT).getCssValueByVisibility();
        String expectedText = "visible";
        Assertions.assertEquals(expectedText, actualText);
    }

    public void checkToHidden() {
        String actualText = webDriverComponents.clickElement()
                .attributeContainByClassName(ELEMENT, webDriverComponents.getVisibility(), HIDDEN)
                .getCssValueByVisibility();
        String expectedText = "hidden";
        Assertions.assertEquals(expectedText, actualText);
    }
}

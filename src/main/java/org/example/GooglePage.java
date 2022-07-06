package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.Keys;

@Data
@AllArgsConstructor
public class GooglePage {
    WebDriverComponents webDriverComponents;
    private static final String MASSAGE = "Let's Write The code ! :)";
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
        webDriverComponents.clickAndSendKeys(MASSAGE);
    }

    public WebDriverComponents getMainElem() {
        return webDriverComponents.findElementByClassName(MAIN_ELEM);
    }

    public void pressEnter() {
        webDriverComponents.visibilityOfElementLocatedByName(Q).sendKeys(Keys.RETURN);
    }

    public WebDriverComponents getLogo() {
        return webDriverComponents.findElementByXpath(LOGO);
    }

    public WebDriverComponents getImageOne() {
        return webDriverComponents.findElementByClassName(IMAGE_1);
    }

    public WebDriverComponents getImageTwo() {
        return webDriverComponents.findElementByXpath(IMAGE_2);
    }

    public void sendNewMassage() {
        webDriverComponents.visibilityOfElementLocatedByName(Q).clear().sendKeys(WEB_DRIVER_TESTS_EXAMPLE)
                .sendKeys(Keys.RETURN);
    }

    public WebDriverComponents checkToVisible() {
        return webDriverComponents.findElementByClassName(ELEMENT);
    }

    public WebDriverComponents checkToHidden() {
        return webDriverComponents.clickElement().attributeContainByClassName(ELEMENT, webDriverComponents.getVisibility(), HIDDEN);
    }
}

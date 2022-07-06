package Pages;

import WebDriver.WebDriverComponents;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Data
@AllArgsConstructor
public class LeetCodePage {
    private static final String CONTRIBUTE_PROMO = "//*[@id=\"contribute-promo\"]";
    WebDriverComponents webDriverComponents;
    private static final String TWO_SUM = "Two Sum";
    private static final String WEBSITE = "https://leetcode.com/accounts/login/";
    private static final String MAIN_IFRAME = "/html/body/div[4]/iframe";
    private static final String OR_YOU_CAN_SIGN_IN_WITH = "tips__3UvI";
    private static final String LOGIN = "//*[@id=\"id_login\"]";
    private static final String LOGIN_NAME = "andersentest@mail.ru";
    private static final String PASSWORD = "//*[@id=\"id_password\"]";
    private static final String PASSWORD_NAME = "Chess_1995@";
    private static final String SIGN_IN_BOTTOM = "//*[@id=\"signin_btn\"]/div";
    private static final String PROBLEMS = "Problems";
    private static final String LOGO = "logo__3xn0";
    private static final String EASY = "css-14oi08n";

    public void openPage() {
        webDriverComponents.openWebsite(WEBSITE);
    }

    public void presenceOfElementLocatedByXPath() {
        String actualText = webDriverComponents.presenceOfElementLocatedByXPath(MAIN_IFRAME).getTitle();
        String expectedText = "Account Login - LeetCode";
        assertEquals(expectedText, actualText);
    }

    public void findElementSignInWith() {
        String actualText = webDriverComponents.findElementByClassName(OR_YOU_CAN_SIGN_IN_WITH).getText();
        String expectedText = "or you can sign in with";
        assertEquals(expectedText, actualText);
    }

    public void loginPage() {
        webDriverComponents.visibilityOfElementLocatedByXPath(LOGIN)
                .clickAndSendKeys(LOGIN_NAME)
                .visibilityOfElementLocatedByXPath(PASSWORD)
                .clickAndSendKeys(PASSWORD_NAME);
    }

    public void clickSignInBottom() {
        webDriverComponents.presenceOfElementLocatedByXPath(SIGN_IN_BOTTOM)
                .visibilityOfElementLocatedByXPath(SIGN_IN_BOTTOM)
                .findAndClickByXpath(SIGN_IN_BOTTOM);
    }

    public WebElement getElemProblem() {
       return webDriverComponents.presenceOfElementLocatedByLink(PROBLEMS)
               .visibilityOfElementLocatedByLink(PROBLEMS).getElement();
    }

    public void getLogo() {
        assertTrue(webDriverComponents.findElementByClassName(LOGO).isDisplayed());
    }

    public void clickTwoSum() {
        webDriverComponents.visibilityOfElementLocatedByLink(TWO_SUM).clickElement()
                .presenceOfElementLocatedByXPath(MAIN_IFRAME);
    }

    public void getEasy() {
        String actualText = webDriverComponents.findElementByClassName(EASY).getText();
        String expectedText = "Easy";
        assertEquals(expectedText, actualText);
    }

    public void waitContributePromo() {
        webDriverComponents.getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(CONTRIBUTE_PROMO)));
    }
}

package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
@AllArgsConstructor
public class LeetCodePage {
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

    public WebDriverComponents presenceOfElementLocatedByXPath() {
        return webDriverComponents.presenceOfElementLocatedByXPath(MAIN_IFRAME);
    }

    public WebDriverComponents findElementSignInWith() {
        return webDriverComponents.findElementByClassName(OR_YOU_CAN_SIGN_IN_WITH);
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
        return webDriverComponents.visibilityOfElementLocatedByLink(PROBLEMS).getElement();
    }

    public WebDriverComponents getLogo() {
        return webDriverComponents.findElementByClassName(LOGO);
    }

    public void clickTwoSum() {
        webDriverComponents.visibilityOfElementLocatedByLink(TWO_SUM).clickElement()
                .presenceOfElementLocatedByXPath(MAIN_IFRAME);
    }

    public WebDriverComponents getEasy() {
        return webDriverComponents.findElementByClassName(EASY);
    }
}

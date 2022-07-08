package Pages;

import WebDriver.WebDriverComponents;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

import static WebDriver.WebDriverComponents.*;

@Data
@AllArgsConstructor
public class LeetCodePage {
    WebDriverComponents webDriverComponents;
    private static final String CONTRIBUTE_PROMO = "//*[@id=\"contribute-promo\"]";
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

    @Step("Открытие главной страницы LeetCode")
    public void openPage() {
        webDriverComponents.openWebsite(WEBSITE);
    }

    @Step("Получение текста из главного оглавления страницы")
    public String getMainTitleText() {
        return webDriverComponents.presenceOfElementLocated(X_PATH, MAIN_IFRAME).getTitle();
    }

    @Step("Получение текста из запроса на вход")
    public String findElementSignInWith() {
        return webDriverComponents.findElement(CLASS_NAME, OR_YOU_CAN_SIGN_IN_WITH).getText();
    }

    @Step("Ввод логина и пароля")
    public WebDriverComponents loginPage() {
        return webDriverComponents.visibilityOfElementLocated(X_PATH, LOGIN)
                .clickAndSendKeys(LOGIN_NAME)
                .visibilityOfElementLocated(X_PATH, PASSWORD)
                .clickAndSendKeys(PASSWORD_NAME);
    }

    @Step("Подтверждение входа на сайт")
    public WebDriverComponents clickSignInBotton() {
        return webDriverComponents.presenceOfElementLocated(X_PATH, SIGN_IN_BOTTOM)
                .visibilityOfElementLocated(X_PATH, SIGN_IN_BOTTOM)
                .findElement(X_PATH, SIGN_IN_BOTTOM).clickElement();
    }


    @Step("Вход во вкладку задач")
    public WebElement getElemProblem() {
        return webDriverComponents.presenceOfElementLocated(PARTIAL_LINK_TEXT, PROBLEMS)
                .visibilityOfElementLocated(PARTIAL_LINK_TEXT, PROBLEMS).getElement();
    }

    @Step("Проверка на отображение основного лога")
    public boolean isLogoDisplayed() {
        return webDriverComponents.findElement(CLASS_NAME, LOGO).isDisplayed();
    }

    @Step("Подтверждение открытия основной задачи")
    public WebDriverComponents clickTwoSum() {
        return webDriverComponents.visibilityOfElementLocated(PARTIAL_LINK_TEXT, TWO_SUM).clickElement()
                .presenceOfElementLocated(X_PATH, MAIN_IFRAME);
    }

    @Step("Получение текста из уровня задачи")
    public String getEasyText() {
        return webDriverComponents.findElement(CLASS_NAME, EASY).getText();
    }

    @Step("Ожидание прогрузки основного фрейма")
    public void waitContributePromo() {
        webDriverComponents.visibilityOfElementLocated(X_PATH, CONTRIBUTE_PROMO);
    }
}

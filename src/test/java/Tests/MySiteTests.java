package Tests;

import Setups.MySiteTestsSetup;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MySiteTests extends MySiteTestsSetup {

    @Test
    @Order(1)
    public void oneTest() {
        leetCodePage.openPage();

        leetCodePage.presenceOfElementLocatedByXPath();

        leetCodePage.findElementSignInWith();

        leetCodePage.loginPage();

        leetCodePage.clickSignInBottom();

        leetCodePage.waitContributePromo();
    }

    @Test
    @Order(2)
    public void twoTest() {
        WebElement elem = leetCodePage.getElemProblem();

        leetCodePage.getLogo();

        elem.click();

        leetCodePage.clickTwoSum();

        leetCodePage.getEasy();
    }

    @Test
    @Order(3)
    public void threeTest() {
        googlePage.openGoogle().clickEndSendMassage();

        googlePage.getMainElem();

        googlePage.pressEnter();

        googlePage.getLogo();

        googlePage.getImageOne();
    }

    @Test
    @Order(4)
    public void fourTest() {
        googlePage.sendNewMassage();

        googlePage.checkToVisible();

        googlePage.checkToHidden();

        googlePage.getImageTwo();
    }
}
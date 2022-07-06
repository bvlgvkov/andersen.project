package org.example;

import Setups.CRMTestsSetup;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRMTests extends CRMTestsSetup {
    @Test
    @Order(1)
    public void oneTest() {
        saucePage.openPage();

        saucePage.loginPage().clickButton();

        saucePage.imageOneIsDisplayed();

        saucePage.findObjectOne();

        saucePage.getShoppingCard();

        saucePage.acceptPurchase();

        saucePage.imageTwoIsDisplayed();

        saucePage.fillPersonalData();

        saucePage.getFinish();

        saucePage.clickFinishIdButton();
    }

    @Test
    @Order(2)
    public void twoTest() {
        notePadPage.openWebsite();

        notePadPage.getTabNav();

        notePadPage.getDeleteDraft();

        notePadPage.setPassword();

        notePadPage.createUrl();

        notePadPage.getTempAttribute();
    }
}
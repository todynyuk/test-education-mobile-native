package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTest implements IAbstractTest {

    @Test()
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testDrawingAndFindByPicture() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        BurgerMenuPageBase burgerMenu = productListPage.clickOnBurgerMenu();
        DrawingPageBase drawingScreen = burgerMenu.clickOnDrawingButton();
//        Assert.assertTrue(drawingScreen.isEmptyPadPresent(), "Drawing area is not empty.");
        drawingScreen.drawPicture();
//        Assert.assertTrue(drawingScreen.isDrawingPresent(), "There is no drawing found.");
//        drawingScreen.clickClearBtn();
//        Assert.assertTrue(drawingScreen.isEmptyPadPresent(), "Drawing area is not cleared");
    }
}

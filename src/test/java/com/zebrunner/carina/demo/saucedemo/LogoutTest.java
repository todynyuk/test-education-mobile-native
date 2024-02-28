package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest implements IAbstractTest, IMobileUtils {

    @Test()
    @TestCaseKey("CR2-9")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLogout() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        BurgerMenuPageBase burgerMenu = productListPage.clickOnBurgerMenu();
        Assert.assertTrue(burgerMenu.isLogoutPresent(), "Logout button isn't presented");
        burgerMenu.clickOnLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button isn't opened");
    }
}

package com.zebrunner.carina.demo.saucedemo;


import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest, IMobileUtils {

    @Test()
    @TestCaseKey("CR2-1")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUserWithValidCredentials() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
    }

    @Test()
    @TestCaseKey("CR2-2")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUserWithLockedCredentials() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLoginMessagePresent(), "Error message isn't presented");
    }

    @Test()
    @TestCaseKey("CR2-3")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUserWithInvalidCredentials() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        loginPage.login("hkvhvh", "hgvkvkghk");
        Assert.assertTrue(loginPage.isLoginMessagePresent(), "Error message isn't presented");
    }
}

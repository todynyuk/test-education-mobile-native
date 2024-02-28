package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PLPTest implements IAbstractTest {

    @Test()
    @TestCaseKey("CR2-4")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testSortProductsFromLowToHigh() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickOnDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(productListPage.isPriceSortedLowToHigh(), "Prices aren't sorted from low to high");
    }

    @Test()
    @TestCaseKey("CR2-5")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testSortProductsFromHighToLow() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickOnDropdownMenu(SortDropdown.HIGH_TO_LOW);
        Assert.assertTrue(productListPage.isPriceSortedHighToLow(), "Prices aren't sorted from high to low");
    }

    @Test()
    @TestCaseKey("CR2-10")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testSortProductsFromAtoZ() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickOnDropdownMenu(SortDropdown.AZ);
        Assert.assertTrue(productListPage.isItemsFilteredFromAToZ(), "Prices aren't sorted from A to Z");
    }
}

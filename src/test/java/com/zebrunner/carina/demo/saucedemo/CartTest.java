package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {

    @Test()
    @TestCaseKey("CR2-4")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testAddToCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickAddToCartButtonEnum(ProductName.BACKPACK);
        CartPageBase cart = productListPage.clickOnCartButton();
        Assert.assertTrue(cart.isItemNameTextPresent(ProductName.BACKPACK), "Item name isn't presented in the cart");
    }

    @Test()
    @TestCaseKey("CR2-4")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testRemoveFromCart() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickAddToCartButtonEnum(ProductName.BACKPACK);
        CartPageBase cart = productListPage.clickOnCartButton();
        Assert.assertTrue(cart.isItemNameTextPresent(ProductName.BACKPACK), "Item name isn't presented in the cart");
        cart.removeItemFromCart(ProductName.BACKPACK);
        Assert.assertFalse(cart.isItemNameTextPresent(ProductName.BACKPACK), "Item name is presented in the cart");
    }
}

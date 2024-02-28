package com.zebrunner.carina.demo.saucedemo;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutTotalInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutDeliveryDataPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.SuccessOrderPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest implements IAbstractTest {
    @Test()
    @TestCaseKey("CR2-8")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCheckout() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        ProductListPageBase productListPage = loginPage.autofillLogin();
        Assert.assertTrue(productListPage.isBurgerMenuPresent(), "Burger menu isn't presented");
        productListPage.clickAddToCartButtonEnum(ProductName.BACKPACK);
        CartPageBase cartPage = productListPage.clickOnCartButton();
        Assert.assertTrue(cartPage.isItemNameTextPresent(ProductName.BACKPACK), "Item name isn't presented in the cart");
        CheckoutTotalInfoPageBase checkoutInfoPage = cartPage.clickOnCheckoutInfoButton();
        checkoutInfoPage.typeUserInformation("Emma", "Watson", "555355");
        CheckoutDeliveryDataPageBase checkoutOverviewPage = checkoutInfoPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isTotalPricePresent(), "Total price isn't presented");
        SuccessOrderPageBase orderCompletionPage = checkoutOverviewPage.clickOnFinishButton();
        Assert.assertTrue(orderCompletionPage.isCompleteTitlePresent(), "Title text isn't presented");
    }
}

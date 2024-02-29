package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutTotalInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement cartItemName;

    @FindBy(xpath = "//*[contains(@text,'%s')]/../following-sibling::*[@content-desc='test-Price']//*[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartButtonByName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeItemFromCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public int getItemsListSize() {
        return 0;
    }

    @Override
    public boolean isItemNameTextPresent(ProductName productName) {
        return cartItemName.format(productName.getProductType()).isElementPresent();
    }

    @Override
    public void removeItemFromCart(ProductName productName) {
        removeItemFromCartButtonByName.format(productName.getProductType()).click();
    }

    @Override
    public void removeAllItemsFromCart() {
        while (removeItemFromCartButton.isElementPresent()){
            removeItemFromCartButton.click();
        }
    }

    @Override
    public CheckoutTotalInfoPageBase clickOnCheckoutInfoButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutTotalInfoPageBase.class);
    }
}

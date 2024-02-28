package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutTotalInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement cartItemName;

    @ExtendedFindBy(iosPredicate = "name == 'test-REMOVE'")
    private ExtendedWebElement removeItemFromCartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='%s']/../following-sibling::XCUIElementTypeOther[@name='test-Price']")
    private ExtendedWebElement removeItemFromCartButtonByName;

//    @FindBy(xpath = "")
//    private ExtendedWebElement removeItemFromCartButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-CHECKOUT'")
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
    public void removeItemsFromCart() {
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

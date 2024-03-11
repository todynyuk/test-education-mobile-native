package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutDeliveryDataPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.SuccessOrderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutDeliveryDataPageBase.class)
public class CheckoutDeliveryDataPage extends CheckoutDeliveryDataPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Total')]")
    private ExtendedWebElement totalPrice;

    @ExtendedFindBy(iosPredicate = "name == 'test-FINISH'")
    private ExtendedWebElement finishButton;

    public CheckoutDeliveryDataPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTotalPricePresent() {
        swipe(finishButton);
        return totalPrice.isElementPresent();
    }

    @Override
    public SuccessOrderPageBase clickOnFinishButton() {
        finishButton.click();
        return initPage(getDriver(), SuccessOrderPageBase.class);
    }
}

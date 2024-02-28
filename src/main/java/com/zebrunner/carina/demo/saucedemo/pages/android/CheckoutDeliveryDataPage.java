package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutDeliveryDataPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.SuccessOrderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutDeliveryDataPageBase.class)
public class CheckoutDeliveryDataPage extends CheckoutDeliveryDataPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Total:')]")
    protected ExtendedWebElement totalPrice;

    @FindBy(xpath = "//android.widget.TextView[@text='FINISH']")
    protected ExtendedWebElement finishButton;

    public CheckoutDeliveryDataPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTotalPricePresent() {
        swipe(totalPrice);
        return totalPrice.isElementPresent();
    }

    @Override
    public SuccessOrderPageBase clickOnFinishButton() {
        finishButton.click();
        return initPage(getDriver(), SuccessOrderPageBase.class);
    }
}

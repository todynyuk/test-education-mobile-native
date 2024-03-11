package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.SuccessOrderPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SuccessOrderPageBase.class)
public class SuccessOrderPage extends SuccessOrderPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'THANK YOU FOR YOU ORDER'")
    private ExtendedWebElement completeTitle;

    public SuccessOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCompleteTitlePresent() {
        return completeTitle.isElementPresent();
    }
}

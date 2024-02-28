package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BurgerMenuPageBase.class)
public class BurgerMenuPage extends BurgerMenuPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-DRAWING']")
    private ExtendedWebElement drawingButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Close']")
    private ExtendedWebElement closeButton;

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoutPresent() {
        return logoutButton.isElementPresent(Duration.ofSeconds(3));
    }

    @Override
    public LoginPageBase clickOnLogoutButton() {
        logoutButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public DrawingPageBase clickOnDrawingButton() {
        return null;
    }
}

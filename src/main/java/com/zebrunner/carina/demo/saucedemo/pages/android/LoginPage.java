package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement loginInputField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath = "//android.widget.TextView[@text='standard_user']")
    private ExtendedWebElement autofillUserButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return loginButton.isElementPresent();
    }

    @Override
    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    @Override
    public boolean isLoginMessagePresent() {
        return errorMessage.isElementPresent();
    }

    @Override
    public ProductListPageBase login(String userName, String password) {
        loginInputField.type(userName);
        passwordInputField.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase autofillLogin() {
        swipe(autofillUserButton);
        autofillUserButton.click();
        loginButton.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }
}

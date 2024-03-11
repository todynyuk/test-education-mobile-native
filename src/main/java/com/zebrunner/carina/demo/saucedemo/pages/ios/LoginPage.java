package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'test-Username'")
    private ExtendedWebElement loginInputField;

    @ExtendedFindBy(iosPredicate = "name == 'test-Password'")
    private ExtendedWebElement passwordInputField;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGIN'")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Error message'")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(iosPredicate = "name == 'test-standard_user'")
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
        autofillUserButton.click();
        loginButton.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }
}

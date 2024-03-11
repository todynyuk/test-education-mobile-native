package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutTotalInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutDeliveryDataPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutTotalInfoPageBase.class)
public class CheckoutTotalInfoPage extends CheckoutTotalInfoPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private ExtendedWebElement firsNameInputField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private ExtendedWebElement lastNameInputField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement zipInputField;

    @FindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    private ExtendedWebElement continueButton;

    public CheckoutTotalInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUserInformation(String firstName, String lastName, String zip) {
        firsNameInputField.type(firstName);
        lastNameInputField.type(lastName);
        zipInputField.type(zip);
        Point point = new Point(zipInputField.getElement().getLocation().getX(), zipInputField.getElement().getLocation().getY());
        int x = point.getX() - 10;
        int y = point.getY() + 60;
        tap(x, y);
    }

    @Override
    public CheckoutDeliveryDataPageBase clickOnContinueButton() {
        continueButton.click();
        return initPage(getDriver(), CheckoutDeliveryDataPageBase.class);
    }
}

package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutTotalInfoPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CheckoutDeliveryDataPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutTotalInfoPageBase.class)
public class CheckoutTotalInfoPage extends CheckoutTotalInfoPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    private ExtendedWebElement firsNameInputField;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    private ExtendedWebElement lastNameInputField;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    private ExtendedWebElement zipInputField;

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
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
        tap(point.getX() - 10, point.getY() + 60);
    }

    @Override
    public CheckoutDeliveryDataPageBase clickOnContinueButton() {
        continueButton.click();
        return initPage(getDriver(), CheckoutDeliveryDataPageBase.class);
    }
}

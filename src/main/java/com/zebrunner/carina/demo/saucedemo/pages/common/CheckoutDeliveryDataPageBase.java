package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutDeliveryDataPageBase extends AbstractPage {
    public CheckoutDeliveryDataPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTotalPricePresent();

    public abstract SuccessOrderPageBase clickOnFinishButton();
}

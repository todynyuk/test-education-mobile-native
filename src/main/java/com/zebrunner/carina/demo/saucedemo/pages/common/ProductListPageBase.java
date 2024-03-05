package com.zebrunner.carina.demo.saucedemo.pages.common;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends AbstractPage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHeaderPresent();

    public abstract boolean isBurgerMenuPresent();

    public abstract void clickOnDropdownMenu(SortDropdown sortDropdown);

    public abstract void clickAddToCartButtonEnum(ProductName productName);

    public abstract CartPageBase clickOnCartButton();

    public abstract BurgerMenuPageBase clickOnBurgerMenu();

    public abstract boolean isPriceSortedLowToHigh();

    public abstract boolean isPriceSortedHighToLow();

    public abstract boolean isItemsFilteredFromAToZ();
}

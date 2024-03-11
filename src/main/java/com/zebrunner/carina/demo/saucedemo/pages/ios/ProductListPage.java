package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.google.common.collect.Comparators;
import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == 'test-Menu'")
    private ExtendedWebElement burgerMenuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Modal Selector Button'")
    private ExtendedWebElement filterButton;

    @ExtendedFindBy(iosPredicate = "name == '%s'")
    private ExtendedWebElement sortDropdownMenuButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title'")
    private List<ExtendedWebElement> itemsNameList;

    @ExtendedFindBy(iosPredicate = "name == 'test-Price'")
    private List<ExtendedWebElement> priceList;

    @ExtendedFindBy(iosPredicate = "name == 'test-Toggle'")
    private ExtendedWebElement itemsListViewButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title' and @label='%s']/../following-sibling::XCUIElementTypeOther//XCUIElementTypeOther[@name='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosPredicate = "name == 'Terms of Service | Privacy Policy'")
    private ExtendedWebElement footerCopyrightText;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHeaderPresent() {
        return false;
    }

    @Override
    public boolean isBurgerMenuPresent() {
        return burgerMenuButton.isElementPresent(Duration.ofSeconds(3));
    }

    @Override
    public BurgerMenuPageBase clickOnBurgerMenu() {
        burgerMenuButton.click();
        return initPage(getDriver(), BurgerMenuPageBase.class);
    }

    @Override
    public void clickOnDropdownMenu(SortDropdown sortDropdown) {
        filterButton.click();
        sortDropdownMenuButton.format(sortDropdown.getSortType()).click();
    }

    @Override
    public void clickAddToCartButtonEnum(ProductName productName) {
        addToCartButton.format(productName.getProductType()).click();
    }

    @Override
    public CartPageBase clickOnCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    private List<Double> getPricesList() {
        List<String> bufferPricesList = priceList.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
        List<Double> prices = bufferPricesList.stream()
                .map(product -> Double.parseDouble(product.replace("$", "")))
                .collect(Collectors.toList());
        return prices;
    }

    @Override
    public boolean isPriceSortedLowToHigh() {
        return Comparators.isInOrder(getPricesList(), Comparator.naturalOrder());
    }

    @Override
    public boolean isPriceSortedHighToLow() {
        return Comparators.isInOrder(getPricesList(), Comparator.reverseOrder());
    }

    @Override
    public boolean isItemsFilteredFromAToZ() {
        itemsListViewButton.click();
        List<String> newItemsList = new ArrayList<>();
        while (!footerCopyrightText.isElementPresent()) {
            for (ExtendedWebElement element : itemsNameList) {
                newItemsList.add(element.getAttribute("value"));
            }
            swipeUp(100);
        }
        List<String> bufferList = new ArrayList<>(newItemsList);
        Collections.sort(bufferList);
        return newItemsList.equals(bufferList);
    }
}

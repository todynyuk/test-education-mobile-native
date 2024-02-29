package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.enums.ProductName;
import com.zebrunner.carina.demo.saucedemo.enums.SortDropdown;
import com.zebrunner.carina.demo.saucedemo.pages.common.BurgerMenuPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.CartPageBase;
import com.zebrunner.carina.demo.saucedemo.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']")
    private ExtendedWebElement itemsListViewButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortDropdownMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<ExtendedWebElement> itemsNameList;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> priceList;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'%s')]/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Service | Privacy Policy']")
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
    public void clickOnDropdownMenu(SortDropdown sortDropdown) {
        filterButton.click();
        sortDropdownMenuButton.format(sortDropdown.getSortType()).click();
    }

    @Override
    public void clickAddToCartButtonEnum(ProductName productName) {
        swipe(addToCartButton.format(productName.getProductType()));//test it
        addToCartButton.format(productName.getProductType()).click();
    }

    @Override
    public CartPageBase clickOnCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public BurgerMenuPageBase clickOnBurgerMenu() {
        burgerMenuButton.click();
        return initPage(getDriver(), BurgerMenuPageBase.class);
    }

    private List<Double> getPricesList() {
        itemsListViewButton.click();
        List<Double> pricesList = new ArrayList<>();
        while (!footerCopyrightText.isElementPresent()) {
            for (ExtendedWebElement element : priceList) {
                double bufferElement = Double.parseDouble(element.getText().replace("$", ""));
                if (!pricesList.contains(bufferElement)) {
                    pricesList.add(bufferElement);
                }
            }
            swipeUp(500);
        }
        return pricesList;//working
//        Map<String, Double> itemNamesAndPricesList = new LinkedHashMap<>();
//        String bufferElementName;
//        double bufferElementPrice;
//        while (!footerCopyrightText.isElementPresent()) {
//            for (int i = 0; i < itemsNameList.size() - 1; i++) {
//                for (int j = 0; j < priceList.size() - 1; j++) {
////                    if(!priceList.get(j).isVisible(1)){
//////                        continue;
////                        swipeUp(1, 3000);
////                    }
////                    else {
//////                        swipeUp(1, 3000);
////                    }
//                    bufferElementName = itemsNameList.get(i).getText();
////                    System.out.println("bufferElementName: "+bufferElementName);
//                    bufferElementPrice = Double.parseDouble(priceList.get(j).getText().replace("$", ""));
////                    System.out.println("bufferElementPrice: "+bufferElementPrice);
//                    itemNamesAndPricesList.put(bufferElementName, bufferElementPrice);
////                    String a = "Test.allTheThings() T-Shirt (Red)";
////                    boolean test = itemNamesAndPricesList.containsKey(a);
////                    System.out.println("test: "+test);
//                    if (!itemNamesAndPricesList.containsKey(bufferElementName)&&!itemNamesAndPricesList.containsValue(bufferElementPrice)) {//partly working
//                        itemNamesAndPricesList.put(bufferElementName, bufferElementPrice);//4
//                        // itemNamesAndPricesList: {Sauce Labs Onesie=7.99, Sauce Labs Bike Light=9.99, Sauce Labs Bolt T-Shirt=15.99, Sauce Labs Backpack=29.99}
//                        //pricesList: [7.99, 9.99, 15.99, 29.99]
//                    }
//                    else {
//                        continue;
//                    }
//                }
//            }
//            swipeUp(1, 3000);
//        }
//        System.out.println("itemNamesAndPricesList: " + itemNamesAndPricesList);
//        List<Double> pricesList = new ArrayList<>(itemNamesAndPricesList.values());
//        System.out.println("pricesList: " + pricesList);
//        return pricesList;

    }


    @Override
    public boolean isPriceSortedLowToHigh() {
        boolean result = false;
        List<Double> pricesList = getPricesList();

        for (int i = 0; i < pricesList.size() - 1; i++) {
            result = (pricesList.get(i) < pricesList.get(i + 1));
        }
        return result;
    }

    @Override
    public boolean isPriceSortedHighToLow() {
        boolean result = false;
        List<Double> pricesList = getPricesList();
        for (int i = 0; i < pricesList.size() - 1; i++) {
            result = (pricesList.get(i) > pricesList.get(i + 1));
        }
        return result;
    }

    @Override
    public boolean isItemsFilteredFromAToZ() {
        List<String> newItemsList = new ArrayList<>();
        itemsListViewButton.click();
        while (!footerCopyrightText.isElementPresent()) {
            for (ExtendedWebElement element : itemsNameList) {
                String bufferElement = element.getText();
                if (!newItemsList.contains(bufferElement)) {
                    newItemsList.add(bufferElement);
                }
            }
            swipeUp(500);
        }
        List<String> bufferList = new ArrayList<>(newItemsList);
        Collections.sort(bufferList);
        return newItemsList.equals(bufferList);
    }
}

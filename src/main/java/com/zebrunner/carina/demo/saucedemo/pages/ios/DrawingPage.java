package com.zebrunner.carina.demo.saucedemo.pages.ios;

import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.Setting;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CLEAR'`]")
    private ExtendedWebElement clearBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Signature Pad demo'`]")
    private ExtendedWebElement signaturePad;

    @ExtendedFindBy(image = "")
    private ExtendedWebElement emptyDrawingArea;

    @ExtendedFindBy(image = "")
    private ExtendedWebElement drawing;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX;
        int startY;
        int endX;
    }

    @Override
    public void clickClearBtn() {
        clearBtn.click();
    }

    @Override
    public boolean isEmptyPadPresent() {
        return emptyDrawingArea.isElementPresent();
    }

    @Override
    public boolean isDrawingPresent() {
        return drawing.isElementPresent();
    }
}

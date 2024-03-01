package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.Setting;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(image = "img/empty_drawing_area.png")
    private ExtendedWebElement emptyDrawingArea;

    @ExtendedFindBy(image = "img/drawing.png")
    private ExtendedWebElement drawing;

    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    private ExtendedWebElement signaturePad;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CLEAR']")
    private ExtendedWebElement clearButton;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX = position.x + size.width / 10;
        System.out.println("startX: " + startX);
        int startY = position.y + size.height / 10;
        System.out.println("startY: " + startY);
        int endX = startX * 5;
        System.out.println("endX: " + endX);
        tap(startX, startY);
        int pixelCount = 0;
        for (int i = 0; i < 30; i++) {
            swipe(startX, startY + pixelCount, endX, startY+pixelCount, 200);
            pixelCount++;
        }
    }

    @Override
    public void clickClearBtn() {
        clearButton.click();
    }

    @Override
    public boolean isEmptyPadPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return emptyDrawingArea.isElementPresent();
    }

    @Override
    public boolean isDrawingPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.5);
        return drawing.isElementPresent();
    }
}

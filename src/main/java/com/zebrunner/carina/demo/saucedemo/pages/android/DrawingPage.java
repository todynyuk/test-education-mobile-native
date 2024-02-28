package com.zebrunner.carina.demo.saucedemo.pages.android;

import com.zebrunner.carina.demo.saucedemo.pages.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {
    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
    }

    @Override
    public void clickClearBtn() {
    }

    @Override
    public boolean isEmptyPadPresent() {
        return false;
    }

    @Override
    public boolean isDrawingPresent() {
        return false;
    }
}

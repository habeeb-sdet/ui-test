package org.habeeb.automation.pages;

import org.habeeb.automation.constants.TimeOuts;
import org.habeeb.automation.drivermanager.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWaitUtils {

    private WebDriverWait getWebDriverWait(int waitTime){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitTime));
    }

    public WebElement waitForElementToBeVisible(By locator){
        return getWebDriverWait(TimeOuts.ELEMENT_WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator){
        return getWebDriverWait(TimeOuts.ELEMENT_WAIT_TIME)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }


}

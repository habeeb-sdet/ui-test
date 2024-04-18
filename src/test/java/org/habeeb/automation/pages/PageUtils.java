package org.habeeb.automation.pages;

import io.cucumber.java.en.Given;
import org.habeeb.automation.constants.URL;
import org.habeeb.automation.drivermanager.Driver;
import org.openqa.selenium.By;

import static org.habeeb.automation.constants.URL.HEROKU_APP_FORMY_PROJECT;
import static org.habeeb.automation.constants.URL.SAUCE_LAB_DEMO_APP;

public class PageUtils extends ElementWaitUtils{

    public void type(By locator, String value){
        waitForElementToBeVisible(locator).sendKeys(value);
    }

    public void click(By locator){
        waitForElementToBeClickable(locator).click();
    }

    public boolean isDisplayed(By locator){
        try{
            return waitForElementToBeVisible(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isSelected(By locator){
        try{
            return waitForElementToBeVisible(locator).isSelected();
        }catch (Exception e){
            return false;
        }
    }

    private void waitFor(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getUrlToLoad(String siteName){
        siteName = siteName.replace(" ", "_").toUpperCase();
        switch (URL.valueOf(siteName)){
            case HEROKU_APP_FORMY_PROJECT: return HEROKU_APP_FORMY_PROJECT.getUrl();
            case SAUCE_LAB_DEMO_APP: return SAUCE_LAB_DEMO_APP.getUrl();
            default: throw new RuntimeException("Site name " + siteName + " is invalid");
        }
    }
}

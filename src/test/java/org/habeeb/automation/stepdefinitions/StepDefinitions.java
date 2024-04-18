package org.habeeb.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import org.habeeb.automation.constants.URL;
import org.habeeb.automation.drivermanager.Driver;

import static org.habeeb.automation.constants.URL.HEROKU_APP_FORMY_PROJECT;
import static org.habeeb.automation.constants.URL.SAUCE_LAB_DEMO_APP;

public class StepDefinitions {

    @Given("User navigates to {string} site")
    public void navigateToSite(String siteName){
        System.out.println(Thread.currentThread().getName() + " : Navigates to " + siteName + " page");
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String urlToLoad = getUrlToLoad(siteName);
        if(!currentUrl.endsWith(urlToLoad)){
            Driver.getDriver().get(urlToLoad);
        }else {
            Driver.getDriver().navigate().refresh();
        }
        waitFor();


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

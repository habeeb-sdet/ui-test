package org.habeeb.automation.pages.herokuapp;

import io.cucumber.java.en.Given;
import org.habeeb.automation.pages.PageUtils;
import org.openqa.selenium.By;

public class HomePage extends PageUtils {

    @Given("User clicks and navigate to {string} page")
    public void clickAndNavigateTo(String pageToGo){
        By locator = By.cssSelector(".jumbotron-fluid [href*='" + pageToGo.toLowerCase() + "']");
        click(locator);
    }
}

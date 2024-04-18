package org.habeeb.automation.pages.saucelab;

import io.cucumber.java.en.Given;
import org.habeeb.automation.pages.PageUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LogInPage extends PageUtils {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    @Given("User enters {string} and {string}")
    public void enterUsername(String username, String password){
        System.out.println("Entering username : " + username + ", password : " + password);
        type(this.username, username);
        type(this.password, password);
    }

    @Given("User click on login button")
    public void clickLoginButton(){
        System.out.println("Clicking log-in button");
        click(this.loginButton);
    }

    @Given("Error message should be displayed")
    public void validateErrorMessage(){
        Assert.assertTrue(isDisplayed(this.errorMessage));
    }

}

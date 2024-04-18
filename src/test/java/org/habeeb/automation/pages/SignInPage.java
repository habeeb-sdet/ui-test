package org.habeeb.automation.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class SignInPage {

    private By emailOrPhoneNumber = By.id("ap_email");
    private By password = By.id("ap_password");
    private By continueBtn = By.cssSelector("#continue[type='submit']");
    private By signInBtn = By.id("signInSubmit");


}

package org.habeeb.automation.pages;

import org.openqa.selenium.By;

public class HomePage {

//    private By accountsAndLogIn = By.xpath("//span[text()='Account & Lists']");
    private By accountsAndLogIn = By.id("nav-link-accountList");
    private By signIn = By.cssSelector("#nav-flyout-ya-signin a[href*='signin']");

}

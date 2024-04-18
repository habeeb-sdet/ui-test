package org.habeeb.automation.pages.herokuapp;

import io.cucumber.java.en.Given;
import org.habeeb.automation.pages.PageUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Checkboxes extends PageUtils {

    @Given("User clicks on {string}")
    public void performCheckboxOperation(String checkbox){
        checkbox = checkbox.replace("Checkbox", "checkbox-");
        By locator = By.id(checkbox);
        click(locator);
    }

    @Given("{string} selection status should be {string}")
    public void validateCheckboxStatus(String checkbox, String status){
        checkbox = checkbox.replace("Checkbox", "checkbox-");
        By locator = By.id(checkbox);
        if(Boolean.parseBoolean(status)){
            Assert.assertTrue(isSelected(locator));
        }else {
            Assert.assertFalse(isSelected(locator));
        }
    }
}

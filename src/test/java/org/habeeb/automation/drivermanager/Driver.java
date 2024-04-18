package org.habeeb.automation.drivermanager;

import org.habeeb.automation.constants.TimeOuts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 11");
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOuts.PAGE_LOAD_WAIT_TIME));
        webDriverThreadLocal.set(webDriver);
    }

    public static WebDriver getDriver(){
//        if(webDriverThreadLocal.get() == null){
//            try {
//                initializeDriver();
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return webDriverThreadLocal.get();
    }

    public static void quitDriver(){
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }


}

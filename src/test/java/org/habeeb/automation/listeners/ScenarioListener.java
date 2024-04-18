package org.habeeb.automation.listeners;

import org.habeeb.automation.drivermanager.Driver;
import org.testng.IClassListener;
import org.testng.IConfigurationListener;
import org.testng.ITestClass;

import java.net.MalformedURLException;

public class ScenarioListener implements IClassListener,IConfigurationListener {

    @Override
    public void onBeforeClass(ITestClass testClass) {
//        System.out.println("Starting driver");
//        try {
//            Driver.initializeDriver();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
//        System.out.println("Quitting driver session");
//        Driver.quitDriver();
    }
}

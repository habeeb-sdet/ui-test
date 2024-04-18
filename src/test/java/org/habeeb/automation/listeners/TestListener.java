package org.habeeb.automation.listeners;

import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Started test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @BeforeTest
    public void onStart(ITestContext context){
        /*String featurePath = context.getCurrentXmlTest().getParameter("feature");
        String[] features = featurePath.contains(",") ? featurePath.split(",") : new String [] {featurePath};
        Class<?> testClass = TestRunner.class;
        try {
            changeCucumberAnnotation(testClass, features);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        // This is not working, since this changes the features value in CucumberOptions Annotation during multi threading
    }

    private void changeCucumberAnnotation(Class<?> clazz, Object newValue) throws Exception{
        Annotation options = clazz.getAnnotation(CucumberOptions.class);                   //get the CucumberOptions annotation
        InvocationHandler proxyHandler = Proxy.getInvocationHandler(options);              //setup handler so we can update Annotation using reflection. Basically creates a proxy for the Cucumber Options class
        Field f = proxyHandler.getClass().getDeclaredField("memberValues");          //the annotaton key/values are stored in the memberValues field
        f.setAccessible(true);                                                             //suppress any access issues when looking at f
        Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler);      //get the key-value map for the proxy
        memberValues.remove("features");                                              //remove the key entry...don't worry, we'll add it back
        memberValues.put("features",newValue);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

}

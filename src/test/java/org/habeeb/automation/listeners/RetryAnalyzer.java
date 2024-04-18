package org.habeeb.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int maxRetry=0;
    int count=0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if(count < maxRetry){
                count++;
                return true;
            }
        }

        return false;
    }
}

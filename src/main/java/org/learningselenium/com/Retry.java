package org.learningselenium.com;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int retrycount = 0;
    int maxtry = 4;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()&& retrycount<maxtry)
        {
            retrycount++;
            return true;
        }
        return false;
    }
}

package org.learning.com;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestNgBase implements ITestListener {

    static RemoteWebDriver driver;
    static int i;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Browser is about to launch");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        File temp = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temp, new File("C:\\Users\\Owner\\workspace\\learningautomation\\screenshots\\failurescreenshot "+i+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();}
        i++;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test cases got executed sucessfully");
    }

    @Override
    public void onFinish(ITestContext context) {
        driver.quit();
    }
}

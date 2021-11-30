package org.learning.com;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class Baseclass {

    RemoteWebDriver driver;
    ExtentReports extent;
    ExtentHtmlReporter reporter;
    ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        reporter = new ExtentHtmlReporter("C:\\Users\\Owner\\workspace\\learningautomation\\test-output\\automationreport.html");
        //reporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS", "windows");
        extent.setSystemInfo("Browser", "Chrome");
        /*reporter.config().setChartVisibilityOnOpen(true);
        reporter.config().setDocumentTitle("Extent Report Demo");
        reporter.config().setReportName("Test Report");
        reporter.config().setTestViewChartLocation(ChartLocation.TOP);
        reporter.config().setTheme(Theme.STANDARD);
        //reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");*/
    }

    public int takeSnap() throws IOException {
        int ranNum = (int) (Math.random() * 999999 + 9999999);

        File source = driver.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\img" + ranNum + ".png");
        FileUtils.copyFile(source, target);

        return ranNum;
    }


    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
            test.pass("captured screenshot", MediaEntityBuilder.createScreenCaptureFromPath(".././Screenshots/img" + takeSnap() + ".png").build());
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }


    @BeforeClass
    public void setTest() {
        test = extent.createTest("Testcase", "functional cases");

    }

    @AfterTest
    public void method1() {

        extent.flush();
    }

}

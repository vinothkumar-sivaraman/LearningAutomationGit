package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


public class Reporter {

    public RemoteWebDriver driver;
    public ExtentReports extent;
    public ExtentHtmlReporter reporter;
    public ExtentTest test;

    @BeforeSuite
    public void beforeSuite()
    {
        reporter = new ExtentHtmlReporter("C:\\Users\\Owner\\workspace\\learningautomation\\test-output\\extentreport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS","Windows");
        extent.setSystemInfo("Browser","Chrome");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException, InterruptedException {
        if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));
            test.pass("caputre screenshot", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\img" + takeSnap() + ".png").build());
        }else if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
        }else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }

    @BeforeClass
    public void beforeClass()
    {
       // test = extent.createTest("TestCase","selenium cases");
    }

    @AfterTest()
    public void afterTest()
    {
        extent.flush();
    }

    public int takeSnap() throws IOException, InterruptedException {
        int v = (int)(Math.random() * 999999 + 999999);
        File memory = driver.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        File target = new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\img" + v + ".png");
        //FileUtils.copyFile(memory, new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\img" + v + ".png"));
        FileUtils.copyFile(memory,target);
        return v;
    }
}


package org.learning.com;

import Utils.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ReporterRun extends Reporter {

    @Test
    public void faceBook()
    {
        test = extent.createTest("TestCase","selenium cases");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        System.out.println("facebook launched");
        test.assignCategory("Smoke Testing");
    }

    @Test
    public void faceBookFail()
    {
        test = extent.createTest("TestCase1","selenium cases");
        test.assignCategory("Smoke Testing");
        Assert.assertTrue(false);

    }

    @Test
    public void faceBookSkip()
    {
        test = extent.createTest("TestCase2","selenium cases");
        System.out.println("skipping test cases");
        test.assignCategory("Smoke Testing");
        throw new SkipException("skipping this test case");
    }

}

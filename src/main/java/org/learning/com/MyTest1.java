package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyTest1 extends Baseclass {

    @Test(invocationCount = 3)
    public void test1() throws IOException {
     //test = extent.createTest("Test case 1","Passed test case");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://gmail.com");
        test.createNode("method 1", "test case for printing it");
        test.assignCategory("Functional testing");

    }


    @Test
    public void test2()
    {
        test = extent.createTest("Test case 2","failure test case");
        test.assignCategory("Functional testing");
        Assert.assertTrue(false);
    }

    @Test()
    public void test3()
    {
        test = extent.createTest("Test case 3","skipp test case");
        test.assignCategory("Functional testing");
        throw new SkipException("skipping this test case");

    }


}

package org.learning.com;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ctest3 extends BeforeandAfter{


    @Test(groups = {"FunctionalTest"})
    public void test1() {

        driver.get("http://gmail.com");
        Reporter.log("Browser Launched");
        driver.manage().window().maximize();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://www.gmail.com");
    }

    @Test(groups = {"RegressionTest"})
    public void test2() {
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "facebook");
    }
}

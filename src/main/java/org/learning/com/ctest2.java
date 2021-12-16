package org.learning.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ctest2 extends BeforeandAfter{

    @Test(groups = {"FunctionalTest"})
    public void test5(){

        driver.get("https://www.bestbuy.com");
        driver.manage().window().maximize();
        String Website = driver.getCurrentUrl();
        Assert.assertEquals(Website,"https://www.bestbuy.com/");

    }

    @Test(groups = {"RegressionTest"})

    public void test6(){

        driver.get("https://www.target.com");
        driver.manage().window().maximize();
        String targetSite = driver.getCurrentUrl();
        Assert.assertEquals(targetSite,"Target");

    }
}

package org.learningselenium.com;

import org.apache.commons.exec.OS;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Problem5 {

    @Test(priority = 1,enabled = false)
    public void case1() {
        System.out.println("case1 method");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"case1"})
    public void case2() {
        System.out.println("case2 method");
    }

    @Test(expectedExceptions = Exception.class)
    public void case3() {
        System.out.println("case3 method");
        int a = 10;
        int b = 0;
        System.out.println("value");
        System.out.println("the value is"+b);
        int c = a/b;
        if (System.getProperty("os.name").equals("windows"))
        {
            System.out.println(System.getProperty("os.name"));
        }

    }
}

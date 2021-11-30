package org.learning.com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoA {

    @BeforeMethod
    public void methodA()
    {
        System.out.println("I am before method");
    }

    @Test
    public void test()
    {
        System.out.println("Testng installed1");
    }


    @Test
    public void test1()
    {
        System.out.println("Testng installed");
        String url = null;

    }

    @AfterMethod
    public void methodB()
    {
        System.out.println("I am after method");
    }
}

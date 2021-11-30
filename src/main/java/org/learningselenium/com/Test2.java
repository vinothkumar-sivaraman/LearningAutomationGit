package org.learningselenium.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {

    @BeforeMethod
    public void methodBefore()
    {
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("after method");
    }


    @Test(priority = -2)
    public void case1()
    {
        System.out.println("case1");
    }

    @Test(priority = 1)
    public void case2()
    {
        System.out.println("case2");
    }

    @Test(priority = 0)
    public void case3()
    {
        System.out.println("case3");
    }



}

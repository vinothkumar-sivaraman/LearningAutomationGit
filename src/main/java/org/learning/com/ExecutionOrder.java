package org.learning.com;

import org.testng.annotations.*;

public class ExecutionOrder {

    @BeforeSuite
    public void first()
    {
        System.out.println("before suite");
    }

    @AfterSuite
    public void last()
    {
        System.out.println("after suite");
    }

    @BeforeTest
    public void firstTest()
    {
        System.out.println("before test");
    }


    @AfterTest
    public void afterTest()
    {
        System.out.println("after test");
    }


    @BeforeClass
    public void class1()
    {
        System.out.println("before class");
    }

    @AfterClass
    public void class2()
    {
        System.out.println("after class");
    }

    @BeforeMethod
    public void method1()
    {
        System.out.println("before method");
    }

    @AfterMethod
    public void method2()
    {
        System.out.println("after method");
    }

    @Test
    public void myTest()
    {
        System.out.println("@Test1");
    }

    @Test
    public void myTest1()
    {
        System.out.println("@Test2");
    }

}

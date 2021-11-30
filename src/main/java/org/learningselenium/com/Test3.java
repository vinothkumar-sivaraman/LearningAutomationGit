package org.learningselenium.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {

    @Test(groups = {"Prioritycases"})
    public void testA()
    {
        System.out.println("testa method from priority group");
    }

    @Test(groups = {"smokecases"})
    public void testB()
    {
        System.out.println("test B method");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "testB")
    public void testC()
    {
        System.out.println("test c method from priority group");
    }

    @Test(enabled = false)
    public void testD()
    {
        System.out.println("test d method");
    }
}

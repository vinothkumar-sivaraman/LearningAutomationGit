package org.learningselenium.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Problem6 {

    @Test(groups = {"cases"})
    public void run1()
    {
        System.out.println("run1");
    }

    @Test
    public void run2()
    {
        System.out.println("run2");
    }

    @Test(dependsOnGroups = {"cases.*"})
    public void run3()
    {
        System.out.println("run3");
    }

    @Test(groups = {"cases"})
    public void run4()
    {
        System.out.println("run4");
        Assert.assertTrue(false);
    }
}

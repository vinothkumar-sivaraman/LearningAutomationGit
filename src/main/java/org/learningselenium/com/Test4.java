package org.learningselenium.com;

import org.testng.annotations.Test;

public class Test4 {

    @Test(groups = {"Prioritycases"})
    public void testE()
    {
        System.out.println("testE method from priority group");
    }

    @Test(groups = {"smokecases"})
    public void testF()
    {
        System.out.println("test F method");
    }

    @Test(groups = {"Prioritycases"})
    public void testG()
    {
        System.out.println("test G method from priority group");
    }

    @Test
    public void testH()
    {
        System.out.println("test H method");
    }
}

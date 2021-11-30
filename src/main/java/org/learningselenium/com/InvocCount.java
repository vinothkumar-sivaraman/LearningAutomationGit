package org.learningselenium.com;

import org.testng.annotations.Test;

public class InvocCount {

    @Test(invocationCount = 4)
    public void methodA()
    {
        System.out.println("method A got invoked");
    }

    @Test
    public void methodB()
    {
        System.out.println("method B got invoked");
    }
}

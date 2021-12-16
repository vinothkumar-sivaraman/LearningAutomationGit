package org.learningselenium.com;

import Utils.ReusableMethods;
import org.testng.annotations.Test;

import java.io.IOException;

public class FrameWorkIntro {

    @Test
    public void frameworkTest() throws IOException {
        ReusableMethods reusableMethods = new ReusableMethods();
        reusableMethods.beforeInvokeBrowser( reusableMethods.readPropertyFile("url"));
        reusableMethods.clickByUsingXpath(reusableMethods.readPropertyFile("newaccount"));
        reusableMethods.dropdownMethodUsingIndex(reusableMethods.readPropertyFile("monthdropdown"),2);
        reusableMethods.dropdownMethodUsingIndex(reusableMethods.readPropertyFile("daydropdown"),5);


    }
}

package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {

    private static ChromeDriver driver;

    @BeforeMethod
    public void beforeInvokeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("https://amazon.com");
        Reporter.log("browser launched");
        driver.manage().window().maximize();
        Reporter.log("winow maximized");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.amazon.com/");
    }

    @Test
    public void test2() {
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("facebook", "facebook");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }


}

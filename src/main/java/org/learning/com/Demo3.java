package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo3
{
    private static ChromeDriver driver;

    public static void add()
    {
        System.out.println("addtion method");
    }

    @BeforeMethod
    public void beforeInvokeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void zest() {
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        String currentUrl = driver.getCurrentUrl();
        add();
        Assert.assertEquals(currentUrl, "https://www.amazon.com/");
    }

    @Test
    public void test2() {
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "facebook");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

}

package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Problem2 {

    public static ChromeDriver obj;

    static int i=0;
    public static void screenshot() {
        File temp = obj.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temp, new File("C:\\Users\\koloral\\IdeaProjects\\INTRODUCTION\\Screenshots\\screenshot"+i+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();}
        i++;
    }
    @BeforeMethod
    public void Beforemethod() {
        WebDriverManager.chromedriver().setup();
        obj = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        obj.get("https://www.flipkart.com/");
        Reporter.log("Browser launched");
        obj.manage().window().maximize();
        Reporter.log("Browser Maximized");
        obj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        screenshot();
        obj.findElementByXPath("//button[@class='_2KpZ6l _2doB4z']").click(); //CLOSE ALERT MESSAGE
        obj.findElementByXPath("//input[@type='text']").sendKeys("Home Theatres", Keys.ENTER); //SEARCH FOR HOMETHEATRES
        obj.findElementByXPath("//div[text()='4★ & above']").click();//CLICK 4 AND ABOVE
        obj.findElementByXPath("//div[text()='Price -- High to Low']").click(); //CLICK PRICE HIGH TO LOW
        Thread.sleep(Long.parseLong("2000"));
        List<WebElement> price = obj.findElementsByXPath("//div[@class='_30jeq3']");
        System.out.println("Number of products " + price.size()); //TOTAL PRODUCT COUNTS
        Reporter.log("Number of products :40");

        for (WebElement web : price) {
            System.out.println(web.getText());
        } //PRINT ALL PRICES
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("1st and 2nd products price: ");
        for (int i = 0; i < price.size(); i++) {
            if (i < 2) {
                System.out.println(price.get(i).getText());
            }
        }

        String product1 = price.get(0).getText();
        System.out.println("1st product price: " + product1);
        String product2 = price.get(1).getText();
        System.out.println("2nd product price:  " + product2);

        obj.findElementByXPath("//img[@class='_396cs4 _3exPp9']").click();  //click on 1st prodcut

        String windowHandle = obj.getWindowHandle();
        Set<String> windowHandles = obj.getWindowHandles();
        for (String window : windowHandles) {
            obj.switchTo().window(window);
        }
        String price1 = obj.findElementByXPath("//div[@class='_30jeq3 _16Jk6d']").getText();
        System.out.println("1st product price " + price1);
        Assert.assertEquals(price1, product1);  //product 1 validation
        if (product1.equals(price1)) {
            System.out.println("product1 prices matched  " + price1);
        } else {
            System.out.println("product1 prices not matched");
        }
        Reporter.log("product prices Matched");
        obj.findElementByXPath("//label[@class='_6Up2sF']").click(); //click compare
        // obj.findElementByXPath("//label[@class=' _3hShhO']").click();
        obj.close();
        obj.switchTo().window(windowHandle);
        System.out.println("Back to parent window: " + obj.getCurrentUrl());
        Thread.sleep(Long.parseLong("3000"));

        obj.findElementByXPath("//*[@id='container']/div/div[3]/div/div[2]/div[2]/div/div[2]/div/a[2]").click(); //click on 2nd product
        String windowHandle2 = obj.getWindowHandle();
        Set<String> windowHandles2 = obj.getWindowHandles();
        for (String window2 : windowHandles2) {
            obj.switchTo().window(window2);
        }
        String price2 = obj.findElementByXPath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div").getText();
        System.out.println("2nd product price " + price2);
        Assert.assertEquals(price2, product2);  //product 2 validation
        if (product2.equals(price2)) {
            System.out.println("product2 prices matched " + price2);
        } else {
            System.out.println("product2 prices not matched");
        }
        obj.findElementByXPath("//label[@class='_6Up2sF']").click(); //click compare
        obj.findElementByXPath("//span[@class='_3hShhO']").click(); //compare on bottom RIGHT
        String url = obj.getCurrentUrl();
        if (obj.getCurrentUrl().contains("compare")) {
            System.out.println(" URL has word compare");
        } else {
            System.out.println(" URL has NO word compare");
        }
        Thread.sleep(Long.parseLong("3000"));
        File temp = obj.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temp, new File("C:\\Users\\koloral\\IdeaProjects\\INTRODUCTION\\Screenshots\\testng.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(url.contains("compare"));
        obj.close();
        obj.switchTo().window(windowHandle);
        System.out.println("Back to parent window: " + obj.getCurrentUrl());
        Thread.sleep(5000);
        Reporter.log("I am HAPPY");
    }

    @AfterTest
    public void aftermethod() {
        obj.quit();
    }
}

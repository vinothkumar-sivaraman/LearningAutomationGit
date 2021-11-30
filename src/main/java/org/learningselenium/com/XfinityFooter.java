package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class XfinityFooter {
    static ChromeDriver driver;
    static int i;

    public static void screeshot() throws IOException {
        File src = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\snap " + i + ".jpeg"));
        i++;
    }

    public static WebElement getElementWithIndex(By by, int index)
    {
        WebElement element = driver.findElement(By.className("xc-footer--panels"));
        List<WebElement> elements = element.findElements(By.tagName("a"));
        return elements.get(index);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://my.xfinity.com/?cid=cust");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String mainPageUrl = driver.getCurrentUrl();
        List<WebElement> footerLinks = driver.findElementsByXPath("//ul[@class='xc-footer--list']//li/a");
        WebElement element = driver.findElement(By.className("xc-footer--panels"));
        List<WebElement> elements = element.findElements(By.tagName("a"));
        int sizeOfAllLinks= elements.size();
        for (int index=1; index<sizeOfAllLinks; index++ )
        {
            getElementWithIndex(By.tagName("a"), index).click();
            driver.navigate().back();
            Thread.sleep(2000);
            System.out.println(driver.getCurrentUrl());
        }




        System.out.println("total number of footerlinks"+footerLinks.size());
        for(WebElement footerLink: footerLinks)
        {
            if(footerLinks.size() == 0)
            {
                System.out.println("do nothing");
            }
            try {
                footerLink.click();
            } catch (Exception e) {
                System.out.println("Handled exception while clicking on link");
            }
            System.out.println(driver.getCurrentUrl());
            driver.navigate().back();
            Thread.sleep(2000);
        }


    }

}
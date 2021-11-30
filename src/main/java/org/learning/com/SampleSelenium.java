package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleSelenium {

    static ChromeDriver driver;
    static int i =0;


    public static void screeshot() throws IOException {
        File src = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\image "+i+".jpeg"));
        i++;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://my.xfinity.com/?cid=cust");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> headerElements = driver.findElementsByXPath("/li[@class=/'xc-header--navigation-li']");
        List<WebElement> elementByXPath = driver.findElementsByXPath("//li[@class='xc-header--personal-li']");
        List<WebElement> headers = driver.findElementsByXPath("//li[@class='xc-header--slim-navigation-li']");
        WebElement signIn = driver.findElement(By.xpath("(//a[text()='Sign In'])[2]"));

        headerElements.addAll(elementByXPath);
        headerElements.addAll(headers);
        headerElements.add(signIn);
        System.out.println(headerElements.size());
        Actions actions = new Actions(driver);
        for(WebElement headerElement: headerElements) {
            String text = headerElement.getText();
            int i = Integer.parseInt(text);
            System.out.println(i);
        }
        driver.close();
    }
}
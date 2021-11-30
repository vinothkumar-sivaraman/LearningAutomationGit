package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Xfinity {

    static ChromeDriver driver;
    static int i = 0;


    public static void screeshot() throws IOException {
        File src = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\Owner\\workspace\\learningautomation\\Screenshots\\snap " + i + ".jpeg"));
        i++;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://my.xfinity.com/?cid=cust");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> headerElements = driver.findElementsByXPath("//div[@class='xc-header--container-nav']//li");
        Actions actions = new Actions(driver);
        for (WebElement headerElement : headerElements) {
            try {
                System.out.println(headerElement.getText());
                actions.moveToElement(headerElement).perform();
                Thread.sleep(2000);
                screeshot();
            } catch (Exception e) {
                System.out.println("Exception Handled for "+headerElement.getText());
            }
        }
        driver.close();

    }
}
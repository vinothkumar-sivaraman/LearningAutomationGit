package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class XfinityFooter2 {

    static ChromeDriver driver;


    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://my.xfinity.com/?cid=cust");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String mainPageUrl = driver.getCurrentUrl();
        String mainWindow = driver.getWindowHandle();
        List<WebElement> footerLinks = driver.findElementsByXPath("(//a[@class='xc-footer--link'])");
        System.out.println("Total no of links " + footerLinks.size());

/*        for(int j=1;j<footerLinks.size();j++)
        {
            String href = driver.findElementByXPath("(//a[@class='xc-footer--link'])[" + j + "]").getAttribute("href");
            System.out.println(href);
        }*/

        for (int i = 1; i < footerLinks.size(); i++) {
            try {

                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@class='xc-footer--link'])[\"+i+\"]"))));
            } catch (Exception e) {
                driver.navigate().to(mainPageUrl);
            }
            String currentUrl = null;
            try {
                driver.findElementByXPath("(//a[@class='xc-footer--link'])[" + i + "]").click();
                int size = driver.getWindowHandles().size();
                if (size > 1) {
                    Set<String> windowHandles = driver.getWindowHandles();
                    for (String winhandle : windowHandles) {
                        driver.switchTo().window(winhandle);
                        currentUrl = driver.getCurrentUrl();
                        System.out.println(currentUrl);
                        driver.close();
                        driver.switchTo().window(mainWindow);
                    }
                } else {
                    currentUrl = driver.getCurrentUrl();
                }
            } catch (Exception e) {
                driver.navigate().to(mainPageUrl);
            }
            System.out.println(currentUrl);
            driver.navigate().back();
            Thread.sleep(2000);
        }
        driver.close();
    }
}
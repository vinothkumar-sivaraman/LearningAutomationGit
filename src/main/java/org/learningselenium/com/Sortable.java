package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Sortable {

    @Test
    public void sortTest()
    {
    /*    WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> sortElements = driver.findElementsByXPath("//div[@class='vertical-list-container mt-4']/div");
        WebElement src = sortElements.get(0);
        WebElement target = sortElements.get(3);
        Actions act = new Actions(driver);
        act.click(src).clickAndHold().moveToElement(target).release().build().perform();
        //act.contextClick().moveToElement("src",10,20).click().build().perform();
        act.doubleClick(src).perform();
        act.pause(2000).perform();
        driver.get("https://demoqa.com/selectable"); // click
        String property = System.getProperty("os.name");
        System.out.println(property);

        if(property.contains("windows"))
        {
            driver.findElementByXPath("vci").click();
        }else if(property.equals("macos"))
        {
            Set<String> windowHandles = driver.getWindowHandles();
            for(String winhandle:windowHandles)
            {
                driver.switchTo().window(winhandle);
                driver.findElementByXPath("vci").click();
            }
        }*/

        int i = 3;
        while(i<8)
        {
            System.out.println(i);

        }


    }
}

package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Flipkart {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementByXPath("//button[@class='_2KpZ6l _2doB4z']").click();
        driver.findElementByName("q").sendKeys("Home Theaters", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElementByXPath("(//div[@class='_3879cV' and contains(text(),'above')])[1]").click();
        driver.findElementByXPath("(//div[@class='_10UF8M'])[3]").click();
        Thread.sleep(3000);
        WebElement path = driver.findElementByXPath("(//div[@class='_13oc-S'])[1]/div[1]//a[1]");
        driver.executeScript("arguments[0].click();", path);
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> window = new ArrayList<>(windowHandles);
        driver.switchTo().window(window.get(1));
        driver.findElementByXPath("//label[text()='Compare']").click();
        driver.findElementByXPath("//a[@class='_11o22n']").click();

        int size = driver.findElementsByXPath("//*[@class='_30jeq3']").size();
        List<WebElement> hometheaterprices = driver.findElementsByXPath("//*[@class='_30jeq3']"); // 40 values of hometheater prices
        for(WebElement hometheater: hometheaterprices)
        {
            String text = hometheater.getText();
            int i = Integer.parseInt(text);
            int total = 0;
            total = total + i;


        }



    }
}

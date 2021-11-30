package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseEvents {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElementsByXPath("//div[@class='vertical-list-container mt-4']/div");
        WebElement src = list.get(0);
        WebElement target = list.get(3);
        Actions act = new Actions(driver);
        act.click(src).clickAndHold().moveToElement(target).release().build().perform();

    }
}

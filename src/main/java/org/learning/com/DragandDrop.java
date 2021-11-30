package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragandDrop {

    @Test
    public void dragAndDrop()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement src = driver.findElementById("draggable");
        WebElement target = driver.findElementById("droppable");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src,target).perform();

    }
}

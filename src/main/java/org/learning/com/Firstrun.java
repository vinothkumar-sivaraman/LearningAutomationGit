package org.learning.com;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Firstrun {

    @Test
    public void test() throws InterruptedException {
        System.out.println("first run");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/resizable");

        driver.executeScript("window.scrollBy(0,150)");
        Thread.sleep(3000);
        WebElement elementByXPath = driver.findElementByXPath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]");
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementByXPath,500,300).perform();
    }

    @Test
    public void run2()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement elementByClassName = driver.findElementByClassName("main-header");
        Actions actions = new Actions(driver);
        actions.doubleClick(elementByClassName).perform();
        actions.pause(5000).perform();
        actions.click(elementByClassName).perform();


    }
}

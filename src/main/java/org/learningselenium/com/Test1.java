package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public static void main(String[] args) {

        WebDriverManager.iedriver().setup();
        InternetExplorerDriver driver = new InternetExplorerDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("messageWindowButton").click();
        String parent = driver.getWindowHandle();
        System.out.println(driver.getWindowHandles().size());
        Set<String> handles = driver.getWindowHandles();
        List<String> handle = new ArrayList<>(handles);
        driver.switchTo().window(handle.get(1));
        //driver.close();
        String text = driver.findElementByTagName("body").getAttribute("body");
        System.out.println(text);
        driver.close();

    }
}

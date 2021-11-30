package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SortandSele {

    @Test
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        Actions mouseAction = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/resizable/");
        driver.findElementByXPath("//a[text()='Selectable']").click();
        driver.switchTo().frame(0);
        List<WebElement> elementList = driver.findElementsByXPath("//ol[@id='selectable']/li");
        elementList.get(0).click();
        mouseAction.keyDown(Keys.COMMAND).perform();
        elementList.get(6).click();
        mouseAction.release().perform();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();

        //Sortable
        driver.findElementByXPath("//a[text()='Sortable']").click();
        int size = driver.getWindowHandles().size();
        System.out.println("window size" + size);
       /* Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
        }*/
        driver.executeScript("window.scrollTo(0,150)");
        driver.switchTo().frame(0);
        List<WebElement> sortableElements = driver.findElementsByXPath("//*[@id='sortable']/li");
        WebElement source = sortableElements.get(0);
        WebElement target = sortableElements.get(6);
        WebElement source1 = sortableElements.get(6);
        WebElement target1 = sortableElements.get(1);
        mouseAction.click(source).clickAndHold().moveToElement(target).moveByOffset(0, 10).release().build().perform();
        mouseAction.click(source1).clickAndHold().moveToElement(target1).moveByOffset(0, 10).release().build().perform();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();


    }

}


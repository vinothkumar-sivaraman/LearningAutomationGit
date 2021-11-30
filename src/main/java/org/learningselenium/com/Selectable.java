package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selectable {

    @Test
    public void selectTest()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/selectable");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.executeScript("window.scrollBy(0,150)");
        List<WebElement> selectElements = driver.findElementsByXPath("//ul[@id='verticalListContainer']/li");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
        selectElements.get(0).click();
        selectElements.get(1).click();

        for(int i=0; i<selectElements.size();i++)
        {
            if(i==5&&i==6){
                selectElements.get(i).click();
                break;
            }

        }

        for(WebElement element: selectElements)
        {
            element.click();
        }

    }
}

package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyTest2 {

    @Test
    public void A()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("twotabsearchtextbox").sendKeys("chairs");
        List<WebElement> suggestions = driver.findElementsByXPath("//div[@id='suggestions']/div");
        System.out.println(suggestions.size());

        for(int i =0;i<suggestions.size();i++)
        {
            System.out.println(suggestions.get(i).getText());
            if(suggestions.get(i).getText().equals("chairs for kids"))
            {
                suggestions.get(i).click();
                break;
            }

        }

    }
}

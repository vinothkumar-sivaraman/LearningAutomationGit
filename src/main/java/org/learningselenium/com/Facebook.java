package org.learningselenium.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;


public class Facebook {

    @Test(retryAnalyzer = Retry.class)
    public void faceBook()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        System.out.println("facebook launched");
        driver.quit();
    }
}

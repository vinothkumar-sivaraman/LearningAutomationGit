package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeandAfter {

    public RemoteWebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void invokeBrowser() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser () {

        driver.quit();
    }
}

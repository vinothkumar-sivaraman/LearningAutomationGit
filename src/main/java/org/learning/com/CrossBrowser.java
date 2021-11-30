package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestNgBase.class)
public class CrossBrowser {


    @Test
    @Parameters("browsername")
    public void multipleBrowserTest(String browsername)
    {
       if(browsername.equals("chrome"))
       {
           WebDriverManager.chromedriver().setup();
           ChromeDriver driver= new ChromeDriver();
           driver.get("https://gmail.com");
           driver.manage().window().maximize();
           System.out.println("gmail launched");
       }else if(browsername.equals("edge"))
       {
           WebDriverManager.edgedriver().setup();
           EdgeDriver driver= new EdgeDriver();
           try {
               driver.get("https://facebook.com");
           }catch (Exception e)
           {

           }
           //driver.manage().window().maximize();
           System.out.println("facebook launched");
       }

    }
}

package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multiplebrowsertest {


    @Test
    @Parameters("browsername")
    public void multipleBrowserTest(String browsername)
    {
       if(browsername.equals("chrome"))
       {
           WebDriverManager.chromedriver().setup();
           ChromeDriver driver= new ChromeDriver();
           driver.get("https://amazon.com");
           driver.manage().window().maximize();
           System.out.println("gmail launched");
       }else if(browsername.equals("edge"))
       {
           WebDriverManager.edgedriver().setup();
           EdgeDriver driver= new EdgeDriver();
           driver.get("https://amazon.com");
           //driver.manage().window().maximize();
           System.out.println("facebook launched");
       }

    }
}

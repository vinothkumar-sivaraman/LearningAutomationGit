package org.learning.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.learning.com.TestNgBase.driver;

@Listeners(TestNgBase.class)
public class Myntra{

    static int i = 0;
    ChromeOptions options = new ChromeOptions();


    public static void screenshot() throws IOException {
        File memory = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(memory, new File("C:\\Users\\koloral\\IdeaProjects\\INTRODUCTION\\Screenshots\\myntra " + i + ".jpg"));
        i++;
    }

    @BeforeMethod
    public void beforemethod() {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test()  throws InterruptedException, IOException {
        driver.get("https://www.myntra.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementByXPath("//input[@class='desktop-searchBar']").sendKeys("sunglasses", Keys.ENTER);
        Thread.sleep(5000);

        WebElement scroll = driver.findElementByXPath("//div[@class='brand-more']");
        scroll.click();
        driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("polaroid");
        driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();
        driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

        WebElement elementByXPath = driver.findElementByXPath("(//h4[@class='atsa-title'])[3]");
        driver.executeScript("arguments[0].click();", elementByXPath);// modified selenium click to java script click.
        driver.findElementByXPath("//ul[@class='atsa-values']/li[5]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("(//h4[@class='atsa-title'])[7]").click();
        Thread.sleep(2000);
        WebElement elementByXPath1 = driver.findElementByXPath("//input[@type='checkbox' and @value='4.0 TO 5.0']"); // modified xpath and written java script  click
        driver.executeScript("arguments[0].click();", elementByXPath1);
        Thread.sleep(2000);
        WebElement elementByXPath2 = driver.findElementByXPath("//h4[@class='atsa-title' and text()='Face Shape']");
        driver.executeScript("arguments[0].click();", elementByXPath2);
        Thread.sleep(2000);
        WebElement elementByXPath3 = driver.findElementByXPath("//input[@type='checkbox' and @value='Square']");
        driver.executeScript("arguments[0].click();", elementByXPath3);
        Thread.sleep(2000);
        driver.findElementByXPath("//img[@class='img-responsive']").click();
        //after clicking it is opening new window. Leaving this to you to switch window and getting the price and name.
        Set<String> windowHandles = driver.getWindowHandles();  // added this piece of code
        for (String winhandle : windowHandles) {
            driver.switchTo().window(winhandle);
        }
        WebElement productname = driver.findElementByXPath("//h1[@class='pdp-name']");
        String p1 = productname.getText();
        WebElement productprice = driver.findElementByXPath("//span[@class='pdp-price']");
        String p2 = productprice.getText();
        System.out.println("Product name: " + p1);
        System.out.println("Product price: " + p2);
        Thread.sleep(5000);
        try {
            screenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}


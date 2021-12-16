package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReusableMethods {

    RemoteWebDriver driver;

    public void beforeInvokeBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void clickByUsingID(String element)
    {
        driver.findElementById(element).click();
    }

    public void dropdownMethodUsingIndex(String element, int number)
    {
        Select obj = new Select(driver.findElementByXPath(element));
        obj.selectByIndex(number);

    }

    public void identifyFrameUsingIndex(int number)
    {
        driver.switchTo().frame(number);
    }

    public String readPropertyFile(String value) throws IOException {
        FileReader obj = new FileReader("TestData/credentials.properties");
        Properties properties = new Properties();
        properties.load(obj);
        return properties.getProperty(value);
    }



    public void clickByUsingXpath(String element)
    {
        driver.findElementByXPath(element).click();
    }


}

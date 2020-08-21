/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.qatopicstest.ListnersConfig;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.testng.Assert.*;
import org.testng.IClassListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 *
 * @author hp
 */
@Listeners(ListnersConfig.class)
public class SeleniumGridTest {
   // WebDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException
    {
        
    }
    
    @AfterClass
    public void teardown()
    {
     //  tearDownDriver();
    }
    @Test
    public void test() throws MalformedURLException
    {
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\GIT CHROME DRIVER\\chromedriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
    //  cap.setCapability("browserName","chrome");
      cap.setPlatform(Platform.WINDOWS);
     
        ChromeOptions op = new ChromeOptions();
        op.merge(cap);
        URL url = new URL("http://192.168.29.83:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.google.com");
    }
    
}

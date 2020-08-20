/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import PageObjects.JSONReader;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author hp
 */
public class utilityFunctions extends Methods {
    JSONReader find = new JSONReader();
    public static  WebDriver driver;
   static Random randomNo = new Random();
   
    
    //To intialize the driver
    public void intial()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\GIT CHROME DRIVER\\chromedriver.exe");
		 driver = new ChromeDriver();
                 maximize();
    }
    
    //To quit the driver
    public void tearDownDriver()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
    //To maximize the browser
    public void maximize()
    {
        driver.manage().window().maximize();
    }
    
    
    //DropDownTest function utilities
    
    public boolean dropdownguru()
    {
        
        driver.get(find.element("urlDropDown"));
        maximize();
        try{
        Select dropdownCountry=new Select(chooseElement("CSS",find.element("CountryCSS")));
       
       
        dropdownCountry.selectByVisibleText("INDIA");
        dropdownCountry.selectByValue("GREENLAND");
          
       return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
        
        
        
    }
    
    //Multiple Select in dropdown using Select
    public boolean MultipleSelect()
    {
        driver.get(find.element("MultipleSelectURL"));
        maximize();
        Select elements = new Select(chooseElement("ID",find.element("FruitsID")));
        if(elements.isMultiple())
        {
            elements.selectByVisibleText("Apple");
            elements.selectByIndex(3);
            elements.selectByVisibleText("Orange");
            System.out.println(elements.getAllSelectedOptions());
           
           return true;
            
        }
        else
            return false;
    }
//to take screenShots
    public static void takeScreenshot() 
    {
        try{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File fileStored=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileStored,new File("E:\\QA Daily Task\\QATopics20-8-2020\\QATopicsTest\\screenshots"+randomNo.nextInt(5000)+".jpg"));
        }
        catch(IOException e)
        {
            System.out.println("error in scrrenShort");
        }
        }
    
    
    //to find color of element
    public String colorOf()
    {
        driver.get(find.element("FBURL"));
       return colorOfElement(chooseElement("CSS",find.element("ElementFindColor")));
    }
    
    
    //Scrolling feature using JS Exceutor
    public void scrollofPage()
    {
        driver.get(find.element("QAURL"));
        maximize();
        JavascriptExecutor scrollPage= (JavascriptExecutor)driver;
       scrollPage.executeScript("window.scrollBy(0,350)");
        
                
    }
    
    public boolean hoverandclick()
    {
       
            driver.get(find.element("QAURL"));
        
        maximize();
     Actions   action= new Actions(driver);
        action.moveToElement(chooseElement("XPATH",find.element("ServicesXPATH"))).build().perform();
        chooseElement("XPATH",find.element("DataScienceXPATH")).click();
        if(driver.getTitle().equals("Big data Data Science Data Mining Services | QA InfoTech"))
            return true;
        else
           return false;
        
    }
    public boolean dragdrop()
    {
       
        driver.get(find.element("dropWebsite"));
        WebElement drag = chooseElement("CSS",find.element("draggable1"));
       WebElement drop = chooseElement("CSS",find.element("droppable1"));
      
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
     Actions   act = new Actions(driver);
         try{
        act.clickAndHold(drag).moveToElement(drop).release().build().perform();
        return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    //Double click
    public boolean Double1Click()
    {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions act = new Actions(driver);
        WebElement dclick = chooseElement("CSS",find.element("doubleClickCSS"));
        try{
        act.doubleClick(dclick).build().perform();
        driver.switchTo().alert().accept();
        return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
        
    }
    
    //Right Click
    public boolean rightClick()
    {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions act = new Actions(driver);
        try{
        WebElement we = chooseElement("CSS",find.element("rightClickclassCSS"));
        act.contextClick(we).build().perform();
        
        return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    
    //Explicit Wiat
    public void ExplicitWait()
    {
        //For a element to be waited for but with a limit of 10 seconds
        //Not advisable in such cases because its a hard wait
        WebDriverWait we = new WebDriverWait(driver, 10);
        we.until(ExpectedConditions.visibilityOfElementLocated(By.id("statedropdown")));
                
    }
    
    
    
    //BrokenLinksCheck
    public String BrokenLinks()
    {
        driver.get(find.element("QAURL"));
        List al = chooseElements("CSS",find.element("linksTotalCSS"));
        Iterator<WebElement> it = al.iterator();
        String url="";
        HttpURLConnection huc = null;
        int respCode = 200;
        while(it.hasNext())
        {
           url = it.next().getAttribute("href");
           try{
               huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
           }
           catch(Exception e)
           {
               
               
           }
           if(respCode>=400)
           {
               break;
           }
            
        }
        if(respCode>=400)
            return "error";
        else
            return "fine";
    }
    
 
    
}

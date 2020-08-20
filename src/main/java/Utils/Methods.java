/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;




import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author hp
 */
public class Methods{
  //  JiomartUtils jio = new JiomartUtils();
  
    
    

    public WebElement chooseElement(String byStrategy, String locatorValue) {
        By by = null;
        
        switch (byStrategy) {
        case "ID":
            by = By.id(locatorValue);
            break;
        case "CLASS":
            by = By.className(locatorValue);
            break;
        case "LINKTEXT":
            by = By.linkText(locatorValue);
            break;
        case "XPATH":
            by = By.xpath(locatorValue);
            break;
        case "CSS":
            by = By.cssSelector(locatorValue);
            break;
        case "TAGNAME":
            by = By.tagName(locatorValue);
            break;
        }
        
        return utilityFunctions.driver.findElement(by);
    }
    public List<WebElement> chooseElements(String byStrategy, String locatorValue) {
        By by = null;
        
        switch (byStrategy) {
        case "ID":
            by = By.id(locatorValue);
            break;
        case "CLASS":
            by = By.className(locatorValue);
            break;
        case "LINKTEXT":
            by = By.linkText(locatorValue);
            break;
        case "XPATH":
            by = By.xpath(locatorValue);
            break;
        case "CSS":
            by = By.cssSelector(locatorValue);
            break;
        case "TAGNAME":
            by = By.tagName(locatorValue);
            break;
        }
        
        return utilityFunctions.driver.findElements(by);
    }
   
    public String colorOfElement(WebElement element)
    {
      return  element.getCssValue("background-color");
    }

    
}

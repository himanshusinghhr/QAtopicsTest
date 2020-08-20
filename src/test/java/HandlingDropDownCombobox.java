/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utils.utilityFunctions;
import com.mycompany.qatopicstest.ListnersConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.ITestListener;
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
public class HandlingDropDownCombobox extends utilityFunctions{
    
    @BeforeClass
    public void setup()
    {
        intial();
    }
    
    @AfterClass
    public void teardown()
    {
      //  tearDownDriver();
    }

    
    
    @Test(testName = "TC001",description = "DropDownTest")
    public void dropdown()
    {
        
        assertFalse(dropdownguru());
        
    }
    @Test(testName = "TC002",description = "Multiple Select")
    public void multipleSelectDropDown()
    {
        assertTrue(MultipleSelect());
    }
    
    
    @Test(testName = "TC003",description = "Color of elements")
    public void color()
    {
        assertEquals(colorOf(),"rgba(24, 119, 242, 1)");
    }
    
    @Test(testName = "TC003",description = "Scrolling feature of web page")
    public void scroll()
    {
        scrollofPage();
    }
    
    @Test(testName = "TC004",description = "Hover")
    public void hover()
    {
        assertTrue(hoverandclick());
    }
    
    @Test(testName = "TC005",description = "Double Clic and alert Handle")
    public void doubleClick()
    {
        assertTrue(Double1Click());
    }
    @Test(testName = "TC006",description = "Right Click")
    public void rClick()
    {
        assertTrue(rightClick());
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObjects;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author hp
 */
public class JSONReader {
     public JSONObject jo ;
    public JSONReader() 
    {
        try{
    Object obj = new JSONParser().parse(new FileReader("E:\\QA Daily Task\\QATopics20-8-2020\\QATopicsTest\\src\\main\\java\\PageObjects\\PageObjectJson.json"));
        this.jo = (JSONObject) obj;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String element(String element)
    {
       return jo.get(element).toString();
    }
    
}

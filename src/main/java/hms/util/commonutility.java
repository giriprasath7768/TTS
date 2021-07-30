package hms.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hms.base.testbase;

public class commonutility extends testbase {

	public static void fileupload(String loc)
	{
	
		//file Location to upload
	      StringSelection sel = new StringSelection(loc);
//Copy to clipboard
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
	      
 //Create object of Robot class
	      Robot robot;
		try {
			robot = new Robot();
			 // Press Enter
		      robot.keyPress(KeyEvent.VK_ENTER);
		      
		     // Release Enter
		      robot.keyRelease(KeyEvent.VK_ENTER);
		      
		       // Press CTRL+V
		      robot.keyPress(KeyEvent.VK_CONTROL);
		      robot.keyPress(KeyEvent.VK_V);
		      
		     // Release CTRL+V
		      robot.keyRelease(KeyEvent.VK_CONTROL);
		      robot.keyRelease(KeyEvent.VK_V);
		      //Thread.sleep(1000);
		             
		     //Press Enter 
		      robot.keyPress(KeyEvent.VK_ENTER);
		      robot.keyRelease(KeyEvent.VK_ENTER);
				
			
			
			
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	           
	      
		
		
	}
	
	//script for mouse click
	public static void mouseclick(WebElement el)
	{
		Actions action=new Actions(driver);
		action.click(el).build().perform();
	}
	
	
	
	public static void takescreenshot()
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destination=new File(currentDir+"./Screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(scrFile,destination );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.util.WebEventListener;

public class testbase {
	public static WebDriver driver;
	public static Properties pop;
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener webel;
	
	public testbase()
	{
		pop=new Properties();
		
		try {
			FileInputStream ipconfig=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/hms/cofiguration/cofigura.properties");
			pop.load(ipconfig);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 // script for initialization method
	 public static void initialization()
	 {
		 String browserName=pop.getProperty("browser");
		 
		 if(browserName.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");	
			 driver = new ChromeDriver(); 
			 
		 }else if(browserName.equals("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");	
				driver = new FirefoxDriver();  
		 }
		//basic methods
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(pop.getProperty("url"));
		//Firing event
		e_driver=new EventFiringWebDriver(driver);
		webel=new WebEventListener();
		e_driver.register(webel);
		driver=e_driver;
		 
	
	 }
	
	
	//Explicit wait
			public void ewait(WebElement el)
			{
				WebDriverWait wait=new WebDriverWait(driver, 70);
				wait.until(ExpectedConditions.visibilityOf(el));
				
			}
	
	
	
	

}

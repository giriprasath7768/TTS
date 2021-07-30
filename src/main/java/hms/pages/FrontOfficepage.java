package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class FrontOfficepage extends testbase{
	@FindBy(xpath="//h3[contains(text(),'Appointment Details')]")WebElement tableName;
	@FindBy(xpath="//a[contains(text(),'Visitor Book')]")WebElement visitorbook;
	public FrontOfficepage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public boolean fftablename()
	{
		return tableName.isDisplayed();
		
	}
	 public vistorpage clickvistor()
	 {
		 visitorbook.click();
		return new vistorpage();
		 
	 }
	
	
}

package hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class Loginpage extends testbase{

	@FindBy(css="input#email")WebElement uname;
	@FindBy(css="input#password")WebElement upass;
	@FindBy(tagName="img")WebElement HMSlogo;
	@FindBy(linkText="Forgot Password?")WebElement fpass;
	@FindBy(className="btn")WebElement lbttn;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}

//To verify page title
	public String Verifypagetitle() {
		
		return driver.getTitle();
		
	}
//To verfiy Logo
	public boolean verifylogo()
	{
		return HMSlogo.isDisplayed();
		
	}
//To verify login
	public dashboardpage login(String Username,String Password)
	{
		uname.sendKeys(Username);
		upass.sendKeys(Password);
		lbttn.click();
		return new dashboardpage();
		
	}

}

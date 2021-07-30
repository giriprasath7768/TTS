package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class dashboardpage extends testbase{
	
	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(xpath="//h4[contains(text(),'Super Admin')]")WebElement userNameLabel;
	@FindBy(css="ul.sidebar-menu>li")WebElement frontoffice;
	
	public dashboardpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
//click on profile
	public boolean verifyCorrectUserName()
	{
		profile.click();
		ewait(userNameLabel);
		
		return userNameLabel.isDisplayed();
	}
	
	public FrontOfficepage clickff()
	{
		frontoffice.click();
		return new FrontOfficepage();
	}
	
	

}

package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.testbase;
import hms.util.Datepicker;
import hms.util.commonutility;

public class vistorpage extends testbase {
	Datepicker dat=new Datepicker();
	
	@FindBy(xpath="//h3[contains(text(),'Visitor List')]")WebElement tableName;
	@FindBy(xpath="//a[contains(text(),'Add Visitor')]")WebElement Addvisitor;
	@FindBy(xpath="//h4[contains(text(),'Add Visitor')]")WebElement Advscreentitle;
	@FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/select[1]")WebElement drppurpose;
	@FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/input[1]")WebElement vname;
	@FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")WebElement vphone;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/input[1]")WebElement Vidcard;	
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/input[1]")WebElement vnp;
    @FindBy(xpath="//input[@id='date']")WebElement vdat;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")WebElement vintime;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")WebElement vouttime;
    @FindBy(xpath="//textarea[@id='description']")WebElement vnote;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[6]/div[1]/div[1]/input[1]")WebElement vupload;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[2]/form[1]/div[2]/button[1]")WebElement vsavebtt;
    @FindBy(xpath="//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]12")WebElement vsclose;
    
    public vistorpage()
	{
		PageFactory.initElements(driver, this);
	}
    
	public boolean vbtableTitle(){
		return tableName.isDisplayed();
	}
	
	
	public void clickonaddvistor()
	{
		Addvisitor.click();
		
	}
	
	public boolean advTitle(){
		ewait(Advscreentitle);
		return Advscreentitle.isDisplayed();
	}
	public void addvisitdetails(String data[])
	{
		Select drp=new Select(drppurpose);
		drp.selectByVisibleText(data[0]);
		vname.sendKeys(data[1]);
		vphone.sendKeys(data[2]);
		Vidcard.sendKeys(data[3]);
		vnp.sendKeys(data[4]);
		vdat.click();
		dat.datpicker(data[5]);
		vnote.sendKeys(data[6]);
		commonutility.mouseclick(vupload);
		commonutility.fileupload("D:\\fileupload\\Bug_0027.docx");
		
		vsclose.click();
	}
}

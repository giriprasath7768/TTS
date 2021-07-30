package HMS.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.FrontOfficepage;
import hms.pages.Loginpage;
import hms.pages.dashboardpage;
import hms.pages.vistorpage;
import hms.util.ReadExcel;

public class Visitortest extends testbase {
	Loginpage objlog;
	dashboardpage objdash;
	FrontOfficepage objff;
	vistorpage objvs;
	String sheetname="vistor";
	public Visitortest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		objdash=objlog.login(pop.getProperty("username"),pop.getProperty("password"));
		objff=objdash.clickff();
		objvs=objff.clickvistor();
		
	}
	@DataProvider
	public Object[][] getvisdata()
	{
		Object data[][]=ReadExcel.getTestData(sheetname);
		return data;	
		
	}
	
	
	@Test(dataProvider="getvisdata")
	public void addvistordetails(String args[])
	{
		Assert.assertTrue(objvs.vbtableTitle());
		objvs.clickonaddvistor();
		Assert.assertTrue(objvs.advTitle());
		objvs.addvisitdetails(args);
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}

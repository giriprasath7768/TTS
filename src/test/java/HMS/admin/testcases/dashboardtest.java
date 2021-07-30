package HMS.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;
import hms.pages.dashboardpage;

public class dashboardtest extends testbase {
	
	Loginpage objlog;
	dashboardpage objdash;
	
	public dashboardtest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		objlog=new Loginpage();
		//objdash=new dashboardpage();
		objdash=objlog.login(pop.getProperty("username"),pop.getProperty("password"));
				
	}
	
	@Test
	public void dashboardtest()
	{
		Assert.assertTrue(objdash.verifyCorrectUserName());
		objdash.clickff();
	}

	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
}

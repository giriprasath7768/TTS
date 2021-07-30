package HMS.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.FrontOfficepage;
import hms.pages.Loginpage;
import hms.pages.dashboardpage;

public class frontofficetest extends testbase {
	
	Loginpage objlog;
	dashboardpage objdash;
	FrontOfficepage objff;

	public frontofficetest() {
		super();
	}

@BeforeClass
public void setup()
{
	initialization();
	objlog=new Loginpage();
	objdash=objlog.login(pop.getProperty("username"),pop.getProperty("password"));
	objff=objdash.clickff();	
}
@Test
public void frontofficetest()
{
	Assert.assertTrue(objff.fftablename());
	objff.clickvistor();
}

@AfterClass
public void teardown()
{
	driver.close();
}



	
	
	
}

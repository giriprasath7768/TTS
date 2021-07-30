package HMS.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;

public class Logintest extends testbase {
	
	Loginpage objlog;
	
	public Logintest()
	{
		super();
	}
@BeforeMethod
public void setup()
{
	initialization();
	objlog=new Loginpage();
}
@Test(priority=1)
public void titletest()
{
	String Actual=objlog.Verifypagetitle();
	String Expected="Smart Hospital : Hospital Management System";
	Assert.assertEquals(Actual, Expected);
}
@Test(priority=2)
public void testlogin()
{
	Assert.assertTrue(objlog.verifylogo());
	objlog.login(pop.getProperty("username"),pop.getProperty("password"));
}



@AfterMethod
public void teardown()
{
	driver.close();
}
	
	
	
	
	
}

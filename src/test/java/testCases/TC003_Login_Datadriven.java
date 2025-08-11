package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Login_Datadriven extends BaseClass
{

	@Test(dataProvider = "Login_Data",dataProviderClass = DataProviders.class)
	public void verify_loginddt(String email , String pwd , String exp)
	{
		logger.info("Starting TC003 Login Data drivern test case.....");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicklogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		logger.info("checking whether my accountpage is visible or not.....");
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					macc.clickLogout();
					logger.info("My Account page is visible & able to logout hence successful");
					Assert.assertTrue(true);
					
				}
				else
				{
					logger.error("My Account page is not visible thogh its valid credentials...");
					Assert.assertTrue(false);
				}
				
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					macc.clickLogout();
					logger.error("My Account page is visible though its invalid credentials....");
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("My Account page is not visible as its invalid credentials hence its successful..");
					Assert.assertTrue(true);
				}			
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
	
}

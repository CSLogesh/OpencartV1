package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass

{
	@Test(groups="regression")
	public void verify_login()
	{
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickmyaccount();
			hp.clicklogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setemail(p.getProperty("username2"));
			lp.setpassword(p.getProperty("password2"));
			lp.clicklogin();
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean myaccountpageexists = macc.isMyAccountPageExists();
			if(myaccountpageexists==true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}

		}
		catch(Exception e)
			{
				Assert.fail();
			}
	}
	
	
}

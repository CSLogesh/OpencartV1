package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_RegistrationDDT extends BaseClass
{

	@Test(dataProvider = "RegistrationData",dataProviderClass = DataProviders.class)
	public void verify_registration(String fname , String lname , String email , String mblno , String pwd , String cpwd )
	{
	try
	{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clickregister();
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		arp.setfirstname(fname);
		arp.setlastname(lname);
		arp.setemail(email);
		arp.settelephoneno(mblno);
		
		//String password = randomalphanumeric();
		
		arp.setpassword(pwd);
		arp.setconfirmpwd(cpwd);
		
		arp.clickchkboxpolicy();
		arp.clickcontinue();
		
		logger.info("Validating the expected message .....");
		String confirmmsg = arp.confirmmsg();
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
			arp.clickcontinueafterregister();
			MyAccountPage macc = new MyAccountPage(driver);
			macc.clickLogout();
			Assert.assertTrue(true);
			logger.info("Test passed...");
		}
		else
		{
			logger.error("Test Failed....");
			logger.debug("Debug Logs...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e )
		{
			Assert.fail();
		}
	}
}

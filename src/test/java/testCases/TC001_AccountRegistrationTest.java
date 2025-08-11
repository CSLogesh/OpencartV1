package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass 
{
	
	@Test(groups="sanity")
	public void test_registration()
	{
		logger.info("Started testing on homepage....");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clickregister();
		logger.info("Started testing on account registration page....");
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("Providing all the details...");
		arp.setfirstname(randomstring().toUpperCase());
		arp.setlastname(randomstring().toUpperCase());
		arp.setemail(randomalphanumeric()+"@gmail.com");
		arp.settelephoneno(randomnumeric());
		
		String password = randomalphanumeric();
		
		arp.setpassword(password);
		arp.setconfirmpwd(password);
		
		arp.clickchkboxpolicy();
		arp.clickcontinue();
		
		logger.info("Validating the expected message .....");
		String confirmmsg = arp.confirmmsg();
		if(confirmmsg.equals("Your Account Has Been Created!"))
		{
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
		
		logger.info("Registration is completed successfully... ");
	}
	
		
}

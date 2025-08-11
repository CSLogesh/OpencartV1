package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//*[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//*[@id='input-telephone']")
	WebElement txt_telephoneno;
	
	@FindBy(xpath="//*[@id='input-password']")
	WebElement txt_pwd;
	
	@FindBy(xpath="//*[@id='input-confirm']")
	WebElement txt_confirmpwd;
	
	@FindBy(xpath="//*[@name='newsletter' and @value='1']")
	WebElement btn_subscribe_yes;
	
	@FindBy(xpath="//*[@name='newsletter' and @value='0']")
	WebElement btn_subscribe_no;
	
	@FindBy(xpath="//*[@name='agree' and @type='checkbox']")
	WebElement chkd_policy;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msg_confirmation;
	
	@FindBy(xpath="//*[text()='Continue']")
	WebElement btn_continue_afterregister;
	
	public void clickcontinueafterregister()
	{
		btn_continue_afterregister.click();
	}
	

	public void setfirstname(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void settelephoneno(String number)
	{
		txt_telephoneno.sendKeys(number);
	}
	
	public void setpassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void setconfirmpwd(String pwd)
	{
		txt_confirmpwd.sendKeys(pwd);
	}
	
	public void clicksubscription()
	{
		btn_subscribe_yes.click();
	}
	
	public void dontclicksubscription()
	{
		btn_subscribe_no.click();
	}
	
	public void clickchkboxpolicy()
	{
		chkd_policy.click();
	}
	
	public void clickcontinue()
	{
		btn_continue.click();
	}
	
	public String confirmmsg()
	{
		try
		{
			return(msg_confirmation.getText());
			
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	
	}
}

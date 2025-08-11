package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="(//*[text()='My Account'])[1]")
	WebElement lnk_myaccount ; 
	
	@FindBy(xpath="//*[text()='Register']")
	WebElement lnk_register ; 

	@FindBy(xpath="//*[text()='Login']")
	WebElement lnk_login;
	
	
	
	public void clickmyaccount()
	{
		lnk_myaccount.click();
	}
	
	public void clickregister()
	{
		lnk_register.click();
	}

	public void clicklogin()
	{
		lnk_login.click();
	}
	
}

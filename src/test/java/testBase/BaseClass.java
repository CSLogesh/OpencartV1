package testBase;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{

	public static WebDriver driver ; 
	public Logger logger;
	public Properties p ; 
	
	@BeforeClass(groups= {"sanity","regression"})
	@Parameters({"browser","os"})
	public void setup(String br, String os ) throws Exception
	{
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			// os 
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS Found...");
				return ; 
			}
			
			//browser
			
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break ; 
			case "firefox" : capabilities.setBrowserName("Firefox");break;
			default : System.out.println("Invalid browser name..."); return ; 
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.29.164:4444/wd/hub"), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break ; 
			case "firefox" : driver = new FirefoxDriver(); break ; 
			default : System.out.println("Invalid Browser Name..."); return ; 
			}
		}
						
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"sanity","regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String captureScreen(String tname)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		String trgfilepath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +" _"+ timestamp +".html";
		File trg = new File(trgfilepath);
		src.renameTo(trg);
		
		return trgfilepath;
	}
	
	@SuppressWarnings("deprecation")
	public String randomstring()
	{
		String randomstring = RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	
	@SuppressWarnings("deprecation")
	public String randomnumeric()
	{
		String randomnumeric = RandomStringUtils.randomAlphabetic(10);
		return randomnumeric;
	}
	
	@SuppressWarnings("deprecation")
	public String randomalphanumeric()
	{
		String randomalphanumeric = RandomStringUtils.randomAlphanumeric(8);
		return randomalphanumeric;
	}

}

package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	// Data provider 1 
	
	@DataProvider(name="Login_Data")
	public String[][] getdata() throws Exception
	{
		String path = ".\\testdata\\Login_Data.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols = xlutil.getCellCount("Sheet2", 1);
		
		String logindata [][] = new String [totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet2", i, j);
			}
		}
		
		return logindata;	
		
	}
	
	@DataProvider(name="RegistrationData")
	public String[][] getRegistrationData() throws Exception
	{
		String path = ".\\testdata\\RegistrationData.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount("Sheet2");
		int totalcols = xlutil.getCellCount("Sheet2", 1);
		
		String registrationdata [][] = new String [totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				registrationdata[i-1][j]=xlutil.getCellData("Sheet2", i, j);
			}
		}
	
		return registrationdata;
		
	}
	
}

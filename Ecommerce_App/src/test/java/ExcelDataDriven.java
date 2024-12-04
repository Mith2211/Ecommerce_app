import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataDriven {
	
	@DataProvider(name = "LoginTest")
	public Object[][] getData() throws IOException  {
		
		return Excelutil.getTestData("C:\\Users\\Mithilesh\\Downloads\\Ecommerce_App\\Ecommerce_App\\ExcelFiles\\LoginTest.xlsx","Login_Details3");
	}
	
	
	@Test(dataProvider = "LoginTest")
	public void testlogin(String Username, String Password)
	{
		System.out.println(Username);
		System.out.println(Password);
	}

}

package automation.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.PageObjects.ProductCatelogue;
import automation.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = "errormessgaehandling")

	public void ErrormsgValidations() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		String CountryName = "India";
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		// LoginPage landingPage = launchApplication();
		// landingPage.goTo();
		ProductCatelogue productCatelog = loginpage.loginApplication("mithilesh@yopmail.com", "Tes@1234");
		String errormesage = loginpage.errorToastmsg();
		System.out.println(errormesage);
		Assert.assertEquals("Incorrect email or password.", errormesage);

	}

}

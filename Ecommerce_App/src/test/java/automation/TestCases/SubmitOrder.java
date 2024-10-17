package automation.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.PageObjects.LoginPage;
import automation.PageObjects.CartPage;

import automation.PageObjects.NavigationBar;
import automation.PageObjects.PaymentPage;
import automation.PageObjects.ProductCatelogue;
import automation.PageObjects.ThankYou;
import automation.TestComponents.BaseTest;
import automation.TestComponents.Retry;
import automation.PageObjects.OrderHistory;

public class SubmitOrder extends BaseTest {
	String ID;

	@Test(dataProvider = "dataProvider")

	public void submitOrder(HashMap<String, String> input)
			throws IOException, InterruptedException {

		// String productName = "ADIDAS ORIGINAL";
		String CountryName = "India";
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		// LoginPage landingPage = launchApplication();

		// LoginPage landingPage = new LoginPage(driver);
		// landingPage.goTo();
		ProductCatelogue productCatelog = loginpage.loginApplication(input.get("Email"), input.get("Password"));

		// ProductCatelogue productCatelog = new ProductCatelogue(driver);
		// List<WebElement> products = productCatelog.getProdcutList();
		NavigationBar NavBar = productCatelog.addProductToCart(input.get("ProductName"));

		// NavigationBar NavBar= new NavigationBar(driver);
		CartPage cartpage = NavBar.ClickonCart();
		Thread.sleep(2000);

		// CartPage cartpage= new CartPage(driver);
		boolean match = cartpage.ProductMatchInCart(input.get("ProductName"));
		Assert.assertTrue(match);
		PaymentPage paymentpg = cartpage.ClickOnCheckOutbtn();

		// PaymentPage paymentpg= new PaymentPage(driver);
		paymentpg.selectCountryName(CountryName);
		paymentpg.getListOfCountriedfromDD(CountryName);
		ThankYou thanku = paymentpg.ClickOnPlaceOrderbtn();

		// ThankYou thanku= new ThankYou(driver);
		String title = thanku.CheckuserisonThankYou(CountryName);

		ID = thanku.extractOrderID();

		System.out.println("ID=" + ID);

		Assert.assertEquals(title, "THANKYOU FOR THE ORDER.");

		// closeBroswer();

	}

	@Test(dependsOnMethods = "submitOrder", retryAnalyzer = Retry.class)
	public void OrderHistory() throws InterruptedException {
		// WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		Thread.sleep(5000);
		LoginPage loginpage = new LoginPage(driver);

		loginpage.loginApplication("mithilesh@yopmail.com", "Test@1234");

		NavigationBar navbar = new NavigationBar(driver);
		navbar.ClickonOrders();
		OrderHistory orderhistorypage = new OrderHistory(driver);

		boolean matchid = orderhistorypage.orderhistory(ID);

		Assert.assertTrue(matchid);

	}

	@DataProvider
	public Object[][] dataProvider() throws IOException {
//		Object[][] data = new Object[3][3];
//		data[0][0] = "mithilesh@yopmail.com";
//		data[0][1] = "Test@1234";
//		data[0][2] = "ZARA COAT 3";
//
//		data[1][0] = "mithilesh@mailinator.com";
//		data[1][1] = "Test@1234";
//		data[1][2] = "ADIDAS ORIGINAL";
//
//		data[2][0] = "test_test@mailinator.com";
//		data[2][1] = "Test@1234";
//		data[2][2] = "IPHONE 13 PRO";
		//return data;
		
//		HashMap<String,String> map = new HashMap<String, String>();
//		map.put("Email", "mithilesh@yopmail.com");
//		map.put("Password", "Test@1234");
//		map.put("ProductName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String, String>();
//		map1.put("Email", "mithilesh@mailinator.com");
//		map1.put("Password", "Test@1234");
//		map1.put("ProductName", "ADIDAS ORIGINAL");

		//return new Object[][] {{map},{map1}};
		
		List<HashMap<String, String>>  data =getJsonDataMap(System.getProperty("user.dir")+"//src//test//java//automation//data//PurchaseOrder.json");

		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}

package automation.stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import automation.PageObjects.CartPage;
import automation.PageObjects.LoginPage;
import automation.PageObjects.NavigationBar;
import automation.PageObjects.PaymentPage;
import automation.PageObjects.ProductCatelogue;
import automation.PageObjects.ThankYou;
import automation.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.an;

public class StepDefinition extends BaseTest {
	public LoginPage landingpage;
	public ProductCatelogue productCatelog;
	public NavigationBar NavBar;
	public String CountryName = "India";
	public PaymentPage paymentpg ;
	public ThankYou thanku ;
	public String ID;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		 landingpage =launchApplication();
	}

	
	@Given("^Logged in with (.+) and (.+)$")
	public void Logged_in_with_Email_and_Passsword(String Email, String Password)
	{
		 productCatelog= loginpage.loginApplication(Email, Password);
		 
	}
	
	
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String ProductName)
	{
		 NavBar = productCatelog.addProductToCart(ProductName);
	}
	
	
	
	@And("^checkout (.+) and submit order$")
	public void checkout_productName_and_submit_order(String ProductName) throws InterruptedException
	{
		
		// NavigationBar NavBar= new NavigationBar(driver);
		CartPage cartpage = NavBar.ClickonCart();
		Thread.sleep(2000);

		// CartPage cartpage= new CartPage(driver);
		boolean match = cartpage.ProductMatchInCart(ProductName);
		Assert.assertTrue(match);
		 paymentpg = cartpage.ClickOnCheckOutbtn();

		// PaymentPage paymentpg= new PaymentPage(driver);
		paymentpg.selectCountryName(CountryName);
		paymentpg.getListOfCountriedfromDD(CountryName);
		 thanku = paymentpg.ClickOnPlaceOrderbtn();
	}
	
	
	@Then("{string} message is displayed on confirmation page.")
	public void message_is_displayed_on_confirmation_page(String string) throws InterruptedException
	{
		

		// ThankYou thanku= new ThankYou(driver);
		String title = thanku.CheckuserisonThankYou(CountryName);

		ID = thanku.extractOrderID();

		System.out.println("ID=" + ID);

		Assert.assertEquals(title, string);
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    
		String errormesage= landingpage.errorToastmsg();
		Assert.assertEquals(string, errormesage);
		driver.close();
	}
	
}

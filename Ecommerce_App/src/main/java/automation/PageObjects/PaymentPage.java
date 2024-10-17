package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.AbstractComponent.AbstractComponent;

public class PaymentPage extends AbstractComponent {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/* driver.findElement(By.cssSelector("div[class='form-group'] input")).click();
		driver.findElement(By.cssSelector("div[class='form-group'] input")).sendKeys("india");

		List<WebElement> dd = driver.findElements(By.cssSelector("section[class*='list-group'] span"));

		for (int i = 0; i < dd.size(); i++) {
			String countryname = dd.get(i).getText();
			System.out.println(countryname);

			if (countryname.trim().equalsIgnoreCase("India")) {
				dd.get(i).click();
				break;
			}

		}

		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		Thread.sleep(2000);*/

	@FindBy(css = "div[class='form-group'] input")
	WebElement ClickOnCountryDropdown;
	
	@FindBy (css= "section[class*='list-group'] span")
	List<WebElement> dd;
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement PlaceOrderBtn;
	
	
	public void selectCountryName(String CountryName)
	{
		ClickOnCountryDropdown.click();
		ClickOnCountryDropdown.sendKeys(CountryName);		
		
	}
	
	public List<WebElement> getListOfCountriedfromDD(String CountryName) {
		
		for (int i=0; i<dd.size();i++)
		{
			String countryName= dd.get(i).getText();
			
			if (countryName.trim().equalsIgnoreCase(CountryName))
			{
				dd.get(i).click();
				break;
			}
		}
		
				return dd;

	}
		
	
	
	public ThankYou ClickOnPlaceOrderbtn() throws InterruptedException
	{
		Thread.sleep(2000);
		PlaceOrderBtn.click();
		ThankYou thanku= new ThankYou(driver);
		return thanku;
	}
	

}

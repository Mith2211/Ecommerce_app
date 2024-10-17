package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.AbstractComponent.AbstractComponent;

public class ThankYou extends AbstractComponent {

	WebDriver driver;

	public ThankYou(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/* String Title = driver.findElement(By.cssSelector(".hero-primary")).getText().trim();
		System.out.println(Title);

		Assert.assertEquals(Title, "THANKYOU FOR THE ORDER.");*/

	@FindBy(css = ".hero-primary")
	WebElement ExtractThankYouText;
	
	@FindBy(xpath = "//label[contains(text(), '|')]")
	WebElement ExtractOrderId;
	
	
	public String CheckuserisonThankYou(String CountryName)
	{
		String Title= ExtractThankYouText.getText().trim();
		System.out.println("Thank you title log="+Title);
		return Title;
		
	}
	
	public String extractOrderID()
	{
		String extractedId= ExtractOrderId.getText().split(" ")[1].trim();
		
		return extractedId;
	}

}

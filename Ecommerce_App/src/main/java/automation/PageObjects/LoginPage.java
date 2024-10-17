package automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	/*driver.findElement(By.id("userEmail")).sendKeys("mithilesh@yopmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
	driver.findElement(By.id("login")).click();*/
		
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="div[class*='toast-message']")
	WebElement errorMsg;
	
	public ProductCatelogue loginApplication(String Email, String Password)
	{
		waitForWebElementToAppear(userEmail);
		userEmail.sendKeys(Email);
		userPassword.sendKeys(Password);
		login.click();
		ProductCatelogue productCatelog= new ProductCatelogue(driver) ;
		return productCatelog;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorToastmsg()
	{
		waitForWebElementToAppear(errorMsg);
		String errortoastMsg= errorMsg.getText();
		return errortoastMsg;
	}
		
}

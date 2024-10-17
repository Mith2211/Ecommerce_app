package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/* List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

		boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));

		driver.findElement(By.cssSelector(".totalRow button")).click(); */

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	By findBy = By.cssSelector(".totalRow button");
	By checkoutBtn = By.cssSelector(".totalRow button");


	public List<WebElement> getCartProducts() {
				return cartProducts;

	}
		
	public void ProductMatchInCart(String ProductName)
	{
		boolean match = getCartProducts().stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));

		Assert.assertTrue(match);
		
		
		
	}
	
	public void ClickOnCheckOutbtn() throws InterruptedException
	{
		Thread.sleep(2000);
		windowScroll("window.scroll(0,1000)");
		Thread.sleep(2000);
		waitForElementTobeClickable(findBy);
		driver.findElement(checkoutBtn).click();
	}
	

}

package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponent.AbstractComponent;

public class ProductCatelogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatelogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); */

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By ProductsBy = By.cssSelector(".mb-3");
	By toastContainer = By.id("toast-container");
	By addToCart= By.cssSelector(".card-body button:last-of-type");

	public List<WebElement> getProdcutList() {
		waitForElementToAppear(ProductsBy);
		return products;

	}
		
	public WebElement getProductbyName(String ProductName)
	{
		WebElement prod = getProdcutList().stream()
				.filter(product -> product.findElement(By.cssSelector("h5")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);
		System.out.println("product="+prod.getText());
		return prod;
		
		
	}
	
	public NavigationBar addProductToCart(String ProductName)
	{
		WebElement prod = getProductbyName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastContainer);
		NavigationBar NavBar = new NavigationBar(driver);
		return NavBar;
	}
	

}

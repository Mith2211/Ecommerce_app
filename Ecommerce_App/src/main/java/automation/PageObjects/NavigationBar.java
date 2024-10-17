package automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation.AbstractComponent.AbstractComponent;

public class NavigationBar extends AbstractComponent{

	WebDriver driver;

	public NavigationBar(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public CartPage ClickonCart() throws InterruptedException
	{
		
		WebElement DisappearElement = driver.findElement(By.xpath("//div[@id='toast-container']"));
		waitForElementToDisappear(DisappearElement);	
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	public OrderHistory ClickonOrders() throws InterruptedException
	{
		
		WebElement DisappearElement = driver.findElement(By.xpath("//div[@id='toast-container']"));
		waitForElementToDisappear(DisappearElement);	
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
		OrderHistory orderPage = new OrderHistory(driver);
		return orderPage;
	}

	
}

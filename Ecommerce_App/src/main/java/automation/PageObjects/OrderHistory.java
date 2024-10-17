package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponent.AbstractComponent;

public class OrderHistory extends AbstractComponent {
	
	WebDriver driver;
	// //div[contains(@class,'table-responsive')]/table/tbody/tr/th
	public OrderHistory(WebDriver driver) {
		super(driver);		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'table-responsive')]/table/tbody/tr/th")
	List<WebElement> orderIds;
	
	public boolean orderhistory(String ID)
	{
		boolean IDMatch =orderIds.stream().anyMatch(orderid -> orderid.getText().equalsIgnoreCase(ID));
		return IDMatch;
	}

}

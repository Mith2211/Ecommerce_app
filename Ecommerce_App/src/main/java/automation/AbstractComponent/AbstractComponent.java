package automation.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;



public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement AppearElement) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(AppearElement));
	}

	public void waitForElementToDisappear(WebElement DisappearElement) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(DisappearElement));
	}
	
	public void waitForElementTobeClickable(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void windowScroll(String scroll)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scroll);
	}
}

package automation.TestCases;

import java.awt.Window;
import java.time.Duration;
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

public class stadAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys("mithilesh@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("h5")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();

		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

		boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));

		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("div[class='form-group'] input")).click();
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
		Thread.sleep(2000);

		String Title = driver.findElement(By.cssSelector(".hero-primary")).getText().trim();
		System.out.println(Title);

		Assert.assertEquals(Title, "THANKYOU FOR THE ORDER.");

		driver.close();

	}

}

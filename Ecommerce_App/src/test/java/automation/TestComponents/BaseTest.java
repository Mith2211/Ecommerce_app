package automation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automation.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginpage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Mithilesh\\Downloads\\Ecommerce_App\\Ecommerce_App\\src\\test\\java\\automation\\resources\\GlobalData.properties");

		// FileInputStream fis = new
		// FileInputStream(System.getProperty("user.dir")+"//src//test//java//automation//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataMap(String FilePath) throws IOException {
		// Read Json to String
		String JsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);

		// String to HashMap

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//report//" + testCaseName + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "//report//" + testCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();

		loginpage = new LoginPage(driver);
		loginpage.goTo();
		return loginpage;

	}

	@AfterMethod(alwaysRun = true)
	public void closeBroswer() {
		driver.close();
	}

}

package Framework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Framework1.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	public WebDriver InitializeDriver() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + " src\\main\\java\\Frameweork1\\resources\\GlobalData.properties");
		pro.load(fis);
		String browserName = pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("", "");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("", "");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver LaunchApplication() throws IOException {
		driver=InitializeDriver();
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.GoTo();
		return driver;
	}
}

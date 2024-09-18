package Framework1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework1.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class alltestcases1 {

	public static void main(String[] args) {
		
		
		
		String password = "Password@1234";
		String emailId = "adviky2022211@gmail.com";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		/*
		 * driver.findElement(By.xpath("//p[@class='login-wrapper-footer-text']")).click
		 * (); driver.findElement(By.id("firstName")).sendKeys("Advik");
		 * driver.findElement(By.id("lastName")).sendKeys("yerande");
		 * driver.findElement(By.id("userEmail")).sendKeys(emailId);
		 * driver.findElement(By.id("userMobile")).sendKeys("1234567891");
		 * driver.findElement(By.id("userPassword")).sendKeys(password);
		 * driver.findElement(By.id("confirmPassword")).sendKeys(password);
		 * driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		 * driver.findElement(By.id("login")).click();
		 * driver.findElement(By.xpath("//button[text()='Login']")).click();
		 */
		driver.findElement(By.id("userEmail")).sendKeys(emailId);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='row']")));
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='row']"));
		WebElement products = items.stream()
				.filter(s -> s.findElement(By.xpath("//b[text()='ZARA COAT 3']")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);

		products.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Match = cartproducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(Match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath(" //input[@placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath(" //section[@class='ta-results list-group ng-star-inserted']/button[2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		String ConfimationMessge = driver.findElement(By.className("hero-primary")).getText();

		Assert.assertTrue(ConfimationMessge.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

}

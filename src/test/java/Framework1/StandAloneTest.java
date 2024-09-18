package Framework1;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Framework.TestComponents.BaseTest;
import Framework1.pageobject.CartPage;
import Framework1.pageobject.ConfirmationPage;
import Framework1.pageobject.LandingPage;
import Framework1.pageobject.ProductCatalogue;
import Framework1.pageobject.checkoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		LandingPage landingpage = new LandingPage(driver);
		String ProductName = "ZARA COAT 3";
		landingpage.LoginApplication("adviky2022211@gmail.com", "Password@1234");
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(ProductName);
		productcatalogue.goToCartPage();

		CartPage cartpage = new CartPage(driver);
		Boolean Match = cartpage.verifyProductDisplay(ProductName);
		Assert.assertTrue(Match);
		cartpage.goToCheckOut();

		checkoutPage checkout = new checkoutPage(driver);
		checkout.SelectCountry("India");
		checkout.SubmitOrder();

		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		confirmationpage.VerifyConfirmationMessage();

		String ConfimationMessge = driver.findElement(By.className("hero-primary")).getText();

		Assert.assertTrue(ConfimationMessge.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
}

package Framework1.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pagefactory

	@FindBy(xpath = "//div[@class='row']")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productsby = By.xpath("//div[@class='row']");
	By addtocart = By.xpath("//button[@class='btn w-10 rounded']");
	By ToastMessage=By.id("toast-container");
	public List<WebElement> getProductList() {
		WaitforElementToDisAppear(productsby);
		return products;
	}

	public WebElement getProductName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(s -> s.findElement(By.xpath("//b[text()='ZARA COAT 3']")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);

		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductName(productName);
		prod.findElement(addtocart).click();
		WaitforElementToDisAppear(ToastMessage);
		WaitforElementToDisAppear(spinner);
	}

}

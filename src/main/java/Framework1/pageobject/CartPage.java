package Framework1.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> ProductTitles;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	public Boolean verifyProductDisplay(String ProductName) {

		Boolean Match = ProductTitles.stream().anyMatch(s -> s.getText().equalsIgnoreCase("ZARA COAT 3"));
		return Match;
	}

	public void goToCheckOut() {
		checkout.click();
	}

}

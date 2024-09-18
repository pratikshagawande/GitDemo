package Framework1.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent {
	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement Country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement SelectCountry;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement SubmitButton;


	public void SelectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		By result = By.cssSelector(".ta-results");
		WaitforElementToAppear(result);
		SelectCountry.click();
	}

	public void SubmitOrder() {
		SubmitButton.click();
	}
}

package Framework1.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pagefactory

	@FindBy(id = "userEmail")
	WebElement UserEmail;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "login")
	WebElement submit;

	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public void LoginApplication(String email, String password) {
		UserEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
	}

}

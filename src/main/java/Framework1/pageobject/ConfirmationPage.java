package Framework1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "hero-primary")
	WebElement ConfimationMessge;

	public String VerifyConfirmationMessage() {
		return ConfimationMessge.getText();

	}

}

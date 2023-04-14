package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	
	public RegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Continue;
	
	//Action Methods
	
	public void setFirstName(String fn) {
		FirstName.sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		LastName.sendKeys(ln);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void selectPrivacyPolicy(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",PrivacyPolicy);
		//PrivacyPolicy.click();
	}
	public void clickContinue(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Continue);
		//Continue.click();
	}
}

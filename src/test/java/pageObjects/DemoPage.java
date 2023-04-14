package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class DemoPage  {
	
	
	public DemoPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//PageFactory
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	//Action Methods
	
	public void clickMyAccount() {
		MyAccount.click();
	}
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clickLogin() {
		login.click();
	}

}

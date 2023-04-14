package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	}



//Defining pageFactory

@FindBy(xpath="//input[@id='input-email']")
WebElement EMailAddress;

@FindBy(xpath="//input[@id='input-password']")
WebElement Password;

@FindBy(xpath="//button[@type='submit']")
WebElement Login;

//Action methods

public void setEmail(String email) {
	EMailAddress.sendKeys(email);
}

public void setPassword(String pwd) {
	Password.sendKeys(pwd);
}

public void clickLogin() {
	Login.click();
}


}
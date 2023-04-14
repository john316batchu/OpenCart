package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass{

	public TC002_Login_Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(groups= {"sanity","master"})
	public void verifyLogin() {
		
		try {
		log.info("******Starting TC002_Login_Test*******");
		DemoPage dp=new DemoPage(driver);
		log.info("Clicking on MyAccount link");
		dp.clickMyAccount();
		log.info("Clicking on Login Link");
		dp.clickLogin();
		LoginPage lp=new LoginPage(driver);
		log.info("Entering login credentials");
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		Assert.assertEquals(map.isMyAccountPageExist(),true,"Invalid login Details");
		}catch(Exception e) {
			Assert.fail();
		}
		log.info("*****Ending TC002_Login_Test*****");
		
	}

}

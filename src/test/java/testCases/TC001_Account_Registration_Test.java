package testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_Account_Registration_Test extends BaseClass {
	
	
	public TC001_Account_Registration_Test() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	DemoPage dp;
	RegistrationPage rp;
	
	@Test(groups= {"master","regression"})
	public void account_Registration_Test() {
		dp=new DemoPage(driver);
		dp.clickMyAccount();
		dp.clickRegister();
		
		rp=new RegistrationPage(driver);
		log.info("**** Account Registration Test case****");
	try {	
		log.info("Entering firstname");
		rp.setFirstName(generateRandomString());
		log.info("Entering lastname");
		rp.setLastName(generateRandomString());
		log.info("Entering email");
		rp.setEmail(generateRandomString()+"@gmail.com");
		log.info("Entering password");
		rp.setPassword("testabc");
		rp.selectPrivacyPolicy(driver);
		log.info("checked privacy policy");
		rp.clickContinue(driver);
		log.info("Successfully clicked on Continue button");
		log.info("****Account Registration test case is completed****");
		//Assert.fail();
	}catch(Exception e) {
		System.out.println(e.getMessage());
		log.error("Account Registration is failed");
		Assert.fail();
	}
		
	}

}

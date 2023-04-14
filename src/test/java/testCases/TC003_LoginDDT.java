package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DemoPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	public TC003_LoginDDT() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void LoginDDTest(String email, String pwd, String res) {

		log.info("****Starting TC003_LoginDDT****");
		try {

			DemoPage dp = new DemoPage(driver);
			dp.clickMyAccount();
			dp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage map = new MyAccountPage(driver);
			boolean flag = map.isMyAccountPageExist();

			if (res.equals("Valid")) {
				if (flag == true) {
					map.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} else if (res.equals("Invalid")) {
				if (flag == true) {
					map.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		log.info("****Completed TC003_LoginDDT*****");
	}
}

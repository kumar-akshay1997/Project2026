package testCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import testBase.baseClass;

public class Test_Case_2 extends baseClass {
	public Properties p;
	
	@Test(groups = {"sanity", "regression"})
	public void loginTest() {
		logger.info("======Login Test Case Started--------");
		try {
			homePage hPage =new homePage(driver);
			hPage.login_page_click();
			loginPage lPage=new loginPage(driver);
		String loginText=	lPage.loginTextcheck();
		Assert.assertEquals(loginText, "Login to your account");
		logger.info("----------here config-property is introduce------");
		lPage.enterLoginEmail(p.getProperty("email"));
		lPage.enterLoginPassword(p.getProperty("password"));
		System.out.println(p.getProperty("password"));
		Thread.sleep(5000);
		lPage.clickloginbtn();
		boolean logoutDisplay= hPage.logoutBtnDisplay();
		Assert.assertTrue(logoutDisplay);
		}catch (Exception e) {
			// TODO: handle exception
			
			logger.info("=======Test Case Fail=====");
			Assert.fail();
		}
	}
	
	

}

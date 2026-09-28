package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import testBase.baseClass;
import utilities.DataProviders;

public class Test_Case_2_DDT extends baseClass {
	//(dataProvider = "login_data", dataProviderClass = DataProviders.class)
	//String email, String password
	@Test(dataProvider = "login_data", dataProviderClass = DataProviders.class , groups = {"regression"})
	public void loginTest_DDT(String aa, String bb) {
		logger.info("======Login Test Case Started--------");
		
			homePage hPage =new homePage(driver);
			logger.info("======Login Test Case Started now click on the login button--------");
			hPage.login_page_click();
			loginPage lPage=new loginPage(driver);
			logger.info("======Login Test data display-----");
		String loginText=	lPage.loginTextcheck();
		Assert.assertEquals(loginText, "Login to your account");
		logger.info("----------here config-property is introduce------");
		lPage.enterLoginEmail(aa);
		lPage.enterLoginPassword(bb);
		System.out.println(p.getProperty("password"));
		//Thread.sleep(2000);
		lPage.clickloginbtn();
		boolean yes= hPage.logoutBtnDisplay();
		if(yes) {
		//boolean logoutDisplay= hPage.logoutBtnDisplay();
		Assert.assertTrue(yes);}
	}

}

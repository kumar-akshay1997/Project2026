package testCases;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.signupPage;
import testBase.baseClass;

public class Test_Case_1 extends baseClass{
	
	@Test(groups = {"sanity", "regression"})
	public void registrationUser() {
		logger.info("----------Test_Case1_Started--------");
		try {
		homePage hPage= new homePage(driver);
		hPage.login_page_click();
		loginPage lPage= new loginPage(driver);
		String signupText=	lPage.newUserSignupTextElementDisplay();
		logger.info("----------1 Assertion Start for Text Display---------");
		Assert.assertEquals(signupText, "New User Signup!");
		logger.info("----------1 Assertion completed for Text Display---------");
		lPage.enterName(randomString());
		lPage.enterSignupEmail(randomString()+"@testauto.com");
		lPage.clickSignupBtn();
		signupPage sPage=new signupPage(driver);
		boolean acountInforText= sPage.eAITextElementDisplay();
		logger.info("----------2 Assertion Start for Text Display---------");
		Assert.assertTrue(acountInforText);
		logger.info("----------2 Assertion completed for Text Display---------");
		sPage.checkboxMrSelect();
		//exWait.until(ExpectedConditions.ele)
		sPage.userNameEnter(randomString());
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Test Case fail----");
			logger.debug("dibug of fail");
			Assert.fail();
		}
	}
}

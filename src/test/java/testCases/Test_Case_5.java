package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import testBase.baseClass;

public class Test_Case_5 extends baseClass {
	@Test(groups = {"sanity", "regression"})
	public void register_with_existUser() {
		homePage hPage=new homePage(driver);
		hPage.login_page_click();
		loginPage lPage= new loginPage(driver);
		String actualString= lPage.newUserSignupTextElementDisplay();
		Assert.assertEquals(actualString, "New User Signup!");
		lPage.enterName(randomString());
		lPage.enterSignupEmail(p.getProperty("email"));
		lPage.clickSignupBtn();
		String messageActualText= lPage.invalidsignupMessage();
		Assert.assertEquals(messageActualText, "Email Address already exist!");
	}

}

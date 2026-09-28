package pageObjects;

//import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends testBase {
	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[contains(.,'New User Signup!')]")
	WebElement newUserSignupTextElement;
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement loginTextElement;
	
	@FindBy(xpath = "//input[@name='email' and @data-qa='login-email']")
	WebElement loginEmailElement;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordElement;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtnElement;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement nameElement;
	
	@FindBy(xpath = "//input[@name='email' and @data-qa='signup-email' ]")
	WebElement signupEmailElement;
	
	@FindBy(xpath = "//button[text()='Signup' ]")
	WebElement signupBtnElement;
	
	public String loginTextcheck() {
		try {
	return	(loginTextElement.getText());
		}catch (Exception e) {
			return (e.getMessage());// TODO: handle exception
		}
	}
	
	public String newUserSignupTextElementDisplay() {
	try {
		return	(newUserSignupTextElement.getText());
	}
	catch (Exception e) {
		// TODO: handle exception
		return (e.getMessage());
	}
	}
	
	
	
	public void enterName(String name) {
		nameElement.sendKeys(name);
	}
	
	public void enterSignupEmail(String signupEmail) {
		signupEmailElement.sendKeys(signupEmail);
	}
	
	public void clickSignupBtn() {
		signupBtnElement.click();
	}
	
	public void enterLoginEmail(String loginEmail) {
		loginEmailElement.sendKeys(loginEmail);
	}
	
	public void enterLoginPassword(String loginPassword) {
		passwordElement.sendKeys(loginPassword);
	}
	
	public void clickloginbtn() {
		loginBtnElement.click();
	}

}

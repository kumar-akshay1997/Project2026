package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signupPage extends testBase {
	public signupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement eAITextElement;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement checkboxMrElement;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement signupUserNamElement;
	
	public boolean eAITextElementDisplay() {
		return eAITextElement.isDisplayed();
	}
	
	public void checkboxMrSelect() {
		checkboxMrElement.click();
	}
	
	public void userNameEnter(String userName) {
		signupUserNamElement.clear();
		signupUserNamElement.sendKeys(userName);
	}
}

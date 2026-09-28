package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends testBase {
	
	public homePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homePageElement;
	
	@FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
	WebElement loginPagElement;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutBtnElement;
	
	public boolean logoutBtnDisplay() {
	boolean logoutBtn=	logoutBtnElement.isDisplayed();
	return logoutBtn;
	}
	
	public void login_page_click() {
		loginPagElement.click();
	}

}

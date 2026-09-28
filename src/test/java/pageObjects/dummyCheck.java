package pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dummyCheck {
	public WebDriver driver;
	public WebDriverWait exWait;
	@Parameters("browser")
	@Test
	public void browser(String br) throws MalformedURLException {
		
		String gridURL="http://192.168.1.5:4444/wd/hub";
		
		DesiredCapabilities dCapabilities = new DesiredCapabilities();
		dCapabilities.setPlatform(Platform.LINUX);
		dCapabilities.setBrowserName(br);
		URL url= new URL(gridURL);
		WebDriver driver= new RemoteWebDriver(url, dCapabilities);
		
			//driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			exWait= new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.get("https://automationexercise.com/");
			driver.manage().window().maximize();
			System.out.println("test executed");
			driver.close();
		
	}

}

package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import bsh.This;

public class baseClass {
	public static WebDriver driver;
	public Logger logger;
	public WebDriverWait exWait;
	public Properties p;
	@BeforeClass(groups = {"sanity", "regression"})
	//@Parameters({"browser", "os"})
	public void setUp() throws IOException {
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		logger =LogManager.getLogger(this.getClass());
		//switch (browser) {case 1:break;
		driver=new ChromeDriver();
		//case 2: driver= new EdgeDriver();break;
		//default:System.out.println("Invalid Browser");
		//	return;
		//}
		
		
		driver.manage().deleteAllCookies();
		exWait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups = {"sanitys", "regression"})
	public void tearDown() {
		driver.close();
		System.out.println("Driver close");
		
	}
	//To generate Random String of 6 char length
	public String randomString() {
		String rendom=RandomStringUtils.randomAlphanumeric(6);
		return rendom;
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\"+ tname +"_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}


}

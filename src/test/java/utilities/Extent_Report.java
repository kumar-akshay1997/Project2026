package utilities;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.baseClass;

public class Extent_Report implements ITestListener {
	public ExtentSparkReporter exr;
	public ExtentReports er;
	public ExtentTest et;
	String repName;

	public void onStart(ITestContext context) {
		// not implemented
		System.out.println("Listner Start");
		String time_stamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+time_stamp+".html";
		exr = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/"+repName);
		exr.config().setDocumentTitle("Akshay Report");
		exr.config().setReportName("This Is My Report");
		exr.config().setTheme(Theme.DARK);
		er = new ExtentReports();

		er.attachReporter(exr);
		er.setSystemInfo("Window", "OS");
		er.setSystemInfo("Akshy", "Creater");

	}

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("Listner Test Case Start");
		et = er.createTest(result.getName());
		// et.log(Status.PASS, null)
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("Listner Test Case Start");
		et = er.createTest(result.getTestClass().getName());
		et.log(Status.PASS, result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("Listner Test Case Start and Fail");
		et = er.createTest(result.getTestClass().getName());
		et.log(Status.FAIL, "This test cases fail: " + result.getName());
		et.log(Status.FAIL, result.getThrowable());
		try {
		String tempPath=new baseClass().captureScreen(result.getName());
		et.addScreenCaptureFromPath(tempPath);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		System.out.println("Listner Test Case Start and skipped");
		et = er.createTest(result.getTestClass().getName());
		et.log(Status.SKIP, "This is skippeed" + result.getName());
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
		System.out.println("Listner Start and time out");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		er.flush();
	}

}

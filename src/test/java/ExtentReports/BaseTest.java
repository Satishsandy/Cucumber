package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import junit.framework.Test;

public class BaseTest {
	public static WebDriver driver;
	public static com.aventstack.extentreports.ExtentReports Reports; 
	public static ExtentTest Test; 
@Parameters({"browser"})
	@BeforeTest
	public void setup(ITestContext context,@Optional("chrome")String browser) {
	switch (browser.toLowerCase()) {
	case "chrome":
		driver= new ChromeDriver();
		
		break;
	case "firefox":
		driver= new FirefoxDriver();
		break;
	case "edge":
		driver= new EdgeDriver();
		break;
		default:
			System.out.println("browser is invalid");
		break;
	}
	driver.manage().window().maximize();
    Test=	Reports.createTest(context.getName());
    String author = context.getCurrentXmlTest().getParameter("author");
     Test.assignAuthor(author);//lock the inforamation
	}
	
	

	@AfterTest
	public void tearDown() {
		driver.close();

	}
	@BeforeSuite
	public void initialiseExtentReports() {
		Reports = new ExtentReports();
		//File f= new File("C:\\Users\\satish\\Documents\\New folder\\Sa\\Ram\\report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\satish\\Documents\\New folder\\Sa\\Ram\\report.html");
	
	Reports.attachReporter(spark);
	Reports.setSystemInfo("OS", System.getProperty("os.Name"));
	Reports.setSystemInfo("Java Version", System.getProperty("Java.vaersion"));
		
		
	}
	@AfterSuite
	public void generateReports()throws Throwable {
		Reports.flush();
		Desktop.getDesktop().browse(new File("C:\\Users\\satish\\Documents\\New folder\\Sa\\Ram\\report.html").toURI());
	}
	@AfterMethod
	public void checkStatus(Method m,ITestResult result) throws Throwable {
		if(result.getStatus()==ITestResult.FAILURE) {
			String screen =null;
			screen = captureScreenshot(null);
			Test.addScreenCaptureFromBase64String(screen);
			Test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
		Test.pass(m.getName()+  " is passed");	
			
		}
         // m.getAnnotation(Test.class).group()
		Test.assignCategory(m.getAnnotation(org.testng.annotations.Test.class).groups());
	}

	public String captureScreenshot(String fileName)throws Throwable {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dsc= new File("C:\\Users\\satish\\Pictures\\Screenshots\\TestNG"+fileName);
	try {
		FileUtils.copyFile(screen,dsc);
	}catch(IOException e) {
		e.printStackTrace();
	}
	System.out.println("Screenshot saved sucessfully");
	return fileName;
	
	}
/*	public static String captureScreenshot() {
		TakesScreenshot TS = (TakesScreenshot)driver;
		String base64Code=TS.getScreenshotAs(OutputType.BASE64);
		
		System.out.println("Screenshot saved sucessfully");
		return base64Code;*/

}

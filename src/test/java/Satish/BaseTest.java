package Satish;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void screenshotCapture(ITestResult result) throws Throwable {
		if(result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result.getMethod().getMethodName()+".jpg");
		}
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();

	}

	public void captureScreenshot(String fileName)throws Throwable {
		File screen =(File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dsc= new File("C:\\Users\\satish\\Pictures\\Screenshots\\TestNG"+fileName);
	try {
		FileUtils.copyFile(screen,dsc);
	}catch(IOException e) {
		e.printStackTrace();
	}
	System.out.println("Screenshot saved sucessfully");
	}
	
	void dis() {
		System.out.println("satish");
	}

}

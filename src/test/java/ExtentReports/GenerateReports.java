package ExtentReports;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReports {
	public static  WebDriver driver;
	public static void main(String[] args) throws Throwable {
		ExtentReports report= new ExtentReports();
	//	File f = new File("C:\\Users\\satish\\Documents\\New folder");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\satish\\Documents\\New folder.report.html");
		report.attachReporter(spark);
			driver= new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			//Test.info("navigate url");
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			//String excepted = "DashBoard";
			//String actual= driver.getTitle();
			//assertEquals(actual, excepted+"Tittle is not matching");
			String base64=captureScreenshot();
			
			report.createTest("take Screen shot").info("information").addScreenCaptureFromBase64String(base64);
		report.flush();
		driver.close();
		Desktop.getDesktop().browse(new File("C:\\Users\\satish\\Documents\\New folder.report.html").toURI());
	}
	public static String captureScreenshot() {
		TakesScreenshot Ts=(TakesScreenshot)driver;
		String base64=Ts.getScreenshotAs(OutputType.BASE64);
		
		
		System.out.println("Screen shot saved sucessfully");
		return base64;
		
	}

}
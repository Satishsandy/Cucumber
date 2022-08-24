package ExtentReports;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ExtentReports extends BaseTest {
	@Test(testName = "TestGoogle",groups= {"smoke"})
	public void TestGoogle()throws Throwable{
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		Test.info("navigate url");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		//Test.info("Entered test in serch box");
		String expected= "HYR Tutorials - Google Search";
		String actual=driver.getTitle();
		assertEquals(actual, expected ,"Tittla is matching");
		//Test.pass("Asseration web page is valid");
	}
		@Test(testName="TestFacebook",groups= {"smoke","regression"})
		public void TestFacebook() {
		driver.get("https://www.facebook.com/");
		Test.info("navigate url");
		driver.findElement(By.id("email")).sendKeys("997979789898");
		driver.findElement(By.name("login")).click();
		String expected = "https:/login";
		String actual=driver.getCurrentUrl();
		assertEquals(actual, expected);
		}
			
	
	@Test(testName = "TestOrangeHRM",groups= {"sanity"})
	public void TestOrangeHRM() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Test.info("navigate url");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String excepted = "DashBoard";
		String actual= driver.getTitle();
		assertEquals(actual, excepted+"Tittle is not matching");

}}

package Satish;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScrenshor extends BaseTest{
	@Test
	public void TestGoogle()throws Throwable{
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		String expected= "HYR Tutorials - Google Search";
		String actual=driver.getTitle();
		assertEquals(actual, expected ,"Tittla is matching");
	
	}
	@Test
	public void TestOrangeHRM() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String excepted = "DashBoard";
		String actual= driver.getTitle();
		assertEquals(actual, excepted+"Tittle is not matching");
	}

}

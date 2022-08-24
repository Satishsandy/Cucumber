package Satish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Rediff {
	WebDriver driver;
	@Test
	public void Addto () {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	//store list box
	String variable = driver.findElement(By.id("root")).getText();
	System.out.println(variable);
}

}

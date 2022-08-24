package listeners;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Ṭest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
	//	System.out.println(capabilities.getBrowserName());
		//System.out.println(capabilities.getVersion());
         driver.quit();
	}

}

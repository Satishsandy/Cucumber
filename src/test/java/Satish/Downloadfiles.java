package Satish;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Downloadfiles {

	public static void main(String[] args) {
		String location=System.getProperty("user.dr")+"\\Downloads\\";
		//chrome
		HashMap preference= new HashMap();
		preference.put("plugins.always_open_pdf_externally", true);//download pdf file dirctly without opens
		preference.put("download.default_directory", location);
		
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("prefs", preference);
	FirefoxProfile profile= new FirefoxProfile();
	 profile.setPreference("pdfjs.disabled", true);//pdf file dirctly download
		profile.setPreference("browser.downloads.folderList", 2);//0-desktop 1-downloads 2-disired location
		profile.setPreference("browser.download.dir", location);
		FirefoxOptions options =new FirefoxOptions();
		options.setProfile(profile);
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();*/
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		
	}

}

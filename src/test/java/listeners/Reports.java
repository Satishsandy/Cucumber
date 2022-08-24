package listeners;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Reports {
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		ExtentReports reports = new ExtentReports();
	   File f= new File("C:\\Users\\satish\\Documents\\New folder\\Sa\\report.html");
		//ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\satish\\Documents\\New folder\\Sa\\report.html");
	   ExtentSparkReporter spark= new ExtentSparkReporter(f);
	  //  ExtentSparkReporter spark_All = new ExtentSparkReporter("AllTests.html");
	 //   ExtentSparkReporter spark_fail = new ExtentSparkReporter("FailedTests.html");
	   // ExtentSparkReporter spark_Skip = new ExtentSparkReporter("SkipAndWaning.html");
	   //spark_fail.filter().statusFilter().as(new Status [] {Status.FAIL} ).apply();
	   //spark_Skip.filter().statusFilter().as(new Status [] {
		//	   Status.SKIP,
	   //   Status.WARNING
	 		  // } ).apply();
	   // reports.attachReporter(spark_fail,spark_Skip);
	    
	    spark.config().setTheme(Theme.DARK);//change theme
	    spark.config().setReportName("Report NAME");//change report name
	    spark.config().setDocumentTitle("Satish Tittla");//change title
	    spark.config().setTimeStampFormat("dd-MM-yyy hh:mm:ss");//change time format
	    spark.config().setCss(".badge-primary{background-color:#00ff07}");
	    spark.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';" );
	    reports.setSystemInfo("os", System.getProperty("os.name"));
	    reports.setSystemInfo("Java Version", System.getProperty("java.version"));
	    reports.setSystemInfo("os", System.getProperty("os.name"));
	    reports.setSystemInfo("App Url", "www.facebook.com");
	    reports.setSystemInfo("UserName", "Satishsuravarapu084@gmail.com");
	    reports.setSystemInfo("Password", "123456");
	    spark.viewConfigurer().viewOrder().as(new ViewName[] {//to maintain order and selected element visible
	    		ViewName.DASHBOARD,
	    	ViewName.TEST,
	    	ViewName.EXCEPTION,
	    	ViewName.CATEGORY,
	    	ViewName.DEVICE
	    	
	    }).apply();
        //reports.attachReporter(spark);
	    reports.attachReporter(spark);
        
          
          //create test cases on extent reports
          //reports.createTest("Satish Sandhya");
          //To give the pass or fail
         ExtentTest Test1 = reports.createTest("Satish Sandhya");
          Test1.pass("This is passed");
          //Log method
          ExtentTest Test2= reports.createTest("Sandhya Satish");
          Test2.log(Status.FAIL, "This is a fail");
          //chaining method
          
          reports.createTest("Satish").skip("This is skipped");
          reports
          .createTest("Satish Sandhya")
          .log(Status.INFO, "info 1")
          .log(Status.INFO, "info2")
          .log(Status.INFO, "info2")
          .log(Status.PASS, "Pass");
         //.log(Status.WARNING, "Waning")
          //.log(Status.WARNING, "Warning")
        //  .log(Status.SKIP, "Skip")
          //.log(Status.FAIL, "Fail")
         // .log(Status.FAIL, "fail2");
          //fail
          //skip
          //warning
          //pass
         // info
          //italic and Bold
          reports.createTest("Text based Test")
          .log(Status.INFO, "info1")
          .log(Status.INFO, "<b>info2<b>")//bold
          .log(Status.INFO, "<i>info3<i>")//italic
          .log(Status.INFO, "<b><i>info1<b><i>");//bold and italic
          //list map set
          List<String> list= new ArrayList<String>();
          list.add("Satish");
          list.add("Sandhya");
          
          Map<Integer, String> map=new HashMap<Integer, String>();
          map.put(100, "Ram");
          map.put(101, "Kumar");
          map.put(102, "Surya");
          
          Set<Integer> set =map.keySet();
          
          reports.createTest("List test data")
          .info(MarkupHelper.createOrderedList(list))//  ordered list placed in order numbering is coming
          .info(MarkupHelper.createUnorderedList(list));//Inorder list placed in order but bullet marks is coming 
          
          reports.createTest("Map test data")
          .info(MarkupHelper.createOrderedList(map))
          .info(MarkupHelper.createUnorderedList(map));
        
          reports.createTest("set test data")
          .info(MarkupHelper.createOrderedList(set))
          .info(MarkupHelper.createUnorderedList(set));
          
         // highlight text 
          reports.createTest("Hightlight login text")
          .info("Satish")
          .info(MarkupHelper.createLabel("Satish",ExtentColor.RED));
          try {
        	  int  i= 5/0;
           }catch(Exception e) {
        	   reports.createTest("Exception Test1")
        	   .info(e)  ;   
        	   }
          Throwable t= new RuntimeException("Tjhis is a runtime exception");
          reports.createTest("Exception Test2")
   	   .info(t) ;
          try {
        	  int  i= 5/0;
           }catch(Exception e) {
        	   reports.createTest("Exception Test1")
        	   .fail(e)  ; 
        	   }
          Throwable t1= new RuntimeException("Tjhis is a runtime exception");
          reports.createTest("Exception Test2")
   	   .fail(t1) ;
          driver = new ChromeDriver();
          driver.get("https://www.google.co.in");
          String base64Code= captureScreenshot();
         String path =captureScreenshot("C:\\Users\\satish\\Pictures\\Saved Pictures\\satish.jpg");
         

          reports.
          createTest("Screenshot test1", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          addScreenCaptureFromBase64String(base64Code);
        
          reports.
          createTest("Screenshot test2", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          addScreenCaptureFromBase64String(base64Code,"Google HomePage");
          
          reports.
          createTest("Screenshot test6", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          addScreenCaptureFromBase64String(base64Code,"Google HomePage1").
          addScreenCaptureFromBase64String(base64Code,"Google HomePage2").
          addScreenCaptureFromBase64String(base64Code,"Google HomePage3").
          addScreenCaptureFromBase64String(base64Code,"Google HomePage4");
        
          reports.
          createTest("Screenshot test3", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          addScreenCaptureFromPath(path);
          
         // reports.
          createTest("Screenshot test8", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
          .fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
          
          
         reports.
          createTest("Screenshot test5", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          addScreenCaptureFromPath(path, "GoogleHome Page1").
          addScreenCaptureFromPath(path, "GoogleHome Page2").
          addScreenCaptureFromPath(path, "GoogleHome Page3").
          addScreenCaptureFromPath(path, "GoogleHome Page4");
          //fail string deatails ,media
          reports.
          createTest("Screenshot test9", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          fail("This is info msg",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google homepage").build());          //.fail("This is info msg",MediaEntityBuilder.createScreenCaptureFromPath(path,"Google homepage").build());
       //fail throwable 
          Throwable t11 = new Throwable("This is Message");
          reports.
          createTest("Screenshot test10", "This is a attching the screens shot on testlevel").
          info("This is test lvel").
          fail(t11,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google homepage").build());
         // .fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path,"Google homepage").build());
       //Author Category Device if you provide the differnt orders then also executed and it is empty then also executed
          reports.createTest("Test1","Test desc").
          assignAuthor("Satish")
          .assignCategory("Smoke").
          assignDevice("Chromee 102")
          .pass("this is a pass test");
          
          reports.createTest("Test2","Test desc").
          assignAuthor("Sandhya")
          .assignCategory("Sanity").
          assignDevice("Edge 102")
         // .fail("this is a pass test");
          .skip("this method is skipped");
          //enter multiple information
          reports.createTest("Test3","Test desc").
          assignAuthor("Satish")
          .assignAuthor("Sandhya")
          .assignCategory("Smoke")
         .assignCategory("Regression").
          assignDevice("Chromee 102")
          .assignDevice("Chrome 103")
          //.pass("this is pass test");
          .warning("this method is Warning");
          //pass the data in array or normal
          reports.createTest("Test4","Test dsc")
          .assignAuthor("Satish","Sandhya","Raj")
          .assignCategory("Smoke","Sanity","Regression")
          .assignDevice("Chrome 102","Firefox 60","Edge 102")
          .pass("This is a passed test");
          //array
          reports.createTest("Test5","Test dsc")
          .assignAuthor(new String[] {"Satish","Sandhya","Raj"})
          .assignCategory(new String[] {"Smoke","Sanity","Regression"})
          .assignDevice(new String[] {"Chrome 102","Firefox 60","Edge 102"})
          .pass("This is a passed test");
          
          Throwable y= new RuntimeException("Tjhis is a runtime exception");
          reports.createTest("Exception Test2")
   	   .fail(y) ;
          
          reports.flush();
        //  driver.close();
      Desktop.getDesktop().browse(new File("C:\\Users\\satish\\Documents\\New folder\\Sa\\report.html").toURI()); 
       // Desktop.getDesktop().browse(new File("AllTests.html").toURI()); 
       // Desktop.getDesktop().browse(new File("FailedTests.html").toURI()); 
      //  Desktop.getDesktop().browse(new File("SkipAndWaning.html").toURI()); 
        
	}		
		private static ExtentTest createTest(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
		public static String captureScreenshot() {
		TakesScreenshot TS = (TakesScreenshot)driver;
		String base64Code=TS.getScreenshotAs(OutputType.BASE64);
		
		System.out.println("Screenshot saved sucessfully");
		return base64Code;
		
	}
		public static String captureScreenshot(String filename) {
			TakesScreenshot TS = (TakesScreenshot)driver;
			File src=TS.getScreenshotAs(OutputType.FILE);
		File dsc= new File("./Screenshots/"+filename);
			
			try {
				
				FileUtils.copyDirectory(src, dsc);
		}catch(Exception e) {
			e.printStackTrace();
		}
			System.out.println("Screenshot saved sucessfully");
			return dsc.getAbsolutePath();
			
		}
	

	
}

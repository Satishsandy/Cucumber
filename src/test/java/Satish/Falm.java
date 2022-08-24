package Satish;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Falm {

	public static void main(String[] args) {
		  ExtentReports extent = new ExtentReports();
	         ExtentSparkReporter Spark = new ExtentSparkReporter("C:\\Users\\satish\\Documents\\New folder\\reports.html"); 
	         extent.attachReporter(Spark);
	}

}

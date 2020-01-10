package com.assignment.vl.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass {
	
	public ExtentTest logger;
	public static String timeStamp;

	/**
	 * This method is called only once to start reporting in @BeforeSuite.
	 * It creates a folder with time stamp as folder name every time.
	 * Added few informatiom to the report.
	 * */
	
	public ExtentReports startReport() {
		
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent = new ExtentReports();
		
		try {
			timeStamp = getCurrentTimeStamp();
			
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+timeStamp+"/Automation_Report.html");
	       
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("Project", "Automation");
			extent.setSystemInfo("Test - Machine", System.getProperty("os.name"));
			
			htmlReporter.config().setDocumentTitle("Automation Report"); 
			htmlReporter.config().setReportName("Automation"); 
			htmlReporter.config().setTheme(Theme.DARK);		
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return extent;
	}

	
	public String getCurrentTimeStamp() {
		try {
			SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yyyy"+"_"+"HH-mm-ss");
			Date now = new Date();
			String timeStamp = currentDate.format(now);

			return timeStamp;
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
}

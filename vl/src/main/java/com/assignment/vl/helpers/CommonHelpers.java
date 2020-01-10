package com.assignment.vl.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.assignment.vl.base.BaseClass;
import com.assignment.vl.reports.ExtentReportsClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonHelpers {

	private static CommonHelpers instance = null;
	
	private CommonHelpers() {
		System.out.println("Common Helpers");
	}
	
	public static CommonHelpers getInstance() {
		if(instance == null) {
			instance = new CommonHelpers();
		}
		return instance;
	}

	
	public String getScreenShot(AppiumDriver<MobileElement> driver) throws IOException {
		String encodeBase64 = null;

		try {

			ExtentReportsClass extentReport = new ExtentReportsClass();

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = System.getProperty("user.dir") + "/Reports/"+ ExtentReportsClass.timeStamp + "/ScreenShots/"+ extentReport.getCurrentTimeStamp() +".jpeg";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			FileInputStream fileInputStreamReader = new FileInputStream(source);
			byte[] bytes = new byte[(int) source.length()];
			fileInputStreamReader.read(bytes);
			encodeBase64 = new String(Base64.encodeBase64(bytes));

			fileInputStreamReader.close();			

		}catch(Exception e) {
			e.printStackTrace();
		}
		return encodeBase64;

	}

	public void executeTestStep(String testStepDescription , boolean methodToExecute) {

		try {
			if(methodToExecute == false) {
				BaseClass.logger.log(Status.FAIL, "Failed while "+testStepDescription);
			}else if(methodToExecute == true){
				BaseClass.logger.log(Status.PASS, testStepDescription);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String recordTestStep(String testStep) {
		BaseClass.testStep = testStep;
		return testStep;
	}
	
	
}

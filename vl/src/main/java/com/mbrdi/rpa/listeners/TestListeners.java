package com.mbrdi.rpa.listeners;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.assignment.vl.base.BaseClass;
import com.assignment.vl.helpers.CommonHelpers;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestListeners implements ITestListener {
	
	CommonHelpers commonHelpers = CommonHelpers.getInstance();
	BaseClass baseclass;

	public void onTestFailure(ITestResult iTestResult) {
		String failedTestStep = BaseClass.testStep;
		AppiumDriver<MobileElement> driver = null; 

		try {
			driver = BaseClass.drivers.get(0);

			if(driver == null) {
				if(BaseClass.failedStep == null) {
					BaseClass.logger.log(Status.FAIL, "Failed while "+failedTestStep+"<br><br>"+ iTestResult.getThrowable());
				}else {
					BaseClass.logger.log(Status.FAIL, "Failed while "+failedTestStep+"<br><br>"+ BaseClass.failedStep+"<br><br>"+iTestResult.getThrowable());
				}

			}else {
				BaseClass.logger.log(Status.FAIL, "Failed while "+failedTestStep+"<br><br>"+ BaseClass.failedStep +"<br>", 
						MediaEntityBuilder.createScreenCaptureFromBase64String(commonHelpers.getScreenShot(driver)).build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

/**
 * This class contains TestNG annotations @BeforeSuite, @BeforeClass 
 * @BeforeMethod, @AfterSuite.
 * 
 * @author SuryaKiran Reddy
 */

package com.assignment.vl.base;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.assignment.vl.helpers.CommonHelpers;
import com.assignment.vl.helpers.ConfigLibrary;
import com.assignment.vl.helpers.DriverInitialization;
import com.assignment.vl.reports.ExtentReportsClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {
	private static ExtentReports extent; 
	public static String failedStep;
	private DriverInitialization driverInitialization = DriverInitialization.getInstance();
	public CommonHelpers commonHelpers = CommonHelpers.getInstance();
	protected AppiumDriver<MobileElement> driver;
	public static ExtentTest logger;
	public static String testStep;
	public static ArrayList<AppiumDriver<MobileElement>> drivers = new ArrayList<AppiumDriver<MobileElement>>();
	
	/**
	 * This method gets executed only once, before the suite gets executed.
	 * Report is initialised.
	 * 
	 * */
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentReportsClass extentReports = new ExtentReportsClass();
		extent = extentReports.startReport();

	}

	/**
	 * This method gets executed before every test class module.
	 * Driver is initialised and added to a list.
	 * 
	 * */
	
	@BeforeClass
	public void beforeClass() throws Exception{

		try {
			driver = driverInitialization.setupDriver();
			drivers.add(driver);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method gets executed before every test case.
	 * Driver activity is checked before starting the test case.
	 * If driver is not active the driver is initialised.
	 * 
	 * */
	
	@BeforeMethod
	public void beforeMethod(final Method method) throws Exception{
		logger = extent.createTest(method.getName()).assignCategory(method.getDeclaringClass().getSimpleName()).
				assignDevice(ConfigLibrary.class.newInstance().DEVICE_NAME);

		try {
			
			if(driver == null) {
				driver = driverInitialization.setupDriver();
				drivers.add(driver);

			}else {

				try {
					((AppiumDriver<MobileElement>) driver).getContextHandles();
					
				}catch(Exception e) {
					e.printStackTrace();
					driver = driverInitialization.setupDriver();
					drivers.add(driver);

				}
			}
		}catch(Exception e) {
			throw e;
		}

	}

	/**
	 * This method gets executed only once in an execution.
	 * Reporting is closed.
	 * 
	 * */
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}

}

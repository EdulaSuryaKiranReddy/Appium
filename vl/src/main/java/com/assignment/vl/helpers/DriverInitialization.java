/**
 * Class to initialise drivers
 * Start appium server using java. 
 * 
 * @author SuryaKiran Reddy
 * */

package com.assignment.vl.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;

public class DriverInitialization {

	private static DriverInitialization instance = null;

	public static DriverInitialization getInstance() {
		if(instance == null) {
			instance = new DriverInitialization();
		}
		return instance;
	}

	/**
	 * Method to initialise the driver.
	 * Method to start appium server locally
	 * Starts the appium server for OS type: Mac
	 * @throws Exception 
	 * */
	
	public AppiumDriver<MobileElement> setupDriver() throws Exception{
		AppiumDriver<MobileElement> driver = null;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		AppiumDriverLocalService service = null;
		String nodePath;
		File node = null;
		String appiumPath;
		File appium = null;
		ConfigLibrary deviceDetails = new ConfigLibrary();

		try {

			nodePath = "/usr/local/bin/node";
			node = new File(nodePath);

			if(!node.exists()) {
				throw new FileNotFoundException("Node.js not found at location: "+ nodePath);
			}

			appiumPath = "/usr/local/lib/node_modules/appium";
			appium = new File(appiumPath);

			if(!(appium.exists() && appium.isDirectory())) {
				System.out.println("Can't find appium in the root folder: "+ appiumPath);	
				System.out.println("Checking in Applications folder");

				appiumPath = "/Applications/Appium.app";
				appium = new File(appiumPath);

				if(!(appium.exists() && appium.isDirectory())) {
					System.out.println("Can't find appium in the applications folder too: "+ appiumPath);
					throw new FileNotFoundException("Appium not installed");
				}else {
					appiumPath = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";
					appium = new File(appiumPath);
				}					
			}else {
				appiumPath = appiumPath+"/build/lib/main.js";
				appium = new File(appiumPath);
			}



			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(node)
					.withAppiumJS(appium).
					//withArgument(deviceArg, deviceDetails.UDID).
					withArgument(sessionOverride).withIPAddress("127.0.0.1").
					usingPort(4723));

			service.start();
			Thread.sleep(2000);

			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceDetails.DEVICE_NAME);
//			desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceDetails.UDID);
			desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
			desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, deviceDetails.APP_PACKAGE);
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, deviceDetails.APP_ACTIVITY);
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceDetails.PLATFORM_NAME);
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceDetails.PLATFORM_VERSION);
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			desiredCapabilities.setCapability(MobileCapabilityType.APP, deviceDetails.APP_PATH);


			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return driver;
	}



	private ServerArgument deviceArg = new ServerArgument() {
		public String getArgument() {
			return "--device-name";
		}
	};

	/**
	 * Session override argument while starting the appium server.
	 * Over rides old service on the port if running.
	 * */
	
	private ServerArgument sessionOverride = new ServerArgument() {
		public String getArgument() {
			return "--session-override";
		}
	};

}

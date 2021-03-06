/**
 * class contains device information and app information required for appium driver initialisation
 * */

package com.assignment.vl.helpers;

public class ConfigLibrary {
	
	public final String DEVICE_NAME = "emulator-5554";
	public final String UDID = "88746a99";
	public final String APP_PACKAGE = "com.aaks.qaautomation";
	public final String APP_ACTIVITY = "com.aaks.qaautomation.MainActivity";
	public final String PLATFORM_NAME = "Android";
	public final String PLATFORM_VERSION = "7.0";
	public final String APP_PATH = System.getProperty("user.dir")+"/src/main/java/com/assignment/vl/config/app/app-debug.apk";

}

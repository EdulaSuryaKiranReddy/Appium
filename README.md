Pre-Requisites:

1.	Android SDK.
2.	Node.js
3.	Appium
4.	Java
5.	Java Editor (I’m using Eclipse).
6.	Maven 
7.	Test machine (I’m using Macbook).

The project is a maven project which includes TestNG & Page Object Model.

To use TestNG a plugin is required which has to be downloaded from Marketplace. If it is not found in market place then please follow the link provided to install TestNG plugin https://www.guru99.com/install-testng-in-eclipse.html


Code supports Appium installed using command line terminal and Appium GUI.

Running Tests:

Open project in Eclipse.
Change device details in 
/src/main/java/com/assignment/vl/helpers/ConfigLibrary.java

Udid of the device, platform name, platform version has to be changed accordingly

A TestNG.xml file is present inside the project folder. 
Right click on TestNG.xml and click on Run as TestNG suite.


Troubleshooting:

Few versions of eclipse can’t read environment variables in bash profile.
So JAVA_HOME and ANDROID_HOME has to be added in the eclipse.

Right click on TestNG.xml and click on Run configurations -> Environment -> New -> Name: (JAVA_HOME or ANDROID_HOME) -> value: path to JAVA_HOME or ANDROID_HOME -> Apply & Run



package com.assignment.vl.tests;

import org.testng.annotations.Test;
import com.assignment.vl.base.BaseClass;
import com.assignment.vl.pages.EmployeePage;

public class EmployeeTest extends BaseClass{
	private EmployeePage employeePage;	

	/**
	 * Step1: Click on create employee button and verify all error messages.
	 * Step2: Enter employee first name & click on create employee and verify other three error messages.
	 * 
	 * */

	@Test(priority = 1)
	public void verifyErrorMessagesOnFillingIncompleteForm() throws Exception {
		String testStep;
		final String FIRST_NAME = "qaAutomation";

		testStep = "Click on Add Employee Button";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().clickOnAddEmployeeButton());

		testStep = "Click on Create Employee Button";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().clickOnCreateEmployee());

		testStep = "Verify Error messages with out filling form";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().verifyErrorMessages());

		testStep = "Filling the first name";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().enterFirstName(FIRST_NAME));
		
//		testStep = "Click on back button";
//		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().clickOnBackButton());
		
		testStep = "Click on Create Employee Button";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().clickOnCreateEmployee());

		testStep = "On filling the first name, verify last name error message";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().verifyLastNameErrorMessage());

		testStep = "On filling the first name, verify job title error message";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().verifyJobTitleErrorMessage());
		
		testStep = "On filling the first name, verify current project error message";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().verifyCurrentProjectErrorMessage());
		
		testStep = "Click on back button";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().clickOnBackButton());
		
		
	}
	
	/**
	 * Step1: Delete an employee from the list and verify employee is deleted.
	 * 
	 * */
	
	@Test(priority = 2)
	public void deleteEmployeeAndVerify() throws Exception {
		String testStep;

		testStep = "Delete Employee from the list and Verify";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().deleteEmployeeAndVerify());
		
	}
	
	/**
	 * Step1: add 2 employees and verify an advertisement is created.
	 * For test case robustness delete all the employees & advertisements in the list 
	 * 
	 * */
	
	@Test(priority = 3)
	public void verifyAdvertisementAppearsAfterEveryTwoEmployeesAdded() throws Exception {
		String testStep;

		testStep = "Delete all the Employees";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().deleteAllEmployees());
		
		testStep = "Delete all the advertisements";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().deleteAllAdvertisements());
		
		testStep = "Verify advertisement appears after every two employees added";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().addEmployeesAndVerifyAdvertisement());
			
	}
	
	/**
	 * Step 1: Add 9 employees in a loop
	 * Step 2: Delete users 1,2 & 10.
	 * Step 3: Delete all the advertisements.
	 * 
	 * 
	 * */
	
	@Test(priority = 4)
	public void Add_9_usersInALoopAndDelete_1_2_9_AndDismissAllAds() throws Exception {
		String testStep;

		testStep = "Add 9 employees in a loop";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().addNineEmployees());
		
		testStep = "Delete users 1,2 & 10";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().deleteUsers_1_2_10());
		
		testStep = "Delete all advertisements";
		commonHelpers.executeTestStep(commonHelpers.recordTestStep(testStep), getEmployeePageInstance().deleteAdvertisements());	
		
	}
	

	
	
	private EmployeePage getEmployeePageInstance() {
		try {
			if(employeePage == null) {
				employeePage = new EmployeePage(driver);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeePage;
	}
}

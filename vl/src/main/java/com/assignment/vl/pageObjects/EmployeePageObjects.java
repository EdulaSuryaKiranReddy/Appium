/**
 * Page Objects for the Employee page
 * */

package com.assignment.vl.pageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EmployeePageObjects {

	@AndroidFindBy(id = "fab")
	public MobileElement AddEmployeeButton;
	
	@AndroidFindBy(id = "adView")
	public List<MobileElement> AdvertisementBanners;
	
	@AndroidFindBy(id = "firstNameEditText")
	public MobileElement FirstNameTextField;
	
	@AndroidFindBy(id = "lastNameEditText")
	public MobileElement LastNameTextField;
	
	@AndroidFindBy(id = "titleSpinner")
	public MobileElement JobTitleSpinner;
	
	@AndroidFindBy(id = "projectSpinner")
	public MobileElement ProjectSpinner;
	
	@AndroidFindBy(id = "createButton")
	public MobileElement CreateEmployeeButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Qa Automation Engineer']")
	public MobileElement QaAutomationText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Qa Tester']")
	public MobileElement QaTester;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Associate Developer']")
	public MobileElement AssociateDeveloper;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Professional']")
	public MobileElement ProfessionalText;
	
	@AndroidFindBy(id = "validationFirstNameTextView")
	public MobileElement FirstNameErrorText;
	
	@AndroidFindBy(id = "validationLastNameTextView")
	public MobileElement LastNameErrorText;
	
	@AndroidFindBy(id = "validationProjectTextView")
	public MobileElement ProjectValidationErrorText;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout")
	public MobileElement EmployeeCell;
	
	@AndroidFindBy(id = "validationTitleTextView")
	public MobileElement JobTitleErrorText;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement BackButton;
	
	@AndroidFindBy(id = "fullNameTextView")
	public List<MobileElement> EmployeeCells_FullName;
	
	@AndroidFindBy(id = "deleteEmployeeButton")
	public MobileElement DeleteEmployeeButton;

	@AndroidFindBy(id = "adView")
	public MobileElement AdvertisementClose;
}

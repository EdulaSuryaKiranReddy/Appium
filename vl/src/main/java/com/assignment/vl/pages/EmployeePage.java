package com.assignment.vl.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.assignment.vl.base.BaseClass;
import com.assignment.vl.pageObjects.EmployeePageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class EmployeePage {

	private EmployeePageObjects pageObjects = new EmployeePageObjects();
	private AppiumDriver<MobileElement> driver;

	public EmployeePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), pageObjects);
	}

	public boolean clickOnAddEmployeeButton() throws Exception{
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "Add Employee Button is absent";
			pageObjects.AddEmployeeButton.click();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean enterFirstName(String firstName) throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "First Name text field is absent";
			pageObjects.FirstNameTextField.sendKeys(firstName);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean enterLastName(String lastName) throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "Last Name text field is absent";
			pageObjects.LastNameTextField.sendKeys(lastName);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean selectQaTesterJobTitle() throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "Job title spinner is absent";
			pageObjects.JobTitleSpinner.click();

			failedStep = "Qa Tester option is absent in job title spinner";
			pageObjects.QaTester.click();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}


	public boolean selectProfessionalCurrentProject() throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "Current Projecrt spinner is absent";
			pageObjects.ProjectSpinner.click();

			failedStep = "Professional option is absent in Current Project";
			pageObjects.ProfessionalText.click();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}


	public boolean clickOnCreateEmployee() throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "Professional option is absent in Current Project";
			pageObjects.CreateEmployeeButton.click();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}


	public boolean verifyFirstNameErrorMessage() throws Exception {
		String failedStep = null;
		boolean flag = false;
		String actualText;
		final String expectedText = "First Name is Required";

		try {
			failedStep = "First Name Error message text is absent";
			actualText = pageObjects.FirstNameErrorText.getText();

			failedStep = "Error message incorrect";
			Assert.assertEquals(actualText, expectedText);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean verifyLastNameErrorMessage() throws Exception {
		String failedStep = null;
		boolean flag = false;
		String actualText;
		final String expectedText = "Last Name is Required";

		try {
			failedStep = "Last Name Error message text is absent";
			actualText = pageObjects.LastNameErrorText.getText();

			failedStep = "Error message incorrect";
			Assert.assertEquals(actualText, expectedText);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean verifyJobTitleErrorMessage() throws Exception {
		String failedStep = null;
		boolean flag = false;
		String actualText;
		final String expectedText = "Position is Required";

		try {
			failedStep = "Job Title Error message text is absent";
			actualText = pageObjects.JobTitleErrorText.getText();

			failedStep = "Error message incorrect";
			Assert.assertEquals(actualText, expectedText);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean verifyCurrentProjectErrorMessage() throws Exception {
		String failedStep = null;
		boolean flag = false;
		String actualText;
		final String expectedText = "Project is Required";

		try {
			failedStep = "Current Project Error message text is absent";
			actualText = pageObjects.ProjectValidationErrorText.getText();

			failedStep = "Error message incorrect";
			Assert.assertEquals(actualText, expectedText);

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean verifyErrorMessages() throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {

			verifyFirstNameErrorMessage();
			verifyLastNameErrorMessage();
			verifyJobTitleErrorMessage();
			verifyCurrentProjectErrorMessage();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean clickOnBackButton() throws Exception {
		String failedStep = null;
		boolean flag = false;

		try {
			failedStep = "back button is absent";
			pageObjects.BackButton.click();

			flag = true;
		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}


	public boolean deleteEmployeeAndVerify() throws Exception {
		String failedStep = null;
		boolean flag = true;
		String name = null;

		try {

			if(pageObjects.EmployeeCells_FullName.size() == 0) {
				addNewEmployee();
			}

			for(MobileElement currentElement : pageObjects.EmployeeCells_FullName) {
				name = currentElement.getText();
				currentElement.click();

				failedStep = "Delete Employee Button is absent";
				pageObjects.DeleteEmployeeButton.click();Thread.sleep(1500);

				break;
			}


			for(MobileElement currentElement : pageObjects.EmployeeCells_FullName) {
				if(currentElement.getText().equals(name)) {
					flag = false;
					throw new Exception("Employee is not deleted ");
				}
			}


		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean addNewEmployee() throws Exception {
		String failedStep = null;
		boolean flag = true;

		try {

			failedStep = "Add New Employee button is absent";
			pageObjects.AddEmployeeButton.click();

			failedStep = "First name text field absent";
			pageObjects.FirstNameTextField.sendKeys(RandomStringUtils.randomAlphabetic(5));

			failedStep = "Last name text field is absent";
			pageObjects.LastNameTextField.sendKeys(RandomStringUtils.randomNumeric(4));

			failedStep = "Job title spinner is absent";
			pageObjects.JobTitleSpinner.click();

			failedStep = "Associate developer option in job title spinner is absent";
			pageObjects.AssociateDeveloper.click();

			failedStep = "Project spinner is absent";
			pageObjects.ProjectSpinner.click();

			failedStep = "Professional text in current project spinner is absent";
			pageObjects.ProfessionalText.click();

			failedStep = "Create Employee button is absent";
			pageObjects.CreateEmployeeButton.click();

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}


	public boolean deleteAllEmployees() throws Exception {
		String failedStep = null;
		boolean flag = true;
		System.out.println();

		try {
			int size = pageObjects.EmployeeCells_FullName.size();

			for(int counter=1; counter <= size; counter++) {
				driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView")).click();
				failedStep = "Delete Employee Button is absent";
				pageObjects.DeleteEmployeeButton.click();Thread.sleep(1500);
			}

			size = pageObjects.EmployeeCells_FullName.size();
			if(size > 0) {
				deleteAllEmployees();
			}

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean deleteAllAdvertisements() throws Exception {
		String failedStep = null;
		boolean flag = true;

		try {
			int size = pageObjects.AdvertisementBanners.size();

			for(int counter=1; counter <= size; counter++) {
				driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView")).click();Thread.sleep(1500);
				driver.findElement(By.xpath("//android.widget.TextView/..//android.widget.ImageView")).click();Thread.sleep(1500);
			}

			size = pageObjects.AdvertisementBanners.size();
			if(size > 0) {
				deleteAllAdvertisements();
			}

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean addEmployeesAndVerifyAdvertisement() throws Exception {
		String failedStep = null;
		boolean flag = true;

		try {

			for(int counter=1; counter<=2; counter++) {
				addNewEmployee();
			}

			if(!(pageObjects.AdvertisementBanners.size() == 1)) {
				throw new Exception("Advertisement is not created after creating two employees");
			}

			for(int counter=1; counter<=2; counter++) {
				addNewEmployee();
			}

			if(!(pageObjects.AdvertisementBanners.size() == 2)) {
				throw new Exception("Advertisement is not being created after creating two employees");
			}

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean addNineEmployees() throws Exception {
		String failedStep = null;
		boolean flag = true;

		try {

			for(int counter = 1; counter <= 9; counter++){
				addNewEmployee();
			}

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean deleteUsers_1_2_10() throws Exception {
		String failedStep = null;
		boolean flag = true;
		Set<String> employeeNames = new LinkedHashSet<String>(); 
		System.out.println();

		try {
			int size = pageObjects.EmployeeCells_FullName.size();

			for(int counter=1; counter <= size; counter++) {
				driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView")).click();
				failedStep = "Delete Employee Button is absent";
				pageObjects.DeleteEmployeeButton.click();Thread.sleep(1500);

				if(counter == 2) {
					break;
				}
			}

			Point p0 = pageObjects.AdvertisementBanners.get(0).getCenter();
			Point p1 = pageObjects.AdvertisementBanners.get(1).getCenter();

			boolean flag1 = false;
			List<String> list = new ArrayList<String>();
			for(int count = 1; count <= 5; count++) {
				size = pageObjects.EmployeeCells_FullName.size();
				for(int counter=1; counter <= size; counter++) {
					employeeNames.add(driver.findElement(By.xpath("(//android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'fullNameTextView')])["+counter+"]")).getText());

					if(employeeNames.size() == 8) {
						Iterator<String> it = employeeNames.iterator();
						while(it.hasNext()){
							list.add(it.next());
						}
						driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='"+list.get(7)+"']")).click();
						failedStep = "Delete Employee Button is absent";
						pageObjects.DeleteEmployeeButton.click();Thread.sleep(1500);
						flag1 = true;
						break;
					}
				}	

				if(flag1 == true) {
					break;
				}
				new TouchAction(driver).longPress(PointOption.point(p1.x, p1.y)).moveTo(PointOption.point(p0.x, p0.y)).release().perform();
			}

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
	}

	public boolean deleteAdvertisements() throws Exception {
		String failedStep = null;
		boolean flag = true;
		Point p0 = null;
		Point p1 = null;

		try {
			int size = pageObjects.AdvertisementBanners.size();
			
			if(size > 0) {
				 p0 = pageObjects.AdvertisementBanners.get(0).getCenter();
				 p1 = pageObjects.AdvertisementBanners.get(1).getCenter();
			}
			
			for(int counter=1; counter <= size; counter++) {
				driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView")).click();Thread.sleep(1500);
				driver.findElement(By.xpath("//android.widget.TextView/..//android.widget.ImageView")).click();Thread.sleep(1500);
			}

			size = pageObjects.AdvertisementBanners.size();
			if(size > 0) {
				deleteAllAdvertisements();
			}
			
			
			
			for(int count=1; count<=2; count++) {
				new TouchAction(driver).longPress(PointOption.point(p0.x, p0.y)).moveTo(PointOption.point(p1.x, p1.y)).release().perform();
				size = pageObjects.AdvertisementBanners.size();
				
				if(size > 0) {
					driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView")).click();Thread.sleep(1500);
					driver.findElement(By.xpath("//android.widget.TextView/..//android.widget.ImageView")).click();Thread.sleep(1500);
				}
			}

			
			

		}catch(Exception e) {
			BaseClass.failedStep = failedStep;
			throw e;
		}
		return flag;
		
		
	}
	
	
}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.CreateAccountDetailsPojo;
import utils.PropertiesFileReader;

public class CreateAccountPage extends PredefinedActions {

	private static CreateAccountPage createAccountPage;
	private PropertiesFileReader createAccountPageProp;
	
	private CreateAccountPage () {
		createAccountPageProp = new PropertiesFileReader(ConfigFilePath.CREATE_ACCOUNT_PAGE_PROPERTIES);
	}
	
	public static CreateAccountPage getInstance() {
		if(createAccountPage == null) {
			createAccountPage = new CreateAccountPage();
		}
		return createAccountPage;
	}

	public String getCreateAccountPageHeader() {
		return getElementText(createAccountPageProp.getValue("pageHeader"), true);
	}
	
	private void selectGender(boolean isMale) {
		System.out.println("STEP - Select title");
		 WebElement titleElement = isMale
				? getElement(createAccountPageProp.getValue("genderMale"), true)
				: getElement(createAccountPageProp.getValue("genderFemale"), true);
		clickOnElement(titleElement);
	}
	private void enterFirstName(String firstName) {
		System.out.println("STEP - Enter First Name");
		if(firstName!=null) {
			enterText(firstName, createAccountPageProp.getValue("firstName"), true);
		}
	}
	private void enterLastName(String lastName) {
		System.out.println("STEP - Enter Last Name");
		if(lastName != null) {
			enterText(lastName, createAccountPageProp.getValue("lastName"), true);
		}
	}
	private void enterPassword(String password) {
		System.out.println("STEP - Enter Password");
		if(password != null) {
			enterText(password, createAccountPageProp.getValue("password"), true);
		}
	}
	private void selectBirthdate(String day) {
		System.out.println("STEP - Select Birthdate from drop down");
		if(day != null) {
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-days"))).click();
			s = new Select(driver.findElement(By.id("days")));
			s.selectByValue(day);*/
			clickOnElement(createAccountPageProp.getValue("dayDropdown"), true);
			dropdownSelectByValue(day, createAccountPageProp.getValue("day"), false);
		}
	}
	private void selectMonth(String month) {
		System.out.println("STEP - Select Month from drop down");
		if (month!=null) {
			clickOnElement(createAccountPageProp.getValue("monthDropdown"), true);
			dropdownSelectByValue(month, createAccountPageProp.getValue("month"), false);
		}
	}
	private void selectYear(String year) {
		System.out.println("STEP - Select Year from drop down");
		if (year!=null) {
			clickOnElement(createAccountPageProp.getValue("yearDropdown"), true);
			dropdownSelectByValue(year, createAccountPageProp.getValue("year"), false);
		}
	}
	private void selectCompany(String company) {
		System.out.println("Step - Select Company Name");
		if(company!=null) {
			enterText(company, createAccountPageProp.getValue("company"), false);
		}
	}
	private void enterAddress(String address1) {
		System.out.println("STEP - Enter Address");
		if(address1!=null) {
			enterText(address1, createAccountPageProp.getValue("address"), false);
		}
	}
	private void enterCity(String city) {
		System.out.println("STEP - Enter City Name");
		if(city!=null) {
			enterText(city, createAccountPageProp.getValue("city"), false);
		}
	}
	private void enterState(String state) {
		System.out.println("STEP - Select State");
		if(state != null) {
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_state"))).click();
			s = new Select(driver.findElement(By.id("id_state")));
			s.selectByVisibleText(state);*/
			clickOnElement(createAccountPageProp.getValue("stateDropdown"), true);
			dropdownSelectByVisibleText(state, createAccountPageProp.getValue("stateSelect"), false);
		}
	}
	private void enterZipCode(String zipcode) {
		System.out.println("STEP - Enter Zipcode");
		if(zipcode != null)
			enterText(zipcode, createAccountPageProp.getValue("zipCode"), false);
	}
	private void enterAdditionalInfo(String additionalInfo) {
		System.out.println("STEP - Enter Additional Information");
		if(additionalInfo != null) {
			enterText(additionalInfo, createAccountPageProp.getValue("additionalInfo"), false);
		}
	}
	private void enterHomePhone(String homePhone) {
		System.out.println("STEP - Enter HomePhone number");
		if (homePhone != null) {
			enterText(homePhone, createAccountPageProp.getValue("homePhone"), false);
		}
	}
	private void enterMobileNumber(String mobileNumber) {
		System.out.println("STEP - Enter Mobile number");
		if (mobileNumber != null) {
			enterText(mobileNumber, createAccountPageProp.getValue("mobileNumber"), false);
		}
	}
	
	public void enterCreateAccountDetails(CreateAccountDetailsPojo createAccountDetailsPojo) {
		selectGender(createAccountDetailsPojo.isMale());
		enterFirstName(createAccountDetailsPojo.getFirstName());
		enterLastName(createAccountDetailsPojo.getLastName());
		enterPassword(createAccountDetailsPojo.getPassword());
		selectBirthdate(createAccountDetailsPojo.getDays());
		selectMonth(createAccountDetailsPojo.getMonth());
		selectYear(createAccountDetailsPojo.getYear());
		selectCompany(createAccountDetailsPojo.getCompany());
		enterAddress(createAccountDetailsPojo.getAddress1());
		enterCity(createAccountDetailsPojo.getCity());
		enterState(createAccountDetailsPojo.getState());
		enterZipCode(createAccountDetailsPojo.getZipcode());
		enterAdditionalInfo(createAccountDetailsPojo.getAdditionalInfo());
		enterHomePhone(createAccountDetailsPojo.getHomePhone());
		enterMobileNumber(createAccountDetailsPojo.getMobilePhone());
	}

	public MyProfilePage clickOnRegistration() {
		System.out.println("STEP: Click on Registration button after entring all details");
		clickOnElement(createAccountPageProp.getValue("registrationBtn"), true);
		return MyProfilePage.getInstance();
	}
	
	public List<String> getErrorMessage() {
		
		List<WebElement> listOfErrorElements = getElementsList(createAccountPageProp.getValue("errorList"), true);
		List<String> listOfErrorText =  new ArrayList<String>();
		String errorHeadingText = getElementText(createAccountPageProp.getValue("errorHeader"), false);
		listOfErrorText.add(errorHeadingText);
		for (WebElement element : listOfErrorElements) {
			listOfErrorText.add(getElementText(element));
		}
		return listOfErrorText;
	}
}

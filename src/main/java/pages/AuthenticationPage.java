package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class AuthenticationPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static AuthenticationPage authenticationPage;
	
	private PropertiesFileReader authPageProp;
	private AuthenticationPage() {
		authPageProp = new PropertiesFileReader(ConfigFilePath.AUTHENTICATION_PAGE_PROPERTIES);
	}

	public static AuthenticationPage getInstance() {
		if (authenticationPage == null)
			authenticationPage = new AuthenticationPage();

		return authenticationPage;
	}

	public void enterEmailAddressInCreateAccount(String emailId) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(authPageProp.getValue("createAccountEmail")))).sendKeys(emailId);
		enterText(emailId, authPageProp.getValue("createAccountEmail"), true);
	}

	public CreateAccountPage clickOnCreateAccount() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id(authPageProp.getValue("createAccountSubmit")))).click();
		clickOnElement(authPageProp.getValue("createAccountSubmit"), true);
		return CreateAccountPage.getInstance();
	}

	public boolean isAuthenticationHeaderVisible() {
		//WebElement authenticationHeader = getElement(authPageProp.getValue("pageHeader"), true);
		//return authenticationHeader.isDisplayed();
		return isElementDispalyed(authPageProp.getValue("pageHeader"), true);
	}

	public MyProfilePage doLogin(String emailID, String password) {
		enterEmailIdInLogin(emailID);
		enterPasswordInLogin(password);
		clickOnSignInButton();
		return MyProfilePage.getInstance();
	}

	public void enterEmailIdInLogin(String emailID) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(authPageProp.getValue("loginEmail")))).sendKeys(emailID);
		enterText(emailID, authPageProp.getValue("loginEmail"), true);
		System.out.println("Email id entered for login");
	}

	public void enterPasswordInLogin(String password) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(authPageProp.getValue("loginPassword")))).sendKeys(password);
		enterText(password, authPageProp.getValue("loginPassword"), false);
		System.out.println("Password entered for login");
	}

	public void clickOnSignInButton() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id(authPageProp.getValue("signInButton")))).click();
		clickOnElement(authPageProp.getValue("signInButton"), true);
		System.out.println("Signin button clicked");
	}

	public String verifyErrorMessage() {
		//return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(authPageProp.getValue("errorMessage")))).getText();
		return getElementText(authPageProp.getValue("errorMessage"), true);
	}

}

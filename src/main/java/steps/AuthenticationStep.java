package steps;

import cucumber.api.java.en.When;
import pages.AuthenticationPage;

public class AuthenticationStep {

	private AuthenticationPage authenticationPage = AuthenticationPage.getInstance();;

	@When("^user enter username in email address on authentication page$")
	public void user_enter_username_in_email_address_on_authentication_page() throws Throwable {
		authenticationPage.enterEmailIdInLogin("automation07@gmail.com");
	}

	@When("^user enter password in password area on authentication page$")
	public void user_enter_password_in_password_area_on_authentication_page() throws Throwable {
		authenticationPage.enterPasswordInLogin("auto_123");
	}

	@When("^user click on sign in button on authentication page$")
	public void user_click_on_sign_in_button_on_authentication_page() throws Throwable {
		authenticationPage.clickOnSignInButton();
	}

	@When("^user enter \"(.*)\" in email address on authentication page$")
	public void user_enter_in_email_address_on_authentication_page(String emailAddress) throws Throwable {
		authenticationPage.enterEmailIdInLogin(emailAddress);
	}

	@When("^user enter \"(.*)\" in password area on authentication page$")
	public void user_enter_in_password_area_on_authentication_page(String password) throws Throwable {
		authenticationPage.enterPasswordInLogin(password);
	}

	@When("^user click on \"(.*)\" button on authentication page$")
	public void user_click_on_button_on_authentication_page(String buttonName) throws Throwable {
		switch (buttonName.toUpperCase()) {
		case "SIGN IN":
			authenticationPage.clickOnSignInButton();
			break;

		case "CONTACTUS":
			authenticationPage.clickOnSignInButton();
		default:
			break;
		}
	}

}

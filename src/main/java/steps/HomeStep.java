package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomeStep {

	private HomePage homePage;

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		homePage = HomePage.getInstance();
	}

	@When("^user click on sign in button on home page$")
	public void user_click_on_sign_in_button_on_home_page() throws Throwable {
		homePage.clickOnSignIn();
	}

}

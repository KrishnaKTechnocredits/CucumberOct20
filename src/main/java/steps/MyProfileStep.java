package steps;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import pages.MyProfilePage;

public class MyProfileStep {

	@Then("^user verify my profile page is displayed$")
	public void user_verify_my_profile_page_is_displayed() throws Throwable {
		MyProfilePage myProfilePage = MyProfilePage.getInstance();
		String expected = "Automation Technocredits";
		String actual = myProfilePage.getUserFullName();
		Assert.assertEquals("Verification of User Name failed", expected, actual);
	}
}

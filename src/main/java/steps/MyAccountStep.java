package steps;

import org.junit.Assert;

import cucumber.api.java.en.When;
import pages.MyProfilePage;

public class MyAccountStep {

	MyProfilePage myProfilePage = MyProfilePage.getInstance();

	@When("^user full name display as \"([^\"]*)\"$")
	public void user_full_name_display_as(String fullName) throws Throwable {
		String actual = myProfilePage.getUserFullName();
		Assert.assertEquals(actual, fullName);
	}

	@When("^user click on \"([^\"]*)\" section$")
	public void user_click_on_section(String section) throws Throwable {
		myProfilePage.selectSection(section);
	}

}

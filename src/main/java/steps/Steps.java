package steps;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class Steps {

	@Given("^user is on application page$")
	public void user_is_on_application_page() throws Throwable {
	}

	@When("^user added items on home page$")
	public void user_enter_credentials_on_home_page(DataTable table) throws Throwable {
		List<DataTableRow> tableRow = table.getGherkinRows();
		System.out.println("Total rows : " + tableRow.size());
		for (DataTableRow row : tableRow) {
			List<String> cells = row.getCells();
			for (String cell : cells) {
				System.out.println(cell);
			}
		}
	}

	@When("^user click on login button on home page$")
	public void user_click_on_login_button_on_home_page() throws Throwable {
	}

	@Then("^verify user land on profile page$")
	public void verify_user_land_on_profile_page() throws Throwable {
	}

}

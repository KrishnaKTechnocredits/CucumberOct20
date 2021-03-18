
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantPath.ConfigFilePath;

public class DataBaseConnection {

	// @Test
	public void getvalurFromUI() {
		System.setProperty("webdriver.chrome.driver", ConfigFilePath.WINDOWS_CHROMEDRIVER);
		System.out.println("STEP: Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("STEP: Navigate to Application");
		driver.get("http://automationbykrishna.com/");
		List<Employee> empList = new ArrayList<>();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demotable"))).click();
		int totalRow = driver.findElements(By.cssSelector("#table1 tbody tr")).size();
		for (int i = 1; i <= totalRow; i++) {
			int totalCol = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td")).size();
			Employee e = new Employee();
			e.setSr(driver.findElement(By.xpath(("//table[@id='table1']//tbody/tr[" + i + "]/td[1]"))).getText());
			e.setFirstname(
					driver.findElement(By.xpath(("//table[@id='table1']//tbody/tr[" + i + "]/td[2]"))).getText());
			e.setLastname(driver.findElement(By.xpath(("//table[@id='table1']//tbody/tr[" + i + "]/td[3]"))).getText());
			e.setUserName(driver.findElement(By.xpath(("//table[@id='table1']//tbody/tr[" + i + "]/td[4]"))).getText());
			empList.add(e);
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		getValueFromDB();
	}

	public static void getValueFromDB() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"harsh9846");

		System.out.println("Connection created......");

		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery("");

		List empList = new ArrayList<>();

		while (result.next()) {
			Employee employee = new Employee();

			employee.setFirstname(result.getString("firstname"));
			employee.setLastname(result.getString("lastname"));
			employee.setUserName((result.getString("username")));
			employee.setSr(result.getString("sr"));

			empList.add(employee);
		}
	}

}

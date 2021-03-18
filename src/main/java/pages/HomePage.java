package pages;

import org.openqa.selenium.WebElement;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class HomePage extends PredefinedActions {

	private static HomePage homePage;
	private PropertiesFileReader homePageProp;
	
	private HomePage() {
		homePageProp = new PropertiesFileReader(ConfigFilePath.HOME_PAGE_PROPERTIES);
	}
	
	public static HomePage getInstance() {
		if(homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}
	public AuthenticationPage clickOnSignIn() {
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_user_info>a"))).click();*/
		WebElement signInElement = getElement(homePageProp.getValue("signInButton"), true);
		clickOnElement(signInElement);
		//clickOnElement(homePageProp.getValue("signInButton"), true);   // either line25,26 or line 27
		System.out.println("Clicked on sign in");
		return AuthenticationPage.getInstance();
	}
}

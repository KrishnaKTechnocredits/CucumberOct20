package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class MyProfilePage extends PredefinedActions{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static MyProfilePage myProfilePage;
	private PropertiesFileReader myProfilePageProp;
	
	private MyProfilePage() {
		myProfilePageProp = new PropertiesFileReader(ConfigFilePath.MYPROFILE_PAGE_PROPERTIES);
	}
	
	public static MyProfilePage getInstance() {
		if(myProfilePage == null) {
			myProfilePage = new MyProfilePage();
		}
		return myProfilePage;
	}
	
	public String getUserFullName() {
		return getElementText(myProfilePageProp.getValue("userNameFull"), true);
	}
	
	public ProductCategoryPage selectSection(String sectionName) {
		List<WebElement> listOfSections = getElementsList(myProfilePageProp.getValue("selectSection"), true);
		for(WebElement element : listOfSections) {
			if(getElementText(element).equalsIgnoreCase(sectionName)) {
				clickOnElement(element);
				System.out.println(sectionName + " section is selected successfully");
				break;
			}
		}	
		return ProductCategoryPage.getInstance();
	}
}

package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class CheckoutAddressesPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	private static CheckoutAddressesPage checkoutAddressesPage;
	private PropertiesFileReader addressPageProp;

	private CheckoutAddressesPage() {
		addressPageProp = new PropertiesFileReader(ConfigFilePath.CHECKOUT_ADDRESS_PAGE_PROPERTIES);
	}

	public static CheckoutAddressesPage getInstance() {
		if (checkoutAddressesPage == null) {
			checkoutAddressesPage = new CheckoutAddressesPage();
		}
		return checkoutAddressesPage;
	}

	public List<String> getDeliveryAddress() {
		List<WebElement> listOfDeliveryAddress = getElementsList(addressPageProp.getValue("deliveryAdrress"), true);
		List<String> deliveryAddress = new ArrayList<String>();
		for (WebElement element : listOfDeliveryAddress) {
			deliveryAddress.add(getElementText(element));
		}
		return deliveryAddress;

	}

	public List<String> getBillingAddress() {
		List<WebElement> listOfBillingAddress = getElementsList(addressPageProp.getValue("billingAddress"), true);
		List<String> billingAddress = new ArrayList<>();
		for (WebElement element : listOfBillingAddress) {
			billingAddress.add(getElementText(element));
		}
		return billingAddress;
	}

	public void selectCheckbox() {
		WebElement checkbox = getElement(addressPageProp.getValue("checkbox"), true);
		if (getElementAttribute(checkbox,"class").equals("checked"))
			System.out.println("Checkbox is already clicked");
		else
			clickOnElement(checkbox);
	}

	public CheckoutShippingPage clickOnProceedToCheckout() {
		clickOnElement(addressPageProp.getValue("proceedToCheckoutButton"), true);
		return CheckoutShippingPage.getInstance();
	}
}

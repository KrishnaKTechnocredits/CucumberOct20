package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class CheckoutShippingPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static CheckoutShippingPage checkoutShippingPage;
	private PropertiesFileReader shippingPageprop;
	
	private CheckoutShippingPage() {
		shippingPageprop = new PropertiesFileReader(ConfigFilePath.CHECKOUT_SHIPPING_PAGE_PROPERTIES);
	}
	
	public static CheckoutShippingPage getInstance() {
		if(checkoutShippingPage==null) {
			checkoutShippingPage = new CheckoutShippingPage();
		}
		return checkoutShippingPage;
	}

	public String getShippingPrice() {
		return getElementText(shippingPageprop.getValue("shippingPrice"), true).trim().substring(1);
	}

	public void selectCheckbox() {
		System.out.println("STEP: Select Checkbox");
		clickOnElement(shippingPageprop.getValue("checkbox"), true);
	}
	
	public CheckoutPaymentPage clickOnProceedToCheckout() {
		clickOnElement(shippingPageprop.getValue("proceedToCheckoutBtn"), false);
		return CheckoutPaymentPage.getInstance();
	}
	
	public String verifyErrorMessage() {
		String errorMessage = getElementText(shippingPageprop.getValue("errorMessage"), true);
		closeError();
		return errorMessage;
	}
	
	private void closeError() {
		clickOnElement(shippingPageprop.getValue("closeError"), true);
	}
}

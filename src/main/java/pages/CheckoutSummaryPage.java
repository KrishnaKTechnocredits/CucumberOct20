package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class CheckoutSummaryPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static CheckoutSummaryPage checkoutSummaryPage;
	private PropertiesFileReader summaryPageprop;

	private CheckoutSummaryPage() {
		summaryPageprop = new PropertiesFileReader(ConfigFilePath.CHECKOUT_SUMMARY_PAGE_PROPERTIES);
	}

	public static CheckoutSummaryPage getInstance() {
		if (checkoutSummaryPage == null) {
			checkoutSummaryPage = new CheckoutSummaryPage();
		}
		return checkoutSummaryPage;
	}

	public String getProductName() {
		return getElementText(summaryPageprop.getValue("productName"), true);
	}

	public String getSizeAndColor() {
		return getElementText(summaryPageprop.getValue("sizeAndColor"), false);
	}

	public String getUnitPrice() {
		return getElementText(summaryPageprop.getValue("unitPrice"), false).substring(1);
	}

	public String getQuantity() {
		return getElementAttribute("value", summaryPageprop.getValue("quantity"), false);
	}

	public String getTotalPrice() {
		return getElementText(summaryPageprop.getValue("totalPrice"), false).substring(1);
	}

	public String getShippingPrice() {
		return getElementText(summaryPageprop.getValue("shippingPrice"), false).substring(1);
	}

	public String getFinalPrice() {
		return getElementText(summaryPageprop.getValue("finalPrice"), false).substring(1);
	}

	public CheckoutAddressesPage clickOnProceedToCheckout() {
		clickOnElement(summaryPageprop.getValue("proceedToCheckoutBtn"), true);
		return CheckoutAddressesPage.getInstance();
	}
}

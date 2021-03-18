package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class CheckoutPaymentPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static CheckoutPaymentPage checkoutPaymentPage;
	private PropertiesFileReader paymentPageprop;
	
	private CheckoutPaymentPage() {
		paymentPageprop = new PropertiesFileReader(ConfigFilePath.CHECKOUT_PAYMENT_PAGE_PROPERTIES);
	}
	
	public static CheckoutPaymentPage getInstance() {
		if(checkoutPaymentPage==null) {
			checkoutPaymentPage = new CheckoutPaymentPage();
		}
		return checkoutPaymentPage;
	}
	
	public String getPageHeading() {
		return getElementText(paymentPageprop.getValue("pageHeading"), true);
	}
	
	public String getProductName() {
		return getElementText(paymentPageprop.getValue("productName"), true);
	}

	public String getUnitPrice() {
		return getElementText(paymentPageprop.getValue("unitPrice"), true).substring(1);
	}

	public String getQuantity() {
		return getElementText(paymentPageprop.getValue("quantity"), true).trim();
	}

	public String getTotalPrice() {
		return getElementText(paymentPageprop.getValue("totalPrice"), true).trim().substring(1);
	}

	public String getShippingPrice() {
		return getElementText(paymentPageprop.getValue("shippingPrice"), true).substring(1);
	}

	public String getFinalPrice() {
		return getElementText(paymentPageprop.getValue("finalPrice"), true).substring(1);
	}
	
	public ChequePaymentPage clickOnPayByCheque() {
		clickOnElement(paymentPageprop.getValue("payByChequeButton"), true);
		return ChequePaymentPage.getInstance();
	}
	
	public BankPaymentPage clickOnPayByBankWire() {
		clickOnElement(paymentPageprop.getValue("payByBankButton"), true);
		return BankPaymentPage.getInstance();
	}
}

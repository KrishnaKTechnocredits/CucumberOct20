package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class ChequePaymentPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver,30);
	private static ChequePaymentPage chequePaymentPage;
	private PropertiesFileReader chequePayPageprop;

	private ChequePaymentPage() {
		chequePayPageprop = new PropertiesFileReader(ConfigFilePath.CHEQUE_PAYMENT_PAGE_PROPERTIES);
	}
	
	public static ChequePaymentPage getInstance() {
		if(chequePaymentPage == null) {
			chequePaymentPage = new ChequePaymentPage();
		}
		return chequePaymentPage;
	}
	
	public String getPageHeading() {
		return getElementText(chequePayPageprop.getValue("pageHeader"), true);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		clickOnElement(chequePayPageprop.getValue("confirmOrderBtn"), true);
		return OrderConfirmationPage.getInstance();
	}
	
	public CheckoutPaymentPage clickOnOtherPaymentMethods() {
		clickOnElement(chequePayPageprop.getValue("otherPaymentBtn"), true);
		return CheckoutPaymentPage.getInstance();
	}
}

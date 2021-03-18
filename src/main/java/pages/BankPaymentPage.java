package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class BankPaymentPage extends PredefinedActions{

	WebDriverWait wait = new WebDriverWait(driver,30);
	private static BankPaymentPage bankPaymentPage;
	private PropertiesFileReader bankPayPageProp;
	
	private BankPaymentPage() {
		bankPayPageProp = new PropertiesFileReader(ConfigFilePath.BANK_PAYMENT_PAGE_PROPERTIES);
	}
	
	public static BankPaymentPage getInstance() {
		if(bankPaymentPage==null) {
			bankPaymentPage = new BankPaymentPage();
		}
		return bankPaymentPage;
	}
	
	public String getPageHeading() {
		return getElementText(bankPayPageProp.getValue("pageHeader"), true).trim();
	}
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		clickOnElement(bankPayPageProp.getValue("confirmOrderClick"), true);
		return OrderConfirmationPage.getInstance();
	}
	
	public CheckoutPaymentPage clickOnOtherPaymentMethods() {
		clickOnElement(bankPayPageProp.getValue("otherPaymentClick"), true);
		return CheckoutPaymentPage.getInstance();
	}
}

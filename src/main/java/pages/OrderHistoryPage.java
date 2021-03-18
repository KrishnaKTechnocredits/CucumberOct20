package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class OrderHistoryPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static OrderHistoryPage orderHistoryPage;
	private PropertiesFileReader orderHistoryPageprop;

	private OrderHistoryPage() {
		orderHistoryPageprop = new PropertiesFileReader(ConfigFilePath.ORDER_HISTORY_PAGE_PROPERTIES);
	}

	public static OrderHistoryPage getInstance() {
		if (orderHistoryPage == null)
			orderHistoryPage = new OrderHistoryPage();

		return orderHistoryPage;
	}

	public String getPageHeading() {
		return getElementText(orderHistoryPageprop.getValue("pageHeader"), true);
	}

	public String getOrderNumber() {
		return getElementText(orderHistoryPageprop.getValue("orderNumber"), true).trim();
	}

	public String getDateOfOrder() {
		return getElementText(orderHistoryPageprop.getValue("dateOfOrder"), true).trim();
	}

	public String getTotalOrderPrice() {
		return getElementText(orderHistoryPageprop.getValue("totaPrice"), true).trim().substring(1);
	}

	public String getPaymentMethod() {
		return getElementText(orderHistoryPageprop.getValue("paymentMethod"), true);
	}

	public void downloadInvoice() {
		clickOnElement(orderHistoryPageprop.getValue("downloadInvoice"), true);
	}

	public void clickOnDetailsButton() {
		clickOnElement(orderHistoryPageprop.getValue("detailsButton"), true);
	}

	public void clickOnReorderButton() {
		clickOnElement(orderHistoryPageprop.getValue("reorderButton"), true);
	}

	public void clickOnBackToAccountButton() {
		clickOnElement(orderHistoryPageprop.getValue("backToAccountButton"), true);
	}

	public void clickOnHomeButton() {
		clickOnElement(orderHistoryPageprop.getValue("homeButton"), true);
	}
}

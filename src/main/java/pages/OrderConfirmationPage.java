package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import utils.PropertiesFileReader;

public class OrderConfirmationPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	private static OrderConfirmationPage orderConfirmationPage;
	private PropertiesFileReader orderConfirmPageprop;

	private OrderConfirmationPage() {
		orderConfirmPageprop = new PropertiesFileReader(ConfigFilePath.ORDER_CONFIRMATION_PAGE_PROPERTIES);
	}

	public static OrderConfirmationPage getInstance() {
		if (orderConfirmationPage == null)
			orderConfirmationPage = new OrderConfirmationPage();

		return orderConfirmationPage;
	}

	public String getPageHeading() {
		return getElementText(orderConfirmPageprop.getValue("pageHeading"), true).toUpperCase();
	}

	public String getAmountToBePaid() {
		return getElementText(orderConfirmPageprop.getValue("amountToPay"), true).substring(1);
	}
	/*
	 * public String getOrderReferenceDetails() { String s =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "//div[@class='box']//text()[6]"))).getText(); return s; }
	 */

	public OrderHistoryPage clickOnBackToOrders() {
		clickOnElement(orderConfirmPageprop.getValue("backToOrdersBtn"), true);
		return OrderHistoryPage.getInstance();
	}

	/*
	 * public boolean isSuccessAlertDisplayed() { return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
	 * "p.alert.alert-success"))).isDisplayed(); }
	 */

}

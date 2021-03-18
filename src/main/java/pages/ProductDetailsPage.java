package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.ProductDetailsPojo;
import utils.PropertiesFileReader;

public class ProductDetailsPage extends PredefinedActions {

	private static ProductDetailsPage productDetailsPage;
	private PropertiesFileReader productDetailsPageProp;

	private ProductDetailsPage() {
		productDetailsPageProp = new PropertiesFileReader(ConfigFilePath.PRODUCT_DETAILS_PAGE_PROPERTIES);
	}

	public static ProductDetailsPage getInstance() {
		if (productDetailsPage == null)
			productDetailsPage = new ProductDetailsPage();

		return productDetailsPage;
	}

	public ProductDetailsPojo captureProductDetails(ProductDetailsPojo productDetailsPojo) {
		String productName = getElementText(productDetailsPageProp.getValue("productName"), true);
		String description = getElementText(productDetailsPageProp.getValue("description"), true);
		String unitPrice = getElementText(productDetailsPageProp.getValue("unitPrice"), true).substring(1);
		String quantity = getElementAttribute("value", productDetailsPageProp.getValue("quantity"), false);
		String size = getSelectedSize();
		String color = getElementAttribute("title", productDetailsPageProp.getValue("getColor"), true);
		double d = Double.parseDouble(unitPrice) * Integer.parseInt(quantity);
		String totalPrice = String.format("%.2f", d);

		productDetailsPojo.setProductName(productName);
		productDetailsPojo.setDescription(description);
		productDetailsPojo.setUnitPrice(unitPrice);
		productDetailsPojo.setQuantity(quantity);
		productDetailsPojo.setSize(size);
		productDetailsPojo.setColor(color);
		productDetailsPojo.setTotalPrice(totalPrice);

		return productDetailsPojo;
	}

	public void setQuantity(String numOfQuantity) {
		enterText(numOfQuantity, productDetailsPageProp.getValue("quantity"), true);
		System.out.println("quantity mentioned successfully");
	}

	public void setSize(String size) {
		/*
		 * Select select = new Select(driver.findElement(By.id("group_1")));
		 * select.selectByVisibleText(size);
		 */
		dropdownSelectByVisibleText(size, productDetailsPageProp.getValue("size"), false);
		System.out.println("size selected successfully");
	}

	public void setColor(String color) {
		List<WebElement> colorOptions = getElementsList(productDetailsPageProp.getValue("setColor"), false);
		for (WebElement element : colorOptions) {
			if (getElementAttribute(element, "title").equalsIgnoreCase(color)) {
				clickOnElement(element);
				break;
			}
		}
	}

	private String getSelectedSize() {
		String size = "";
		/*
		 * Select select = new
		 * Select(getElement(productDetailsPageProp.getValue("size"), false));
		 * List<WebElement> sizeOptions = select.getOptions();
		 */
		List<WebElement> sizeOptions = dropdownGetAllOptions(productDetailsPageProp.getValue("size"), false);
		for (WebElement element : sizeOptions) {
			if (isElementSelected(element)) {
				size = getElementAttribute(element, "title");
			}
		}
		return size;
	}

	public void clickOnAddToCart() {
		// driver.findElement(By.xpath("//button[@name='Submit']")).click();
		clickOnElement(productDetailsPageProp.getValue("addToCartBtn"), false);
	}

	public void verifyCartDetails(ProductDetailsPojo productDetailsPojo) {

		String productName = getElementText(productDetailsPageProp.getValue("cartProductName"), true);
		String colorAndSize = getElementText(productDetailsPageProp.getValue("cartColorAndSize"), true);
		String quantity = getElementText(productDetailsPageProp.getValue("cartQuantity"), true);
		String totalPrice = getElementText(productDetailsPageProp.getValue("cartTotalPrice"), true).substring(1);
		String totalShipping = getElementText(productDetailsPageProp.getValue("cartShippingPrice"), true).substring(1);
		String finalPrice = getElementText(productDetailsPageProp.getValue("cartFinalPrice"), true).substring(1);
		productDetailsPojo.setShippingPrice(totalShipping);
		productDetailsPojo.setFinalPrice(finalPrice);
		Assert.assertEquals("Product Name is not matching",productName, productDetailsPojo.getProductName());
		Assert.assertEquals("Product color and size is not matching",colorAndSize, productDetailsPojo.getColor() + ", " + productDetailsPojo.getSize());
		Assert.assertEquals("Product quantity is not matching",quantity, productDetailsPojo.getQuantity());
		Assert.assertEquals("Total products price is not matching",totalPrice, productDetailsPojo.getTotalPrice());
		double d = Double.parseDouble(productDetailsPojo.getTotalPrice())
				+ Double.parseDouble(productDetailsPojo.getShippingPrice());
		Assert.assertEquals("Total price including shipping is not matching",finalPrice, String.format("%.2f", d));
	}

	public CheckoutSummaryPage clickOnProceedToCheckout() {
		clickOnElement(productDetailsPageProp.getValue("proceedToCheckoutBtn"), false);
		return CheckoutSummaryPage.getInstance();
	}
}

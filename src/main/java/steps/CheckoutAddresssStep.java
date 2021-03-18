package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import pages.CheckoutSummaryPage;
import pojo.ProductDetailsPojo;

public class CheckoutAddresssStep {

	private ProductDetailsPojo productDetailsPojo;
	CheckoutSummaryPage checkoutSummaryPage = CheckoutSummaryPage.getInstance();

	public CheckoutAddresssStep(ProductDetailsPojo productDetailsPojo) {
		this.productDetailsPojo = productDetailsPojo;
	}

	@And("^user verify product details on checkout address page$")
	public void user_verify_product_details_on_checkout_address_page() {
		Assert.assertEquals("Product Name not matching on Shopping Summary page",checkoutSummaryPage.getProductName(), productDetailsPojo.getProductName());
		Assert.assertEquals("Product quantity not matching on Shopping Summary page",checkoutSummaryPage.getQuantity(), productDetailsPojo.getQuantity());
		Assert.assertEquals("Shipping not matching on Shopping Summary page",checkoutSummaryPage.getShippingPrice(), productDetailsPojo.getShippingPrice());
		Assert.assertEquals("Total price is not matching on Shopping Summary page",checkoutSummaryPage.getTotalPrice(), productDetailsPojo.getTotalPrice());
		Assert.assertEquals("Total price including shipping is not matching on Shopping Summary page",checkoutSummaryPage.getFinalPrice(), productDetailsPojo.getFinalPrice()	);
		Assert.assertEquals("Product unit price is not matching on Shopping Summary page",checkoutSummaryPage.getUnitPrice(), productDetailsPojo.getUnitPrice());
	}

}

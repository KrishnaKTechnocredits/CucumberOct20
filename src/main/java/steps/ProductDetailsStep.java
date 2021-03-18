package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductDetailsPage;
import pojo.ProductDetailsPojo;

public class ProductDetailsStep {

	ProductDetailsPage productDetailsPage = ProductDetailsPage.getInstance();

	private ProductDetailsPojo productDetailsPojo;

	public ProductDetailsStep(ProductDetailsPojo productDetailsPojo) {
		this.productDetailsPojo = productDetailsPojo;
	}

	@When("^user select size as \"([^\"]*)\" on product details page$")
	public void user_select_size_as_on_product_details_page(String size) throws Throwable {
		productDetailsPage.setSize(size);
	}

	@When("^user select Quantity as \"([^\"]*)\" on product details page$")
	public void user_select_Quantity_as_on_product_details_page(String quatity) throws Throwable {
		productDetailsPage.setQuantity(quatity);
	}

	@When("^user select color is \"([^\"]*)\" on product details page$")
	public void user_select_color_is_on_product_details_page(String color) throws Throwable {
		productDetailsPage.setColor("Blue");
	}

	@Then("^user verify product details on product details page$")
	public void user_verify_product_details_on_product_details_page() throws Throwable {
		productDetailsPojo = productDetailsPage.captureProductDetails(productDetailsPojo);
	}

	@Then("^user click on add to cart button on product details page$")
	public void user_click_on_add_to_cart_button_on_product_details_page() throws Throwable {
		productDetailsPage.clickOnAddToCart();
		productDetailsPage.verifyCartDetails(productDetailsPojo);
	}

	@Then("^user click on process and checkout on product details page$")
	public void user_click_on_process_and_checkout_on_product_details_page() throws Throwable {
		productDetailsPage.clickOnProceedToCheckout();
	}

}

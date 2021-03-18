package steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import pages.ProductCategoryPage;

public class ProductCategoryStep {

	ProductCategoryPage productCategoryPage = ProductCategoryPage.getInstance();
	private List<WebElement> productList;

	@When("^user verify product list is displayed on product category page$")
	public void user_verify_product_list_is_displayed() throws Throwable {
		productList = productCategoryPage.getProductList();
		Assert.assertTrue("No Products to purchase", productList.size() >= 1);
	}

	@When("^user select the first available product on page product category page$")
	public void user_select_the_first_available_product_on_page() throws Throwable {
		productCategoryPage.selectFirstAvailableProduct(productList);
	}
}

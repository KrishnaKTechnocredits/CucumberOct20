package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import exceptions.ProductNotAvailableException;
import utils.PropertiesFileReader;

public class ProductCategoryPage extends PredefinedActions {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	private static ProductCategoryPage productCategoryPage;
	private PropertiesFileReader productCategoryPageProp;

	private ProductCategoryPage() {
		productCategoryPageProp = new PropertiesFileReader(ConfigFilePath.PRODUCT_CATEGORY_PAGE_PROPERTIES);
	}

	public static ProductCategoryPage getInstance() {
		if (productCategoryPage == null)
			productCategoryPage = new ProductCategoryPage();

		return productCategoryPage;
	}

	public List<WebElement> getProductList() {
		return getElementsList(productCategoryPageProp.getValue("productList"), true);
	}

	public ProductDetailsPage selectFirstAvailableProduct(List<WebElement> productList) {
		try {
			if (productList.size() > 0)
				productList.get(0).click();
			else
				throw new ProductNotAvailableException("Product not available to select");
		} catch (ProductNotAvailableException e) {
			e.getMessage();
		}
		return ProductDetailsPage.getInstance();
	}
}

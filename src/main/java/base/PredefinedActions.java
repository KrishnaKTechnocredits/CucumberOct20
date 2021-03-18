package base;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantPath.ConfigFilePath;
import exceptions.ElementNotEnabledException;
import utils.TimeUtil;

public class PredefinedActions {

	protected static WebDriver driver;
	private static WebDriverWait wait;

	public static void start(String browser) {
		System.setProperty("webdriver.chrome.driver", ConfigFilePath.WINDOWS_CHROMEDRIVER);
		System.out.println("STEP: Launch browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		System.out.println("STEP: Navigate to Application");
		driver.get("http://automationpractice.com/index.php");
	}

	public static void close() {
		System.out.println("STEP - Close Browser");
		driver.close();
	}

	public static void captureScreenShot(String result) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./takeScreenShot/" + result + "_" + TimeUtil.getTimeStamp() + ".png"));
			// Files.copy(file, new File("./takeScreenShot/" + result + "_" +
			// TimeUtil.getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] captureScreenShotInbyteFormat() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		return src;
	}

	private String getLocatorType(String locator) {
		String locatorType = locator.split("]:-")[0].substring(1);
		return locatorType;
	}

	private String getLocatorValue(String locator) {
		String locatorValue = locator.split("]:-")[1];
		return locatorValue;
	}

	protected WebElement getElement(String locator, boolean isWaitRequired) {
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		wait = new WebDriverWait(driver, 30);
		WebElement element = null;
		switch (locatorType.toUpperCase()) {
		case "CSS":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				element = driver.findElement(By.cssSelector(locatorValue));
			break;

		case "XPATH":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				element = driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			else
				element = driver.findElement(By.id(locatorValue));
			break;
		case "CLASS":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			else
				element = driver.findElement(By.className(locatorValue));
			break;
		case "TAG":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			else
				element = driver.findElement(By.tagName(locatorValue));
			break;
		case "NAME":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			else
				element = driver.findElement(By.name(locatorValue));
			break;
		case "LINK":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			else
				element = driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIALLINK":
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			else
				element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			throw new InvalidParameterException("Invalid Locator Type");
		}
		return element;
	}

	protected List<WebElement> getElementsList(String locator, boolean isWaitRequired) {
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);

		List<WebElement> listOfElements = new ArrayList<WebElement>();
		switch (locatorType.toUpperCase()) {
		case "CSS":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
			else
				listOfElements = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "XPATH":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			else
				listOfElements = driver.findElements(By.xpath(locatorValue));
			break;
		case "ID":
			if (isWaitRequired)
				listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
			else
				listOfElements = driver.findElements(By.id(locatorValue));
			break;
		case "CLASS":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorValue)));
			else
				listOfElements = driver.findElements(By.className(locatorValue));
			break;
		case "TAG":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locatorValue)));
			else
				listOfElements = driver.findElements(By.tagName(locatorValue));
			break;
		case "NAME":
			if (isWaitRequired)
				listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
			else
				listOfElements = driver.findElements(By.name(locatorValue));
			break;
		case "LINK":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));
			else
				listOfElements = driver.findElements(By.linkText(locatorValue));
			break;
		case "PARTIALLINK":
			if (isWaitRequired)
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));
			else
				listOfElements = driver.findElements(By.partialLinkText(locatorValue));
			break;
		default:
			throw new InvalidParameterException("Invalid Locator Type");
		}
		return listOfElements;
	}

	protected void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	protected void clickOnElement(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		clickOnElement(element);
	}

	protected void clearText(WebElement element) {
		element.clear();
	}

	protected void enterText(String text, WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element.isEnabled()) {
			clearText(element);
			element.sendKeys(text);
		} else
			throw new ElementNotEnabledException("Text box is not enabled");
	}

	protected void enterText(String text, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		enterText(text, element);
	}

	protected void scrollToElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	protected boolean isElementDispalyed(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		scrollToElement(element);
		return element.isDisplayed();
	}

	protected boolean isElementSelected(WebElement element) {
		scrollToElement(element);
		return element.isSelected();
	}

	protected String getElementText(String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		return getElementText(element);
	}

	protected String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}

	protected String getElementAttribute(String attribute, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locator, isWaitRequired);
		scrollToElement(element);
		return element.getAttribute(attribute);
	}

	protected String getElementAttribute(WebElement element, String attribute) {
		scrollToElement(element);
		return element.getAttribute(attribute);
	}

	private Select getSelectClassObject(String locator, boolean isWaitRequired) {
		Select select = new Select(getElement(locator, isWaitRequired));
		return select;
	}

	protected List<WebElement> dropdownGetAllOptions(String locator, boolean isWaitRequired) {
		Select select = getSelectClassObject(locator, isWaitRequired);
		return select.getOptions();
	}

	protected void dropdownSelectByVisibleText(String text, String locator, boolean isWaitRequired) {
		Select select = getSelectClassObject(locator, isWaitRequired);
		select.selectByVisibleText(text);
	}

	protected void dropdownSelectByValue(String text, String locator, boolean isWaitRequired) {
		Select select = getSelectClassObject(locator, isWaitRequired);
		select.selectByValue(text);
	}

}
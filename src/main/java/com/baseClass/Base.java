package com.baseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static WebDriver initializeWebDriver(String browser) {

		try {
			String downloadFilepath = "/home/st/eclipse-workspace/Tcarts_FPO/Downloads";

			if (browser.equalsIgnoreCase("chrome")) {

				HashMap<String, Object> chromePrefs = new HashMap<>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);

				List<String> chromeArguments = new LinkedList<>();
				chromeArguments.add("incognito");
				chromeArguments.add("disable-plugins");
			    chromeArguments.add("disable-extensions");
				//chromeArguments.add("--headless");
				chromeArguments.add("--no-sandbox");
				chromeArguments.add("--disable-dev-shm-usage");
				chromeArguments.add("--disable-setuid-sandbox");
				chromeArguments.add("--disable-popup-blocking");
				chromeArguments.add("--ignore-certificate-errors");
				chromeArguments.add("deleteAllCookies");
				

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments(chromeArguments);

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("firefox")) {

				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.dir", downloadFilepath);
				firefoxProfile.setPreference("browser.download.useDownloadDir", true);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // Example
																											// MIME type

				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(firefoxProfile);

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options);

			} else if (browser.equalsIgnoreCase("edge")) {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}

			if (driver != null) {

				driver.manage().window().maximize();

			}
		} catch (Exception e) {

			System.err.println("An error occurred during WebDriver setup: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}

		return driver;
	}

	public static void navigate(String action, String url) {

		try {
			if (action.equalsIgnoreCase("to")) {
				driver.navigate().to(url);
			} else if (action.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (action.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (action.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else {
				System.err.println("Invalid navigation action: " + action);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while navigating: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void performMouseAction(String action, WebElement element) {

		try {
			Actions ac = new Actions(driver);
			if (action.equalsIgnoreCase("click")) {
				ac.click(element).build().perform();
			} else if (action.equalsIgnoreCase("rightclick")) {
				ac.contextClick(element).build().perform();
			} else if (action.equalsIgnoreCase("doubleclick")) {
				ac.doubleClick(element).build().perform();
			} else if (action.equalsIgnoreCase("mousehover")) {
				ac.moveToElement(element).build().perform();
			} else if (action.equalsIgnoreCase("dragdrop")) {
				// You would need to provide source and target elements as parameters
				// ac.dragAndDrop(source, target).build().perform();
			} else {
				System.err.println("Invalid mouse action: " + action);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while performing mouse action: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void handleAlert(String action, String input) {

		try {
			Alert alert = driver.switchTo().alert();
			if (action.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (action.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			} else if (action.equalsIgnoreCase("sendkeys")) {
				alert.sendKeys(input);
				alert.accept(); // After sending keys, you can choose to accept the alert
			} else {
				System.err.println("Invalid alert action: " + action);
			}
		} catch (NoAlertPresentException e) {
			System.err.println("No alert is present: " + e.getMessage());
			// Handle the absence of an alert or return an appropriate error status as
			// needed
		} catch (Exception e) {
			System.err.println("An error occurred while handling the alert: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void switchToFrame(String action, String value, WebElement element) {

		try {
			if (action.equalsIgnoreCase("id")) {
				driver.switchTo().frame(value);
			} else if (action.equalsIgnoreCase("index")) {
				int index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			} else if (action.equalsIgnoreCase("element")) {
				driver.switchTo().frame(element);
			} else if (action.equalsIgnoreCase("parent")) {
				driver.switchTo().parentFrame();
			} else if (action.equalsIgnoreCase("main")) {
				driver.switchTo().defaultContent();
			} else {
				System.err.println("Invalid frame switching action: " + action);
			}
		} catch (NoSuchFrameException e) {
			System.err.println("Frame not found: " + e.getMessage());
			e.printStackTrace();
			// Handle the absence of the frame or return an appropriate error status as
			// needed
		} catch (NumberFormatException e) {
			System.err.println("Invalid frame index value: " + value);
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		} catch (Exception e) {
			System.err.println("An error occurred while switching frames: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void interactWithDropdown(String action, WebElement element, String valueOrText, int index) {

		try {
			Select s = new Select(element);

			if (action.equalsIgnoreCase("value")) {
				s.selectByValue(valueOrText);
			} else if (action.equalsIgnoreCase("index")) {
				s.selectByIndex(index);
			} else if (action.equalsIgnoreCase("text")) {
				s.selectByVisibleText(valueOrText);
			} else if (action.equalsIgnoreCase("ismultiple")) {
				System.out.println(s.isMultiple());
			} else {
				System.err.println("Invalid dropdown interaction action: " + action);
			}
		} catch (NoSuchElementException e) {
			System.err.println("Dropdown option not found: " + e.getMessage());
			e.printStackTrace();
			// Handle the absence of the option or return an appropriate error status as
			// needed
		} catch (Exception e) {
			System.err.println("An error occurred while interacting with the dropdown: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void waitForElement(String waitType, long timeout, WebElement element) {

		try {
			if (waitType.equalsIgnoreCase("static")) {
				// Perform a static wait
				Thread.sleep(timeout);
			} else if (waitType.equalsIgnoreCase("implicit")) {
				// Set an implicit wait
				driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			} else if (waitType.equalsIgnoreCase("explicit")) {
				// Perform an explicit wait
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOf(element));
			} else {
				System.err.println("Invalid wait type: " + waitType);
			}
		} catch (InterruptedException e) {
			System.err.println("Static wait interrupted: " + e.getMessage());
			e.printStackTrace();
			// Handle the interruption or return an appropriate error status as needed
		} catch (NoSuchElementException e) {
			System.err.println("Element not found during explicit wait: " + e.getMessage());
			e.printStackTrace();
			// Handle the absence of the element or return an appropriate error status as
			// needed
		} catch (Exception e) {
			System.err.println("An error occurred while waiting: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		} finally {
			// Reset implicit wait to its default value (optional)
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}
	}

	public static void performAction(String action, WebElement element, int pixelValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			if (action.equalsIgnoreCase("scrollintoview")) {
				// Scroll the element into view
				js.executeScript("arguments[0].scrollIntoView();", element);
			} else if (action.equalsIgnoreCase("click")) {
				// Click on the element
				js.executeScript("arguments[0].click();", element);
			} else if (action.equalsIgnoreCase("scrollby")) {
				// Scroll the page by the specified pixel value
				js.executeScript("window.scrollBy(0, arguments[0]);", pixelValue);
			} else {
				System.err.println("Invalid action: " + action);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while performing the action: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

	public static void takeScreenshot(String location, String method) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(location);

			if (method.equalsIgnoreCase("FileUtils")) {
				// Using FileUtils to copy the screenshot
				FileUtils.copyFile(source, destination);
				System.out.println("Screenshot captured and saved at: " + location);
			} else {
				System.err.println("Invalid screenshot method: " + method);
			}
		} catch (IOException e) {
			System.err.println("An error occurred while capturing the screenshot: " + e.getMessage());
			e.printStackTrace();
			// Handle the exception or return an appropriate error status as needed
		}
	}

//	public static int getSecondsSinceMidnight() {
//
//		try {
//			Calendar now = Calendar.getInstance();
//			int hours = now.get(Calendar.HOUR_OF_DAY);
//			int minutes = now.get(Calendar.MINUTE);
//			int seconds = now.get(Calendar.SECOND);
//
//			// Calculate the total seconds since midnight
//			int totalSeconds = hours * 3600 + minutes * 60 + seconds;
//			return totalSeconds;
//		} catch (Exception e) {
//			System.err.println("An error occurred while calculating seconds since midnight: " + e.getMessage());
//			e.printStackTrace();
//			return -1; // Return a sentinel value or handle the error as needed
//		}
//	}

	public static boolean closeAllOtherWindows(WebDriver driver) {

		String parentWindowHandle = driver.getWindowHandle();
		java.util.Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				try {
					driver.switchTo().window(windowHandle);
					driver.close();
				} catch (Exception e) {
					// Handle any exceptions that occur when trying to close a window
					System.err.println("Error closing window: " + e.getMessage());
				}
			}
		}

		driver.switchTo().window(parentWindowHandle);

		return driver.getWindowHandles().size() == 1;
	}

	// Wait for the element to be clickable ignoring the
	// StaleElementReferenceException

	public boolean waitForElementToBeClickableBool(WebDriver driver, By attributeValue, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(attributeValue));
			flag = true;
			return flag;

		} catch (Exception Ex) {
			return flag;
		}
	}

	// Wait for the Alert present ignoring the Stale ElementReferenceException

	public boolean waitForAlertPresent(WebDriver driver, int waitTime) {
		boolean flag = false;
		new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.alertIsPresent());
		try {
			driver.switchTo().alert();
			return flag = true;
		} catch (Exception Ex) {
			return flag;
		}
	}

	// Wait for the element to be visible ignoring the
	// StaleElementReferenceException

	public boolean waitForElementToBeVisible(WebDriver driver, By attributeValue, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
			flag = true;
			return flag;
		} catch (Exception Ex) {
			return flag;
		}
	}

	// Click on a checkbox or radio button element

	public static void clickOnElement(WebElement element) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			} else {
				System.out.println("Element is not visible or clickable.");
			}
		} catch (Exception e) {
			System.err.println("An error occurred while clicking the element: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Check if an element meets the specified condition

	public static boolean isElementConditionMet(WebElement element, String condition) {

		boolean result = false;

		try {
			if (condition.equalsIgnoreCase("enabled")) {
				result = element.isEnabled();
			} else if (condition.equalsIgnoreCase("selected")) {
				result = element.isSelected();
			} else if (condition.equalsIgnoreCase("displayed")) {
				result = element.isDisplayed();
			} else {
				System.err.println("Invalid condition: " + condition);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while checking the element condition: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public static void handleDropdown(WebElement element) {

		try {
			Select s = new Select(element);

			java.util.List<WebElement> options = s.getOptions();
			java.util.List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			WebElement firstSelectedOption = s.getFirstSelectedOption();

			System.out.println("Options in the dropdown:");
			if (!options.isEmpty()) {
				for (WebElement webElement : options) {
					System.out.println(webElement.getText());
				}
			} else {
				System.out.println("No options found in the dropdown.");
			}

			System.out.println("Selected options:");
			if (!allSelectedOptions.isEmpty()) {
				for (WebElement webElement : allSelectedOptions) {
					System.out.println(webElement.getText());
				}
			} else {
				System.out.println("No selected options found in the dropdown.");
			}

			System.out.println("First selected option: ");
			if (firstSelectedOption != null) {
				System.out.println(firstSelectedOption.getText());
			} else {
				System.out.println("No first selected option found in the dropdown.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Dropdown element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static void simulateKeyEvent(int keyEvent) {

		try {
			Robot r = new Robot();

			switch (keyEvent) {
			case KeyEvent.VK_UP:
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
				System.out.println("Simulated VK_UP");
				break;
			case KeyEvent.VK_DOWN:
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				System.out.println("Simulated VK_DOWN");
				break;
			case KeyEvent.VK_ENTER:
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				System.out.println("Simulated VK_ENTER");
				break;
			default:
				System.out.println("Invalid key event");
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void getcurrenturl() {
		if (driver != null) {
			System.out.println(driver.getCurrentUrl());
		} else {
			System.out.println("WebDriver is not initialized.");
		}
	}

	public static void gettitle() {
		if (driver != null) {
			System.out.println(driver.getTitle());
		} else {
			System.out.println("WebDriver is not initialized.");
		}
	}

	public static void gettext(WebElement element) {
		if (element != null) {
			System.out.println(element.getText());
		} else {
			System.out.println("WebElement is null.");
		}
	}

	public static void getattribute(WebElement element, String input) {
		if (element != null) {
			System.out.println(element.getAttribute(input));
		} else {
			System.out.println("WebElement is null.");
		}
	}

	public static void getUrl(String url) {
		if (driver != null) {
			driver.get(url);
		} else {
			System.out.println("WebDriver is not initialized.");
		}
	}

	public static void sendKeys(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

}

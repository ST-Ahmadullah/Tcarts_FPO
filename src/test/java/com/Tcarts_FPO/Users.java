package com.Tcarts_FPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.baseClass.Base;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Users extends Base {

	public static WebDriver driver = Base.initializeWebDriver("chrome");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Tcarts_FP.class);

	@Test(priority = 0)
	public void setUp() {

		PropertyConfigurator.configure("log4j.properties");

		log.info("URL");

		getUrl("https://tcfoodapp.sumanas.xyz/login");

		String url = driver.getCurrentUrl();
		assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

		waitForElement("implicit", 30, null);

	}

	@Test(dependsOnMethods = { "setUp" })
	private void logIn() throws Throwable {

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendKeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendKeys(pom.getInstanceli().getPassword(), password);

		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceli().getSignin(), 0);

	}

	@Test(priority = 3)
	public void users() {

		log.info("Users");

		performAction("click", pom.getInstancedb().getUsers(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(dependsOnMethods = { "users" }, priority = 1)
	private void student() throws Throwable {

		log.info("Student");

		performAction("click", pom.getInstancedb().getStudent(), 0);
		waitForElement("static", 1000, null);

		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		log.info("Create User");

		performAction("click", pom.getInstanceco().getCreate(), 0);
		sendKeys(pom.getInstancestl().getFirstname(), "Ramesh");
		sendKeys(pom.getInstancestl().getLastname(), "B");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getReset(), 0);
		sendKeys(pom.getInstancestl().getPhonenumber(), "9171548");
		sendKeys(pom.getInstancestl().getAlternatenumber(), "87569");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);

		WebElement firstNameErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[1]"));
		if (firstNameErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + firstNameErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement emailErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[2]"));
		if (emailErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + emailErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement registerNumberErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[3]"));
		if (registerNumberErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + registerNumberErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement primaryPhoneNumberErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[4]"));
		if (primaryPhoneNumberErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + primaryPhoneNumberErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement AlternatePhoneNumberErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[5]"));
//		assertTrue(AlternatePhoneNumberErrorMessage.isDisplayed(),"Error message is not displayed for Alternate no.");
		if (AlternatePhoneNumberErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + AlternatePhoneNumberErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		navigate("refresh", null);

		String f = FileReaderManager.getInstanceFRM().getInstanceCR().getFirstName();
		sendKeys(pom.getInstancestl().getFirstname(), f);
		String l = FileReaderManager.getInstanceFRM().getInstanceCR().getLastName();
		sendKeys(pom.getInstancestl().getLastname(), l);
		String e = FileReaderManager.getInstanceFRM().getInstanceCR().getStudentEmail();
		sendKeys(pom.getInstancestl().getEmail(), e);
		String r = FileReaderManager.getInstanceFRM().getInstanceCR().getRegisterNumber();
		sendKeys(pom.getInstancestl().getRegno(), r);
		clickOnElement(pom.getInstancestl().getMale());
		String d = FileReaderManager.getInstanceFRM().getInstanceCR().getDepartment();
		sendKeys(pom.getInstancestl().getDeptname(), d);
		String p = FileReaderManager.getInstanceFRM().getInstanceCR().getPrimaryNumber();
		sendKeys(pom.getInstancestl().getPhonenumber(), p);
		String a = FileReaderManager.getInstanceFRM().getInstanceCR().getAlternateNumber();
		sendKeys(pom.getInstancestl().getAlternatenumber(), a);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceco().getSave(), 0);

		performAction("click", pom.getInstanceco().getPopup(), 0);

		log.info("Edit User");

		sendKeys(pom.getInstanceco().getSearch(), "Zyan");
		waitForElement("static", 2000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "Zyan  ";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceco().getEdit(), 0);
		clear(pom.getInstancestl().getFirstname());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancestl().getFirstname(), "Zero");
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getSave(), 0);

		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

//		WebElement search1 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
//		String actual1 = search1.getText();
//		System.out.println(actual1);
//		String expected1 = "Zyan  ";
//		assertNotEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("View User");

		sendKeys(pom.getInstanceco().getSearch(), "Zero");
		waitForElement("static", 1000, null);

		WebElement search2 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual2 = search2.getText();
		System.out.println(actual2);
		String expected2 = "Zero  ";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		log.info("Delete User");

		performAction("click", pom.getInstanceco().getDelete(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getDeleteit(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getOk(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

	}

	@Test(dependsOnMethods = { "users" }, priority = 2, enabled = false)
	private void staff() throws Throwable {

		log.info("Staff");

		performAction("click", pom.getInstancedb().getStaff(), 0);
		waitForElement("static", 1000, null);

		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		log.info("Create User");

		performAction("click", pom.getInstanceco().getCreate(), 0);
		sendKeys(pom.getInstancesl().getStaffname(), "Rajan");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getReset(), 0);
		sendKeys(pom.getInstancesl().getMobile(), "9171548");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);

		WebElement NameErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[1]"));
		if (NameErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + NameErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement emailErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[2]"));
		if (emailErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + emailErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement mobileNumberErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[3]"));
		if (mobileNumberErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + mobileNumberErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		navigate("refresh", null);

		String n = FileReaderManager.getInstanceFRM().getInstanceCR().getStaffName();
		sendKeys(pom.getInstancesl().getStaffname(), n);
		String e = FileReaderManager.getInstanceFRM().getInstanceCR().getStaffEmail();
		sendKeys(pom.getInstancesl().getStaffemail(), e);
		String m = FileReaderManager.getInstanceFRM().getInstanceCR().getMobileNumber();
		sendKeys(pom.getInstancesl().getMobile(), m);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceco().getSave(), 0);

		performAction("click", pom.getInstanceco().getPopup(), 0);

		log.info("Edit User");

		sendKeys(pom.getInstanceco().getSearch(), "Ashik");
		waitForElement("static", 2000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "Ashik  ";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceco().getEdit(), 0);
		clear(pom.getInstancesl().getStaffname());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesl().getStaffname(), "Anish Raj");
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getSave(), 0);

		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

		WebElement search1 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual1 = search1.getText();
		System.out.println(actual1);
		String expected1 = "Ashik  ";
		assertNotEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("View User");

		sendKeys(pom.getInstanceco().getSearch(), "Anish Raj");
		waitForElement("static", 1000, null);

		WebElement search2 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual2 = search2.getText();
		System.out.println(actual2);
		String expected2 = "Anish Raj  ";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		log.info("Delete User");

		performAction("click", pom.getInstanceco().getDelete(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getDeleteit(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getOk(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

	}

	@Test(dependsOnMethods = { "users" }, priority = 3, enabled = false)
	private void canteenStaff() throws Throwable {

		log.info("Canteen Staff");

		performAction("click", pom.getInstancedb().getCanteenstaff(), 0);
		waitForElement("static", 1000, null);

		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		log.info("Create User");

		performAction("click", pom.getInstanceco().getCreate(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstancecsl().getCanteenstaffname(), "Aaa");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getReset(), 0);
		waitForElement("static", 1000, null);

		WebElement NameErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[1]"));
		if (NameErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + NameErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement emailErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[2]"));
		if (emailErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + emailErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement canteenErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[3]"));
		if (canteenErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + canteenErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		String n = FileReaderManager.getInstanceFRM().getInstanceCR().getCanteenStaffName();
		sendKeys(pom.getInstancesl().getStaffname(), n);
		String e = FileReaderManager.getInstanceFRM().getInstanceCR().getCanteenStaffEmail();
		sendKeys(pom.getInstancesl().getStaffemail(), e);
		waitForElement("static", 1000, null);
		performAction("click", driver.findElement(By.xpath("//label[@for='01h3vpwsy891y98rmbjxtpx5m7']")), 0);
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

		log.info("Edit User");

		sendKeys(pom.getInstanceco().getSearch(), "Arun");
		waitForElement("static", 1000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "Arun  ";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceco().getEdit(), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancecsl().getCanteenstaffname());
		sendKeys(pom.getInstancecsl().getCanteenstaffname(), "Arul");

		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

		WebElement search1 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual1 = search1.getText();
		System.out.println(actual1);
		String expected1 = "Arun  ";
		assertNotEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("View User");

		sendKeys(pom.getInstanceco().getSearch(), "Arul");
		waitForElement("static", 1000, null);

		WebElement search2 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual2 = search2.getText();
		System.out.println(actual2);
		String expected2 = "Arul  ";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		log.info("Delete User");

		performAction("click", pom.getInstanceco().getDelete(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getDeleteit(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getOk(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getRefresh(), 0);

	}

	@Test(dependsOnMethods = { "users" }, priority = 4, enabled = false)
	private void guest() {

		log.info("Users-Guest");

		performAction("click", pom.getInstancedb().getGuest(), 0);
		waitForElement("static", 1000, null);

		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstanceugl().getSearch(), "Vj");
		waitForElement("static", 1000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "Vj";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceugl().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceugl().getCloseview(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceugl().getRefresh(), 0);

	}

}

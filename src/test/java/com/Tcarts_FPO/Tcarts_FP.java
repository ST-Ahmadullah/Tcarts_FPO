package com.Tcarts_FPO;

import org.testng.annotations.Test;
import com.baseClass.Base;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tcarts_FP extends Base {

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

	@Test(priority = 1)
	public void dashboard() throws Throwable {

		log.info("Dashboard");

		performAction("click", pom.getInstancedb().getFullscreen(), 0);
//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedb().getMenu(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancedb().getSvg(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedb().getMenu(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancedb().getPng(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedb().getMenu(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancedb().getCsv(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedb().getFullscreen(), 0);
//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedb().getIconview(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancedb().getDashboard(), 0);
		waitForElement("static", 1000, null);
	}

	@Test(priority = 2)
	public void sales() {

		log.info("Sales");

		performAction("click", pom.getInstancedb().getSales(), 0);
		waitForElement("static", 1500, null);

	}

	@Test(dependsOnMethods = { "sales" }, priority = 1)
	private void receipts() throws Throwable {

		log.info("Receipt List");

		performAction("click", pom.getInstancedb().getReceipts(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		log.info("Payment Pending");

		performAction("click", driver.findElement(By.xpath("//label[@for='payment_status_P']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getReset(), 0);

		log.info("In Progress");

		performAction("click", driver.findElement(By.xpath("//label[@for='payment_status_W']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getReset(), 0);

		log.info("Failed");

		performAction("click", driver.findElement(By.xpath("//label[@for='payment_status_F']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String f = FileReaderManager.getInstanceFRM().getInstanceCR().getReceiptFailed(); // Search
		sendKeys(pom.getInstanceco().getSearch(), f);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstancerl().getViewitem(), 0); // Item Status
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getItemstatus(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getView(), 0); // View
		waitForElement("static", 1500, null);
		performAction("scrollintoview", driver.findElement(By.xpath("//div[3]/div/table/tbody/tr[21]/td[1]")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//button[@title='Check Billdesk']")), 0); // Check Billdesk
		waitForElement("static", 1500, null);
		performAction("scrollintoview", driver.findElement(By.xpath("//div[1]/div/div/table/tbody/tr[21]/td[1]")), 0);
		waitForElement("static", 1500, null);
		performAction("click", driver.findElement(By.xpath("(//button[@class='btn-close'])[2]")), 0);
		waitForElement("static", 2000, null);

		WebElement v1 = driver.findElement(By.xpath("//div[@class='badge badge-danger']")); // Validation
		String actual1 = v1.getText();
		System.out.println(actual1);
		String expected1 = "Failed";
		assertEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstancerl().getNext(), 0); // Page - Next & Previous
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getReset(), 0); // Reset
		waitForElement("static", 1000, null);

		log.info("Cancelled");

		performAction("click", driver.findElement(By.xpath("//label[@for='payment_status_C']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String c = FileReaderManager.getInstanceFRM().getInstanceCR().getReceiptCancelled();
		sendKeys(pom.getInstanceco().getSearch(), c);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstancerl().getViewitem(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getItemstatus(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//button[@title='Check Billdesk']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", driver.findElement(By.xpath("(//button[@class='btn-close'])[2]")), 0);
		waitForElement("static", 1500, null);

		WebElement v2 = driver.findElement(By.xpath("//div[@class='badge badge-dark']")); // Validation
		String actual2 = v2.getText();
		System.out.println(actual2);
		String expected2 = "Cancelled";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getRefresh(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Paid");

		performAction("click", driver.findElement(By.xpath("//label[@for='payment_status_S']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String p = FileReaderManager.getInstanceFRM().getInstanceCR().getReceiptPaid();
		sendKeys(pom.getInstanceco().getSearch(), p);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstancerl().getViewitem(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getItemstatus(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1500, null);
		performAction("scrollintoview", driver.findElement(By.xpath("//div[3]/div/table/tbody/tr[20]/td[1]")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//button[@title='Check Billdesk']")), 0);
		waitForElement("static", 1500, null);
		performAction("scrollintoview", driver.findElement(By.xpath("//div[1]/div/div/table/tbody/tr[21]/td[1]")), 0);
		waitForElement("static", 1500, null);
		performAction("click", driver.findElement(By.xpath("(//button[@class='btn-close'])[2]")), 0);
		waitForElement("static", 2000, null);

		WebElement v3 = driver.findElement(By.xpath("//div[@class='badge badge-success']")); // Validation
		String actual3 = v3.getText();
		System.out.println(actual3);
		String expected3 = "Paid";
		assertEquals(expected3, actual3);

		performAction("click", pom.getInstanceco().getRefresh(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("All");

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllStatuses']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancerl().getSearchButton(), 0);
		waitForElement("static", 1000, null);

//		driver.findElement(By.xpath("//select[@name='datatable-buttons_length']")).click(); // Show List Slection
//		waitForElement("static", 1000, null);
//		driver.findElement(By.xpath("//label/select/option[3]")).click();
//		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstancerl().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -3000);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancerl().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancerl().getAdvanceSearch(), 0);
		waitForElement("static", 1500, null);
//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1500, null);

	}

	@Test(dependsOnMethods = { "sales" }, priority = 2)
	private void orders() throws Throwable {

		log.info("Order List");

		performAction("click", pom.getInstancedb().getOrders(), 0);
		waitForElement("static", 2000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		log.info("Not Delivered");

		performAction("click", driver.findElement(By.xpath("//label[@for='status_N']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceol().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String nD = FileReaderManager.getInstanceFRM().getInstanceCR().getOrderNotDelivered(); // Search Order
		sendKeys(pom.getInstanceco().getSearch(), nD);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceol().getVieworder(), 0); // View Order
		waitForElement("static", 1000, null);
		navigate("back", null);
		waitForElement("static", 3000, null);

		WebElement v1 = driver.findElement(By.xpath("//div[@class='badge badge-danger']")); // Validation
		String actual1 = v1.getText();
		System.out.println(actual1);
		String expected1 = "Not Delivered";
		assertEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Partially Delivered");

		performAction("click", driver.findElement(By.xpath("//label[@for='status_P']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getSearchButton(), 0);
		waitForElement("static", 1500, null);

		String pD = FileReaderManager.getInstanceFRM().getInstanceCR().getOrderPartiallyDelivered(); // Search Order
		sendKeys(pom.getInstanceco().getSearch(), pD);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceol().getVieworder(), 0); // View Order
		waitForElement("static", 1000, null);
		navigate("back", null);
		waitForElement("static", 3000, null);

		WebElement v2 = driver.findElement(By.xpath("//div[@class='badge badge-warning']")); // Validation
		String actual2 = v2.getText();
		System.out.println(actual2);
		String expected2 = "Partially Delivered";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceol().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Delivered");

		performAction("click", driver.findElement(By.xpath("//label[@for='status_D']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceol().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String d = FileReaderManager.getInstanceFRM().getInstanceCR().getOrderDelivered(); // Search Order
		sendKeys(pom.getInstanceco().getSearch(), d);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceol().getVieworder(), 0); // View Order
		waitForElement("static", 1000, null);
		navigate("back", null);
		waitForElement("static", 3000, null);

		WebElement v3 = driver.findElement(By.xpath("//div[@class='badge badge-success']")); // Validation
		String actual3 = v3.getText();
		System.out.println(actual3);
		String expected3 = "Delivered";
		assertEquals(expected3, actual3);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Cancelled");

		performAction("click", driver.findElement(By.xpath("//label[@for='status_C']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceol().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		String c = FileReaderManager.getInstanceFRM().getInstanceCR().getOrderCancelled(); // Search Order
		sendKeys(pom.getInstanceco().getSearch(), c);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceol().getVieworder(), 0); // View Order
		waitForElement("static", 1000, null);
		navigate("back", null);
		waitForElement("static", 3000, null);

		WebElement v4 = driver.findElement(By.xpath("//div[@class='badge badge-dark']")); // Validation
		String actual4 = v4.getText();
		System.out.println(actual4);
		String expected4 = "Cancelled";
		assertEquals(expected4, actual4);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("All");

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllStatuses']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceol().getSearchButton(), 0);
		waitForElement("static", 1000, null);

//		driver.findElement(By.xpath("//select[@name='datatable-buttons_length']")).click(); // Show List Slection
//		waitForElement("static", 1000, null);
//		driver.findElement(By.xpath("//label/select/option[3]")).click();
//		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 2500, null);
		performAction("click", pom.getInstanceol().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getPrevious(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollby", null, -3000);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceol().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceol().getAdvanceSearch(), 0);
		waitForElement("static", 1500, null);
//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(dependsOnMethods = { "sales" }, priority = 3)
	private void refunds() throws Throwable {

		log.info("Order Refund List");

		performAction("click", pom.getInstancedb().getRefunds(), 0);
		waitForElement("static", 2000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		log.info("Pending");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_P']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Refund Initiated");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_W']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);

		String rI = FileReaderManager.getInstanceFRM().getInstanceCR().getRefundInitiated(); // Search
		sendKeys(pom.getInstanceco().getSearch(), rI);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstanceorl().getViewitem(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getView(), 0); // View
		waitForElement("static", 1500, null);
		performAction("scrollintoview", driver.findElement(By.xpath("//div[8]/div/table/tbody/tr[12]/td[1]")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		WebElement v = driver.findElement(By.xpath("//div[@class='badge badge-warning']")); // Validation
		String actual = v.getText();
		System.out.println(actual);
		String expected = "Refund Initiated";
		assertEquals(expected, actual);

		performAction("click", pom.getInstanceco().getRefresh(), 0); // Refresh
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Partial Refund Initiated");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_PI']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Refunded");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_C']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Partially Refunded");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_PR']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("Declined");

		performAction("click", driver.findElement(By.xpath("//label[@for='refund_status_D']")), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		log.info("All");

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllStatuses']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceorl().getSearchButton(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstanceorl().getNext(), 0);
		waitForElement("static", 1500, null);
		performAction("scrollby", null, -300);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstanceorl().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceorl().getAdvanceSearch(), 0);
		waitForElement("static", 1500, null);
//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(priority = 5)
	public void gST() {

		log.info("GST");

		performAction("click", pom.getInstancedb().getReports(), 0);
		waitForElement("static", 1500, null);

	}

	@Test(dependsOnMethods = { "gST" })
	private void salesReport() {

		log.info("Sales Report");

		performAction("click", pom.getInstancedb().getSalesreport(), 0);
		waitForElement("static", 2000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		performAction("click", pom.getInstancersr().getDaterange(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getToday(), 0); // Today & Breakfast
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0ngsn3sswr75tkwfqp4v']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Idli");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Idli')])[1]")), 0);
		waitForElement("static", 1500, null);
		clear(pom.getInstancersr().getSearchselectabledishes());
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Milk");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Milk')])[1]")), 0);
		waitForElement("static", 1500, null);
		sendKeys(pom.getInstancersr().getSearchselectiondishes(), "Milk");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Milk')])[2]")), 0);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // Yesterday & // MorningBreak
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getYesterday(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nhwhd8dv358kdjxs902']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Tea");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Tea')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancersr().getSearchselectabledishes());
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Puffs");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Puffs')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectiondishes(), "Puffs");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Puffs')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // Last 7 days & Lunch
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getLast7days(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nja5a0ns82kr3eyvtb7']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Vegetable Biryani");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Vegetable Biryani')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancersr().getSearchselectabledishes());
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Lemon Rice");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Lemon Rice')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectiondishes(), "Lemon Rice");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Lemon Rice')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // Last 30 days & EveningBreak
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getLast30days(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nk3cbyx1wtzk8k0mx6k']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Samosa");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Samosa')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancersr().getSearchselectabledishes());
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Ice Cream");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Ice Cream')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectiondishes(), "Ice Cream");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Ice Cream')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // This Month & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getThismonth(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getSelectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getDeselectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getSelectall(), 0);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // Last Month & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getLastmonth(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getSelectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getDeselectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getSelectall(), 0);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getDaterange(), 0); // Custom & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancersr().getCustom(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//th[@class='prev available']//span")), 0);

		driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//tr[1]//td[3]")).click();
		waitForElement("static", 1000, null);
		driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//tr[5]//td[7]")).click();

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancersr().getSearchselectabledishes(), "Chapati");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Chapati')])[1]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancersr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstanceco().getSearch(), "Chapati");
		waitForElement("static", 3000, null);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"id\"]/td[2]"));
		String actualText = element.getText();
		System.out.println(actualText);
		String expectedText = "Chapati";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(dependsOnMethods = { "gST" })
	private void gstReport() {

		log.info("GST Report");

		performAction("click", pom.getInstancedb().getGstreport(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		performAction("click", pom.getInstancegr().getDaterange(), 0);
		waitForElement("static", 1000, null);

		driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//tr[1]//td[3]")).click();
		waitForElement("static", 1000, null);
		driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//tr[5]//td[3]")).click();
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancegr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancegr().getReset(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);

	}

	@Test(dependsOnMethods = { "gST" })
	private void stockReport() {

		log.info("Stock Report");

		performAction("click", pom.getInstancedb().getStockreport(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		performAction("click", pom.getInstancesr().getDaterange(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getToday(), 0); // Today & Breakfast
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0ngsn3sswr75tkwfqp4v']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Idli");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Idli')])[1]")), 0);
		waitForElement("static", 1500, null);
		clear(pom.getInstancesr().getSearchselectabledishes());
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Milk");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Milk')])[1]")), 0);
		waitForElement("static", 1500, null);
		sendKeys(pom.getInstancesr().getSearchselectiondishes(), "Milk");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Milk')])[2]")), 0);
		waitForElement("static", 1500, null);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstanceco().getSearch(), "Idli");
		waitForElement("static", 3000, null);

		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // Yesterday & // MorningBreak
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getYesterday(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nhwhd8dv358kdjxs902']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Tea");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Tea')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancesr().getSearchselectabledishes());
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Puffs");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Puffs')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectiondishes(), "Puffs");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Puffs')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstanceco().getSearch(), "Tea");
		waitForElement("static", 3000, null);

		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // Last 7 days & Lunch
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getLast7days(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nja5a0ns82kr3eyvtb7']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Vegetable Biryani");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Vegetable Biryani')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancesr().getSearchselectabledishes());
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Lemon Rice");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Lemon Rice')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectiondishes(), "Lemon Rice");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Lemon Rice')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstanceco().getSearch(), "Vegetable Biryani");
		waitForElement("static", 3000, null);

		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // Last 30 days & EveningBreak
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getLast30days(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='timeFrame_01h3vq0nk3cbyx1wtzk8k0mx6k']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Samosa");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Samosa')])[1]")), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancesr().getSearchselectabledishes());
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Ice Cream");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Ice Cream')])[1]")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectiondishes(), "Ice Cream");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Ice Cream')])[2]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstanceco().getSearch(), "Samosa");
		waitForElement("static", 3000, null);

		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // This Month & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getThismonth(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getSelectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getDeselectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getSelectall(), 0);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstanceco().getSearch(), "Milk");
		waitForElement("static", 3000, null);

		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // Last Month & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getLastmonth(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getSelectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getDeselectall(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getSelectall(), 0);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstanceco().getSearch(), "Juice");
		waitForElement("static", 3000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 3000, null);
		performAction("click", pom.getInstancesr().getReset(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getDaterange(), 0); // Custom & AllTimeframes
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancesr().getCustom(), 0);
		waitForElement("static", 1000, null);

		performAction("click", driver.findElement(By.xpath("//th[@class='prev available']//span")), 0);

		driver.findElement(By.xpath("//div[@class='drp-calendar left']//tbody//tr[1]//td[3]")).click();
		waitForElement("static", 1000, null);
		driver.findElement(By.xpath("//div[@class='drp-calendar right']//tbody//tr[5]//td[7]")).click();

		performAction("click", driver.findElement(By.xpath("//label[@for='selectAllTimeFrames']")), 0);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancesr().getSearchselectabledishes(), "Chapati");
		performAction("click", driver.findElement(By.xpath("(//span[contains(text(),'Chapati')])[1]")), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancesr().getSearchbutton(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstanceco().getSearch(), "Chapati");
		waitForElement("static", 3000, null);

		clear(pom.getInstanceco().getSearch());
		waitForElement("static", 2000, null);
		performAction("click", pom.getInstancersr().getReset(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
//		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(priority = 6)
	public void appFeedback() {

		log.info("App Feedback");

		performAction("click", pom.getInstancedb().getAppfeedback(), 0);
		waitForElement("static", 2000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);

		sendKeys(pom.getInstancefb().getSearch(), "Tester"); // 1
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancefb().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancefb().getRefresh(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstancefb().getSearch(), "Developer"); // 2
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancefb().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancefb().getRefresh(), 0);
		waitForElement("static", 1000, null);

//		performMouseAction("click", pom.getInstancedb().getFullscreen());
		performAction("click", pom.getInstancedb().getFullscreen(), 0);
		waitForElement("static", 1000, null);

	}

	@Test(priority = 7)
	public void tearDown() throws Throwable {

		log.info("Logout");

		performAction("click", pom.getInstancelo().getAdmin(), 0);
		waitForElement("static", 2000, null);
		performAction("click", pom.getInstancelo().getLogout(), 0);
		waitForElement("static", 1500, null);
		quit();
	}

}

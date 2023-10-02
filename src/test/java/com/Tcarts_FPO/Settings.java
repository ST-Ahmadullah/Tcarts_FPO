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

public class Settings extends Base {

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

	@Test
	public void settings() {

		log.info("Settings");

	}

	@Test(dependsOnMethods = { "settings" }, priority = 1, enabled = false)
	private void canteen() {

		log.info("Canteen");

		performAction("click", pom.getInstancedb().getCanteens(), 0);
		waitForElement("static", 1000, null);

		log.info("Create Canteen");

		performAction("click", pom.getInstanceco().getCreate(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);

		WebElement canteenNameErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[1]"));
		if (canteenNameErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + canteenNameErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement canteenCodeErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[2]"));
		if (canteenCodeErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + canteenCodeErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		sendKeys(pom.getInstancecl().getCanteenname(), "Canteen");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getReset(), 0);
		waitForElement("static", 1000, null);

		sendKeys(pom.getInstancecl().getCanteenname(), "ST Canteen");
		sendKeys(pom.getInstancecl().getCanteencode(), "007");
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);

		log.info("Edit Canteen");

		sendKeys(pom.getInstanceco().getSearch(), "ST Canteen");
		waitForElement("static", 1000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "ST Canteen";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceco().getEdit(), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancecl().getCanteenname());
		clear(pom.getInstancecl().getCanteencode());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancecl().getCanteenname(), "As Canteen");
		sendKeys(pom.getInstancecl().getCanteencode(), "07");
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

		WebElement search1 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual1 = search1.getText();
		System.out.println(actual1);
		String expected1 = "ST Canteen";
		assertNotEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("View & Delete Canteen");

		sendKeys(pom.getInstanceco().getSearch(), "As Canteen");
		waitForElement("static", 1000, null);

		WebElement search2 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual2 = search2.getText();
		System.out.println(actual2);
		String expected2 = "As Canteen";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getDelete(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getDeleteit(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getOk(), 0);
		waitForElement("static", 1000, null);

		WebElement search3 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual3 = search3.getText();
		System.out.println(actual3);
		String expected3 = "ST Canteen";
		assertNotEquals(expected3, actual3);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("Overschedule");

		sendKeys(pom.getInstanceco().getSearch(), "Canteen1");
		waitForElement("static", 1000, null);

		WebElement search4 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual4 = search4.getText();
		System.out.println(actual4);
		String expected4 = "Canteen1";
		assertEquals(expected4, actual4);

		performAction("click", pom.getInstancecl().getOverschedule(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancecl().getMorningbreak(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getLunch(), 0);
		waitForElement("static", 1000, null);
		;
		performAction("click", pom.getInstancecl().getEveningbreak(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getBreakfast(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancecl().getNewdish(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getViewclose(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getNewdish(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getSearch(), 0);
		sendKeys(pom.getInstancecl().getSearch(), "Chapati");
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancecl().getAdd(), 0);
		waitForElement("static", 1500, null);
		performAction("click", pom.getInstancecl().getClose(), 0);
		waitForElement("static", 1000, null);

//		performAction("click", pom.getInstancecl().getNewdish(), 0);
//		waitForElement("static", 1500, null);
//		performAction("click", pom.getInstancecl().getSearch(), 0);
//		sendKeys(pom.getInstancecl().getSearch(), "chapati");
//		waitForElement("static", 1500, null);

//		performMouseAction("click", pom.getInstancecl().getSelectdish());
//		performAction("click", pom.getInstancecl().getSelectdish(), 0);
//		simulateKeyEvent(KeyEvent.VK_ENTER); 
//		performAction("click", pom.getInstancecl().getAdd(), 0);
//		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancecl().getStockqty(), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancecl().getSearchbox());
		performAction("click", pom.getInstancecl().getCancel(), 0);

		performAction("click", pom.getInstancecl().getStockqty(), 0);
		clear(pom.getInstancecl().getSearchbox());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancecl().getSearchbox(), "100");

		performAction("click", pom.getInstancecl().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getDelete(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancecl().getRemoveit(), 0);
		waitForElement("static", 1000, null);
		navigate("back", null);

		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getRefresh(), 0);

	}

	@Test(dependsOnMethods = { "settings" }, priority = 2, enabled = false)
	private void dishes() {

		log.info("Dishes");

		performAction("click", pom.getInstancedb().getDishes(), 0);
		waitForElement("static", 1000, null);

		log.info("Create Dish");

		performAction("click", pom.getInstanceco().getCreate(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 3000, null);

		WebElement dishNameErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[1]"));
		if (dishNameErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + dishNameErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement dishPriceErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[2]"));
		if (dishPriceErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + dishPriceErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		WebElement timeframesErrorMessage = driver.findElement(By.xpath("(//ul[@class='text-sm mt-2'])[3]"));
		if (timeframesErrorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + timeframesErrorMessage.getText());
		} else {
			System.out.println("Error message is not displayed.");
		}

		sendKeys(pom.getInstancedl().getDishname(), "Brinji");
		sendKeys(pom.getInstancedl().getDishprice(), "100.00");

		performAction("click", pom.getInstancedl().getVeg(), 0);
		performAction("click", pom.getInstancedl().getLunch(), 0);
		performAction("click", pom.getInstancedl().getBreakfast(), 0);
		performAction("click", pom.getInstancedl().getEveningbreak(), 0);
		performAction("click", pom.getInstancedl().getMorningbreak(), 0);
		performAction("click", pom.getInstancedl().getGstexclude(), 0);
		performAction("click", pom.getInstanceco().getReset(), 0);

		sendKeys(pom.getInstancedl().getDishname(), "Biryanii");
		sendKeys(pom.getInstancedl().getDishprice(), "180.00");
		clear(driver.findElement(By.id("number_of_items")));
		sendKeys(driver.findElement(By.id("number_of_items")), "100");
		performAction("click", pom.getInstancedl().getNonveg(), 0);
		sendKeys(pom.getInstancedl().getImage(), "/home/st/Downloads/image.jpeg");
		performAction("click", pom.getInstancedl().getGstinclude(), 0);
		performAction("click", pom.getInstancedl().getLunch(), 0);

		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);
		waitForElement("static", 1000, null);

		performAction("scrollintoview", pom.getInstancedl().getNextpage(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancedl().getNextpage(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstancedl().getPreviouspage(), 0);
		waitForElement("static", 1000, null);

		log.info("Edit Dish");

		performAction("scrollby", null, -1000);
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstanceco().getSearch(), "Biryanii");
		waitForElement("static", 1000, null);

		WebElement search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actualText = search.getText();
		System.out.println(actualText);
		String expectedText = "Biryanii";
		assertEquals(expectedText, actualText);

		performAction("click", pom.getInstanceco().getEdit(), 0);
		waitForElement("static", 1000, null);
		clear(pom.getInstancedl().getDishname());
		clear(pom.getInstancedl().getDishprice());
		waitForElement("static", 1000, null);
		sendKeys(pom.getInstancedl().getDishname(), "Biryani spl ");
		sendKeys(pom.getInstancedl().getDishprice(), "150.00");
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getPopup(), 0);

		WebElement search1 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual1 = search1.getText();
		System.out.println(actual1);
		String expected1 = "Biryanii";
		assertNotEquals(expected1, actual1);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

		log.info("View Dish");

		sendKeys(pom.getInstanceco().getSearch(), "Biryani spl");
		waitForElement("static", 1000, null);

		WebElement search2 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']"));
		String actual2 = search2.getText();
		System.out.println(actual2);
		String expected2 = "Biryani spl";
		assertEquals(expected2, actual2);

		performAction("click", pom.getInstanceco().getView(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getCloseview(), 0);
		waitForElement("static", 1000, null);

		log.info("Delete Dish");

		performAction("click", pom.getInstanceco().getDelete(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getDeleteit(), 0);
		waitForElement("static", 1000, null);
		performAction("click", pom.getInstanceco().getOk(), 0);
		waitForElement("static", 3000, null);

		WebElement search3 = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String actual3 = search3.getText();
		System.out.println(actual3);
		String expected3 = "Biryani spl";
		assertNotEquals(expected3, actual3);

		performAction("click", pom.getInstanceco().getRefresh(), 0);

	}

	@Test(dependsOnMethods = { "settings" })
	private void holidays() {

		performAction("click", pom.getInstancedb().getHolidays(), 0);

		performAction("click", pom.getInstanceco().getCreate(), 0);
		waitForElement("static", 1000, null);

		performAction("click", pom.getInstancehl().getFestivalname(), 0);

		sendKeys(pom.getInstancehl().getFestivalname(), "Ayudhapoojai");

		performAction("click", pom.getInstancehl().getFestivaldate(), 0);

		WebElement dateInput = driver.findElement(By.id("date"));
		dateInput.clear();
		dateInput.sendKeys("23-10-2023");

		performAction("click", pom.getInstanceco().getSave(), 0);
		waitForElement("static", 3000, null);

	}

}

package com.Tcarts_FPO;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import com.baseClass.Base;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tcarts_FPO_Demo extends Base {

	public static WebDriver driver = Base.initializeWebDriver("chrome");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Tcarts_FPO_Demo.class);

	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {

		report = new ExtentReports("//home//st//eclipse-workspace//Tcarts_FPO//Report//ExtentReport//Report.html");
		test = report.startTest("ExtentReport");
	}

	@Test(priority = -1)
	public void setUp() throws Throwable {

		PropertyConfigurator.configure("log4j.properties");

		log.info("URL");

		getUrl("https://tcfoodapp.sumanas.xyz/login");

		if (driver.getTitle().equals("TCARTS Food PreOrdering")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}

		waitForElement("implicit", 30, null);
	}

	@Test(priority = 0)
	public void login() throws Throwable {

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendKeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendKeys(pom.getInstanceli().getPassword(), password);

		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceli().getSignin(), 0);

	}

	@Test(priority = 1)
	public void tearDown() throws Throwable {

		log.info("Logout");

		performAction("click", pom.getInstancelo().getAdmin(), 0);
		waitForElement("static", 2000, null);
		performAction("click", pom.getInstancelo().getLogout(), 0);
		waitForElement("static", 1500, null);
		quit();
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}

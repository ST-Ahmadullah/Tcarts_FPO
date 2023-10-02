package com.Tcarts_FPO;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import com.baseClass.Base;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Login extends Base {
	
	public static WebDriver driver = Base.initializeWebDriver("chrome");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Login.class);

	@BeforeMethod
	public void setUp() {

		PropertyConfigurator.configure("log4j.properties");

		log.info("URL");

		getUrl("https://tcfoodapp.sumanas.xyz/login");

		String url = driver.getCurrentUrl();
		assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

		waitForElement("implicit", 30, null);

	}

	@Test()
	public void logIn() throws Throwable {

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendKeys(pom.getInstanceli().getUsername(), email);
		
		waitForElement("static", 1000, null);
		
		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendKeys(pom.getInstanceli().getPassword(), password);

		waitForElement("static", 1000, null);

		performAction("click", pom.getInstanceli().getSignin(), 0);
		waitForElement("static", 3000, null);

	}
	
	@AfterMethod
	public void tearDown() throws Throwable {

		log.info("Logout");

		performAction("click", pom.getInstancelo().getAdmin(), 0);
		waitForElement("static", 2000, null);
		performAction("click", pom.getInstancelo().getLogout(), 0);
		waitForElement("static", 2000, null);
		quit();
	}

}

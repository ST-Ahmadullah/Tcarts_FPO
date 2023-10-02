package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_CanteenStaffList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement canteenstaffname;

	@FindBy(id = "email")
	private WebElement canteenstaffmail;

	@FindBy(xpath = "//label[@for='status']")
	private WebElement statuscheckbox;

	public Users_CanteenStaffList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCanteenstaffname() {
		return canteenstaffname;
	}

	public WebElement getCanteenstaffmail() {
		return canteenstaffmail;
	}

	public WebElement getStatuscheckbox() {
		return statuscheckbox;
	}

}

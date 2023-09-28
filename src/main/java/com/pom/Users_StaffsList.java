package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_StaffsList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement staffname;

	@FindBy(id = "email")
	private WebElement staffemail;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(xpath = "//label[@for='status']")
	private WebElement statuscheckbox;

	public Users_StaffsList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffname() {
		return staffname;
	}

	public WebElement getStaffemail() {
		return staffemail;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getStatuscheckbox() {
		return statuscheckbox;
	}

}

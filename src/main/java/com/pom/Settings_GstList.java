package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_GstList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement gstname;

	@FindBy(id = "percentage")
	private WebElement gstpercent;

	public Settings_GstList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getGstname() {
		return gstname;
	}

	public WebElement getGstpercent() {
		return gstpercent;
	}

}

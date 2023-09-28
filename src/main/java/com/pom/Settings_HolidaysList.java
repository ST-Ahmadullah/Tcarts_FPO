package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_HolidaysList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement festivalname;

	@FindBy(id = "date")
	private WebElement festivaldate;

	public Settings_HolidaysList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getFestivalname() {
		return festivalname;
	}

	public WebElement getFestivaldate() {
		return festivaldate;
	}

}

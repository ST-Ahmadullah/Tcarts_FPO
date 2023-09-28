package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_TimeframesList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement tfname;

	@FindBy(id = "start_time")
	private WebElement sttime;

	@FindBy(id = "end_time")
	private WebElement edtime;

	public Settings_TimeframesList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getTfname() {
		return tfname;
	}

	public WebElement getSttime() {
		return sttime;
	}

	public WebElement getEdtime() {
		return edtime;
	}

}

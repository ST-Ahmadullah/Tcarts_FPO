package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_GstReport {

	public WebDriver driver;

	@FindBy(id = "dateRange")
	private WebElement daterange;

	@FindBy(id = "searchButton")
	private WebElement searchbutton;

	@FindBy(xpath = "//button[@id='reset']")
	private WebElement reset;

	public Reports_GstReport(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDaterange() {
		return daterange;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getReset() {
		return reset;
	}

}

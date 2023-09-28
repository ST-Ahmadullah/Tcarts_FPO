package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppFeedbackList {

	public WebDriver driver;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(xpath = "//button[@title='View']")
	private WebElement view;

	@FindBy(xpath = "//button[@title='Reset']")
	private WebElement refresh;

	public AppFeedbackList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getRefresh() {
		return refresh;
	}

}

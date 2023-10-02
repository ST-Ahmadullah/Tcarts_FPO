package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales_OrderList {

	public WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='View Order']")
	private WebElement vieworder;

	@FindBy(xpath = "//a[normalize-space()='Order']")
	private WebElement order;

	@FindBy(id = "searchButton")
	private WebElement searchButton;

	@FindBy(id = "reset")
	private WebElement reset;

	@FindBy(xpath = "//a[normalize-space()='Next']")
	private WebElement next;

	@FindBy(xpath = "//li[@id='datatable-buttons_previous']")
	private WebElement previous;

	@FindBy(xpath = "//button[contains(@class, 'btn-success')]")
	private WebElement advanceSearch;

	public Sales_OrderList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getVieworder() {
		return vieworder;
	}

	public WebElement getOrder() {
		return order;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getNext() {
		return next;
	}

	public WebElement getPrevious() {
		return previous;
	}

	public WebElement getAdvanceSearch() {
		return advanceSearch;
	}
	

}

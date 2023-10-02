package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales_OrderReceiptList {
	
	public WebDriver driver;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign fs-16 details-control']")
	private WebElement viewitem;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign fs-16 order-item-control']")
	private WebElement itemstatus;
	
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
	
	
	public Sales_OrderReceiptList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getViewitem() {
		return viewitem;
	}

	public WebElement getItemstatus() {
		return itemstatus;
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

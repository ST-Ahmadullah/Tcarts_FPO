package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_SalesReport {

	public WebDriver driver;

	@FindBy(id = "dateRangePicker")
	private WebElement daterange;

	@FindBy(xpath = "//li[normalize-space()='Today']")
	private WebElement today;

	@FindBy(xpath = "//li[normalize-space()='Yesterday']")
	private WebElement yesterday;

	@FindBy(xpath = "//li[normalize-space()='Last 7 Days']")
	private WebElement last7days;

	@FindBy(xpath = "//li[normalize-space()='Last 30 Days']")
	private WebElement last30days;

	@FindBy(xpath = "//li[normalize-space()='This Month']")
	private WebElement thismonth;

	@FindBy(xpath = "//li[normalize-space()='Last Month']")
	private WebElement lastmonth;

	@FindBy(xpath = "//li[normalize-space()='Custom Range']")
	private WebElement custom;

	@FindBy(xpath = "//div[@class='ms-selectable']//input[@type='text']")
	private WebElement searchselectabledishes;

	@FindBy(xpath = "//div[@class='ms-selection']//input[@type='text']")
	private WebElement searchselectiondishes;

	@FindBy(id = "select-all")
	private WebElement selectall;

	@FindBy(id = "deselect-all")
	private WebElement deselectall;

	@FindBy(id = "searchButton")
	private WebElement searchbutton;

	@FindBy(xpath = "//button[@id='reset']")
	private WebElement reset;

	public Reports_SalesReport(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDaterange() {
		return daterange;
	}

	public WebElement getToday() {
		return today;
	}

	public WebElement getYesterday() {
		return yesterday;
	}

	public WebElement getLast7days() {
		return last7days;
	}

	public WebElement getLast30days() {
		return last30days;
	}

	public WebElement getThismonth() {
		return thismonth;
	}

	public WebElement getLastmonth() {
		return lastmonth;
	}

	public WebElement getCustom() {
		return custom;
	}

	public WebElement getSearchselectabledishes() {
		return searchselectabledishes;
	}

	public WebElement getSearchselectiondishes() {
		return searchselectiondishes;
	}

	public WebElement getSelectall() {
		return selectall;
	}

	public WebElement getDeselectall() {
		return deselectall;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getReset() {
		return reset;
	}

}

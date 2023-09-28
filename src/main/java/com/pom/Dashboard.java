package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	public WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	private WebElement dashboard;

	@FindBy(xpath = "//a[@class='waves-effect waves-light nav-link d-none d-md-inline-block mx-10 push-btn bg-transparent hover-primary']")
	private WebElement iconview;

	@FindBy(xpath = "//a[@title='Full Screen']")
	private WebElement fullscreen;

	@FindBy(xpath = "//div[@title='Menu']")
	private WebElement menu;

	@FindBy(xpath = "//a[normalize-space()='Sumanas Technologies']")
	private WebElement sumanas;

	@FindBy(xpath = "//span[normalize-space()='Sales']")
	private WebElement sales;

	@FindBy(xpath = "//span[normalize-space()='Receipts']")
	private WebElement receipts;

	@FindBy(xpath = "//span[normalize-space()='Orders']")
	private WebElement orders;

	@FindBy(xpath = "//span[normalize-space()='Refunds']")
	private WebElement refunds;

	@FindBy(xpath = "//span[normalize-space()='Users']")
	private WebElement users;

	@FindBy(xpath = "//span[normalize-space()='Student']")
	private WebElement student;

	@FindBy(xpath = "//span[normalize-space()='Staff']")
	private WebElement staff;

	@FindBy(xpath = "//span[normalize-space()='Canteen Staff']")
	private WebElement canteenstaff;

	@FindBy(xpath = "//span[normalize-space()='Settings']")
	private WebElement settings;

	@FindBy(xpath = "//span[normalize-space()='Canteens']")
	private WebElement canteens;

	@FindBy(xpath = "//span[normalize-space()='Dishes']")
	private WebElement dishes;

	@FindBy(xpath = "//span[normalize-space()='Timeframes']")
	private WebElement timeframes;

	@FindBy(xpath = "//span[normalize-space()='Schedules']")
	private WebElement schedules;

	@FindBy(xpath = "//span[normalize-space()='GST']")
	private WebElement gst;

	@FindBy(xpath = "//span[normalize-space()='Holidays']")
	private WebElement holidays;

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	private WebElement reports;

	@FindBy(xpath = "//span[normalize-space()='GST Report']")
	private WebElement gstreport;

	@FindBy(xpath = "//span[normalize-space()='Stock Report']")
	private WebElement stockreport;

	@FindBy(xpath = "//span[normalize-space()='App Feedback']")
	private WebElement appfeedback;

	@FindBy(xpath = "//span[normalize-space()='Guest']")
	private WebElement guest;

	@FindBy(xpath = "//span[normalize-space()='Sales Report']")
	private WebElement salesreport;

	@FindBy(xpath = "//div[@title='Download SVG']")
	private WebElement svg;

	@FindBy(xpath = "//div[@title='Download PNG']")
	private WebElement png;

	@FindBy(xpath = "//div[@title='Download CSV']")
	private WebElement csv;

	public Dashboard(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getIconview() {
		return iconview;
	}

	public WebElement getFullscreen() {
		return fullscreen;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getSumanas() {
		return sumanas;
	}

	public WebElement getSales() {
		return sales;
	}

	public WebElement getReceipts() {
		return receipts;
	}

	public WebElement getOrders() {
		return orders;
	}

	public WebElement getRefunds() {
		return refunds;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getStudent() {
		return student;
	}

	public WebElement getStaff() {
		return staff;
	}

	public WebElement getCanteenstaff() {
		return canteenstaff;
	}

	public WebElement getSettings() {
		return settings;
	}

	public WebElement getCanteens() {
		return canteens;
	}

	public WebElement getDishes() {
		return dishes;
	}

	public WebElement getTimeframes() {
		return timeframes;
	}

	public WebElement getSchedules() {
		return schedules;
	}

	public WebElement getGst() {
		return gst;
	}

	public WebElement getHolidays() {
		return holidays;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getGstreport() {
		return gstreport;
	}

	public WebElement getStockreport() {
		return stockreport;
	}

	public WebElement getAppfeedback() {
		return appfeedback;
	}

	public WebElement getGuest() {
		return guest;
	}

	public WebElement getSalesreport() {
		return salesreport;
	}

	public WebElement getSvg() {
		return svg;
	}

	public WebElement getPng() {
		return png;
	}

	public WebElement getCsv() {
		return csv;
	}

}

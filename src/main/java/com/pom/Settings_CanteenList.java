package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_CanteenList {

	public WebDriver driver;

	@FindBy(id = "canteen")
	private WebElement canteenname;

	@FindBy(id = "short_code")
	private WebElement canteencode;

	@FindBy(xpath = "//a[@class='btn btn-dark btn-sm mr-1']")
	private WebElement overschedule;

	@FindBy(xpath = "//div[@id='navpills-0']//button[@type='button'][normalize-space()='Add New Dish']")
	private WebElement newdish;

	@FindBy(xpath = "//button[@class='btn-close']")
	private WebElement viewclose;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement close;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	private WebElement selectdish;

	@FindBy(xpath = "//button[@class='btn btn-primary float-end btn-add-item']")
	private WebElement add;

	@FindBy(xpath = "//a[@data-title='Enter Stock Quantity']")
	private WebElement stockqty;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-remove']")
	private WebElement cancel;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-md mb-5 btn-remove-item']")
	private WebElement delete;

	@FindBy(xpath = "//button[normalize-space()='Yes, remove it!']")
	private WebElement removeit;

	@FindBy(xpath = "//a[contains(text(),'Morning Break')]")
	private WebElement morningbreak;

	@FindBy(xpath = "//a[contains(text(),'Lunch')]")
	private WebElement lunch;

	@FindBy(xpath = "//a[contains(text(),'Evening Break')]")
	private WebElement eveningbreak;

	@FindBy(xpath = "//a[contains(text(),'Breakfast')]")
	private WebElement breakfast;

	public Settings_CanteenList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCanteenname() {
		return canteenname;
	}

	public WebElement getCanteencode() {
		return canteencode;
	}

	public WebElement getOverschedule() {
		return overschedule;
	}

	public WebElement getNewdish() {
		return newdish;
	}

	public WebElement getViewclose() {
		return viewclose;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSelectdish() {
		return selectdish;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getStockqty() {
		return stockqty;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getRemoveit() {
		return removeit;
	}

	public WebElement getMorningbreak() {
		return morningbreak;
	}

	public WebElement getLunch() {
		return lunch;
	}

	public WebElement getEveningbreak() {
		return eveningbreak;
	}

	public WebElement getBreakfast() {
		return breakfast;
	}
	
	

}

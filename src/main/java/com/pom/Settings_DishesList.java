package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_DishesList {

	public WebDriver driver;

	@FindBy(id = "name")
	private WebElement dishname;

	@FindBy(id = "price")
	private WebElement dishprice;

	@FindBy(id = "image")
	private WebElement image;

	@FindBy(xpath = "//label[@for='Include']")
	private WebElement gstinclude;

	@FindBy(xpath = "//label[@for='Exclude']")
	private WebElement gstexclude;

	@FindBy(xpath = "//label[@for='Veg']")
	private WebElement veg;

	@FindBy(xpath = "//label[@for='Non Veg']")
	private WebElement nonveg;

	@FindBy(id = "01h3vq0ngsn3sswr75tkwfqp4v")
	private WebElement breakfast;

	@FindBy(id = "01h3vq0nk3cbyx1wtzk8k0mx6k")
	private WebElement eveningbreak;

	@FindBy(id = "01h3vq0nja5a0ns82kr3eyvtb7")
	private WebElement lunch;

	@FindBy(id = "01h3vq0nhwhd8dv358kdjxs902")
	private WebElement morningbreak;

	@FindBy(id = "datatable-buttons_previous")
	private WebElement previouspage;

	@FindBy(id = "datatable-buttons_next")
	private WebElement nextpage;

	public Settings_DishesList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDishname() {
		return dishname;
	}

	public WebElement getDishprice() {
		return dishprice;
	}

	public WebElement getGstinclude() {
		return gstinclude;
	}

	public WebElement getGstexclude() {
		return gstexclude;
	}

	public WebElement getVeg() {
		return veg;
	}

	public WebElement getNonveg() {
		return nonveg;
	}

	public WebElement getBreakfast() {
		return breakfast;
	}

	public WebElement getEveningbreak() {
		return eveningbreak;
	}

	public WebElement getLunch() {
		return lunch;
	}

	public WebElement getMorningbreak() {
		return morningbreak;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getPreviouspage() {
		return previouspage;
	}

	public WebElement getNextpage() {
		return nextpage;
	}

}

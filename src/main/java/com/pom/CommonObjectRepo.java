package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonObjectRepo {

	public WebDriver driver;

	@FindBy(xpath = "//button[normalize-space()='New']")
	private WebElement create;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement reset;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//button[@data-bs-dismiss='alert']")
	private WebElement popup;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(xpath = "//button[@title='Reset']")
	private WebElement refresh;

	@FindBy(xpath = "//a[contains(@class,'btn btn-primary btn-sm mr-1')]")
	private WebElement edit;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-delete btn-sm mr-1']")
	private WebElement delete;

	@FindBy(xpath = "//button[normalize-space()='Yes, delete it!']")
	private WebElement deleteit;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement ok;

	@FindBy(xpath = "//button[@title='View']")
	private WebElement view;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement closeview;

	public CommonObjectRepo(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreate() {
		return create;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getPopup() {
		return popup;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getRefresh() {
		return refresh;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getDeleteit() {
		return deleteit;
	}

	public WebElement getOk() {
		return ok;
	}

	public WebElement getView() {
		return view;
	}

	public WebElement getCloseview() {
		return closeview;
	}

}

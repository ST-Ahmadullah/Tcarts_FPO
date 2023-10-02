package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_SchedulePlanner {

	public WebDriver driver;

	@FindBy(xpath = "//select[@id='canteen']")
	private WebElement selectcanteen;

	@FindBy(xpath = "//h4[normalize-space()='Monday']")
	private WebElement monday;

	@FindBy(xpath = "//h4[normalize-space()='Tuesday']")
	private WebElement tuesday;

	@FindBy(xpath = "//h4[normalize-space()='Wednesday']")
	private WebElement wednesday;

	@FindBy(xpath = "//h4[normalize-space()='Thursday']")
	private WebElement thursday;

	@FindBy(xpath = "//h4[normalize-space()='Friday']")
	private WebElement friday;

	@FindBy(xpath = "//h4[normalize-space()='Saturday']")
	private WebElement saturday;

	@FindBy(xpath = "//h4[normalize-space()='Sunday']")
	private WebElement sunday;

	@FindBy(xpath = "//button[normalize-space()='Yes, remove it!']")
	private WebElement removeit;

	public Settings_SchedulePlanner(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getSelectcanteen() {
		return selectcanteen;
	}

	public WebElement getMonday() {
		return monday;
	}

	public WebElement getTuesday() {
		return tuesday;
	}

	public WebElement getWednesday() {
		return wednesday;
	}

	public WebElement getThursday() {
		return thursday;
	}

	public WebElement getFriday() {
		return friday;
	}

	public WebElement getSaturday() {
		return saturday;
	}

	public WebElement getSunday() {
		return sunday;
	}

	public WebElement getRemoveit() {
		return removeit;
	}

}

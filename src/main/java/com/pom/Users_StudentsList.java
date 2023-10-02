package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_StudentsList {

	public WebDriver driver;
	
	@FindBy(id = "first_name")
	private WebElement firstname;
	
	@FindBy(id = "last_name")
	private WebElement lastname;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "registration_number")
	private WebElement regno;
	
	@FindBy(xpath = "//label[@for='Male']")
	private WebElement male;
	
	@FindBy(xpath = "//label[@for='Female']")
	private WebElement female;
	
	@FindBy(xpath = "//label[@for='Other']")
	private WebElement other;
	
	@FindBy(id = "department_id")
	private WebElement deptname;
	
	@FindBy(id = "primary_phone_number")
	private WebElement phonenumber;
	
	@FindBy(id = "alternate_phone_number")
	private WebElement alternatenumber;
	
	@FindBy(xpath = "//label[@for='status']")
	private WebElement statuscheckbox;

	public Users_StudentsList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getRegno() {
		return regno;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getDeptname() {
		return deptname;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getAlternatenumber() {
		return alternatenumber;
	}

	public WebElement getStatuscheckbox() {
		return statuscheckbox;
	}

}

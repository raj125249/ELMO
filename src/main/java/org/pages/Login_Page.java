package org.pages;

import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BasicFunctions {

	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
		
	@FindAll({ @FindBy(xpath = "//input[@id='userId']"), @FindBy(xpath = "//input[@name='userId']") })
	WebElement username_Field;

	public WebElement username_Field() {
		return username_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='password']"), @FindBy(xpath = "//input[@id='password']") })
	WebElement password_Field;

	public WebElement password_Field() {
		return password_Field;
	}

	@FindAll({ @FindBy(xpath = "//button[@name='btnLogin']"), @FindBy(xpath = "//button[@id='btnLogin']") })
	WebElement login_Button;

	public WebElement login_Button() {
		return login_Button;
	}

	@FindBy(xpath = "(//li[@class='dropdown nav-profile']//following::span[1])[1]")
	WebElement User_Profile_Name;

	public WebElement User_Profile_Name() {
		return User_Profile_Name;
	}

}

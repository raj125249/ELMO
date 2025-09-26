package org.testFunctions;

import java.awt.AWTException;

import java.io.IOException;


import org.common.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Login_Page;
import org.testng.annotations.Test;

public class Commercial_Login extends BaseClass {

	public static String Loginuser;
	public static String Loginuser_password;
	public static String Login_User_Name;

	@Test(dataProvider = "Comm_UW_Login")
	public void tc001(String S_No, String UserId, String Password_Query, String PassWord_Query_Column, String Run_Flag)
			throws IOException, InterruptedException, ClassNotFoundException, AWTException {

		//currentUrl2 = driver.getCurrentUrl();
		driver.get(currentUrl);
		Login_Page LP = new Login_Page();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(UserId);
		Loginuser = LP.username_Field().getAttribute("value");
		System.out.println("Login user id: " + Loginuser);

		String password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
				+ Loginuser + "'";
		Loginuser_password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Loginuser_password);
		
		
		Login_User_Name = get_DB_Data(password_Query, "USER_NAME");
		System.out.println("User Profile Name is: " + Login_User_Name);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();
		System.out.println("Application log in successfull");
	}
	
}
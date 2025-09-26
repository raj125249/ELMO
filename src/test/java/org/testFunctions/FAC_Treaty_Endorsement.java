package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Underwritting_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAC_Treaty_Endorsement extends BaseClass {

	@Test(dataProvider = "FAC_Treaty_Endorsement")
	public void tc_001(String S_No, String Search_Policy, String Policy_Number, String Type_of_Policy,
			String Insured_Name, String Endorsement_Type, String Remarks, String Doc_type, String FAC_Percentage_Value,
			String FAC_Participant_Name, String FAC_Participant_Share_Percentage_Value, String Run_Flag)
			throws AWTException, InterruptedException, IOException, ClassNotFoundException {

		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Login_Page LP = new Login_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		
		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 18, 1));
		String loginuser = LP.username_Field().getAttribute("value");
		System.out.println("Login user id: " + loginuser);

		String password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
				+ loginuser + "'";
		String Loginuser_password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Loginuser_password);

		webDriverWait(ExpectedConditions.visibilityOf(LP.login_Button()));
		LP.login_Button().click();

		String user_Profile_Name = get_DB_Data(password_Query, "USER_NAME");
		System.out.println("User Profile Name is: " + user_Profile_Name);

		if (user_Profile_Name.equals("Juan Siracusa")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Policy_Number);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
			// Policy Number Verification
			String policy_Number = GSP.Policy_Number().getText();
			System.out.println("Policy Number is: " + policy_Number);

			if (policy_Number.contains(Policy_Number)) {
				Assert.assertEquals(policy_Number, Policy_Number);
				System.out.println("Policy Number Verification is Pass");
			} else {
				Assert.fail();
				System.out.println("Policy Number Verification Failed");
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

//		Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			scrollDownJavaSc(GSP.get_Product());
			String Product_Type = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type);

// 		Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			Endorsement_Information_Page EIP = new Endorsement_Information_Page();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			String endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + endorsement_Type);

//		enter remarks
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

//    	click proceed
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();

			webDriverWait(ExpectedConditions.visibilityOf(apin.Policy_Document_Dropdown()));
			selectByVisibleText(apin.Policy_Document_Dropdown(), Doc_type);

			rb.delay(7000);
			// upload doc in policy level

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.upload_File()));
			apin.upload_File().click();
			StringSelection ss1 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			rb.delay(2000);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			rb.delay(7000);

			// Document Upload Success Message
//			webDriverWait(ExpectedConditions.visibilityOf(obje.DocumentUploadSuccess()));
//			String success_Msg1 = obje.DocumentUploadSuccess().getText();
//			System.out.println("Document Uploaded Message : " + success_Msg1);

// 		click Proceed
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
			EIP.proceed_Button().click();

			Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			ri.Prop_FAC().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
			ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
			ri.Save_Add_Participant().click();

			webDriverWait(ExpectedConditions.visibilityOf(ri.FAC_Participant_Name()));
			ri.FAC_Participant_Name().sendKeys(FAC_Participant_Name);
			rb.delay(3000);
			keyPress(KeyEvent.VK_ENTER);
			keyRelease(KeyEvent.VK_ENTER);
			System.out.println("FAC Participant Name = " + FAC_Participant_Name);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Share_Percentage()));
			ri.FAC_Participant_Share_Percentage().sendKeys(FAC_Participant_Share_Percentage_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Save_Close()));
			ri.FAC_Participant_Save_Close().click();

//		click proceed
			Thread.sleep(3000);
			webDriverWait(ExpectedConditions.visibilityOf(ri.proceed_Button()));
			scrollDownJavaSc(ri.proceed_Button());
			ri.proceed_Button().click();

//		Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());
			// object.approve_Endorsement_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
			String policyNumber = EIP.get_Policy().getText();
			System.out.println("Policy Number is: " + policy_Number);

			if (policyNumber.contains(Policy_Number)) {

				Assert.assertEquals(policyNumber, Policy_Number);
				System.out.println("Policy Number Verification Passed");

			} else {

				Assert.fail();
				System.out.println("Policy Number Verificstion Failed");
			}

//		Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			rb.delay(5000);

			if (GSP.FAC_Not_Closed().isDisplayed()) {

				if (user_Profile_Name.equals("Juan Siracusa")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.RI_Prop_FAC()));
					GSP.RI_Prop_FAC().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.FAC_Treaty_Button()));
					GSP.FAC_Treaty_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Approve_FAC_Button()));
					GSP.Approve_FAC_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Approve_Treaty_Button()));
					GSP.Approve_Treaty_Button().click();
				} else {

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys("juans");

					String RI_password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
							+ "juans" + "'";
					String RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(RI_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
//					Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//	 				Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Allocation_Menu()));
					ra.RI_Allocation_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_PolicyNo()));
					ra.RI_FAC_PolicyNo().sendKeys(Policy_Number, Keys.TAB);
					Thread.sleep(2000);

					// select last option of endorsement in RI allocation.
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_Trans_SrNo_Text()));
					Select select = new Select(ra.RI_FAC_Trans_SrNo_Text());
					List<WebElement> options = select.getOptions();
					int size = options.size() - 1;
					select.selectByIndex(size);

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_Policy_Search()));
					ra.RI_FAC_Policy_Search().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.RI_Prop_FAC()));
					javaScribtClick(GSP.RI_Prop_FAC());

					rb.delay(5000);
					// scrollDownJavaSc(obj.Approve_FAC_Button());
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Approve_FAC_Button()));
					GSP.Approve_FAC_Button().click();

					rb.delay(5000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Approve_FAC_Confirm()));
					javaScribtClick(GSP.Approve_FAC_Confirm());
					
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Approve_Treaty_Button()));
					GSP.Approve_Treaty_Button().click();
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Policy_Number);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

			}
		} else {
			System.out
					.println("Unable to process the " + Endorsement_Type + " Endorsement in the login userprofile id ");
		}
	}
}
package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.List;

import org.common.BaseClass;
import org.common.BasicFunctions;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.pages.Approval_Workflow_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Issue_Policy_RA_Slip extends BaseClass {
	
	public static String Quotation;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static String Policy_Number;
	public static String RI_Password;
	public static List<WebElement> MyAction;

	@Test(dataProvider = "Issue_Policy")
	public void tc_001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Floatingtype, String Floating_Policy, String Insured_Query, String Insured_ID,
			String Quotation_Validity_Days, String Co_Insurance_Share_Percentage, String Sum_Insured_Currency,
			String Premium_Currency, String Contact_Number, String Business_Occupation, String Territorial_Limits,
			String Product_Type, String Indeminity_Field, String Material_Policy_Damage_Number, String Introducer_Name,
			String Processor_Name, String Risk_Description, String Occupancy_Type, String Description,
			String Risk_Catagory, String Location, String Cyber_Risk, String Limit_Per_AOA, String Select_Reference,
			String Inward_SI, String Inward_Premium, String Multiple_Risk, String Multiple_SMI,
			String Sum_Insured_Amount, String Sum_Insured_Rate, String Sum_Insured_Premium, String SMI_Discount,
			String SMI_Loadings, String Discount_Rate, String Loading_Rate, String Edit_SMI, String Edit_SI,
			String Edit_SI_RATE, String Del_SMI, String Policy_Discount, String Policy_Discount_Rate,
			String Policy_Loading, String Policy_Loading_Rate, String Policy_Deductible,
			String Policy_Deductible_Calctype, String Policy_Deductible_RateValue, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Coinsurer_Share, String Doc_type, String Special_Tty, String RI_Ceding_Basic, String Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String Approve_Policy,

			String Policy_Endorsements, String Non_Financial_Endors, String Financial_Endors,
			String Change_Policy_Endors, String Extension_Policy_Endors, String Reduction_Policy_Endors,
			String FAC_Endors, String Discount_Loadings_Endors, String Policy_Cancellation_Endors,
			String Policy_Reinstatement_Endors, String PO_Box_Numer, String Address, String Edit_SI_Value,
			String Edit_SI_Rate, String Financial_Add_FAC,

			String Run_Flag) throws InterruptedException, AWTException, IOException, ClassNotFoundException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Commercial_Login CLP = new Commercial_Login();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		Global_Search_Page GSP = new Global_Search_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();
		
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		// get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quote_Number()));
		String quoteNumber = ra.get_Quote_Number().getText();
		// Get Gross_Premium
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Gross_Premium()));
		String gross_premium = ra.get_Gross_Premium().getText();
		System.out.println("Gross Premium Amount is: " + gross_premium);

		// Get Discount
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Discount()));
		String discount = ra.get_Discount().getText();
		System.out.println("Discount amount: " + discount);

		// Get Loading
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Loading()));
		// scrollDownJavaSc(obj3.get_Charge());
		String loading = ra.get_Loading().getText();
		System.out.println("Loading amount: " + loading);

		// Get Fees
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Charge()));
		String Fees = ra.get_Charge().getText();
		System.out.println("Fees/Charges value: " + Fees);

		// Get Policy Tax Amount
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Tax_amount()));
		String Policy_Tax_Amount = ra.get_Policy_Tax_amount().getText();
		System.out.println("Policy tax Amount is: " + Policy_Tax_Amount);

		// Get Inward Commission
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Inward_Commission_amount()));
		String Inward_Commission = ra.get_Inward_Commission_amount().getText();
		double Inward_Commission_Amount = string_To_double_Convert(Inward_Commission);

		// get Inward Commission Percentage
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Inward_Commission_Tax_Text()));
		String get_Inward_Commission_Tax_Text = ra.get_Inward_Commission_Tax_Text().getText();
		String drawDigitsFromString2 = StringHelper.drawDigitsFromString(get_Inward_Commission_Tax_Text);
		double Inward_Commission_percent = string_To_double_Convert(drawDigitsFromString2);

		double Inward_Commission_Tax = Inward_Commission_Amount * Inward_Commission_percent / 100;
		String Inward_Policy_Tax = String.format("%.2f", Inward_Commission_Tax);
		System.out.println("Inward Commission Tax is: " + Inward_Policy_Tax);

		// Get Inward Commission Amount
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Inward_Commission_Tax_Amount()));
		String Inward_Commission_Tax_Amount = ra.get_Inward_Commission_Tax_Amount().getText();
		System.out.println("Inward Commission tax amount: " + Inward_Commission_Tax_Amount);

		// Get Net To Customer
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
		String Net_To_Customer = ra.Net_to_Customer().getText();
		System.out.println("Net to Customer: " + Net_To_Customer);

		try {
			// Get Net Premium
			webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
			String NetPremium = ra.Net_Premium().getText();
			System.out.println("Net to Customer: " + NetPremium);
		} catch (Exception e) {
		}

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

		// click continue button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

		try {
			// get Qutation Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
			Quotation = ra.get_Quotation_Number().getText();
			System.out.println("Finalized Quotation: " + Quotation);

			// RA Slip Quotation print Docs
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_PrintDocs()));
			ra.Summary_Quotation_PrintDocs().click();
			rb.delay(3000);

			List<WebElement> listCheckBox = ra.Summary_Quotation_Checkbox();
			System.out.println("Print document List: " + listCheckBox.size());
			for (int i = 0; i < listCheckBox.size(); i++) {
				listCheckBox.get(i).click();
			}
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Print()));
			ra.Summary_Quotation_Print().click();
			Set<String> window = driver.getWindowHandles();
			String parentWindowHandle = driver.getWindowHandle();
			for (String handle : window) {
				driver.switchTo().window(handle);
				if (!(handle.equals(parentWindowHandle))) {
					System.out.println(driver.getTitle());
					// driver.close();
				}
			}
			driver.switchTo().window(parentWindowHandle);
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quote_Print_Close()));
			ra.Quote_Print_Close().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
			javaScribtClick(ra.global_Search_Button());
			// Enter Quote Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
			ra.Quote_Number_Field().sendKeys(Quotation);

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.quote_Search_Button()));
			ra.quote_Search_Button().click();

		} catch (Exception e) {
			try {
				if (ra.RI_Approval_Msg().isDisplayed()) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Approval_Msg()));
					String RI_Special_Treaty = ra.RI_Approval_Msg().getText();
					System.out.println("RI Special Treaty WF MSG: " + RI_Special_Treaty);

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(RI_Login_User);

					String RI_password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
							+ RI_Login_User + "'";
					RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(RI_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					String RI_User_Name = get_DB_Data(RI_password_Query, "USER_NAME");
					System.out.println("RI user name: " + RI_User_Name);

					rb.delay(3000);
//					Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//					Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();
					rb.delay(1000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
					ra.RI_Confirmation_Menu().click();

//					Search Quote Number 
					webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
					ra.search_Enq_Field().sendKeys(Quotation);

					rb.delay(3000);
//					Click Proportional RI Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
					ra.proportional_RI_Button().click();
					rb.delay(3000);

//					Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
					ra.remarks_Field().sendKeys(Remarks);

//					Click Confirm RI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
					ra.confirm_RI_Button().click();

//					Click Yes button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
					ra.yes_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//					Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
					ra.Quote_Number_Field().sendKeys(Quotation);

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.quote_Search_Button()));
					ra.quote_Search_Button().click();
				}

			} catch (Exception e2) {

				if (ra.Quotation_SI_WFMSG().isDisplayed()) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quotation_SI_WFMSG()));
					String SILevelMSG = ra.Quotation_SI_WFMSG().getText();
					System.out.println("SI level WF msg: " + SILevelMSG);
					String SI_WF_RefNo = extractWorkflowReference(SILevelMSG);
					System.out.println("Workflow Reference Number: " + SI_WF_RefNo);

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
					uwp.userNameField().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
					uwp.User_logout().click();
					
												 				

					username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
					WF_Description = get_DB_Data(username_Query, "WF_DESC");

					password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
							+ "') USER_PASSWORD FROM DUAL";
					App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("Claims WF Section: " + WF_Description);
							break;
						}
					}

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactionstab_Search()));
					WFA.Clm_Myactionstab_Search().sendKeys(SI_WF_RefNo);

					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approver_Viewoption()));
					WFA.Clm_Approver_Viewoption().click();

					rb.delay(20000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approve_Remarks()));
					WFA.Clm_Approve_Remarks().sendKeys("test");

					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_WF_Approve()));
					WFA.Clm_WF_Approve().click();

					rb.delay(5000);
					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
					uwp.userNameField().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
					uwp.User_logout().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Quote_Number_Field().sendKeys(Quotation);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_Button()));
					GSP.Quote_Search_Button().click();
				}
			}
		}
//Global Search Page Quote Print Docs		
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.SearchPage_Quote_Print_Docs()));
		GSP.SearchPage_Quote_Print_Docs().click();
		rb.delay(3000);
		List<WebElement> listCheckBoxes = GSP.Print_CheckBox();
		System.out.println("Print document List: " + listCheckBoxes.size());
		for (int i = 0; i < listCheckBoxes.size(); i++) {
			// webDriverWait(ExpectedConditions.visibilityOf(listCheckBoxes.get(i)));
			listCheckBoxes.get(i).click();
		}
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Print_Docs()));
		javaScribtClick(GSP.Quote_Print_Docs());
		Set<String> window1 = driver.getWindowHandles();
		String parentWindowHandle1 = driver.getWindowHandle();
		for (String handle : window1) {
			driver.switchTo().window(handle);
			if (!(handle.equals(parentWindowHandle1))) {
				System.out.println(driver.getTitle());
				// driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle1);
		rb.delay(3000);

//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_PrintDocs_Close()));
//		GSP.Quote_Search_PrintDocs_Close().click();

		navigateRefresh();
		rb.delay(5000);

// Approve as Policy in Search page.
		if (Approve_Policy.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.APPROVE_POLICY()));
			GSP.APPROVE_POLICY().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.mode_of_Pay_Dropdown()));
			selectByVisibleText(ra.mode_of_Pay_Dropdown(), Mode_Of_Pay);

			if (Mode_Of_Pay.equals("Cash")) {
				// Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
				ra.cash_Analysis_Button().click();

				// Click Add New Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
				ra.add_New_Button().click();

				// Click Check Box
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
				ra.cash_Code_Checkbox().click();

				// Select cash Type
				webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
				selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

				if (Cash_Type.equals("CHEQUE")) {
					// Enter Cheque No
					webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
					ra.cheque_Ref_Num().sendKeys(Cheque_No);

					// Select Bank Name
					webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
					selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

					// Enter Account Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
					ra.account_Number_Field().sendKeys(Account_Number);

					// Enter Cheque Date
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
					ra.cheque_End_Date().click();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime now = LocalDateTime.now();
					ra.cheque_End_Date().sendKeys(dtf.format(now));

					// Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(Net_To_Customer);
				} else if (Cash_Type.equals("CASH")) {
					// Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(Net_To_Customer);
				}

				// Save the details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
				ra.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit")) {
				webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
				rb.delay(2000);
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
			javaScribtClick(ra.approve_Policy_Button());
			// ra.approve_Policy_Button().click();

			try {
//				// Click RA Slip Approve as Policy Button
//				webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
//				javaScribtClick(ra.approve_Policy_Button());

				// get policy number
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
				Policy_Number = ra.get_Policy_Number().getText();
				System.out.println("Policy Number is: " + Policy_Number);

				// Click RA SLip page Summary policy Print.
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
				ra.Summary_Policy_PrintDocs().click();
				rb.delay(3000);
				List<WebElement> listCheckBoxes1 = ra.Summary_Quotation_Checkbox();
				System.out.println("Print document List: " + listCheckBoxes1.size());
				for (int i = 0; i < listCheckBoxes1.size(); i++) {
					listCheckBoxes1.get(i).click();
				}
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Print()));
				ra.Summary_Quotation_Print().click();
				Set<String> windows = driver.getWindowHandles();
				String parentWindowHandler = driver.getWindowHandle();
				for (String handle : windows) {
					driver.switchTo().window(handle);
					if (!(handle.equals(parentWindowHandler))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}
				driver.switchTo().window(parentWindowHandler);
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_Print_close()));
				ra.Summary_Policy_Print_close().click();

				// Click Global Search Button
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Policy_Number);

				// Click Policy Search Button
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

			} catch (Exception e) {
				if (ra.Quotation_SI_WFMSG().isDisplayed() || ra.Quotation_Information_RA().isDisplayed()) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quotation_SI_WFMSG()));
					String SILevelMSG = ra.Quotation_SI_WFMSG().getText();
					System.out.println("SI level WF msg: " + SILevelMSG);
					String SI_WF_RefNo = extractWorkflowReference(SILevelMSG);
					System.out.println("Workflow Reference Number: " + SI_WF_RefNo);

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
					uwp.userNameField().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
					uwp.User_logout().click();

					username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
					WF_Description = get_DB_Data(username_Query, "WF_DESC");

					password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
							+ "') USER_PASSWORD FROM DUAL";
					App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(App_User);
					System.out.println(App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("2nd level WF Section: " + WF_Description);
							break;
						}
					}
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactionstab_Search()));
					WFA.Clm_Myactionstab_Search().sendKeys(SI_WF_RefNo);

					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approver_Viewoption()));
					WFA.Clm_Approver_Viewoption().click();

					rb.delay(10000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approve_Remarks()));
					WFA.Clm_Approve_Remarks().sendKeys("test");

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_WF_Approve()));
					WFA.Clm_WF_Approve().click();

					webDriverWait(ExpectedConditions.visibilityOf(AWF.WF_Success_Msg()));
					String updateMSG = AWF.WF_Success_Msg().getText();
					System.out.println("Work Flow status: " + updateMSG);

					rb.delay(5000);
					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
					uwp.userNameField().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
					uwp.User_logout().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Quote No");

					// Search Policy via Quotation.
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Quotation);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.PolicyNo_Query()));
					Policy_Number = GSP.PolicyNo_Query().getText();
					System.out.println("Policy Number is: " + Policy_Number);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Docs()));
					GSP.Policy_Print_Docs().click();

					rb.delay(3000);
					List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
					System.out.println("Print document List: " + listCheckBoxes1.size());
					for (int i = 0; i < listCheckBoxes1.size(); i++) {
						listCheckBoxes1.get(i).click();
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
					GSP.Print_Docs().click();
					Set<String> windows = driver.getWindowHandles();
					String parentWindowHandler = driver.getWindowHandle();
					for (String handle : windows) {
						driver.switchTo().window(handle);
						if (!(handle.equals(parentWindowHandler))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
					GSP.Policy_Print_Close().click();
				}
			}
			rb.delay(3000);

			try {
				if (GSP.FAC_Not_Closed().isEnabled()) {
					if (CLP.Login_User_Name.equals("Juan Siracusa")) {

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
//				Click Menu Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
						ra.menu_Button().click();

//					Click RI Confirmation Log
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
						// scrollDownJavaSc(GSP.Approve_FAC_Button());
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
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Policy_Number);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

				}

			} catch (Exception e) {
			}

//			Click View Accounts Button
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.view_Accounting_Menu()));
			GSP.view_Accounting_Menu().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.VW_SearchType()));
			selectByIndex(GSP.VW_SearchType(), 1);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.VW_Endorsement_Type()));
			Select EndorType = new Select(GSP.VW_Endorsement_Type());
			List<WebElement> options = EndorType.getOptions();
			int size = options.size() - 1;
			EndorType.selectByIndex(size);

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.View_Accounting_Record()));
			GSP.View_Accounting_Record().click();

//			Click Print Docs Button
			scrollDownJavaSc(GSP.VW_Acc_Print_Docs());
			GSP.VW_Acc_Print_Docs().click();
			Set<String> windows = driver.getWindowHandles();
			String parentWindowHandler = driver.getWindowHandle();
			for (String handle : windows) {
				driver.switchTo().window(handle);
				if (!(handle.equals(parentWindowHandler))) {
					System.out.println(driver.getTitle());
					// driver.close();
				}
			}
			driver.switchTo().window(parentWindowHandler);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.VW_Back_Policy()));
			GSP.VW_Back_Policy().click();

		}

	}

}

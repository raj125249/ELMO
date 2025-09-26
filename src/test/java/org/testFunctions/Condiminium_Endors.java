package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Approval_Workflow_Page;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.testng.annotations.Test;

public class Condiminium_Endors extends BaseClass {

	public static String OurSI;
	public static String Endor_policy;
	public static String policy_Type;
	public static String username_Query;
	public static String password_Query;
	public static String Quote_Number;
	public static String App_User;
	public static String Product_Type;
	public static String App_Password;
	public static String WF_Description;
	public static String RI_Password;
	public static List<WebElement> checkboxes;
	public static List<WebElement> MyAction;
	public static String Mode_Of_Pay;
	public static String Endorsement_Type;

	@Test(dataProvider = "Condominium_Endors")
	public void tc_001(String S_No, String Search_Policy, String Policy_Query, String Query_Policy, String Remarks,
			String Contact_No, String Email_ID, String Address, String Doc_type, String Coinsurer_Name_Query,
			String Coinsurer_ID, String RI_Login_User, String Risk_Description, String Select_Reference,
			String Description, String Location, String Sum_Insured_Rate, String Sum_Insured_Amount,
			String Limit_Per_AOA, String Cyber_Risk, String Inward_SI, String Inward_Premium, String Financial_Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User1, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account,

			String Edit_SI_Value, String Edit_SI_Rate, String Add_Risk, String Add_Risk_SI, String Add_SMI,
			String Del_Risk, String Del_SMI, String Edit_SMI, String Policy_Endorsements, String Non_Financial_Endor,
			String Financial_Endors, String Change_PolicyPeriod_Endor, String Extension_PolicyPeriod_Endor,
			String Reduction_PolicyPeriod_Endor, String FAC_Endors, String Change_BS_Endor, String Discount_Loadings_Endors,
			String Policy_Cancellation_Endor, String Policy_Reinstatement_Endor, String Run_Flag)
			throws AWTException, InterruptedException, IOException, ClassNotFoundException, ParseException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		PersonalUW_Login PLP = new PersonalUW_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		Condominium_Policy con_pol = new Condominium_Policy();
		Underwritting_Page uwp = new Underwritting_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();

//Policy Endorsements validation
		if (Policy_Endorsements.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

			if (con_pol.Policy_Number == null) {
				String Endorse_Policy = "SELECT * FROM (SELECT TPI_POLICY_NO FROM T_POL_INFO WHERE TPI_STATUS = 'A' AND NOT EXISTS (SELECT 1 FROM Q_POL_INFO WHERE\r\n"
						+ "QPI_TRAN_TYPE='REN' and QPI_OLD_POLICY_NO = TPI_POLICY_NO) AND TPI_BDM_USER IS NULL AND (TPI_END_TYPE != '008' OR \r\n"
						+ "TPI_END_TYPE IS NULL) and (tpi_prod_code in (0101)) and TPI_SCH_CODE in (168,169) ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = '1'";
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
				// GSP.Policy_Number_Field().sendKeys(get_DB_Data(Endorse_Policy,
				// "TPI_POLICY_NO"));
				// GSP.Policy_Number_Field().sendKeys("03356000254");
			} else {
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(con_pol.Policy_Number);
			}
		}

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		Endor_policy = GSP.Policy_Number().getText();
		System.out.println("Endorsment Policy: " + Endor_policy);

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String Policytype = GSP.Policy_Type().getText();
		System.out.println("Type of Policy: " + Policytype);

		if (Non_Financial_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Non Financial");

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String Pol_Start_Date = GSP.policy_Start_Date().getAttribute("value");
			System.out.println("Actual Policy Start Date: " + Pol_Start_Date);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
			String Pol_To_Date = GSP.policy_To_Date().getAttribute("value");
			System.out.println("Actual Policy To Date: " + Pol_To_Date);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			try {

				if (GSP.Endor_Date_validation().isDisplayed()) {

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Endor_Date_validation()));
					String Error = GSP.Endor_Date_validation().getText();
					System.out.println(Error);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
					GSP.effective_From_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime date = LocalDateTime.parse(Pol_Start_Date, formatter);
					LocalDateTime newDate = date.plusDays(30);
					String newDateString = newDate.format(formatter);
					GSP.effective_From_Date().sendKeys(newDateString);
					System.out.println("Endorsement Effective From Date: " + newDateString);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
					GSP.proceed_Button().click();
				}

			} catch (Exception e) {

			}

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

//			Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys("change in details");

//			Enter PO BOx Number
			webDriverWait(ExpectedConditions.visibilityOf(EIP.po_Box_Field()));
			EIP.po_Box_Field().clear();
			EIP.po_Box_Field().sendKeys("5645364");

//			Change Address
			webDriverWait(ExpectedConditions.visibilityOf(EIP.address_Field()));
			EIP.address_Field().clear();
			EIP.address_Field().sendKeys("Maltese");

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

//			edit risk in endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Endo_edit_risk()));
			ris.Endo_edit_risk().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Description_Field()));
			ris.risk_Description_Field().clear();
			ris.risk_Description_Field().sendKeys("Risk");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

			Thread.sleep(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

//			Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
			javaScribtClick(EIP.approve_Non_Financial_Endorsement());

			try {

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
				ra.Summary_Policy_PrintDocs().click();

				rb.delay(3000);
				List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
				System.out.println("Print document List: " + listCheckBoxes1.size());
				for (int i = 0; i < listCheckBoxes1.size(); i++) {
					listCheckBoxes1.get(i).click();
				}
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
				GSP.Print_Docs().click();
				Set<String> windows1 = driver.getWindowHandles();
				String parentWindowHandler1 = driver.getWindowHandle();
				for (String handle : windows1) {
					driver.switchTo().window(handle);
					if (!(handle.equals(parentWindowHandler1))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}
				driver.switchTo().window(parentWindowHandler1);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
				GSP.Policy_Print_Close().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
//			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

			} catch (Exception e) {

				// non-financial RI WF
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
					LP.username_Field().sendKeys(RI_Login_User1);

					String RI_password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
							+ RI_Login_User1 + "'";
					RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(RI_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					String RI_User_Name = get_DB_Data(RI_password_Query, "USER_NAME");
					System.out.println("RI user name: " + RI_User_Name);

//				Click Menu Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//				Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();
					rb.delay(1000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
					ra.RI_Confirmation_Menu().click();

//				Search Quote Number 
					webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
					ra.search_Enq_Field().sendKeys(Endor_policy);
					rb.delay(3000);

//				Click Proportional RI Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
					ra.proportional_RI_Button().click();
					rb.delay(3000);

//				Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
					ra.remarks_Field().sendKeys(Remarks);

//				Click Confirm RI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
					ra.confirm_RI_Button().click();

//				Click Yes button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
					ra.yes_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());

//				Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
					GSP.endorsement_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
					javaScribtClick(EIP.approve_Non_Financial_Endorsement());

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
					ra.Summary_Policy_PrintDocs().click();

					rb.delay(3000);
					List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
					System.out.println("Print document List: " + listCheckBoxes1.size());
					for (int i = 0; i < listCheckBoxes1.size(); i++) {
						listCheckBoxes1.get(i).click();
//						}
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
						GSP.Print_Docs().click();
						Set<String> windows1 = driver.getWindowHandles();
						String parentWindowHandler1 = driver.getWindowHandle();
						for (String handle : windows1) {
							driver.switchTo().window(handle);
							if (!(handle.equals(parentWindowHandler1))) {
								System.out.println(driver.getTitle());
								// driver.close();
							}
						}

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();
					}

				} else if (ra.Quotation_SI_WFMSG().isDisplayed()) {

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
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Quote_Number_Field().sendKeys(Quote_Number);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_Button()));
					GSP.Quote_Search_Button().click();
				}
			}
// nonfinancial endorsement ends here	
		}

		if (Financial_Endors.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			Product_Type = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Financial");

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String Pol_Start_Date = GSP.policy_Start_Date().getAttribute("value");
			System.out.println("Actual Policy Start Date: " + Pol_Start_Date);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
			String Pol_To_Date = GSP.policy_To_Date().getAttribute("value");
			System.out.println("Actual Policy To Date: " + Pol_To_Date);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			try {
				if (GSP.Endor_Date_validation().isDisplayed()) {

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Endor_Date_validation()));
					String Error = GSP.Endor_Date_validation().getText();
					System.out.println(Error);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
					GSP.effective_From_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime date = LocalDateTime.parse(Pol_Start_Date, formatter);
					LocalDateTime newDate = date.plusDays(30);
					String newDateString = newDate.format(formatter);
					GSP.effective_From_Date().sendKeys(newDateString);
					System.out.println("Endorsement Effective From Date: " + newDateString);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
					GSP.proceed_Button().click();
				}
			} catch (Exception e) {
			}

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

//		business source
			webDriverWait(ExpectedConditions.visibilityOf(EIP.Business_source()));
			String B_Source = EIP.Business_source().getText();
			System.out.println("Business source: " + B_Source);

//		Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

//		Risk information page
			if (Add_Risk.equals("Yes")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_Button()));
				ris.Add_Risk_Button().click();

				// Enter Risk Description
				webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
				ris.risk_Description_Field().sendKeys(Risk_Description);

				if (Policytype.equals("Erection All Risks") || Policytype.equals("Contractors All Risks Insurance")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.select_reference()));
					selectByVisibleText(ris.select_reference(), Select_Reference);
					System.out.println("Select reference: " + Select_Reference);

					webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
					ris.Contractor_Name().sendKeys("Site Engineer");
				}

				// Select description
				webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
				selectByVisibleText(ris.description_Dropdown(), Description);

				// Enter Location
				webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
				ris.Location_Field().sendKeys(Location);
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Location_List()));
				ris.Location_List().click();

				// Click Longitude Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
				ris.find_Latitude().click();

				rb.delay(7000);
				webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
				javaScribtClick(ris.ok_Button());

				if (Policytype.equals("Contract Works Insurance")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.PA_Permit_No()));
					ris.PA_Permit_No().sendKeys("7865464");
					System.out.println("PA Permit No: 7865464");
				}

				policy_Type = Product_Type;

				switch (policy_Type) {
				case "Liability Commercial":
					// Enter Limit Per AOA
					webDriverWait(ExpectedConditions.visibilityOf(ris.Limit_Per_AOA_Field()));
					ris.Limit_Per_AOA_Field().sendKeys(Limit_Per_AOA);
					break;
				case "Fire Commercial":
					// Select Cyber Risk
					webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
					selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
					break;
				case "Electronic Equipment Insurance":
					// Select Cyber Risk
					webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
					selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
					break;
				default:
					break;
				}

				// Inward formation section
				if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {

					// 100% and Our SI & Premium value
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
					ris.Risk_Inward_SI().sendKeys(Inward_SI, Keys.TAB);
					System.out.println("Inward SI Value: " + Inward_SI);

					rb.delay(3000); //
					webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurSI()));
					OurSI = getAtrributeValue(ris.Risk_Inward_OurSI(), "value");
					System.out.println("Inward Our SI value: " + OurSI);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
					ris.Risk_Inward_Premium().sendKeys(Inward_Premium, Keys.TAB);
					System.out.println("Inward Premium Value: " + Inward_Premium);

					rb.delay(3000); //
					webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurPremium()));
					String OurPremium = getAtrributeValue(ris.Risk_Inward_OurPremium(), "value");
					System.out.println("Inward our Premium Value: " + OurPremium);
				}

				// Click save Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();

				// Get Risk Success Msg
				webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Success_Msg()));
				String risk_Success_Msg = ris.Risk_Success_Msg().getText();
				System.out.println("Risk Success Msg is: " + risk_Success_Msg);

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box2()));
				ris.risk_Check_Box2().click();

				// Click Add SMI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
				javaScribtClick(ris.Add_SMI_Button());

				rb.delay(3000);
				// uncheck the check boxes
				try {
					checkboxes = ris.SMI_CheckBox_Uncheck();
					for (WebElement checked : checkboxes) {
						if (checked.isSelected()) {
							checked.click();
						}
					}
				} catch (Exception e) {
				}

				// Add SMI details
				if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
					// Enter SMI check box Details conditions to be handled
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
					ris.Inward_OurSMI_Checkbox().click();

					if (Policytype.equals("Erection All Risks")) {
						webDriverWait(ExpectedConditions.elementToBeClickable(ris.professional_Fees_Checkbox()));
						ris.professional_Fees_Checkbox().click();
					}
					// Enter SI value
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
					ris.Inward_OurSMI_SI().click();
					doubleClick(ris.sum_Insured_Field());
					ris.Inward_OurSMI_SI().sendKeys(OurSI);
					System.out.println("Inward Our SI value: " + OurSI);

					// Enter rate value.
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
					ris.Inward_OurSMI_Rate().sendKeys("1.08308", Keys.TAB);

					// Save Sum Insured Details
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
					ris.save_Button().click();

				} else {

					// Enter SMI check box Details conditions to be handled
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
					ris.Sum_Insured_checkbox().click();

					// Enter SI value
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().clear();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(Add_Risk_SI, Keys.TAB);
					System.out.println("New Risk SI value: " + Add_Risk_SI);

					// Enter rate value.
					webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
					ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

//					if (Policytype.equals("Erection All Risks")) {
//						webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//						Thread.sleep(3000);
//						ris.professional_Fees_Rate_per().click();
//						ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					} else if (Policytype.equals("Group Personal Accident and Annual Business Travel")) {
//						ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					}

					Thread.sleep(1000);
					// Save Sum Insured Details
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
					ris.save_Button().click();
				}
			}

			if (Add_SMI.equals("Yes")) {

				scrollUpJavaSc(ris.risk_Check_Box());
				rb.delay(4000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
				ris.risk_Check_Box().click();

				// Click Add SMI Button
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
				ris.Add_SMI_Button().click();

				rb.delay(3000);
				try {
					checkboxes = ris.SMI_CheckBox_Uncheck();
					for (WebElement checked : checkboxes) {
						if (checked.isSelected()) {
							checked.click();
						}
					}
				} catch (Exception e) {
				}

				if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
					ris.Inward_OurSMI_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
					ris.Inward_OurSMI_SI().sendKeys("15000");

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
					ris.Inward_OurSMI_Rate().sendKeys("1", Keys.TAB);
				} else {
					// Enter SMI check box Details conditions to be handled
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
					javaScribtClick(ris.Sum_Insured_checkbox());

					// Enter SI value
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().click();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
					System.out.println("New SMI SI value: " + Sum_Insured_Amount);

					// Enter rate value.
					webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
					ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

//					if (Policytype.equals("Erection All Risks")) {
//						webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//						Thread.sleep(3000);
//						ris.professional_Fees_Rate_per().click();
//						ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					} else if (Policytype.equals("Group Personal Accident and Annual Business Travel")) {
//						ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					}
					Thread.sleep(1000); // Save Sum Insured Details
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
					ris.save_Button().click();
				}
			}

			if (Edit_SMI.equals("Yes")) {

				scrollUpJavaSc(ris.risk_Check_Box());
				rb.delay(8000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
				ris.risk_Check_Box().click();

				if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
//					Click the risk edit icon to enter the Inward SI and Premium
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditRisk_Button()));
					ris.EditRisk_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
					ris.Risk_Inward_SI().sendKeys("150000");

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
					ris.Risk_Inward_Premium().sendKeys("1500");

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_OurSI()));
					String Endo_Inward_OurSI = ris.Risk_Inward_OurSI().getText();
					System.out.println("Endo Inward OurSI " + Endo_Inward_OurSI);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_OurPremium()));
					String Endo_Inward_Premium = ris.Risk_Inward_OurPremium().getText();
					System.out.println("Endo Inward Premium " + Endo_Inward_Premium);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
					ris.save_Button().click();
					rb.delay(3000);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditSMI_Risk()));
					ris.EditSMI_Risk().click();
					rb.delay(2000);
					// SMI edit

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_EDIT_ICON()));
					ris.SMI_EDIT_ICON().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));
					ris.EDIT_SI_Value().sendKeys(Endo_Inward_OurSI);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
					ris.Inward_OurSMI_Rate().sendKeys("1.08308", Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
					ris.Save_EDIT_SI().click();

				} else {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditSMI_Risk()));
					ris.EditSMI_Risk().click();
					rb.delay(3000);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].value = '';", ris.EDIT_SI_Value());
					ris.EDIT_SI_Value().sendKeys(Edit_SI_Value, Keys.TAB);
					System.out.println("Edited SMI Value: " + Edit_SI_Value);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Rate()));
					// doubleClick(ris.EDIT_SI_Rate());
					ris.EDIT_SI_Rate().clear();
					ris.EDIT_SI_Rate().sendKeys(Edit_SI_Rate, Keys.TAB);

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
					ris.Save_EDIT_SI().click();
				}
			}

			if (Del_SMI.equals("Yes")) {
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
				javaScribtClick(ris.risk_Check_Box());

				rb.delay(5000);
				scrollDownJavaSc(ris.Del_SMI());
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Del_SMI()));
				ris.Del_SMI().click();
			}

			if (Del_Risk.equals("Yes")) {
				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Del_Risk()));
				javaScribtClick(ris.Del_Risk());

				scrollUpJavaSc(ris.DelRisk_Yes());
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.DelRisk_Yes()));
				ris.DelRisk_Yes().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
				ris.confirm_ok_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.RevertRisk_SI_Value()));
				String RevertSI = ris.RevertRisk_SI_Value().getText();
				System.out.println("Deletion Risk SI value " + RevertSI);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.RevertRisk_Premium_Value()));
				String RevertPremium = ris.RevertRisk_Premium_Value().getText();
				System.out.println("Deletion Risk Premium value " + RevertPremium);
			}

			// click Proceed option to add pol info page.
			scrollDownJavaSc(ris.Proceed_Button());
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
			ris.Proceed_Button().click();
			System.out.println("Proceed to add pol info page");

			// Add pol info page
			// Coinsurance section
			if (B_Source.equals("Direct with Elmo Leader") || B_Source.equals("Direct with Elmo Follower")
					|| B_Source.equals("Broker with Elmo Leader") || B_Source.equals("Broker with Elmo Follower")
					|| B_Source.equals("Salesman with Elmo Leader") || B_Source.equals("Introducers with Elmo Leader")
					|| B_Source.equals("Branches with Elmo Leader") || B_Source.equals("Staff with Elmo Leader")
					|| B_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {

				webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_SI()));
				String Coinsurer_Share_SI = apin.co_Insurer_Share_SI().getText();
				System.out.println("coinsurer share SI value " + Coinsurer_Share_SI);

				webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
				String Coinsurer_sharePremium = apin.co_Insurer_Share_Premium().getText();
				System.out.println("coinsurer share premium value " + Coinsurer_sharePremium);
			}

//			Click proceed
			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
			javaScribtClick(apin.proceed_Button());
			System.out.println("procced to RI ceding page");

			// proceeding to RI ceding page.
			if (LP.User_Profile_Name().equals("Juan Siracusa") && Financial_Add_FAC.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
				ri.Prop_FAC().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Placement_CheckBox()));
				ri.FAC_Placement_CheckBox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
				ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
				ri.Save_Add_Participant().click();

				webDriverWait(ExpectedConditions.visibilityOf(ri.FAC_Participant_Name()));
				ri.FAC_Participant_Name().sendKeys(get_DB_Data(FAC_Participant_Query, FAC_ID));
				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Select_FAC_Participant_Name()));
				ri.Select_FAC_Participant_Name().click();
				String FACParticipant = getAtrributeValue(ri.FAC_Participant_Name(), "value");
				System.out.println("FAC Participant Name = " + FACParticipant);

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Share_Percentage()));
				ri.FAC_Participant_Share_Percentage().sendKeys(FAC_Participant_Share_Percentage_Value, Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Save_Close()));
				ri.FAC_Participant_Save_Close().click();

			} else if (LP.User_Profile_Name().equals("Juan Siracusa") && Financial_Add_FAC.equals("No")) {
			}

			// Click proceed button
			Thread.sleep(3000);
			webDriverWait(ExpectedConditions.visibilityOf(ris.Proceed_Button()));
			scrollDownJavaSc(ris.Proceed_Button());
			ris.Proceed_Button().click();

			// RA slip page.

//			Get Net To Customer
			webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
			String Net_To_Customer = ra.Net_to_Customer().getText();
			System.out.println("Net to Customer: " + Net_To_Customer);

//			Select Mode of Pay
			webDriverWait(ExpectedConditions.visibilityOf(ra.mode_of_Pay_Dropdown()));
			Select modelist = new Select(ra.mode_of_Pay_Dropdown());
			List<WebElement> ModeOfPay = modelist.getOptions();
			List<WebElement> Options = new ArrayList<>();
			for (WebElement options : ModeOfPay) {
				if (!options.getText().toLowerCase().contains("select")) {
					Options.add(options);
				}
			}
			if (!Options.isEmpty()) {
				Random ModeofPay = new Random();
				int randomPayMode = ModeofPay.nextInt(Options.size());
				modelist.selectByIndex(ModeOfPay.indexOf(Options.get(randomPayMode)));
				Mode_Of_Pay = Options.get(randomPayMode).getText();
				System.out.println("Mode of Pay: " + Mode_Of_Pay);
			}

			if (Mode_Of_Pay.equals("Cash") || Mode_Of_Pay.equals("Cash sale combined")) {
//				Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
				javaScribtClick(ra.cash_Analysis_Button());

//				Click Add New Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
				ra.add_New_Button().click();

//				Click Check Box
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
				ra.cash_Code_Checkbox().click();

//				Select cash Type
				webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
				selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

				if (Cash_Type.equals("CHEQUE")) {
//					Enter Cheque No
					webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
					ra.cheque_Ref_Num().sendKeys(Cheque_No);

//					Select Bank Name
					webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
					selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//					Enter Account Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
					ra.account_Number_Field().sendKeys(Account_Number);

//					Enter Cheque Date
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
					ra.cheque_End_Date().click();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime now = LocalDateTime.now();
					ra.cheque_End_Date().sendKeys(dtf.format(now));

//					Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

				} else if (Cash_Type.equals("CASH")) {

//					Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

				}
//				Save the details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
				ra.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit") || Mode_Of_Pay.equals("Debit")) {

				webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
				rb.delay(3000);
				selectByIndex(ra.Insured_Billing_Account(), 1);

			} else if (Mode_Of_Pay.equals("SEPA")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_AC_Number()));
				ra.SEPA_AC_Number().clear();
				ra.SEPA_AC_Number().sendKeys("10112407330018");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_Swift_Code()));
				ra.SEPA_Swift_Code().clear();
				ra.SEPA_Swift_Code().sendKeys("APSBMTMT");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_IBAN()));
				ra.SEPA_IBAN().clear();
				ra.SEPA_IBAN().sendKeys("MT02APSB77046002407312407330018");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BankList()));
				selectByIndex(ra.SEPA_BankList(), 2);

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BIC_Code()));
				ra.SEPA_BIC_Code().clear();
				ra.SEPA_BIC_Code().sendKeys("HJGFTUYT675785465");
			}

			Thread.sleep(15000);

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());
			// obj5.approve_Endorsement_Button().click();

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
					LP.username_Field().sendKeys(RI_Login_User1);

					String RI_password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
							+ RI_Login_User1 + "'";
					RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(RI_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					String RI_User_Name = get_DB_Data(RI_password_Query, "USER_NAME");
					System.out.println("RI user name: " + RI_User_Name);

					rb.delay(3000);
//			Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//			Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();
					rb.delay(1000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
					ra.RI_Confirmation_Menu().click();

//			Search Quote Number 
					webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
					ra.search_Enq_Field().sendKeys(Endor_policy);

					rb.delay(3000);
//			Click Proportional RI Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
					ra.proportional_RI_Button().click();
					rb.delay(3000);

//			Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
					ra.remarks_Field().sendKeys(Remarks);

//			Click Confirm RI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
					ra.confirm_RI_Button().click();

//			Click Yes button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
					ra.yes_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//			Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
					GSP.endorsement_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

				}

			} catch (Exception e) {

			} finally {

			}

			try {

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
				Endor_policy = EIP.get_Policy().getText();
				System.out.println("Policy Number is: " + Endor_policy);

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

				Set<String> windows1 = driver.getWindowHandles();
				String parentWindowHandler1 = driver.getWindowHandle();
				for (String handle : windows1) {
					driver.switchTo().window(handle);

					if (!(handle.equals(parentWindowHandler1))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}
				driver.switchTo().window(parentWindowHandler1);
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quote_Print_Close()));
				ra.Quote_Print_Close().click();

				rb.delay(5000);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

			} catch (Exception e) {

				try {
					if (Mode_Of_Pay.equals("Cash")) {
//						Click Cash Analysis
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
						ra.cash_Analysis_Button().click();

//						Click Add New Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
						ra.add_New_Button().click();

//						Click Check Box
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
						ra.cash_Code_Checkbox().click();

//						Select cash Type
						webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
						selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

						if (Cash_Type.equals("CHEQUE")) {
//							Enter Cheque No
							webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
							ra.cheque_Ref_Num().sendKeys(Cheque_No);

//							Select Bank Name
							webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
							selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//							Enter Account Number
							webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
							ra.account_Number_Field().sendKeys(Account_Number);

//							Enter Cheque Date
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
							ra.cheque_End_Date().click();

							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDateTime now = LocalDateTime.now();
							ra.cheque_End_Date().sendKeys(dtf.format(now));
//							
//							Enter Amount
							webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
							ra.amount_Field().sendKeys(con_pol.Net_To_Customer);
						} else if (Cash_Type.equals("CASH")) {

//							Enter Amount
							webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
							ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

						}

//						Save the details
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
						ra.save_Cash_Analysis().click();

					} else if (Mode_Of_Pay.equals("Credit")) {
						webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
						rb.delay(3000);
						selectByIndex(ra.Insured_Billing_Account(), 1);
					}
				} catch (Exception e2) {
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
				javaScribtClick(EIP.approve_Non_Financial_Endorsement());

				try {

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
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						rb.delay(2000);
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
						selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

						// Search Policy via Quotation.
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();

					}

				} catch (Exception e2) {
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
				ra.Summary_Policy_PrintDocs().click();

				rb.delay(3000);
				List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
				System.out.println("Print document List: " + listCheckBoxes1.size());
				for (int i = 0; i < listCheckBoxes1.size(); i++) {
					listCheckBoxes1.get(i).click();
				}
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
				GSP.Print_Docs().click();
				Set<String> windows1 = driver.getWindowHandles();
				String parentWindowHandler1 = driver.getWindowHandle();
				for (String handle : windows1) {
					driver.switchTo().window(handle);
					if (!(handle.equals(parentWindowHandler1))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();
			}

//Financial endorsment ends here.
		}

		if (Change_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Change in Policy Period");

			// Enter Endorsement From Date
			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
			GSP.effective_From_Date().click();
			keyPress(KeyEvent.VK_CONTROL);
			keyPress(KeyEvent.VK_A);
			keyRelease(KeyEvent.VK_CONTROL);
			keyRelease(KeyEvent.VK_A);

			keyPress(KeyEvent.VK_BACK_SPACE);
			keyRelease(KeyEvent.VK_BACK_SPACE);
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// Get the current date
			LocalDate currentDate1 = LocalDate.now();
			// Add one day to the current date to get the next date
			LocalDate nextDate1 = currentDate1.plusDays(20);
			// Format the next date to the desired format
			String formattedNextDate1 = nextDate1.format(formatter1);
			GSP.effective_From_Date().sendKeys(formattedNextDate1);

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			try {

				webDriverWait(ExpectedConditions.visibilityOf(EIP.Change_PolicyPeriod_Validation()));
				String Change_Period = EIP.Change_PolicyPeriod_Validation().getText();
				System.out.println(Change_Period);

				if (EIP.Change_PolicyPeriod_Validation().isEnabled()) {
					System.out.println("Change Period validation Msg: " + Change_Period);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy, Keys.ENTER);
				}
			} catch (Exception e) {

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + endorsement_Type);

				// Get Policy Number
//				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
//				String policy_No = EIP.get_Policy_Number().getText();

				// Get Customer name
				webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
				String customer_Name = EIP.customer_Name().getText();
				String customer = customer_Name.replace(" - ", "-");
				System.out.println("Customer name is: " + customer);

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Get Premium Amount
				webDriverWait(ExpectedConditions.visibilityOf(EIP.deleted_SMI_Premium()));
				String SMI_Premium_Amount = EIP.deleted_SMI_Premium().getText();

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				Thread.sleep(20000);

				// get Policy Fess
				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
				String policy_Fees = EIP.get_Policy_Fees().getText();
				System.out.println("Policy Fees Amount is: " + policy_Fees);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();
				Thread.sleep(2000);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();
				Thread.sleep(5000);

				// Get Gross_Premium
				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
				String gross_premium1 = EIP.get_Gross_Premium().getText();
				System.out.println("Gross Premium Amount is: " + gross_premium1);

				try {
					// Get Net Premium
					webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
					String NetPremium = ra.Net_Premium().getText();
					System.out.println("Net to Customer: " + NetPremium);
				} catch (Exception e1) {
				}

//		Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

				try {
					webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
					String policyNumber = EIP.get_Policy().getText();
					System.out.println("Policy Number is: " + policyNumber);

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

					Set<String> windows1 = driver.getWindowHandles();
					String parentWindowHandler1 = driver.getWindowHandle();
					for (String handle : windows1) {
						driver.switchTo().window(handle);

						if (!(handle.equals(parentWindowHandler1))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler1);

					rb.delay(5000);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
				} catch (Exception e7) {
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
						ra.search_Enq_Field().sendKeys(Endor_policy);

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
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
						javaScribtClick(ra.global_Search_Button());
//					Enter Quote Number
						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
						GSP.endorsement_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						try {
							if (Mode_Of_Pay.equals("Cash")) {
//					Click Cash Analysis
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
								ra.cash_Analysis_Button().click();

//					Click Add New Button
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
								ra.add_New_Button().click();

//					Click Check Box
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
								ra.cash_Code_Checkbox().click();

//					Select cash Type
								webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
								selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

								if (Cash_Type.equals("CHEQUE")) {
//						Enter Cheque No
									webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
									ra.cheque_Ref_Num().sendKeys(Cheque_No);

//						Select Bank Name
									webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
									selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//						Enter Account Number
									webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
									ra.account_Number_Field().sendKeys(Account_Number);

//						Enter Cheque Date
									webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
									ra.cheque_End_Date().click();

									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
									LocalDateTime now = LocalDateTime.now();
									ra.cheque_End_Date().sendKeys(dtf.format(now));
//						
//						Enter Amount
									webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
									ra.amount_Field().sendKeys(con_pol.Net_To_Customer);
								} else if (Cash_Type.equals("CASH")) {

//						Enter Amount
									webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
									ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

								}

//					Save the details
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
								ra.save_Cash_Analysis().click();

							} else if (Mode_Of_Pay.equals("Credit")) {
								webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
								rb.delay(3000);
								selectByIndex(ra.Insured_Billing_Account(), 1);
							}
						} catch (Exception e2) {
						}

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
						javaScribtClick(EIP.approve_Non_Financial_Endorsement());

						try {

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
								LP.username_Field().sendKeys(PLP.Loginuser);

								webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
								LP.password_Field().sendKeys(PLP.Loginuser_password);

								webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
								LP.login_Button().click();

								rb.delay(2000);
								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
								GSP.global_Search_Button().click();

								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
								selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

								// Search Policy via Quotation.
								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
								GSP.Policy_Number_Field().sendKeys(Endor_policy);

								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
								GSP.policy_Search_Button().click();

							}

						} catch (Exception e2) {

						}

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
						ra.Summary_Policy_PrintDocs().click();

						rb.delay(3000);
						List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
						System.out.println("Print document List: " + listCheckBoxes1.size());
						for (int i = 0; i < listCheckBoxes1.size(); i++) {
							listCheckBoxes1.get(i).click();
						}
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
						GSP.Print_Docs().click();
						Set<String> windows1 = driver.getWindowHandles();
						String parentWindowHandler1 = driver.getWindowHandle();
						for (String handle : windows1) {
							driver.switchTo().window(handle);
							if (!(handle.equals(parentWindowHandler1))) {
								System.out.println(driver.getTitle());
								// driver.close();
							}
						}
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();
					}
				}
			}
//Change_PolicyPeriod_Endor ends here			
		}

		if (Extension_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Extension of Policy Period");

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
			System.out.println("Policy Start Date: " + ActualPolicyStartDate);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
			String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
			System.out.println("Policy End Date: " + ActualPolicyEndDate);

			// Enter Endorsement To Date
			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
			LocalDateTime newDate = date.plusDays(15);
			String newDateString = newDate.format(formatter1);
			GSP.effective_To_Date().sendKeys(newDateString);
			System.out.println("Endorsement Effective to Date: " + newDateString);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Get Customer name
			webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
			String customer_Name = EIP.customer_Name().getText();
			String customer = customer_Name.replace(" - ", "-");
			System.out.println("Customer name is: " + customer);

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Get Premium Amount
			webDriverWait(ExpectedConditions.visibilityOf(EIP.deleted_SMI_Premium()));
			String SMI_Premium_Amount = EIP.deleted_SMI_Premium().getText();

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			Thread.sleep(20000);

			// get Policy Fess
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
			String policy_Fees = EIP.get_Policy_Fees().getText();
			System.out.println("Policy Fees Amount is: " + policy_Fees);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(2000);
			// Click special Treaty Option
			// webDriverWait(ExpectedConditions.elementToBeClickable(EIP.special_Tty_No_Option()));
			// EIP.special_Tty_No_Option().click();

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(3000);

			// Get Gross_Premium
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
			String gross_premium1 = EIP.get_Gross_Premium().getText();
			System.out.println("Gross Premium Amount is: " + gross_premium1);

			try {
				// Get Net Premium
				webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
				String NetPremium = ra.Net_Premium().getText();
				System.out.println("Net to Customer: " + NetPremium);
			} catch (Exception e) {
			}

//		Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

			try {
				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
				Endor_policy = EIP.get_Policy().getText();
				System.out.println("Policy Number is: " + Endor_policy);

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

				Set<String> windows1 = driver.getWindowHandles();
				String parentWindowHandler1 = driver.getWindowHandle();
				for (String handle : windows1) {
					driver.switchTo().window(handle);

					if (!(handle.equals(parentWindowHandler1))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}
				driver.switchTo().window(parentWindowHandler1);

				rb.delay(5000);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();
			} catch (Exception e) {
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
//		Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//		Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();
					rb.delay(1000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
					ra.RI_Confirmation_Menu().click();

//		Search Quote Number 
					webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
					ra.search_Enq_Field().sendKeys(Endor_policy);

					rb.delay(3000);
//		Click Proportional RI Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
					ra.proportional_RI_Button().click();
					rb.delay(3000);

//		Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
					ra.remarks_Field().sendKeys(Remarks);

//		Click Confirm RI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
					ra.confirm_RI_Button().click();

//		Click Yes button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
					ra.yes_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//		Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
					GSP.endorsement_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					try {
						if (Mode_Of_Pay.equals("Cash")) {
//					Click Cash Analysis
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
							ra.cash_Analysis_Button().click();

//					Click Add New Button
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
							ra.add_New_Button().click();

//					Click Check Box
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
							ra.cash_Code_Checkbox().click();

//					Select cash Type
							webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
							selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

							if (Cash_Type.equals("CHEQUE")) {
//						Enter Cheque No
								webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
								ra.cheque_Ref_Num().sendKeys(Cheque_No);

//						Select Bank Name
								webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
								selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//						Enter Account Number
								webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
								ra.account_Number_Field().sendKeys(Account_Number);

//						Enter Cheque Date
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
								ra.cheque_End_Date().click();

								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								LocalDateTime now = LocalDateTime.now();
								ra.cheque_End_Date().sendKeys(dtf.format(now));
//						
//						Enter Amount
								webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
								ra.amount_Field().sendKeys(con_pol.Net_To_Customer);
							} else if (Cash_Type.equals("CASH")) {

//						Enter Amount
								webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
								ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

							}

//					Save the details
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
							ra.save_Cash_Analysis().click();

						} else if (Mode_Of_Pay.equals("Credit")) {
							webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
							rb.delay(3000);
							selectByIndex(ra.Insured_Billing_Account(), 1);
						}
					} catch (Exception e2) {
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
					javaScribtClick(EIP.approve_Non_Financial_Endorsement());

					try {

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
							LP.username_Field().sendKeys(PLP.Loginuser);

							webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
							LP.password_Field().sendKeys(PLP.Loginuser_password);

							webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
							LP.login_Button().click();

							rb.delay(2000);
							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
							GSP.global_Search_Button().click();

							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
							selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

							// Search Policy via Quotation.
							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
							GSP.Policy_Number_Field().sendKeys(Endor_policy);

							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
							GSP.policy_Search_Button().click();

						}

					} catch (Exception e2) {
						// TODO: handle exception
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
					ra.Summary_Policy_PrintDocs().click();

					rb.delay(3000);
					List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
					System.out.println("Print document List: " + listCheckBoxes1.size());
					for (int i = 0; i < listCheckBoxes1.size(); i++) {
						listCheckBoxes1.get(i).click();
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
					GSP.Print_Docs().click();
					Set<String> windows1 = driver.getWindowHandles();
					String parentWindowHandler1 = driver.getWindowHandle();
					for (String handle : windows1) {
						driver.switchTo().window(handle);
						if (!(handle.equals(parentWindowHandler1))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
				}
			}
//extension ends here
		}

		if (Reduction_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Reduction of Policy Period");

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
			System.out.println("Policy Start Date: " + ActualPolicyStartDate);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
			String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
			System.out.println("Policy End Date: " + ActualPolicyEndDate);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
			GSP.effective_To_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
			LocalDateTime newDate = date.plusDays(-30);
			String newDateString = newDate.format(formatter1);
			GSP.effective_To_Date().sendKeys(newDateString);
			System.out.println("Endorsement Effective to Date: " + newDateString);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Get Premium Amount
			webDriverWait(ExpectedConditions.visibilityOf(EIP.deleted_SMI_Premium()));
			String SMI_Premium_Amount = EIP.deleted_SMI_Premium().getText();

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			Thread.sleep(20000);

			// get Policy Fess
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
			String policy_Fees = EIP.get_Policy_Fees().getText();
			System.out.println("Policy Fees Amount is: " + policy_Fees);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(2000);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(3000);

			// Get Gross_Premium
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
			String gross_premium1 = EIP.get_Gross_Premium().getText();
			System.out.println("Gross Premium Amount is: " + gross_premium1);

			try {
				// Get Net Premium
				webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
				String NetPremium = ra.Net_to_Customer().getText();
				System.out.println("Net to Customer: " + NetPremium);
			} catch (Exception e) {
			}

//			Select Mode of Pay
			webDriverWait(ExpectedConditions.visibilityOf(ra.mode_of_Pay_Dropdown()));
			Select modelist = new Select(ra.mode_of_Pay_Dropdown());
			List<WebElement> ModeOfPay = modelist.getOptions();
			List<WebElement> Options = new ArrayList<>();
			for (WebElement options : ModeOfPay) {
				if (!options.getText().toLowerCase().contains("select")) {
					Options.add(options);
				}
			}
			if (!Options.isEmpty()) {
				Random ModeofPay = new Random();
				int randomPayMode = ModeofPay.nextInt(Options.size());
				modelist.selectByIndex(ModeOfPay.indexOf(Options.get(randomPayMode)));
				Mode_Of_Pay = Options.get(randomPayMode).getText();
				System.out.println("Mode of Pay: " + Mode_Of_Pay);
			}

			if (Mode_Of_Pay.equals("Cash") || Mode_Of_Pay.equals("Cash sale combined")) {
//				Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
				javaScribtClick(ra.cash_Analysis_Button());

//				Click Add New Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
				ra.add_New_Button().click();

//				Click Check Box
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
				ra.cash_Code_Checkbox().click();

//				Select cash Type
				webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
				selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

				if (Cash_Type.equals("CHEQUE")) {
//					Enter Cheque No
					webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
					ra.cheque_Ref_Num().sendKeys(Cheque_No);

//					Select Bank Name
					webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
					selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//					Enter Account Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
					ra.account_Number_Field().sendKeys(Account_Number);

//					Enter Cheque Date
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
					ra.cheque_End_Date().click();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime now = LocalDateTime.now();
					ra.cheque_End_Date().sendKeys(dtf.format(now));

//					Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

				} else if (Cash_Type.equals("CASH")) {

//					Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

				}
//				Save the details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
				ra.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit") || Mode_Of_Pay.equals("Debit")) {

				webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
				rb.delay(3000);
				selectByIndex(ra.Insured_Billing_Account(), 1);

			} else if (Mode_Of_Pay.equals("SEPA")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_AC_Number()));
				ra.SEPA_AC_Number().clear();
				ra.SEPA_AC_Number().sendKeys("10112407330018");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_Swift_Code()));
				ra.SEPA_Swift_Code().clear();
				ra.SEPA_Swift_Code().sendKeys("APSBMTMT");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_IBAN()));
				ra.SEPA_IBAN().clear();
				ra.SEPA_IBAN().sendKeys("MT02APSB77046002407312407330018");

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BankList()));
				selectByIndex(ra.SEPA_BankList(), 2);

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BIC_Code()));
				ra.SEPA_BIC_Code().clear();
				ra.SEPA_BIC_Code().sendKeys("HJGFTUYT675785465");
			}

//		Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

			try {
				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
				Endor_policy = EIP.get_Policy().getText();
				System.out.println("Policy Number is: " + Endor_policy);

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

				Set<String> windows1 = driver.getWindowHandles();
				String parentWindowHandler1 = driver.getWindowHandle();
				for (String handle : windows1) {
					driver.switchTo().window(handle);

					if (!(handle.equals(parentWindowHandler1))) {
						System.out.println(driver.getTitle());
						// driver.close();
					}
				}
				driver.switchTo().window(parentWindowHandler1);

				rb.delay(5000);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();
			} catch (Exception e) {
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
//		Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//		Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();
					rb.delay(1000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
					ra.RI_Confirmation_Menu().click();

//		Search Quote Number 
					webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
					ra.search_Enq_Field().sendKeys(Endor_policy);

					rb.delay(3000);
//		Click Proportional RI Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
					ra.proportional_RI_Button().click();
					rb.delay(3000);

//		Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
					ra.remarks_Field().sendKeys(Remarks);

//		Click Confirm RI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
					ra.confirm_RI_Button().click();

//		Click Yes button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
					ra.yes_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//		Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
					GSP.endorsement_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					try {
						if (Mode_Of_Pay.equals("Cash")) {
//					Click Cash Analysis
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
							ra.cash_Analysis_Button().click();

//					Click Add New Button
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
							ra.add_New_Button().click();

//					Click Check Box
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
							ra.cash_Code_Checkbox().click();

//					Select cash Type
							webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
							selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

							if (Cash_Type.equals("CHEQUE")) {
//						Enter Cheque No
								webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
								ra.cheque_Ref_Num().sendKeys(Cheque_No);

//						Select Bank Name
								webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
								selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//						Enter Account Number
								webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
								ra.account_Number_Field().sendKeys(Account_Number);

//						Enter Cheque Date
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
								ra.cheque_End_Date().click();

								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								LocalDateTime now = LocalDateTime.now();
								ra.cheque_End_Date().sendKeys(dtf.format(now));
//						
//						Enter Amount
								webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
								ra.amount_Field().sendKeys(con_pol.Net_To_Customer);
							} else if (Cash_Type.equals("CASH")) {

//						Enter Amount
								webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
								ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

							}

//					Save the details
							webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
							ra.save_Cash_Analysis().click();

						} else if (Mode_Of_Pay.equals("Credit")) {
							webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
							rb.delay(3000);
							selectByIndex(ra.Insured_Billing_Account(), 1);
						}
					} catch (Exception e2) {
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
					javaScribtClick(EIP.approve_Non_Financial_Endorsement());

					try {

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
							LP.username_Field().sendKeys(PLP.Loginuser);

							webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
							LP.password_Field().sendKeys(PLP.Loginuser_password);

							webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
							LP.login_Button().click();

							rb.delay(2000);
							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
							GSP.global_Search_Button().click();

							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
							selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

							// Search Policy via Quotation.
							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
							GSP.Policy_Number_Field().sendKeys(Endor_policy);

							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
							GSP.policy_Search_Button().click();

						}

					} catch (Exception e2) {

					}

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
					ra.Summary_Policy_PrintDocs().click();

					rb.delay(3000);
					List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
					System.out.println("Print document List: " + listCheckBoxes1.size());
					for (int i = 0; i < listCheckBoxes1.size(); i++) {
						listCheckBoxes1.get(i).click();
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
					GSP.Print_Docs().click();
					Set<String> windows1 = driver.getWindowHandles();
					String parentWindowHandler1 = driver.getWindowHandle();
					for (String handle : windows1) {
						driver.switchTo().window(handle);
						if (!(handle.equals(parentWindowHandler1))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
				}
			}
//Reduction ends here					
		}

		if (FAC_Endors.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			if (PLP.Login_User_Name.equals("Juan Siracusa")) {

//			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
//			GSP.global_Search_Button().click();
//
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
//			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
//			GSP.global_Search_Button().click();
//
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
//			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);
//
//			// Enter Policy Number
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
//			GSP.Policy_Number_Field().sendKeys(Policy_Number);
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
//			GSP.policy_Search_Button().click();
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
//			// Policy Number Verification
//			String policy_Number = GSP.Policy_Number().getText();
//			System.out.println("Policy Number is: " + policy_Number);
//
//			if (policy_Number.contains(Policy_Number)) {
//				Assert.assertEquals(policy_Number, Policy_Number);
//				System.out.println("Policy Number Verification is Pass");
//			} else {
//				Assert.fail();
//				System.out.println("Policy Number Verification Failed");
//			}

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

////		Get Product
//			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
//			scrollDownJavaSc(GSP.get_Product());
//			String Product_Type = GSP.get_Product().getText();
//			System.out.println("Product Type is: " + Product_Type);

// 		Select Endorsement Type
				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "FAC and Treaty Adjustment");

//		Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

//		enter remarks
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

//    	click proceed
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(apin.Policy_Document_Dropdown()));
				selectByVisibleText(apin.Policy_Document_Dropdown(), Doc_type);

				rb.delay(7000);
				// upload doc in policy level

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.upload_File()));
				apin.upload_File().click();
				StringSelection ss11 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss11, null);
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

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
				ri.Prop_FAC().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
				ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
				ri.Save_Add_Participant().click();

				webDriverWait(ExpectedConditions.visibilityOf(ri.FAC_Participant_Name()));
				ri.FAC_Participant_Name().sendKeys(get_DB_Data(FAC_Participant_Query, FAC_ID));
				webDriverWait(ExpectedConditions.elementToBeClickable(ri.Select_FAC_Participant_Name()));
				ri.Select_FAC_Participant_Name().click();
				String Fac_Participant = ri.FAC_Participant_Name().getText();
				System.out.println("FAC Participant Name = " + Fac_Participant);

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

				try {
					webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
					Endor_policy = EIP.get_Policy().getText();
					System.out.println("Policy Number is: " + Endor_policy);

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

					Set<String> windows1 = driver.getWindowHandles();
					String parentWindowHandler1 = driver.getWindowHandle();
					for (String handle : windows1) {
						driver.switchTo().window(handle);

						if (!(handle.equals(parentWindowHandler1))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler1);

					rb.delay(5000);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
				} catch (Exception e) {
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
//			Click Menu Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
						ra.menu_Button().click();

//			Click RI Confirmation Log
						scrollDownJavaSc(ra.Reinsurance_Menu());
						ra.Reinsurance_Menu().click();
						rb.delay(1000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
						ra.RI_Confirmation_Menu().click();

//			Search Quote Number 
						webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
						ra.search_Enq_Field().sendKeys(Endor_policy);

						rb.delay(3000);
//			Click Proportional RI Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
						ra.proportional_RI_Button().click();
						rb.delay(3000);

//			Enter Remarks
						webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
						ra.remarks_Field().sendKeys(Remarks);

//			Click Confirm RI Button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
						ra.confirm_RI_Button().click();

//			Click Yes button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
						ra.yes_Button().click();

						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
						ra.user_Profile().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
						ra.logout_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
						javaScribtClick(ra.global_Search_Button());
//			Enter Quote Number
						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
						GSP.endorsement_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						try {
							if (Mode_Of_Pay.equals("Cash")) {
//						Click Cash Analysis
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
								ra.cash_Analysis_Button().click();

//						Click Add New Button
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
								ra.add_New_Button().click();

//						Click Check Box
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
								ra.cash_Code_Checkbox().click();

//						Select cash Type
								webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
								selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

								if (Cash_Type.equals("CHEQUE")) {
//							Enter Cheque No
									webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
									ra.cheque_Ref_Num().sendKeys(Cheque_No);

//							Select Bank Name
									webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
									selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//							Enter Account Number
									webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
									ra.account_Number_Field().sendKeys(Account_Number);

//							Enter Cheque Date
									webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
									ra.cheque_End_Date().click();

									DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
									LocalDateTime now = LocalDateTime.now();
									ra.cheque_End_Date().sendKeys(dtf.format(now));
//							
//							Enter Amount
									webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
									ra.amount_Field().sendKeys(con_pol.Net_To_Customer);
								} else if (Cash_Type.equals("CASH")) {

//							Enter Amount
									webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
									ra.amount_Field().sendKeys(con_pol.Net_To_Customer);

								}

//						Save the details
								webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
								ra.save_Cash_Analysis().click();

							} else if (Mode_Of_Pay.equals("Credit")) {
								webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
								rb.delay(3000);
								selectByIndex(ra.Insured_Billing_Account(), 1);
							}
						} catch (Exception e2) {
						}

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
						javaScribtClick(EIP.approve_Non_Financial_Endorsement());

						try {

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
								LP.username_Field().sendKeys(PLP.Loginuser);

								webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
								LP.password_Field().sendKeys(PLP.Loginuser_password);

								webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
								LP.login_Button().click();

								rb.delay(2000);
								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
								GSP.global_Search_Button().click();

								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
								selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

								// Search Policy via Quotation.
								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
								GSP.Policy_Number_Field().sendKeys(Endor_policy);

								webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
								GSP.policy_Search_Button().click();

							}

						} catch (Exception e2) {
						}

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
						ra.Summary_Policy_PrintDocs().click();

						rb.delay(3000);
						List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
						System.out.println("Print document List: " + listCheckBoxes1.size());
						for (int i = 0; i < listCheckBoxes1.size(); i++) {
							listCheckBoxes1.get(i).click();
						}
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
						GSP.Print_Docs().click();
						Set<String> windows1 = driver.getWindowHandles();
						String parentWindowHandler1 = driver.getWindowHandle();
						for (String handle : windows1) {
							driver.switchTo().window(handle);
							if (!(handle.equals(parentWindowHandler1))) {
								System.out.println(driver.getTitle());
								// driver.close();
							}
						}
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();
					}
				}

				rb.delay(5000);

				if (GSP.FAC_Not_Closed().isDisplayed()) {

					if (PLP.Login_User_Name.equals("Juan Siracusa")) {

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
						ra.RI_FAC_PolicyNo().sendKeys(Endor_policy, Keys.TAB);
						Thread.sleep(2000);

						// select last option of endorsement in RI allocation.
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_Trans_SrNo_Text()));
						Select select = new Select(ra.RI_FAC_Trans_SrNo_Text());
						List<WebElement> options1 = select.getOptions();
						int size1 = options1.size() - 1;
						select.selectByIndex(size1);

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
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_policy);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

				}
			} else {
				System.out.println("Unable to process the" + "FAC and Treaty Adjustment"
						+ "Endorsement in the login userprofile id");

			}
//FAC endorse ends here					

		}

		if (Discount_Loadings_Endors.equals("Yes")) {

			// Discounts and Loading ends here
		}

		if (Policy_Cancellation_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Policy Cancellation");

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Get Deleted Premium
			webDriverWait(ExpectedConditions.visibilityOf(EIP.deleted_SMI_Premium()));
			scrollDownJavaSc(EIP.deleted_SMI_Premium());
			Thread.sleep(4000);
			String SMI_Premium = EIP.deleted_SMI_Premium().getText();
			System.out.println("Deleted SMI Premium is: " + SMI_Premium);
			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(20000);

			// get Policy Fess
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
			scrollDownJavaSc(EIP.get_Policy_Fees());
			String policy_Fees = EIP.get_Policy_Fees().getText();
			System.out.println("Policy Fees Amount is: " + policy_Fees);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(3000);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			scrollDownJavaSc(EIP.proceed_Button());
			javaScribtClick(EIP.proceed_Button());
			Thread.sleep(5000);

			// Get Gross_Premium
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
			String gross_premium1 = EIP.get_Gross_Premium().getText();
			System.out.println("Gross Premium Amount is: " + gross_premium1);

			try {
				// Get Net Premium
				webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
				String NetPremium = ra.Net_Premium().getText();
				System.out.println("Net to Customer: " + NetPremium);
			} catch (Exception e) {
			}

			// Select Mode of Pay
			webDriverWait(ExpectedConditions.visibilityOf(EIP.mode_of_Pay_Dropdown()));
			selectByVisibleText(EIP.mode_of_Pay_Dropdown(), Mode_Of_Pay);

			if (Mode_Of_Pay.equals("Debit")) {
				webDriverWait(ExpectedConditions.visibilityOf(EIP.Insured_Billing_Account()));
				try {
					selectByIndex(EIP.Insured_Billing_Account(), 1);
				} catch (Exception e) {

					selectByVisibleText(EIP.Insured_Billing_Account(), Insured_Billing_Account);
				}

			} else if (Mode_Of_Pay.equals("SEPA")) {
				webDriverWait(ExpectedConditions.visibilityOf(EIP.BIC_Code()));
				EIP.BIC_Code().sendKeys(Account_Number);
			}

			Thread.sleep(20000);

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());
			// object.approve_Endorsement_Button().click();

			try {

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
//				Click Menu Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
						ra.menu_Button().click();

//				Click RI Confirmation Log
						scrollDownJavaSc(ra.Reinsurance_Menu());
						ra.Reinsurance_Menu().click();
						rb.delay(1000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
						ra.RI_Confirmation_Menu().click();

//				Search Quote Number 
						webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
						ra.search_Enq_Field().sendKeys(Endor_policy);

						rb.delay(3000);
//				Click Proportional RI Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
						ra.proportional_RI_Button().click();
						rb.delay(3000);

//				Enter Remarks
						webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
						ra.remarks_Field().sendKeys(Remarks);

//				Click Confirm RI Button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
						ra.confirm_RI_Button().click();

//				Click Yes button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
						ra.yes_Button().click();

						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
						ra.user_Profile().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
						ra.logout_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
						javaScribtClick(ra.global_Search_Button());
//				Enter Quote Number
						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();

						// click the endorsement button

					}
				} catch (Exception e) {

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
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						rb.delay(2000);
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_policy);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_Button()));
						GSP.Quote_Search_Button().click();

					}
				}

			} catch (Exception e) {

			}
//Cancellation Ends here

		}

		if (Policy_Reinstatement_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Policy Re-Instatement");

//		Get Effective From Date
			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String Effective_From_Date = getAtrributeValue(GSP.policy_Start_Date(), "value");
			System.out.println("Effective From Date is: " + Effective_From_Date);

//		Get Effective To Date
			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
			String Effective_To_Date = getAtrributeValue(GSP.effective_To_Date(), "value");
			System.out.println("Effective From Date is: " + Effective_To_Date);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

//		Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

//		Get Deleted Premium
			webDriverWait(ExpectedConditions.visibilityOf(EIP.deleted_SMI_Premium()));
			scrollDownJavaSc(EIP.deleted_SMI_Premium());
			Thread.sleep(3000);
			String SMI_Premium = EIP.deleted_SMI_Premium().getText();
			System.out.println("Deleted SMI Premium is: " + SMI_Premium);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(15000);

//		get Policy Fess 
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
			String policy_Fees = EIP.get_Policy_Fees().getText();
			System.out.println("Policy Fees Amount is: " + policy_Fees);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();
			Thread.sleep(2000);

//		Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			// object.proceed_Button().click();
			scrollDownJavaSc(EIP.proceed_Button());
			javaScribtClick(EIP.proceed_Button());
			Thread.sleep(3000);

//		Select Mode of Pay
			webDriverWait(ExpectedConditions.visibilityOf(EIP.mode_of_Pay_Dropdown()));
			selectByVisibleText(EIP.mode_of_Pay_Dropdown(), Mode_Of_Pay);

			if (Mode_Of_Pay.equals("Cash")) {
//			Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.cash_Analysis_Button()));
				EIP.cash_Analysis_Button().click();

//			Click Add New Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.add_New_Button()));
				EIP.add_New_Button().click();

//			Click Check Box
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.cash_Code_Checkbox()));
				EIP.cash_Code_Checkbox().click();

//			Select cash Type
				webDriverWait(ExpectedConditions.visibilityOf(EIP.cash_Type_Dropdown()));
				selectByVisibleText(EIP.cash_Type_Dropdown(), Cash_Type);

				if (Cash_Type.equals("CHEQUE")) {
//				Enter Cheque No
					webDriverWait(ExpectedConditions.visibilityOf(EIP.cheque_Ref_Num()));
					EIP.cheque_Ref_Num().sendKeys(Cheque_No);

//				Select Bank Name
					webDriverWait(ExpectedConditions.visibilityOf(EIP.Bank_Name_Dropdown()));
					selectByVisibleText(EIP.Bank_Name_Dropdown(), Bank_Name);

//				Enter Account Number
					webDriverWait(ExpectedConditions.visibilityOf(EIP.account_Number_Field()));
					EIP.account_Number_Field().sendKeys(Account_Number, Keys.TAB);

//				Enter Cheque Date
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.cheque_End_Date()));

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime now = LocalDateTime.now();
					EIP.cheque_End_Date().sendKeys(dtf.format(now));
//				
//				Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(EIP.amount_Field()));
					EIP.amount_Field().sendKeys(con_pol.Net_To_Customer);
				} else if (Cash_Type.equals("CASH")) {

//				Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(EIP.amount_Field()));
					EIP.amount_Field().sendKeys(con_pol.Net_To_Customer);

				}

//			SAve the details
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.save_Cash_Analysis()));
				EIP.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit")) {
				webDriverWait(ExpectedConditions.visibilityOf(EIP.Insured_Billing_Account()));
				try {

					selectByIndex(EIP.Insured_Billing_Account(), 1);
				} catch (Exception e) {

					selectByVisibleText(EIP.Insured_Billing_Account(), Insured_Billing_Account);
				}
			}
			Thread.sleep(20000);

//		Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());
			
// Re-Instatement ends here.
		}

	}
}
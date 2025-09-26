package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Approval_Workflow_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Condominium_Policy extends BaseClass {

	public static String Quote_Number;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static List<WebElement> MyAction;
	public static String Policy_Number;
	public static String RI_Password;
	public static String Net_To_Customer;

	@Test(dataProvider = "Condominium")

	public void tc001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Insured_Query, String Insured_ID, String Quotation_Validity_Days,
			String Co_Insurance_Share_Percentage, String Sum_Insured_Currency, String Premium_Currency,
			String Contact_Number, String Business_Occupation, String Territorial_Limits, String Introducer_Name,
			String Processor_Name, String Demands_Needs, String Risk_Description, String Occupancy_Type,
			String Description, String Risk_Catagory, String Location, String Inward_SI, String Inward_Premium,
			String Risk_Apartment, String Risk_Machinery, String Multiple_Risk, String Multiple_SMI,
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
			String Approve_Policy, String Policy_Endorsements, String Non_Financial_Endors, String Financial_Endors,
			String Change_Policy_Endors, String Extension_Policy_Endors, String Reduction_Policy_Endors,
			String FAC_Endors, String Discount_Loadings_Endors, String Policy_Cancellation_Endors,
			String Policy_Reinstatement_Endors, String PO_Box_Numer, String Address, String Edit_SI_Value,
			String Edit_SI_Rate, String Financial_Add_FAC, String Run_Flag)
			throws InterruptedException, AWTException, ClassNotFoundException, IOException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		PersonalUW_Login PLP = new PersonalUW_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();

		// Underwriting page

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.CI_Menu()));
		javaScribtClick(uwp.CI_Menu());

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		javaScribtClick(uwp.menu_Button());

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Personal_Underwriting_Button()));
		javaScribtClick(uwp.Personal_Underwriting_Button());

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Fire_Personal_Menu()));
		uwp.Fire_Personal_Menu().click();

		// Customer Info page
//				Enter Insured Name
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Insured_Code_Field()));
		cus.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_insured()));
		cus.select_insured().click();

//				Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(cus.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(cus.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

//				Enter Quotation Validity Days
//				webDriverWait(ExpectedConditions.visibilityOf(obj.quotation_Valid_Days()));
//				obj.quotation_Valid_Days().clear();
//				obj.quotation_Valid_Days().sendKeys(Quotation_Validity_Days);

//				Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(cus.Business_Source_Dropdown()));
		selectByVisibleText(cus.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source: " + Business_Source);

//				Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(cus.Types_of_Policy_Dropdown()));
		selectByVisibleText(cus.Types_of_Policy_Dropdown(), Types_of_Policy);

//				Enter Co-insurance share percentage
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {
			webDriverWait(ExpectedConditions.visibilityOf(cus.co_insurance_Share_Percentage()));
			cus.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
			System.out.println("Co-Insurance share percentage: " + Co_Insurance_Share_Percentage);
		}

//				Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(cus.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

//				Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Premium_Currency_Dropdown()));
		selectByVisibleText(cus.Premium_Currency_Dropdown(), Premium_Currency);

//		Enter Contact Number		
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Contact_Number_Field()));
		cus.Contact_Number_Field().click();
		cus.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cus.Contact_Number_Field().sendKeys(Keys.DELETE);
		cus.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number: " + Contact_Number);

// 		Enter Associate Name
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Condominium_Association_Name()));
		cus.Condominium_Association_Name().sendKeys("Association Name");

//		Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
		cus.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_Intoducer()));
		cus.select_Intoducer().click();
		System.out.println("Introducer Name: " + Introducer_Name);

//		Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
		cus.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_processor()));
		cus.select_processor().click();
		System.out.println("Processor Name: " + Processor_Name);

// 		Demands and Needs
		if (Demands_Needs.equals("Yes")) {
			cus.condominium_DN_1Y().click();
			cus.condominium_DN_2Y().click();
			cus.condominium_DN_3Y().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(cus.proceed_Button()));
			cus.proceed_Button().click();

			// navigateRefresh();

			rb.delay(2000);
			webDriverWait(ExpectedConditions.visibilityOf(cus.DN_AlertMSG()));
			String DN_AlertMsg = cus.DN_AlertMSG().getText();
			System.out.println("Demands and needs WF MSG: " + DN_AlertMsg);

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(cus.Cust_QuoteNo()));
			String Quote_No = cus.Cust_QuoteNo().getText();
			System.out.println("Quotation Number: " + Quote_No);

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW, q_pol_info WHERE TC_ref_id = "
					+ "(select QPI_TRANS_ID from q_pol_info where qpi_quot_no='" + Quote_Number
					+ "') and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
			App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
			WF_Description = get_DB_Data(username_Query, "WF_DESC");
			System.out.println(WF_Description);
			String DN_RefNo = get_DB_Data(username_Query, "TC_TRANS_ID");
			password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
					+ "') USER_PASSWORD FROM DUAL";
			App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(App_User);

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(App_Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.My_Action_Tab()));
			uwp.My_Action_Tab().click();

//			MyAction = WFA.Clm_MyAction_SubSection();
//			for (WebElement MyAction_Section : MyAction) {
//				String SubsectionText = MyAction_Section.getText().trim();
//				if (WF_Description.equals(SubsectionText)) {
//					javaScribtClick(MyAction_Section);
//					System.out.println("WF Section: " + WF_Description);
//					break;
//				}
//			}

			webDriverWait(ExpectedConditions.elementToBeClickable(AWF.Demands_Needs_ActionsTab()));
			AWF.Demands_Needs_ActionsTab().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactionstab_Search()));
			WFA.Clm_Myactionstab_Search().sendKeys(DN_RefNo);

			webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approver_Viewoption()));
			WFA.Clm_Approver_Viewoption().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Approval_Remarks()));
			uwp.Approval_Remarks().sendKeys("Approve");

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.WF_ApprovalButton()));
			uwp.WF_ApprovalButton().click();

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

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
			GSP.Quote_Number_Field().sendKeys(Quote_Number, Keys.ENTER);

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Edit()));
			GSP.Quote_Edit().click();

		} else {
			try {
				cus.condominium_DN_1N().click();
				cus.condominium_DN_2Y().click();
				cus.condominium_DN_3Y().click();
			} catch (Exception e) {
			}
		}

		scrollDownJavaSc(cus.proceed_Button());
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.proceed_Button()));
		cus.proceed_Button().click();

//Risk Page
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Description_Field()));
		ris.risk_Description_Field().sendKeys(Risk_Description);

//		Enter Location
		webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
		ris.Location_Field().sendKeys(Location);

		rb.delay(2000);
		// Click Longitude Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
		ris.find_Latitude().click();

		rb.delay(7000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
		javaScribtClick(ris.ok_Button());
		System.out.println("Location saved successfully");
		String Locality = ris.Location_Field().getAttribute("value");
		System.out.println("Location text: " + Locality);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Floors()));
		ris.Condominium_Floors().sendKeys("5");

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Apartment_Number()));
		ris.Condominium_Apartment_Number().sendKeys("10");

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Garages_Number()));
		;
		ris.Condominium_Garages_Number().sendKeys("2");

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Lifts_Number()));
		ris.Condominium_Lifts_Number().sendKeys("1");

		try {
			List<WebElement> riskInsured = ris.Condominium_Risk_insured();
			for (WebElement check : riskInsured) {
				if (check.isSelected()) {
					check.click();
				}
			}
		} catch (Exception e) {
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();
		
//		Get Risk Success Msg
		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Success_Msg()));
		String risk_Success_Msg = ris.Risk_Success_Msg().getText();
		System.out.println("Risk Success Msg is: " + risk_Success_Msg);

//		Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		Quote_Number = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + Quote_Number);

//		Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);

//		get Insured name 
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		if (Risk_Apartment.equals("Yes")) {

			// Add Apartment Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Risk_Apartment()));
			ris.Condominium_Risk_Apartment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Checkbox()));
			ris.Apartment_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_OwnerName()));
			ris.Apartment_OwnerName().sendKeys("James");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Reference_Number()));
			ris.Apartment_Reference_Number().sendKeys("4532543");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_CivilID()));
			ris.Apartment_CivilID().sendKeys("3453253245");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Type()));
			selectByVisibleText(ris.Apartment_Type(), "Apartment");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Pledge()));
			selectByVisibleText(ris.Apartment_Pledge(), "Yes");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_BankName()));
			ris.Apartment_BankName().sendKeys("BNF Bank");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_BranchName()));
			ris.Apartment_BranchName().sendKeys("Malta");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Pledge_Date_From()));
			ris.Apartment_Pledge_Date_From().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Pledge_End_Date()));
			ris.Apartment_Pledge_End_Date().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_SumInsured()));
			ris.Apartment_SumInsured().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Save()));
			ris.Apartment_Save().click();

		}

		if (Risk_Machinery.equals("Yes")) {

			// Add Machinery Details.
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condominium_Risk_Machinery()));
			ris.Condominium_Risk_Machinery().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_Checkbox()));
			ris.Machinery_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_Description()));
			ris.Machinery_Description().sendKeys("machine lift");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_SerialNumber()));
			ris.Machinery_SerialNumber().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_MakeModel()));
			ris.Machinery_MakeModel().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_Year_Manufacture()));
			ris.Machinery_Year_Manufacture().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_SumInsured()));
			ris.Machinery_SumInsured().sendKeys("");

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Apartment_Save()));
			ris.Apartment_Save().click();

		}
		
//Add SMI 
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
		javaScribtClick(ris.Add_SMI_Button());

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condo_Buldings_CheckBox()));
		ris.Condo_Buldings_CheckBox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condo_Buldings_SI()));
		ris.Condo_Buldings_SI().click();
		doubleClick(ris.Condo_Buldings_SI());
		ris.Condo_Buldings_SI().sendKeys(Sum_Insured_Amount);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condo_Com_Area_Checkbox()));
		ris.Condo_Com_Area_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Condo_Com_Area_SI()));
		ris.Condo_Com_Area_SI().click();
		doubleClick(ris.Condo_Com_Area_SI());
		ris.Condo_Com_Area_SI().sendKeys(Sum_Insured_Amount);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Passenger_Lift_checkbox()));
		ris.Passenger_Lift_checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Passenger_Lift_SI()));
		ris.Passenger_Lift_SI().click();
		doubleClick(ris.Passenger_Lift_SI());
		ris.Passenger_Lift_SI().sendKeys(Sum_Insured_Amount);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_BreaKDown_Checkbox()));
		ris.Machinery_BreaKDown_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Machinery_BreaKDown_SI()));
		ris.Machinery_BreaKDown_SI().click();
		doubleClick(ris.Machinery_BreaKDown_SI());
		ris.Machinery_BreaKDown_SI().sendKeys(Sum_Insured_Amount);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

// Risk Premium and Annual Premium
		rb.delay(5000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.Total_Risk_Annual_Premium()));
		String annual_Sum_Insured_Premium = ris.Total_Risk_Annual_Premium().getText();
		System.out.println("Total Risk Annual Premium is: " + annual_Sum_Insured_Premium);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Total_Premium()));
		String RiskPremium = ris.Risk_Total_Premium().getText();
		System.out.println("Total Risk Premium Value is: " + RiskPremium);

//			Get Premium Amount
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Premium_Field()));
		String SMIPremium = ris.SMI_Premium_Field().getText();
		System.out.println("Total SMI premium value is: " + SMIPremium);

		rb.delay(2000);
//			Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		String SMI_Annual_Premium = ris.SMI_Annual_Premium().getText();
		System.out.println("SMI Annual Premium Amount is: " + SMI_Annual_Premium);

		rb.delay(3000);

//			Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		javaScribtClick(ris.Proceed_Button());

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {

		}

		System.out.println("Proceed to Add Pol info page");

		// Add pol info page

		// Add policy Discounts and Loadings to the policy.
		try {
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			javaScribtClick(apin.Policy_Discounts_Loadings_Panel());
			try {
				webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
				String policy_Fees = apin.get_Policy_Fees().getText();
				System.out.println("Policy Fees is: " + policy_Fees);
			} catch (Exception e2) {
			}
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Discount);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discount_Checkbox()));
		apin.Policy_Discount_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discount_Rate()));
		apin.Policy_Discount_Rate().sendKeys(Policy_Discount_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		// Add Policy Loadings
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Loading);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Loading_Checkbox()));
		apin.Policy_Loading_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Loading_Rate()));
		apin.Policy_Loading_Rate().sendKeys(Policy_Loading_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		// Add Policy Deductibles
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Deductible);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Checkbox()));
		apin.Policy_Deductible_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Caltype()));
		selectByVisibleText(apin.Policy_Deductible_Caltype(), Policy_Deductible_Calctype);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Rate()));
		apin.Policy_Deductible_Rate().sendKeys(Policy_Deductible_RateValue, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		rb.delay(5000);

		// Introducer/processor commission
		String user_Profile_Name2 = apin.userNameField().getText();
		System.out.println("User Profile Name is: " + user_Profile_Name2);

		if (PLP.Login_User_Name.contains("Juan Siracusa")) {

			webDriverWait(ExpectedConditions.visibilityOf(apin.introducerEditBtn()));
			apin.introducerEditBtn().click();

			webDriverWait(ExpectedConditions.visibilityOf(apin.commAmtFC()));
			apin.commAmtFC().click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='10';", apin.commAmtFC());
			rb.delay(2000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
			apin.updateBtn().click();

			// success msg is mapped as same for upload documents in policy level
			webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
			String success_Msg = apin.DocumentUploadSuccess().getText();
			System.out.println("Introducer Updated Message: " + success_Msg);
			rb.delay(5000);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Intorducer_commAmtFC()));
			String Int_comm_Amount = apin.Intorducer_commAmtFC().getText();
			System.out.println("Introducer commission amount: " + Int_comm_Amount);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.processorEditButton()));
			apin.processorEditButton().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.commAmtFC()));
			apin.commAmtFC().click();
			js.executeScript("arguments[0].value='10';", apin.commAmtFC());
			rb.delay(2000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
			apin.updateBtn().click();

			webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
			String success_Msg2 = apin.DocumentUploadSuccess().getText();
			System.out.println("Processor Updated Message: " + success_Msg2);
			rb.delay(5000);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Processor_commAmtFC()));
			String Pro_comm_Amount = apin.Processor_commAmtFC().getText();
			System.out.println("Processor commission amount: " + Pro_comm_Amount);

		} else {
			System.out.println("Introducer-Processor update is not Applicable");
		}
		rb.delay(5000);

		// Coinsurance Section
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {

			rb.delay(3000);
			// Click Co Insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.co_Insursance_Menu()));
			apin.co_Insursance_Menu().click();

			rb.delay(3000);
			// Click Add Co insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
			apin.add_Co_Insurance_Button().click();

			// Get Total Sum Insured
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Sum_Insured()));
			String text = apin.get_Total_Sum_Insured().getText();
			double Total_Sum_Insured = string_To_double_Convert(text);

//						Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Premium_FC()));
			String Total_Premium_FC = apin.get_Total_Premium_FC().getText();
			double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
			System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

//						Get Our Share
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Share()));
			String text2 = apin.get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

//						get Our Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Premium()));
			String text3 = apin.get_Our_Premium().getText();
			String our_Premium = text3.replace(",", "");
			System.out.println("our Premium is: " + our_Premium);

			if (our_Premium.contains(Premium_Amount)) {
				Assert.assertEquals(our_Premium, Premium_Amount);
				System.out.println("Premium Amount Verification Passed");
			} else {
				Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}

			// Insurer Premium
			double text4 = string_To_double_Convert(text3);
			double insurer_Premium = Total_Premium_Amount - text4;
			String Remaining_Premium = String.format("%.2f", insurer_Premium);
			System.out.println("Insurer Premium Amount is: " + Remaining_Premium);

//						Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
			apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
			rb.delay(5000);
			apin.select_Coinsurance().click();
			String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
			System.out.println("Coinsurer Name: " + coinsurer);
			rb.delay(3000);

//						Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
			apin.coinsurance_Share_Percentage_Field().click();
			apin.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share, Keys.TAB);
			rb.delay(3000);

			if (Business_Source.equals("Direct with Elmo Follower")
					|| Business_Source.equals("Broker with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
				apin.Coins_LeaderYN().click();
			}

//						Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
			apin.Save_Coinsurance_Details().click();

//						Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
			scrollDownJavaSc(apin.co_Insurer_Share_Premium());
			String text5 = apin.co_Insurer_Share_Premium().getText();
			String Coinsurer_Premium_Amount = text5.replace(",", "");
			System.out.println("Co insurer Premium Amount is: " + Coinsurer_Premium_Amount);

//						Premium Amount Verification
			if (Coinsurer_Premium_Amount.contains(Remaining_Premium)) {
				Assert.assertEquals(Coinsurer_Premium_Amount, Remaining_Premium);
				System.out.println("Premium Amount Verification Passed");
			} else {
				// Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}
		}

		// Add Insured
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Additional_Insured_Menu()));
		apin.Additional_Insured_Menu().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
		apin.Add_Additional_Insured().click();

//					if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
//							|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {
		//
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//						selectByVisibleText(obj1.Split_YN(), Split_YN);
//						System.out.println("Split invoice is: " + Split_YN);
//						rb.delay(5000);
		//
//						webDriverWait(ExpectedConditions.visibilityOf(obj1.Yes_AddInsured_Name()));
//						obj1.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
//						rb.delay(2000);
//						obj1.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
//						obj1.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
////						webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
////						obj1.Select_Add_Insured_Name().click();
//						String AddInsured = getAtrributeValue(obj1.Yes_AddInsured_Name(), "value");
//						System.out.println("Add Insured Name :" + AddInsured);
		//
//						webDriverWait(ExpectedConditions.visibilityOf(obj1.Add_Ins_Billing_Account()));
//						rb.delay(3000);
//						selectByIndex(obj1.Add_Ins_Billing_Account(), 1);
//						String AddIns_BillAcct = getAtrributeValue(obj1.Add_Ins_Billing_Account(), "value");
//						System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);
		//
//					} else if ((Split_YN.equals("No")) && (Business_Source.equals("Direct") || Business_Source.equals("Broker")
//							|| Business_Source.equals("Salesman") || Business_Source.equals("Introducers")
//							|| Business_Source.equals("Branches") || Business_Source.equals("Staff")
//							|| Business_Source.equals("Direct with Elmo Leader")
//							|| Business_Source.equals("Broker with Elmo Leader")
//							|| Business_Source.equals("Broker with Elmo Follower")
//							|| Business_Source.equals("Direct with Elmo Follower")
//							|| Business_Source.equals("Salesman with Elmo Leader")
//							|| Business_Source.equals("Introducers with Elmo Leader")
//							|| Business_Source.equals("Branches with Elmo Leader")
//							|| Business_Source.equals("Staff with Elmo Leader")
//							|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")
//							|| Business_Source.equals("Tied Insurance Intermediary"))) {
		//
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//						selectByVisibleText(obj1.Split_YN(), Split_YN);
//						System.out.println("Split invoice is:" + Split_YN);
//						rb.delay(5000);
		//
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj1.No_AddInsured_Name()));
//						obj1.No_AddInsured_Name().sendKeys("John");
//						String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
//						System.out.println("Add Insured Name: " + AddInsname);
//					}

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
		selectByIndex(apin.Split_YN(), 1);
		String Splitvalue = first_Selected_Value(apin.Split_YN());
		// String Splitvalue = obj1.Split_YN().getAttribute("value");
		System.out.println("Split Invoice value: " + Splitvalue);

		if (Splitvalue.equals("Yes")) {

			webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
			apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
			rb.delay(2000);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
//						obj1.Select_Add_Insured_Name().click();
			String AddInsured = getAtrributeValue(apin.Yes_AddInsured_Name(), "value");
			System.out.println("Add Insured Name: " + AddInsured);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Billing_Account()));
			rb.delay(3000);
			selectByIndex(apin.Add_Ins_Billing_Account(), 1);
			String AddIns_BillAcct = getAtrributeValue(apin.Add_Ins_Billing_Account(), "value");
			System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);

		} else if (Splitvalue.equals("No")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.No_AddInsured_Name()));
			apin.No_AddInsured_Name().sendKeys("John");
			// String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
			System.out.println("Add Insured Name: " + "John");
		}

		webDriverWait(ExpectedConditions.visibilityOf(apin.Insured_Type()));
		selectByVisibleText(apin.Insured_Type(), Ins_Type);
		System.out.println("Add Insured Type: " + Ins_Type);

		webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Id_Types()));
		if (apin.Add_Ins_Id_Types() == null) {
			selectByVisibleText(apin.Add_Ins_Id_Types(), AddIns_IDType);
			System.out.println("AddIns ID Type: " + AddIns_IDType);
		} else {
			String AddInsID = getAtrributeValue(apin.Add_Ins_Id_Types(), "value");
			System.out.println("AddIns ID Type: " + AddInsID);
		}

		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Id_No()));
		if (apin.AddIns_Id_No() == null) {
			apin.AddIns_Id_No().sendKeys(AddIns_IdNo);
			System.out.println("AddIns ID No: " + AddIns_IdNo);
		} else {
			String AddInsIDNo = getAtrributeValue(apin.AddIns_Id_No(), "value");
			System.out.println("AddIns ID No: " + AddInsIDNo);
		}

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Ins_Mobile_No()));
		apin.Add_Ins_Mobile_No().click();
//					if (obj11.Add_Ins_Mobile_No() == null) {
		apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
//					}else{
		String AddIns_MobNum = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
		System.out.println("Add Ins Mobile No: " + AddIns_MobNum);
//					}

		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_PO_Box()));
		apin.AddIns_PO_Box().click();
		if (apin.AddIns_PO_Box() == null) {
			apin.AddIns_PO_Box().sendKeys(AddIns_POBox);
			System.out.println("AddIns PO Box: " + AddIns_POBox);
		} else {
			String PO_Box = getAtrributeValue(apin.AddIns_PO_Box(), "value");
			System.out.println("AddIns PO Box: " + PO_Box);
		}

		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Email_Id()));
		apin.AddIns_Email_Id().click();
		String EmailID = getAtrributeValue(apin.AddIns_Email_Id(), "value");
		// if (EmailID == null) {
		apin.AddIns_Email_Id().sendKeys(AddIns_EmailID);
		System.out.println("AddIns Email Id: " + AddIns_EmailID);
		// }else {

		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Relation()));
		selectByVisibleText(apin.AddIns_Relation(), Add_Ins_Relation);
		System.out.println("AddIns Relation: " + Add_Ins_Relation);

		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Address()));
		apin.AddIns_Address().click();
		// if (obj11.AddIns_Address() == null) {
		apin.AddIns_Address().sendKeys(Add_Ins_Address);
		// System.out.println("AddIns Address: " + Add_Ins_Address);
		// }else {
		String AddIns_Add = getAtrributeValue(apin.AddIns_Address(), "value");
		System.out.println("AddIns Address: " + AddIns_Add);
		// }

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.get_AddIns_Save()));
		apin.get_AddIns_Save().click();
		System.out.println("Add Insured Details saved successfully");

		// survey details
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Survey_Details_Menu()));
		apin.Survey_Details_Menu().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Surveyor_Button()));
		apin.Add_Surveyor_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Survey_Date()));
		apin.Survey_Date().click();
		keyPress(KeyEvent.VK_CONTROL);
		keyPress(KeyEvent.VK_A);
		keyRelease(KeyEvent.VK_CONTROL);
		keyRelease(KeyEvent.VK_A);

		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Add one day to the current date to get the next date
		LocalDate nextDate = currentDate.plusDays(8);

		// Format the next date to the desired format
		String formattedNextDate = nextDate.format(formatter);
		apin.Survey_Date().sendKeys(formattedNextDate, Keys.TAB);

		webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));
		Select dropdown = new Select(apin.Surveyor_Name());
		List<WebElement> SurveyorName = dropdown.getOptions();
		List<WebElement> validOptions = new ArrayList<>();
		for (WebElement option : SurveyorName) {
			if (!option.getText().toLowerCase().contains("select")) {
				validOptions.add(option);
			}
		}
		if (!validOptions.isEmpty()) {
			Random Surveyorname = new Random();
			int randomIndexOfSurveyorName = Surveyorname.nextInt(validOptions.size());
			dropdown.selectByIndex(SurveyorName.indexOf(validOptions.get(randomIndexOfSurveyorName)));
			String Surveyor_Name = validOptions.get(randomIndexOfSurveyorName).getText();
			System.out.println("Surveyor Name: " + Surveyor_Name);
		}

		webDriverWait(ExpectedConditions.visibilityOf(apin.get_Surveyor_Remarks()));
		apin.get_Surveyor_Remarks().sendKeys("testing");

		webDriverWait(ExpectedConditions.visibilityOf(apin.get_Surveyor_Risk()));
		apin.get_Surveyor_Risk().sendKeys(Surveyor_Risk);

		// Survey Upload docs
		webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Doctype()));
		selectByVisibleText(apin.Surveyor_Doctype(), Survey_Doc_type);

		// upload Surveyor doc in policy level
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Surveyor_Upload()));
		apin.Surveyor_Upload().click();
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(5000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(10000);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_surveyor()));
		apin.Save_surveyor().click();

		// Terms and Conditions
		rb.delay(5000);

		try {

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Terms_Conditions()));
			apin.Add_Terms_Conditions().click();
			System.out.println("Add Terms and condition is Enabled");

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Panel()));
			apin.Terms_Conditions_Panel().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Terms_Conditions()));
			apin.Add_Terms_Conditions().click();

		}

		try {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox()));
			javaScribtClick(apin.Terms_Conditions_Checkbox());

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
			apin.Save_Terms_Conditions().click();

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Cancel_Terms_Conditions()));
			apin.Cancel_Terms_Conditions().click();
		}

		rb.delay(3000);

//General Questionnaire

		List<WebElement> yes = apin.GQ_Yes_Option();
		ExecutorService executor_Service = Executors.newFixedThreadPool(yes.size());
		for (WebElement radio : yes) {
			executor_Service.submit(() -> {
				radio.click();
			});
		}

		List<WebElement> textes = apin.GQ_Text();
		ExecutorService executor_Service1 = Executors.newFixedThreadPool(textes.size());
		for (WebElement text : textes) {
			executor_Service.submit(() -> {
				text.sendKeys("Testing");
			});
		}

		// Policy Documents Upload
		// scrollDownJavaSc(obj.Policy_Document_Dropdown());
		webDriverWait(ExpectedConditions.visibilityOf(apin.Policy_Document_Dropdown()));
		selectByVisibleText(apin.Policy_Document_Dropdown(), Doc_type);

		rb.delay(7000);

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

		// Click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();

		rb.delay(10000);

		// RI Ceding page.
		if (Special_Tty.equals("Y")) {

			// Click Special Treaty Yes Option
			webDriverWait(ExpectedConditions.elementToBeClickable(ri.special_Tty_Yes_Option()));
			ri.special_Tty_Yes_Option().click();

			webDriverWait(ExpectedConditions.visibilityOf(ri.get_Spcl_Tty_Reason()));
			ri.get_Spcl_Tty_Reason().sendKeys("Special Treaty Reason");

			// Click Save Button
			webDriverWait(ExpectedConditions.elementToBeClickable(ri.get_Spcl_Tty_Save()));
			ri.get_Spcl_Tty_Save().click();

			// Data Saved Success MSG
			webDriverWait(ExpectedConditions.visibilityOf(ri.data_saved_success()));
			String success_Msg = ri.data_saved_success().getText();
			System.out.println("Spcl : " + success_Msg);
		} else if (Special_Tty.equals("N")) {
		}

//					Select RI Ceding Basis 
		webDriverWait(ExpectedConditions.visibilityOf(ri.select_RI_ceding_Basis()));
		selectByVisibleText(ri.select_RI_ceding_Basis(), RI_Ceding_Basic);

//					include FAC in policy

		if (PLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			javaScribtClick(ri.Prop_FAC());

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Placement_CheckBox()));
			ri.FAC_Placement_CheckBox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
			ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
			ri.Save_Add_Participant().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Name()));
			ri.FAC_Participant_Name().sendKeys(get_DB_Data(FAC_Participant_Query, FAC_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Select_FAC_Participant_Name()));
			ri.Select_FAC_Participant_Name().click();
			String Fac_Participant = ri.FAC_Participant_Name().getText();
			System.out.println("FAC Participant Name = " + Fac_Participant);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Share_Percentage()));
			ri.FAC_Participant_Share_Percentage().sendKeys(FAC_Participant_Share_Percentage_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Save_Close()));
			ri.FAC_Participant_Save_Close().click();

		} else if (PLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("No")) {
		}

//		Click Proceed
		rb.delay(3000);
		webDriverWait(ExpectedConditions.visibilityOf(ri.proceed_Button()));
		scrollDownJavaSc(ri.proceed_Button());
		ri.proceed_Button().click();

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
			Quote_Number = ra.get_Quotation_Number().getText();
			System.out.println("Finalized Quotation: " + Quote_Number);

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
			ra.Quote_Number_Field().sendKeys(Quote_Number);

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
					ra.search_Enq_Field().sendKeys(Quote_Number);

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
					webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
					ra.Quote_Number_Field().sendKeys(Quote_Number);

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
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Quote No");

					// Search Policy via Quotation.
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Quote_Number);

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

//Approve Policy Close poin
		}

	}
}
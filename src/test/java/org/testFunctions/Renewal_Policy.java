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
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Global_Search_Page;
import org.pages.Renewal_Policy_Page;
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Renewal_Policy extends BaseClass {

	public static String annual_Sum_Insured_Premium;
	public static String OurSI;
	public static String policy_Type;
	public static String Risk_TODate;

	@Test(dataProvider = "Renewal_Policy")

	public void tc_001(String SNo, String Search_Policy, String Renewal_Policy, String Types_of_Policy,
			String Business_Source, String Insured_Query, String Insured_ID, String Quotation_Validity_Days,
			String Co_Insurance_Share_Percentage, String Sum_Insured_Currency, String Premium_Currency,
			String Contact_Number, String Business_Occupation, String Territorial_Limits, String Product_Type,
			String Indeminity_Field, String Indeminity_Period_Unit_Dropdown, String Material_Policy_Damage_Number,
			String Introducer_Name, String Processor_Name, String Risk_Description, String Occupancy_Type,
			String Description, String Risk_Catagory, String Location, String Cyber_Risk, String Limit_Per_AOA,
			String Select_Reference, String Inward_SI, String Inward_Premium, String Multiple_Risk, String Multiple_SMI,
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
			String FAC_Participant_Share_Percentage_Value, String Mode_Of_Pay, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String FAC_Participant, String RI_Status, String Approve_Policy, String Run_Flag)
			throws AWTException, ClassNotFoundException, IOException, InterruptedException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Renewal_Policy_Page renew = new Renewal_Policy_Page();
		Issue_Policy_Customer_Info_Page cust = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();

//underWriting page	
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Renewals_Menu()));
		uwp.Renewals_Menu().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Policy_Due_For_Renewal()));
		uwp.Policy_Due_For_Renewal().click();

//		webDriverWait(ExpectedConditions.elementToBeClickable(UWpage.Policy_Due_For_RenewalBatch()));
//		UWpage.Policy_Due_For_RenewalBatch().click();

//		webDriverWait(ExpectedConditions.elementToBeClickable(UWpage.menu_Button()));
//		UWpage.menu_Button().click();

//Renewal Log page
		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Select_Search_Policy()));
		selectByVisibleText(renew.Select_Search_Policy(), Search_Policy);

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Search_Enter_Policy()));
		renew.Search_Enter_Policy().sendKeys(Renewal_Policy);
		System.out.println("Renewal Policy: "+Renewal_Policy);

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Renewal_Search()));
		renew.Renewal_Search().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Renewal_Policy_Checkbox()));
		renew.Renewal_Policy_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Generate_Renewal_Quotation()));
		renew.Generate_Renewal_Quotation().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.Renewal_Quotation_No()));
		String Renewal_Quote_No = renew.Renewal_Quotation_No().getText();
		System.out.println("Renewal Quotation No: " + Renewal_Quote_No);

//Customer Info page
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Insured_Code_Field()));
		cust.Insured_Code_Field().clear();
		cust.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_insured()));
		cust.select_insured().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Business_Source_Dropdown()));
		selectByVisibleText(cust.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source = " + Business_Source);

		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Ren_Policy_Type()));
		String policytype = cust.Ren_Policy_Type().getText();
		System.out.println("Type of policy: " + policytype);

//		Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(cust.Contact_Number_Field()));
		cust.Contact_Number_Field().click();
		cust.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cust.Contact_Number_Field().sendKeys(Keys.DELETE);

		cust.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number = " + Contact_Number);

//		Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.introducer_Name_Field()));
		cust.introducer_Name_Field().clear();
		cust.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_Intoducer()));
		cust.select_Intoducer().click();
		System.out.println("Introducer Name = " + Introducer_Name);

//		Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.Processor_Name_Field()));
		cust.Processor_Name_Field().clear();
		cust.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_processor()));
		cust.select_processor().click();
		System.out.println("Processor Name = " + Processor_Name);

//		Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
		cust.proceed_Button().click();
		System.out.println("proceed to Risk info page");

//Risk info page

		// Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		String quote_Number = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + quote_Number);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);

		// get Insured name
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		// Edit the SMI
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Edit_SMI()));
		ris.Edit_SMI().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));
		ris.EDIT_SI_Value().sendKeys(Keys.CONTROL + "a");
		ris.EDIT_SI_Value().sendKeys(Keys.DELETE);
		ris.EDIT_SI_Value().sendKeys("100000");

		webDriverWait(ExpectedConditions.elementToBeClickable(renew.EDIT_SI_Rate()));
		ris.EDIT_SI_Rate().clear();
		ris.EDIT_SI_Rate().sendKeys("1");

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
		ris.Save_EDIT_SI().click();

		// Add Risk
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_Button()));
		scrollUpJavaSc(ris.Add_Risk_Button());
		ris.Add_Risk_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
		ris.risk_Description_Field().sendKeys(Risk_Description);

		if (Types_of_Policy.equals("Erection All Risks") || Types_of_Policy.equals("Contractors All Risks Insurance")) {
			webDriverWait(ExpectedConditions.visibilityOf(ris.select_reference()));
			selectByVisibleText(ris.select_reference(), Select_Reference);
			System.out.println("Select reference: " + Select_Reference);

			webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
			ris.Contractor_Name().sendKeys("Site Engineer");
		}

		// Select description
		webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
		selectByVisibleText(ris.description_Dropdown(), Description);

		// Risk Effective fm date
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Effec_FMDT()));
		String Risk_FMDate = ris.Risk_Effec_FMDT().getAttribute("value");
		System.out.println("Risk effective from date: " + Risk_FMDate);

		// Risk Effective to date
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Effec_TODT()));
		Risk_TODate = ris.Risk_Effec_TODT().getAttribute("value");
		System.out.println("Risk effective to date: " + Risk_TODate);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
		ris.Location_Field().sendKeys(Location);

		Thread.sleep(2000);
		// Click Longitude Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
		ris.find_Latitude().click();

		Thread.sleep(7000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
		javaScribtClick(ris.ok_Button());

		policy_Type = policytype;

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

		if (Types_of_Policy.equals("Contractors All Risks Insurance")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Maintenance_Period_FD()));
			ris.Maintenance_Period_FD().click();
			keyPress(KeyEvent.VK_CONTROL);
			keyPress(KeyEvent.VK_A);
			keyRelease(KeyEvent.VK_CONTROL);
			keyRelease(KeyEvent.VK_A);

			keyPress(KeyEvent.VK_BACK_SPACE);
			keyRelease(KeyEvent.VK_BACK_SPACE);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// Get Risk eff to date
			LocalDate xDate;
			try {
				xDate = LocalDate.parse(Risk_TODate, formatter);
			} catch (DateTimeParseException e) {
				e.printStackTrace();
				return;
			}
			LocalDate nextdate = xDate.plusDays(1);

			String Main_FMDate = nextdate.format(formatter);
			ris.Maintenance_Period_FD().sendKeys(Main_FMDate, Keys.TAB);
		}

		// Inward formation section
		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

			// 100% and Our SI & Premium value
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
			ris.Risk_Inward_SI().sendKeys(Inward_SI, Keys.TAB);
			System.out.println("Inward SI Value: " + Inward_SI);

			rb.delay(3000);
			// webDriverWait(ExpectedConditions.visibilityOf(obj.Risk_Inward_OurSI()));
			OurSI = getAtrributeValue(ris.Risk_Inward_OurSI(), "value");
			System.out.println("Inward Our SI value: " + OurSI);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
			ris.Risk_Inward_Premium().sendKeys(Inward_Premium, Keys.TAB);
			System.out.println("Inward Premium Value: " + Inward_Premium);

			rb.delay(3000);
			// webDriverWait(ExpectedConditions.visibilityOf(obj.Risk_Inward_OurPremium()));
			String OurPremium = getAtrributeValue(ris.Risk_Inward_OurPremium(), "value");
			System.out.println("Inward our Premium Value: " + OurPremium);
		}

		// Click save Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_save_Button()));
		ris.Add_Risk_save_Button().click();

		// Add SMI

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
		ris.Add_SMI_Button().click();

		// Add SMI details
		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

			// Enter SMI check box Details conditions to be handled
			rb.delay(2000);
			if (Types_of_Policy.equals("Business Interruption Insurance")) {

			} else {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
				ris.Inward_OurSMI_Checkbox().click();
			}
			// Enter SI value
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
			ris.Inward_OurSMI_SI().click();
			doubleClick(ris.Inward_OurSMI_SI());
			ris.Inward_OurSMI_SI().sendKeys(OurSI);
			System.out.println("Inward Our SI value: " + OurSI);

			// Enter rate value.
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
			ris.Inward_OurSMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

			if (Types_of_Policy.equals("Erection All Risks")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.professional_Fees_Checkbox()));
				ris.professional_Fees_Checkbox().click();
			}

			// Save Sum Insured Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

		} else {

			// Enter SMI check box Details conditions to be handled
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
			ris.Sum_Insured_checkbox().click();

			// Enter SI value
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
			ris.sum_Insured_Field().click();
			doubleClick(ris.sum_Insured_Field());
			ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
			System.out.println("SI value: " + Sum_Insured_Amount);

			// Enter rate value.
			webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
			ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
			if (Types_of_Policy.equals("Erection All Risks")) {
				webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
				Thread.sleep(3000);
				ris.professional_Fees_Rate_per().click();
				ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
			} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
				ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
				ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
			}
		}
		Thread.sleep(1000);

		// Save Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

		// Add Discounts and Loadings to the SMI
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Icon()));
		ris.SMI_DL_Icon().click();

		// Add SMI Discounts
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.oi_add_SMI_DL()));
		ris.oi_add_SMI_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Dropdown()));
		selectByVisibleText(ris.SMI_DL_Dropdown(), SMI_Discount);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Checkbox()));
		ris.SMI_Discount_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Rate()));
		ris.SMI_Discount_Rate().sendKeys(Discount_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Save()));
		ris.SMI_Discount_Loadings_Save().click();

		// Add SMI Loadings
		Thread.sleep(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.oi_add_SMI_DL()));
		ris.oi_add_SMI_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Dropdown()));
		selectByVisibleText(ris.SMI_DL_Dropdown(), SMI_Loadings);

		Thread.sleep(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Loading_Checkbox()));
		ris.SMI_Loading_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Loading_Rate()));
		ris.SMI_Loading_Rate().sendKeys(Loading_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Save()));
		ris.SMI_Discount_Loadings_Save().click();
		rb.delay(3000);

		// Close SMI Loadings and discounts details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Close()));
		ris.SMI_Discount_Loadings_Close().click();

		// Risk Premium and Annual Premium
		rb.delay(2000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.Total_Risk_Annual_Premium()));
		annual_Sum_Insured_Premium = ris.Total_Risk_Annual_Premium().getText();
		System.out.println("Total Risk Annual Premium is: " + annual_Sum_Insured_Premium);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Total_Premium()));
		String RiskPremium = ris.Risk_Total_Premium().getText();
		System.out.println("Total Risk Premium Value is: " + RiskPremium);

//			Get Premium Amount
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Premium_Field()));
		String SMIPremium = getAtrributeValue(ris.SMI_Premium_Field(), "value");
		System.out.println("Total SMI premium value is: " + SMIPremium);

		Thread.sleep(2000);
//			Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		String SMI_Annual_Premium = ris.SMI_Annual_Premium().getText();
		System.out.println("SMI Annual Premium Amount is: " + SMI_Annual_Premium);

		rb.delay(3000);

//			Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		System.out.println("Proceed to Add Pol info page");

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {

		}

//Add pol info page

		// Add policy Discounts and Loadings to the policy
		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			apin.Policy_Discounts_Loadings_Panel().click();
		} catch (Exception e) {
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);
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

		if (user_Profile_Name2.contains("Juan Siracusa")) {

			webDriverWait(ExpectedConditions.visibilityOf(apin.introducerEditBtn()));
			apin.introducerEditBtn().click();

			webDriverWait(ExpectedConditions.visibilityOf(apin.commAmtFC()));
			apin.commAmtFC().click();

			apin.commAmtFC().sendKeys(Keys.CONTROL + "a");
			apin.commAmtFC().sendKeys(Keys.DELETE);
			apin.commAmtFC().sendKeys("10");
			rb.delay(2000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
			apin.updateBtn().click();

			// success msg is mapped as same for upload documents in policy level
			webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
			String success_Msg = apin.DocumentUploadSuccess().getText();
			System.out.println("Introducer Updated Message: " + success_Msg);
			rb.delay(5000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.processorEditButton()));
			apin.processorEditButton().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.commAmtFC()));
			apin.commAmtFC().click();

			apin.commAmtFC().sendKeys(Keys.CONTROL + "a");
			apin.commAmtFC().sendKeys(Keys.DELETE);
			apin.commAmtFC().sendKeys("10");
			rb.delay(2000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
			apin.updateBtn().click();

			webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
			String success_Msg2 = apin.DocumentUploadSuccess().getText();
			System.out.println("Processor Updated Message: " + success_Msg2);
			rb.delay(5000);

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

//				Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Premium_FC()));
			String Total_Premium_FC = apin.get_Total_Premium_FC().getText();
			double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
			System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

//				Get Our Share
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Share()));
			String text2 = apin.get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

//				get Our Premium
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

//				Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
			apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
			apin.select_Coinsurance().click();
			String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
			System.out.println("Coinsurer Name: " + coinsurer);
			rb.delay(3000);

//				Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
			apin.coinsurance_Share_Percentage_Field().click();
			apin.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share, Keys.TAB);
			rb.delay(3000);

			if (Business_Source.equals("Direct with Elmo Follower")
					|| Business_Source.equals("Broker with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
				apin.Coins_LeaderYN().click();
			}

//				Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
			apin.Save_Coinsurance_Details().click();

//				Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
			scrollDownJavaSc(apin.co_Insurer_Share_Premium());
			String text5 = apin.co_Insurer_Share_Premium().getText();
			String Coinsurer_Premium_Amount = text5.replace(",", "");
			System.out.println("Co insurer Premium Amount is: " + Coinsurer_Premium_Amount);

//				Premium Amount Verification
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

		if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
			selectByVisibleText(apin.Split_YN(), Split_YN);
			System.out.println("Split invoice is: " + Split_YN);
			Thread.sleep(5000);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
			apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
			Thread.sleep(2000);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
//				webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
//				obj1.Select_Add_Insured_Name().click();
			String AddInsured = getAtrributeValue(apin.Yes_AddInsured_Name(), "value");
			System.out.println("Add Insured Name :" + AddInsured);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Billing_Account()));
			rb.delay(3000);
			selectByIndex(apin.Add_Ins_Billing_Account(), 1);
			String AddIns_BillAcct = getAtrributeValue(apin.Add_Ins_Billing_Account(), "value");
			System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);

		} else if ((Split_YN.equals("No")) && (Business_Source.equals("Direct") || Business_Source.equals("Broker")
				|| Business_Source.equals("Salesman") || Business_Source.equals("Introducers")
				|| Business_Source.equals("Branches") || Business_Source.equals("Staff")
				|| Business_Source.equals("Direct with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary"))) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
			selectByVisibleText(apin.Split_YN(), Split_YN);
			System.out.println("Split invoice is:" + Split_YN);
			Thread.sleep(5000);

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.No_AddInsured_Name()));
			apin.No_AddInsured_Name().sendKeys("John");
			String AddInsname = getAtrributeValue(apin.No_AddInsured_Name(), "value");
			System.out.println("Add Insured Name: " + AddInsname);
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

		Thread.sleep(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Ins_Mobile_No()));
		apin.Add_Ins_Mobile_No().click();
//			if (obj11.Add_Ins_Mobile_No() == null) {
		apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
		// System.out.println("Add Ins Mobile No: " + AddIns_MobileNo);
//			}else{
		String AddIns_MobNum = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
		System.out.println("Add Ins Mobile No: " + AddIns_MobNum);
//			}

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

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox()));
		apin.Terms_Conditions_Checkbox().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
		apin.Save_Terms_Conditions().click();

		rb.delay(3000);

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

		Thread.sleep(10000);

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

//			Select RI Ceding Basis 
		webDriverWait(ExpectedConditions.visibilityOf(ri.select_RI_ceding_Basis()));
		selectByVisibleText(ri.select_RI_ceding_Basis(), RI_Ceding_Basic);

//			include FAC in policy

		if (user_Profile_Name2.contains("Juan Siracusa") && Add_FAC.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			ri.Prop_FAC().click();

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

		} else if (user_Profile_Name2.contains("Juan Siracusa") && Add_FAC.equals("No")) {
		}

//			Click Proceed
		Thread.sleep(3000);
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

		// Get Net Premium
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
		String NetPremium = ra.Net_Premium().getText();
		System.out.println("Net to Customer: " + NetPremium);

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

		// click continue button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

		// get Quotation Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
		String Quotation_Number = ra.get_Quotation_Number().getText();

		// get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
		String customer_name = ra.customer_Name().getText();
		System.out.println("Customer Name: " + customer_name);

		// Select Mode of Pay
		webDriverWait(ExpectedConditions.visibilityOf(ra.mode_of_Pay_Dropdown()));
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
		// Summary Quotation print Docs

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_PrintDocs()));
		ra.Summary_Quotation_PrintDocs().click();
		rb.delay(3000);

//			webDriverWait(ExpectedConditions.elementToBeClickable(obj3.Summary_Quotation_Checkbox()));
//			obj3.Summary_Quotation_Checkbox().click();

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

		webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Policy_Close()));
		ra.Summary_Quotation_Policy_Close().click();

		Global_Search_Page objref = new Global_Search_Page();
		rb.delay(3000);
		// Click Approve as Policy Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
		// obj3.approve_Policy_Button().click();
		javaScribtClick(ra.approve_Policy_Button());

		// Click Continue Button
		// webDriverWait(ExpectedConditions.elementToBeClickable(obj3.continue_Button()));
		// obj3.continue_Button().click();

		try {
			if (ra.RI_Approval_Msg().isDisplayed()) {

//					Log out
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
				ra.user_Profile().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
				ra.logout_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 2, 1));

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 2, 2));

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				Thread.sleep(2000);
				String userProfile_Name = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + userProfile_Name);

				if (userProfile_Name.contains(ReadExcelData.readExcel("Login", 2, 3))) {
					Assert.assertEquals(userProfile_Name, ReadExcelData.readExcel("Login", 2, 3));
					System.out.println(
							"Employee named " + userProfile_Name + " signed in into the application successfully");
				} else {
					Assert.fail();
					System.out.println("Test Case Failed");
				}

//					Click Menu Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
				ra.menu_Button().click();

//	 				Click RI Confirmation Log
				scrollDownJavaSc(ra.Reinsurance_Menu());
				ra.Reinsurance_Menu().click();
				Thread.sleep(1000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
				ra.RI_Confirmation_Menu().click();

//					Search Quote Number 
				webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
				ra.search_Enq_Field().sendKeys(quote_Number);
				Thread.sleep(1000);
//					Click Proportional RI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
				ra.proportional_RI_Button().click();
				Thread.sleep(3000);
//					Click Prop FAC Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.prop_FAC_Button()));
				ra.prop_FAC_Button().click();
//					Enter FAC Percentage
				webDriverWait(ExpectedConditions.visibilityOf(ra.FAC_Percentage_Field()));
				ra.FAC_Percentage_Field().sendKeys(Co_Insurance_Share_Percentage);

//					SAve FAC Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_and_Close_Button()));
				ra.save_and_Close_Button().click();
				Thread.sleep(1000);

//					click Add participant Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_Participant_Button()));
				ra.add_Participant_Button().click();

//					Add FAC Participant
				webDriverWait(ExpectedConditions.visibilityOf(ra.FAC_Participant_Field()));
				ra.FAC_Participant_Field().sendKeys(FAC_Participant);
				rb.delay(2000);
				keyPress(KeyEvent.VK_ENTER);
				keyRelease(KeyEvent.VK_ENTER);

//					Add Share Percentage
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.FAC_Share_Percentage()));
				ra.FAC_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage, Keys.TAB);
				Thread.sleep(2000);

//					Save FAC
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_FAC_Button()));
				scrollDownJavaSc(ra.save_FAC_Button());
				// obj.save_FAC_Button().click();
				javaScribtClick(ra.save_FAC_Button());

//					Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
				ra.remarks_Field().sendKeys(Remarks);

//					Click Confirm RI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
				ra.confirm_RI_Button().click();

//					Click Yes button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
				ra.yes_Button().click();

				Thread.sleep(2000);
//					Log out
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
				ra.user_Profile().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.signout_Button()));
				ra.signout_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 1, 1));

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 1, 2));

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				Thread.sleep(2000);
				String userProfileName = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + userProfileName);

				if (userProfileName.contains(ReadExcelData.readExcel("Login", 1, 3))) {
					Assert.assertEquals(userProfileName, ReadExcelData.readExcel("Login", 1, 3));
					System.out.println(
							"Employee named " + userProfileName + " signed in into the application successfully");
				} else {
					Assert.fail();
					System.out.println("Test Case Failed");
				}
//					Click Global Search Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
				javaScribtClick(ra.global_Search_Button());
//					Enter Quote Number
				webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
				ra.Quote_Number_Field().sendKeys(quote_Number);

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.quote_Search_Button()));
				ra.quote_Search_Button().click();

//					Get Policy Status
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Status()));
				String policy_Status = ra.get_Policy_Status().getText();
				System.out.println("Policy Status is: " + policy_Status);

				if (policy_Status.contains("RI Confirmed")) {
					Assert.assertEquals(policy_Status, "RI Confirmed");
					System.out.println("RI Confimed Successfully");
				} else {
					Assert.fail();
					System.out.println("RI is not Confirmed");
				}

//					Approve as Policy
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
				ra.approve_Policy_Button().click();
				Thread.sleep(2000);
//					get Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));

				String policy_Number = ra.get_Policy_Number().getText();
				System.out.println("Policy Number is: " + policy_Number);

//					Get Customer Name
				webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
				String Customer_Name = ra.customer_Name().getText();
				System.out.println("Customer Name is: " + Customer_Name);

//					Log out
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
				// obj.user_Profile().click();
				javaScribtClick(ra.user_Profile());

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
				ra.logout_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 2, 1));

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 2, 2));

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

//					Click Menu Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
				ra.menu_Button().click();

				// Click RI Confirmation Log
				scrollDownJavaSc(ra.Reinsurance_Menu());
				ra.Reinsurance_Menu().click();
				Thread.sleep(1000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
				ra.RI_Confirmation_Menu().click();

//					select RI Status
				selectByVisibleText(ra.RI_Status_Dropdown(), RI_Status);

//					click Search Policy Notes'
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Search_Policy_Notes_Button()));
				ra.Search_Policy_Notes_Button().click();
				Thread.sleep(1000);

//					Search Quote Number 
				webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
				ra.search_Enq_Field().sendKeys(policy_Number);
				Thread.sleep(1000);
//					Click Proportional RI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
				ra.proportional_RI_Button().click();

//					Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
				scrollDownJavaSc(ra.remarks_Field());
				ra.remarks_Field().sendKeys(Remarks);
				Thread.sleep(2000);
//					Approve FAC Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Approve_FAC_Button()));
				ra.Approve_FAC_Button().click();
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
				ra.yes_Button().click();

//					Get Success Msg
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Error_Msg()));
				String FAC_Msg = ra.get_Error_Msg().getText();
				System.out.println("FAC Msg is: " + FAC_Msg);

				if (FAC_Msg.contains("Approved Successfully")) {
					System.out.println("FAC Approved");
				} else {
					Assert.fail();
					System.out.println("FAC is Not Approved");
				}
			}

		} catch (Exception e) {
			System.out.println("RI Not Required");
//				get Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
			String policy_Number = ra.get_Policy_Number().getText();
			System.out.println("Policy Number is: " + policy_Number);

//				Get Customer Name
			webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
			String Customer_Name = ra.customer_Name().getText();
			System.out.println("Customer Name is: " + Customer_Name);

			// Summary policy Print.

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
			ra.Summary_Policy_PrintDocs().click();
			rb.delay(3000);

			List<WebElement> listCheckBoxes = ra.Summary_Quotation_Checkbox();
			System.out.println("Print document List: " + listCheckBoxes.size());

			for (int i = 0; i < listCheckBoxes.size(); i++) {

				listCheckBoxes.get(i).click();
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Print()));
			ra.Summary_Quotation_Print().click();

			Set<String> windows = driver.getWindowHandles();
			String parentWindowHandler = driver.getWindowHandle();
			for (String handle : window) {
				driver.switchTo().window(handle);

				if (!(handle.equals(parentWindowHandler))) {
					System.out.println(driver.getTitle());
					// driver.close();
				}

			}
			driver.switchTo().window(parentWindowHandler);

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Policy_Close()));
			ra.Summary_Quotation_Policy_Close().click();

//				Click Global Search Button
			webDriverWait(ExpectedConditions.elementToBeClickable(objref.global_Search_Button()));
			objref.global_Search_Button().click();

//				Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(objref.Policy_Number_Field()));
			objref.Policy_Number_Field().sendKeys(policy_Number);

//				Click Policy Search Button
			webDriverWait(ExpectedConditions.elementToBeClickable(objref.policy_Search_Button()));
			objref.policy_Search_Button().click();
//				get Policy Type 
			webDriverWait(ExpectedConditions.visibilityOf(objref.Policy_Type()));
			String policy_Type1 = objref.Policy_Type().getText();

//				Policy Type Verification
			if (policy_Type1.contains(Types_of_Policy)) {
				Assert.assertEquals(policy_Type1, Types_of_Policy);
				System.out.println("Policy Type Verification Passed");
			} else {
				Assert.fail();
				System.out.println("Policy Type Verification Failed");
			}

//				Get Insured Name
			webDriverWait(ExpectedConditions.visibilityOf(objref.Insured_Name()));
			String insured_Customer_Name = objref.Insured_Name().getText();

//				Insured Name Verification
//				if (insured_Customer_Name.contains(Insured_Name)) {
//					Assert.assertEquals(insured_Customer_Name, Insured_Name);
//					System.out.println("Insured Customer Name Verification Passed");
//				} else {
//					// Assert.fail();
//					System.out.println("Insured Name Verification Failed");
//				}

//				Endorsement Button Enabled Verification
			webDriverWait(ExpectedConditions.visibilityOf(objref.endorsement_Button()));
			if (objref.endorsement_Button().isDisplayed()) {
				Assert.assertEquals(true, objref.endorsement_Button().isDisplayed());
			} else {
				Assert.fail();
				System.out.println("Endorsement Button is Displayed");
			}

//				Click View Accounts Button
			webDriverWait(ExpectedConditions.elementToBeClickable(objref.view_Accounting_Menu()));
			objref.view_Accounting_Menu().click();

//				Click Print Docs Button
			scrollDownJavaSc(objref.VW_Acc_Print_Docs());
			objref.VW_Acc_Print_Docs().click();
		}
	}
}
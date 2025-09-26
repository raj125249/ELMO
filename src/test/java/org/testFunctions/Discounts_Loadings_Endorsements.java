package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.testng.annotations.Test;

public class Discounts_Loadings_Endorsements extends BaseClass {

	@Test(dataProvider = "Discounts_Loadings_Endorsements")
	public void tc_001(String S_No, String Search_Policy, String Policy_Number, String Type_of_Policy,
			String Discount_Rate, String Loading_Rate, String Insured_Name, String Endorsement_Type, String Remarks,
			String SMI_Discount, String SMI_Loadings, String Policy_Loading, String Policy_Loading_Rate,
			String Policy_Deductible_RateValue, String Policy_Deductible_Calctype, String Policy_Deductible,
			String Policy_Discount, String Policy_Discount_Rate, String Mode_Of_Pay, String Net_To_Customer,
			String Account_Number, String Bank_Name, String Cheque_No, String Cash_Type, String Insured_Billing_Account, String Run_Flag)
			throws AWTException, InterruptedException {

		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		
//Global search page.
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(Policy_Number, Keys.ENTER);
		System.out.println("Policy Number: " + Policy_Number);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String Policytype = GSP.Policy_Type().getText();
		System.out.println("Type of Policy: " + Policytype);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
		String Insured = GSP.Insured_Name().getText();
		System.out.println("Insured Name: " + Insured);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

		// Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: " + Product_Type);

		// Select Endorsement Type
		webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
		selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
		GSP.proceed_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
		String endorsement_Type = EIP.get_Endorsement_Type().getText();
		System.out.println("Endorsement Type is: " + endorsement_Type);

//Endorsement Information.

		// enter remarks
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.remarks_Field()));
		EIP.remarks_Field().sendKeys(Remarks);

		// click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();

//Risk information validation.

		// Risk 1
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
		ris.risk_Check_Box().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.View_DL_option()));
		ris.View_DL_option().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Endo_DL_Edit()));
		ris.Endo_DL_Edit().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Edit_DLRate_Value()));
		ris.Edit_DLRate_Value().sendKeys("3", Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Edit_DL_Save()));
		ris.Edit_DL_Save().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Loading_Edit()));
		ris.Loading_Edit().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Edit_DLRate_Value()));
		ris.Edit_DLRate_Value().sendKeys("3", Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Edit_DL_Save()));
		ris.Edit_DL_Save().click();

		// Close SMI Loadings and discounts details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Close()));
		ris.SMI_Discount_Loadings_Close().click();

		// Risk 2
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditSMI_Risk()));
		ris.EditSMI_Risk().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.View_DL_option2()));
		ris.View_DL_option().click();

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

		// Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		System.out.println("Proceed to Add Pol info page");

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {

		}

//Add Pol info page
		try {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			apin.Policy_Discounts_Loadings_Panel().click();
			System.out.println("Add Terms and condition is Enabled");
		} catch (Exception e) {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			apin.Policy_Discounts_Loadings_Panel().click();
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			apin.Policy_Discounts_Loadings_Panel().click();
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

		// Click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();

//RI Ceding page
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();

//RA Slip page

		try {

			if (Mode_Of_Pay.equals("Cash")) {
//				Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
				ra.cash_Analysis_Button().click();

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
					// Enter Cheque No
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
					ra.amount_Field().sendKeys(Net_To_Customer);
				} else if (Cash_Type.equals("CASH")) {

//					Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(Net_To_Customer);

				}

//				Save the details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
				ra.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit")) {
				webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
				rb.delay(3000);
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}
		} catch (Exception e) {

		}

//		Approve Endorsement
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
		javaScribtClick(EIP.approve_Endorsement_Button());

	}
}
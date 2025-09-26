package org.testFunctions;

import java.awt.Robot;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.AWTException;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineWidth;
import org.pages.Endorsement_Information_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Global_Search_Page;
import org.testng.annotations.Test;

public class Change_in_Coinsurance extends BaseClass {

	@Test(dataProvider = "Change_in_Coinsurance")
	public void tc_001(String S_No, String Search_Policy, String Policy_Query, String Policy_ID,
			String Endorsement_Type, String Change_Percent_Value, String Remarks, String PO_Box_Number, String Address,
			String Coinsurer_Name_Query, String Coinsurer_ID, String Mode_Of_Pay, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account, String Run_Flag)
			throws AWTException, ClassNotFoundException, IOException {
		
		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();

//Policy search page

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(get_DB_Data(Policy_Query, Policy_ID), Keys.ENTER);

		// Get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		String PolicyNo = GSP.Policy_Number().getText();
		System.out.println("Policy Number: " + PolicyNo);

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

		// Enter Endorse share percentage value

//	business source
		webDriverWait(ExpectedConditions.visibilityOf(EIP.Business_source()));
		String B_Source = EIP.Business_source().getText();
		System.out.println("Business source: " + B_Source);

		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Endo_Share_percentage()));
		EIP.Endo_Share_percentage().clear();
		EIP.Endo_Share_percentage().sendKeys(Change_Percent_Value);
		// String sharevalue = getAtrributeValue(EIP.Endo_Share_percentage(),
		// "value");
		String sharevalue = EIP.Endo_Share_percentage().getAttribute("value");
		System.out.println("change in coinsurance value: " + sharevalue);

		// enter remarks
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.remarks_Field()));
		EIP.remarks_Field().sendKeys(Remarks);

		// click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();

//Risk Information page.

		if (B_Source.equals("Direct with Elmo Follower") || B_Source.equals("Broker with Elmo Follower")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Edit_option()));
			ris.Risk_Edit_option().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSI()));
			String updateOURSI = getAtrributeValue(ris.Inward_OurSI(), "value");
			System.out.println("Updated Inward Our SI value: " + updateOURSI);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OURPremium()));
			String updateOURPremium = getAtrributeValue(ris.Inward_OURPremium(), "value");
			System.out.println("Updated Inward Our SI value: " + updateOURPremium);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_Close()));
			ris.Inward_Close().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));
			ris.EDIT_SI_Value().sendKeys(updateOURSI, Keys.TAB, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_updated_Premium()));
			String UpdatedPremium = getAtrributeValue(ris.Inward_updated_Premium(), "value");
			System.out.println("Updated Inward Our SI value: " + UpdatedPremium);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
			ris.Save_EDIT_SI().click();
		}

		// click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();
		System.out.println("proceed to add pol info page");

//Add Pol info page.

		// BS validation
		if (B_Source.equals("Direct with Elmo Leader") || B_Source.equals("Broker with Elmo Leader")
				|| B_Source.equals("Direct with Elmo Follower") || B_Source.equals("Broker with Elmo Follower")) {

			if (sharevalue.contains("-")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
				apin.add_Co_Insurance_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
				apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
				apin.select_Coinsurance().click();
				String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
				System.out.println("Coinsurer Name: " + coinsurer);
				rb.delay(2000);

				// enter share
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
				apin.coinsurance_Share_Percentage_Field().clear();
				String share = sharevalue.replace("-", "");
				apin.coinsurance_Share_Percentage_Field().sendKeys(share, Keys.TAB);
				System.out.println("share percentage value: " + share);

				rb.delay(2000);

				if (B_Source.equals("Direct with Elmo Follower") || B_Source.equals("Broker with Elmo Follower")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
					apin.Coins_LeaderYN().click();
				}
			} else {

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.EditCoInsuranceEndInfo()));
				apin.EditCoInsuranceEndInfo().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
				apin.coinsurance_Share_Percentage_Field().clear();
				double share_Value = Double.parseDouble(sharevalue);
				double negativevalue = -share_Value;
				String sharevalue2 = Double.toString(negativevalue);
				apin.coinsurance_Share_Percentage_Field().sendKeys(sharevalue2, Keys.TAB);
				System.out.println("coinsurance share% value " + sharevalue2);
			}
		}
		// save details
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
		apin.Save_Coinsurance_Details().click();

		// click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();
		System.out.println("proceed to RI ceding page");

//RI Ceding page

		webDriverWait(ExpectedConditions.elementToBeClickable(ri.RICeding_Total_SI()));
		String RI_Total_SI = ri.RICeding_Total_SI().getAttribute("value");
		System.out.println("RI SI value: " + RI_Total_SI);

		webDriverWait(ExpectedConditions.elementToBeClickable(ri.RICeding_Total_SI()));
		String RI_Total_Premium = ri.RICeding_Total_SI().getAttribute("value");
		System.out.println("RI SI value: " + RI_Total_Premium);

		webDriverWait(ExpectedConditions.elementToBeClickable(ri.proceed_Button()));
		ri.proceed_Button().click();
		System.out.println("proceed to RA slip page");

//RA slip page

//		Get Net To Customer
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
		String Net_To_Customer = ra.Net_to_Customer().getText();
		System.out.println("Net to Customer: " + Net_To_Customer);

		try {

//		Select Mode of Pay
			webDriverWait(ExpectedConditions.visibilityOf(ra.mode_of_Pay_Dropdown()));
			selectByVisibleText(ra.mode_of_Pay_Dropdown(), Mode_Of_Pay);

			if (Mode_Of_Pay.equals("Cash")) {
//			Click Cash Analysis
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
				ra.cash_Analysis_Button().click();

//			Click Add New Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
				ra.add_New_Button().click();

//			Click Check Box
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
				ra.cash_Code_Checkbox().click();

//			Select cash Type
				webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
				selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

				if (Cash_Type.equals("CHEQUE")) {
//				Enter Cheque No
					webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
					ra.cheque_Ref_Num().sendKeys(Cheque_No);

//				Select Bank Name
					webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
					selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//				Enter Account Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
					ra.account_Number_Field().sendKeys(Account_Number);

//				Enter Cheque Date
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
					ra.cheque_End_Date().click();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDateTime now = LocalDateTime.now();
					ra.cheque_End_Date().sendKeys(dtf.format(now));
//				
//				Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(Net_To_Customer);
				} else if (Cash_Type.equals("CASH")) {

//				Enter Amount
					webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
					ra.amount_Field().sendKeys(Net_To_Customer);

				}

//			Save the details
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
				ra.save_Cash_Analysis().click();

			} else if (Mode_Of_Pay.equals("Credit")) {
				webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
				rb.delay(3000);
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}

		} catch (Exception e) {
		}

		// Approve Endorsement
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
		javaScribtClick(EIP.approve_Endorsement_Button());
		// obj5.approve_Endorsement_Button().click();

	}
}
package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.pages.Endorsement_Information_Page;
import org.pages.Login_Page;
import org.pages.Global_Search_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Policy_Re_Instatement_Endorsement extends BaseClass {

	@Test(dataProvider = "Policy_Re_Instatement")
	public void tc_001(String S_No, String Search_Policy, String Policy_Number, String Type_of_Policy,
			String Insured_Name, String Endorsement_Type, String Remarks, String Mode_Of_Pay,
			String Insured_Billing_Account, String Cash_Type, String Cheque_No, String Bank_Name, String Account_Number,
			String Run_Flag) throws AWTException, InterruptedException, IOException, ClassNotFoundException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Global_Search_Page GSP = new Global_Search_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 2, 1));
		String loginuser = LP.username_Field().getAttribute("value");
		System.out.println("Login user id: " + loginuser);

		String password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
				+ loginuser + "'";
		String Loginuser_password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Loginuser_password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		String user_Profile_Name = get_DB_Data(password_Query, "USER_NAME");
		System.out.println("User Profile Name is: " + user_Profile_Name);

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

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String policy_type = GSP.Policy_Type().getText();

		if (policy_type.contains(Type_of_Policy)) {

			Assert.assertEquals(policy_type, Type_of_Policy);
			System.out.println("Policy Type Verified");

		} else {

			Assert.fail();
			System.out.println("Policy Type Verification Failed");

		}

		// Insured Name Verification

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
		String insured_Name = GSP.Insured_Name().getText();

		if (insured_Name.contains(Insured_Name)) {

			Assert.assertEquals(insured_Name, Insured_Name);
			System.out.println("Insured Name Verification Passed");
		} else {

			Assert.fail();
			System.out.println("Insured Name Verification Failed");

		}

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

//		Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: " + Product_Type);

		// Select Endorsement Type
		webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
		selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

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
		String endorsement_Type = EIP.get_Endorsement_Type().getText();
		System.out.println("Endorsement Type is: " + endorsement_Type);

//		Endorsement Type Verification
		if (endorsement_Type.contains(Endorsement_Type)) {
			Assert.assertEquals(endorsement_Type, Endorsement_Type);
			System.out.println("Endorsement Type Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Endorsement Type Verification Failed");
		}

//		Get Policy Number 
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
		String policy_No = EIP.get_Policy_Number().getText();

//		Policy Number Verification
		if (policy_No.contains(Policy_Number)) {
			Assert.assertEquals(policy_No, Policy_Number);
			System.out.println("Policy Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Policy Number Verification Failed");
		}

//		Get Customer name
		webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
		String customer_Name = EIP.customer_Name().getText();
		String customer = customer_Name.replace(" - ", "-");
		System.out.println("Customer name is: " + customer);

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
		Thread.sleep(20000);
//		get Policy Fess 
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Fees()));
		String policy_Fees = EIP.get_Policy_Fees().getText();
		System.out.println("Policy Fees Amount is: " + policy_Fees);

		// Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();
		Thread.sleep(3000);

//		Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		scrollDownJavaSc(EIP.proceed_Button());
		EIP.proceed_Button().click();
		Thread.sleep(5000);
		// Get Gross_Premium
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
		String gross_premium = EIP.get_Gross_Premium().getText();
		System.out.println("Gross Premium Amount is: " + gross_premium);

		// Gross Premium Verification
		if (gross_premium.contains(SMI_Premium)) {
			Assert.assertEquals(gross_premium, SMI_Premium);
			System.out.println("Gross Premium AMount Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Gross Amount Verification Failed");
		}

		// Get Double Value
		String grossPremium = gross_premium.replace("-", "");
		double gross_premium_Double_Value = string_To_double_Convert(gross_premium);
		double grossDouble_Value = string_To_double_Convert(grossPremium);

		// Get Discount
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Discount()));
		String discount = EIP.get_Discount().getText();
		System.out.println(discount);
		double Discount_Amount = string_To_double_Convert(discount);

		// Get Loading
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Loading()));
		scrollDownJavaSc(EIP.get_Charge());
		String loading = EIP.get_Loading().getText();
		System.out.println(loading);
		double Loading_Amount = string_To_double_Convert(loading);

		// Get Fees
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Charge()));
		String Fees = EIP.get_Charge().getText();
		double Fees_Amount = string_To_double_Convert(Fees);

		// Get Policy Tax
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Tax_Text()));
		String policy_Tax_percentage = EIP.get_Policy_Tax_Text().getText();
		String drawDigitsFromString = StringHelper.drawDigitsFromString(policy_Tax_percentage);
		double Tax_Percentage = string_To_double_Convert(drawDigitsFromString);

		// get Amount
		double Tax_Amount = grossDouble_Value * Tax_Percentage / 100;
		String Policy_Tax = String.format("%.2f", Tax_Amount);
		System.out.println("Policy Tax Amount is: " + Policy_Tax);

		// Get Policy Tax Amount
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Tax_amount()));
		String Policy_Tax_Amount = EIP.get_Policy_Tax_amount().getText();
		System.out.println("Policy tax Amount is: " + Policy_Tax_Amount);

		if (Policy_Tax_Amount.contains(Policy_Tax)) {
			Assert.assertEquals(Policy_Tax_Amount, Policy_Tax);
			System.out.println("Tax Amount Verification Passed");
		} else {
			// Assert.fail();
			System.out.println("Tax Amount Verification Failed");
		}

		double Policy_Tax_Double_Value = string_To_double_Convert(Policy_Tax_Amount);

		// Get Inward Commission
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Inward_Commission_amount()));
		String Inward_Commission = EIP.get_Inward_Commission_amount().getText();
		double Inward_Commission_Amount = string_To_double_Convert(Inward_Commission);

		// get Inward Commission Percentage
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Inward_Commission_Tax_Text()));
		String get_Inward_Commission_Tax_Text = EIP.get_Inward_Commission_Tax_Text().getText();
		String drawDigitsFromString2 = StringHelper.drawDigitsFromString(get_Inward_Commission_Tax_Text);
		double Inward_Commission_percent = string_To_double_Convert(drawDigitsFromString2);

		double Inward_Commission_Tax = Inward_Commission_Amount * Inward_Commission_percent / 100;
		String Inward_Policy_Tax = String.format("%.2f", Inward_Commission_Tax);
		System.out.println("Inward Commission Tax is: " + Inward_Policy_Tax);

		// Get Inward Commission Amount
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Inward_Commission_Tax_Amount()));
		String Inward_Commission_Tax_Amount = EIP.get_Inward_Commission_Tax_Amount().getText();
		// Inward Commission Tax Amount Verification
		if (Inward_Commission_Tax_Amount.contains(Inward_Policy_Tax)) {
			Assert.assertEquals(Inward_Commission_Tax_Amount, Inward_Policy_Tax);
			System.out.println("Inward Commission Tax Amount Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Inward Commission Tax Amount Verification Failed");
		}

		double Inward_Commission_Tax_Double_Value = string_To_double_Convert(Inward_Commission_Tax_Amount);
		// Net Premium
		double net_Premium = gross_premium_Double_Value + Loading_Amount + Fees_Amount + Policy_Tax_Double_Value
				+ Inward_Commission_Amount + Inward_Commission_Tax_Double_Value - Discount_Amount;

		String Net_Premium = String.format("%.2f", net_Premium);
		System.out.println("Net Premium Is: " + Net_Premium);

		// Get Net Premium
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Net_Premium()));
		String Net_Premium_Amount = EIP.get_Net_Premium().getText();
		String Net_To_Customer = Net_Premium_Amount.replace(",", "");

		// Net Amount Verification Failed
		if (Net_To_Customer.contains(Net_Premium)) {
			Assert.assertEquals(Net_To_Customer, Net_Premium);
			System.out.println("Net Amount Verification PAssed");
		} else {
			Assert.fail();
			System.out.println("Net Amount Verification Failed");
		}

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
				EIP.amount_Field().sendKeys(Net_To_Customer);
			} else if (Cash_Type.equals("CASH")) {

//				Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(EIP.amount_Field()));
				EIP.amount_Field().sendKeys(Net_To_Customer);

			}

//			Save the details
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.save_Cash_Analysis()));
			EIP.save_Cash_Analysis().click();

		} else if (Mode_Of_Pay.equals("Credit")) {
			webDriverWait(ExpectedConditions.visibilityOf(EIP.Insured_Billing_Account()));
			try {
				selectByVisibleText(EIP.Insured_Billing_Account(), customer);
			} catch (Exception e) {

				selectByIndex(EIP.Insured_Billing_Account(),3);
			}
		}
		Thread.sleep(5000);
//		Approve Endorsement
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
		javaScribtClick(EIP.approve_Endorsement_Button());

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

		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
		EIP.Close_Button().click();

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
		String PolicyNumber = GSP.Policy_Number().getText();
		System.out.println("Policy Number is: " + PolicyNumber);

		if (PolicyNumber.contains(Policy_Number)) {
			Assert.assertEquals(PolicyNumber, Policy_Number);
			System.out.println("Policy Number Verification is Pass");

		} else {

			Assert.fail();
			System.out.println("Policy Number Verification Failed");

		}

//		Get Policy From Date
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Policy_From_Date()));
		String policy_From_Date = GSP.get_Policy_From_Date().getText();
		System.out.println("Policy From Date is: " + policy_From_Date);

//		Policy From Date Verification
		if (policy_From_Date.contains(Effective_From_Date)) {

			Assert.assertEquals(policy_From_Date, Effective_From_Date);
			System.out.println("Policy From Date Verification Passed");

		} else {
			Assert.fail();
			System.out.println("Policy From Date Verification Failed");
		}
//		Get Policy To Date
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Policy_To_Date()));
		String Policy_To_Date = GSP.get_Policy_To_Date().getText();
		System.out.println("Policy To date is: " + Policy_To_Date);

//		Policy To date Verification
		if (Policy_To_Date.contains(Effective_To_Date)) {
			Assert.assertEquals(Policy_To_Date, Effective_To_Date);
			System.out.println("Policy To date Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Policy To Date Verification Failed");
		}

	}

}

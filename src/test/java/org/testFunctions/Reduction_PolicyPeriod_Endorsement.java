package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Endorsement_Information_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Login_Page;
import org.pages.Global_Search_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reduction_PolicyPeriod_Endorsement extends BaseClass {

	@Test(dataProvider = "Reduction_Policy_Period")
	public void tc_001(String S_No, String Search_Policy, String Policy_Number, String Type_of_Policy,
			String Insured_Name, String Endorsement_Type, String Remarks, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account, String Run_Flag)
			throws AWTException, InterruptedException, IOException, ClassNotFoundException {

		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();
		Login_Page LP = new Login_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
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

		// Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: " + Product_Type);

		// Select Endorsement Type
		webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
		selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
		String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
		System.out.println("Policy Start Date: " + ActualPolicyStartDate);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
		String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
		System.out.println("Policy End Date: " + ActualPolicyEndDate);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
		GSP.effective_To_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter);
		LocalDateTime newDate = date.plusDays(-30);
		String newDateString = newDate.format(formatter);
		GSP.effective_To_Date().sendKeys(newDateString);
		System.out.println("Endorsement Effective to Date: " + newDateString);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
		GSP.proceed_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
		String endorsement_Type = EIP.get_Endorsement_Type().getText();
		System.out.println("Endorsement Type is: " + endorsement_Type);

		// Endorsement Type Verification
		if (endorsement_Type.contains(Endorsement_Type)) {
			Assert.assertEquals(endorsement_Type, Endorsement_Type);
			System.out.println("Endorsement Type Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Endorsement Type Verification Failed");
		}

		// Get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
		String policy_No = EIP.get_Policy_Number().getText();

		// Policy Number Verification
		if (policy_No.contains(Policy_Number)) {
			Assert.assertEquals(policy_No, Policy_Number);
			System.out.println("Policy Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Policy Number Verification Failed");
		}

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
		// webDriverWait(ExpectedConditions.elementToBeClickable(object.special_Tty_No_Option()));
		// object.special_Tty_No_Option().click();

		// Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();
		Thread.sleep(3000);
		// Get Gross_Premium
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Gross_Premium()));
		String gross_premium = EIP.get_Gross_Premium().getText();
		System.out.println("Gross Premium Amount is: " + gross_premium);

//		//		Gross Premium Verification
//		if (gross_premium.contains(SMI_Premium_Amount)) {
//			Assert.assertEquals(gross_premium, SMI_Premium_Amount);
//			System.out.println("Gross Premium AMount Verification Passed");
//		}else {
//			//	Assert.fail();
//			System.out.println("Gross Amount Verification Failed");
//		}

		// Get Double Value
		double gross_premium_Double_Value = string_To_double_Convert(gross_premium);

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
		double Tax_Amount = gross_premium_Double_Value * Tax_Percentage / 100;
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

		if (Mode_Of_Pay.equals("Debit")) {
			webDriverWait(ExpectedConditions.visibilityOf(EIP.Insured_Billing_Account()));
			try {
				selectByVisibleText(EIP.Insured_Billing_Account(), customer);
			} catch (Exception e) {
				selectByIndex(EIP.Insured_Billing_Account(), 3);
			}

		} else if (Mode_Of_Pay.equals("SEPA")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.SEPA_Acc_Number()));
			EIP.SEPA_Acc_Number().sendKeys("65468654658");

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.SEPA_Swift_Code()));
			EIP.SEPA_Swift_Code().sendKeys("JHFHGFI36879856");

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.SEPA_IBAN_No()));
			EIP.SEPA_IBAN_No().sendKeys("GCI657658765469");

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.SEPA_Bank_Name()));
			selectByIndex(EIP.SEPA_Bank_Name(), 2);

			webDriverWait(ExpectedConditions.visibilityOf(EIP.BIC_Code()));
			EIP.BIC_Code().sendKeys(Account_Number);
		}

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

		// Customer Name Verification
		String customerName = EIP.customer_Name().getText();
		System.out.println("Customer Name is: " + customerName);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(Policy_Number);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();

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

			}//else {
//				System.out.println("FAC is not applicable");
//			}
	}
}
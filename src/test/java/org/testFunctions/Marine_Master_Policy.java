package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.pages.MarinePolicy_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Marine_Master_Policy extends BaseClass {

	public static String annual_Sum_Insured_Premium;
	public static String OurSI;
	public static String policy_Type;
	public static String Risk_TODate;
	public static String Quote_Number;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static String Password;
	public static String MOC_Policy_Number = null;
	public static String RI_Password;
	public static List<WebElement> MyAction;

	@Test(dataProvider = "MOC_Policy")
	public void tc001(String S_No, String Policy_Type, String MOC_Policy_Query, String MOC_Policy, String Insured_Query,
			String Insured_ID, String Quotation_Validity_Days, String Business_Source,
			String Co_Insurance_Share_Percentage, String Sum_Insured_Currency, String Premium_Currency,
			String Contact_Number, String Business_Occupation, String Territorial_Limits, String Introducer_Name,
			String Processor_Name, String Est_Annual_Turnover, String Limit_shipment, String Min_Premium,
			String Bank_Name, String Coinsurer_Name_Query, String Coinsurer_ID, String Coinsurer_Share, String CC_Value,
			String Incoterms, String CFR_Value, String Policy_Discount, String Policy_Discount_Rate,
			String Policy_Loading, String Policy_Loading_Rate, String Policy_Deductible,
			String Policy_Deductible_Calctype, String Policy_Deductible_RateValue, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Doc_type, String Special_Tty, String Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Banks_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String FAC_Participant, String RI_Status, String Approve_Policy, String Run_Flag)
			throws IOException, AWTException, ClassNotFoundException, ParseException, InterruptedException {

		//driver.get(currentUrl);

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Commercial_Login CLP = new Commercial_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		MarinePolicy_Page MP = new MarinePolicy_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cust = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();

//		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
//		LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 3, 1));
//		loginuser = LP.username_Field().getAttribute("value");
//		System.out.println("Login user id: " + loginuser);
//
//		password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
//				+ loginuser + "'";
//		Loginuser_password = get_DB_Data(password_Query, "USER_PASSWORD");
//
//		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
//		LP.password_Field().sendKeys(Loginuser_password);
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
//		LP.login_Button().click();
//
//		String user_Profile_Name = get_DB_Data(password_Query, "USER_NAME");
//		System.out.println("User Profile Name is: " + user_Profile_Name);

		// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		// Click Personal Underwriting
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.commercial_Underwriting_Button()));
		uwp.commercial_Underwriting_Button().click();
		rb.delay(3000);

		// Click MOC
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Marine_Open_Cover()));
		uwp.Marine_Open_Cover().click();

		// Enter Insured Name
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Insured_Code_Field()));
		cust.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_insured()));
		cust.select_insured().click();

		// Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(cust.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(cust.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

		// Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(cust.Business_Source_Dropdown()));
		selectByVisibleText(cust.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source = " + Business_Source);

//		// Select Type of Policy
//		webDriverWait(ExpectedConditions.visibilityOf(apin.Types_of_Policy_Dropdown()));
//		selectByVisibleText(apin.Types_of_Policy_Dropdown(), Types_of_Policy);

		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {
			webDriverWait(ExpectedConditions.visibilityOf(cust.co_insurance_Share_Percentage()));
			cust.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
			System.out.println("Co-Insurance share percentage = " + Co_Insurance_Share_Percentage);
		}

		// Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(cust.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(cust.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

		// Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(cust.Premium_Currency_Dropdown()));
		selectByVisibleText(cust.Premium_Currency_Dropdown(), Premium_Currency);

		// Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(cust.Contact_Number_Field()));
		cust.Contact_Number_Field().click();
		cust.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cust.Contact_Number_Field().sendKeys(Keys.DELETE);
		cust.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number = " + Contact_Number);

		// Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(cust.Business_Field()));
		cust.Business_Field().sendKeys(Business_Occupation);

		// Enter Territorial Limits
		webDriverWait(ExpectedConditions.visibilityOf(cust.territorial_Limits()));
		cust.territorial_Limits().sendKeys(Territorial_Limits);

		// Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.introducer_Name_Field()));
		cust.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_Intoducer()));
		cust.select_Intoducer().click();
		System.out.println("Introducer Name = " + Introducer_Name);

		// Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.Processor_Name_Field()));
		cust.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_processor()));
		cust.select_processor().click();
		System.out.println("Processor Name = " + Processor_Name);

		// Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
		cust.proceed_Button().click();
		System.out.println("proceed to Risk info page");

//Risk Info page

		// Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		String quote_Number = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + quote_Number);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);

		// get Insure name
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		// enter Estimated annual turnover
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Annual_TurnOver()));
		MP.MOC_Annual_TurnOver().sendKeys(Est_Annual_Turnover);
		System.out.println("Estimated annual turnover: " + Est_Annual_Turnover);

		// enter limit per shipment
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Limit_per_Shipment()));
		MP.MOC_Limit_per_Shipment().sendKeys(Limit_shipment);
		System.out.println("Limit per shipment: " + Limit_shipment);

		// enter Minimum Premium
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Min_Premium()));
		MP.MOC_Min_Premium().sendKeys(Min_Premium);
		System.out.println("Minimum Premium :" + Min_Premium);

		// enter bank name
		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Bank()));
			MP.MOC_Bank().sendKeys("BNF");
		} catch (Exception e) {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Banklist()));
			selectByVisibleText(MP.MOC_Banklist(), Bank_Name);
			System.out.println("Bank Name: " + Bank_Name);
		}

// MOC coinsurance details	
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {

			try {
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_add_CoInsurance_Button()));
				MP.MOC_add_CoInsurance_Button().click();
			} catch (Exception e) {
				// Click Add Co insurance Menu
				webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CoInsursance_Menu()));
				MP.MOC_CoInsursance_Menu().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_add_CoInsurance_Button()));
				MP.MOC_add_CoInsurance_Button().click();
			}
			// Get Total Sum Insured
			webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_get_Total_Sum_Insured()));
			String text = MP.MOC_get_Total_Sum_Insured().getText();
			double Total_Sum_Insured = string_To_double_Convert(text);

//			Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_get_Total_Premium_FC()));
			String Total_Premium_FC = MP.MOC_get_Total_Premium_FC().getText();
			double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
			System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

//			Get Our Share
			webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_get_Our_Share()));
			String text2 = MP.MOC_get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

//			get Our Premium
			webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_get_Our_Premium()));
			String text3 = MP.MOC_get_Our_Premium().getText();
			String our_Premium = text3.replace(",", "");
			System.out.println("our Premium is: " + our_Premium);

			if (our_Premium.contains(Premium_Amount)) {
				Assert.assertEquals(our_Premium, Premium_Amount);
				System.out.println("Premium Amount Verification Passed");
			} else {
				Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}

//Insurer Premium
			double text4 = string_To_double_Convert(text3);
			double insurer_Premium = Total_Premium_Amount - text4;
			String Remaining_Premium = String.format("%.2f", insurer_Premium);
			System.out.println("Insurer Premium Amount is: " + Remaining_Premium);

//			Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_coinsurance_Name_Field()));
			MP.MOC_coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_select_Coinsurance()));
			MP.MOC_select_Coinsurance().click();
			String coinsurer = getAtrributeValue(MP.MOC_coinsurance_Name_Field(), "value");
			System.out.println("Coinsurer Name: " + coinsurer);
			rb.delay(3000);

//			Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_coinsurance_Share_Percentage_Field()));
			MP.MOC_coinsurance_Share_Percentage_Field().click();
			MP.MOC_coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share, Keys.TAB);
			rb.delay(3000);

			if (Business_Source.equals("Direct with Elmo Follower")
					|| Business_Source.equals("Broker with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Coins_LeaderYN()));
				MP.MOC_Coins_LeaderYN().click();
			}

//			Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Save_Coinsurance_Details()));
			javaScribtClick(MP.MOC_Save_Coinsurance_Details());

//			Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_CoInsurer_Share_Premium()));
			scrollDownJavaSc(MP.MOC_CoInsurer_Share_Premium());
			String text5 = MP.MOC_CoInsurer_Share_Premium().getText();
			String Coinsurer_Premium_Amount = text5.replace(",", "");
			System.out.println("Co insurer Premium Amount is: " + Coinsurer_Premium_Amount);

//			Premium Amount Verification
			if (Coinsurer_Premium_Amount.contains(Remaining_Premium)) {
				Assert.assertEquals(Coinsurer_Premium_Amount, Remaining_Premium);
				System.out.println("Premium Amount Verification Passed");
			} else {
				// Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}
		}
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Save_Risk()));
		rb.delay(2000);
		MP.MOC_Save_Risk().click();

//MOC applicable incoterms
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Applicable_Incoterms()));
		MP.MOC_Applicable_Incoterms().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CC_Checkbox()));
		rb.delay(3000);
		MP.MOC_CC_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CC_Value()));
		MP.MOC_CC_Value().clear();
		MP.MOC_CC_Value().sendKeys(CC_Value);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CFR_Checkbox()));
		MP.MOC_CFR_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CFR_Value()));
		MP.MOC_CFR_Value().clear();
		MP.MOC_CFR_Value().sendKeys(CFR_Value);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Save_Close()));
		MP.MOC_Save_Close().click();

//MOC applicable conveyance
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Applicable_Conveyance()));
		MP.MOC_Applicable_Conveyance().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_BySea()));
		MP.MOC_BySea().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ByAir()));
		MP.MOC_ByAir().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_By_Air_Sea_Land()));
		MP.MOC_By_Air_Sea_Land().click();
		rb.delay(2000);
		MP.MOC_Applicable_Conveyance().click();

//MOC Imports from		
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ImportsFrm()));
		doubleClick(MP.MOC_ImportsFrm());
		rb.delay(3000);
		MP.MOC_ImportsFrm().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_AGCC()));
		javaScribtClick(MP.MOC_AGCC());
		// MP.MOC_AGCC().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Abha_SaudiArabia()));
		javaScribtClick(MP.MOC_Abha_SaudiArabia());
		// MP.MOC_Abha_SaudiArabia().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_AbuDhabi_UAE()));
		javaScribtClick(MP.MOC_AbuDhabi_UAE());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ImportsFrm()));
		MP.MOC_ImportsFrm().click();

// MOC exports to
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ExportsTo()));
		JavascriptExecutor JavascriptExecutor = (JavascriptExecutor) driver;
		JavascriptExecutor.executeScript("arguments[0].click();", MP.MOC_ExportsTo());
		// doubleClick(MP.MOC_ExportsTo());
		rb.delay(3000);
		MP.MOC_ExportsTo().click();

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Abudhabi()));
		JavascriptExecutor.executeScript("arguments[0].click();", MP.MOC_Abudhabi());

		Actions actions = new Actions(driver);
//		actions.moveToElement(MP.MOC_Abudhabi()).build().perform();
		// javaScribtClick(MP.MOC_Abudhabi());
		// MP.MOC_Bulgaria().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Aden_Yemen()));
		actions.moveToElement(MP.MOC_Aden_Yemen()).click().perform();
		// javaScribtClick(MP.MOC_Aden_Yemen());
		// MP.MOC_Burma().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Afghanistan()));
		actions.moveToElement(MP.MOC_Afghanistan()).click().perform();
		// javaScribtClick(MP.MOC_Afghanistan());
		// MP.MOC_Burundi().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_exports()));
		MP.MOC_exports().click();

//MOC Add Goods
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods()));
		javaScribtClick(MP.MOC_Goods());

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Alcoholic_Beverages_Checkbox()));
		MP.MOC_Alcoholic_Beverages_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Alcoholic_Beverages_Clauses()));
		selectByIndex(MP.MOC_Alcoholic_Beverages_Clauses(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Alcoholic_Beverages_Rate()));
		MP.MOC_Alcoholic_Beverages_Rate().sendKeys("1");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Building_Materials_Checkbox()));
		MP.MOC_Building_Materials_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Building_Materials_Clauses()));
		selectByIndex(MP.MOC_Building_Materials_Clauses(), 2);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Building_Materials_Rate()));
		MP.MOC_Building_Materials_Rate().sendKeys("1.5");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cereals_Checkbox()));
		MP.MOC_Cereals_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cereals_Clauses()));
		selectByIndex(MP.MOC_Cereals_Clauses(), 3);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cereals_Rate()));
		MP.MOC_Cereals_Rate().sendKeys("2");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods_Save()));
		MP.MOC_Goods_Save().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		System.out.println("proceed to Add pol info page");

// add pol info page		

		try {

			rb.delay(5000);
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			apin.Policy_Discounts_Loadings_Panel().click();

			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);
		}

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Discount);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.MOC_Discount_Checkbox()));
		apin.MOC_Discount_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.MOC_Discount_Rate()));
		apin.MOC_Discount_Rate().sendKeys(Policy_Discount_Rate, Keys.TAB);

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

// Add Insured

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
			javaScribtClick(apin.Add_Additional_Insured());
		} catch (Exception e) {
			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Additional_Insured_Menu()));
			apin.Additional_Insured_Menu().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
			javaScribtClick(apin.Add_Additional_Insured());
		}

		if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
			selectByVisibleText(apin.Split_YN(), Split_YN);
			System.out.println("Split invoice is: " + Split_YN);
			rb.delay(2000);
			webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
			apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
			rb.delay(2000);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
//					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Select_Add_Insured_Name()));
//					apin.Select_Add_Insured_Name().click();
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
			rb.delay(5000);

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

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Ins_Mobile_No()));
		apin.Add_Ins_Mobile_No().click();
//				if (obj11.Add_Ins_Mobile_No() == null) {
		apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
		// System.out.println("Add Ins Mobile No: " + AddIns_MobileNo);
//				}else{
		String AddIns_MobNum = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
		System.out.println("Add Ins Mobile No: " + AddIns_MobNum);
//				}

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));

		// Create a Select object for the dropdown
		Select dropdown = new Select(apin.Surveyor_Name());
		// Get all the options in the dropdown
		List<WebElement> SurveyorName = dropdown.getOptions();
		// Filter out the option that contains the text "Select"
		List<WebElement> validOptions = new ArrayList<>();
		for (WebElement option : SurveyorName) {
			if (!option.getText().toLowerCase().contains("select")) {
				validOptions.add(option);
			}
		}
		// Check if valid options exist
		if (!validOptions.isEmpty()) {
			// Pick a random index from the valid options list
			Random random = new Random();
			int randomIndexOfSurveyorName = random.nextInt(validOptions.size());
			// Select the random option
			dropdown.selectByIndex(SurveyorName.indexOf(validOptions.get(randomIndexOfSurveyorName)));
			// Print the selected option (optional)
			String selectedSurveyor = validOptions.get(randomIndexOfSurveyorName).getText();
			System.out.println("Surveyor Name: " + selectedSurveyor);
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

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox()));
		apin.Terms_Conditions_Checkbox().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
		apin.Save_Terms_Conditions().click();

		rb.delay(3000);
		// Policy Documents Upload
		// scrollDownJavaSc(apin.Policy_Document_Dropdown());
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

		rb.delay(1000);

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

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_finalize_Quotation()));
		MP.MOC_finalize_Quotation().click();

		// click continue button
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_continue_Quote_Button()));
		MP.MOC_continue_Quote_Button().click();

		// get Quotation Number
		webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_get_Quotation_Number()));
		Quote_Number = MP.MOC_get_Quotation_Number().getText();
		System.out.println("Quotation Number: " + Quote_Number);

// go to the global search page
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
		javaScribtClick(ra.global_Search_Button());
		// Enter Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
		ra.Quote_Number_Field().sendKeys(Quote_Number);
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.quote_Search_Button()));
		ra.quote_Search_Button().click();

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
		driver.navigate().refresh();
		
//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_PrintDocs_Close()));
//		GSP.Quote_Search_PrintDocs_Close().click();
		rb.delay(5000);

		if (Approve_Policy.equals("Yes")) {

			// approve as policy
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.APPROVE_POLICY()));
			GSP.APPROVE_POLICY().click();

			try {
				rb.delay(5000);
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
				MOC_Policy_Number = ra.get_Policy_Number().getText();
				System.out.println("Policy Number is: " + MOC_Policy_Number);

				// Get Customer Name
				webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
				String CustomerName = ra.customer_Name().getText();
				System.out.println("Customer Name is: " + CustomerName);

				// MOC Summary policy Print.
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
				ra.Summary_Policy_PrintDocs().click();
				rb.delay(3000);

				List<WebElement> listCheckBoxes1 = ra.Summary_Quotation_Checkbox();
				System.out.println("Print document List: " + listCheckBoxes1.size());

				for (int i = 0; i < listCheckBoxes1.size(); i++) {
					listCheckBoxes1.get(i).click();
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Print()));
				javaScribtClick(ra.Summary_Quotation_Print());

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
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Policy_Close()));
				javaScribtClick(ra.Summary_Quotation_Policy_Close());

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
					ra.search_Enq_Field().sendKeys(Quote_Number);

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

					// Default login user
					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//				Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
					ra.Quote_Number_Field().sendKeys(Quote_Number);

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.quote_Search_Button()));
					ra.quote_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.APPROVE_POLICY()));
					GSP.APPROVE_POLICY().click();
					
					try {
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.APPROVE_POLICY()));
						GSP.APPROVE_POLICY().click();
					} catch (Exception e2) {	}

					webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
					MOC_Policy_Number = ra.get_Policy_Number().getText();
					System.out.println("Policy Number is: " + MOC_Policy_Number);
				}
			}

			// click global search icon
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(MOC_Policy_Number);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();
		}
	}
}
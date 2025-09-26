package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Issue_Policy_Annual_Contract_Works extends BaseClass {

	@Test(dataProvider = "Annual_Contract_Certificate")
	public void tc_001(String S_No, String Policy_Type, String Insured_Name, String Quotation_Validity_Days,
			String Business_Source, String Types_of_Policy, String Co_Insurance_Share_Percentage,
			String Sum_Insured_Currency, String Premium_Currency, String Contact_Number, String Business_Occupation,
			String Territorial_Limits, String Introducer_Name, String Processor_Name, String Sum_Insured_Amount,
			String Sum_Insured_Rate, String Risk_Description, String Occupancy_Type, String Description,
			String Location, String Cyber_Risk, String Contractor_Name, String Principals_Name, String Coinsurer_Name,
			String Coinsurer_Share, String RI_Ceding_Basic, String Mode_Of_Pay, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account, String Run_Flag)
			throws InterruptedException, IOException, AWTException, ParseException {
		Robot rb = new Robot();
		Underwritting_Page object = new Underwritting_Page();
		// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(object.menu_Button()));
		object.menu_Button().click();

		// Click Commercial Underwriting
		webDriverWait(ExpectedConditions.elementToBeClickable(object.commercial_Underwriting_Button()));
		object.commercial_Underwriting_Button().click();

		// Click Engineering Commercial
		webDriverWait(ExpectedConditions.elementToBeClickable(object.Engineering_Commercial_Menu()));
		object.Engineering_Commercial_Menu().click();

		Issue_Policy_Customer_Info_Page objec = new Issue_Policy_Customer_Info_Page();

		// // Click Proceed Button
		// webDriverWait(ExpectedConditions.elementToBeClickable(objec.proceed_Button()));
		// objec.proceed_Button().click();
		//
		// // Get Error Msg
		// webDriverWait(ExpectedConditions.visibilityOf(objec.get_Error_Msg()));
		// String error_Msg = objec.get_Error_Msg().getText();
		// System.out.println("Error Msg is: "+error_Msg);
		//
		// // Error Msg Verification
		// if (error_Msg.contains(ReadExcelData.readExcel("Error_Msg", 1, 1))) {
		// Assert.assertEquals(error_Msg, ReadExcelData.readExcel("Error_Msg", 1, 1));
		// System.out.println("Error Msg Verification Passed");
		// } else {
		// Assert.fail();
		// System.out.println("Error Msg Verification Failed");
		// }

		// Enter Insured Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.Insured_Code_Field()));
		objec.Insured_Code_Field().sendKeys(Insured_Name);
		Thread.sleep(20000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);

		// get Customer name
		webDriverWait(ExpectedConditions.visibilityOf(objec.customer_Name_Field()));
		String customer_Name = getAtrributeValue(objec.customer_Name_Field(), "value");
		System.out.println("Customer Name is: " + customer_Name);

		// Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(objec.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

		// Enter Quotation Validity Days
		webDriverWait(ExpectedConditions.visibilityOf(objec.quotation_Valid_Days()));
		objec.quotation_Valid_Days().clear();
		objec.quotation_Valid_Days().sendKeys(Quotation_Validity_Days);

		// Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(objec.Business_Source_Dropdown()));
		selectByVisibleText(objec.Business_Source_Dropdown(), Business_Source);

		// Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(objec.Types_of_Policy_Dropdown()));
		selectByVisibleText(objec.Types_of_Policy_Dropdown(), Types_of_Policy);

		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Salesman with Elmo Leader")) {
			// Enter Co-insurance share percentage

			webDriverWait(ExpectedConditions.visibilityOf(objec.co_insurance_Share_Percentage()));
			objec.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
		}

		// Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(objec.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(objec.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

		// Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(objec.Premium_Currency_Dropdown()));
		selectByVisibleText(objec.Premium_Currency_Dropdown(), Premium_Currency);

		// Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.Contact_Number_Field()));
		objec.Contact_Number_Field().sendKeys(Contact_Number);

		// Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(objec.Business_Field()));
		objec.Business_Field().sendKeys(Business_Occupation);

		// Enter Territorial Limits
		webDriverWait(ExpectedConditions.visibilityOf(objec.territorial_Limits()));
		objec.territorial_Limits().sendKeys(Territorial_Limits);

		// Enter Introducer NAme
		webDriverWait(ExpectedConditions.visibilityOf(objec.introducer_Name_Field()));
		objec.introducer_Name_Field().sendKeys(Introducer_Name);
		Thread.sleep(20000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
		// Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.Processor_Name_Field()));
		objec.Processor_Name_Field().sendKeys(Processor_Name);
		Thread.sleep(20000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);

		// Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.proceed_Button()));
		objec.proceed_Button().click();

		Issue_Policy_Risk_Information_Page obj = new Issue_Policy_Risk_Information_Page();

		// Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Quote_Number()));
		String quote_Number = obj.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + quote_Number);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Type_of_Policy()));
		String type_of_Policy = obj.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);

		if (type_of_Policy.contains(Types_of_Policy)) {
			Assert.assertEquals(type_of_Policy, Types_of_Policy);
			System.out.println("Type Of Policy Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Type of Policy Verification Failed");
		}

		// get Insure name
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Insured_Name()));
		String insured_Name = obj.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		if (insured_Name.contains(Insured_Name)) {
			Assert.assertEquals(insured_Name, Insured_Name);
			System.out.println("Insured Name Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Insured Name Verification Failed");
		}

		// Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Button()));
		obj.SMI_Button().click();

		Thread.sleep(2000);
		// Click Annual Contract Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.contractors_Works_Checkbox()));
		obj.contractors_Works_Checkbox().click();
		// Enter Sum Insured
		webDriverWait(ExpectedConditions.visibilityOf(obj.contractors_Work_Sum_Insured()));
		obj.contractors_Work_Sum_Insured().click();
		doubleClick(obj.contractors_Work_Sum_Insured());

		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		obj.contractors_Work_Sum_Insured().sendKeys(Sum_Insured_Amount, Keys.TAB);

		// Click Debris Removal Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Debris_Removal_Checkbox()));
		obj.Debris_Removal_Checkbox().click();

		// Enter Sum Insured Amount
		webDriverWait(ExpectedConditions.visibilityOf(obj.Debris_Removal_Sum_Insured()));
		obj.Debris_Removal_Sum_Insured().click();
		doubleClick(obj.Debris_Removal_Sum_Insured());

		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		obj.Debris_Removal_Sum_Insured().sendKeys(Sum_Insured_Amount, Keys.TAB);

		// Save Details
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.save_Button()));
		obj.save_Button().click();
		Thread.sleep(4000);
		// Get Total SMI
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Total_SMI()));
		String Total_SMI = obj.get_Total_SMI().getText();
		System.out.println("Total SMI Amount is: " + Total_SMI);

		// Click proceed button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Proceed_Button()));
		obj.Proceed_Button().click();

		Thread.sleep(20000);

		// Click proceed button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Proceed_Button()));
		obj.Proceed_Button().click();

		Issue_Policy_RA_Slip_Page obj3 = new Issue_Policy_RA_Slip_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.finalize_Quote_Button()));
		// get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Quote_Number()));
		String quoteNumber = obj.get_Quote_Number().getText();

		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Sum_Insured_Amount()));
		String sum_Insured_Amount = obj3.get_Sum_Insured_Amount().getText();

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.finalize_Quote_Button()));
		obj3.finalize_Quote_Button().click();

		Thread.sleep(3000);
		// Click Continue Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.continue_Quote_Button()));
		obj3.continue_Quote_Button().click();

		// get Qutation Number
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Quotation_Number()));
		String Quotation_Number = obj3.get_Quotation_Number().getText();

		// get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(obj3.customer_Name()));
		String customer_name = obj3.customer_Name().getText();

		// Click Approve as Policy Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.approve_Policy_Button()));
		obj3.approve_Policy_Button().click();

		// Click Continue Button
		// webDriverWait(ExpectedConditions.elementToBeClickable(obj3.continue_Button()));
		// obj3.continue_Button().click();

		// get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Policy_Number()));
		String policy_Number = obj3.get_Policy_Number().getText();
		System.out.println("Policy Number is: " + policy_Number);

		// Get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(obj3.customer_Name()));
		String Customer_Name = obj3.customer_Name().getText();
		System.out.println("Customer Name is: " + Customer_Name);

		if (Customer_Name.contains(customer_name)) {
			Assert.assertEquals(Customer_Name, customer_name);
		} else {
			Assert.fail();
		}

		// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(object.menu_Button()));
		object.menu_Button().click();

//		Click Commercial Underwriting																			//puneeth//
		webDriverWait(ExpectedConditions.elementToBeClickable(object.commercial_Underwriting_Button()));
		object.commercial_Underwriting_Button().click();

//		Click annual Contract Work Certificate
		webDriverWait(ExpectedConditions.elementToBeClickable(object.Annual_Contract_Works_Certificate()));
		object.Annual_Contract_Works_Certificate().click();

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(object.Policy_No_Field()));
		object.Policy_No_Field().sendKeys(policy_Number);
		Thread.sleep(10000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);

		// click single certificate Button
		webDriverWait(ExpectedConditions.elementToBeClickable(object.create_Single_Certificate_Button()));
		object.create_Single_Certificate_Button().click();

		// Enter Insured Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.Insured_Code_Field()));
		objec.Insured_Code_Field().sendKeys(Insured_Name);
		Thread.sleep(10000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);

		// Enter From Date
		webDriverWait(ExpectedConditions.visibilityOf(objec.policy_From_Date()));
		String from_Date = getAtrributeValue(objec.policy_From_Date(), "value");
		System.out.println(from_Date);
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date parse = date.parse(from_Date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);

		// Add one day to the date
		calendar.add(Calendar.DAY_OF_MONTH, 2);

		// Get the next date
		Date next_Date = calendar.getTime();

		// Format the next date as a string
		String nextDateStr = date.format(next_Date);
		System.out.println(nextDateStr);
		objec.policy_From_Date().clear();

		objec.policy_From_Date().sendKeys(nextDateStr);
//		Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.Contact_Number_Field()));
		objec.Contact_Number_Field().sendKeys(Contact_Number);

		webDriverWait(ExpectedConditions.elementToBeClickable(objec.proceed_Button()));
		objec.proceed_Button().click();

//		Enter Risk Description
		webDriverWait(ExpectedConditions.visibilityOf(obj.risk_Description_Field()));
		obj.risk_Description_Field().sendKeys(Risk_Description);

		// Select Occupancy Type
		// webDriverWait(ExpectedConditions.visibilityOf(obj.Occupancy_Dropdown()));
		// selectByVisibleText(obj.Occupancy_Dropdown(), Occupancy_Type);

		// Select description
		webDriverWait(ExpectedConditions.visibilityOf(obj.description_Dropdown()));
		selectByVisibleText(obj.description_Dropdown(), Description);

		// Enter Location
		webDriverWait(ExpectedConditions.visibilityOf(obj.Location_Field()));
		obj.Location_Field().sendKeys(Location);

		// Click Longitude Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.find_Latitude()));
		obj.find_Latitude().click();

		Thread.sleep(7000);
		webDriverWait(ExpectedConditions.visibilityOf(obj.ok_Button()));

		webDriverWait(ExpectedConditions.elementToBeClickable(obj.ok_Button()));
		javaScribtClick(obj.ok_Button());

//		Select cyber Risk
		webDriverWait(ExpectedConditions.visibilityOf(obj.cyber_Risk_Dropdown()));
		selectByVisibleText(obj.cyber_Risk_Dropdown(), Cyber_Risk);

		Thread.sleep(5000);

//		Enter Contractor name
		webDriverWait(ExpectedConditions.visibilityOf(obj.contractor_Name_Field()));
		obj.contractor_Name_Field().sendKeys(Contractor_Name);

		Thread.sleep(5000);

//		Enter Principals Name
		webDriverWait(ExpectedConditions.visibilityOf(obj.principals_Name_Field()));
		obj.principals_Name_Field().sendKeys(Principals_Name);

//		Click save Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.save_Button()));
		obj.save_Button().click();

		Thread.sleep(5000);

//		Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Quote_Number()));
		String QuoteNumber = obj.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + QuoteNumber);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Type_of_Policy()));
		String Type_of_Policy = obj.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + Type_of_Policy);

		if (Type_of_Policy.contains(Types_of_Policy)) {
			Assert.assertEquals(Type_of_Policy, Types_of_Policy);
			System.out.println("Type Of Policy Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Type of Policy Verification Failed");
		}

		// get Insure name
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Insured_Name()));
		String InsuredName = obj.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + InsuredName);

		if (InsuredName.contains(Insured_Name)) {
			Assert.assertEquals(InsuredName, Insured_Name);
			System.out.println("Insured Name Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Insured Name Verification Failed");
		}

//		Get Master Policy No
		webDriverWait(ExpectedConditions.visibilityOf(obj.get_Master_Policy_Number()));
		String master_policy_Number = obj.get_Master_Policy_Number().getText();

//		Policy Number Verification
		if (master_policy_Number.contains(policy_Number)) {
			Assert.assertEquals(master_policy_Number, policy_Number);
			System.out.println("Master Policy Number is same");
		} else {
			Assert.fail();
			System.out.println("Master Policy Number is not same");
		}

		// Click risk Check box
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.risk_Check_Box()));
		obj.risk_Check_Box().click();

//		Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Add_SMI_Button()));
		obj.Add_SMI_Button().click();

		// Enter Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Sum_Insured_checkbox()));
		obj.Sum_Insured_checkbox().click();

		// Enter Sum Insured Rate
		webDriverWait(ExpectedConditions.visibilityOf(obj.sum_Insured_Rate_Field()));
		obj.sum_Insured_Rate_Field().click();
		doubleClick(obj.sum_Insured_Rate_Field());
		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		obj.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

//		click Debris Removal Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Risk_Sum_Insured_checkbox()));
		obj.Risk_Sum_Insured_checkbox().click();

//		Enter Sum Insured Rate
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.sum_Insured_Risk_Rate_Field()));
		obj.sum_Insured_Risk_Rate_Field().click();
		doubleClick(obj.sum_Insured_Risk_Rate_Field());
		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		obj.sum_Insured_Risk_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//		Save Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.save_Button()));
		obj.save_Button().click();
		Thread.sleep(3000);
		// Get Annual Sum Insured Anount
		webDriverWait(ExpectedConditions.visibilityOf(obj.SMI_Annual_Premium()));
		String annual_Sum_Insured_Premium = obj.SMI_Annual_Premium().getText();
		System.out.println("Annual Sum Insured Amount is: " + annual_Sum_Insured_Premium);

		// Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(obj.SMI_Annual_Premium()));
		scrollDownJavaSc(obj.SMI_Annual_Premium());
		String SMI_Annual_Premium = obj.SMI_Annual_Premium().getText();
		System.out.println("Annual Premium Amount is: " + SMI_Annual_Premium);

		// Premium Amount Verification
		if (SMI_Annual_Premium.contains(annual_Sum_Insured_Premium)) {
			Assert.assertEquals(SMI_Annual_Premium, annual_Sum_Insured_Premium);
			System.out.println("Premium Amount Verification Passed");

		} else {
			Assert.fail();
			System.out.println("Premium AMount Verification Failed");
		}

		// Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj.Proceed_Button()));
		obj.Proceed_Button().click();
		Issue_Policy_Additional_Info_Page obj1 = new Issue_Policy_Additional_Info_Page();
//		get Policy Fees
		Thread.sleep(20000);
		webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Policy_Fees()));
		String policy_Fees = obj1.get_Policy_Fees().getText();
		System.out.println("Policy Fees is: " + policy_Fees);
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")) {

			// Click Co Insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.co_Insursance_Menu()));
			obj1.co_Insursance_Menu().click();

			// Click Add Co insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.add_Co_Insurance_Button()));
			obj1.add_Co_Insurance_Button().click();
			Thread.sleep(1000);
			// Get Total Sum Insured
			webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Total_Sum_Insured()));
			String text = obj1.get_Total_Sum_Insured().getText();
			double Total_Sum_Insured = string_To_double_Convert(text);

			// Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Total_Premium_FC()));
			String Total_Premium_FC = obj1.get_Total_Premium_FC().getText();
			double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
			System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

			if (Total_Premium_FC.contains(annual_Sum_Insured_Premium)) {
				Assert.assertEquals(Total_Premium_FC, annual_Sum_Insured_Premium);
				System.out.println("Premium Amount Verification Passed");
			} else {
				Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}

			// Get Our Share
			webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Our_Share()));
			String text2 = obj1.get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

			// get Our Premium
			webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Our_Premium()));
			String text3 = obj1.get_Our_Premium().getText();
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

			// Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.coinsurance_Name_Field()));
			obj1.coinsurance_Name_Field().click();
			obj1.coinsurance_Name_Field().sendKeys(Coinsurer_Name);
			Thread.sleep(2000);
			keyPress(KeyEvent.VK_ENTER);
			keyRelease(KeyEvent.VK_ENTER);

			// Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.coinsurance_Share_Percentage_Field()));
			obj1.coinsurance_Share_Percentage_Field().click();
			obj1.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share);

			// Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Save_Coinsurance_Details()));
			obj1.Save_Coinsurance_Details().click();
			try {
				webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Save_Coinsurance_Details()));
				obj1.Save_Coinsurance_Details().click();
			} catch (Exception e) {
			}

			Thread.sleep(3000);
			// Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(obj1.co_Insurer_Share_Premium()));
			scrollDownJavaSc(obj1.co_Insurer_Share_Premium());
			String text5 = obj1.co_Insurer_Share_Premium().getText();
			String Coinsurer_Premium_Amount = text5.replace(",", "");
			System.out.println("Co insurer Premium Amount is: " + Coinsurer_Premium_Amount);

			// Premium Amount Verification
			if (Coinsurer_Premium_Amount.contains(Remaining_Premium)) {
				Assert.assertEquals(Coinsurer_Premium_Amount, Remaining_Premium);
				System.out.println("Premium Amount Verification Passed");
			} else {
				Assert.fail();
				System.out.println("Premium Amount Verification Failed");
			}

		} else {

		}

		// Click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.proceed_Button()));
		obj1.proceed_Button().click();

		Issue_Policy_RI_Ceding_Page obj2 = new Issue_Policy_RI_Ceding_Page();
		Thread.sleep(4000);
		// Click Special Treaty No Option
		webDriverWait(ExpectedConditions.elementToBeClickable(obj2.special_Tty_No_Option()));
		obj2.special_Tty_No_Option().click();

		// Select RI Ceding Basic
		webDriverWait(ExpectedConditions.visibilityOf(obj2.select_RI_ceding_Basis()));
		selectByVisibleText(obj2.select_RI_ceding_Basis(), RI_Ceding_Basic);

		// Click Proceed
		webDriverWait(ExpectedConditions.visibilityOf(obj2.proceed_Button()));
		scrollDownJavaSc(obj2.proceed_Button());
		obj2.proceed_Button().click();
		Thread.sleep(3000);
		
		
//		Get Gross_Premium
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Gross_Premium()));
		String gross_premium = obj3.get_Gross_Premium().getText();
		System.out.println("Gross Premium Amount is: " + gross_premium);

		// Get Discount
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Discount()));
		String discount = obj3.get_Discount().getText();
		System.out.println("Discount amount: " + discount);

		// Get Loading
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Loading()));
		//scrollDownJavaSc(obj3.get_Charge());
		String loading = obj3.get_Loading().getText();
		System.out.println("Loading amount: " + loading);

		// Get Fees
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Charge()));
		String Fees = obj3.get_Charge().getText();
		System.out.println("Fees/Charges value: "+Fees);
		
		// Get Policy Tax Amount
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Policy_Tax_amount()));
		String Policy_Tax_Amount = obj3.get_Policy_Tax_amount().getText();
		System.out.println("Policy tax Amount is: " + Policy_Tax_Amount);


		// Get Inward Commission
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Inward_Commission_amount()));
		String Inward_Commission = obj3.get_Inward_Commission_amount().getText();
		double Inward_Commission_Amount = string_To_double_Convert(Inward_Commission);

		// get Inward Commission Percentage
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Inward_Commission_Tax_Text()));
		String get_Inward_Commission_Tax_Text = obj3.get_Inward_Commission_Tax_Text().getText();
		String drawDigitsFromString2 = StringHelper.drawDigitsFromString(get_Inward_Commission_Tax_Text);
		double Inward_Commission_percent = string_To_double_Convert(drawDigitsFromString2);

		double Inward_Commission_Tax = Inward_Commission_Amount * Inward_Commission_percent / 100;
		String Inward_Policy_Tax = String.format("%.2f", Inward_Commission_Tax);
		System.out.println("Inward Commission Tax is: " + Inward_Policy_Tax);

		// Get Inward Commission Amount
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Inward_Commission_Tax_Amount()));
		String Inward_Commission_Tax_Amount = obj3.get_Inward_Commission_Tax_Amount().getText();
		System.out.println("Inward Commission tax amount: " + Inward_Commission_Tax_Amount);
				
		//Get Net To Customer
		webDriverWait(ExpectedConditions.visibilityOf(obj3.Net_to_Customer()));
		String Net_To_Customer = obj3.Net_to_Customer().getText();
		System.out.println("Net to Customer: "+Net_To_Customer);
				
		//Get Net Premium
		webDriverWait(ExpectedConditions.visibilityOf(obj3.Net_Premium()));
		String NetPremium = obj3.Net_Premium().getText();
		System.out.println("Net to Customer: "+NetPremium);

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.finalize_Quote_Button()));
		obj3.finalize_Quote_Button().click();
		Thread.sleep(2000);

		// Click Continue Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.continue_Quote_Button()));
		obj3.continue_Quote_Button().click();
		Thread.sleep(5000);

		// get Qutation Number
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Quotation_Number()));
		String QuotationNumber = obj3.get_Quotation_Number().getText();

		// get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(obj3.customer_Name()));
		String Customer_name = obj3.customer_Name().getText();

		// Select Mode of Pay
		webDriverWait(ExpectedConditions.visibilityOf(obj3.mode_of_Pay_Dropdown()));
		selectByVisibleText(obj3.mode_of_Pay_Dropdown(), Mode_Of_Pay);

		if (Mode_Of_Pay.equals("Cash")) {
			// Click Cash Analysis
			webDriverWait(ExpectedConditions.elementToBeClickable(obj3.cash_Analysis_Button()));
			obj3.cash_Analysis_Button().click();

			// Click Add New Button
			webDriverWait(ExpectedConditions.elementToBeClickable(obj3.add_New_Button()));
			obj3.add_New_Button().click();

			// Click Check Box
			webDriverWait(ExpectedConditions.elementToBeClickable(obj3.cash_Code_Checkbox()));
			obj3.cash_Code_Checkbox().click();

			// Select cash Type
			webDriverWait(ExpectedConditions.visibilityOf(obj3.cash_Type_Dropdown()));
			selectByVisibleText(obj3.cash_Type_Dropdown(), Cash_Type);

			if (Cash_Type.equals("CHEQUE")) {
				// Enter Cheque No
				webDriverWait(ExpectedConditions.visibilityOf(obj3.cheque_Ref_Num()));
				obj3.cheque_Ref_Num().sendKeys(Cheque_No);

				// Select Bank Name
				webDriverWait(ExpectedConditions.visibilityOf(obj3.Bank_Name_Dropdown()));
				selectByVisibleText(obj3.Bank_Name_Dropdown(), Bank_Name);

				// Enter Account Number
				webDriverWait(ExpectedConditions.visibilityOf(obj3.account_Number_Field()));
				obj3.account_Number_Field().sendKeys(Account_Number);

				// Enter Cheque Date
				webDriverWait(ExpectedConditions.elementToBeClickable(obj3.cheque_End_Date()));
				obj3.cheque_End_Date().click();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDateTime now = LocalDateTime.now();
				obj3.cheque_End_Date().sendKeys(dtf.format(now));
				//
				// Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(obj3.amount_Field()));
				obj3.amount_Field().sendKeys(Net_To_Customer);
			} else if (Cash_Type.equals("CASH")) {

				// Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(obj3.amount_Field()));
				obj3.amount_Field().sendKeys(Net_To_Customer);

			}

			// SAve the details
			webDriverWait(ExpectedConditions.elementToBeClickable(obj3.save_Cash_Analysis()));
			obj3.save_Cash_Analysis().click();

		} else if (Mode_Of_Pay.equals("Credit")) {
			webDriverWait(ExpectedConditions.visibilityOf(obj3.Insured_Billing_Account()));
			rb.delay(2000);
			selectByIndex(obj3.Insured_Billing_Account(), 1);
		}
		Thread.sleep(1000);
		// Click Approve as Policy Button
		webDriverWait(ExpectedConditions.elementToBeClickable(obj3.approve_Policy_Button()));
		// obj3.approve_Policy_Button().click();
		javaScribtClick(obj3.approve_Policy_Button());

		// Click Continue Button
		// webDriverWait(ExpectedConditions.elementToBeClickable(obj3.continue_Button()));
		// obj3.continue_Button().click();

//		get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(obj3.get_Policy_Number()));
		String policyNumber = obj3.get_Policy_Number().getText();
		System.out.println("Policy Number is: " + policyNumber);

//		Get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(obj3.customer_Name()));
		String CustomerName = obj3.customer_Name().getText();
		System.out.println("Customer Name is: " + CustomerName);

		Global_Search_Page objref = new Global_Search_Page();
//		Click Global Search Button
		webDriverWait(ExpectedConditions.elementToBeClickable(objref.global_Search_Button()));
		objref.global_Search_Button().click();

//		Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(objref.Policy_Number_Field()));
		objref.Policy_Number_Field().sendKeys(policyNumber);

//		Click Policy Search Button
		webDriverWait(ExpectedConditions.elementToBeClickable(objref.policy_Search_Button()));
		objref.policy_Search_Button().click();
//		get Policy Type 
		webDriverWait(ExpectedConditions.visibilityOf(objref.Policy_Type()));
		String policy_Type = objref.Policy_Type().getText();

//		Policy Type Verification
		if (policy_Type.contains(Types_of_Policy)) {
			Assert.assertEquals(policy_Type, Types_of_Policy);
			System.out.println("Policy Type Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Policy Type Verification Failed");
		}

//		Get Insured Name
		webDriverWait(ExpectedConditions.visibilityOf(objref.Insured_Name()));
		String insured_Customer_Name = objref.Insured_Name().getText();

//		Insured Name Verification
		if (insured_Customer_Name.contains(Insured_Name)) {
			Assert.assertEquals(insured_Customer_Name, Insured_Name);
			System.out.println("Insured Customer Name Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Insured Name Verification Failed");
		}

//		Endorsement Button Enabled Verification
		webDriverWait(ExpectedConditions.visibilityOf(objref.endorsement_Button()));
		if (objref.endorsement_Button().isDisplayed()) {
			Assert.assertEquals(true, objref.endorsement_Button().isDisplayed());
		} else {
			Assert.fail();
			System.out.println("Endorsement Button is Displayed");
		}

//		Click View Account Button
		webDriverWait(ExpectedConditions.elementToBeClickable(objref.view_Accounting_Menu()));
		objref.view_Accounting_Menu().click();
		String parent_Window = driver.getWindowHandle();
//		Click Print Docs Button
		scrollDownJavaSc(objref.VW_Acc_Print_Docs());
		objref.VW_Acc_Print_Docs().click();

	}

}

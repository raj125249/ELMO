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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class Issue_Policy_Annual_Contract_Works_Reg extends BaseClass {

	@Test(dataProvider = "Annual_Contract_Certificate_Reg")
	public void tc_001(String S_No, String Policy_Type, String Insured_Query, String Insured_ID,
			String Quotation_Validity_Days, String Business_Source, String Types_of_Policy,
			String Co_Insurance_Share_Percentage, String Sum_Insured_Currency, String Premium_Currency,
			String Contact_Number, String Business_Occupation, String Territorial_Limits, String Introducer_Name,
			String Processor_Name, String Sum_Insured_Amount, String Sum_Insured_Rate, String Risk_Description,
			String Occupancy_Type, String Description, String Location, String Cyber_Risk, String Contractor_Name,
			String Principals_Name, String Coinsurer_Name, String Coinsurer_Share, String RI_Ceding_Basic,
			String Mode_Of_Pay, String Cash_Type, String Cheque_No, String Bank_Name, String Account_Number,
			String Insured_Billing_Account, String Run_Flag)
			throws InterruptedException, IOException, AWTException, ParseException, ClassNotFoundException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Global_Search_Page GSP = new Global_Search_Page();
		MarinePolicy_Page MP = new MarinePolicy_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cust = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		driver.get(currentUrl);

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 1, 1));

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 1, 2));

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		rb.delay(20000);
		String user_Profile_Name = LP.User_Profile_Name().getText();
		System.out.println("User Profile Name is: " + user_Profile_Name);

		if (user_Profile_Name.contains(ReadExcelData.readExcel("Login", 1, 3))) {

			Assert.assertEquals(user_Profile_Name, ReadExcelData.readExcel("Login", 1, 3));
			System.out.println("Employee named " + ReadExcelData.readExcel("Login", 1, 3)
					+ " signed in into the application successfully");
		} else {
			Assert.fail();
			System.out.println("Test Case Failed");

		}

		// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		// Click Commercial Underwriting
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.commercial_Underwriting_Button()));
		uwp.commercial_Underwriting_Button().click();

		// Click Engineering Commercial
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Engineering_Commercial_Menu()));
		uwp.Engineering_Commercial_Menu().click();

		Issue_Policy_Customer_Info_Page objec = new Issue_Policy_Customer_Info_Page();

		// Enter Insured Name
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.Insured_Code_Field()));
		objec.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.select_insured()));
		objec.select_insured().click();

		// Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(objec.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

//		// Enter Quotation Validity Days
//		webDriverWait(ExpectedConditions.visibilityOf(objec.quotation_Valid_Days()));
//		objec.quotation_Valid_Days().clear();
//		objec.quotation_Valid_Days().sendKeys(Quotation_Validity_Days);

		// Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(objec.Business_Source_Dropdown()));
		selectByVisibleText(objec.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source = " + Business_Source);

		// Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(objec.Types_of_Policy_Dropdown()));
		selectByVisibleText(objec.Types_of_Policy_Dropdown(), Types_of_Policy);

		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {
			webDriverWait(ExpectedConditions.visibilityOf(objec.co_insurance_Share_Percentage()));
			objec.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
			System.out.println("Co-Insurance share percentage = " + Co_Insurance_Share_Percentage);
		}

		// Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(objec.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(objec.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

		// Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(objec.Premium_Currency_Dropdown()));
		selectByVisibleText(objec.Premium_Currency_Dropdown(), Premium_Currency);

		// Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.Contact_Number_Field()));
		objec.Contact_Number_Field().click();
		objec.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		objec.Contact_Number_Field().sendKeys(Keys.DELETE);
		objec.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number = " + Contact_Number);

		// Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(objec.Business_Field()));
		objec.Business_Field().sendKeys(Business_Occupation);

		// Enter Territorial Limits
		webDriverWait(ExpectedConditions.visibilityOf(objec.territorial_Limits()));
		objec.territorial_Limits().sendKeys(Territorial_Limits);

		// Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.introducer_Name_Field()));
		objec.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.select_Intoducer()));
		objec.select_Intoducer().click();
		System.out.println("Introducer Name = " + Introducer_Name);

		// Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.Processor_Name_Field()));
		objec.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.select_processor()));
		objec.select_processor().click();
		System.out.println("Processor Name = " + Processor_Name);

		// Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.proceed_Button()));
		objec.proceed_Button().click();
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

		// get Insure name
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		// Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Button()));
		ris.SMI_Button().click();
		rb.delay(2000);

		// Click Annual Contract Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.contractors_Works_Checkbox()));
		ris.contractors_Works_Checkbox().click();

		// Enter Sum Insured
		webDriverWait(ExpectedConditions.visibilityOf(ris.contractors_Work_Sum_Insured()));
		ris.contractors_Work_Sum_Insured().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].", ris.contractors_Work_Sum_Insured());
		ris.contractors_Work_Sum_Insured().sendKeys(Sum_Insured_Amount, Keys.TAB);

		// Click Debris Removal Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Debris_Removal_Checkbox()));
		ris.Debris_Removal_Checkbox().click();

		// Enter Sum Insured Amount
		webDriverWait(ExpectedConditions.visibilityOf(ris.Debris_Removal_Sum_Insured()));
		ris.Debris_Removal_Sum_Insured().click();
		js.executeScript("arguments[0].", ris.Debris_Removal_Sum_Insured());
		ris.Debris_Removal_Sum_Insured().sendKeys(Sum_Insured_Amount, Keys.TAB);

		// Save Details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();
		rb.delay(5000);

		// Get Total SMI
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Total_SMI()));
		String Total_SMI = ris.get_Total_SMI().getText();
		System.out.println("Total SMI Amount is: " + Total_SMI);

		// Click proceed button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();

		rb.delay(20000);

		// Click proceed button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();

		Issue_Policy_RA_Slip_Page obj3 = new Issue_Policy_RA_Slip_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		// get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quote_Number()));
		String quoteNumber = ris.get_Quote_Number().getText();

		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Sum_Insured_Amount()));
		String sum_Insured_Amount = ra.get_Sum_Insured_Amount().getText();

		// Sum Insured AMount Verification
		if (sum_Insured_Amount.contains(Total_SMI)) {
			Assert.assertEquals(sum_Insured_Amount, Total_SMI);
			System.out.println("Sum Insured Amount Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Sum Insured Amount Verification Failed");
		}

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

//		click continue quote Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

		// get Qutation Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
		String Quotation_Number = ra.get_Quotation_Number().getText();

		if (Quotation_Number.contains(quote_Number)) {
			Assert.assertEquals(Quotation_Number, quote_Number);
			System.out.println("Quotation Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println();
		}

		// get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
		String customer_name = ra.customer_Name().getText();

		// Click Approve as Policy Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
		ra.approve_Policy_Button().click();

		// Click Continue Button
		// webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Button()));
		// ra.continue_Button().click();

		// get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
		String policy_Number = ra.get_Policy_Number().getText();
		System.out.println("Policy Number is: " + policy_Number);

		// Get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
		String Customer_Name = ra.customer_Name().getText();
		System.out.println("Customer Name is: " + Customer_Name);

		if (Customer_Name.contains(customer_name)) {
			Assert.assertEquals(Customer_Name, customer_name);
		} else {
			Assert.fail();
		}

		// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		// Click annual Contract Work Certificate

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Annual_Contract_Works_Certificate()));
		uwp.Annual_Contract_Works_Certificate().click();

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(uwp.Policy_No_Field()));
		uwp.Policy_No_Field().sendKeys(policy_Number);
		rb.delay(10000);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);

		// click single certificate Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.create_Single_Certificate_Button()));
		uwp.create_Single_Certificate_Button().click();

		// Enter Insured Name
		webDriverWait(ExpectedConditions.visibilityOf(objec.Insured_Code_Field()));
		objec.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(objec.select_insured()));
		objec.select_insured().click();

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
		rb.delay(5000);
		objec.policy_From_Date().sendKeys(nextDateStr);

//		Enter Contact Number
		webDriverWait(ExpectedConditions.visibilityOf(objec.Contact_Number_Field()));
		objec.Contact_Number_Field().sendKeys(Contact_Number);

		webDriverWait(ExpectedConditions.elementToBeClickable(objec.proceed_Button()));
		objec.proceed_Button().click();

//		Enter Risk Description
		webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
		ris.risk_Description_Field().sendKeys(Risk_Description);

		// Select Occupancy Type
		webDriverWait(ExpectedConditions.visibilityOf(ris.Occupancy_Dropdown()));
		selectByVisibleText(ris.Occupancy_Dropdown(), Occupancy_Type);

		// Select description
		webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
		selectByVisibleText(ris.description_Dropdown(), Description);

		// Enter Location
		webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
		ris.Location_Field().sendKeys(Location);

		// Click Longitude Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
		ris.find_Latitude().click();

		rb.delay(9000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));

		webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
		ris.ok_Button().click();

//		Select cyber Risk
		webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
		selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);

//		Enter Contractor name
		webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
		ris.contractor_Name_Field().sendKeys(Contractor_Name);

//		Enter Principals Name
		webDriverWait(ExpectedConditions.visibilityOf(ris.principals_Name_Field()));
		ris.principals_Name_Field().sendKeys(Principals_Name);

//		Click save Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

//		Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		String QuoteNumber = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + QuoteNumber);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String Type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + Type_of_Policy);

		if (Type_of_Policy.contains(Types_of_Policy)) {
			Assert.assertEquals(Type_of_Policy, Types_of_Policy);
			System.out.println("Type Of Policy Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Type of Policy Verification Failed");
		}

		// get Insure name
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String InsuredName = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + InsuredName);

//		Get Master Policy No
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Master_Policy_Number()));
		String master_policy_Number = ris.get_Master_Policy_Number().getText();

//		Policy Number Verification
		if (master_policy_Number.contains(policy_Number)) {
			Assert.assertEquals(master_policy_Number, policy_Number);
			System.out.println("Master Policy Number is same");
		} else {
			Assert.fail();
			System.out.println("Master Policy Number is not same");
		}

		// Click risk Check box
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
		ris.risk_Check_Box().click();

//		Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
		ris.Add_SMI_Button().click();

		// Enter Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
		ris.Sum_Insured_checkbox().click();

		// Enter Sum Insured Rate
		webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
		ris.sum_Insured_Rate_Field().click();
		doubleClick(ris.sum_Insured_Rate_Field());
		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

//		click Debris Removal Checkbox
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Sum_Insured_checkbox()));
		ris.Risk_Sum_Insured_checkbox().click();

//		Enter Sum Insured Rate
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Risk_Rate_Field()));
		ris.sum_Insured_Risk_Rate_Field().click();
		doubleClick(ris.sum_Insured_Risk_Rate_Field());
		keyPress(KeyEvent.VK_BACK_SPACE);
		keyRelease(KeyEvent.VK_BACK_SPACE);
		ris.sum_Insured_Risk_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//		Save Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();
		rb.delay(5000);
		// Get Annual Sum Insured Anount
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		String annual_Sum_Insured_Premium = ris.SMI_Annual_Premium().getText();
		System.out.println("Annual Sum Insured Amount is: " + annual_Sum_Insured_Premium);

		// Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		scrollDownJavaSc(ris.SMI_Annual_Premium());
		String SMI_Annual_Premium = ris.SMI_Annual_Premium().getText();
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
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		System.out.println("Proceed to Add Pol Info Page");

//Add Pol info page.
		// get Policy Fees
		rb.delay(20000);
		webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
		String policy_Fees = apin.get_Policy_Fees().getText();
		System.out.println("Policy Fees is: " + policy_Fees);
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")) {

			// Click Co Insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.co_Insursance_Menu()));
			apin.co_Insursance_Menu().click();

			// Click Add Co insurance Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
			apin.add_Co_Insurance_Button().click();
			rb.delay(1000);
			// Get Total Sum Insured
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Sum_Insured()));
			String text = apin.get_Total_Sum_Insured().getText();
			double Total_Sum_Insured = string_To_double_Convert(text);

			// Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Premium_FC()));
			String Total_Premium_FC = apin.get_Total_Premium_FC().getText();
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
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Share()));
			String text2 = apin.get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

			// get Our Premium
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

			// Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
			apin.coinsurance_Name_Field().click();
			apin.coinsurance_Name_Field().sendKeys(Coinsurer_Name);
			rb.delay(2000);
			keyPress(KeyEvent.VK_ENTER);
			keyRelease(KeyEvent.VK_ENTER);

			// Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
			apin.coinsurance_Share_Percentage_Field().click();
			apin.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share);

			// Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
			apin.Save_Coinsurance_Details().click();
			try {
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
				apin.Save_Coinsurance_Details().click();
			} catch (Exception e) {
			}

			rb.delay(3000);
			// Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
			scrollDownJavaSc(apin.co_Insurer_Share_Premium());
			String text5 = apin.co_Insurer_Share_Premium().getText();
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
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();

		rb.delay(4000);
		// Click Special Treaty No Option
		// webDriverWait(ExpectedConditions.elementToBeClickable(ri.special_Tty_No_Option()));
		// obj2.special_Tty_No_Option().click();

		// Select RI Ceding Basic
		webDriverWait(ExpectedConditions.visibilityOf(ri.select_RI_ceding_Basis()));
		selectByVisibleText(ri.select_RI_ceding_Basis(), RI_Ceding_Basic);

		// Click Proceed
		webDriverWait(ExpectedConditions.visibilityOf(ri.proceed_Button()));
		webDriverWait(ExpectedConditions.elementToBeClickable(ri.proceed_Button()));
		scrollDownJavaSc(ri.proceed_Button());
		ri.proceed_Button().click();
		rb.delay(3000);

//		Get Gross_Premium
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Gross_Premium()));
		String gross_premium = ra.get_Gross_Premium().getText();
		System.out.println("Gross Premium Amount is: " + gross_premium);

		// Get Discount
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Discount()));
		String discount = ra.get_Discount().getText();
		System.out.println("Discount Value: " + discount);

		// Get Loading
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Loading()));
		scrollDownJavaSc(ra.get_Charge());
		String loading = ra.get_Loading().getText();
		System.out.println("Loading Value: " + loading);

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

//		Get Net To Customer
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
		String Net_To_Customer = ra.Net_to_Customer().getText();
		System.out.println("Net to Customer: " + Net_To_Customer);

//		Get Net Premium
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
		String NetPremium = ra.Net_Premium().getText();
		System.out.println("Net to Customer: " + NetPremium);

//	Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

//Click Continue Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

//		get Qutation Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
		String QuotationNumber = ra.get_Quotation_Number().getText();

		if (QuotationNumber.contains(QuoteNumber)) {
			Assert.assertEquals(Quotation_Number, quote_Number);
			System.out.println("Quotation Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println();
		}

		// get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
		String Customer_name = ra.customer_Name().getText();

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
				//
				// Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
				ra.amount_Field().sendKeys(Net_To_Customer);
			} else if (Cash_Type.equals("CASH")) {

				// Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
				ra.amount_Field().sendKeys(Net_To_Customer);

			}

			// SAve the details
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
			ra.save_Cash_Analysis().click();

		} else if (Mode_Of_Pay.equals("Credit")) {
			webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
			// obj.Insured_Billing_Account().sendKeys(Introducer_Name);
			selectByValue(ra.Insured_Billing_Account(), Insured_Billing_Account);
		}

		// Click Approve as Policy Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
		// ra.approve_Policy_Button().click();
		javaScribtClick(ra.approve_Policy_Button());

		// Click Continue Button
		/*
		 * webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Button())
		 * );
		 */
		/* ra.continue_Button().click(); */
//		get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
		String policyNumber = ra.get_Policy_Number().getText();
		System.out.println("Policy Number is: " + policyNumber);

//		Get Customer Name
		webDriverWait(ExpectedConditions.visibilityOf(ra.customer_Name()));
		String CustomerName = ra.customer_Name().getText();
		System.out.println("Customer Name is: " + CustomerName);

	}

}

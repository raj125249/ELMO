package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.MarinePolicy_Page;
import org.testng.annotations.Test;

public class MOC_Endorsements extends BaseClass {

	public static String Endor_Policy;
	public static String OurShare;

	@Test(dataProvider = "Non_Financial_Endorsement_Reg") 
	public void tc_001(String S_No, String Search_Policy, String Policy_Query, String Query_Policy, String Remarks,
			String Contact_No, String Email_ID, String Address, String Open_Cover_Details, String Annual_TurnOver,
			String Limit_PerShipment, String Incoterms_Add, String CPT_Value, String Incoterms_Edit,
			String Incoterms_Percentage, String Conveyance_Edit, String Conveyance_Add, String ImportsFrom_Del,
			String ImportsFrom_Add, String ImportsTo_Add, String ImportsTo_Del, String Goods_update, String Goods_Del,
			String Goods_Add, String Doc_type, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Non_Financial_Endor, String Change_PolicyPeriod_Endor, String Extension_PolicyPeriod_Endor,
			String Reduction_PolicyPeriod_Endor, String Change_BS_Endor, String Policy_Cancellation_Endor,
			String Policy_Reinstatement_Endor, String Run_Flag)
			throws AWTException, InterruptedException, IOException, ClassNotFoundException, ParseException {

		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Policy_Reg Pol = new Policy_Reg();
		MarinePolicy_Page MP = new MarinePolicy_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Marine_MOC_Policy MOC = new Marine_MOC_Policy();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		if (MOC.MC_Policy_No == null) {
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(get_DB_Data(Policy_Query, Query_Policy));
			String Policy_No = getAtrributeValue(GSP.Policy_Number_Field(), "value");
			System.out.println("Policy Number: " + Policy_No);
		} else {
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(MOC.MC_Policy_No);
			System.out.println("Policy Number: " + MOC.MC_Policy_No);
		}

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();

		// select MOC policy
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
		MP.MOC_Select().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select_Policy()));
		Endor_Policy = MP.MOC_Select_Policy().getText();

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

//		Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: " + Product_Type);

		Thread.sleep(5000);
		webDriverWait(ExpectedConditions.visibilityOf(EIP.Policy_Type()));
		String policy_type = EIP.Policy_Type().getText();
		System.out.println("Policy Type: " + policy_type);

		if (Non_Financial_Endor.equals("Yes")) {

			// Select Endorsement Type
			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Non Financial");

			webDriverWait(ExpectedConditions.visibilityOf(EIP.Org_Policy_Start_Date()));
			String Policy_Start_Date = EIP.Org_Policy_Start_Date().getAttribute("value");
			System.out.println("Policy Start Date: " + Policy_Start_Date);

			webDriverWait(ExpectedConditions.visibilityOf(EIP.Org_Policy_End_Date()));
			String Policy_End_Date = EIP.Org_Policy_End_Date().getAttribute("value");
			System.out.println("Policy End Date: " + Policy_End_Date);

			webDriverWait(ExpectedConditions.visibilityOf(EIP.End_From_Date()));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date startDate = dateFormat.parse(Policy_Start_Date);
			Date endDate = dateFormat.parse(Policy_End_Date);
			// Generate random date between startDate and endDate
			Date randomDate = getRandomDate(startDate, endDate);
			// Format and print random date
			String endfmdate = dateFormat.format(randomDate);
			EIP.End_From_Date().clear();
			EIP.End_From_Date().sendKeys(endfmdate);
			System.out.println("Endrosement from date: " + endfmdate);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			String endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + endorsement_Type);

//			Get Policy Number 
			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
			Endor_Policy = EIP.get_Policy_Number().getText();

//			Get Customer name
			webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
			String customer_Name = EIP.customer_Name().getText();
			String customer = customer_Name.replace(" - ", "-");
			System.out.println("Customer name is: " + customer);

//			Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

//			Enter Contact Details
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Contact_No()));
			EIP.Contact_No().clear();
			EIP.Contact_No().sendKeys(Contact_No);

//			Enter Email ID
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Email_Id()));
			EIP.Email_Id().clear();
			EIP.Email_Id().sendKeys(Email_ID);

//			Change Address
			webDriverWait(ExpectedConditions.visibilityOf(EIP.address_Field()));
			EIP.address_Field().clear();
			EIP.address_Field().sendKeys(Address);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Risk page

			if (policy_type.equals("Marine Open Cover")) {

				if (Open_Cover_Details.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Annual_TurnOver()));
					MP.MOC_Annual_TurnOver().clear();
					MP.MOC_Annual_TurnOver().sendKeys(Annual_TurnOver);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Limit_per_Shipment()));
					MP.MOC_Limit_per_Shipment().clear();
					MP.MOC_Limit_per_Shipment().sendKeys(Limit_PerShipment);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Min_Premium()));
					MP.MOC_Min_Premium().clear();
					MP.MOC_Min_Premium().sendKeys("500");

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Banklist()));
					selectByIndex(MP.MOC_Banklist(), 2);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Save_Risk()));
					MP.MOC_Save_Risk().click();
				}

				if (Incoterms_Add.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Applicable_Incoterms()));
					MP.MOC_Applicable_Incoterms().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CPT_Checkbox()));
					MP.MOC_CPT_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_CPT_Value()));
					MP.MOC_CPT_Value().clear();
					MP.MOC_CPT_Value().sendKeys(CPT_Value);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Save_Close()));
					MP.MOC_Save_Close().click();
				}

				if (Incoterms_Edit.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Incoterms_edit_Button()));
					MP.Incoterms_edit_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Update_Incoterms_Percentage()));
					MP.Update_Incoterms_Percentage().clear();
					MP.Update_Incoterms_Percentage().sendKeys(Incoterms_Percentage);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Update_Incoterms()));
					MP.Update_Incoterms().click();
				}

				if (Conveyance_Add.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Applicable_Conveyance()));
					MP.MOC_Applicable_Conveyance().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ByLand()));
					MP.MOC_ByLand().click();
					rb.delay(2000);
					MP.MOC_Applicable_Conveyance().click();
				}

				if (Conveyance_Edit.equals("Yes")) {
					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Conveyance_Del()));
					MP.Conveyance_Del().click();
				}

				if (ImportsFrom_Add.equals("Yes")) {
					rb.delay(2000);
					scrollUpJavaSc(MP.MOC_ImportsFrm());
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ImportsFrm()));
					doubleClick(MP.MOC_ImportsFrm());
					rb.delay(3000);
					MP.MOC_ImportsFrm().click();

					java.util.List<WebElement> Checkboxes = MP.Add_Port_FM();
					if (Checkboxes.size() > 0) {
						int randomIndex = new Random().nextInt(Checkboxes.size());
						Checkboxes.get(randomIndex).click();
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ImportsFrm()));
					doubleClick(MP.MOC_ImportsFrm());
				}

				rb.delay(3000);
				if (ImportsFrom_Del.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.ImportFm_del()));
					MP.ImportFm_del().click();
				}

				if (ImportsTo_Add.equals("Yes")) {
					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_ExportsTo()));
					JavascriptExecutor JavascriptExecutor = (JavascriptExecutor) driver;
					JavascriptExecutor.executeScript("arguments[0].click();", MP.MOC_ExportsTo());
					doubleClick(MP.MOC_ExportsTo());
					rb.delay(3000);
					// MP.MOC_ExportsTo().click();

					java.util.List<WebElement> Checkboxes = MP.Add_Port_To();
					if (Checkboxes.size() > 0) {
						int randomIndex = new Random().nextInt(Checkboxes.size());
						Checkboxes.get(randomIndex).click();
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_exports()));
					MP.MOC_exports().click();
				}

				if (ImportsTo_Del.equals("Yes")) {
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.ImportTo_Del()));
					MP.ImportTo_Del().click();
				}

				if (Goods_Add.equals("Yes")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods()));
					MP.MOC_Goods().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Foodstuffs()));
					MP.MOC_Foodstuffs().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_FoodStuff_Clauses()));
					selectByIndex(MP.MOC_FoodStuff_Clauses(), 2);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_FoodStuff_Rate()));
					MP.MOC_FoodStuff_Rate().sendKeys("1.5");

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods_Save()));
					MP.MOC_Goods_Save().click();
				}

				if (Goods_update.equals("Yes")) {
					rb.delay(5000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Goods_Update()));
					MP.Goods_Update().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Goods_Rate_Update()));
					MP.Goods_Rate_Update().sendKeys("3");

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Goods_Clauses_Update()));
					selectByIndex(MP.Goods_Clauses_Update(), 2);

					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Goods_Update_close()));
					MP.Goods_Update_close().click();
				}

				if (Goods_Del.equals("Yes")) {
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(MP.Goods_Del()));
					MP.Goods_Del().click();
				}
			}

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

			Thread.sleep(1000);
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			try {
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();
			} catch (Exception e) {
			}

//			Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
			javaScribtClick(EIP.approve_Non_Financial_Endorsement());

//			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
//			Policy_No = EIP.get_Policy().getText();
//			System.out.println("Policy Number is: " + Policy_No);

//			if (policyNumber.contains(Policy_Number)) {
//				Assert.assertEquals(policyNumber, Policy_Number);
//				System.out.println("Policy Number Verification Passed");
//			} else {
//				Assert.fail();
//				System.out.println("Policy Number Verificstion Failed");
//			}

//			Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
			EIP.Close_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Endor_Policy);
			System.out.println("Policy Number is: " + Endor_Policy);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();
//			if (Policy_No.contains(Policy_Number)) {
//				Assert.assertEquals(Policy_No, Policy_Number);
//				System.out.println("Policy Number Verification is Pass");
//			} else {
//				Assert.fail();
//				System.out.println("Policy Number Verification Failed");
//			}

//			Click Policy Details Menu
//			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Details_Menu()));
//			GSP.policy_Details_Menu().click();

		}

		if (Change_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
			MP.MOC_Select().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

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
					GSP.Policy_Number_Field().sendKeys(Endor_Policy, Keys.ENTER);
				}

			} catch (Exception e) {

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + endorsement_Type);

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

				// Risk Edit if needed
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add polinfo page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Policy);
				System.out.println("Policy Number is: " + Endor_Policy);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();
//				if (Policy_No.contains(Policy_Number)) {
//					Assert.assertEquals(Policy_No, Policy_Number);
//					System.out.println("Policy Number Verification is Pass");
//				} else {
//					Assert.fail();
//					System.out.println("Policy Number Verification Failed");
//				}

//				Click Policy Details Menu
//				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Details_Menu()));
//				GSP.policy_Details_Menu().click();

			}
//Change_PolicyPeriod_Endor ends here
		}

		if (Extension_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
			MP.MOC_Select().click();

			rb.delay(3000);
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
			String Endorsement_Type = EIP.get_Endorsement_Type().getText();
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

			// Risk Edit if needed
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// add polinfo page
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

//			Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
			EIP.Close_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Endor_Policy);
			System.out.println("Policy Number is: " + Endor_Policy);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();

		}

		if (Reduction_PolicyPeriod_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
			MP.MOC_Select().click();

			rb.delay(3000);
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
			String Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Risk Edit if needed
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// add polinfo page
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

//			Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
			EIP.Close_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Endor_Policy);
			System.out.println("Policy Number is: " + Endor_Policy);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();

		}

		if (Change_BS_Endor.equals("Yes")) {

			try {
				webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
				MP.MOC_Select().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();
			} catch (Exception e) {
			}

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Change in Source of Business");

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
			String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
			System.out.println("Policy Start Date: " + ActualPolicyStartDate);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
			String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
			System.out.println("Policy End Date: " + ActualPolicyEndDate);

//			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
//			GSP.effective_To_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//			LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
//			LocalDateTime newDate = date.plusDays(-30);
//			String newDateString = newDate.format(formatter1);
//			GSP.effective_To_Date().sendKeys(newDateString);
//			System.out.println("Endorsement Effective to Date: " + newDateString);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			String Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Select the BS type
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Select_BS()));
			Select select = new Select(EIP.Select_BS());
			java.util.List<WebElement> options = select.getOptions();
			Random random = new Random();
			int randomIndex = 1 + random.nextInt(options.size() - 1);
			select.selectByIndex(randomIndex);
			String BS = options.get(randomIndex).getText();
			System.out.println("Selected option: " + BS);

			if (BS.contains("with Elmo Leader")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Coin_Percent()));
				EIP.Coin_Percent().sendKeys("70");
				OurShare = EIP.Coin_Percent().getAttribute("value");
				System.out.println("Coinsurance Ourshare value: " + OurShare);
			} else if (BS.contains("with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Coin_Percent()));
				EIP.Coin_Percent().sendKeys("30");
				OurShare = EIP.Coin_Percent().getAttribute("value");
				System.out.println("Coinsurance Ourshare value: " + OurShare);
			}

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			if (BS.equals("Branches") || BS.equals("Branches with Elmo Leader") || BS.equals("Direct with Elmo Leader")
					|| BS.equals("Direct with Elmo Follower") || BS.equals("Staff with Elmo Leader")
					|| BS.equals("Salesman with Elmo Leader") || BS.equals("Salesman") || BS.equals("Introducers")
					|| BS.equals("Introducers with Elmo Leader") || BS.equals("Staff") || BS.equals("Direct")) {

//				Enter Introducer Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
				cus.introducer_Name_Field().sendKeys("M00");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
				String Introducer = EIP.select_Intoducer().getText();
				EIP.select_Intoducer().click();
				System.out.println("Introducer Name: " + Introducer);

//				Enter Processor Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
				cus.Processor_Name_Field().sendKeys("PROFLIM01");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
				String Processor = EIP.select_processor().getText();
				EIP.select_processor().click();
				System.out.println("Processor Name: " + Processor);

			} else if (BS.equals("Broker with Elmo Leader") || BS.equals("Broker with Elmo Follower")
					|| BS.equals("Broker")) {

//				Enter Introducer Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
				cus.introducer_Name_Field().sendKeys("SPIRINS01");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
				String Introducer = EIP.select_Intoducer().getText();
				EIP.select_Intoducer().click();
				System.out.println("Introducer Name: " + Introducer);

//				Enter Processor Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
				cus.Processor_Name_Field().sendKeys("GERPRIL01");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
				String Processor = EIP.select_processor().getText();
				EIP.select_processor().click();
				System.out.println("Processor Name: " + Processor);

			} else if (BS.equals("Tied Insurance Intermediary with Elmo Leader")
					|| BS.equals("Tied Insurance Intermediary")) {

//				Enter Introducer Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
				cus.introducer_Name_Field().sendKeys("PROFLIM01");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
				String Introducer = EIP.select_Intoducer().getText();
				EIP.select_Intoducer().click();
				System.out.println("Introducer Name: " + Introducer);

//				Enter Processor Name
				webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
				cus.Processor_Name_Field().sendKeys("M0010");
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
				String Processor = EIP.select_processor().getText();
				EIP.select_processor().click();
				System.out.println("Processor Name: " + Processor);
			}

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// enter coinsurance information page

			if (BS.equals("Direct with Elmo Leader") || BS.equals("Direct with Elmo Follower")
					|| BS.equals("Broker with Elmo Leader") || BS.equals("Broker with Elmo Follower")
					|| BS.equals("Salesman with Elmo Leader") || BS.equals("Introducers with Elmo Leader")
					|| BS.equals("Branches with Elmo Leader") || BS.equals("Staff with Elmo Leader")
					|| BS.equals("Tied Insurance Intermediary with Elmo Leader")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.co_Insursance_Menu()));
				apin.co_Insursance_Menu().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
				apin.add_Co_Insurance_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
				apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
				rb.delay(5000);
				apin.select_Coinsurance().click();
				String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
				System.out.println("Coinsurer Name: " + coinsurer);
				rb.delay(3000);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
				apin.coinsurance_Share_Percentage_Field().click();
				int Ourshare = Integer.parseInt(OurShare);
				int coin_share = 100 - Ourshare;
				apin.coinsurance_Share_Percentage_Field().sendKeys(String.valueOf(coin_share), Keys.TAB);
				System.out.println("coinsurer share percentage: " + coin_share);

				if (BS.equals("Direct with Elmo Follower") || BS.equals("Broker with Elmo Follower")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
					apin.Coins_LeaderYN().click();
				}

//				Save Details
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
				apin.Save_Coinsurance_Details().click();

			}

			// add polinfo page
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

//			Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
			EIP.Close_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Endor_Policy);
			System.out.println("Policy Number is: " + Endor_Policy);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();
		}

		if (Policy_Cancellation_Endor.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Select()));
			MP.MOC_Select().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			// Get Product
			webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
			String Product_Type1 = GSP.get_Product().getText();
			System.out.println("Product Type is: " + Product_Type1);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
			selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Policy Cancellation");

			webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
			String Endorsement_Type = EIP.get_Endorsement_Type().getText();
			System.out.println("Endorsement Type is: " + Endorsement_Type);

			// Click Proceed Button
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Enter Remarks
			webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
			EIP.remarks_Field().sendKeys(Remarks);

			// Risk page
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// add pol info page
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
			EIP.proceed_Button().click();

			// Approve Endorsement
			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
			javaScribtClick(EIP.approve_Endorsement_Button());

//			Customer Name Verification
			String customerName = EIP.customer_Name().getText();
			System.out.println("Customer Name is: " + customerName);

			webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
			EIP.Close_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

			// Enter Policy Number
			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Endor_Policy);
			System.out.println("Policy Number is: " + Endor_Policy);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();

		}

		if (Policy_Reinstatement_Endor.equals("Yes")) {
		}

	}
}
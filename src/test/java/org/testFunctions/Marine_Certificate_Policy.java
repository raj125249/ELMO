package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.common.BaseClass;
import org.common.StringHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Approval_Workflow_Page;
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
import org.testng.annotations.Test;

public class Marine_Certificate_Policy extends BaseClass {

	public static String MC_Policy_No;
	public static String MC_Quotation;
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
		Marine_Master_Policy MOC = new Marine_Master_Policy();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.commercial_Underwriting_Button()));
		uwp.commercial_Underwriting_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Marine_Certificate()));
		uwp.Marine_Certificate().click();

		rb.delay(3000);
		if (MOC.MOC_Policy_Number == null) {
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Open_Policy_Number()));
			uwp.Open_Policy_Number().sendKeys(get_DB_Data(MOC_Policy_Query, MOC_Policy));
			javaScribtClick(uwp.Open_Policy_number_click());
		} else {
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Open_Policy_Number()));
			uwp.Open_Policy_Number().sendKeys(MOC.MOC_Policy_Number);
			javaScribtClick(uwp.Open_Policy_number_click());
		}
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.create_Single_Certificate_Button()));
		uwp.create_Single_Certificate_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Marine_Certificate_Quote()));
		MC_Quotation = MP.Marine_Certificate_Quote().getText();
		System.out.println("Marine Certificate Quotation: " + MC_Quotation);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Assured()));
		String MC_Assured = MP.MOC_Assured().getAttribute("value");
		System.out.println("Marine Certificate Assured: " + MC_Assured);

		webDriverWait(ExpectedConditions.visibilityOf(cust.policy_From_Date()));
		String from_Date = getAtrributeValue(cust.policy_From_Date(), "value");
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
		cust.policy_From_Date().clear();
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.policy_From_Date()));
		cust.policy_From_Date().sendKeys(nextDateStr);
		System.out.println("Certificate Policy Start Date: " + nextDateStr);

		webDriverWait(ExpectedConditions.elementToBeClickable(cust.policy_To_Date()));
		Date parse1 = date.parse(nextDateStr);
		calendar.setTime(parse1);
		calendar.add(calendar.DAY_OF_MONTH, 200);
		Date next_date = calendar.getTime();
		String next_date_str = date.format(next_date);
		cust.policy_To_Date().clear();
		cust.policy_To_Date().sendKeys(next_date_str);
		System.out.println("Certificate Policy To Date: " + next_date_str);

		webDriverWait(ExpectedConditions.visibilityOf(cust.Contact_Number_Field()));
		cust.Contact_Number_Field().click();
		cust.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cust.Contact_Number_Field().sendKeys(Keys.DELETE);
		cust.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number = " + Contact_Number);

		webDriverWait(ExpectedConditions.visibilityOf(cust.Types_of_Policy_Dropdown()));
		String BS = cust.Types_of_Policy_Dropdown().getAttribute("value");
		System.out.println("Business Source: " + BS);

		webDriverWait(ExpectedConditions.visibilityOf(cust.Business_Field()));
		cust.Business_Field().sendKeys(Business_Occupation);
		System.out.println("Business/Occupation = " + Business_Occupation);

		webDriverWait(ExpectedConditions.visibilityOf(cust.territorial_Limits()));
		cust.territorial_Limits().sendKeys(Territorial_Limits);
		System.out.println("Territorial Limits = " + Territorial_Limits);

//Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
		cust.proceed_Button().click();
		System.out.println("proceed to Risk info page");

		// enter shipment details
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Declaration_Mon_Year()));
		MP.MOC_Declaration_Mon_Year().click();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime nextDate1 = LocalDateTime.parse(nextDateStr, inputFormatter);
		/* */ LocalDate nextDate = nextDate1.toLocalDate();
		LocalDate nextDay = nextDate.plus(1, ChronoUnit.DAYS);
		// Define the output format (mm/yyyy)
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
		// Format the result
		String MOC_ShipmentDate = nextDay.format(outputFormatter);
		MP.MOC_Declaration_Mon_Year().sendKeys(MOC_ShipmentDate, Keys.TAB);
		System.out.println("Marine Cerificate Shipment Date: " + MOC_ShipmentDate);

		webDriverWait(ExpectedConditions.visibilityOf(MP.Conveyance_Type()));
		selectByIndex(MP.Conveyance_Type(), 1);
		String conveyance = MP.Conveyance_Type().getAttribute("value");
		System.out.println("Marine Certificate conveyance type: " + conveyance);

		webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_Cer_PortsFM()));
		selectByIndex(MP.MOC_Cer_PortsFM(), 1);
		String Portfm = getAtrributeValue(MP.MOC_Cer_PortsFM(), "value");
		System.out.println("Marine ports fm: " + Portfm);

		webDriverWait(ExpectedConditions.visibilityOf(MP.MOC_Cer_PortsTO()));
		selectByIndex(MP.MOC_Cer_PortsTO(), 1);
		String Portto = getAtrributeValue(MP.MOC_Cer_PortsTO(), "value");
		System.out.println("Marine ports fm: " + Portto);

		if (Incoterms.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cer_Incoterms()));
			MP.MOC_Cer_Incoterms().click();
		} else {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cer_Partial_Incoterms()));
			MP.MOC_Cer_Partial_Incoterms().click();
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Marine_LCNO()));
		MP.Marine_LCNO().sendKeys("8987098");

//		rb.delay(3000);
//		if (MI_Bank_YN.equals("Yes")) {
//			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MI_Bank_YN()));
//			MP.MI_Bank_YN().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MI_BankInterest()));
//			selectByVisibleText(MP.MI_BankInterest(), Bank_Name);
//			System.out.println("Bank Interest: " + Bank_Name);
//		}

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Marine_LCNO()));
		MP.Marine_LCNO().sendKeys("8987098");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_shipment_Save()));
		MP.MOC_shipment_Save().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cer_Goods()));
		MP.MOC_Cer_Goods().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods1_Checkbox()));
		MP.MOC_Goods1_Checkbox().click();

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods1_incoterms()));
			selectByIndex(MP.MOC_Goods1_incoterms(), 1);
		} catch (Exception E) {
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods1_SI()));
		MP.MOC_Goods1_SI().sendKeys("100000", Keys.TAB);

		try {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods2_Checkbox()));
			MP.MOC_Goods2_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods2_incoterms()));
			selectByIndex(MP.MOC_Goods2_incoterms(), 1);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Goods2_SI()));
			MP.MOC_Goods2_SI().sendKeys("150000", Keys.TAB);			
		} catch (Exception e) {
		}
		
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.MOC_Cer_Goods_Save()));
		MP.MOC_Cer_Goods_Save().click();
		
		rb.delay(3000);
		driver.findElement(By.xpath("//table[@id='coveragesInfoTbl']//tbody//td[1]")).click();

//Risk Premium and Annual Premium
		rb.delay(2000);
		webDriverWait(ExpectedConditions.visibilityOf(MP.MC_Shipment_AnnualPremium()));
		String annual_Sum_Insured_Premium = MP.MC_Shipment_AnnualPremium().getText();
		System.out.println("Total Risk Annual Premium is: " + annual_Sum_Insured_Premium);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Total_Premium()));
		String RiskPremium = ris.Risk_Total_Premium().getText();
		System.out.println("Total Risk Premium Value is: " + RiskPremium);

//Get Premium Amount
		webDriverWait(ExpectedConditions.visibilityOf(MP.MI_SMIPremium()));
		String SMIPremium = getAtrributeValue(MP.MI_SMIPremium(), "value");
		System.out.println("Total SMI premium value is: " + SMIPremium);

		rb.delay(2000);
//Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(MP.MC_SMI_AnnualPRemium()));
		String SMI_Annual_Premium = MP.MC_SMI_AnnualPRemium().getText();
		System.out.println("SMI Annual Premium Amount is: " + SMI_Annual_Premium);

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		System.out.println("Proceed to add pol info page");

// add pol info page
		try {
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);
		} catch (Exception e) {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			javaScribtClick(apin.Policy_Discounts_Loadings_Panel());

			rb.delay(3000);
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fee is: " + policy_Fees);
		}

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		javaScribtClick(apin.Add_Policy_DL());

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
		javaScribtClick(apin.Add_Policy_DL());

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
		javaScribtClick(apin.Add_Policy_DL());

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
		if (CLP.Loginuser.contains("Juan Siracusa")) {

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

		// Add Insured
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Additional_Insured_Menu()));
		apin.Additional_Insured_Menu().click();

//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
//		apin.Add_Additional_Insured().click();
//
//		if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
//				|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
//			selectByVisibleText(apin.Split_YN(), Split_YN);
//			System.out.println("Split invoice is: " + Split_YN);
//			rb.delay(5000);
//
//			webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
//			apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
//			rb.delay(2000);
//			apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
//			apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
////					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Select_Add_Insured_Name()));
////					apin.Select_Add_Insured_Name().click();
//			String AddInsured = getAtrributeValue(apin.Yes_AddInsured_Name(), "value");
//			System.out.println("Add Insured Name :" + AddInsured);
//
//			webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Billing_Account()));
//			rb.delay(3000);
//			selectByIndex(apin.Add_Ins_Billing_Account(), 1);
//			String AddIns_BillAcct = getAtrributeValue(apin.Add_Ins_Billing_Account(), "value");
//			System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);
//
//		} else if ((Split_YN.equals("No")) && (Business_Source.equals("Direct") || Business_Source.equals("Broker")
//				|| Business_Source.equals("Salesman") || Business_Source.equals("Introducers")
//				|| Business_Source.equals("Branches") || Business_Source.equals("Staff")
//				|| Business_Source.equals("Direct with Elmo Leader")
//				|| Business_Source.equals("Broker with Elmo Leader")
//				|| Business_Source.equals("Broker with Elmo Follower")
//				|| Business_Source.equals("Direct with Elmo Follower")
//				|| Business_Source.equals("Salesman with Elmo Leader")
//				|| Business_Source.equals("Introducers with Elmo Leader")
//				|| Business_Source.equals("Branches with Elmo Leader")
//				|| Business_Source.equals("Staff with Elmo Leader")
//				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")
//				|| Business_Source.equals("Tied Insurance Intermediary"))) {
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
//			selectByVisibleText(apin.Split_YN(), Split_YN);
//			System.out.println("Split invoice is:" + Split_YN);
//			rb.delay(5000);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(apin.No_AddInsured_Name()));
//			apin.No_AddInsured_Name().sendKeys("John");
//			String AddInsname = getAtrributeValue(apin.No_AddInsured_Name(), "value");
//			System.out.println("Add Insured Name: " + AddInsname);
//		}
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.Insured_Type()));
//		selectByVisibleText(apin.Insured_Type(), Ins_Type);
//		System.out.println("Add Insured Type: " + Ins_Type);
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Id_Types()));
//		if (apin.Add_Ins_Id_Types() == null) {
//			selectByVisibleText(apin.Add_Ins_Id_Types(), AddIns_IDType);
//			System.out.println("AddIns ID Type: " + AddIns_IDType);
//		} else {
//			String AddInsID = getAtrributeValue(apin.Add_Ins_Id_Types(), "value");
//			System.out.println("AddIns ID Type: " + AddInsID);
//		}
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Id_No()));
//		if (apin.AddIns_Id_No() == null) {
//			apin.AddIns_Id_No().sendKeys(AddIns_IdNo);
//			System.out.println("AddIns ID No: " + AddIns_IdNo);
//		} else {
//			String AddInsIDNo = getAtrributeValue(apin.AddIns_Id_No(), "value");
//			System.out.println("AddIns ID No: " + AddInsIDNo);
//		}
//
//		rb.delay(5000);
//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Ins_Mobile_No()));
//		apin.Add_Ins_Mobile_No().click();
////				if (obj11.Add_Ins_Mobile_No() == null) {
//		apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
//		// System.out.println("Add Ins Mobile No: " + AddIns_MobileNo);
////				}else{
//		String AddIns_MobNum1 = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
//		System.out.println("Add Ins Mobile No: " + AddIns_MobNum1);
////				}
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_PO_Box()));
//		apin.AddIns_PO_Box().click();
//		if (apin.AddIns_PO_Box() == null) {
//			apin.AddIns_PO_Box().sendKeys(AddIns_POBox);
//			System.out.println("AddIns PO Box: " + AddIns_POBox);
//		} else {
//			String PO_Box = getAtrributeValue(apin.AddIns_PO_Box(), "value");
//			System.out.println("AddIns PO Box: " + PO_Box);
//		}
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Email_Id()));
//		apin.AddIns_Email_Id().click();
//		String EmailID1 = getAtrributeValue(apin.AddIns_Email_Id(), "value");
//		// if (EmailID == null) {
//		apin.AddIns_Email_Id().sendKeys(AddIns_EmailID);
//		System.out.println("AddIns Email Id: " + AddIns_EmailID);
//		// }else {
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Relation()));
//		selectByVisibleText(apin.AddIns_Relation(), Add_Ins_Relation);
//		System.out.println("AddIns Relation: " + Add_Ins_Relation);
//
//		webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Address()));
//		apin.AddIns_Address().click();
//		// if (obj11.AddIns_Address() == null) {
//		apin.AddIns_Address().sendKeys(Add_Ins_Address);
//		// System.out.println("AddIns Address: " + Add_Ins_Address);
//		// }else {
//		String AddIns_Add1 = getAtrributeValue(apin.AddIns_Address(), "value");
//		System.out.println("AddIns Address: " + AddIns_Add1);
//		// }
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.get_AddIns_Save()));
//		apin.get_AddIns_Save().click();
//		System.out.println("Add Insured Details saved successfully");

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
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Get the current date
		LocalDate currentDate1 = LocalDate.now();

		// Add one day to the current date to get the next date
		LocalDate nextDate11 = currentDate1.plusDays(8);

		// Format the next date to the desired format
		String formattedNextDate1 = nextDate11.format(formatter1);
		apin.Survey_Date().sendKeys(formattedNextDate1, Keys.TAB);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));
		// Create a Select object for the dropdown
		Select dropdown1 = new Select(apin.Surveyor_Name());
		// Get all the options in the dropdown
		List<WebElement> SurveyorName1 = dropdown1.getOptions();
		// Filter out the option that contains the text "Select"
		List<WebElement> validOptions1 = new ArrayList<>();
		for (WebElement option : SurveyorName1) {
			if (!option.getText().toLowerCase().contains("select")) {
				validOptions1.add(option);
			}
		}
		// Check if valid options exist
		if (!validOptions1.isEmpty()) {
			// Pick a random index from the valid options list
			Random random = new Random();
			int randomIndexOfSurveyorName = random.nextInt(validOptions1.size());
			// Select the random option
			dropdown1.selectByIndex(SurveyorName1.indexOf(validOptions1.get(randomIndexOfSurveyorName)));
			// Print the selected option (optional)
			String selectedSurveyor = validOptions1.get(randomIndexOfSurveyorName).getText();
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
		StringSelection ss2 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
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
		// scrollDownJavaSc(ris.Policy_Document_Dropdown());
		webDriverWait(ExpectedConditions.visibilityOf(apin.Policy_Document_Dropdown()));
		selectByVisibleText(apin.Policy_Document_Dropdown(), Doc_type);

		rb.delay(7000);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.upload_File()));
		apin.upload_File().click();
		StringSelection ss12 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss12, null);
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
		System.out.println("Procced to RI ceding page");

//Certificate Generation starts

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

//include FAC in policy

		if (CLP.Loginuser.contains("Juan Siracusa") && Add_FAC.equals("Yes")) {

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

		} else if (CLP.Loginuser.contains("Juan Siracusa") && Add_FAC.equals("No")) {
		}

		scrollDownJavaSc(apin.proceed_Button());
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		javaScribtClick(apin.proceed_Button());
		System.out.println("Proceed to Summary Page");

		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		// get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quote_Number()));
		String quoteNumber = ris.get_Quote_Number().getText();
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
		// scrollDownJavaSc(ra.get_Charge());
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

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

		// click continue button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

		try {
			// get Qutation Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
			MC_Quotation = ra.get_Quotation_Number().getText();
			System.out.println("Finalized Quotation: " + MC_Quotation);

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
			ra.Quote_Number_Field().sendKeys(MC_Quotation);

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
					MOC.RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(MOC.RI_Password);

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
					ra.search_Enq_Field().sendKeys(MC_Quotation);

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

					webDriverWait(ExpectedConditions.visibilityOf(AWF.RI_Confirmed_Msg()));
					String RI_APP_Msg = AWF.RI_Confirmed_Msg().getText();
					System.out.println("RI Confirmed Msg: " + RI_APP_Msg);

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
					ra.logout_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//					Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
					ra.Quote_Number_Field().sendKeys(MC_Quotation);

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

					MOC.username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					MOC.App_User = get_DB_Data(MOC.username_Query, "TC_RESP_USER_ID");
					MOC.WF_Description = get_DB_Data(MOC.username_Query, "WF_DESC");

					MOC.password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + MOC.App_User
							+ "') USER_PASSWORD FROM DUAL";
					MOC.App_Password = get_DB_Data(MOC.password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(MOC.App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(MOC.App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MOC.MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MOC.MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (MOC.WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("Claims WF Section: " + MOC.WF_Description);
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
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Quote_Number_Field().sendKeys(MC_Quotation);

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
		driver.navigate().refresh();

// 		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_PrintDocs_Close()));
//		javaScribtClick(GSP.Quote_Search_PrintDocs_Close());
		rb.delay(3000);

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
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
			ra.approve_Policy_Button().click();

			try {
				// Click RA Slip Approve as Policy Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
				javaScribtClick(ra.approve_Policy_Button());

				// get policy number
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
				MC_Policy_No = ra.get_Policy_Number().getText();
				System.out.println("Policy Number is: " + MC_Policy_No);

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
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Policy_Close()));
				ra.Summary_Quotation_Policy_Close().click();

				// Click Global Search Button
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(MC_Policy_No);

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

					MOC.username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					MOC.App_User = get_DB_Data(MOC.username_Query, "TC_RESP_USER_ID");
					MOC.WF_Description = get_DB_Data(MOC.username_Query, "WF_DESC");

					MOC.password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + MOC.App_User
							+ "') USER_PASSWORD FROM DUAL";
					MOC.App_Password = get_DB_Data(MOC.password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(MOC.App_User);
					System.out.println(MOC.App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(MOC.App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (MOC.WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("2nd level WF Section: " + MOC.WF_Description);
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
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Quote No");

					// Search Policy via Quotation.
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(MC_Quotation);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.PolicyNo_Query()));
					MC_Policy_No = GSP.PolicyNo_Query().getText();
					System.out.println("Policy Number is: " + MC_Policy_No);

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

			if (GSP.FAC_Not_Closed().isDisplayed()) {

				if (CLP.Login_User_Name.equals("Juan Siracusa")) {

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
//			Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//				Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Allocation_Menu()));
					ra.RI_Allocation_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_PolicyNo()));
					ra.RI_FAC_PolicyNo().sendKeys(MC_Policy_No, Keys.TAB);
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
				GSP.Policy_Number_Field().sendKeys(MC_Policy_No);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

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

//Approve Policy Close point
		}

	}
}
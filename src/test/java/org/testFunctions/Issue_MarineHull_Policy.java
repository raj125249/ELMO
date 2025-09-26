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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.common.StringHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Approval_Workflow_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.MarinePolicy_Page;
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Issue_MarineHull_Policy extends BaseClass {

	public static String annual_Sum_Insured_Premium;
	public static String OurSI;
	public static String policy_Type;
	public static String Risk_TODate;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static String USER;
	public static String Password;
	public static String Policy_Number;
	public static String RI_Password;
	public static String Quote_Number;
	public static List<WebElement> MyAction;

	@Test(dataProvider = "Marine_Hull")

	public void tc_001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Insured_Query, String Insured_ID, String Quotation_Validity_Days,
			String Co_Insurance_Share_Percentage, String Coverage_Type, String Sum_Insured_Currency,
			String Premium_Currency, String Contact_Number, String Business_Occupation, String Territorial_Limits,
			String Demands_Needs, String Introducer_Name, String Processor_Name, String Risk_Description,
			String Location, String Type_Boat, String vessel_regNo, String Brand, String Model_Make, String Make_Year,
			String Type_Of_Usage, String NavigationLimits, String Measuring_Unit, String Inward_SI,
			String Inward_Premium, String Period_Type, String SumInsured_Value, String Sum_Insured_Rate,
			String Policy_Discount, String Policy_Discount_Rate, String Policy_Loading, String Policy_Loading_Rate,
			String Policy_Deductible, String Policy_Deductible_Calctype, String Policy_Deductible_RateValue,
			String Coinsurer_Name_Query, String Coinsurer_ID, String Coinsurer_Share, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Doc_type, String Special_Tty, String RI_Ceding_Basic,
			String Add_FAC, String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String FAC_Participant, String RI_Status, String Approve_Policy, String Run_Flag)
			throws AWTException, IOException, ClassNotFoundException, InterruptedException {

//pages included		
		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		PersonalUW_Login PLP = new PersonalUW_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();
		MarinePolicy_Page MP = new MarinePolicy_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cust = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();

// Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		// Click Personal Underwriting
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Personal_Underwriting_Button()));
		uwp.Personal_Underwriting_Button().click();
		rb.delay(3000);

		// Click Marine Hull
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Marine_Hull()));
		uwp.Marine_Hull().click();

//Customer info page

		// insured name
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Insured_Code_Field()));
		cust.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_insured()));
		javaScribtClick(cust.select_insured());

		// Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(cust.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(cust.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

		// Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(cust.Business_Source_Dropdown()));
		selectByVisibleText(cust.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source: " + Business_Source);

		// Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(cust.Types_of_Policy_Dropdown()));
		selectByVisibleText(cust.Types_of_Policy_Dropdown(), Types_of_Policy);

		// select Coverage type
		webDriverWait(ExpectedConditions.visibilityOf(MP.Hull_Coverage_Type()));
		selectByVisibleText(MP.Hull_Coverage_Type(), Coverage_Type);
		System.out.println("Coverage Type is: " + Coverage_Type);

//		Enter Contact Number		
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.Contact_Number_Field()));
		cust.Contact_Number_Field().clear();
		cust.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number = " + Contact_Number);

//		Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(cust.Business_Field()));
		cust.Business_Field().sendKeys(Business_Occupation);
		System.out.println("Business/Occupation: " + Business_Occupation);

//		Territorial limits
		webDriverWait(ExpectedConditions.visibilityOf(cust.territorial_Limits()));
		cust.territorial_Limits().sendKeys(Territorial_Limits);
		System.out.println("Territorial Limits = " + Territorial_Limits);

//		Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.introducer_Name_Field()));
		cust.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_Intoducer()));
		cust.select_Intoducer().click();
		System.out.println("Introducer Name = " + Introducer_Name);

//		Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cust.Processor_Name_Field()));
		cust.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.select_processor()));
		cust.select_processor().click();
		System.out.println("Processor Name = " + Processor_Name);

//Demands and Needs
		if (Demands_Needs.equals("Yes")) {
			MP.DN_PowerBoat_No().click();
			MP.DN_MalteseIsland_No().click();
			MP.DN_BoatTP_No().click();
			MP.DN_Mediterrian_No().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
			cust.proceed_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DN_AlertMSG()));
			String DN_AlertMsg = MP.DN_AlertMSG().getText();
			System.out.println("Demands and needs WF MSG: " + DN_AlertMsg);

			webDriverWait(ExpectedConditions.elementToBeClickable(cust.Cust_QuoteNo()));
			Quote_Number = cust.Cust_QuoteNo().getAttribute("value");
			System.out.println("Quotation Number: " + Quote_Number);
			System.out.println("WF is generated for Demands and Needs");

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 4, 1));

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 4, 2));

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(5000);
			String user_Profile_Name1 = LP.User_Profile_Name().getText();
			System.out.println("User Profile Name is: " + user_Profile_Name1);

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.My_Action_Tab()));
			uwp.My_Action_Tab().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(AWF.Demands_Needs_ActionsTab()));
			AWF.Demands_Needs_ActionsTab().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Actions_Search()));
			uwp.Actions_Search().sendKeys(Quote_Number, Keys.ENTER);
			rb.delay(2000);

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Approval_Remarks()));
			uwp.Approval_Remarks().sendKeys("Testing");

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.WF_ApprovalButton()));
			uwp.WF_ApprovalButton().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(ReadExcelData.readExcel("Login", 3, 1));

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(ReadExcelData.readExcel("Login", 3, 2));

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(5000);
			String user_Profile_Name11 = LP.User_Profile_Name().getText();
			System.out.println("User Profile Name is: " + user_Profile_Name11);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
			GSP.Policy_Number_Field().sendKeys(Quote_Number, Keys.ENTER);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Edit()));
			GSP.Quote_Edit().click();
		} else if (Demands_Needs.equals("No")) {
			MP.DN_PowerBoat_No().click();
			MP.DN_MalteseIsland_Yes().click();
			MP.DN_BoatTP_No().click();
			MP.DN_Mediterrian_No().click();
		}

		scrollDownJavaSc(cust.proceed_Button());
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
		cust.proceed_Button().click();

//Risk Info page
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Description_Field()));
		ris.risk_Description_Field().sendKeys(Risk_Description);

//		Enter Location
		webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
		ris.Location_Field().sendKeys(Location);

		rb.delay(2000);
		// Click Longitude Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
		ris.find_Latitude().click();

		rb.delay(7000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
		javaScribtClick(ris.ok_Button());
		System.out.println("Location saved successfully");
		String Locality = ris.Location_Field().getAttribute("value");
		System.out.println("Location text: " + Locality);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Boat_Type()));
		selectByVisibleText(MP.Boat_Type(), Type_Boat);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Vessel_RegNo()));
		MP.Vessel_RegNo().sendKeys(vessel_regNo);

//		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Brand()));
//		MP.Brand().sendKeys(Brand);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Make_Model()));
		MP.Make_Model().sendKeys(Model_Make);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Year_make()));
		MP.Year_make().sendKeys(Make_Year);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Usage_Type()));
		selectByVisibleText(MP.Usage_Type(), Type_Of_Usage);
		System.out.println("Type of usage: " + Type_Of_Usage);

		if (Type_Of_Usage.equals("Commercial") || Type_Of_Usage.equals("Water Sports")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.No_Of_Passengers()));
			MP.No_Of_Passengers().sendKeys("20");
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Navigation_Limit()));
		selectByVisibleText(MP.Navigation_Limit(), NavigationLimits);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Measuring_unit()));
		selectByVisibleText(MP.Measuring_unit(), Measuring_Unit);
		System.out.println("Measuring unit is: " + Measuring_Unit);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Hull_length()));
		MP.Hull_length().sendKeys("4.8800");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Beam_Hull()));
		MP.Beam_Hull().sendKeys("20");

//inward calculations	

		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

			// 100% and Our SI & Premium value
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
			ris.Risk_Inward_SI().sendKeys(Inward_SI, Keys.TAB);
			System.out.println("Inward SI Value:" + Inward_SI);

			rb.delay(3000);
			webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurSI()));
			OurSI = getAtrributeValue(ris.Risk_Inward_OurSI(), "value");
			System.out.println("Inward Our SI value:" + OurSI);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
			ris.Risk_Inward_Premium().sendKeys(Inward_Premium, Keys.TAB);
			System.out.println("Inward Premium Value: " + Inward_Premium);

			rb.delay(3000);
			webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurPremium()));
			String OurPremium = getAtrributeValue(ris.Risk_Inward_OurPremium(), "Value");
			System.out.println("Inward our Premium Value:" + OurPremium);
		}
//		Click save Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

//		Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);
		
//		Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		Quote_Number = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + Quote_Number);

//		get Insured name 
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		// Add Engine Details
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Risk_Engine()));
		MP.Risk_Engine().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Add_Period_Tender_Engine()));
		MP.Add_Period_Tender_Engine().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine1_Checkbox()));
		MP.Engine1_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_Make()));
		MP.Engine_Make().sendKeys("Machine");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_Model()));
		MP.Engine_Model().sendKeys("2012");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_Manufacture_Year()));
		MP.Engine_Manufacture_Year().sendKeys("2015");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_SerialNo()));
		MP.Engine_SerialNo().sendKeys("97657657");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_Fuel()));
		MP.Engine_Fuel().sendKeys("Petrol");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Engine_Capacity()));
		MP.Engine_Capacity().sendKeys("45");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Save()));
		MP.Save().click();

		// Add Tender Details
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Risk_Tender()));
		MP.Risk_Tender().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Add_Period_Tender_Engine()));
		MP.Add_Period_Tender_Engine().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_Checkbox()));
		MP.Tender_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_Type()));
		selectByIndex(MP.Tender_Type(), 2);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_value()));
		MP.Tender_value().sendKeys("500000");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_Make()));
		MP.Tender_Make().sendKeys("2021");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_Model()));
		MP.Tender_Model().sendKeys("2023");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_Make_Year()));
		MP.Tender_Make_Year().sendKeys("2023");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_EngineMake()));
		MP.Tender_EngineMake().sendKeys("2023");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Tender_HP()));
		MP.Tender_HP().sendKeys("43");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Save()));
		MP.Save().click();

		// Add Period Details
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Risk_Period()));
		MP.Risk_Period().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Add_Period_Tender_Engine()));
		MP.Add_Period_Tender_Engine().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type_Checkbox()));
		javaScribtClick(MP.Period_type_Checkbox());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type()));
		selectByVisibleText(MP.Period_type(), Period_Type);
		System.out.println("Period Type is: " + Period_Type);

//		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_garaged()));
//		Select dropdown = new Select(MP.Period_type1_garaged());
//		List<WebElement> Periodtype = dropdown.getOptions();
//		List<WebElement> validOptions = new ArrayList<>();
//		for (WebElement option : Periodtype) {
//			if (!option.getText().toLowerCase().contains("select")) {
//				validOptions.add(option);
//			}
//		}
//		if (!validOptions.isEmpty()) {
//			Random random = new Random();
//			int randomIndexOfPeriodType = random.nextInt(validOptions.size());
//			dropdown.selectByIndex(Periodtype.indexOf(validOptions.get(randomIndexOfPeriodType)));
//			String PeriodType = validOptions.get(randomIndexOfPeriodType).getText();
//			System.out.println("Period Type: " + PeriodType);
//		}
		if (Period_Type.equals("Garaged after each and every use")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_Location()));
			selectByIndex(MP.Period_type1_Location(), 3);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_fmdt()));
			MP.Period_type1_fmdt().sendKeys("10-JAN");

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_todt()));
			MP.Period_type1_todt().sendKeys("30-MAR");

		} else if (Period_Type.equals("In-Commission")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_Location()));
			selectByIndex(MP.Period_type1_Location(), 2);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_fmdt()));
			MP.Period_type1_fmdt().sendKeys("10-JAN");

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_todt()));
			MP.Period_type1_todt().sendKeys("30-MAR");

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_Commission_type()));
			selectByIndex(MP.Period_type1_Commission_type(), 2);

		} else if (Period_Type.equals("LaidUp")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Laidup_Location()));
			MP.Laidup_Location().sendKeys("Malta");

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_fmdt()));
			MP.Period_type1_fmdt().sendKeys("10-JAN");

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.Period_type1_todt()));
			MP.Period_type1_todt().sendKeys("30-MAR");
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Save()));
		MP.Save().click();
		
		
		rb.delay(3000);
//		Click risk Check box
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
		ris.risk_Check_Box().click();

//		Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
		ris.Add_SMI_Button().click();

		// Add SMI details
		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_Checkbox()));
			MP.DeathSMI_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_SIvalue()));
			MP.DeathSMI_SIvalue().sendKeys(Keys.CONTROL + "a");
			MP.DeathSMI_SIvalue().sendKeys(Keys.DELETE);
			MP.DeathSMI_SIvalue().sendKeys(SumInsured_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_Rate()));
			MP.DeathSMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);
		} else {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(MP.SMI_HULL_Checkbox()));
			javaScribtClick(MP.SMI_HULL_Checkbox());

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.SMI_Hull_SI_Value()));
			MP.SMI_Hull_SI_Value().sendKeys(Keys.CONTROL + "a");
			MP.SMI_Hull_SI_Value().sendKeys(Keys.DELETE);
			MP.SMI_Hull_SI_Value().sendKeys(SumInsured_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_Checkbox()));
			MP.DeathSMI_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_SIvalue()));
			MP.DeathSMI_SIvalue().sendKeys(Keys.CONTROL + "a");
			MP.DeathSMI_SIvalue().sendKeys(Keys.DELETE);
			MP.DeathSMI_SIvalue().sendKeys(SumInsured_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.DeathSMI_Rate()));
			MP.DeathSMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MedicalPayments_CheckBox()));
			MP.MedicalPayments_CheckBox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MedicalPayments_SI_Value()));
			MP.MedicalPayments_SI_Value().sendKeys(Keys.CONTROL + "a");
			MP.MedicalPayments_SI_Value().sendKeys(Keys.DELETE);
			MP.MedicalPayments_SI_Value().sendKeys(SumInsured_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(MP.MedicalPayments_SI_Rate()));
			MP.MedicalPayments_SI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

		}
		// Save Sum Insured Details
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

// Risk Premium and Annual Premium
		rb.delay(2000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.Total_Risk_Annual_Premium()));
		annual_Sum_Insured_Premium = ris.Total_Risk_Annual_Premium().getText();
		System.out.println("Total Risk Annual Premium is: " + annual_Sum_Insured_Premium);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Total_Premium()));
		String RiskPremium = ris.Risk_Total_Premium().getText();
		System.out.println("Total Risk Premium Value is: " + RiskPremium);

//		Get Premium Amount
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Premium_Field()));
		String SMIPremium = getAtrributeValue(ris.SMI_Premium_Field(), "value");
		System.out.println("Total SMI premium value is: " + SMIPremium);

		rb.delay(2000);
//		Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		String SMI_Annual_Premium = ris.SMI_Annual_Premium().getText();
		System.out.println("SMI Annual Premium Amount is: " + SMI_Annual_Premium);

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {
		}

		rb.delay(3000);
//		click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();
		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {
		}

		System.out.println("Proceed to Add Pol info page");

//Add pol info page
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("FAC approve text: " + alertText);
			acceptAlert();
		} catch (Exception e) {
		}
		try {
			rb.delay(2000);
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fee is: " + policy_Fees);

		} catch (Exception e) {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			javaScribtClick(apin.Policy_Discounts_Loadings_Panel());
			try {
				webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
				String policy_Fees = apin.get_Policy_Fees().getText();
				System.out.println("Policy Fees is: " + policy_Fees);
			} catch (Exception e1) {
			}
		}
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		javaScribtClick(apin.Add_Policy_DL());

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Discount);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Discount_Checkbox()));
		MP.Policy_Discount_Checkbox().click();

//		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Discount_Rate()));
//		MP.Policy_Discount_Rate().sendKeys(Policy_Discount_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Discont_Value()));
		MP.Policy_Discont_Value().sendKeys("25");

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		// Add Policy Loadings
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Loading);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Loading_Checkbox()));
		MP.Policy_Loading_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Loading_Rate()));
		MP.Policy_Loading_Rate().sendKeys(Policy_Loading_Rate, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		// Add Policy Deductibles
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
		apin.Add_Policy_DL().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
		selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Deductible);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Deductible_Checkbox()));
		MP.Policy_Deductible_Checkbox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Deductible_Caltype()));
		selectByVisibleText(MP.Policy_Deductible_Caltype(), Policy_Deductible_Calctype);

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Policy_Deductible_Rate()));
		MP.Policy_Deductible_Rate().sendKeys(Policy_Deductible_RateValue, Keys.TAB);

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
		apin.Policy_DL_Save_Button().click();

		rb.delay(5000);
//Coinsurance Section
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

//			Get Total Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Premium_FC()));
			String Total_Premium_FC = apin.get_Total_Premium_FC().getText();
			double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
			System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

//			Get Our Share
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Share()));
			String text2 = apin.get_Our_Share().getText();
			double ourshare = string_To_double_Convert(text2);

			double premium = Total_Premium_Amount * ourshare / 100;
			String Premium_Amount = String.format("%.2f", premium);
			System.out.println("Our Premium Amount is: " + Premium_Amount);

//			get Our Premium
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

//			Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
			apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
			apin.select_Coinsurance().click();
			String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
			System.out.println("Coinsurer Name: " + coinsurer);
			rb.delay(3000);

//			Enter Share
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
			apin.coinsurance_Share_Percentage_Field().click();
			apin.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share, Keys.TAB);
			rb.delay(3000);

			if (Business_Source.equals("Direct with Elmo Follower")
					|| Business_Source.equals("Broker with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
				apin.Coins_LeaderYN().click();
			}

//			Save Details
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
			apin.Save_Coinsurance_Details().click();

//			Get Insurer Premium
			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
			scrollDownJavaSc(apin.co_Insurer_Share_Premium());
			String text5 = apin.co_Insurer_Share_Premium().getText();
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

//Add Insured Details 
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
			rb.delay(5000);

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
//				if (obj31.Add_Ins_Mobile_No() == null) {
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
		// if (obj31.AddIns_Address() == null) {
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

//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Surveyor_Name()));
//		apin.Surveyor_Name().sendKeys(get_DB_Data(Add_Surveyor_Query, Add_Surveyor_ID));
//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Select_Surveyor_Name()));
//		apin.Select_Surveyor_Name().click();
//		String SurveyorName = getAtrributeValue(apin.Surveyor_Name(), "value");
//		System.out.println("Surveyor Name: " + SurveyorName);

		webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));
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
			Random Surveyorname = new Random();
			int randomIndexOfSurveyorName = Surveyorname.nextInt(validOptions.size());
			// Select the random option
			dropdown.selectByIndex(SurveyorName.indexOf(validOptions.get(randomIndexOfSurveyorName)));
			String Surveyor_Name = validOptions.get(randomIndexOfSurveyorName).getText();
			System.out.println("Surveyor Name: " + Surveyor_Name);
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
		javaScribtClick(apin.Terms_Conditions_Checkbox());
		
//		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox1()));
//		apin.Terms_Conditions_Checkbox1().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
		apin.Save_Terms_Conditions().click();

//General Questions.

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(MP.pleasure_purposes_yes()));
		javaScribtClick(MP.pleasure_purposes_yes());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.years_of_experience()));
		MP.years_of_experience().sendKeys("5 years");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Boat_license()));
		javaScribtClick(MP.Boat_license());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.boat_handling()));
		MP.boat_handling().sendKeys("Driving");

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Owner_Craft()));
		javaScribtClick(MP.Owner_Craft());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Craft_CurrentlyConvicted()));
		javaScribtClick(MP.Craft_CurrentlyConvicted());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Craft_lost_5years()));
		javaScribtClick(MP.Craft_lost_5years());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Craft_Cancelled()));
		javaScribtClick(MP.Craft_Cancelled());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Sustain_Damages()));
		javaScribtClick(MP.Sustain_Damages());

		webDriverWait(ExpectedConditions.elementToBeClickable(MP.Craft_Converted()));
		javaScribtClick(MP.Craft_Converted());

		rb.delay(3000);

		// Policy Documents Upload
		scrollDownJavaSc(apin.Policy_Document_Dropdown());
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
		webDriverWait(ExpectedConditions.elementToBeClickable(cust.proceed_Button()));
		javaScribtClick(cust.proceed_Button());
		System.out.println("Proceed to RI Ceding Page");

		rb.delay(3000);

		try {

			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("FAC approve text: " + alertText);
			acceptAlert();

		} catch (Exception e) {

		}

//RI Ceding page
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

//		Select RI Ceding Basis 
		webDriverWait(ExpectedConditions.visibilityOf(ri.select_RI_ceding_Basis()));
		selectByVisibleText(ri.select_RI_ceding_Basis(), RI_Ceding_Basic);

//		include FAC in policy

		if (PLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			ri.Prop_FAC().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Placement_CheckBox()));
			ri.FAC_Placement_CheckBox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
			ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
			ri.Save_Add_Participant().click();
			System.out.println("FAC Participant Name = " + FAC_Participant);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Share_Percentage()));
			ri.FAC_Participant_Share_Percentage().sendKeys(FAC_Participant_Share_Percentage_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Save_Close()));
			ri.FAC_Participant_Save_Close().click();

		} else if (PLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("No")) {
		}

//		Click Proceed
		rb.delay(3000);
		webDriverWait(ExpectedConditions.visibilityOf(ri.proceed_Button()));
		scrollDownJavaSc(ri.proceed_Button());
		ri.proceed_Button().click();

//RA slip Summary page		
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

		try {
			// Get Net Premium
			webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
			String NetPremium = ra.Net_Premium().getText();
			System.out.println("Net to Customer: " + NetPremium);
		} catch (Exception e) {
		}

		// Click Finalize quote_Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.finalize_Quote_Button()));
		ra.finalize_Quote_Button().click();

		// click continue button
		webDriverWait(ExpectedConditions.elementToBeClickable(ra.continue_Quote_Button()));
		ra.continue_Quote_Button().click();

		try {
			// get Qutation Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.get_Quotation_Number()));
			Quote_Number = ra.get_Quotation_Number().getText();
			System.out.println("Finalized Quotation: " + Quote_Number);

//			// RA Slip Quotation print Docs
//			rb.delay(3000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_PrintDocs()));
//			ra.Summary_Quotation_PrintDocs().click();
//			rb.delay(3000);
//
//			List<WebElement> listCheckBox = ra.Summary_Quotation_Checkbox();
//			System.out.println("Print document List: " + listCheckBox.size());
//			for (int i = 0; i < listCheckBox.size(); i++) {
//				listCheckBox.get(i).click();
//			}
//			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Quotation_Print()));
//			ra.Summary_Quotation_Print().click();
//			Set<String> window = driver.getWindowHandles();
//			String parentWindowHandle = driver.getWindowHandle();
//			for (String handle : window) {
//				driver.switchTo().window(handle);
//				if (!(handle.equals(parentWindowHandle))) {
//					System.out.println(driver.getTitle());
//					// driver.close();
//				}
//			}
//			driver.switchTo().window(parentWindowHandle);
//					
//			webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quote_Print_Close()));
//			ra.Quote_Print_Close().click();
//			System.out.println("All the print docs printed successful");

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
			javaScribtClick(ra.global_Search_Button());
			// Enter Quote Number
			webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
			ra.Quote_Number_Field().sendKeys(Quote_Number);

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
					String RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(RI_Password);

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
					ra.search_Enq_Field().sendKeys(Quote_Number);

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
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
					javaScribtClick(ra.global_Search_Button());
//					Enter Quote Number
					webDriverWait(ExpectedConditions.visibilityOf(ra.Quote_Number_Field()));
					ra.Quote_Number_Field().sendKeys(Quote_Number);

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

					username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
					WF_Description = get_DB_Data(username_Query, "WF_DESC");

					password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
							+ "') USER_PASSWORD FROM DUAL";
					App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("Claims WF Section: " + WF_Description);
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
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Quote_Number_Field().sendKeys(Quote_Number);

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
		System.out.println("SYSO");
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
				rb.delay(3000);
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
			javaScribtClick(ra.approve_Policy_Button());

			try {
				// Click RA Slip Approve as Policy Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
				javaScribtClick(ra.approve_Policy_Button());

				// get policy number
				webDriverWait(ExpectedConditions.visibilityOf(ra.get_Policy_Number()));
				Policy_Number = ra.get_Policy_Number().getText();
				System.out.println("Policy Number is: " + Policy_Number);

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
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_Print_close()));
				ra.Summary_Policy_Print_close().click();

				// Click Global Search Button
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Policy_Number);

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

					username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
							+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
					App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
					WF_Description = get_DB_Data(username_Query, "WF_DESC");

					password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
							+ "') USER_PASSWORD FROM DUAL";
					App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
					LP.username_Field().sendKeys(App_User);
					System.out.println(App_User);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
					LP.password_Field().sendKeys(App_Password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
					WFA.Clm_Myactions_Tab().click();

					MyAction = WFA.Clm_MyAction_SubSection();

					for (WebElement MyAction_Section : MyAction) {
						String SubsectionText = MyAction_Section.getText().trim();

						if (WF_Description.equals(SubsectionText)) {
							MyAction_Section.click();
							System.out.println("2nd level WF Section: " + WF_Description);
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
					LP.username_Field().sendKeys(PLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(PLP.Loginuser_password);

					webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
					LP.login_Button().click();

					rb.delay(2000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), "Quote No");

					// Search Policy via Quotation.
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Quote_Number);

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.PolicyNo_Query()));
					Policy_Number = GSP.PolicyNo_Query().getText();
					System.out.println("Policy Number is: " + Policy_Number);

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
							//driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
					GSP.Policy_Print_Close().click();
				}
			}
			rb.delay(3000);

			try {
				if (GSP.FAC_Not_Closed().isDisplayed()) {

					if (PLP.Login_User_Name.equals("Juan Siracusa")) {

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
//				Click Menu Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
						ra.menu_Button().click();

//					Click RI Confirmation Log
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
					GSP.Policy_Number_Field().sendKeys(Policy_Number);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
				}
				
			} catch (Exception e) {	}
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
					//driver.close();
				}
			}
			driver.switchTo().window(parentWindowHandler);
			System.out.println("View Accounting Docs generated successfully");
			
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.VW_Back_Policy()));
			GSP.VW_Back_Policy().click();

//Approve Policy Close point
		}

	}
}
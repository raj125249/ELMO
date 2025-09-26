package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.common.BaseClass;
import org.common.StringHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import org.pages.Underwritting_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Policy_Reg extends BaseClass {

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
	public static String Policy_Number;
	public static String RI_Password;
	//public static String Floatingtype;
	public static List<WebElement> MyAction;
	public static List<WebElement> checkboxes;
	public static String Net_To_Customer;
	public static String Mode_Of_Pay;

	@Test(dataProvider = "Issue_Policy_Reg")
	public void tc_001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Floatingtype, String Floating_Policy, String Insured_Query, String Insured_ID,
			String Quotation_Validity_Days, String Co_Insurance_Share_Percentage, String Sum_Insured_Currency,
			String Premium_Currency, String Contact_Number, String Business_Occupation, String Territorial_Limits,
			String Product_Type, String Indeminity_Field, String Material_Policy_Damage_Number, String Introducer_Name,
			String Processor_Name, String Risk_Description, String Occupancy_Type, String Description,
			String Risk_Catagory, String Location, String Cyber_Risk, String Limit_Per_AOA, String Select_Reference,
			String Inward_SI, String Inward_Premium, String Multiple_Risk, String Multiple_SMI,
			String Sum_Insured_Amount, String Sum_Insured_Rate, String Sum_Insured_Premium, String SMI_Discount,
			String SMI_Loadings, String Discount_Rate, String Loading_Rate, String Policy_Discount,
			String Policy_Discount_Rate, String Policy_Loading, String Policy_Loading_Rate, String Policy_Deductible,
			String Policy_Deductible_Calctype, String Policy_Deductible_RateValue, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Surveyor, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Coinsurer_Share, String Doc_type, String Special_Tty, String RI_Ceding_Basic, String Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String Approve_Policy, String Policy_Endorsements, String Non_Financial_Endors, String Financial_Endors,
			String Change_Policy_Endors, String Extension_Policy_Endors, String Reduction_Policy_Endors,
			String FAC_Endors, String Discount_Loadings_Endors, String Policy_Cancellation_Endors,
			String Policy_Reinstatement_Endors, String PO_Box_Numer, String Address, String Edit_SI_Value,
			String Edit_SI_Rate, String Add_Risk, String Add_Risk_SI, String Add_SMI, String Del_Risk, String Del_SMI,
			String Edit_SMI, String Financial_Add_FAC, String Run_Flag)
			throws IOException, InterruptedException, AWTException, ClassNotFoundException, ParseException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Commercial_Login CLP = new Commercial_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();

//Underwriting page

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.CI_Menu()));
		javaScribtClick(uwp.CI_Menu());

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		javaScribtClick(uwp.menu_Button());

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.commercial_Underwriting_Button()));
		javaScribtClick(uwp.commercial_Underwriting_Button());

		if (Policy_Type.equals("Fire Commercial")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Fire_Commercial_Menu()));
			javaScribtClick(uwp.Fire_Commercial_Menu());
		} else if (Policy_Type.equals("Liability Commercial")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Liability_Commercial_Menu()));
			uwp.Liability_Commercial_Menu().click();
		} else if (Policy_Type.equals("Engineering Commercial")) {
			// Click Liability Commercial
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Engineering_Commercial_Menu()));
			uwp.Engineering_Commercial_Menu().click();
		} else if (Policy_Type.equals("Accident Commercial")) {
			// Click Accident Commercial
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Accident_Commercial_Menu()));
			uwp.Accident_Commercial_Menu().click();
		}

//Customer Info page
//		Enter Insured Name
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Insured_Code_Field()));
		cus.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_insured()));
		cus.select_insured().click();

//		Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(cus.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(cus.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

//		Enter Quotation Validity Days
//		webDriverWait(ExpectedConditions.visibilityOf(obj.quotation_Valid_Days()));
//		obj.quotation_Valid_Days().clear();
//		obj.quotation_Valid_Days().sendKeys(Quotation_Validity_Days);

//		Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(cus.Business_Source_Dropdown()));
		selectByVisibleText(cus.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source: " + Business_Source);

//		Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(cus.Types_of_Policy_Dropdown()));
		selectByVisibleText(cus.Types_of_Policy_Dropdown(), Types_of_Policy);

//		Enter Co-insurance share percentage
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {
			webDriverWait(ExpectedConditions.visibilityOf(cus.co_insurance_Share_Percentage()));
			cus.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
			System.out.println("Co-Insurance share percentage: " + Co_Insurance_Share_Percentage);
		}

//		Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(cus.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

//		Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Premium_Currency_Dropdown()));
		selectByVisibleText(cus.Premium_Currency_Dropdown(), Premium_Currency);

//		Enter Contact Number		
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Contact_Number_Field()));
		cus.Contact_Number_Field().click();
		cus.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cus.Contact_Number_Field().sendKeys(Keys.DELETE);
		cus.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number: " + Contact_Number);

//		if (Policy_Type.equals("Fire Commercial") && Floating_Policy.equals("Yes")) {
//			webDriverWait(ExpectedConditions.elementToBeClickable(cus.Floating_Policy_Type()));
//			selectByVisibleText(cus.Floating_Policy_Type(), Floatingtype);
//			System.out.println("Floating type is: " + Floatingtype);

//			webDriverWait(ExpectedConditions.elementToBeClickable(objec.Floating_Policy_Type()));
//			Select dropdownValues = new Select(objec.Floating_Policy_Type());
//			List<WebElement> Floating_Policy = dropdownValues.getOptions();
//			Random randomFloatingpolicytype = new Random();
//			int randomIndexFloatingtype = randomFloatingpolicytype.nextInt(Floating_Policy.size());
//			dropdownValues.selectByIndex(randomIndexFloatingtype);
//			WebElement Floatingtypevalue = dropdownValues.getFirstSelectedOption();
//			Floatingtype = Floatingtypevalue.getText();
//			System.out.println("Selected Floating Type: " + Floatingtype);
//
//			if (Floatingtype.equals("Declaration Policy") || Floatingtype.equals("Floating with Declaration Policy")) {
//				webDriverWait(ExpectedConditions.elementToBeClickable(objec.Declaration_Frequency()));
//				Select dropdown = new Select(objec.Declaration_Frequency());
//				List<WebElement> Declaration_Frequency_Dropdown = dropdown.getOptions();
//				List<WebElement> validOptions = new ArrayList<>();
//				for (WebElement option : Declaration_Frequency_Dropdown) {
//					if (!option.getText().toLowerCase().contains("select")) {
//						validOptions.add(option);
//					}
//				}
//				if (!validOptions.isEmpty()) {
//					Random randomDeclarationFrequency = new Random();
//					int randomIndexOfDeclarationFrequency = randomDeclarationFrequency.nextInt(validOptions.size());
//					dropdown.selectByIndex(Declaration_Frequency_Dropdown
//							.indexOf(validOptions.get(randomIndexOfDeclarationFrequency)));
//					String Frequncy = validOptions.get(randomIndexOfDeclarationFrequency).getText();
//					System.out.println("Declaration Frequency: " + Frequncy);
//				}
//			}
//		}

//		Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(cus.Business_Field()));
		cus.Business_Field().sendKeys(Business_Occupation);
		System.out.println("Business/Occupation: " + Business_Occupation);

//		select Territorial Limit
		if (Policy_Type.equals("Accident Commercial")) {
			webDriverWait(ExpectedConditions.visibilityOf(cus.territorial_Limits()));
			cus.territorial_Limits().sendKeys(Territorial_Limits);
			System.out.println("Territorial Limits: " + Territorial_Limits);
		}

//		Select Product Type
		// if (Policy_Type.equals("Engineering Commercial")
		// && !(Types_of_Policy.equals("Plant and Equipment All Risks Insurance"))) {
		webDriverWait(ExpectedConditions.visibilityOf(cus.product_Type_Dropdown()));
		selectByVisibleText(cus.product_Type_Dropdown(), Product_Type);
		System.out.println("Product type: " + Product_Type);
//		}

//		select indemnity validation
		if (Types_of_Policy.equals("Business Interruption Insurance") || Types_of_Policy.equals("SME Package Insurance")
				|| Types_of_Policy.equals("Hotel Plan Insurance")
				|| Types_of_Policy.equals("Engineering BI Insurance")) {

			webDriverWait(ExpectedConditions.visibilityOf(cus.indeminity_Field()));
			cus.indeminity_Field().sendKeys(Indeminity_Field);
			System.out.println("Indemnity Field: " + Indeminity_Field);

			// rb.delay(3000);
//			webDriverWait(ExpectedConditions.visibilityOf(objec.indeminity_Period_Unit_Dropdown()));
//			selectByVisibleText(objec.indeminity_Period_Unit_Dropdown(), );
//			System.out.println("Indemnity Period Unit Dropdown = " +);

			webDriverWait(ExpectedConditions.visibilityOf(cus.indeminity_Period_Unit_Dropdown()));
			Select dropdown = new Select(cus.indeminity_Period_Unit_Dropdown());
			List<WebElement> Indeminity_Period_Unit_Dropdown = dropdown.getOptions();
			List<WebElement> validOptions = new ArrayList<>();
			for (WebElement option : Indeminity_Period_Unit_Dropdown) {
				if (!option.getText().toLowerCase().contains("select")) {
					validOptions.add(option);
				}
			}
			if (!validOptions.isEmpty()) {
				Random randomIndemnity_Unit = new Random();
				int randomIndexOfIndemnityUnit = randomIndemnity_Unit.nextInt(validOptions.size());
				dropdown.selectByIndex(
						Indeminity_Period_Unit_Dropdown.indexOf(validOptions.get(randomIndexOfIndemnityUnit)));
				String Indemnity_Period_Unit = validOptions.get(randomIndexOfIndemnityUnit).getText();
				System.out.println("Indemnity Period Unit Value is: " + Indemnity_Period_Unit);
			}
			webDriverWait(ExpectedConditions.visibilityOf(cus.material_Policy_Damage_Number()));
			cus.material_Policy_Damage_Number().sendKeys(Material_Policy_Damage_Number);
			System.out.println("Material Policy Damage Number: " + Material_Policy_Damage_Number);
		}

//		Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
		cus.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_Intoducer()));
		cus.select_Intoducer().click();
		System.out.println("Introducer Name: " + Introducer_Name);

//		Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
		cus.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_processor()));
		cus.select_processor().click();
		System.out.println("Processor Name: " + Processor_Name);

//		Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.proceed_Button()));
		cus.proceed_Button().click();
		System.out.println("proceed to Risk info page");

// Risk info page. 

//		Enter Risk Description
		rb.delay(5000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
		ris.risk_Description_Field().sendKeys(Risk_Description);

		if (Types_of_Policy.equals("Erection All Risks") || Types_of_Policy.equals("Contractors All Risks Insurance")) {
			webDriverWait(ExpectedConditions.visibilityOf(ris.select_reference()));
			selectByVisibleText(ris.select_reference(), Select_Reference);
			System.out.println("Select reference: " + Select_Reference);

			webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
			ris.Contractor_Name().sendKeys("Site Engineer");
		}

		if (Types_of_Policy.equals("Contract Works Insurance")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.PA_Permit_No()));
			ris.PA_Permit_No().sendKeys("7865464");
		}

		// Risk Effective fm date
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Effec_FMDT()));
		String Risk_FMDate = ris.Risk_Effec_FMDT().getAttribute("value");
		System.out.println("Risk effective from date: " + Risk_FMDate);

		// Risk Effective to date
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Effec_TODT()));
		Risk_TODate = ris.Risk_Effec_TODT().getAttribute("value");
		System.out.println("Risk effective to date: " + Risk_TODate);

//		Select description																									
		webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
		selectByVisibleText(ris.description_Dropdown(), Description);
		System.out.println("Description: " + Description);

//		Enter Location
		webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
		ris.Location_Field().sendKeys(Location);
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Location_List()));
		ris.Location_List().click();

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

		policy_Type = Policy_Type;

		switch (policy_Type) {
		case "Professional Indemnity Insurance":
//			Enter Limit Per AOA
			webDriverWait(ExpectedConditions.visibilityOf(ris.Limit_Per_AOA_Field()));
			ris.Limit_Per_AOA_Field().sendKeys(Limit_Per_AOA);
			break;
		case "Fire Commercial":
//			Select Cyber Risk
			webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
			selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
			break;
		case ("Electronic Equipment Insurance"):
//			Select Cyber Risk
			webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
			selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
			break;
		default:
			break;
		}

		if (Types_of_Policy.equals("Deterioration of Stock Insurance")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Description_Of_Goods()));
			ris.Description_Of_Goods().sendKeys("Testing");
		}

		if (Types_of_Policy.equals("Professional Indemnity Insurance")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Limit_Type()));
			selectByIndex(ris.Limit_Type(), 1);
		}

//		if (Types_of_Policy.equals("Contractors All Risks Insurance")) {
//			webDriverWait(ExpectedConditions.elementToBeClickable(obj.Maintenance_Period_FD()));
//			obj.Maintenance_Period_FD().click();
//			keyPress(KeyEvent.VK_CONTROL);
//			keyPress(KeyEvent.VK_A);
//			keyRelease(KeyEvent.VK_CONTROL);
//			keyRelease(KeyEvent.VK_A);
//
//			keyPress(KeyEvent.VK_BACK_SPACE);
//			keyRelease(KeyEvent.VK_BACK_SPACE);
//
//			SimpleDateFormat inpuFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
//			SimpleDateFormat outFormat = new SimpleDateFormat("dd/mm/yyyy");
//
////			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			// Get Risk eff to date
//
//			Date date = (Date) inpuFormat.parse(Risk_TODate);
//			String Main_FMDate = outFormat.format(date);
//
//			obj.Maintenance_Period_FD().sendKeys(Main_FMDate, Keys.TAB);
//			String Maintenance_Start_Date = obj.Maintenance_Period_FD().getAttribute("value");
//			System.out.println("Maintenance start date: " + Maintenance_Start_Date);
//		} else {
//				}

//Inward formation section

		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

//100% and Our SI & Premium value 
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
			String OurPremium = getAtrributeValue(ris.Risk_Inward_OurPremium(), "value");
			System.out.println("Inward our Premium Value:" + OurPremium);
		}

//		Click save Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
		ris.save_Button().click();

//		Get Risk Success Msg
		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Success_Msg()));
		String risk_Success_Msg = ris.Risk_Success_Msg().getText();
		System.out.println("Risk Success Msg is: " + risk_Success_Msg);

//		Get Quote Number
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Quote_Number()));
		Quote_Number = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + Quote_Number);

//		Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Type_of_Policy()));
		String type_of_Policy = ris.get_Type_of_Policy().getText();
		System.out.println("Type of Policy is: " + type_of_Policy);

//		get Insured name 
		webDriverWait(ExpectedConditions.visibilityOf(ris.get_Insured_Name()));
		String insured_Name = ris.get_Insured_Name().getText();
		System.out.println("Insured Name is: " + insured_Name);

		rb.delay(3000);
//		Click risk Check box
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
		ris.risk_Check_Box().click();

//		Click Add SMI Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
		ris.Add_SMI_Button().click();

		rb.delay(3000);
		// uncheck the check boxes
		try {

			checkboxes = ris.SMI_CheckBox_Uncheck();
			for (WebElement checked : checkboxes) {
				if (checked.isSelected()) {
					checked.click();
				}
			}

		} catch (Exception e) {
		}

// Add SMI details
		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {
			if (Policy_Type.equals("Fire Commercial") && Floating_Policy.equals("Yes")) {

				if ((Floatingtype.equals("Floating Policy"))
						&& (!Types_of_Policy.equals("Business Interruption Insurance"))) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_SMI_Checkbox()));
					javaScribtClick(ris.FloatingYN_SMI_Checkbox());

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().click();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(OurSI);
					System.out.println("SI value: " + OurSI);

					webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
					ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_Checkbox()));
					ris.FloatingYN_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_SMI_Default_Checkbox()));
					ris.FloatingYN_SMI_Default_Checkbox().click();

				} else if (Floatingtype.equals("Declaration Policy")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_Checkbox()));
					javaScribtClick(ris.DeclarationYN_SMI_Checkbox());

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_SI_Value()));
					ris.DeclarationYN_SMI_SI_Value().click();
					doubleClick(ris.DeclarationYN_SMI_SI_Value());
					ris.DeclarationYN_SMI_SI_Value().sendKeys(OurSI, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_Rate_Value()));
					ris.DeclarationYN_SMI_Rate_Value().sendKeys(Sum_Insured_Rate, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Checkbox()));
					ris.DeclarationYN_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Deposit_Percentage()));
					ris.DeclarationYN_Deposit_Percentage().clear();
					ris.DeclarationYN_Deposit_Percentage().sendKeys("10", Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Min_Percentage()));
					ris.DeclarationYN_Min_Percentage().clear();
					ris.DeclarationYN_Min_Percentage().sendKeys("10", Keys.TAB);

				} else if (Floatingtype.equals("Floating with Declaration Policy")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SMI_Checkbox()));
					javaScribtClick(ris.Floating_Declaration_SMI_Checkbox());

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SI_Value()));
					ris.Floating_Declaration_SI_Value().click();
					doubleClick(ris.Floating_Declaration_SI_Value());
					ris.Floating_Declaration_SI_Value().sendKeys(OurSI, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SMI_Rate()));
					ris.Floating_Declaration_SMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

					try {
						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_DefaultYN_Checkbox()));
						ris.Floating_Declaration_DefaultYN_Checkbox().click();

						webDriverWait(ExpectedConditions
								.elementToBeClickable(ris.Floating_Declaration_FloatingYN_Checkbox()));
						ris.Floating_Declaration_FloatingYN_Checkbox().click();

						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_Deposit_Percentage()));
						ris.Floating_Declaration_Deposit_Percentage().clear();
						ris.Floating_Declaration_Deposit_Percentage().sendKeys("10", Keys.TAB);

						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_Minimum_Percentage()));
						ris.Floating_Declaration_Minimum_Percentage().clear();
						ris.Floating_Declaration_Minimum_Percentage().sendKeys("10", Keys.TAB);
					} catch (Exception e) {
					}
				}

			}

			else {

				// Enter SMI check box Details conditions to be handled
				rb.delay(2000);
				// if (!Types_of_Policy.equals("Business Interruption Insurance")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
				ris.Inward_OurSMI_Checkbox().click();
				// }
				// Enter SI value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
				ris.Inward_OurSMI_SI().click();
				doubleClick(ris.Inward_OurSMI_SI());
				ris.Inward_OurSMI_SI().sendKeys(OurSI);
				System.out.println("Inward Our SI value: " + OurSI);

				// Enter rate value.
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
				ris.Inward_OurSMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

			}
			// Save Sum Insured Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

		} else {

			if (Floating_Policy.equals("Yes")) {

				if ((Floatingtype.equals("Floating Policy"))
						&& (!Types_of_Policy.equals("Business Interruption Insurance"))) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_SMI_Checkbox()));
					ris.FloatingYN_SMI_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().click();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
					System.out.println("SI value: " + Sum_Insured_Amount);

					webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
					ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_Checkbox()));
					ris.FloatingYN_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.FloatingYN_SMI_Default_Checkbox()));

					ris.FloatingYN_SMI_Default_Checkbox().click();

				} else if (Floatingtype.equals("Declaration Policy")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_Checkbox()));
					javaScribtClick(ris.DeclarationYN_SMI_Checkbox());

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_SI_Value()));
					ris.DeclarationYN_SMI_SI_Value().click();
					doubleClick(ris.DeclarationYN_SMI_SI_Value());
					ris.DeclarationYN_SMI_SI_Value().sendKeys(Sum_Insured_Amount, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_SMI_Rate_Value()));
					ris.DeclarationYN_SMI_Rate_Value().sendKeys(Sum_Insured_Rate, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Checkbox()));
					ris.DeclarationYN_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Deposit_Percentage()));
					ris.DeclarationYN_Deposit_Percentage().clear();
					ris.DeclarationYN_Deposit_Percentage().sendKeys("10", Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.DeclarationYN_Min_Percentage()));
					ris.DeclarationYN_Min_Percentage().clear();
					ris.DeclarationYN_Min_Percentage().sendKeys("10", Keys.TAB);

				} else if (Floatingtype.equals("Floating with Declaration Policy")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SMI_Checkbox()));
					ris.Floating_Declaration_SMI_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SI_Value()));
					ris.Floating_Declaration_SI_Value().click();
					doubleClick(ris.Floating_Declaration_SI_Value());
					ris.Floating_Declaration_SI_Value().sendKeys(Sum_Insured_Amount, Keys.TAB);

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_SMI_Rate()));
					ris.Floating_Declaration_SMI_Rate().click();
					ris.Floating_Declaration_SMI_Rate().sendKeys(Sum_Insured_Rate, Keys.TAB);

					try {
						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_DefaultYN_Checkbox()));
						ris.Floating_Declaration_DefaultYN_Checkbox().click();

						webDriverWait(ExpectedConditions
								.elementToBeClickable(ris.Floating_Declaration_FloatingYN_Checkbox()));
						ris.Floating_Declaration_FloatingYN_Checkbox().click();

						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_Deposit_Percentage()));
						ris.Floating_Declaration_Deposit_Percentage().clear();
						ris.Floating_Declaration_Deposit_Percentage().sendKeys("10", Keys.TAB);

						webDriverWait(
								ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_Minimum_Percentage()));
						ris.Floating_Declaration_Minimum_Percentage().clear();
						ris.Floating_Declaration_Minimum_Percentage().sendKeys("10", Keys.TAB);
					} catch (Exception e) {
					}
				}
			} else {
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
				javaScribtClick(ris.Sum_Insured_checkbox());

				// Enter SI value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
				ris.sum_Insured_Field().click();
				doubleClick(ris.sum_Insured_Field());
				ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
				System.out.println("SI value: " + Sum_Insured_Amount);

				// Enter rate value.
				rb.delay(2000);
				webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
				ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				if (Types_of_Policy.equals("Erection All Risks")) {
//					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//					rb.delay(3000);
//					ris.professional_Fees_Rate_per().click();
//					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
//					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				}
			}
			rb.delay(1000);
			// Save Sum Insured Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

			// Add Discounts and Loadings to the SMI
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Icon()));
			ris.SMI_DL_Icon().click();

			try {

				// Add SMI Discounts
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.oi_add_SMI_DL()));
				ris.oi_add_SMI_DL().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Dropdown()));
				selectByVisibleText(ris.SMI_DL_Dropdown(), SMI_Discount);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Checkbox()));
				ris.SMI_Discount_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Rate()));
				ris.SMI_Discount_Rate().sendKeys(Discount_Rate, Keys.TAB);

				scrollDownJavaSc(ris.SMI_Discount_Loadings_Save());
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Save()));
				ris.SMI_Discount_Loadings_Save().click();

				// Add SMI Loadings
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.oi_add_SMI_DL()));
				ris.oi_add_SMI_DL().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Dropdown()));
				selectByVisibleText(ris.SMI_DL_Dropdown(), SMI_Loadings);

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Loading_Checkbox()));
				ris.SMI_Loading_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Loading_Rate()));
				ris.SMI_Loading_Rate().sendKeys(Loading_Rate, Keys.TAB);

				scrollDownJavaSc(ris.SMI_Discount_Loadings_Save());
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Save()));
				ris.SMI_Discount_Loadings_Save().click();
				rb.delay(3000);

				// Close SMI Loadings and discounts details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Close()));
				ris.SMI_Discount_Loadings_Close().click();

			} catch (Exception e) {

				// Close SMI Loadings and discounts details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_Discount_Loadings_Close()));
				ris.SMI_Discount_Loadings_Close().click();

			}

			if (Multiple_SMI.contains("Yes")) {

				// Click risk Check box
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
				ris.risk_Check_Box().click();

				// Click Add SMI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
				ris.Add_SMI_Button().click();

				try {

					checkboxes = ris.SMI_CheckBox_Uncheck();
					for (WebElement checked : checkboxes) {
						if (checked.isSelected()) {
							checked.click();
						}
					}

				} catch (Exception e) {
				}

				// Floating and Decalration need to act in the place

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
				ris.Sum_Insured_checkbox().click();

				// Enter SI value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
				ris.sum_Insured_Field().click();
				doubleClick(ris.sum_Insured_Field());
				ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
				System.out.println("SI value: " + Sum_Insured_Amount);

				// Enter rate value.
				webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
				ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				if (Types_of_Policy.equals("Erection All Risks")) {
//					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//					rb.delay(3000);
//					ris.professional_Fees_Rate_per().click();
//					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
//					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				}

				rb.delay(1000);
				// Save Sum Insured Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();
			}

// Multiple risk
			if (Multiple_Risk.equals("Yes")) {
				rb.delay(2000);
				scrollUpJavaSc(ris.Add_Risk_Button());
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_Button()));
				ris.Add_Risk_Button().click();

//			Enter Risk Description
				rb.delay(3000);
				webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
				ris.risk_Description_Field().sendKeys(Risk_Description + "2");

				if (Types_of_Policy.equals("Erection All Risks")
						|| Types_of_Policy.equals("Contractors All Risks Insurance")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.select_reference()));
					selectByVisibleText(ris.select_reference(), Select_Reference);
					System.out.println("Select reference: " + Select_Reference);

					webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
					ris.Contractor_Name().sendKeys("Site Engineer");
				}

				if (Types_of_Policy.equals("Contract Works Insurance")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.PA_Permit_No()));
					ris.PA_Permit_No().sendKeys("7865464");
				}

				// Select Occupancy Type
				// webDriverWait(ExpectedConditions.visibilityOf(obj.Occupancy_Dropdown()));
				// selectByVisibleText(obj.Occupancy_Dropdown(), Occupancy_Type);

//			Select description																									
				webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
				selectByVisibleText(ris.description_Dropdown(), Description);
				webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
				ris.Location_Field().sendKeys(Location);

				rb.delay(2000);
				// Click Longitude Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
				ris.find_Latitude().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
				javaScribtClick(ris.ok_Button());

				policy_Type = Policy_Type;

				switch (policy_Type) {
				case "Liability Commercial":
//						Enter Limit Per AOA
					webDriverWait(ExpectedConditions.visibilityOf(ris.Limit_Per_AOA_Field()));
					ris.Limit_Per_AOA_Field().sendKeys(Limit_Per_AOA);
					break;
				case "Fire Commercial":
//						Select Cyber Risk
					webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
					selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
					break;
				case "Electronic Equipment Insurance":
//						Select Cyber Risk
					webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
					selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
					break;
				default:
					break;
				}

//			if (Types_of_Policy.equals("Contractors All Risks Insurance")) {
//				webDriverWait(ExpectedConditions.elementToBeClickable(obj.Maintenance_Period_FD()));
//				obj.Maintenance_Period_FD().click();
//				keyPress(KeyEvent.VK_CONTROL);
//				keyPress(KeyEvent.VK_A);
//				keyRelease(KeyEvent.VK_CONTROL);
//				keyRelease(KeyEvent.VK_A);
//				keyPress(KeyEvent.VK_BACK_SPACE);
//				keyRelease(KeyEvent.VK_BACK_SPACE);
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//				// Get Risk eff to date
//				LocalDate xDate;
//				try {
//					xDate = LocalDate.parse(Risk_TODate, formatter);
//				} catch (DateTimeParseException e) {
//					e.printStackTrace();
//					return;
//				}
//				LocalDate nextdate = xDate.plusDays(1);
//				String Main_FMDate = nextdate.format(formatter);
//				obj.Maintenance_Period_FD().sendKeys(Main_FMDate, Keys.TAB);
//			}else {
//		}
				// Inward formation section
//					if (Business_Source.equals("Broker with Elmo Follower")
//							|| Business_Source.equals("Direct with Elmo Follower")) {
//						// 100% and Our SI & Premium value
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj.Risk_Inward_SI()));
//						obj.Risk_Inward_SI().sendKeys(Inward_SI, Keys.TAB);
//						System.out.println("Inward SI Value: " + Inward_SI);
//						rb.delay(3000);
//						// webDriverWait(ExpectedConditions.visibilityOf(obj.Risk_Inward_OurSI()));
//						OurSI = getAtrributeValue(obj.Risk_Inward_OurSI(), "value");
//						System.out.println("Inward Our SI value: " + OurSI);
//						webDriverWait(ExpectedConditions.elementToBeClickable(obj.Risk_Inward_Premium()));
//						obj.Risk_Inward_Premium().sendKeys(Inward_Premium, Keys.TAB);
//						System.out.println("Inward Premium Value: " + Inward_Premium);
//						rb.delay(3000);
//						// webDriverWait(ExpectedConditions.visibilityOf(obj.Risk_Inward_OurPremium()));
//						String OurPremium = getAtrributeValue(obj.Risk_Inward_OurPremium(), "value");
//						System.out.println("Inward our Premium Value: " + OurPremium);
//					}
//					Click save Button
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_save_Button()));
				ris.Add_Risk_save_Button().click();
				// javaScribtClick(obj.save_Button());

//			Get Risk Success Msg
				webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Success_Msg()));
				String risk_Success = ris.Risk_Success_Msg().getText();
				System.out.println("Risk Success Msg is: " + risk_Success);

				rb.delay(3000);
//			Click risk Check box
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box2()));
				ris.risk_Check_Box2().click();

//			Click Add SMI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
				ris.Add_SMI_Button().click();

				try {

					checkboxes = ris.SMI_CheckBox_Uncheck();
					for (WebElement checked : checkboxes) {
						if (checked.isSelected()) {
							checked.click();
						}
					}

				} catch (Exception e) {
				}

//			Enter SMI check box Details	conditions to be handled
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
				ris.Sum_Insured_checkbox().click();

//			Enter Sum Insured Amount
				if (Business_Source.equals("Broker with Elmo Follower")
						|| Business_Source.equals("Direct with Elmo Follower")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().click();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(OurSI);
					System.out.println("Inward Our SI value: " + OurSI);
				} else {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
					ris.sum_Insured_Field().click();
					doubleClick(ris.sum_Insured_Field());
					ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
					System.out.println("SI value: " + Sum_Insured_Amount);
				}

//			Enter Sum Insured Rate
				webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
				ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				if (Types_of_Policy.equals("Erection All Risks")) {
//					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//					rb.delay(3000);
//					ris.professional_Fees_Rate_per().click();
//					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
//					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//				}

				rb.delay(1000);

//			Save Sum Insured Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();

				// Add Discounts and Loadings to the SMI
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_DL_Icon()));
//					obj.SMI_DL_Icon().click();
//					// Add SMI Discounts
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.oi_add_SMI_DL()));
//					obj.oi_add_SMI_DL().click();
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_DL_Dropdown()));
//					selectByVisibleText(obj.SMI_DL_Dropdown(), SMI_Discount);
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Discount_Checkbox()));
//					obj.SMI_Discount_Checkbox().click();
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Discount_Rate()));
//					obj.SMI_Discount_Rate().sendKeys(Discount_Rate, Keys.TAB);
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Discount_Loadings_Save()));
//					obj.SMI_Discount_Loadings_Save().click();
				//
//					// Add SMI Loadings
				//
//					rb.delay(2000);
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.oi_add_SMI_DL()));
//					obj.oi_add_SMI_DL().click();
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_DL_Dropdown()));
//					selectByVisibleText(obj.SMI_DL_Dropdown(), SMI_Loadings);
				//
//					rb.delay(5000);
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Loading_Checkbox()));
//					obj.SMI_Loading_Checkbox().click();
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Loading_Rate()));
//					obj.SMI_Loading_Rate().sendKeys(Loading_Rate, Keys.TAB);
				//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Discount_Loadings_Save()));
//					obj.SMI_Discount_Loadings_Save().click();
//					rb.delay(3000);
				//
//					// Close SMI Loadings and discounts details
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj.SMI_Discount_Loadings_Close()));
//					obj.SMI_Discount_Loadings_Close().click();

				if (Multiple_SMI.contains("Yes")) {

//					 	Click risk Check box
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box2()));
					javaScribtClick(ris.risk_Check_Box2());

//				Click Add SMI Button
					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
					ris.Add_SMI_Button().click();

					try {

						checkboxes = ris.SMI_CheckBox_Uncheck();
						for (WebElement checked : checkboxes) {
							if (checked.isSelected()) {
								checked.click();
							}
						}

					} catch (Exception e) {
					}

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
					ris.Sum_Insured_checkbox().click();
					rb.delay(3000);

//					Enter Sum Insured Amount
					if (Business_Source.equals("Broker with Elmo Follower")
							|| Business_Source.equals("Direct with Elmo Follower")) {

						webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
						ris.sum_Insured_Field().click();
						doubleClick(ris.sum_Insured_Field());
						ris.sum_Insured_Field().sendKeys(OurSI);
						System.out.println("Inward Our SI value: " + OurSI);
					} else {
						webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
						ris.sum_Insured_Field().click();
						doubleClick(ris.sum_Insured_Field());
						ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
						System.out.println("SI value: " + Sum_Insured_Amount);
					}

//					Enter Sum Insured Rate
					webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
					ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					if (Types_of_Policy.equals("Erection All Risks")) {
//						webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
//						rb.delay(3000);
//						ris.professional_Fees_Rate_per().click();
//						ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
//						ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
//						ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
//					}
					rb.delay(1000);
//					Save Sum Insured Details
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
					ris.save_Button().click();
					rb.delay(2000);
				}
			}
		}

// Risk Premium and Annual Premium
		rb.delay(5000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.Total_Risk_Annual_Premium()));
		annual_Sum_Insured_Premium = ris.Total_Risk_Annual_Premium().getText();
		System.out.println("Total Risk Annual Premium is: " + annual_Sum_Insured_Premium);

		webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Total_Premium()));
		String RiskPremium = ris.Risk_Total_Premium().getText();
		System.out.println("Total Risk Premium Value is: " + RiskPremium);

//		Get Premium Amount
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Premium_Field()));
		String SMIPremium = ris.SMI_Premium_Field().getText();
		System.out.println("Total SMI premium value is: " + SMIPremium);

		rb.delay(2000);
//		Get SMI Annual Premium
		webDriverWait(ExpectedConditions.visibilityOf(ris.SMI_Annual_Premium()));
		String SMI_Annual_Premium = ris.SMI_Annual_Premium().getText();
		System.out.println("SMI Annual Premium Amount is: " + SMI_Annual_Premium);

		rb.delay(3000);

//		Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		javaScribtClick(ris.Proceed_Button());

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();
		} catch (Exception e) {

		}

		System.out.println("Proceed to Add Pol info page");

// Add pol info page

//Add policy Discounts and Loadings to the policy.
		try {
			webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
			String policy_Fees = apin.get_Policy_Fees().getText();
			System.out.println("Policy Fees is: " + policy_Fees);

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
			javaScribtClick(apin.Policy_Discounts_Loadings_Panel());
			try {
				webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
				String policy_Fees = apin.get_Policy_Fees().getText();
				System.out.println("Policy Fees is: " + policy_Fees);
			} catch (Exception e2) {
			}
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

		rb.delay(5000);

// Introducer/processor commission
		String user_Profile_Name2 = apin.userNameField().getText();
		System.out.println("User Profile Name is: " + user_Profile_Name2);

		if (CLP.Login_User_Name.contains("Juan Siracusa")) {

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

//Insurer Premium
			double text4 = string_To_double_Convert(text3);
			double insurer_Premium = Total_Premium_Amount - text4;
			String Remaining_Premium = String.format("%.2f", insurer_Premium);
			System.out.println("Insurer Premium Amount is: " + Remaining_Premium);

//			Enter Co insurer
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
			apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
			rb.delay(5000);
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

//Add Insured
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Additional_Insured_Menu()));
		apin.Additional_Insured_Menu().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
		apin.Add_Additional_Insured().click();

//		if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
//				|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//			selectByVisibleText(obj1.Split_YN(), Split_YN);
//			System.out.println("Split invoice is: " + Split_YN);
//			rb.delay(5000);
//
//			webDriverWait(ExpectedConditions.visibilityOf(obj1.Yes_AddInsured_Name()));
//			obj1.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
//			rb.delay(2000);
//			obj1.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
//			obj1.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
////			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
////			obj1.Select_Add_Insured_Name().click();
//			String AddInsured = getAtrributeValue(obj1.Yes_AddInsured_Name(), "value");
//			System.out.println("Add Insured Name :" + AddInsured);
//
//			webDriverWait(ExpectedConditions.visibilityOf(obj1.Add_Ins_Billing_Account()));
//			rb.delay(3000);
//			selectByIndex(obj1.Add_Ins_Billing_Account(), 1);
//			String AddIns_BillAcct = getAtrributeValue(obj1.Add_Ins_Billing_Account(), "value");
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
//			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//			selectByVisibleText(obj1.Split_YN(), Split_YN);
//			System.out.println("Split invoice is:" + Split_YN);
//			rb.delay(5000);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.No_AddInsured_Name()));
//			obj1.No_AddInsured_Name().sendKeys("John");
//			String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
//			System.out.println("Add Insured Name: " + AddInsname);
//		}

		webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
		selectByIndex(apin.Split_YN(), 1);
		String Splitvalue = first_Selected_Value(apin.Split_YN());
		// String Splitvalue = obj1.Split_YN().getAttribute("value");
		System.out.println("Split Invoice value: " + Splitvalue);

		if (Splitvalue.equals("Yes")) {

			webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
			apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
			rb.delay(2000);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
			apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
//			webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
//			obj1.Select_Add_Insured_Name().click();
			String AddInsured = getAtrributeValue(apin.Yes_AddInsured_Name(), "value");
			System.out.println("Add Insured Name: " + AddInsured);

			webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Billing_Account()));
			rb.delay(3000);
			selectByIndex(apin.Add_Ins_Billing_Account(), 1);
			String AddIns_BillAcct = getAtrributeValue(apin.Add_Ins_Billing_Account(), "value");
			System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);

		} else if (Splitvalue.equals("No")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.No_AddInsured_Name()));
			apin.No_AddInsured_Name().sendKeys("John");
			// String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
			System.out.println("Add Insured Name: " + "John");
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
//		if (obj11.Add_Ins_Mobile_No() == null) {
		apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
//		}else{
		String AddIns_MobNum = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
		System.out.println("Add Ins Mobile No: " + AddIns_MobNum);
//		}

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

//survey details	

		if (Surveyor.equals("Yes")) {

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

			webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));
			Select dropdown = new Select(apin.Surveyor_Name());
			List<WebElement> SurveyorName = dropdown.getOptions();
			List<WebElement> validOptions = new ArrayList<>();
			for (WebElement option : SurveyorName) {
				if (!option.getText().toLowerCase().contains("select")) {
					validOptions.add(option);
				}
			}
			if (!validOptions.isEmpty()) {
				Random Surveyorname = new Random();
				int randomIndexOfSurveyorName = Surveyorname.nextInt(validOptions.size());
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
		} else {
			System.out.println("Surveyor is not applicable");
		}

//Terms and Conditions
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

		try {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox()));
			javaScribtClick(apin.Terms_Conditions_Checkbox());

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
			apin.Save_Terms_Conditions().click();

		} catch (Exception e) {

			webDriverWait(ExpectedConditions.elementToBeClickable(apin.Cancel_Terms_Conditions()));
			apin.Cancel_Terms_Conditions().click();
		}

		rb.delay(3000);

//Policy Documents Upload
		// scrollDownJavaSc(obj.Policy_Document_Dropdown());
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

		rb.delay(10000);

//RI Ceding page.
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

		if (CLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			javaScribtClick(ri.Prop_FAC());

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

		} else if (CLP.Login_User_Name.contains("Juan Siracusa") && Add_FAC.equals("No")) {
		}

//		Click Proceed
		rb.delay(3000);
		webDriverWait(ExpectedConditions.visibilityOf(ri.proceed_Button()));
		scrollDownJavaSc(ri.proceed_Button());
		ri.proceed_Button().click();

//RA slip page
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
		// scrollDownJavaSc(obj3.get_Charge());
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
		Net_To_Customer = ra.Net_to_Customer().getText();
		System.out.println("Net to Customer: " + Net_To_Customer);

		try {
			// Get Net Premium
			webDriverWait(ExpectedConditions.visibilityOf(ra.Net_Premium()));
			String NetPremium = ra.Net_Premium().getText();
			System.out.println("Net Premium: " + NetPremium);
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
					RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

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

					rb.delay(10000);
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
					ra.user_Profile().click();

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
					LP.username_Field().sendKeys(CLP.Loginuser);

					webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
					LP.password_Field().sendKeys(CLP.Loginuser_password);

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
		rb.delay(3000);

//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_PrintDocs_Close()));
//		GSP.Quote_Search_PrintDocs_Close().click();

		navigateRefresh();
		rb.delay(5000);

// Approve as Policy in Search page.
		if (Approve_Policy.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.APPROVE_POLICY()));
			GSP.APPROVE_POLICY().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.mode_of_Pay_Dropdown()));
//			selectByIndex(ra.mode_of_Pay_Dropdown(), 3);
//			Mode_Of_Pay = first_Selected_Value(ra.mode_of_Pay_Dropdown());
//			System.out.println(Mode_Of_Pay);
			Select modelist = new Select(ra.mode_of_Pay_Dropdown());
			List<WebElement> ModeOfPay = modelist.getOptions();
			List<WebElement> Options = new ArrayList<>();
			for (WebElement options : ModeOfPay) {
				if (!options.getText().toLowerCase().contains("select")) {
					Options.add(options);
				}
			}
			if (!Options.isEmpty()) {
				Random ModeofPay = new Random();
				int randomPayMode = ModeofPay.nextInt(Options.size());
				modelist.selectByIndex(ModeOfPay.indexOf(Options.get(randomPayMode)));
				Mode_Of_Pay = Options.get(randomPayMode).getText();
				System.out.println("Mode of Pay: " + Mode_Of_Pay);
			}

			if (Mode_Of_Pay.equals("Cash") || Mode_Of_Pay.equals("Cash sale combined")) {
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
				rb.delay(2000);
				selectByIndex(ra.Insured_Billing_Account(), 1);
			}

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
			javaScribtClick(ra.approve_Policy_Button());
			new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			// ra.approve_Policy_Button().click();

			try {
//				// Click RA Slip Approve as Policy Button
//				webDriverWait(ExpectedConditions.elementToBeClickable(ra.approve_Policy_Button()));
//				javaScribtClick(ra.approve_Policy_Button());

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
					javaScribtClick(WFA.Clm_Approver_Viewoption());

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

					//Search Policy via Quotation.
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
							// driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
					GSP.Policy_Print_Close().click();
				}
			}
			rb.delay(3000);

			try {
				if (GSP.FAC_Not_Closed().isEnabled()) {
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

			} catch (Exception e) {
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

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.View_Accounting_Record()));
			GSP.View_Accounting_Record().click();

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

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.CI_Menu()));
			uwp.CI_Menu().click();
//Approve Policy Close poin
		}
	}

}

package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.testng.annotations.Test;

public class Issue_Policy_Risk_Information extends BaseClass {
	public static String annual_Sum_Insured_Premium;
	public static String OurSI;
	public static String policy_Type;
	public static String Risk_TODate;

	@Test(dataProvider = "Issue_Policy")
	public void tc_001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Floatingtype, String Floating_Policy, String Insured_Query, String Insured_ID,
			String Quotation_Validity_Days, String Co_Insurance_Share_Percentage, String Sum_Insured_Currency,
			String Premium_Currency, String Contact_Number, String Business_Occupation, String Territorial_Limits,
			String Product_Type, String Indeminity_Field, String Material_Policy_Damage_Number, String Introducer_Name,
			String Processor_Name, String Risk_Description, String Occupancy_Type, String Description,
			String Risk_Catagory, String Location, String Cyber_Risk, String Limit_Per_AOA, String Select_Reference,
			String Inward_SI, String Inward_Premium, String Multiple_Risk, String Multiple_SMI,
			String Sum_Insured_Amount, String Sum_Insured_Rate, String Sum_Insured_Premium, String SMI_Discount,
			String SMI_Loadings, String Discount_Rate, String Loading_Rate, String Edit_SMI, String Edit_SI,
			String Edit_SI_RATE, String Del_SMI, String Policy_Discount, String Policy_Discount_Rate,
			String Policy_Loading, String Policy_Loading_Rate, String Policy_Deductible,
			String Policy_Deductible_Calctype, String Policy_Deductible_RateValue, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Coinsurer_Share, String Doc_type, String Special_Tty, String RI_Ceding_Basic, String Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String Approve_Policy,

			String Policy_Endorsements, String Non_Financial_Endors, String Financial_Endors,
			String Change_Policy_Endors, String Extension_Policy_Endors, String Reduction_Policy_Endors,
			String FAC_Endors, String Discount_Loadings_Endors, String Policy_Cancellation_Endors,
			String Policy_Reinstatement_Endors, String PO_Box_Numer, String Address, String Edit_SI_Value,
			String Edit_SI_Rate, String Financial_Add_FAC,

			String Run_Flag) throws InterruptedException, IOException, AWTException {

		Robot rb = new Robot();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();

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
		case "Liability Commercial":
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
		String Quote_No = ris.get_Quote_Number().getText();
		System.out.println("Quote Number is: " + Quote_No);

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
		
		rb.delay(5000);
		//uncheck the check boxes
			List<WebElement> checkboxes = ris.SMI_CheckBox_Uncheck();
			for (WebElement checked : checkboxes) {
				if (checked.isSelected()) {
					checked.click();
				}
			}

		// Add SMI details
		if (Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")) {

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

					webDriverWait(
							ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_FloatingYN_Checkbox()));
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

			} else {

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

				if (Types_of_Policy.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.professional_Fees_Checkbox()));
					ris.professional_Fees_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Public_Liability_CheckBox()));
					ris.Public_Liability_CheckBox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Contracts_Works_Checkbox()));
					ris.Contracts_Works_Checkbox().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Debris_Remove_Checkbox()));
					ris.Debris_Remove_Checkbox().click();
				}
			}
			// Save Sum Insured Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

		} else {

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

					webDriverWait(
							ExpectedConditions.elementToBeClickable(ris.Floating_Declaration_FloatingYN_Checkbox()));
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

			} else {

				rb.delay(3000);
				if (!Types_of_Policy.equals("Business Interruption Insurance")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
					javaScribtClick(ris.Sum_Insured_checkbox());
				}
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
				if (Types_of_Policy.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
					rb.delay(3000);
					ris.professional_Fees_Rate_per().click();
					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
				}
			}
			rb.delay(1000);
			// Save Sum Insured Details
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

			// Add Discounts and Loadings to the SMI
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_DL_Icon()));
			ris.SMI_DL_Icon().click();

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

			if (Multiple_SMI.contains("Yes")) {

				// Click risk Check box
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
				ris.risk_Check_Box().click();

				// Click Add SMI Button
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
				ris.Add_SMI_Button().click();

				// Floating and Decalration need to act in the place

				// if (!Types_of_Policy.equals("Business Interruption Insurance")) {
				// Enter SMI check box Details conditions to be handled
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
				ris.Sum_Insured_checkbox().click();
				// }
				// Enter SI value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.sum_Insured_Field()));
				ris.sum_Insured_Field().click();
				doubleClick(ris.sum_Insured_Field());
				ris.sum_Insured_Field().sendKeys(Sum_Insured_Amount);
				System.out.println("SI value: " + Sum_Insured_Amount);

				// Enter rate value.
				webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
				ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
				if (Types_of_Policy.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
					rb.delay(3000);
					ris.professional_Fees_Rate_per().click();
					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
				}

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

//			Enter SMI check box Details	conditions to be handled
				rb.delay(2000);
				// if (!Types_of_Policy.equals("Business Interruption Insurance")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
				ris.Sum_Insured_checkbox().click();
				// }

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
				if (Types_of_Policy.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
					rb.delay(3000);
					ris.professional_Fees_Rate_per().click();
					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
				} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
					ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
					ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
				}

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

					// Enter SMI check box Details conditions to be handled
					// if (!Types_of_Policy.equals("Business Interruption Insurance")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.Sum_Insured_checkbox()));
					ris.Sum_Insured_checkbox().click();
					// }
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
					if (Types_of_Policy.equals("Erection All Risks")) {
						webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
						rb.delay(3000);
						ris.professional_Fees_Rate_per().click();
						ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
					} else if (Types_of_Policy.equals("Group Personal Accident and Annual Business Travel")) {
						ris.Cancellation_and_Curltainment().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Death().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Hijack().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Legal_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Medical_and_Emergency_Expenses().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Passport_Indemnity().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Permanent_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Personal_Baggage().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Personal_Liability().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Personal_Money_and_Credit_Cards().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Temporary_Total_Disablement().sendKeys(Sum_Insured_Rate, Keys.TAB);
						ris.Travel_Delay().sendKeys(Sum_Insured_Rate, Keys.TAB);
					}
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

		
		
	}
}
package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.testng.annotations.Test;

public class Financial_Endorsement extends BaseClass {

	public static String OurSI;
	public static String policy_Type;
	public static List<WebElement> checkboxes;
	public static String Endor_Pol;

	@Test(dataProvider = "Financial_Endorsement")

	public void tc_001(String S_No, String Search_Policy, String Policy_Query, String Policy_Number, String Endorsement_Type, String Remarks,
			String Add_Risk, String Add_SMI, String Del_Risk, String Del_SMI, String Edit_SMI, String Risk_Description,
			String Select_Reference, String Description, String Location, String Cyber_Risk, String Limit_Per_AOA,
			String Sum_Insured_Amount, String Sum_Insured_Rate, String Edit_SI_Value, String Edit_SI_Rate,
			String Inward_SI, String Inward_Premium, String Financial_Add_FAC, String FAC_Percentage_Value,
			String FAC_Participant_Query, String FAC_ID, String FAC_Participant_Share_Percentage_Value,
			String Cash_Type, String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account,
			String Run_Flag) throws InterruptedException, AWTException, ClassNotFoundException, IOException {

		Global_Search_Page GSP = new Global_Search_Page();
		Login_Page LP = new Login_Page();
		Commercial_Login CLP = new Commercial_Login();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Robot rb = new Robot();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(get_DB_Data(Policy_Query, Policy_Number), Keys.ENTER);
		//System.out.println("Policy Number: " + Policy_Number);
		
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		Endor_Pol = GSP.Policy_Number().getText();
		System.out.println("Endorsment Policy: " + Endor_Pol);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String Policytype = GSP.Policy_Type().getText();
		System.out.println("Type of Policy: " + Policytype);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
		String Insured = GSP.Insured_Name().getText();
		System.out.println("Insured Name: " + Insured);

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
		String Pol_Start_Date = GSP.policy_Start_Date().getAttribute("value");
		System.out.println("Actual Policy Start Date: " + Pol_Start_Date);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
		String Pol_To_Date = GSP.policy_To_Date().getAttribute("value");
		System.out.println("Actual Policy To Date: " + Pol_To_Date);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
		GSP.proceed_Button().click();

		if (GSP.Endor_Date_validation().isEnabled()) {

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Endor_Date_validation()));
			String Error = GSP.Endor_Date_validation().getText();
			System.out.println(Error);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
			GSP.effective_From_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime date = LocalDateTime.parse(Pol_Start_Date, formatter);
			LocalDateTime newDate = date.plusDays(30);
			String newDateString = newDate.format(formatter);
			GSP.effective_From_Date().sendKeys(newDateString);
			System.out.println("Endorsement Effective From Date: " + newDateString);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
			GSP.proceed_Button().click();
		}
//Endorsement information page

		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
		Endorsement_Type = EIP.get_Endorsement_Type().getText();
		System.out.println("Endorsement Type is: " + Endorsement_Type);

//		business source
		webDriverWait(ExpectedConditions.visibilityOf(EIP.Business_source()));
		String B_Source = EIP.Business_source().getText();
		System.out.println("Business source: " + B_Source);

//		Enter Remarks
		webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
		EIP.remarks_Field().sendKeys(Remarks);

//		Click Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();

//Risk information page
		if (Add_Risk.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_Risk_Button()));
			ris.Add_Risk_Button().click();

			// Enter Risk Description
			webDriverWait(ExpectedConditions.visibilityOf(ris.risk_Description_Field()));
			ris.risk_Description_Field().sendKeys(Risk_Description);

			if (Policytype.equals("Erection All Risks") || Policytype.equals("Contractors All Risks Insurance")) {
				webDriverWait(ExpectedConditions.visibilityOf(ris.select_reference()));
				selectByVisibleText(ris.select_reference(), Select_Reference);
				System.out.println("Select reference: " + Select_Reference);

				webDriverWait(ExpectedConditions.visibilityOf(ris.contractor_Name_Field()));
				ris.Contractor_Name().sendKeys("Site Engineer");
			}
			// Select description
			webDriverWait(ExpectedConditions.visibilityOf(ris.description_Dropdown()));
			selectByVisibleText(ris.description_Dropdown(), Description);

			// Enter Location
			webDriverWait(ExpectedConditions.visibilityOf(ris.Location_Field()));
			ris.Location_Field().sendKeys(Location);

			// Click Longitude Button
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.find_Latitude()));
			ris.find_Latitude().click();

			rb.delay(7000);
			webDriverWait(ExpectedConditions.visibilityOf(ris.ok_Button()));
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.ok_Button()));
			javaScribtClick(ris.ok_Button());

			policy_Type = Product_Type;

			switch (policy_Type) {
			case "Liability Commercial":
				// Enter Limit Per AOA
				webDriverWait(ExpectedConditions.visibilityOf(ris.Limit_Per_AOA_Field()));
				ris.Limit_Per_AOA_Field().sendKeys(Limit_Per_AOA);
				break;
			case "Fire Commercial":
				// Select Cyber Risk
				webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
				selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
				break;
			case "Electronic Equipment Insurance":
				// Select Cyber Risk
				webDriverWait(ExpectedConditions.visibilityOf(ris.cyber_Risk_Dropdown()));
				selectByVisibleText(ris.cyber_Risk_Dropdown(), Cyber_Risk);
				break;
			default:
				break;
			}

			// Inward formation section
			if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {

				// 100% and Our SI & Premium value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
				ris.Risk_Inward_SI().sendKeys(Inward_SI, Keys.TAB);
				System.out.println("Inward SI Value: " + Inward_SI);

				rb.delay(3000); //
				webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurSI()));
				OurSI = getAtrributeValue(ris.Risk_Inward_OurSI(), "value");
				System.out.println("Inward Our SI value: " + OurSI);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
				ris.Risk_Inward_Premium().sendKeys(Inward_Premium, Keys.TAB);
				System.out.println("Inward Premium Value: " + Inward_Premium);

				rb.delay(3000); //
				webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Inward_OurPremium()));
				String OurPremium = getAtrributeValue(ris.Risk_Inward_OurPremium(), "value");
				System.out.println("Inward our Premium Value: " + OurPremium);
			}

			// Click save Button
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
			ris.save_Button().click();

			// Get Risk Success Msg
			webDriverWait(ExpectedConditions.visibilityOf(ris.Risk_Success_Msg()));
			String risk_Success_Msg = ris.Risk_Success_Msg().getText();
			System.out.println("Risk Success Msg is: " + risk_Success_Msg);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box2()));
			ris.risk_Check_Box2().click();

			// Click Add SMI Button
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
			javaScribtClick(ris.Add_SMI_Button());

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
			if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
				// Enter SMI check box Details conditions to be handled
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
				ris.Inward_OurSMI_Checkbox().click();

				if (Policytype.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(ris.professional_Fees_Checkbox()));
					ris.professional_Fees_Checkbox().click();
				}
				// Enter SI value
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
				ris.Inward_OurSMI_SI().click();
				doubleClick(ris.sum_Insured_Field());
				ris.Inward_OurSMI_SI().sendKeys(OurSI);
				System.out.println("Inward Our SI value: " + OurSI);

				// Enter rate value.
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
				ris.Inward_OurSMI_Rate().sendKeys("1.08308", Keys.TAB);

				// Save Sum Insured Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();
			} else {

				// Enter SMI check box Details conditions to be handled
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
				if (Policytype.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
					Thread.sleep(3000);
					ris.professional_Fees_Rate_per().click();
					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
				} else if (Policytype.equals("Group Personal Accident and Annual Business Travel")) {
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

				Thread.sleep(1000);
				// Save Sum Insured Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();
			}
		}

		if (Add_SMI.equals("Yes")) {
			scrollUpJavaSc(ris.risk_Check_Box());
			rb.delay(4000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
			ris.risk_Check_Box().click();

			// Click Add SMI Button
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Add_SMI_Button()));
			ris.Add_SMI_Button().click();

			if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Checkbox()));
				ris.Inward_OurSMI_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_SI()));
				ris.Inward_OurSMI_SI().sendKeys("15000");

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
				ris.Inward_OurSMI_Rate().sendKeys("1", Keys.TAB);
			} else {
				// Enter SMI check box Details conditions to be handled
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
				webDriverWait(ExpectedConditions.visibilityOf(ris.sum_Insured_Rate_Field()));
				ris.sum_Insured_Rate_Field().sendKeys(Sum_Insured_Rate, Keys.TAB);
				if (Policytype.equals("Erection All Risks")) {
					webDriverWait(ExpectedConditions.visibilityOf(ris.professional_Fees_Rate_per()));
					Thread.sleep(3000);
					ris.professional_Fees_Rate_per().click();
					ris.professional_Fees_Rate_per().sendKeys(Sum_Insured_Rate, Keys.TAB);
				} else if (Policytype.equals("Group Personal Accident and Annual Business Travel")) {
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
				Thread.sleep(1000); // Save Sum Insured Details
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();
			}
		}

		if (Edit_SMI.equals("Yes")) {

			scrollUpJavaSc(ris.risk_Check_Box());
			rb.delay(8000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
			ris.risk_Check_Box().click();

			if (B_Source.equals("Broker with Elmo Follower") || B_Source.equals("Direct with Elmo Follower")) {
//				Click the risk edit icon to enter the Inward SI and Premium
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditRisk_Button()));
				ris.EditRisk_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_SI()));
				ris.Risk_Inward_SI().sendKeys("150000");

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_Premium()));
				ris.Risk_Inward_Premium().sendKeys("1500");

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_OurSI()));
				String Endo_Inward_OurSI = ris.Risk_Inward_OurSI().getText();
				System.out.println("Endo Inward OurSI " + Endo_Inward_OurSI);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Risk_Inward_OurPremium()));
				String Endo_Inward_Premium = ris.Risk_Inward_OurPremium().getText();
				System.out.println("Endo Inward Premium " + Endo_Inward_Premium);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();
				rb.delay(3000);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditSMI_Risk()));
				ris.EditSMI_Risk().click();
				rb.delay(2000);
				// SMI edit

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.SMI_EDIT_ICON()));
				ris.SMI_EDIT_ICON().click();

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));
				ris.EDIT_SI_Value().sendKeys(Endo_Inward_OurSI);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Inward_OurSMI_Rate()));
				ris.Inward_OurSMI_Rate().sendKeys("1.08308", Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
				ris.Save_EDIT_SI().click();

			} else {

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditSMI_Risk()));
				ris.EditSMI_Risk().click();
				rb.delay(3000);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Value()));

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value = '';", ris.EDIT_SI_Rate());
				ris.EDIT_SI_Rate().sendKeys(Edit_SI_Value);
//				ris.EDIT_SI_Value().clear();
//				ris.EDIT_SI_Value().sendKeys(Edit_SI_Value,Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EDIT_SI_Rate()));
				// doubleClick(ris.EDIT_SI_Rate());
				ris.EDIT_SI_Rate().clear();
				ris.EDIT_SI_Rate().sendKeys(Edit_SI_Rate, Keys.TAB);

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Save_EDIT_SI()));
				ris.Save_EDIT_SI().click();
			}
		}

		if (Del_SMI.equals("Yes")) {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Check_Box()));
			ris.risk_Check_Box().click();

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Del_SMI()));
			ris.Del_SMI().click();
		}

		if (Del_Risk.equals("Yes")) {
			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.Del_Risk()));
			javaScribtClick(ris.Del_Risk());

			scrollUpJavaSc(ris.DelRisk_Yes());
			webDriverWait(ExpectedConditions.elementToBeClickable(ris.DelRisk_Yes()));
			ris.DelRisk_Yes().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.confirm_ok_Button()));
			ris.confirm_ok_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.RevertRisk_SI_Value()));
			String RevertSI = ris.RevertRisk_SI_Value().getText();
			System.out.println("Deletion Risk SI value " + RevertSI);

			webDriverWait(ExpectedConditions.elementToBeClickable(ris.RevertRisk_Premium_Value()));
			String RevertPremium = ris.RevertRisk_Premium_Value().getText();
			System.out.println("Deletion Risk Premium value " + RevertPremium);
		}

//click Proceed option to add pol info page.
		scrollDownJavaSc(ris.Proceed_Button());
		webDriverWait(ExpectedConditions.elementToBeClickable(ris.Proceed_Button()));
		ris.Proceed_Button().click();

//Add pol info page
		// Coinsurance section
		if (B_Source.equals("Direct with Elmo Leader") || B_Source.equals("Direct with Elmo Follower")
				|| B_Source.equals("Broker with Elmo Leader") || B_Source.equals("Broker with Elmo Follower")
				|| B_Source.equals("Salesman with Elmo Leader") || B_Source.equals("Introducers with Elmo Leader")
				|| B_Source.equals("Branches with Elmo Leader") || B_Source.equals("Staff with Elmo Leader")
				|| B_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {

			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_SI()));
			String Coinsurer_Share_SI = apin.co_Insurer_Share_SI().getText();
			System.out.println("coinsurer share SI value " + Coinsurer_Share_SI);

			webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
			String Coinsurer_sharePremium = apin.co_Insurer_Share_Premium().getText();
			System.out.println("coinsurer share premium value " + Coinsurer_sharePremium);
		}

//		Click proceed
		webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
		apin.proceed_Button().click();

// proceeding to RI ceding page.	

		if (LP.User_Profile_Name().equals("Juan Siracusa") && Financial_Add_FAC.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Prop_FAC()));
			ri.Prop_FAC().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Placement_CheckBox()));
			ri.FAC_Placement_CheckBox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Fac_Percentage()));
			ri.Fac_Percentage().sendKeys(FAC_Percentage_Value);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Save_Add_Participant()));
			ri.Save_Add_Participant().click();

			webDriverWait(ExpectedConditions.visibilityOf(ri.FAC_Participant_Name()));
			ri.FAC_Participant_Name().sendKeys(get_DB_Data(FAC_Participant_Query, FAC_ID));
			webDriverWait(ExpectedConditions.elementToBeClickable(ri.Select_FAC_Participant_Name()));
			ri.Select_FAC_Participant_Name().click();
			String FACParticipant = getAtrributeValue(ri.FAC_Participant_Name(), "value");
			System.out.println("FAC Participant Name = " + FACParticipant);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Share_Percentage()));
			ri.FAC_Participant_Share_Percentage().sendKeys(FAC_Participant_Share_Percentage_Value, Keys.TAB);

			webDriverWait(ExpectedConditions.elementToBeClickable(ri.FAC_Participant_Save_Close()));
			ri.FAC_Participant_Save_Close().click();

		} else if (LP.User_Profile_Name().equals("Juan Siracusa") && Financial_Add_FAC.equals("No")) {
		}

		// Click proceed button
		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.visibilityOf(ris.Proceed_Button()));
		scrollDownJavaSc(ris.Proceed_Button());
		ris.Proceed_Button().click();

// RA slip page.	

//		Get Net To Customer
		webDriverWait(ExpectedConditions.visibilityOf(ra.Net_to_Customer()));
		String Net_To_Customer = ra.Net_to_Customer().getText();
		System.out.println("Net to Customer: " + Net_To_Customer);

//		Select Mode of Pay
		webDriverWait(ExpectedConditions.visibilityOf(ra.mode_of_Pay_Dropdown()));
		selectByIndex(ra.mode_of_Pay_Dropdown(), 3);
		String Mode_Of_Pay = first_Selected_Value(ra.mode_of_Pay_Dropdown());
		System.out.println(Mode_Of_Pay);

		if (Mode_Of_Pay.equals("Cash") || Mode_Of_Pay.equals("Cash sale combined")) {
//			Click Cash Analysis
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
			javaScribtClick(ra.cash_Analysis_Button());

//			Click Add New Button
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
			ra.add_New_Button().click();

//			Click Check Box
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
			ra.cash_Code_Checkbox().click();

//			Select cash Type
			webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
			selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

			if (Cash_Type.equals("CHEQUE")) {
//				Enter Cheque No
				webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
				ra.cheque_Ref_Num().sendKeys(Cheque_No);

//				Select Bank Name
				webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
				selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

//				Enter Account Number
				webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
				ra.account_Number_Field().sendKeys(Account_Number);

//				Enter Cheque Date
				webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
				ra.cheque_End_Date().click();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDateTime now = LocalDateTime.now();
				ra.cheque_End_Date().sendKeys(dtf.format(now));

//				Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
				ra.amount_Field().sendKeys(Net_To_Customer);

			} else if (Cash_Type.equals("CASH")) {

//				Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
				ra.amount_Field().sendKeys(Net_To_Customer);

			}
//			Save the details
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
			ra.save_Cash_Analysis().click();

		} else if (Mode_Of_Pay.equals("Credit") || Mode_Of_Pay.equals("Debit")) {

			webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
			rb.delay(3000);
			selectByIndex(ra.Insured_Billing_Account(), 1);

		} else if (Mode_Of_Pay.equals("SEPA")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_AC_Number()));
			ra.SEPA_AC_Number().clear();
			ra.SEPA_AC_Number().sendKeys("10112407330018");

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_Swift_Code()));
			ra.SEPA_Swift_Code().clear();
			ra.SEPA_Swift_Code().sendKeys("APSBMTMT");

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_IBAN()));
			ra.SEPA_IBAN().clear();
			ra.SEPA_IBAN().sendKeys("MT02APSB77046002407312407330018");

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BankList()));
			selectByIndex(ra.SEPA_BankList(), 2);

			webDriverWait(ExpectedConditions.elementToBeClickable(ra.SEPA_BIC_Code()));
			ra.SEPA_BIC_Code().clear();
			ra.SEPA_BIC_Code().sendKeys("HJGFTUYT675785465");
		}

		Thread.sleep(15000);

		// Approve Endorsement
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
		javaScribtClick(EIP.approve_Endorsement_Button());

		/*
		 * try { 
		 * workflow
		 * 			Quote WF
		 * 
		 * 
		 * 
		 * } catch (Exception e) { // TODO: handle exception }
		 */

		// obj5.approve_Endorsement_Button().click();

//		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
//		String policyNumber = EIP.get_Policy().getText();
//		System.out.println("Policy Number is: " + Endoe_Pol);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		javaScribtClick(GSP.global_Search_Button());

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(Endor_Pol);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();

//Summary Endorsement Print docs		
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Docs()));
		GSP.Policy_Print_Docs().click();
		rb.delay(3000);

		List<WebElement> listCheckBoxes = GSP.Print_CheckBox();
		System.out.println("Print document List: " + listCheckBoxes.size());

		for (int i = 0; i < listCheckBoxes.size(); i++) {

			listCheckBoxes.get(i).click();
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
		rb.delay(5000);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
		GSP.Policy_Print_Close().click();

		rb.delay(3000);

		try {

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
//					Click Menu Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
					ra.menu_Button().click();

//	 				Click RI Confirmation Log
					scrollDownJavaSc(ra.Reinsurance_Menu());
					ra.Reinsurance_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Allocation_Menu()));
					ra.RI_Allocation_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_FAC_PolicyNo()));
					ra.RI_FAC_PolicyNo().sendKeys(Endor_Pol, Keys.TAB);
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
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

			} else {
				System.out.println("FAC is not applicable");
			}

		} catch (Exception e) {
		}

	}
}
package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.common.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Underwritting_Page;
import org.testng.annotations.Test;

public class Issue_Policy_Underwriting extends BaseClass {
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

			String Run_Flag) throws InterruptedException, AWTException, ClassNotFoundException, IOException {
		Robot rb = new Robot();
		Underwritting_Page uwp = new Underwritting_Page();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.CI_Menu()));
		uwp.CI_Menu().click();

//		Click Menu Button
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
		uwp.menu_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(uwp.userNameField()));
		String user_ProfileName = uwp.userNameField().getText();
		System.out.println("Login User is: "+user_ProfileName);

//		Click Commercial Underwriting 
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.commercial_Underwriting_Button()));
		uwp.commercial_Underwriting_Button().click();
		Thread.sleep(2000);
		if (Policy_Type.equals("Fire Commercial")) {
//			Click Commercial Fire Menu
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Fire_Commercial_Menu()));
			uwp.Fire_Commercial_Menu().click();
		} else if (Policy_Type.equals("Liability Commercial")) {
//			Click Liability Commercial
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Liability_Commercial_Menu()));
			uwp.Liability_Commercial_Menu().click();
		} else if (Policy_Type.equals("Engineering Commercial")) {
//			Click Engineering Commercial
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Engineering_Commercial_Menu()));
			uwp.Engineering_Commercial_Menu().click();
		} else if (Policy_Type.equals("Accident Commercial")) {
// 			click Accident commercial
			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Accident_Commercial_Menu()));
			uwp.Accident_Commercial_Menu().click();
		}
	}
}

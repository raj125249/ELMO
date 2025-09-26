package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;

import org.common.BaseClass;
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
import org.testng.annotations.Test;

public class Issue_Policy_Endorsements extends BaseClass{

	@Test(dataProvider = "Issue_Policy_Reg")
	 public void tc001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
				String Floatingtype, String Insured_Query, String Insured_ID, String Quotation_Validity_Days,
				String Co_Insurance_Share_Percentage, String Sum_Insured_Currency, String Premium_Currency,
				String Contact_Number, String Business_Occupation, String Territorial_Limits, String Product_Type,
				String Indeminity_Field, String Material_Policy_Damage_Number, String Introducer_Name,
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
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				String Run_Flag) throws AWTException  {
		
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

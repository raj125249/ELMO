package org.pages;

import java.util.List;

import org.common.BasicFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Endorsement_Information_Page extends BasicFunctions {

	public Endorsement_Information_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//textarea[@id='txnRemarks']"),
			@FindBy(xpath = "//textarea[@name='quoteInfo.txnRemarks']") })
	WebElement remarks_Field;

	public WebElement remarks_Field() {
		return remarks_Field;
	}
	
	//@FindBy(xpath="//select[@id='menuTyp']//option[not(@selected='selected') and string-length(@value) > 0]")
	@FindBy(xpath="//select[@id='menuTyp']")
	WebElement Select_BS;
	
	public WebElement Select_BS() {
		return Select_BS;
	}
	
	@FindBy(xpath="//input[@id='id_coins_perc']")
	WebElement Coin_Percent;
	
	public WebElement Coin_Percent() {
		return Coin_Percent;
	}
	
	@FindBy(xpath="//ul[@id='ui-id-2']//li[1]//div[1]")
	WebElement select_Intoducer;
	
	public WebElement select_Intoducer() {
		return select_Intoducer;
	}
	
	@FindBy(xpath="//ul[@id='ui-id-3']//li[1]//div[1]")
	WebElement select_processor;
	  
	public WebElement select_processor() {
		return select_processor;
	}

	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement Contact_No;

	public WebElement Contact_No() {
		return Contact_No;
	}

	@FindBy(xpath = "//input[@id='emailId']")
	WebElement Email_Id;

	public WebElement Email_Id() {
		return Email_Id;
	}

	@FindBy(xpath = "(//input[@id='policyStartDate'])[2]")
	WebElement Org_Policy_Start_Date;

	public WebElement Org_Policy_Start_Date() {
		return Org_Policy_Start_Date;
	}

	@FindBy(xpath = "(//input[@id='policyEndDate'])[2]")
	WebElement Org_Policy_End_Date;

	public WebElement Org_Policy_End_Date() {
		return Org_Policy_End_Date;
	}

	@FindBy(xpath="//form[@id='endorseHome']/div[2]//div[4]//span")
	WebElement Policy_Type;
	
	public WebElement Policy_Type() {
		return Policy_Type;
	}
	
	@FindBy(xpath = "//input[@id='id_coins_perc']")
	WebElement Endo_Share_percentage;

	public WebElement Endo_Share_percentage() {
		return Endo_Share_percentage;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='AS_CUST_CODE']"), @FindBy(xpath = "//input[@name='assuredCode']") })
	WebElement Edit_Insured;

	public WebElement Edit_Insured() {
		return Edit_Insured;
	}

	@FindAll({ @FindBy(xpath = "//h5[@id='conditionsInfoGridTitle']"),
			@FindBy(xpath = "//i[@id='idPlus_CoversAccordioncinfo']") })
	WebElement Terms_Conditions_Panel;

	public WebElement Terms_Conditions_Panel() {
		return Terms_Conditions_Panel;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_conditions_add']"),
			@FindBy(xpath = "[onclick='addEditConditionsInfo('Add');']") })
	WebElement Add_Terms_Conditions;

	public WebElement Add_Terms_Conditions() {
		return Add_Terms_Conditions;
	}

	@FindAll({ @FindBy(xpath = "(//input[@onclick='formatCheckBox_onchange_cond(this.value, this.checked);'])[1]"),
			@FindBy(xpath = "(//input[@class='for_check_all'])[1]"),
			@FindBy(xpath = "(//input[@class=\"for_check_all\"])[1]") })
	WebElement Terms_Conditions_Checkbox;

	public WebElement Terms_Conditions_Checkbox() {
		return Terms_Conditions_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//button[text()=' Save']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[4]") })
	WebElement Save_Terms_Conditions;

	public WebElement Save_Terms_Conditions() {
		return Save_Terms_Conditions;
	}

	@FindAll({ @FindBy(xpath = "(//button[@class='btn btn-danger btn-sm'])[1]"),
			@FindBy(xpath = "(//i[@class='fa fa-times-circle'])[2]") })
	WebElement Cancel_Terms_Conditions;

	public WebElement get_Cancel_Terms_Conditions() {
		return Cancel_Terms_Conditions;
	}

	@FindBy(xpath = "//ul[@id='ui-id-2']//li[1]//div[1]")
	WebElement Select_Edit_Insured;

	public WebElement Select_Edit_Insured() {
		return Select_Edit_Insured;
	}
	
	@FindBy(xpath="//button[@id='btn_close']")
	WebElement endo_close;
	
	public WebElement endo_close() {
		return endo_close;
	}

	@FindBy(xpath = "(//li[@class='dropdown nav-profile']//following::span[1])[1]")
	WebElement UserName;

	public WebElement UserName() {
		return UserName;
	}

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Proceed')]"),
			@FindBy(xpath = "//button[@id='btn_proceed']") })
	WebElement proceed_Button;

	public WebElement proceed_Button() {
		return proceed_Button;
	}

	@FindAll({ @FindBy(xpath = "(//button[@id='btn_proc'])[4]") })
	WebElement ok_Button;

	public WebElement ok_Button() {
		return ok_Button;
	}

	@FindBy(xpath = "//button[@id='btn_proceedEndors']")
	WebElement proceed_Endorsement_Button;

	public WebElement proceed_Endorsement_Button() {
		return proceed_Endorsement_Button;
	}

	@FindBy(xpath = "//span[@class='label orig mr-20']//b")
	WebElement get_Endorsement_Type;

	public WebElement get_Endorsement_Type() {
		return get_Endorsement_Type;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[1]")
	WebElement Endor_Select_Add_Risk;

	public WebElement Endor_Select_Add_Risk() {
		return Endor_Select_Add_Risk;
	}

	@FindBy(xpath = "(//div[@id='endtEditDetailsTbl']//div)[1]//div[2]")
	WebElement get_Policy_Number;

	public WebElement get_Policy_Number() {
		return get_Policy_Number;
	}

	@FindBy(xpath = "//div[@id='policy']")
	WebElement get_Policy;

	public WebElement get_Policy() {
		return get_Policy;
	}

	@FindBy(xpath = "//div[contains(text(),'Customer')]//following-sibling::div[1]")
	WebElement customer_Name;

	public WebElement customer_Name() {
		return customer_Name;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Business Source')]/following-sibling::div[1]"),
			@FindBy(xpath = "//*[contains(text(),'Business Source')]//following-sibling::div[1]//select//option[@selected]") })
	WebElement Business_source;
	
	public WebElement Business_source() {
		return Business_source;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='othersInfoTbl']//tbody[1]//tr[1]//td[5]") })
	WebElement get_Policy_Fees;

	public WebElement get_Policy_Fees() {
		return get_Policy_Fees;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='ttySplAppr_disp0']"),
			@FindBy(xpath = "(//input[@name='prod.ttySplAppr'])[2]") })
	WebElement special_Tty_No_Option;

	public WebElement special_Tty_No_Option() {
		return special_Tty_No_Option;
	}

	@FindBy(xpath = "//td[contains(text(),'Gross Premium')]//following-sibling::td[1]")
	WebElement get_Gross_Premium;

	public WebElement get_Gross_Premium() {
		return get_Gross_Premium;
	}

	@FindBy(xpath = "//td[contains(text(),'Discounts')]//following::td[1]")
	WebElement get_Discount;

	public WebElement get_Discount() {
		return get_Discount;
	}

	@FindBy(xpath = "//td[contains(text(),'Loading')]//following::td[1]")
	WebElement get_Loading;

	public WebElement get_Loading() {
		return get_Loading;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='riskInfoTbl']//tbody[1]//tr[1]//td[1]//input[1]"),
			@FindBy(xpath = "(//input[@name='shipmentNos'])[1]") })
	WebElement risk_Check_Box;

	public WebElement risk_Check_Box() {
		return risk_Check_Box;
	}

	@FindBy(xpath = "//td[contains(text(),'Fees')]//following::td[1]")
	WebElement get_Charge;

	public WebElement get_Charge() {
		return get_Charge;
	}

	@FindBy(xpath = "//td[contains(text(),'Policy Tax')]")
	WebElement get_Policy_Tax_Text;

	public WebElement get_Policy_Tax_Text() {
		return get_Policy_Tax_Text;
	}

	@FindBy(xpath = "//td[contains(text(),'Policy Tax')]//following::td[1]")
	WebElement get_Policy_Tax_amount;

	public WebElement get_Policy_Tax_amount() {
		return get_Policy_Tax_amount;
	}

	@FindBy(xpath = "(//td[contains(text(),'Inward Commission')]//following::td[1])[1]")
	WebElement get_Inward_Commission_amount;

	public WebElement get_Inward_Commission_amount() {
		return get_Inward_Commission_amount;
	}

	@FindBy(xpath = "//td[contains(text(),'Inward Commission Tax')]")
	WebElement get_Inward_Commission_Tax_Text;

	public WebElement get_Inward_Commission_Tax_Text() {
		return get_Inward_Commission_Tax_Text;
	}

	@FindBy(xpath = "//td[contains(text(),'Inward Commission Tax')]//following::td[1]")
	WebElement get_Inward_Commission_Tax_Amount;

	public WebElement get_Inward_Commission_Tax_Amount() {
		return get_Inward_Commission_Tax_Amount;
	}

	@FindBy(xpath = "//b[contains(text(),'Net To Customer')]//following::td[1]")
	WebElement get_Net_Premium;

	public WebElement get_Net_Premium() {
		return get_Net_Premium;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_approveEndt']") })
	WebElement approve_Endorsement_Button;

	public WebElement approve_Endorsement_Button() {
		return approve_Endorsement_Button;
	}

	@FindBy(xpath = "//button[contains(@id, 'btn_approveEnd')]")
	WebElement approve_Non_Financial_Endorsement;

	public WebElement approve_Non_Financial_Endorsement() {
		return approve_Non_Financial_Endorsement;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_approveclose']") })
	WebElement Close_Button;

	public WebElement Close_Button() {
		return Close_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='sel_modeOfpay']"), @FindBy(xpath = "//select[@name='modeOfPay']") })
	WebElement mode_of_Pay_Dropdown;

	public WebElement mode_of_Pay_Dropdown() {
		return mode_of_Pay_Dropdown;
	}

	@FindBy(xpath = "//button[@id='id_cashAnalysis']")
	WebElement cash_Analysis_Button;

	public WebElement cash_Analysis_Button() {
		return cash_Analysis_Button;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='add_']") })
	WebElement add_New_Button;

	public WebElement add_New_Button() {
		return add_New_Button;
	}
	
	@FindBy(xpath="//div[contains(text(), 'Change in Policy Period can be done only for first Endorsment.')]")
	WebElement Change_PolicyPeriod_Validation;
	
	public WebElement Change_PolicyPeriod_Validation() {
		return Change_PolicyPeriod_Validation;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='cashCodes_1']"), @FindBy(xpath = "//input[@name='cashCodes']") })
	WebElement cash_Code_Checkbox;

	public WebElement cash_Code_Checkbox() {
		return cash_Code_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='cashType_1']"), @FindBy(xpath = "//select[@id='cashType_1']") })
	WebElement cash_Type_Dropdown;

	public WebElement cash_Type_Dropdown() {
		return cash_Type_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='cheqRefNo_1']"), @FindBy(xpath = "//input[@id='cheqRefNo_1']") })
	WebElement cheque_Ref_Num;

	public WebElement cheque_Ref_Num() {
		return cheque_Ref_Num;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='bankType_1']"), @FindBy(xpath = "//select[@name='bankType_1']") })
	WebElement Bank_Name_Dropdown;

	public WebElement Bank_Name_Dropdown() {
		return Bank_Name_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='accNo_1']"), @FindBy(xpath = "//input[@name='accNo_1']") })
	WebElement account_Number_Field;

	public WebElement account_Number_Field() {
		return account_Number_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='cheqEnd_1']"), @FindBy(xpath = "//input[@name='cheqEnd_1']") })
	WebElement cheque_End_Date;

	public WebElement cheque_End_Date() {
		return cheque_End_Date;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='amt_1']"), @FindBy(xpath = "//input[@name='amt_1']") })
	WebElement amount_Field;

	public WebElement amount_Field() {
		return amount_Field;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='saveCashAlys']"), @FindBy(xpath = "//button[text()=' Save']") })
	WebElement save_Cash_Analysis;

	public WebElement save_Cash_Analysis() {
		return save_Cash_Analysis;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='id_insBillAcnt']"), @FindBy(xpath = "//select[@name='insBillAcnt']") })
	WebElement Insured_Billing_Account;

	public WebElement Insured_Billing_Account() {
		return Insured_Billing_Account;
	}

	@FindAll({ @FindBy(xpath = "(//i[@id='id_deleteRisk'])[1]") })
	WebElement delete_Risk;

	public WebElement delete_Risk() {
		return delete_Risk;
	}

	@FindAll({ @FindBy(xpath = "(//button[@id='btn_common_del_save'])[3]") })
	WebElement delete_Risk_Confirm_Button;

	public WebElement delete_Risk_Confirm_Button() {
		return delete_Risk_Confirm_Button;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[@id='1']//td[7]") })
	WebElement delete_RiskSI_Value;

	public WebElement delete_RiskSI_Value() {
		return delete_RiskSI_Value;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[@id='1']//td[9]") })
	WebElement delete_RiskPremium_Value;

	public WebElement delete_RiskPremium_Value() {
		return delete_RiskPremium_Value;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='id_bicCode']"), @FindBy(xpath = "//input[@name='summaryInfo.bicCode']") })
	WebElement BIC_Code;

	public WebElement BIC_Code() {
		return BIC_Code;
	}

	@FindBy(xpath = "//input[@id='id_ibanNo']")
	WebElement SEPA_IBAN_No;

	public WebElement SEPA_IBAN_No() {
		return SEPA_IBAN_No;
	}

	@FindBy(xpath = "//input[@id='id_AccNumber']")
	WebElement SEPA_Acc_Number;

	public WebElement SEPA_Acc_Number() {
		return SEPA_Acc_Number;
	}

	@FindBy(xpath = "//input[@id='id_swiftCode']")
	WebElement SEPA_Swift_Code;

	public WebElement SEPA_Swift_Code() {
		return SEPA_Swift_Code;
	}

	@FindBy(xpath = "//select[@id='id_bankName']")
	WebElement SEPA_Bank_Name;

	public WebElement SEPA_Bank_Name() {
		return SEPA_Bank_Name;
	}

	@FindAll({ @FindBy(xpath = "(//table[@id='sumInsuredInfoTbl']//following::i[@title='Delete'])[1]") })
	WebElement delete_SMI;

	public WebElement delete_SMI() {
		return delete_SMI;
	}

	@FindAll({ @FindBy(xpath = "//td[@id='totalSmiPremFc']") })
	WebElement deleted_SMI_Premium;

	public WebElement deleted_SMI_Premium() {
		return deleted_SMI_Premium;
	}

	@FindAll({ @FindBy(xpath = "//div[@id='ApprovalErrorDiv']//ul//li") })
	WebElement Approval_Error_Msg;

	public WebElement Approval_Error_Msg() {
		return Approval_Error_Msg;
	}

	@FindBy(xpath = "//div[contains(text(),'Fac Request is Enabled')]")
	WebElement FAC_MSg;

	public WebElement FAC_MSg() {
		return FAC_MSg;
	}

	@FindBy(xpath = "//i[@class='fa fa-outdent']")
	WebElement menu_Button;

	public WebElement menu_Button() {
		return menu_Button;
	}

	@FindBy(xpath = "//span[contains(text(),'RI Confiramtion Log')]")
	WebElement RI_Confirmation_Menu;

	public WebElement RI_Confirmation_Menu() {
		return RI_Confirmation_Menu;
	}

	@FindAll({ @FindBy(xpath = "//input[@class='form-control input-sm mt-5']"),
			@FindBy(xpath = "//input[@class='form-control input-sm mt-5']") })
	WebElement search_Enq_Field;

	public WebElement search_Enq_Field() {
		return search_Enq_Field;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_proportinalRi']"),
			@FindBy(xpath = "//button[contains(text(),'Proportional RI')]") })
	WebElement proportional_RI_Button;

	public WebElement proportional_RI_Button() {
		return proportional_RI_Button;
	}

	@FindAll({ @FindBy(xpath = "(//button[@id='btn_common_del_save'])[3]") })
	WebElement yes_Button;

	public WebElement yes_Button() {
		return yes_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='poBox']"), @FindBy(xpath = "//input[@name='quoteInfo.poBox']") })
	WebElement po_Box_Field;

	public WebElement po_Box_Field() {
		return po_Box_Field;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='docCode']"), @FindBy(xpath = "//select[@id='sel_docId']") })
	WebElement Policy_Document_Dropdown;

	public WebElement Policy_Document_Dropdown() {
		return Policy_Document_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//span[@class='btn btn-file btn-blue  btn-sm dmsFile']"),
			@FindBy(xpath = "//*[@class='col-md-1 right']") })
	WebElement upload_File;

	public WebElement upload_File() {
		return upload_File;
	}

	@FindAll({ @FindBy(xpath = "//textarea[@name='quoteInfo.address1']"),
			@FindBy(xpath = "//textarea[@id='address1Id']") })
	WebElement address_Field;

	public WebElement address_Field() {
		return address_Field;
	}

	@FindBy(xpath = "//input[@id='endFromDate']")
	WebElement End_From_Date;

	public WebElement End_From_Date() {
		return End_From_Date;
	}

	@FindBy(xpath = "//input[@id='endToDate']")
	WebElement End_To_Date;

	public WebElement End_To_Date() {
		return End_To_Date;
	}

}
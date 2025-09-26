package org.pages;

import java.util.List;

import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Policy_RA_Slip_Page extends BasicFunctions {

	public Issue_Policy_RA_Slip_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//th[contains(text(),'Sum Insured')]//following-sibling::th[2])[2]")
	WebElement get_Sum_Insured_Amount;

	public WebElement get_Sum_Insured_Amount() {
		return get_Sum_Insured_Amount;
	}

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement get_Error_Msg;

	public WebElement get_Error_Msg() {
		return get_Error_Msg;
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
	WebElement Net_to_Customer;

	public WebElement Net_to_Customer() {
		return Net_to_Customer;
	}

	@FindBy(xpath = "//tr[@id='idNetShow']//td[2]")
	WebElement Net_Premium;

	public WebElement Net_Premium() {
		return Net_Premium;
	}

	@FindBy(xpath = "//div[contains(text(),'Quote No')]//following-sibling::div[1]//b")
	WebElement get_Quote_Number;

	public WebElement get_Quote_Number() {
		return get_Quote_Number;
	}

	@FindBy(xpath = "//button[@id='btn_finalQuote']")
	WebElement finalize_Quote_Button;

	public WebElement finalize_Quote_Button() {
		return finalize_Quote_Button;
	}

	@FindBy(xpath = "//button[@id='btn_approveQuote']")
	WebElement approve_Policy_Button;

	public WebElement approve_Policy_Button() {
		return approve_Policy_Button;
	}

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Quote No')]//following-sibling::div[1])[2]"),
			@FindBy(xpath = "//div[@id='quote']") })
	WebElement get_Quotation_Number;

	public WebElement get_Quotation_Number() {
		return get_Quotation_Number;
	}

	@FindBy(xpath = "(//button[@id='btn_QuoteApprContinue'])[2]")
	WebElement continue_Quote_Button;

	public WebElement continue_Quote_Button() {
		return continue_Quote_Button;
	}

	@FindBy(xpath = "//div[contains(text(),'Customer')]//following-sibling::div[1]")
	WebElement customer_Name;

	public WebElement customer_Name() {
		return customer_Name;
	}

	@FindBy(xpath = "(//div[contains(text(),'Policy Start Date')]//following-sibling::div[1])[2]")
	WebElement get_Policy_Start_Date;

	public WebElement get_Policy_Start_Date() {
		return get_Policy_Start_Date;
	}

	@FindBy(xpath = "(//div[contains(text(),'Policy End Date')]//following-sibling::div[1])[2]")
	WebElement get_Policy_End_Date;

	public WebElement get_Policy_End_Date() {
		return get_Policy_End_Date;
	}

	@FindBy(xpath = "//button[@id='btn_appprintDocs_quote']")
	WebElement print_Doc_Button;

	public WebElement print_Doc_Button() {
		return print_Doc_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='sel_modeOfpay']"), @FindBy(xpath = "//select[@name='modeOfPay']") })
	WebElement mode_of_Pay_Dropdown;

	public WebElement mode_of_Pay_Dropdown() {
		return mode_of_Pay_Dropdown;
	}

	@FindBy(xpath = "//div[@id='policy']")
	WebElement get_Policy_Number;

	public WebElement get_Policy_Number() {
		return get_Policy_Number;
	}

	@FindBy(xpath = "//button[normalize-space()='Cash Analysis']")
	WebElement cash_Analysis_Button;

	public WebElement cash_Analysis_Button() {
		return cash_Analysis_Button;
	}

	@FindBy(xpath = "//button[@id='add_']")
	WebElement add_New_Button;

	public WebElement add_New_Button() {
		return add_New_Button;
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

	@FindBy(xpath = "//div[contains(text(),'Kindly Contact RI department')]")
	WebElement RI_Approval_Msg;

	public WebElement RI_Approval_Msg() {
		return RI_Approval_Msg;
	}

	@FindBy(xpath = "//div[@id='OperStatusBlockDiv']//div[contains(text(), 'Approval request sent to')]")
	WebElement Quotation_WF_MSG;

	public WebElement Quotation_WF_MSG() {
		return Quotation_WF_MSG;
	}

	@FindBy(xpath = "(//div//h5[normalize-space()='Quote Information'])")
	WebElement Quotation_Information_RA;

	public WebElement Quotation_Information_RA() {
		return Quotation_Information_RA;
	}

	@FindBy(xpath = "//i[@class='fa fa-outdent']")
	WebElement menu_Button;

	public WebElement menu_Button() {
		return menu_Button;
	}

	@FindBy(xpath = "//span[contains(text(),'RI Confirmation Log')]")
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
	
	@FindBy(xpath="//td[@id='excessShareNewPerc']")
	WebElement Excess_Treaty_Percent;
	
	public WebElement Excess_Treaty_Percent() {
		return Excess_Treaty_Percent;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_proportinalRi']"),
			@FindBy(xpath = "//button[contains(text(),'Proportional RI')]") })
	WebElement proportional_RI_Button;

	public WebElement proportional_RI_Button() {
		return proportional_RI_Button;
	}

	@FindBy(xpath = "//button[@id='btn_prop_fac']")
	WebElement prop_FAC_Button;

	public WebElement prop_FAC_Button() {
		return prop_FAC_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='facPerc']"), @FindBy(xpath = "//input[@id='facPerc']") })
	WebElement FAC_Percentage_Field;

	public WebElement FAC_Percentage_Field() {
		return FAC_Percentage_Field;
	}

	@FindBy(xpath = "//button[@id='btn_save&Close']")
	WebElement save_and_Close_Button;

	public WebElement save_and_Close_Button() {
		return save_and_Close_Button;
	}

	@FindBy(xpath = "//textarea[@id='remarks']")
	WebElement remarks_Field;

	public WebElement remarks_Field() {
		return remarks_Field;
	}

	@FindBy(xpath = "//button[@id='btn_confirmRi']")
	WebElement confirm_RI_Button;

	public WebElement confirm_RI_Button() {
		return confirm_RI_Button;
	}

	@FindAll({ @FindBy(xpath = "(//button[@id='btn_proc'])[6]"),
			@FindBy(xpath = "(//div[contains(text(),'Do you want to Proceed')]//following::div[2]//button[1])[3]") })
	WebElement yes_Button;

	public WebElement yes_Button() {
		return yes_Button;
	}
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	WebElement RI_Confirmed_Msg;
	
	public WebElement RI_Confirmed_Msg() {
		return RI_Confirmed_Msg;
	}

	@FindBy(xpath = "(//div//h5[normalize-space()='Approval Information'])")
	WebElement Policy_Information_RA;

	public WebElement Policy_Information_RA() {
		return Policy_Information_RA;
	}

	@FindBy(xpath = "//div[contains(text(), 'Approval request sent to')]")
	WebElement Quotation_SI_WFMSG;

	public WebElement Quotation_SI_WFMSG() {
		return Quotation_SI_WFMSG;
	}

	@FindAll({ @FindBy(xpath = "//a[@title='Global Search']") })
	WebElement global_Search_Button;

	public WebElement global_Search_Button() {
		return global_Search_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_quoteNo']"), @FindBy(xpath = "//input[@name='quoteNo']") })
	WebElement Quote_Number_Field;

	public WebElement Quote_Number_Field() {
		return Quote_Number_Field;
	}

	@FindBy(xpath = "//a[@title='Search Quote']")
	WebElement quote_Search_Button;

	public WebElement quote_Search_Button() {
		return quote_Search_Button;
	}

	@FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody[1]//tr[1]//td[7]")
	WebElement get_Policy_Status;

	public WebElement get_Policy_Status() {
		return get_Policy_Status;
	}

	@FindBy(xpath = "//li[@class='dropdown nav-profile']//span")
	WebElement user_Profile;

	public WebElement user_Profile() {
		return user_Profile;
	}

	@FindAll({ @FindBy(xpath = "(//ul[@class='dropdown-menu animated littleFadeInRight']//a)[2]") })
	WebElement signout_Button;

	public WebElement signout_Button() {
		return signout_Button;
	}

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout_Button;

	public WebElement logout_Button() {
		return logout_Button;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='addParticipant']") })
	WebElement add_Participant_Button;

	public WebElement add_Participant_Button() {
		return add_Participant_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='facCustBean.qfcCustDesc']"),
			@FindBy(xpath = "//input[@id='OR_CUST_NAME']") })
	WebElement FAC_Participant_Field;

	public WebElement FAC_Participant_Field() {
		return FAC_Participant_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_qfcSharePerc']"),
			@FindBy(xpath = "//input[@name='facCustBean.qfcSharePerc']") })
	WebElement FAC_Share_Percentage;

	public WebElement FAC_Share_Percentage() {
		return FAC_Share_Percentage;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_qfcWarrentyDays']"),
			@FindBy(xpath = "//input[@name='facCustBean.qfcWarrentyDays']") })
	WebElement warranty_Days_Field;

	public WebElement warranty_Days_Field() {
		return warranty_Days_Field;
	}

	@FindAll({ @FindBy(xpath = "//div[@id='saveDiv']//button[1]") })
	WebElement save_FAC_Button;

	public WebElement save_FAC_Button() {
		return save_FAC_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='facReqStatus']"),
			@FindBy(xpath = "//select[@name='facReqLogBean.facReqStatus']") })
	WebElement RI_Status_Dropdown;

	public WebElement RI_Status_Dropdown() {
		return RI_Status_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "(//a[@id='notes_search_btn'])[1]"),
			@FindBy(xpath = "(//a[@title='Search Policies Notes'])[1]") })
	WebElement Search_Policy_Notes_Button;

	public WebElement Search_Policy_Notes_Button() {
		return Search_Policy_Notes_Button;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_confirmFac']") })
	WebElement Approve_FAC_Button;

	public WebElement Approve_FAC_Button() {
		return Approve_FAC_Button;
	}

	@FindBy(xpath = "//span[text()=' Reinsurance ']")
	WebElement Reinsurance_Menu;

	public WebElement Reinsurance_Menu() {
		return Reinsurance_Menu;
	}

//Puneeth
	// Quotation Print docs in RA slip page
	@FindAll({ @FindBy(xpath = "//*[@id='btn_appprintDocs_quote']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[6]") })
	WebElement Summary_Quotation_PrintDocs;

	public WebElement Summary_Quotation_PrintDocs() {
		return Summary_Quotation_PrintDocs;
	}

	@FindBy(xpath = "(//table//tbody//input[@name='typeRec'])")
	List<WebElement> Summary_Quotation_Checkbox;

	public List<WebElement> Summary_Quotation_Checkbox() {
		return Summary_Quotation_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "(//button[@id='printReport'])[1]"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[7]") })
	WebElement Summary_Quotation_Print;

	public WebElement Summary_Quotation_Print() {
		return Summary_Quotation_Print;
	}

	@FindBy(xpath = "(//button[@class='btn btn-warning btn-sm mr-10'])[2]")
	WebElement Summary_Quotation_Policy_Close;

	public WebElement Summary_Quotation_Policy_Close() {
		return Summary_Quotation_Policy_Close;
	}

	@FindBy(xpath = "(//button[contains(text(),'Close')])[2]")
	WebElement Summary_Policy_Print_close;

	public WebElement Summary_Policy_Print_close() {
		return Summary_Policy_Print_close;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_appprintDocs']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[6]") })
	WebElement Summary_Policy_PrintDocs;

	public WebElement Summary_Policy_PrintDocs() {
		return Summary_Policy_PrintDocs;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='typeRec_0']"), @FindBy(xpath = "(//input[@name='typeRec'])") })
	WebElement Summary_Policy_CheckBox;

	public WebElement Summary_Policy_CheckBox() {
		return Summary_Policy_CheckBox;
	}

	@FindAll({ @FindBy(xpath = "(//*[text()=' Print'])[1]"), @FindBy(xpath = "(//button[@id='printReport'])[1]") })
	WebElement Summary_Policy_Print;

	public WebElement Summary_Policy_Print() {
		return Summary_Policy_Print;
	}

	@FindBy(xpath = "//span[@id='span_TotalPendingAction']")
	WebElement Myactions_Tab;

	public WebElement Myactions_Tab() {
		return Myactions_Tab;
	}

	@FindBy(xpath = "//ul[@id='WorkflowTreeViewId_0']//a")
	List<WebElement> UW_MyAction_SubSection;

	public List<WebElement> UW_MyAction_SubSection() {
		return UW_MyAction_SubSection;
	}

	@FindBy(xpath = "//div[@id='div_tbl_search']//input")
	WebElement MyAction_Ref_Search;

	public WebElement MyAction_Ref_Search() {
		return MyAction_Ref_Search;
	}

	@FindBy(xpath = "//table[@id='WorkflowQueryTable']//span")
	WebElement Approver_Viewoption;

	public WebElement Approver_Viewoption() {
		return Approver_Viewoption;
	}

	@FindBy(xpath = "//textarea[@id='remarksTemp']")
	WebElement Approve_Remarks;

	public WebElement Approve_Remarks() {
		return Approve_Remarks;
	}

	@FindBy(xpath = "//button[@id='btn_approve']")
	WebElement WF_Approve;

	public WebElement WF_Approve() {
		return WF_Approve;
	}

	@FindBy(xpath = "//div[@id='OperStatusBlockDiv']//div")
	WebElement RA_Slip_WFMSG;

	public WebElement RA_Slip_WFMSG() {
		return RA_Slip_WFMSG;
	}

	@FindBy(xpath = "//span[contains(text(),'RI Allocation')]")
	WebElement RI_Allocation_Menu;

	public WebElement RI_Allocation_Menu() {
		return RI_Allocation_Menu;
	}

	@FindBy(xpath = "//input[@id='txt_policyno_facPlace']")
	WebElement RI_FAC_PolicyNo;

	public WebElement RI_FAC_PolicyNo() {
		return RI_FAC_PolicyNo;
	}

	@FindBy(xpath = "//select[@id='endSrNos']/option[last()]")
	WebElement RI_FAC_Trans_SrNo;

	public WebElement RI_FAC_Trans_SrNo() {
		return RI_FAC_Trans_SrNo;
	}

	@FindBy(xpath = "//select[@id='endSrNos']")
	WebElement RI_FAC_Trans_SrNo_Text;

	public WebElement RI_FAC_Trans_SrNo_Text() {
		return RI_FAC_Trans_SrNo_Text;
	}

	@FindBy(xpath = "//button[@id='btn_searchPlacement']")
	WebElement RI_FAC_Policy_Search;

	public WebElement RI_FAC_Policy_Search() {
		return RI_FAC_Policy_Search;
	}

	@FindBy(xpath = "//div[@id='forPymentLinkHide']//button[contains(text(),'Close')]")
	WebElement Quote_Print_Close;

	public WebElement Quote_Print_Close() {
		return Quote_Print_Close;
	}

	@FindBy(xpath="//input[@id='id_AccNumber']")
	WebElement SEPA_AC_Number;
	
	public WebElement SEPA_AC_Number() {
		return SEPA_AC_Number;
	}
	
	@FindBy(xpath="//input[@id='id_swiftCode']")
	WebElement SEPA_Swift_Code;
	
	public WebElement SEPA_Swift_Code() {
		return SEPA_Swift_Code;
	}
	
	@FindBy(xpath="//input[@id='id_ibanNo']")
	WebElement SEPA_IBAN;
	
	public WebElement SEPA_IBAN() {
		return SEPA_IBAN;
	}
	
	@FindBy(xpath="//select[@id='id_bankName']")
	WebElement SEPA_BankList;
	
	public WebElement SEPA_BankList() {
		return SEPA_BankList;
	}
	
	@FindBy(xpath="//input[@id='id_bicCode']")
	WebElement SEPA_BIC_Code;
	
	public WebElement SEPA_BIC_Code() {
		return SEPA_BIC_Code;
	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
//
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
//	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}

}
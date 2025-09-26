package org.pages;

import java.util.List;

import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Global_Search_Page extends BasicFunctions {

	public Global_Search_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//a[@title='Global Search']") })
	WebElement global_Search_Button;

	public WebElement global_Search_Button() {
		return global_Search_Button;
	}

	@FindBy(xpath = "//select[@id='sel_search_quote']")
	WebElement search_quote_Dropdown;

	public WebElement search_quote_Dropdown() {
		return search_quote_Dropdown;
	}

	@FindBy(xpath = "//input[@id='txt_quoteNo']")
	WebElement Quote_Number_Field;

	public WebElement Quote_Number_Field() {
		return Quote_Number_Field;
	}

	@FindBy(xpath = "//a[@id='srchQuote']")
	WebElement Quote_Search_Button;

	public WebElement Quote_Search_Button() {
		return Quote_Search_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='sel_search_policy']"), @FindBy(xpath = "//select[@name='policyBy']") })
	WebElement Search_Policy_Dropdown;

	public WebElement Search_Policy_Dropdown() {
		return Search_Policy_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_policyNo']"), @FindBy(xpath = "//input[@name='policyNo']") })
	WebElement Policy_Number_Field;

	public WebElement Policy_Number_Field() {
		return Policy_Number_Field;
	}

	@FindAll({ @FindBy(xpath = "(//a[@title='Search Policy'])[1]"), @FindBy(xpath = "//a[@id='srchPol']") })
	WebElement policy_Search_Button;

	public WebElement policy_Search_Button() {
		return policy_Search_Button;
	}

	@FindBy(xpath = "//select[@id='sel_search_claim']")
	WebElement Search_Claim_Dropdown;

	public WebElement Search_Claim_Dropdown() {
		return Search_Claim_Dropdown;
	}

	@FindBy(xpath = "//input[@id='txt_claimNo']")
	WebElement Claim_Number_Feild;

	public WebElement Claim_Number_Feild() {
		return Claim_Number_Feild;
	}

	@FindBy(xpath = "//a[@id='srchClaim']")
	WebElement Claim_Search_button;

	public WebElement Claim_Search_button() {
		return Claim_Search_button;
	}

	@FindBy(xpath = "(//input[@id='tranRecId'])[2]")
	WebElement Claim_GoTo;

	public WebElement Claim_GoTo() {
		return Claim_GoTo;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody//tr[1]//td[2]"),
			@FindBy(xpath = "(//tbody)[1]//tr[1]//td[2]") })
	WebElement Policy_Number;

	public WebElement Policy_Number() {
		return Policy_Number;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody//tr[1]//td[4]"),
			@FindBy(xpath = "(//tbody)[1]//tr[1]//td[4]") })
	WebElement Policy_Type;

	public WebElement Policy_Type() {
		return Policy_Type;
	}

	@FindAll({ @FindBy(xpath = "(//tbody)[1]//tr[1]//td[5]"),
			@FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody//tr[1]//td[5]") })
	WebElement Insured_Name;

	public WebElement Insured_Name() {
		return Insured_Name;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_endorsement']"),
			@FindBy(xpath = "//div[@class='text-center mb-10']//button[2]") })
	WebElement endorsement_Button;

	public WebElement endorsement_Button() {
		return endorsement_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='endorsementType']"),
			@FindBy(xpath = "//select[@name='endorsementType']") })
	WebElement endorsement_Type_Dropdown;

	public WebElement endorsement_Type_Dropdown() {
		return endorsement_Type_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_submit_endt']"),
			@FindBy(xpath = "//button[@class='btn btn-greensea btn-sm pull-right']") })
	WebElement proceed_Button;

	public WebElement proceed_Button() {
		return proceed_Button;
	}

	@FindBy(xpath = "//input[@id='endToDate']")
	WebElement effective_To_Date;

	public WebElement effective_To_Date() {
		return effective_To_Date;
	}

	@FindBy(xpath = "//input[@id='endFromDate']")
	WebElement effective_From_Date;

	public WebElement effective_From_Date() {
		return effective_From_Date;
	}
	
	@FindBy(xpath="//div[h4[text()='Error !!!']]")
	WebElement Endor_Date_validation;
	
	public WebElement Endor_Date_validation() {
		return Endor_Date_validation;
	}
	
	@FindBy(xpath = "//input[@id='policyStartDate' and @type='text']")	
	WebElement policy_Start_Date;

	public WebElement policy_Start_Date() {
		return policy_Start_Date;
	}

	@FindBy(xpath = "//input[@id='policyEndDate' and @type='text']")
	WebElement policy_To_Date;

	public WebElement policy_To_Date() {
		return policy_To_Date;
	}

	@FindBy(xpath = "//div[contains(text(),'Product')]//following::div[1]//span")
	WebElement get_Product;

	public WebElement get_Product() {
		return get_Product;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Policy Details')]//parent::div//child::div[1]") })
	WebElement policy_Details_Menu;

	public WebElement policy_Details_Menu() {
		return policy_Details_Menu;
	}

	@FindAll({ @FindBy(xpath = "//div[text()='P.O. Box']//following-sibling::div[1]") })
	WebElement get_po_Box_Number;

	public WebElement get_po_Box_Number() {
		return get_po_Box_Number;
	}

	@FindAll({ @FindBy(xpath = "//div[text()='Address']//following-sibling::div[1]") })
	WebElement get_Address;

	public WebElement get_Address() {
		return get_Address;
	}

	@FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody[1]//tr[1]//td[6]")
	WebElement get_Policy_From_Date;

	public WebElement get_Policy_From_Date() {
		return get_Policy_From_Date;
	}

	@FindBy(xpath = "//table[@id='dashboard_search_tbl']//tbody[1]//tr[1]//td[7]")
	WebElement get_Policy_To_Date;

	public WebElement get_Policy_To_Date() {
		return get_Policy_To_Date;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_approve_acnt']"),
			@FindBy(xpath = "//button[text()=' View Accounting ']") })
	WebElement view_Accounting_Menu;

	public WebElement view_Accounting_Menu() {
		return view_Accounting_Menu;
	}

	@FindBy(xpath = "//button[@id='btn_printDocs']")
	WebElement Policy_Print_Docs;

	public WebElement Policy_Print_Docs() {
		return Policy_Print_Docs;
	}

	@FindBy(xpath = "(//button[@id='btn_printDocs_quote'])")
	WebElement Quote_Print_Docs;

	public WebElement Quote_Print_Docs() {
		return Quote_Print_Docs;
	}
	
	@FindBy(xpath="(//button[@id='printReport'])[1]")
	WebElement Quote_Print_Report;
	
	public WebElement Quote_Print_Report() {
		return Quote_Print_Report;
	}

	@FindBy(xpath = "//*[contains(@id, 'typeRec')]")
	List<WebElement> Print_CheckBox;

	public List<WebElement> Print_CheckBox() {
		return Print_CheckBox;
	}

	@FindBy(xpath = "//div[@id='forPymentLinkHide']//button[@id='printReport']")
	WebElement Print_Docs;

	public WebElement Print_Docs() {
		return Print_Docs;
	}

	@FindBy(xpath = "//button[@id='btn_edit']")
	WebElement Quote_Edit;

	public WebElement Quote_Edit() {
		return Quote_Edit;
	}

	@FindBy(xpath = "//button[@id='btn_deleteQuote']")
	WebElement REN_Quote_Del;

	public WebElement REN_Quote_Del() {
		return REN_Quote_Del;
	}

	@FindBy(xpath = "//a[@id='renQuoteWipNo']")
	WebElement REN_Quote_Policy;

	public WebElement REN_Quote_Policy() {
		return REN_Quote_Policy;
	}

	@FindBy(xpath = "//button[@id='btn_convertToPolicy']")
	WebElement APPROVE_POLICY;

	public WebElement APPROVE_POLICY() {
		return APPROVE_POLICY;
	}

	@FindBy(xpath = "(//div[@class='modal-dialog modal-lg']//button[normalize-space()='×'])[2]")
	@CacheLookup
	WebElement Quote_Search_PrintDocs_Close;

	public WebElement Quote_Search_PrintDocs_Close() {
		return Quote_Search_PrintDocs_Close;
	}

	@FindBy(xpath = "//*[@type='checkbox']")
	List<WebElement> Search_Quotation_PrintDocs_Checkbox;

	public List<WebElement> Search_Quotation_PrintDocs_Checkbox() {
		return Search_Quotation_PrintDocs_Checkbox;
	}

	@FindBy(xpath = "//div[@id='facNotClose']//b[text()='FAC not Closed']")
	WebElement FAC_Not_Closed;

	public WebElement FAC_Not_Closed() {
		return FAC_Not_Closed;
	}

	@FindBy(xpath = "//button[@id='btn_facApp']")
	WebElement FAC_Treaty_Button;

	public WebElement FAC_Treaty_Button() {
		return FAC_Treaty_Button;
	}

	@FindBy(xpath = "//button[@id='btn_prop_fac']")
	WebElement RI_Prop_FAC;

	public WebElement RI_Prop_FAC() {
		return RI_Prop_FAC;
	}

	@FindBy(xpath = "//button[@id='btn_approve_fac_pol']")
	WebElement Approve_FAC_Button;

	public WebElement Approve_FAC_Button() {
		return Approve_FAC_Button;
	}

	@FindBy(xpath = "//button[@onclick='approveFacNow();']")
	WebElement Approve_FAC_Confirm;

	public WebElement Approve_FAC_Confirm() {
		return Approve_FAC_Confirm;
	}

	@FindBy(xpath = "//button[@id='btn_approve_tty_pol']")
	WebElement Approve_Treaty_Button;

	public WebElement Approve_Treaty_Button() {
		return Approve_Treaty_Button;
	}

	@FindBy(xpath = "//button[@id='btn_printDocs_quote']")
	WebElement SearchPage_Quote_Print_Docs;

	public WebElement SearchPage_Quote_Print_Docs() {
		return SearchPage_Quote_Print_Docs;
	}

	@FindBy(xpath = "(//button[@class='btn btn-warning btn-sm mr-10'])[1]")
	WebElement SearchPage_Quote_Print_Close;

	public WebElement SearchPage_Quote_Print_Close() {
		return SearchPage_Quote_Print_Close;
	}

	@FindBy(xpath = "//table[@id='dashboard_search_tbl']//tr[1]//td[2]")
	WebElement PolicyNo_Query;

	public WebElement PolicyNo_Query() {
		return PolicyNo_Query;
	}

	@FindBy(xpath = "//div[@id='forPymentLinkHide']//button[normalize-space()='Close']")
	WebElement Policy_Print_Close;

	public WebElement Policy_Print_Close() {
		return Policy_Print_Close;
	}
	
	@FindBy(xpath = "//button[@id='btn_printDocs']")
	WebElement VW_Acc_Print_Docs;

	public WebElement VW_Acc_Print_Docs() {
		return VW_Acc_Print_Docs;
	}
	
	@FindBy(xpath = "//select[@id='act_Searchby']")
	WebElement VW_SearchType;

	public WebElement VW_SearchType() {
		return VW_SearchType;
	}
	
	@FindBy(xpath = "//select[@id='endSrNo']")
	WebElement VW_Endorsement_Type;

	public WebElement VW_Endorsement_Type() {
		return VW_Endorsement_Type;
	}
	
	@FindBy(xpath = "//button[@id='btn_approve_tty_pol_back']")
	WebElement VW_Back_Policy;

	public WebElement VW_Back_Policy() {
		return VW_Back_Policy;
	}
	
	@FindBy(xpath = "//table[@id='acntClaimResultGrid']//tbody//tr[1]")
	WebElement View_Accounting_Record;

	public WebElement View_Accounting_Record() {
		return View_Accounting_Record;
	}
	
//	@FindBy(xpath = "")
//	WebElement ;
//
//	public WebElement () {
//		return ;
//	}

	
}
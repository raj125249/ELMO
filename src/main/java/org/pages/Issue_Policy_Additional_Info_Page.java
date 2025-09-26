package org.pages;

import java.util.List;

import org.common.BasicFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Policy_Additional_Info_Page extends BasicFunctions {

	public Issue_Policy_Additional_Info_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@id='idPlus_CoversAccordionotinfo']")
	WebElement Policy_Discounts_Loadings_Panel;

	public WebElement Policy_Discounts_Loadings_Panel() {
		return Policy_Discounts_Loadings_Panel;
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

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement DocumentUploadSuccess;

	public WebElement DocumentUploadSuccess() {
		return DocumentUploadSuccess;
	}

//policyfee	
	@FindAll({ @FindBy(xpath = "//div[@id='div_others']") })
	WebElement Pol_Discounts_Panel;

	public WebElement Pol_Discounts_Panel() {
		return Pol_Discounts_Panel;
	}

	@FindBy(xpath = "//table[@id='othersInfoTbl']//tbody[1]//td[contains(text(),'Policy Fee')]//following-sibling::td[3]")
	WebElement get_Policy_Fees;

	// table[@id='othersInfoTbl']//tbody[1]//tr[1]//td[5]
	public WebElement get_Policy_Fees() {
		return get_Policy_Fees;
	}

// policy discounts and loadings	
	@FindBy(xpath = "//button[@id='btn_others_add']")
	WebElement Add_Policy_DL;

	public WebElement Add_Policy_DL() {
		return Add_Policy_DL;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='cvrType']"), @FindBy(xpath = "//select[@name='cvrType']") })
	WebElement Policy_DL_Dropdown;

	public WebElement Policy_DL_Dropdown() {
		return Policy_DL_Dropdown;
	}

//Policy discounts 
	@FindAll({ @FindBy(xpath = "//input[@id='cvrCodes_CDP/']") })
	WebElement Policy_Discount_Checkbox;

	public WebElement Policy_Discount_Checkbox() {
		return Policy_Discount_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='rate_CDP']"), @FindBy(xpath = "//input[@name='rate_CDP']") })
	WebElement Policy_Discount_Rate;

	public WebElement Policy_Discount_Rate() {
		return Policy_Discount_Rate;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='premium_CDP']"),
			@FindBy(xpath = "(//input[contains(@id,'premium')])[5]") })
	WebElement Policy_Discont_Value;

	public WebElement get_Policy_Discont_Value() {
		return Policy_Discont_Value;
	}

	@FindBy(xpath = "(//table[@id='othersTbl']//td//input)[1]")
	WebElement MOC_Discount_Checkbox;

	public WebElement MOC_Discount_Checkbox() {
		return MOC_Discount_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='othersTbl']//td[4]//input)[1]")
	WebElement MOC_Discount_Rate;

	public WebElement MOC_Discount_Rate() {
		return MOC_Discount_Rate;
	}

	@FindAll({ @FindBy(xpath = "//button[text()=' Save']"),
			@FindBy(xpath = "//button[@class='btn btn-greensea btn-sm mr-10']") })
	WebElement Policy_DL_Save_Button;

	public WebElement Policy_DL_Save_Button() {
		return Policy_DL_Save_Button;
	}

//Policy Loadings

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[2]//td[1]//input")
	WebElement Policy_Loading_Checkbox;

	public WebElement Policy_Loading_Checkbox() {
		return Policy_Loading_Checkbox;
	}

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[2]//td[4]//input")
	WebElement Policy_Loading_Rate;

	public WebElement Policy_Loading_Rate() {
		return Policy_Loading_Rate;
	}

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[2]//td[5]//input")
	WebElement Policy_Loading_Value;

	public WebElement get_Policy_Loading_Value() {
		return Policy_Loading_Value;
	}

// Policy Deductible

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[1]//td[1]//input")
	WebElement Policy_Deductible_Checkbox;

	public WebElement Policy_Deductible_Checkbox() {
		return Policy_Deductible_Checkbox;
	}

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[1]//td[4]//select")
	WebElement Policy_Deductible_Caltype;

	public WebElement Policy_Deductible_Caltype() {
		return Policy_Deductible_Caltype;
	}

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[1]//td[5]//input")
	WebElement Policy_Deductible_Rate;

	public WebElement Policy_Deductible_Rate() {
		return Policy_Deductible_Rate;
	}

// Add Terms and conditions
	@FindAll({ @FindBy(xpath = "//*[text()=' Terms & Conditions']"),
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

	@FindBy(xpath = "(//input[@class='for_check_all'])[2]")
	WebElement Terms_Conditions_Checkbox1;

	public WebElement Terms_Conditions_Checkbox1() {
		return Terms_Conditions_Checkbox1;
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

	public WebElement Cancel_Terms_Conditions() {
		return Cancel_Terms_Conditions;
	}

//Add insured details

	@FindAll({ @FindBy(xpath = "//i[@id='idPlus_AdditionalInsuredinfoDiv']"),
			@FindBy(xpath = "(//i[@class='fa fa-plus-square'])[3]") })
	WebElement Additional_Insured_Menu;

	public WebElement Additional_Insured_Menu() {
		return Additional_Insured_Menu;
	}

	@FindAll({ @FindBy(xpath = "//button[@onclick=\"addEditAddInsured();\"]"),
			@FindBy(xpath = "//button[@id='btn_addIns']") })
	WebElement Add_Additional_Insured;

	public WebElement Add_Additional_Insured() {
		return Add_Additional_Insured;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='splitBillYn']"), @FindBy(xpath = "//select[@name='splitBillYn']") })
	WebElement Split_YN;

	public WebElement Split_YN() {
		return Split_YN;
	}

// Add Insured Name
	@FindBy(xpath = "//input[@id='insName']")
	WebElement No_AddInsured_Name;

	public WebElement No_AddInsured_Name() {
		return No_AddInsured_Name;
	}

	@FindBy(xpath = "(//input[@id='txt_custCode'])")
	WebElement Yes_AddInsured_Name;

	public WebElement Yes_AddInsured_Name() {
		return Yes_AddInsured_Name;
	}

	@FindBy(xpath = "//ul[@id='ui-id-5']//li[1]//div[1]")
	WebElement Select_Add_Insured_Name;

	public WebElement Select_Add_Insured_Name() {
		return Select_Add_Insured_Name;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='insType']"), @FindBy(xpath = "//select[@name='insType']") })
	WebElement Insured_Type;

	public WebElement Insured_Type() {
		return Insured_Type;
	}

	@FindAll({ @FindBy(xpath = "(//div[@class='col-md-4 form-group '])[1]//input"),
			@FindBy(xpath = "//input[@id='mobileAddIns']") })
	WebElement Add_Ins_Mobile_No;

	public WebElement Add_Ins_Mobile_No() {
		return Add_Ins_Mobile_No;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='idTypes']"), @FindBy(xpath = "//select[@name='idTypes']") })
	WebElement Add_Ins_Id_Types;

	public WebElement Add_Ins_Id_Types() {
		return Add_Ins_Id_Types;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='idNo']"), @FindBy(xpath = "//input[@name='idNo']") })
	WebElement AddIns_Id_No;

	public WebElement AddIns_Id_No() {
		return AddIns_Id_No;
	}

	@FindAll({ @FindBy(xpath = "(//div[@class='col-md-4 form-group '])[3]//input"),
			@FindBy(xpath = "//input[@id='emailAddIns']") })
	WebElement AddIns_Email_Id;

	public WebElement AddIns_Email_Id() {
		return AddIns_Email_Id;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='poBoxAddIns']"), @FindBy(xpath = "//input[@name='poBoxAddIns']") })
	WebElement AddIns_PO_Box;

	public WebElement AddIns_PO_Box() {
		return AddIns_PO_Box;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='relation']"), @FindBy(xpath = "//select[@name='relation']") })
	WebElement AddIns_Relation;

	public WebElement AddIns_Relation() {
		return AddIns_Relation;
	}

	@FindBy(xpath = "//select[@id='id_insBillAcnt']")
	WebElement Add_Ins_Billing_Account;

	public WebElement Add_Ins_Billing_Account() {
		return Add_Ins_Billing_Account;
	}

	@FindAll({ @FindBy(xpath = "//*[@id='addressAddIns']"), @FindBy(xpath = "//*[@name='addressAddIns']") })
	WebElement AddIns_Address;

	public WebElement AddIns_Address() {
		return AddIns_Address;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_save_AddIns']"),
			@FindBy(xpath = "//button[@onclick='javascript: saveAddIns('Save');']") })
	WebElement AddIns_Save;

	public WebElement get_AddIns_Save() {
		return AddIns_Save;
	}

	@FindAll({ @FindBy(xpath = "(//button[@class='btn btn-danger btn-sm'])[1]"),
			@FindBy(xpath = "(//i[@class='fa fa-times-circle'])[2]") })
	WebElement AddIns_Cancel;

	public WebElement get_AddIns_Cancel() {
		return AddIns_Cancel;
	}

//Survey Details
	@FindAll({ @FindBy(xpath = "//i[@id='idPlus_SurveyorInfo']"),
			@FindBy(xpath = "(//i[@class='fa fa-minus-square'])[4]") })
	WebElement Survey_Details_Menu;

	public WebElement Survey_Details_Menu() {
		return Survey_Details_Menu;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_surveyor_add']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm pull-right'])[3]") })
	WebElement Add_Surveyor_Button;

	public WebElement Add_Surveyor_Button() {
		return Add_Surveyor_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='surDate']"), @FindBy(xpath = "//input[@name='surNewDate']") })
	WebElement Survey_Date;

	public WebElement Survey_Date() {
		return Survey_Date;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='surDueDate']"), @FindBy(xpath = "//input[@name='surDDate']") })
	WebElement Survey_Due_Date;

	public WebElement get_Survey_Due_Date() {
		return Survey_Due_Date;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='surName']"), @FindBy(xpath = "//select[@name='surName']") })
	WebElement Surveyor_Name;

	public WebElement Surveyor_Name() {
		return Surveyor_Name;
	}

	@FindBy(xpath = "//ul[@id='ui-id-7']//li[1]//div[1]")
	WebElement Select_Surveyor_Name;

	public WebElement Select_Surveyor_Name() {
		return Select_Surveyor_Name;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='surRemarks']"), @FindBy(xpath = "//input[@name='surRemarks']") })
	WebElement Surveyor_Remarks;

	public WebElement get_Surveyor_Remarks() {
		return Surveyor_Remarks;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='riskType']"), @FindBy(xpath = "//select[@name='riskType']") })
	WebElement Surveyor_Risk;

	public WebElement get_Surveyor_Risk() {
		return Surveyor_Risk;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='sel_docIds']"), @FindBy(xpath = "(//select[@name='docCode'])[2]") })
	WebElement Surveyor_Doctype;

	public WebElement Surveyor_Doctype() {
		return Surveyor_Doctype;
	}

	@FindAll({ @FindBy(xpath = "(//span[@class='btn btn-file btn-blue  btn-sm dmsFile'])[2]"),
			@FindBy(xpath = "(//*[@class='fileupload-new'])[2]") })
	WebElement Surveyor_Upload;

	public WebElement Surveyor_Upload() {
		return Surveyor_Upload;
	}

	@FindAll({ @FindBy(xpath = "//button[@onclick='saveSurveyDetailsInfo();']"),
			@FindBy(xpath = "//button[@onclick='saveSurveyDetailsInfo();']") })
	WebElement Save_surveyor;

	public WebElement Save_surveyor() {
		return Save_surveyor;
	}

	@FindAll({ @FindBy(xpath = "//button[@class='btn btn-danger btn-sm']"),
			@FindBy(xpath = "//button[@onclick='cancelSurvyInfo();']") })
	WebElement Cancel_surveyor;

	public WebElement get_Cancel_surveyor() {
		return Cancel_surveyor;
	}

// coinsurance section
	@FindAll({ @FindBy(xpath = "//i[@id='idPlus_CoversAccordionosinfo']") })
	WebElement co_Insursance_Menu;

	public WebElement co_Insursance_Menu() {
		return co_Insursance_Menu;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_coins_add']") })
	WebElement add_Co_Insurance_Button;

	public WebElement add_Co_Insurance_Button() {
		return add_Co_Insurance_Button;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Our Sum Insured FC')]//following-sibling::div[1]") })
	WebElement get_Our_Sum_Insured_Amount;

	public WebElement get_Our_Sum_Insured_Amount() {
		return get_Our_Sum_Insured_Amount;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='coinsCustCodeDesc']"),
			@FindBy(xpath = "//input[@name='coinsCustCodeDesc']") })
	WebElement coinsurance_Name_Field;

	public WebElement coinsurance_Name_Field() {
		return coinsurance_Name_Field;
	}

//coinsurance 
	@FindAll({
			@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li//div[contains(text(),' ')]"),
			@FindBy(xpath = "//ul[@id='ui-id-3']//li[1]//div[1]") })
	WebElement select_Coinsurance;

	public WebElement select_Coinsurance() {
		return select_Coinsurance;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='coinsSharePrec']"), @FindBy(xpath = "//input[@name='coinsSharePrec']") })
	WebElement coinsurance_Share_Percentage_Field;

	public WebElement coinsurance_Share_Percentage_Field() {
		return coinsurance_Share_Percentage_Field;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Total Premium FC')]//following-sibling::div[1]") })
	WebElement get_Total_Premium_FC;

	public WebElement get_Total_Premium_FC() {
		return get_Total_Premium_FC;
	}

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Our Share ')]//following-sibling::div[1])[2]") })
	WebElement get_Our_Share;

	public WebElement get_Our_Share() {
		return get_Our_Share;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Our  Premium FC')]//following-sibling::div[1]") })
	WebElement get_Our_Premium;

	public WebElement get_Our_Premium() {
		return get_Our_Premium;
	}

	@FindBy(xpath = "//td[@id='totalCur1Val3']")
	WebElement co_Insurer_Share_SI;

	public WebElement co_Insurer_Share_SI() {
		return co_Insurer_Share_SI;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Total Sum Insured FC')]//following-sibling::div[1]") })
	WebElement get_Total_Sum_Insured;

	public WebElement get_Total_Sum_Insured() {
		return get_Total_Sum_Insured;
	}

	@FindBy(xpath = "//td[@id='totalCur1Val5']")
	WebElement co_Insurer_Share_Premium;

	public WebElement co_Insurer_Share_Premium() {
		return co_Insurer_Share_Premium;
	}

	@FindBy(xpath = "//input[@id='coinsLeadYN']")
	WebElement Coins_LeaderYN;

	public WebElement Coins_LeaderYN() {
		return Coins_LeaderYN;
	}

	@FindAll({ @FindBy(xpath = "get_Discount_value") })
	WebElement get_Discount_Loading_value;

	public WebElement get_Discount_Loading_value() {
		return get_Discount_Loading_value;
	}

	@FindBy(xpath = "//button[@id='btn_proceed']")
	WebElement proceed_Button;

	public WebElement proceed_Button() {
		return proceed_Button;
	}

	@FindAll({ @FindBy(xpath = "//button[contains(text(),' Save')]"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[4]") })
	WebElement Save_Coinsurance_Details;

	public WebElement Save_Coinsurance_Details() {
		return Save_Coinsurance_Details;
	}

//Introducer validations.

	@FindBy(xpath = "(//li[@class='dropdown nav-profile']//following::span[1])[1]")
	WebElement userNameField;

	public WebElement userNameField() {
		return userNameField;
	}

	@FindBy(xpath = "(//*[@class='fa fa-custom fa-pencil'])[1]")
	WebElement introducerEditBtn;

	public WebElement introducerEditBtn() {
		return introducerEditBtn;
	}

	@FindBy(xpath = "//*[@id='commAmtFc']")
	WebElement commAmtFC;

	public WebElement commAmtFC() {
		return commAmtFC;
	}

	@FindBy(xpath = "//*[@id='btn_update_broker']")
	WebElement updateBtn;

	public WebElement updateBtn() {
		return updateBtn;
	}

	@FindBy(xpath = "(//*[@class='fa fa-custom fa-pencil'])[2]")
	WebElement processorEditButton;

	public WebElement processorEditButton() {
		return processorEditButton;
	}

	@FindBy(xpath = "//table[@id='coInsuranceInfoTbl']")
	List<WebElement> Coinsurers;

	public List<WebElement> Coinsurers() {
		return Coinsurers;
	}

	@FindBy(xpath = "//table[@id='coInsuranceInfoTbl']//tbody//tr[1]//td[17]//i[1]")
	WebElement EditCoInsuranceEndInfo;

	public WebElement EditCoInsuranceEndInfo() {
		return EditCoInsuranceEndInfo;
	}

	@FindBy(xpath = "//table[@id='brokerTbl']//tbody//tr//td[contains(text(),'Introducer')]/following-sibling::td[4]")
	WebElement Intorducer_commAmtFC;

	public WebElement Intorducer_commAmtFC() {
		return Intorducer_commAmtFC;
	}

	@FindBy(xpath = "//table[@id='brokerTbl']//tbody//tr//td[contains(text(),'Processor')]/following-sibling::td[4]")
	WebElement Processor_commAmtFC;

	public WebElement Processor_commAmtFC() {
		return Processor_commAmtFC;
	}

//condominium Questionnaire.

	@FindBy(xpath = "//input[@type='radio' and @value='1']")
	List<WebElement> GQ_Yes_Option;

	public List<WebElement> GQ_Yes_Option() {
		return GQ_Yes_Option;
	}

	@FindBy(xpath = "//input[@type='text' and @name='answerText']")
	List<WebElement> GQ_Text;

	public List<WebElement> GQ_Text() {
		return GQ_Text;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
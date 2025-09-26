package org.pages;

import java.util.List;

import org.common.BasicFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Policy_Risk_Information_Page extends BasicFunctions {

	public Issue_Policy_Risk_Information_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//textarea[@id='riskTitle']"), @FindBy(xpath = "//textarea[@name='riskTitle']") })
	WebElement risk_Description_Field;

	public WebElement risk_Description_Field() {
		return risk_Description_Field;
	}
	
	@FindBy(xpath="//textarea[@id='hunterRiskDesc']")
	WebElement HunterRiskD;
	
	public WebElement HunterRiskD() {
		return HunterRiskD;
	}
	
	@FindBy(xpath="//textarea[@id='associationAddress']")
	WebElement HunterRiskAddress;
	
	public WebElement HunterRiskAddress() {
		return HunterRiskAddress;
	}
	
	@FindBy(xpath="//textarea[@id='associationContract']")
	WebElement HuntersContact;
	
	public WebElement HuntersContact() {
		return HuntersContact;
	}

	@FindBy(xpath = "//button[@id='btn_risk_add' or @id='btn_sz_add']")
	WebElement Add_Risk_Button;

	public WebElement Add_Risk_Button() {
		return Add_Risk_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='riskType']"), @FindBy(xpath = "//select[@name='riskType']") })
	WebElement Occupancy_Dropdown;

	public WebElement Occupancy_Dropdown() {
		return Occupancy_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='typeOfBuilding']"), @FindBy(xpath = "//select[@name='code15']") })
	WebElement description_Dropdown;

	public WebElement description_Dropdown() {
		return description_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='typeOfCatg']"), @FindBy(xpath = "//select[@name='riskCatg']") })
	WebElement risk_Catg_Dropdown;

	public WebElement risk_Catg_Dropdown() {
		return risk_Catg_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='address']"), @FindBy(xpath = "//input[@name='address']") })
	WebElement Location_Field;

	public WebElement Location_Field() {
		return Location_Field;
	}
	
	@FindBy(xpath="(//ul[contains(@id, 'ui-id')]//div)[1]")
	WebElement Location_List;
	
	public WebElement Location_List() {
		return Location_List;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='geoCodeLocation']"), @FindBy(xpath = "//button[@name='geoCodes']") })
	WebElement find_Latitude;

	public WebElement find_Latitude() {
		return find_Latitude;
	}

	@FindBy(xpath = "//button[@id='btn_save']")
	WebElement ok_Button;

	public WebElement ok_Button() {
		return ok_Button;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='code06']"), @FindBy(xpath = "//select[@id='code06']") }) // Specifically
	WebElement cyber_Risk_Dropdown;

	public WebElement cyber_Risk_Dropdown() {
		return cyber_Risk_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='code02']"), @FindBy(xpath = "//select[@id='code02']") }) // Contract
	WebElement select_reference;

	public WebElement select_reference() {
		return select_reference;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='data02']"), @FindBy(xpath = "//input[@name='data02']") })
	WebElement Contractor_Name;

	public WebElement Contractor_Name() {
		return Contractor_Name;
	}

//Inward section
	@FindBy(xpath = "//input[@id='inwSi']")
	WebElement Risk_Inward_SI;

	public WebElement Risk_Inward_SI() {
		return Risk_Inward_SI;
	}
	
	@FindBy(xpath="//input[@id='data03']")
	WebElement Description_Of_Goods;
	
	public WebElement Description_Of_Goods() {
		return Description_Of_Goods;
	}

	@FindBy(xpath = "//input[@id='inwPremium']")
	WebElement Risk_Inward_Premium;

	public WebElement Risk_Inward_Premium() {
		return Risk_Inward_Premium;
	}

	@FindBy(xpath = "//input[@id='inwOurSi']")
	WebElement Risk_Inward_OurSI;

	public WebElement Risk_Inward_OurSI() {
		return Risk_Inward_OurSI;
	}

	@FindBy(xpath = "//input[@id='inwOurPremium']")
	WebElement Risk_Inward_OurPremium;

	public WebElement Risk_Inward_OurPremium() {
		return Risk_Inward_OurPremium;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='saveClose']"), @FindBy(xpath="//button[normalize-space(text()) ='Save']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])") })
	WebElement save_Button;

	public WebElement save_Button() {
		return save_Button;
	}
	
	@FindBy(xpath="//button[@id='btn_saveRisk']")
	WebElement Hunters_SaveRisk;
	
	public WebElement Hunters_SaveRisk() {
		return Hunters_SaveRisk;
	}

	@FindAll({ @FindBy(xpath = "(//button[contains(text(),'Save')])[2]"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[2]") })
	WebElement Add_Risk_save_Button;

	public WebElement Add_Risk_save_Button() {
		return Add_Risk_save_Button;
	}

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement Risk_Success_Msg;

	public WebElement Risk_Success_Msg() {
		return Risk_Success_Msg;
	}

	@FindBy(xpath = "//div[contains(text(),'Quote No')]//following-sibling::div[1]//b")
	WebElement get_Quote_Number;

	public WebElement get_Quote_Number() {
		return get_Quote_Number;
	}

	@FindBy(xpath = "//td[@id='totalSiHun']")
	WebElement get_Total_SMI;

	public WebElement get_Total_SMI() {
		return get_Total_SMI;
	}

	@FindBy(xpath = "//div[contains(text(),'Type of Policy')]//following-sibling::div[1]")
	WebElement get_Type_of_Policy;

	public WebElement get_Type_of_Policy() {
		return get_Type_of_Policy;
	}

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Insured')]//following-sibling::div[1])[1]") })
	WebElement get_Insured_Name;

	public WebElement get_Insured_Name() {
		return get_Insured_Name;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[not(@style)]//td[3]")
	WebElement risk_Check_Box;

	public WebElement risk_Check_Box() {
		return risk_Check_Box;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[(@style)]//td[3]")	
	WebElement risk_Check_Box2;

	public WebElement risk_Check_Box2() {
		return risk_Check_Box2;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//td[11][.//i[2][@id='id_revertRisk']][1]/preceding-sibling::td[2]")
	WebElement RevertRisk_Premium_Value;

	public WebElement RevertRisk_Premium_Value() {
		return RevertRisk_Premium_Value;
	}
	
	@FindBy(xpath = "//table[@id='riskInfoTbl']//td[11][.//i[2][@id='id_revertRisk']][1]/preceding-sibling::td[2]")
	WebElement RevertRisk_SI_Value;

	public WebElement RevertRisk_SI_Value() {
		return RevertRisk_SI_Value;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[not(@style)]//td[1]//input")
	WebElement Del_Risk;

	public WebElement Del_Risk() {
		return Del_Risk;
	}

	@FindBy(xpath = "//button[@id='delete_marked_risk']")
	WebElement DelRisk_Yes;

	public WebElement DelRisk_Yes() {
		return DelRisk_Yes;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_smi_add']"),
			@FindBy(xpath = "//button[contains(text(),'Add SMI')]") })
	WebElement Add_SMI_Button;

	public WebElement Add_SMI_Button() {
		return Add_SMI_Button;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_app_smi']") })
	WebElement SMI_Button;

	public WebElement SMI_Button() {
		return SMI_Button;
	}

// SMI 
	
	@FindBy(xpath="//div[@id='id_smiForm']//input[@type='checkbox' and @checked]")
	List<WebElement> SMI_CheckBox_Uncheck;
	
	public List<WebElement> SMI_CheckBox_Uncheck() {
		return SMI_CheckBox_Uncheck;
	}
	
	@FindBy(xpath = "(//tr//td[3][text()='SI']//preceding-sibling::td[2]//input[1][@type='checkbox'])[1]")
	WebElement Sum_Insured_checkbox;

	public WebElement Sum_Insured_checkbox() {
		return Sum_Insured_checkbox;
	}
	
//	@FindBy(xpath="//table[@id='smisTbl_1']//tbody//tr[1]//td[1]//input[1]")
//	WebElement SMI_checkbox;

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[2]//td[1]//input[1][@checked]")
	WebElement SMI_Checked_Box;

	public WebElement SMI_Checked_Box() {
		return SMI_Checked_Box;
	}
	
	@FindAll({ @FindBy(xpath = "(//input[@name='smiCodes'])[2]"),
			@FindBy(xpath = "//table[@id='smisTbl_0']//tbody[1]//tr[2]//td[1]//input[2]") })
	WebElement Risk_Sum_Insured_checkbox;

	public WebElement Risk_Sum_Insured_checkbox() {
		return Risk_Sum_Insured_checkbox;
	}

	@FindBy(xpath = "(//tr//td[3][text()='SI']//following-sibling::td[2]//input[1][contains(@id, 'sumInsured')])[1]")
	WebElement sum_Insured_Field;

	public WebElement sum_Insured_Field() {
		return sum_Insured_Field;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='smisTbl_0']//tbody[1]//tr[2]//td[5]//input"),
			@FindBy(xpath = "(//input[contains(@id,'sumInsured')])[4]") })
	WebElement ADD_Sum_Insured_Feild;

	public WebElement ADD_Sum_Insured_Feild() {
		return ADD_Sum_Insured_Feild;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='smisTbl_0']//tbody[1]//tr[2]//td[6]//input[1]"),
			@FindBy(xpath = "(//input[contains(@name,'rate')])[3]") })
	WebElement sum_Insured_Risk_Rate_Field;

	public WebElement sum_Insured_Risk_Rate_Field() {
		return sum_Insured_Risk_Rate_Field;
	}

	@FindBy(xpath = "(//tr//td[3][text()='SI']//following-sibling::td[3]//input[@type='text'])[1]")
	WebElement sum_Insured_Rate_Field;

	public WebElement sum_Insured_Rate_Field() {
		return sum_Insured_Rate_Field;
	}

	@FindBy(xpath = "//td[@id='totalSmiPremFc']")
	WebElement SMI_Premium_Field;

	public WebElement SMI_Premium_Field() {
		return SMI_Premium_Field;
	}

	@FindAll({ @FindBy(xpath = "//td[@id='totalAnnualPremFc']") })
	WebElement Total_Risk_Annual_Premium;

	public WebElement Total_Risk_Annual_Premium() {
		return Total_Risk_Annual_Premium;
	}

	@FindAll({ @FindBy(xpath = "//td[@id='totalAnnualPremFc']") })
	WebElement SMI_Annual_Premium;

	public WebElement SMI_Annual_Premium() {
		return SMI_Annual_Premium;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_proceed']"),
			@FindBy(xpath = "//button[contains(text(),'Proceed')]") })
	WebElement Proceed_Button;

	public WebElement Proceed_Button() {
		return Proceed_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='data04']"), @FindBy(xpath = "//input[@name='data04']") })
	WebElement Limit_Per_AOA_Field;

	public WebElement Limit_Per_AOA_Field() {
		return Limit_Per_AOA_Field;
	}
	
	@FindBy(xpath="//select[@id='data05']")
	WebElement Limit_Type;
	
	public WebElement Limit_Type() {
		return Limit_Type;
	}
	
	@FindBy(xpath = "(//button[@id='btn_proc'])[4]")
	WebElement confirm_ok_Button;

	public WebElement confirm_ok_Button() {
		return confirm_ok_Button;
	}

	@FindBy(xpath = "//input[@value='Contract Works']//parent::td//preceding-sibling::td//input[1]")
	WebElement contractors_Works_Checkbox;

	public WebElement contractors_Works_Checkbox() {
		return contractors_Works_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//input[@value='Contract Works']//following::td[3]//input[1]") })
	WebElement contractors_Work_Sum_Insured;

	public WebElement contractors_Work_Sum_Insured() {
		return contractors_Work_Sum_Insured;
	}

	@FindBy(xpath = "//input[@value='Debris Removal']//parent::td//preceding-sibling::td//input[1]")
	WebElement Debris_Removal_Checkbox;

	public WebElement Debris_Removal_Checkbox() {
		return Debris_Removal_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//input[@value='Debris Removal']//following::td[3]//input[1]") })
	WebElement Debris_Removal_Sum_Insured;

	public WebElement Debris_Removal_Sum_Insured() {
		return Debris_Removal_Sum_Insured;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='data02']"), @FindBy(xpath = "//input[@name='data02']") })
	WebElement contractor_Name_Field;

	public WebElement contractor_Name_Field() {
		return contractor_Name_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='data03']"), @FindBy(xpath = "//input[@id='data03']") })
	WebElement principals_Name_Field;

	public WebElement principals_Name_Field() {
		return principals_Name_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='data07']"), @FindBy(xpath = "//input[@id='data07']") })
	WebElement site_of_Works_Field;

	public WebElement site_of_Works_Field() {
		return site_of_Works_Field;
	}

	@FindBy(xpath = "//div[contains(text(),'Master Policy No')]//following-sibling::div[1]")
	WebElement get_Master_Policy_Number;

	public WebElement get_Master_Policy_Number() {
		return get_Master_Policy_Number;
	}

//Add Discounts and Loadings button in SMI level
	
	@FindBy(xpath="//table[@id='othersTbl']//td[text()='No data available in table']")
	WebElement SMI_No_Dis_Loadings;
	
	public WebElement SMI_No_Dis_Loadings() {
		return SMI_No_Dis_Loadings;
	}

	@FindAll({ @FindBy(xpath = "(//i[@title='Discount & Loadings'])[2]"),
			@FindBy(xpath = "(onclick='addSmiOthersInfo('Add','1','1001','1','010201','M','undefined');')") })
	WebElement SMI_DL_Icon;

	public WebElement SMI_DL_Icon() {
		return SMI_DL_Icon;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_others_add']"),
			@FindBy(xpath = "//button[@onclick='addEditOthersInfoSmi('Add');']") })
	WebElement oi_add_SMI_DL;

	public WebElement oi_add_SMI_DL() {
		return oi_add_SMI_DL;
	}

	@FindAll({ @FindBy(xpath = "//div[@id='s2id_cvrType']"),
			@FindBy(xpath = "//div[@class='select2-container select-2 col-md-12 p-0']") })
	WebElement Click_Select_Dropdown;

	public WebElement Click_Select_Dropdown() {
		return Click_Select_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='cvrType']"),
			@FindBy(xpath = "//select[@onchange='loadOthersInfo(this.value, '1', 'M', '010202', '1037', '1')']") })
	WebElement SMI_DL_Dropdown;

	public WebElement SMI_DL_Dropdown() {
		return SMI_DL_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='cvrCodes_CDP/']"), @FindBy(xpath = "(//input[@value='CDP'])") })
	WebElement SMI_Discount_Checkbox;

	public WebElement SMI_Discount_Checkbox() {
		return SMI_Discount_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='rate_CDP']"), @FindBy(xpath = "//input[@id='rate_CDP']") })
	WebElement SMI_Discount_Rate;

	public WebElement SMI_Discount_Rate() {
		return SMI_Discount_Rate;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='cvrCodes_010202/']"),
			@FindBy(xpath = "(//input[@onclick='formatCheckBox_Others(this.value, this.checked);'])[2]") })
	WebElement SMI_Loading_Checkbox;

	public WebElement SMI_Loading_Checkbox() {
		return SMI_Loading_Checkbox;
	}

	@FindBy(xpath = "//table[@id='othersTbl']//tbody//tr[2]//td[4]//input")
	WebElement SMI_Loading_Rate;

	public WebElement SMI_Loading_Rate() {
		return SMI_Loading_Rate;
	}

	@FindAll({ @FindBy(xpath = "[onclick='formatCheckBox_Others(this.value, this.checked);']"),
			@FindBy(xpath = "//input[@id='cvrCodes_01']") })
	WebElement SMI_Deductible_Checkbox;

	public WebElement get_SMI_Deductible_Checkbox() {
		return SMI_Deductible_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "[onchange='getCalcTypeCode('01');']") })
	WebElement SMI_Deductible_Caltype;

	public WebElement get_SMI_Deductible_Caltype() {
		return SMI_Deductible_Caltype;
	}

	@FindAll({ @FindBy(xpath = "//td[@class=' strDataNoWrap text-center'][33]"),
			@FindBy(xpath = "//input[@id='rate_01']") })
	WebElement SMI_Deductible_Rate;

	public WebElement get_SMI_Deductible_Rate() {
		return SMI_Deductible_Rate;
	}

	@FindBy(xpath = "//div[@id='smiOthersBottomDiv']//div//button[normalize-space()='Save']")
	WebElement SMI_Discount_Loadings_Save;

	public WebElement SMI_Discount_Loadings_Save() {
		return SMI_Discount_Loadings_Save;
	}

	@FindBy(xpath = "//div[@id='smiOthersBottomDiv']//div//button[normalize-space()='Cancel']")
	WebElement SMI_Discount_Loadings_Cancel;

	public WebElement get_SMI_Discount_Loadings_Cancel() {
		return SMI_Discount_Loadings_Cancel;
	}

	@FindBy(xpath = "((//div[@class='modal-header'])//button[normalize-space()='×'])[4]")
	WebElement SMI_Discount_Loadings_Close;

	public WebElement SMI_Discount_Loadings_Close() {
		return SMI_Discount_Loadings_Close;
	}

//Puneeth
	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[1]") })
	WebElement SME_Rate_Percentage1;

	public WebElement SME_Rate_Percentage() {
		return SME_Rate_Percentage1;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[20]") })
	WebElement SME_Rate_Percentage2;

	public WebElement SME_Rate_Percentage2() {
		return SME_Rate_Percentage2;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[21]") })
	WebElement SME_Rate_Percentage3;

	public WebElement SME_Rate_Percentage3() {
		return SME_Rate_Percentage3;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[25]") })
	WebElement SME_Rate_Percentage4;

	public WebElement SME_Rate_Percentage4() {
		return SME_Rate_Percentage4;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[26]") })
	WebElement SME_Rate_Percentage5;

	public WebElement SME_Rate_Percentage5() {
		return SME_Rate_Percentage5;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[28]") })
	WebElement SME_Rate_Percentage6;

	public WebElement SME_Rate_Percentage6() {
		return SME_Rate_Percentage6;
	}

	@FindAll({ @FindBy(xpath = "(//*[@style='text-align:right'])[29]") })
	WebElement SME_Rate_Percentage7;

	public WebElement SME_Rate_Percentage7() {
		return SME_Rate_Percentage7;
	}

	@FindBy(xpath = "(//*[@style='text-align:right'])[30]")
	WebElement SME_Rate_Percentage8;

	public WebElement SME_Rate_Percentage8() {
		return SME_Rate_Percentage8;
	}

	@FindBy(xpath = "(//*[@style='text-align:right'])[31]")
	WebElement SME_Rate_Percentage9;

	public WebElement SME_Rate_Percentage9() {
		return SME_Rate_Percentage9;
	}

	@FindBy(xpath = "(//*[@style='text-align:right'])[33]")
	WebElement SME_Rate_Percentage10;

	public WebElement SME_Rate_Percentage10() {
		return SME_Rate_Percentage10;
	}

//  Erection All Risks Insurance

	@FindBy(xpath = "//ul[@id='SmiAccordion']//li//table//tbody//tr[11]//td[1]//input[1]")
	WebElement professional_Fees_Checkbox;

	public WebElement professional_Fees_Checkbox() {
		return professional_Fees_Checkbox;
	}
	
	@FindBy(xpath="//ul[@id='SmiAccordion']//li//table//tbody//tr[12]//td[1]//input[1]")
	WebElement Public_Liability_CheckBox;
	
	public WebElement Public_Liability_CheckBox() {
		return Public_Liability_CheckBox;
	}
	
	@FindBy(xpath="//ul[@id='SmiAccordion']//li//table//tbody//tr[3]//td[1]//input[1]")
	WebElement Contracts_Works_Checkbox;
	
	public WebElement Contracts_Works_Checkbox() {
		return Contracts_Works_Checkbox;
	}

	@FindBy(xpath="//ul[@id='SmiAccordion']//li//table//tbody//tr[4]//td[1]//input[1]")
	WebElement Debris_Remove_Checkbox;
	
	public WebElement Debris_Remove_Checkbox() {
		return Debris_Remove_Checkbox;
	}
	
	@FindBy(xpath="//button[contains(text(), 'Save')]")
	WebElement SMI_Save;
	
	public WebElement SMI_Save() {
		return SMI_Save;
	}

	@FindBy(xpath = "//ul[@id='SmiAccordion']//li//table//tbody//tr[11]//td[6]//input")
	WebElement professional_Fees_Rate_per;

	public WebElement professional_Fees_Rate_per() {
		return professional_Fees_Rate_per;
	}

//Edit SMI	

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr[not(@style)]//td//i[@title='Edit']")
	WebElement EditSMI_Risk;

	public WebElement EditSMI_Risk() {
		return EditSMI_Risk;
	}

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr[1]//td[12]//i[@title='Edit']")
	WebElement Edit_SMI;

	public WebElement Edit_SMI() {
		return Edit_SMI;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//tr[2]//td[11]//i[1]")
	WebElement EditRisk_Button;

	public WebElement EditRisk_Button() {
		return EditRisk_Button;
	}

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr//td[14]//i[2]")
	WebElement SMI_EDIT_ICON;

	public WebElement SMI_EDIT_ICON() {
		return SMI_EDIT_ICON;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='sumInsured']"),
			@FindBy(xpath = "(//input[@class='form-control decimal number'])[3]") })
	WebElement EDIT_SI_Value;

	public WebElement EDIT_SI_Value() {
		return EDIT_SI_Value;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='rate']"), @FindBy(xpath = "//input[@class='form-control perc number']") })
	WebElement EDIT_SI_Rate;

	public WebElement EDIT_SI_Rate() {
		return EDIT_SI_Rate;
	}

	@FindAll({ @FindBy(xpath = "//button[contains(text(),' Save')]"),
			@FindBy(xpath = "//button[@class='btn btn-greensea btn-sm mr-10']") })
	WebElement Save_EDIT_SI;

	public WebElement Save_EDIT_SI() {
		return Save_EDIT_SI;
	}

	@FindAll({ @FindBy(xpath = "(//button[@class='btn btn-danger btn-sm'])[2]"),
			@FindBy(xpath = "(//*[contains(text(),' Cancel')])[3]") })
	WebElement Cancel_EDIT_SI;

	public WebElement Cancel_EDIT_SI() {
		return Cancel_EDIT_SI;
	}

//Del SMI	
	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr[1]//td//i[@title='Delete']")
	WebElement Del_SMI;

	public WebElement Del_SMI() {
		return Del_SMI;
	}

//Risk Total Premium
	@FindBy(xpath = "//td[@id='totalPremium']")
	WebElement Risk_Total_Premium;

	public WebElement Risk_Total_Premium() {
		return Risk_Total_Premium;
	}
	
//Risk Apartment Details
	
	@FindBy(xpath="//input[@id='number01']")
	WebElement Condominium_Floors;
	
	public WebElement Condominium_Floors() {
		return Condominium_Floors;
	}
	
	@FindBy(xpath="//input[@id='number02']")
	WebElement Condominium_Apartment_Number;
	
	public WebElement Condominium_Apartment_Number() {
		return Condominium_Apartment_Number;
	}
	
	@FindBy(xpath="//input[@id='number03']")
	WebElement Condominium_Garages_Number;
	
	public WebElement Condominium_Garages_Number() {
		return Condominium_Garages_Number;
	}
	
	@FindBy(xpath="//input[@id='number04']")
	WebElement Condominium_Lifts_Number;
	
	public WebElement Condominium_Lifts_Number() {
		return Condominium_Lifts_Number;
	}
	
	@FindBy(xpath="//input[@type='checkbox' and contains(@id, 'flag') and not(@checked)]")
	List<WebElement> Condominium_Risk_insured;
	
	public List<WebElement> Condominium_Risk_insured() {
		return Condominium_Risk_insured;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//Condominium Apartment

	@FindAll({ @FindBy(xpath = "//i[@class='fa fa-building-o']"), @FindBy(xpath = "//i[@title='Apartment']") })
	WebElement Condominium_Risk_Apartment;

	public WebElement Condominium_Risk_Apartment() {
		return Condominium_Risk_Apartment;
	}

	@FindBy(xpath = "//input[@id='aptmtCodes_1']")
	WebElement Apartment_Checkbox;

	public WebElement Apartment_Checkbox() {
		return Apartment_Checkbox;
	}

	@FindBy(xpath = "//input[@id='ownerName_1']")
	WebElement Apartment_OwnerName;

	public WebElement Apartment_OwnerName() {
		return Apartment_OwnerName;
	}

	@FindBy(xpath = "//input[@id='aptGargeNo_1']")
	WebElement Apartment_Reference_Number;

	public WebElement Apartment_Reference_Number() {
		return Apartment_Reference_Number;
	}

	@FindBy(xpath = "//input[@id='insuredName_1']")
	WebElement Apartment_CivilID;

	public WebElement Apartment_CivilID() {
		return Apartment_CivilID;
	}

	@FindBy(xpath = "//select[@id='aptGarType_1']")
	WebElement Apartment_Type;

	public WebElement Apartment_Type() {
		return Apartment_Type;
	}

	@FindBy(xpath = "//select[@id='pledgeType_1']")
	WebElement Apartment_Pledge;

	public WebElement Apartment_Pledge() {
		return Apartment_Pledge;
	}

	@FindBy(xpath = "//input[@id='bankType_1']")
	WebElement Apartment_BankName;

	public WebElement Apartment_BankName() {
		return Apartment_BankName;
	}

	@FindBy(xpath = "//input[@id='branchName_1']")
	WebElement Apartment_BranchName;

	public WebElement Apartment_BranchName() {
		return Apartment_BranchName;
	}

	@FindBy(xpath = "//input[@id='signDate_1']")
	WebElement Apartment_Pledge_Date_From;

	public WebElement Apartment_Pledge_Date_From() {
		return Apartment_Pledge_Date_From;
	}

	@FindBy(xpath = "//input[@id='pldgeEnd_1']")
	WebElement Apartment_Pledge_End_Date;

	public WebElement Apartment_Pledge_End_Date() {
		return Apartment_Pledge_End_Date;
	}

	@FindBy(xpath = "//input[@id='sumInsured_1']")
	WebElement Apartment_SumInsured;

	public WebElement Apartment_SumInsured() {
		return Apartment_SumInsured;
	}

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement Apartment_Save;

	public WebElement Apartment_Save() {
		return Apartment_Save;
	}

	@FindBy(xpath = "//button[@id='add_']")
	WebElement Add_Apartment_Details;

	public WebElement Add_Apartment_Details() {
		return Add_Apartment_Details;
	}

	@FindBy(xpath = "//button[text()=' Cancel']")
	WebElement Apartment_Cancel;

	public WebElement Apartment_Cancel() {
		return Apartment_Cancel;
	}

//Machinery Condominium risk

	@FindAll({ @FindBy(xpath = "//i[@class='fa fa-gear']"), @FindBy(xpath = "//i[@title='machinery']") })
	WebElement Condominium_Risk_Machinery;

	public WebElement Condominium_Risk_Machinery() {
		return Condominium_Risk_Machinery;
	}
	
	@FindBy(xpath = "//input[@id='machCodes_1']")
	WebElement Machinery_Checkbox;

	public WebElement Machinery_Checkbox() {
		return Machinery_Checkbox;
	}

	@FindBy(xpath = "//input[@id='Description_1']")
	WebElement Machinery_Description;

	public WebElement Machinery_Description() {
		return Machinery_Description;
	}

	@FindBy(xpath = "//input[@id='serialNumber_1']")
	WebElement Machinery_SerialNumber;

	public WebElement Machinery_SerialNumber() {
		return Machinery_SerialNumber;
	}

	@FindBy(xpath = "//input[@id='makeModal_1']")
	WebElement Machinery_MakeModel;

	public WebElement Machinery_MakeModel() {
		return Machinery_MakeModel;
	}

	@FindBy(xpath = "//input[@id='yearManufre_1']")
	WebElement Machinery_Year_Manufacture;

	public WebElement Machinery_Year_Manufacture() {
		return Machinery_Year_Manufacture;
	}

	@FindBy(xpath = "//input[@id='sumInsured_1']")
	WebElement Machinery_SumInsured;

	public WebElement Machinery_SumInsured() {
		return Machinery_SumInsured;
	}

	@FindBy(xpath = "// button[@id='add_']")
	WebElement Add_Machinery_Details;

	public WebElement Add_Machinery_Details() {
		return Add_Machinery_Details;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[1]//td[6]//input")
	WebElement Cancellation_and_Curltainment;

	public WebElement Cancellation_and_Curltainment() {
		return Cancellation_and_Curltainment;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[4]//td[6]//input")
	WebElement Death;

	public WebElement Death() {
		return Death;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[5]//td[6]//input")
	WebElement Hijack;

	public WebElement Hijack() {
		return Hijack;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[7]//td[6]//input")
	WebElement Legal_Expenses;

	public WebElement Legal_Expenses() {
		return Legal_Expenses;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[8]//td[6]//input")
	WebElement Medical_and_Emergency_Expenses;

	public WebElement Medical_and_Emergency_Expenses() {
		return Medical_and_Emergency_Expenses;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[11]//td[6]//input")
	WebElement Passport_Indemnity;

	public WebElement Passport_Indemnity() {
		return Passport_Indemnity;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[12]//td[6]//input")
	WebElement Permanent_Disablement;

	public WebElement Permanent_Disablement() {
		return Permanent_Disablement;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[13]//td[6]//input")
	WebElement Personal_Baggage;

	public WebElement Personal_Baggage() {
		return Personal_Baggage;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[15]//td[6]//input")
	WebElement Personal_Liability;

	public WebElement Personal_Liability() {
		return Personal_Liability;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[16]//td[6]//input")
	WebElement Personal_Money_and_Credit_Cards;

	public WebElement Personal_Money_and_Credit_Cards() {
		return Personal_Money_and_Credit_Cards;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[18]//td[6]//input")
	WebElement Temporary_Total_Disablement;

	public WebElement Temporary_Total_Disablement() {
		return Temporary_Total_Disablement;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[20]//td[6]//input")
	WebElement Travel_Delay;

	public WebElement Travel_Delay() {
		return Travel_Delay;
	}

// Follower BS SMI validations
	@FindAll({
			@FindBy(xpath = "((//ul[@id='SmiAccordion']//li//table//tbody//td[3][text()= 'SI'])[1]/preceding-sibling::td//input[1])[1]"),
			@FindBy(xpath = "((//table[@id='smisTbl_0']//tbody//tr//td[3][text()='SI'])[1]/preceding-sibling::td//input[1])[1]")})
	WebElement Inward_OurSMI_Checkbox;

	public WebElement Inward_OurSMI_Checkbox() {
		return Inward_OurSMI_Checkbox;
	}

	@FindBy(xpath = "((//ul[@id='SmiAccordion']//li//table//tbody//td[3][text()= 'SI'])[1]/following-sibling::td//input[1])[1]")
	WebElement Inward_OurSMI_SI;

	public WebElement Inward_OurSMI_SI() {
		return Inward_OurSMI_SI;
	}

	@FindBy(xpath = "((//ul[@id='SmiAccordion']//li//table//tbody//td[3][text()= 'SI'])[1]/following-sibling::td//input[@class='form-control perc rateClass'])[1]")
	WebElement Inward_OurSMI_Rate;

	public WebElement Inward_OurSMI_Rate() {
		return Inward_OurSMI_Rate;
	}

//Discounts and Loadings Endorsements

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr[1]//td[12]//i[1]")
	WebElement View_DL_option;

	public WebElement View_DL_option() {
		return View_DL_option;
	}

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//tbody//tr[2]//td[12]//i[1]")
	WebElement View_DL_option2;

	public WebElement View_DL_option2() {
		return View_DL_option2;
	}

	@FindBy(xpath = "//button[@id='btn_others_add']")
	WebElement ADD_SMI_OI_DL;

	public WebElement ADD_SMI_OI_DL() {
		return ADD_SMI_OI_DL;
	}

	@FindBy(xpath = "//table[@id='othersInfoTbl']//tbody//tr[1]//td[7]//i")
	WebElement Endo_DL_Edit;

	public WebElement Endo_DL_Edit() {
		return Endo_DL_Edit;
	}

	@FindBy(xpath = "//input[@id='rate']")
	WebElement Edit_DLRate_Value;

	public WebElement Edit_DLRate_Value() {
		return Edit_DLRate_Value;
	}

	@FindBy(xpath = "//button[text()= ' Save']")
	WebElement Edit_DL_Save;

	public WebElement Edit_DL_Save() {
		return Edit_DL_Save;
	}

	@FindBy(xpath = "//table[@id='othersInfoTbl']//tbody//tr[2]//td[7]//i")
	WebElement Loading_Edit;

	public WebElement Loading_Edit() {
		return Loading_Edit;
	}

//change in coinsurance endorsement.
	@FindBy(xpath = "//table[@id='riskInfoTbl']//tbody//td[10]//div//i[1]")
	WebElement Risk_Edit_option;

	public WebElement Risk_Edit_option() {
		return Risk_Edit_option;
	}

	@FindBy(xpath = "(//div[@class='col-md-2 form-group decimal'][2])[1]")
	WebElement Inward_OurSI;

	public WebElement Inward_OurSI() {
		return Inward_OurSI;
	}

	@FindBy(xpath = "(//div[@class='col-md-2 form-group decimal'][2])[2]")
	WebElement Inward_OURPremium;

	public WebElement Inward_OURPremium() {
		return Inward_OURPremium;
	}

	@FindBy(xpath = "//button[@id='id_inwardCls']")
	WebElement Inward_Close;

	public WebElement Inward_Close() {
		return Inward_Close;
	}

	@FindBy(xpath = "//table[@id='sumInsuredInfoTbl']//i[2]")
	WebElement InWard_SMI_EditOption;

	public WebElement InWard_SMI_EditOption() {
		return InWard_SMI_EditOption;
	}

	@FindBy(xpath = "//input[@id='premium']")
	WebElement Inward_updated_Premium;

	public WebElement Inward_updated_Premium() {
		return Inward_updated_Premium;
	}

	@FindBy(xpath = "//input[@id='date01']")
	WebElement Maintenance_Period_FD;

	public WebElement Maintenance_Period_FD() {
		return Maintenance_Period_FD;
	}

	@FindBy(xpath = "//input[@id='effToDt']")
	WebElement Risk_Effec_TODT;

	public WebElement Risk_Effec_TODT() {
		return Risk_Effec_TODT;
	}

	@FindBy(xpath = "//input[@id='effFmDt']")
	WebElement Risk_Effec_FMDT;

	public WebElement Risk_Effec_FMDT() {
		return Risk_Effec_FMDT;
	}

	@FindBy(xpath = "(//input[contains(@onchange, 'enableSubLimit')])[1]")
	WebElement FloatingYN_Checkbox;

	public WebElement FloatingYN_Checkbox() {
		return FloatingYN_Checkbox;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableSubLimit')]/parent::td)/preceding-sibling::td[9]//input)[1]")
	WebElement FloatingYN_SMI_Checkbox;

	public WebElement FloatingYN_SMI_Checkbox() {
		return FloatingYN_SMI_Checkbox;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableSubLimit')]/parent::td)/preceding-sibling::td[3]//input)[1]")
	WebElement FloatingYN_SMI_Default_Checkbox;

	public WebElement FloatingYN_SMI_Default_Checkbox() {
		return FloatingYN_SMI_Default_Checkbox;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/preceding-sibling::td[2]//input[1])[1]")
	WebElement DeclarationYN_SMI_Checkbox;

	public WebElement DeclarationYN_SMI_Checkbox() {
		return DeclarationYN_SMI_Checkbox;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/following-sibling::td[2]//input[1])[1]")
	WebElement DeclarationYN_SMI_SI_Value;

	public WebElement DeclarationYN_SMI_SI_Value() {
		return DeclarationYN_SMI_SI_Value;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/following-sibling::td[3]//input[1])[1]")
	WebElement DeclarationYN_SMI_Rate_Value;

	public WebElement DeclarationYN_SMI_Rate_Value() {
		return DeclarationYN_SMI_Rate_Value;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/following-sibling::td[5]//input[1])[1]")
	WebElement DeclarationYN_Checkbox;

	public WebElement DeclarationYN_Checkbox() {
		return DeclarationYN_Checkbox;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/following-sibling::td[6]//input[1])[1]")
	WebElement DeclarationYN_Deposit_Percentage;

	public WebElement DeclarationYN_Deposit_Percentage() {
		return DeclarationYN_Deposit_Percentage;
	}

	@FindBy(xpath = "((//input[contains(@onchange,'enableDeposit')])/parent::td/preceding-sibling::td[5][text()='SI']/following-sibling::td[9]//input[1])[1]")
	WebElement DeclarationYN_Min_Percentage;

	public WebElement DeclarationYN_Min_Percentage() {
		return DeclarationYN_Min_Percentage;
	}

	@FindBy(xpath = "(//input[contains(@onchange,'enableDeposit')])[1]/ancestor::tr//td[1]//input[1]")
	WebElement Floating_Declaration_SMI_Checkbox;

	public WebElement Floating_Declaration_SMI_Checkbox() {
		return Floating_Declaration_SMI_Checkbox;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]/ancestor::tr//td[5]//input[1]")
	WebElement Floating_Declaration_SI_Value;
	
	public WebElement Floating_Declaration_SI_Value() {
		return Floating_Declaration_SI_Value;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]/ancestor::tr//td[7]//input")
	WebElement Floating_Declaration_DefaultYN_Checkbox;
	
	public WebElement Floating_Declaration_DefaultYN_Checkbox() {
		return Floating_Declaration_DefaultYN_Checkbox;
	}

	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]/ancestor::tr//td[8]//input")
	WebElement Floating_Declaration_SMI_Rate;
	
	public WebElement Floating_Declaration_SMI_Rate() {
		return Floating_Declaration_SMI_Rate;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]")
	WebElement Floating_Declaration_DeclarationYN;
	
	public WebElement Floating_Declaration_DeclarationYN() {
		return Floating_Declaration_DeclarationYN;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]//ancestor::tr//td[11]//input")
	WebElement Floating_Declaration_Deposit_Percentage;
	
	public WebElement Floating_Declaration_Deposit_Percentage() {
		return Floating_Declaration_Deposit_Percentage;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]//ancestor::tr//td[14]//input")
	WebElement Floating_Declaration_Minimum_Percentage;
	
	public WebElement Floating_Declaration_Minimum_Percentage() {
		return Floating_Declaration_Minimum_Percentage;
	}
	
	@FindBy(xpath="(//input[contains(@onchange,'enableDeposit')])[1]//ancestor::tr//td[16]//input")
	WebElement Floating_Declaration_FloatingYN_Checkbox;
	
	public WebElement Floating_Declaration_FloatingYN_Checkbox() {
		return Floating_Declaration_FloatingYN_Checkbox;
	}
	
	@FindBy(xpath="//table[@id='tbl_shipment']//tbody//tr//td[4]")
	WebElement Risk_Row;
	
	public WebElement Risk_Row() {
		return Risk_Row;
	}
	
	@FindBy(xpath="//input[@id='data02']")
	WebElement HS_Customer_License;
	
	public WebElement HS_Customer_License() {
		return HS_Customer_License;
	}
	
	@FindBy(xpath="//input[@id='data03']")
	WebElement HS_ToolsUsed;
	
	public WebElement HS_ToolsUsed() {
		return HS_ToolsUsed;
	}

	@FindBy(xpath="//table[@id='riskInfoGrid']//i[@title='Edit']")
	WebElement Endo_edit_risk;
	
	public WebElement Endo_edit_risk() {
		return Endo_edit_risk;
	}
	
	@FindBy(xpath="//input[@id='data08']")
	WebElement PA_Permit_No;
	
	public WebElement PA_Permit_No() {
		return PA_Permit_No;
	}
	
	@FindBy(xpath="//tr[td//a[text()='Buildings']]//input[@type='checkbox']")
	WebElement Condo_Buldings_CheckBox;
	
	public WebElement Condo_Buldings_CheckBox() {
		return Condo_Buldings_CheckBox;
	}
	
	@FindBy(xpath="(//tr[td//a[text()='Common Areas Sum Insured']]//input[@type='checkbox'])[1]")
	WebElement Condo_Com_Area_Checkbox;
	
	public WebElement Condo_Com_Area_Checkbox() {
		return Condo_Com_Area_Checkbox;
	}
	
	@FindBy(xpath="(//tr[td//a[text()='Passenger Lift Sum Insured']]//input[@type='checkbox'])[1]")
	WebElement Passenger_Lift_checkbox;
	
	public WebElement Passenger_Lift_checkbox() {
		return Passenger_Lift_checkbox;
	}
	
	@FindBy(xpath="(//tr[td//a[text()='Machinery Breakdown']]//input[@type='checkbox'])[1]")
	WebElement Machinery_BreaKDown_Checkbox;
	
	public WebElement Machinery_BreaKDown_Checkbox() {
		return Machinery_BreaKDown_Checkbox;
	}
	
	@FindBy(xpath="//tr[td[contains(., 'Buildings')]]//input[contains(@name, 'sumInsured')][1]")
	WebElement Condo_Buldings_SI;
	
	public WebElement Condo_Buldings_SI() {
		return Condo_Buldings_SI;
	}
	
	@FindBy(xpath="(//tr[td[contains(., 'Common Areas Sum Insured')]]//input[contains(@name, 'sumInsured')])[1]")
	WebElement Condo_Com_Area_SI;
	
	public WebElement Condo_Com_Area_SI() {
		return Condo_Com_Area_SI;
	}
	
	@FindBy(xpath="(//tr[td[contains(., 'Passenger Lift Sum Insured')]]//input[contains(@name, 'sumInsured')])[1]")
	WebElement Passenger_Lift_SI;
	
	public WebElement Passenger_Lift_SI() {
		return Passenger_Lift_SI;
	}
	
	@FindBy(xpath="(//tr[td[contains(., 'Machinery Breakdown')]]//input[contains(@name, 'sumInsured')])[1]")
	WebElement Machinery_BreaKDown_SI;
	
	public WebElement Machinery_BreaKDown_SI() {
		return Machinery_BreaKDown_SI;
	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}

}
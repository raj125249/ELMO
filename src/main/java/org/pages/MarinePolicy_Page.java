package org.pages;

import java.util.List;

import org.common.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarinePolicy_Page extends BaseClass {

	public MarinePolicy_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='btn_finalQuote']")
	WebElement MOC_finalize_Quotation;

	public WebElement MOC_finalize_Quotation() {
		return MOC_finalize_Quotation;
	}

	@FindBy(xpath = "(//button[@id='btn_QuoteApprContinue'])[2]")
	WebElement MOC_continue_Quote_Button;

	public WebElement MOC_continue_Quote_Button() {
		return MOC_continue_Quote_Button;
	}

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Quote No')]//following-sibling::div[1])[2]"),
			@FindBy(xpath = "//div[@id='quote']") })
	WebElement MOC_get_Quotation_Number;

	public WebElement MOC_get_Quotation_Number() {
		return MOC_get_Quotation_Number;
	}

	@FindBy(xpath = "//button[@id='btn_approveQuote']")
	WebElement MOC_approve_As_Policy_button;

	public WebElement MOC_approve_As_Policy_button() {
		return MOC_approve_As_Policy_button;
	}

	@FindBy(xpath = "//*[@class='row mt-10 mb-10']//div[2]//b")
	WebElement Marine_Certificate_Quote;

	public WebElement Marine_Certificate_Quote() {
		return Marine_Certificate_Quote;
	}

	@FindBy(xpath = "//input[@id='AS_CUST_NAME_EDIT']")
	WebElement MOC_Assured;

	public WebElement MOC_Assured() {
		return MOC_Assured;
	}

	@FindBy(xpath = "//input[@id='sailingDate']")
	WebElement MOC_Declaration_Mon_Year;

	public WebElement MOC_Declaration_Mon_Year() {
		return MOC_Declaration_Mon_Year;
	}

	@FindBy(xpath = "//select[@id='sel_conveyanceType']")
	WebElement Conveyance_Type;

	public WebElement Conveyance_Type() {
		return Conveyance_Type;
	}
	
	@FindBy(xpath="(//table[@id='tbl_bov']//i[@title='Edit'])[1]")
	WebElement Incoterms_edit_Button;
	
	public WebElement Incoterms_edit_Button() {
		return Incoterms_edit_Button;
	}
	
	@FindBy(xpath="//input[@id='basicPerValue']")
	WebElement Update_Incoterms_Percentage;
	
	public WebElement Update_Incoterms_Percentage() {
		return Update_Incoterms_Percentage;
	}
	
	@FindBy(xpath="//button[@id='btn_proc']")
	WebElement Update_Incoterms;
	
	public WebElement Update_Incoterms() {
		return Update_Incoterms;
	}

	@FindBy(xpath = "//input[@id='vesselCode']")
	WebElement MOC_Vessel_Name;

	public WebElement MOC_Vessel_Name() {
		return MOC_Vessel_Name;
	}

	@FindBy(xpath = "//select[@id='porfrm']")
	WebElement MOC_Cer_PortsFM;

	public WebElement MOC_Cer_PortsFM() {
		return MOC_Cer_PortsFM;
	}

	@FindBy(xpath = "//select[@id='porto']")
	WebElement MOC_Cer_PortsTO;

	public WebElement MOC_Cer_PortsTO() {
		return MOC_Cer_PortsTO;
	}

	@FindBy(xpath = "//input[@id='checkAllBasis']")
	WebElement MOC_Cer_Incoterms;

	public WebElement MOC_Cer_Incoterms() {
		return MOC_Cer_Incoterms;
	}
	
	@FindBy(xpath = "//input[@id='selectBasis0']")
	WebElement MOC_Cer_Partial_Incoterms;

	public WebElement MOC_Cer_Partial_Incoterms() {
		return MOC_Cer_Partial_Incoterms;
	}

	@FindBy(xpath = "//select[@id='valuationCodeId']")
	WebElement MI_Incoterms;

	public WebElement MI_Incoterms() {
		return MI_Incoterms;
	}

	@FindBy(xpath = "//input[@id='variancePerc']")
	WebElement MI_Variance;

	public WebElement MI_Variance() {
		return MI_Variance;
	}

	@FindBy(xpath = "//input[@id='bankOption1']")
	WebElement MI_Bank_YN;

	public WebElement MI_Bank_YN() {
		return MI_Bank_YN;
	}

	@FindBy(xpath = "//select[@id='bankCode']")
	WebElement MI_BankInterest;

	public WebElement MI_BankInterest() {
		return MI_BankInterest;
	}

	@FindBy(xpath = "//input[@id='lcNo']")
	WebElement Marine_LCNO;

	public WebElement Marine_LCNO() {
		return Marine_LCNO;
	}

	@FindBy(xpath = "//button[@id='saveClose']")
	WebElement MOC_shipment_Save;

	public WebElement MOC_shipment_Save() {
		return MOC_shipment_Save;
	}

	@FindBy(xpath = "//button[@id='add_invoice']")
	WebElement MOC_Cer_Goods;

	public WebElement MOC_Cer_Goods() {
		return MOC_Cer_Goods;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[1]//input)[1]")
	WebElement MOC_Goods1_Checkbox;

	public WebElement MOC_Goods1_Checkbox() {
		return MOC_Goods1_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[4]//select)[1]")
	WebElement MOC_Goods1_incoterms;

	public WebElement MOC_Goods1_incoterms() {
		return MOC_Goods1_incoterms;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[5]//input[1])[1]")
	WebElement MOC_Goods1_SI;

	public WebElement MOC_Goods1_SI() {
		return MOC_Goods1_SI;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[1]//input)[2]")
	WebElement MOC_Goods2_Checkbox;

	public WebElement MOC_Goods2_Checkbox() {
		return MOC_Goods2_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[4]//select)[2]")
	WebElement MOC_Goods2_incoterms;

	public WebElement MOC_Goods2_incoterms() {
		return MOC_Goods2_incoterms;
	}

	@FindBy(xpath = "(//table[@id='smisTbl_0']//tbody//tr//td[5]//input[1])[2]")
	WebElement MOC_Goods2_SI;

	public WebElement MOC_Goods2_SI() {
		return MOC_Goods2_SI;
	}

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement MOC_Cer_Goods_Save;

	public WebElement MOC_Cer_Goods_Save() {
		return MOC_Cer_Goods_Save;
	}

	@FindBy(xpath = "//select[@id='coverType']")
	WebElement Hull_Coverage_Type;

	public WebElement Hull_Coverage_Type() {
		return Hull_Coverage_Type;
	}
	
	@FindBy(xpath="(//table[@id='tbl_appl_conv']//i[@title='Delete'])[1]")
	WebElement Conveyance_Del;
	
	public WebElement Conveyance_Del() {
		return Conveyance_Del;
	}

//Demands and needs
	@FindBy(xpath = "//input[@id='Ans01Y']")
	WebElement DN_PowerBoat_Yes;

	public WebElement DN_PowerBoat_Yes() {
		return DN_PowerBoat_Yes;
	}

	@FindBy(xpath = "//input[@id='Ans01N']")
	WebElement DN_PowerBoat_No;

	public WebElement DN_PowerBoat_No() {
		return DN_PowerBoat_No;
	}

	@FindBy(xpath = "//input[@id='Ans02Y']")
	WebElement DN_MalteseIsland_Yes;

	public WebElement DN_MalteseIsland_Yes() {
		return DN_MalteseIsland_Yes;
	}

	@FindBy(xpath = "//input[@id='Ans02N']")
	WebElement DN_MalteseIsland_No;

	public WebElement DN_MalteseIsland_No() {
		return DN_MalteseIsland_No;
	}

	@FindBy(xpath = "//input[@id='Ans03Y']")
	WebElement DN_BoatTP_Yes;

	public WebElement DN_BoatTP_Yes() {
		return DN_BoatTP_Yes;
	}

	@FindBy(xpath = "//input[@id='Ans03N']")
	WebElement DN_BoatTP_No;

	public WebElement DN_BoatTP_No() {
		return DN_BoatTP_No;
	}

	@FindBy(xpath = "//input[@id='Ans04Y']")
	WebElement DN_Mediterrian_Yes;

	public WebElement DN_Mediterrian_Yes() {
		return DN_Mediterrian_Yes;
	}

	@FindBy(xpath = "//input[@id='Ans04N']")
	WebElement DN_Mediterrian_No;

	public WebElement DN_Mediterrian_No() {
		return DN_Mediterrian_No;
	}

	@FindBy(xpath = "//select[@id='sel_Code03']")
	WebElement Boat_Type;

	public WebElement Boat_Type() {
		return Boat_Type;
	}

	@FindBy(xpath = "//input[@id='key01']")
	WebElement Vessel_RegNo;

	public WebElement Vessel_RegNo() {
		return Vessel_RegNo;
	}

	@FindBy(xpath = "//input[@id='data19']")
	WebElement Brand;

	public WebElement Brand() {
		return Brand;
	}

	@FindBy(xpath = "//input[@id='data04']")
	WebElement Make_Model;

	public WebElement Make_Model() {
		return Make_Model;
	}

	@FindBy(xpath = "//input[@id='number16']")
	WebElement Year_make;

	public WebElement Year_make() {
		return Year_make;
	}

	@FindBy(xpath = "//select[@id='code05']")
	WebElement Usage_Type;

	public WebElement Usage_Type() {
		return Usage_Type;
	}

	@FindBy(xpath = "//select[@id='code04']")
	WebElement Navigation_Limit;

	public WebElement Navigation_Limit() {
		return Navigation_Limit;
	}

	@FindBy(xpath = "//input[@id='number11']")
	WebElement No_Of_Passengers;

	public WebElement No_Of_Passengers() {
		return No_Of_Passengers;
	}

	@FindBy(xpath = "//select[@id='sel_Code01']")
	WebElement Measuring_unit;

	public WebElement Measuring_unit() {
		return Measuring_unit;
	}

	@FindBy(xpath = "//input[@id='number05']")
	WebElement Hull_length;

	public WebElement Hull_length() {
		return Hull_length;
	}

	@FindBy(xpath = "//input[@id='number14']")
	WebElement Beam_Hull;

	public WebElement Beam_Hull() {
		return Beam_Hull;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tr//td[12]//i[@title='Period']")
	WebElement Risk_Period;

	public WebElement Risk_Period() {
		return Risk_Period;
	}

	@FindBy(xpath = "//button[@id='add_']")
	WebElement Add_Period_Tender_Engine;

	public WebElement Add_Period_Tender_Engine() {
		return Add_Period_Tender_Engine;
	}

	@FindBy(xpath = "//button[normalize-space(text()) ='Save']")
	WebElement Save;

	public WebElement Save() {
		return Save;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[1]//input)[1]")
	WebElement Period_type_Checkbox;

	public WebElement Period_type_Checkbox() {
		return Period_type_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[2]//select)[1]")
	WebElement Period_type;

	public WebElement Period_type() {
		return Period_type;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[3]//input)[1]")
	WebElement Laidup_Location;

	public WebElement Laidup_Location() {
		return Laidup_Location;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[3]//select)[1]")
	WebElement Period_type1_Location;

	public WebElement Period_type1_Location() {
		return Period_type1_Location;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[4]//input)[1]")
	WebElement Period_type1_fmdt;

	public WebElement Period_type1_fmdt() {
		return Period_type1_fmdt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[5]//input)[1]")
	WebElement Period_type1_todt;

	public WebElement Period_type1_todt() {
		return Period_type1_todt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[6]//select)[1]")
	WebElement Period_type1_Commission_type;

	public WebElement Period_type1_Commission_type() {
		return Period_type1_Commission_type;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[1]//input)[2]")
	WebElement Period_type2_Checkbox;

	public WebElement Period_type2_Checkbox() {
		return Period_type2_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[2]//select)[2]")
	WebElement Period_type2_InCommission;

	public WebElement Period_type1_InCommission() {
		return Period_type2_InCommission;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[3]//select)[2]")
	WebElement Period_type2_Location;

	public WebElement Period_type2_Location() {
		return Period_type2_Location;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[4]//input)[2]")
	WebElement Period_type2_fmdt;

	public WebElement Period_type2_fmdt() {
		return Period_type2_fmdt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[5]//input)[2]")
	WebElement Period_type2_todt;

	public WebElement Period_type2_todt() {
		return Period_type2_todt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[6]//select)[2]")
	WebElement Period_type2_Commission_type;

	public WebElement Period_type2_Commission_type() {
		return Period_type2_Commission_type;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[1]//input)[3]")
	WebElement Period_type3_Checkbox;

	public WebElement Period_type3_Checkbox() {
		return Period_type3_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[2]//select)[3]")
	WebElement Period_type3_LaidUp;

	public WebElement Period_type3_LaidUp() {
		return Period_type3_LaidUp;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[3]//input)[3]")
	WebElement Period_type3_Location;

	public WebElement Period_type3_Location() {
		return Period_type2_Location;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[4]//input)[3]")
	WebElement Period_type3_fmdt;

	public WebElement Period_type3_fmdt() {
		return Period_type3_fmdt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[5]//input)[3]")
	WebElement Period_type3_todt;

	public WebElement Period_type3_todt() {
		return Period_type3_todt;
	}

	@FindBy(xpath = "(//table[@id='prdHullTbl']//tbody//tr//td[6]//select)[3]")
	WebElement Period_type3_Commission_type;

	public WebElement Period_type3_Commission_type() {
		return Period_type3_Commission_type;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tr//td[12]//i[@title='Tender']")
	WebElement Risk_Tender;

	public WebElement Risk_Tender() {
		return Risk_Tender;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[1]//input")
	WebElement Tender_Checkbox;

	public WebElement Tender_Checkbox() {
		return Tender_Checkbox;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[2]//select")
	WebElement Tender_Type;

	public WebElement Tender_Type() {
		return Tender_Type;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[3]//input")
	WebElement Tender_value;

	public WebElement Tender_value() {
		return Tender_value;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[4]//input")
	WebElement Tender_Make;

	public WebElement Tender_Make() {
		return Tender_Make;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[5]//input")
	WebElement Tender_Model;

	public WebElement Tender_Model() {
		return Tender_Model;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[6]//input")
	WebElement Tender_Make_Year;

	public WebElement Tender_Make_Year() {
		return Tender_Make_Year;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[7]//input")
	WebElement Tender_EngineMake;

	public WebElement Tender_EngineMake() {
		return Tender_EngineMake;
	}

	@FindBy(xpath = "//table[@id='tenderTbl']//tbody//tr[2]//td[8]//input")
	WebElement Tender_HP;

	public WebElement Tender_HP() {
		return Tender_HP;
	}

	@FindBy(xpath = "//table[@id='riskInfoTbl']//tr//td[12]//i[@title='Engine']")
	WebElement Risk_Engine;

	public WebElement Risk_Engine() {
		return Risk_Engine;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[1]//input)")
	WebElement Engine1_Checkbox;

	public WebElement Engine1_Checkbox() {
		return Engine1_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[2]//input)")
	WebElement Engine_Make;

	public WebElement Engine_Make() {
		return Engine_Make;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[3]//input)")
	WebElement Engine_Model;

	public WebElement Engine_Model() {
		return Engine_Model;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[4]//input)")
	WebElement Engine_Manufacture_Year;

	public WebElement Engine_Manufacture_Year() {
		return Engine_Manufacture_Year;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[5]//input)")
	WebElement Engine_SerialNo;

	public WebElement Engine_SerialNo() {
		return Engine_SerialNo;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[6]//input)")
	WebElement Engine_Fuel;

	public WebElement Engine_Fuel() {
		return Engine_Fuel;
	}

	@FindBy(xpath = "(//table[@id='engineTbl']//tbody//tr[2]//td[7]//input)")
	WebElement Engine_Capacity;

	public WebElement Engine_Capacity() {
		return Engine_Capacity;
	}

	@FindBy(xpath = "//i[@class='fa fa-arrow-circle-down']")
	WebElement Driver_Details_Arrow_Mark;

	public WebElement Driver_Details_Arrow_Mark() {
		return Driver_Details_Arrow_Mark;
	}

	@FindBy(xpath = "//button[@id='btn_driver_add']")
	WebElement Driver_Add;

	public WebElement Driver_Add() {
		return Driver_Add;
	}

	@FindBy(xpath = "//table[@id='DriverInfoTbl']//td[6]//i[@title='Edit']")
	WebElement Drivers_Edit;

	public WebElement Drivers_Edit() {
		return Drivers_Edit;
	}

	@FindBy(xpath = "//input[@id='drvCustCodeAuto']")
	WebElement Driver_Name;

	public WebElement Driver_Name() {
		return Driver_Name;
	}

	@FindBy(xpath = "//input[@id='qraData03']")
	WebElement Driver_Experience;

	public WebElement Driver_Experience() {
		return Driver_Experience;
	}

	@FindBy(xpath = "//input[@id='qraDate01']")
	WebElement Driver_DOB;

	public WebElement Driver_DOB() {
		return Driver_DOB;
	}

	@FindBy(xpath = "//a[text()='Death']/ancestor::td//input[1]")
	WebElement DeathSMI_Checkbox;

	public WebElement DeathSMI_Checkbox() {
		return DeathSMI_Checkbox;
	}

	@FindBy(xpath = "//a[text()='Death']/ancestor::td//following-sibling::td[4]//input[1]")
	WebElement DeathSMI_SIvalue;

	public WebElement DeathSMI_SIvalue() {
		return DeathSMI_SIvalue;
	}

	@FindBy(xpath = "//a[text()='Death']/ancestor::td//following-sibling::td[5]//input[1]")
	WebElement DeathSMI_Rate;

	public WebElement DeathSMI_Rate() {
		return DeathSMI_Rate;
	}

	@FindBy(xpath = "//a[text()='Hull']/ancestor::td//input[1]")
	WebElement SMI_HULL_Checkbox;

	public WebElement SMI_HULL_Checkbox() {
		return SMI_HULL_Checkbox;
	}

	@FindBy(xpath = "//a[text()='Hull']/ancestor::td//following-sibling::td[4]//input[1]")
	WebElement SMI_Hull_SI_Value;

	public WebElement SMI_Hull_SI_Value() {
		return SMI_Hull_SI_Value;
	}

	@FindBy(xpath = "//a[text()='Medical Payments']/ancestor::td//following-sibling::td[4]//input[1]")
	WebElement MedicalPayments_SI_Value;

	public WebElement MedicalPayments_SI_Value() {
		return MedicalPayments_SI_Value;
	}

	@FindBy(xpath ="//a[text()='Medical Payments']/ancestor::td//input[1]")
	WebElement MedicalPayments_CheckBox;

	public WebElement MedicalPayments_CheckBox() {
		return MedicalPayments_CheckBox;
	}
	
	@FindBy(xpath="//a[text()='Medical Payments']/ancestor::td//following-sibling::td[5]//input[1]")
	WebElement MedicalPayments_SI_Rate;
	
	public WebElement MedicalPayments_SI_Rate() {
		return MedicalPayments_SI_Rate;
	}

	@FindBy(xpath = "//input[@id='idCheck_G1_1']")
	WebElement pleasure_purposes_yes;

	public WebElement pleasure_purposes_yes() {
		return pleasure_purposes_yes;
	}

	@FindBy(xpath = "//input[@id='answerText_G2']")
	WebElement years_of_experience;

	public WebElement years_of_experience() {
		return years_of_experience;
	}

	@FindBy(xpath = "//input[@id='idCheck_G3_1']")
	WebElement Boat_license;

	public WebElement Boat_license() {
		return Boat_license;
	}

	@FindBy(xpath = "//input[@id='answerText_G4']")
	WebElement boat_handling;

	public WebElement boat_handling() {
		return boat_handling;
	}

	@FindBy(xpath = "//input[@id='idCheck_G5_1']")
	WebElement Owner_Craft;

	public WebElement Owner_Craft() {
		return Owner_Craft;
	}

	@FindBy(xpath = "//input[@id='idCheck_G6_1']")
	WebElement Craft_CurrentlyConvicted;

	public WebElement Craft_CurrentlyConvicted() {
		return Craft_CurrentlyConvicted;
	}

	@FindBy(xpath = "//input[@id='idCheck_G7_1']")
	WebElement Craft_lost_5years;

	public WebElement Craft_lost_5years() {
		return Craft_lost_5years;
	}

	@FindBy(xpath = "//input[@id='idCheck_G8_1']")
	WebElement Craft_Cancelled;

	public WebElement Craft_Cancelled() {
		return Craft_Cancelled;
	}

	@FindBy(xpath = "//input[@id='idCheck_G9_1']")
	WebElement Sustain_Damages;

	public WebElement Sustain_Damages() {
		return Sustain_Damages;
	}

	@FindBy(xpath = "//input[@id='idCheck_G10_1']")
	WebElement Craft_Converted;

	public WebElement Craft_Converted() {
		return Craft_Converted;
	}

	@FindBy(xpath = "(//div[@class='ui-pnotify-text'])[1]")
	WebElement DN_AlertMSG;

	public WebElement DN_AlertMSG() {
		return DN_AlertMSG;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[1]//td[1]//input")
	WebElement MI_1SMI_Checkbox;

	public WebElement MI_1SMI_Checkbox() {
		return MI_1SMI_Checkbox;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[1]//td[3]//select")
	WebElement MI_1SMI_Clauses;

	public WebElement MI_1SMI_Clauses() {
		return MI_1SMI_Clauses;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[1]//td[4]//input")
	WebElement MI_1SMI_SIvalue;

	public WebElement MI_1SMI_SIvalue() {
		return MI_1SMI_SIvalue;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[1]//td[7]//input")
	WebElement MI_1SMI_Rate;

	public WebElement MI_1SMI_Rate() {
		return MI_1SMI_Rate;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[2]//td[1]//input")
	WebElement MI_2SMI_Checkbox;

	public WebElement MI_2SMI_Checkbox() {
		return MI_2SMI_Checkbox;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[2]//td[3]//select")
	WebElement MI_2SMI_Clauses;

	public WebElement MI_2SMI_Clauses() {
		return MI_2SMI_Clauses;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[2]//td[4]//input")
	WebElement MI_2SMI_SIvalue;

	public WebElement MI_2SMI_SIvalue() {
		return MI_2SMI_SIvalue;
	}

	@FindBy(xpath = "//table[@id='smisTbl_0']//tbody//tr[2]//td[7]//input")
	WebElement MI_2SMI_Rate;

	public WebElement MI_2SMI_Rate() {
		return MI_2SMI_Rate;
	}

	@FindBy(xpath = "//td[@id='totalAnnualPremium']")
	WebElement MC_Shipment_AnnualPremium;

	public WebElement MC_Shipment_AnnualPremium() {
		return MC_Shipment_AnnualPremium;
	}

	@FindBy(xpath = "//td[@id='tot_Annl']")
	WebElement MC_SMI_AnnualPRemium;

	public WebElement MC_SMI_AnnualPRemium() {
		return MC_SMI_AnnualPRemium;
	}
	
	@FindBy(xpath="//td[@id='tot_prem']")
	WebElement MI_SMIPremium;
	
	public WebElement MI_SMIPremium() {
		return MI_SMIPremium;
	}

	@FindBy(xpath = "//div[@id='OperStatusBlockDiv']//div")
	WebElement MOC_Quote_WF_MSG;

	public WebElement MOC_Quote_WF_MSG() {
		return MOC_Quote_WF_MSG;
	}

	@FindBy(xpath = "//*[@id='OperStatusBlockDiv']/div/div/div[2]/div[6]/div/text()")
	WebElement MOC_Policy_WF_MSG;

	// *[normalize-space(@class) ='col-md-12 text-left alert alert-warning']
	public WebElement MOC_Policy_WF_MSG() {
		return MOC_Policy_WF_MSG;
	}

//Marine Hull Discounts

//policy discounts
	@FindAll({ @FindBy(xpath = "//input[@id='cvrCodes_CCSD/']") })
	WebElement Policy_Discount_Checkbox;

	public WebElement Policy_Discount_Checkbox() {
		return Policy_Discount_Checkbox;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='rate_CCSD']"), @FindBy(xpath = "//input[@name='rate_CCSD']") })
	WebElement Policy_Discount_Rate;

	public WebElement Policy_Discount_Rate() {
		return Policy_Discount_Rate;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='premium_CCSD']"),
			@FindBy(xpath = "(//input[contains(@id,'premium')])[2]") })
	WebElement Policy_Discont_Value;

	public WebElement Policy_Discont_Value() {
		return Policy_Discont_Value;
	}

	@FindAll({ @FindBy(xpath = "//button[text()=' Save']"),
			@FindBy(xpath = "//button[@class='btn btn-greensea btn-sm mr-10']") })
	WebElement Policy_DL_Save_Button;

	public WebElement Policy_DL_Save_Button() {
		return Policy_DL_Save_Button;
	}

	// Policy Loadings

	@FindBy(xpath = "//textarea[text()='Policy Level Loadings']//ancestor::td//preceding-sibling::td[2]//input")
	WebElement Policy_Loading_Checkbox;

	public WebElement Policy_Loading_Checkbox() {
		return Policy_Loading_Checkbox;
	}

	@FindBy(xpath = "//textarea[text()='Policy Level Loadings']//ancestor::td//following-sibling::td[1]//input")
	WebElement Policy_Loading_Rate;

	public WebElement Policy_Loading_Rate() {
		return Policy_Loading_Rate;
	}

	@FindBy(xpath = "//textarea[text()='Policy Level Loadings']//ancestor::td//following-sibling::td[2]//input[1]")
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

	@FindBy(xpath="//input[@id='cvrCodes_OD/']")
	WebElement MI_SMI_Discount_Checkbox;

	public WebElement MI_SMI_Discount_Checkbox() {
		return MI_SMI_Discount_Checkbox;
	}
	
	@FindBy(xpath="//input[@id='rate_OD']")
	WebElement MI_SMI_Discount_rate;

	public WebElement MI_SMI_Discount_rate() {
		return MI_SMI_Discount_rate;
	}
	
	@FindBy(xpath="//input[@id='cvrCodes_060101/']")
	WebElement MI_SMI_Loading_Checkbox;

	public WebElement MI_SMI_Loading_Checkbox() {
		return MI_SMI_Loading_Checkbox;
	}
	
	@FindBy(xpath="//input[@id='rate_060101']")
	WebElement MI_SMI_Loading_Rate;

	public WebElement MI_SMI_Loading_Rate() {
		return MI_SMI_Loading_Rate;
	}
	
	@FindBy(xpath = "//input[@id='marSumInsured']")
	WebElement MOC_Annual_TurnOver;

	public WebElement MOC_Annual_TurnOver() {
		return MOC_Annual_TurnOver;
	}

	@FindBy(xpath = "//input[@id='limitPerShip']")
	WebElement MOC_Limit_per_Shipment;

	public WebElement MOC_Limit_per_Shipment() {
		return MOC_Limit_per_Shipment;
	}

	@FindBy(xpath = "//input[@id='form_risk_marineBean_minPrem']")
	WebElement MOC_Min_Premium;

	public WebElement MOC_Min_Premium() {
		return MOC_Min_Premium;
	}

	@FindBy(xpath = "//select[@id='bank_List']")
	WebElement MOC_Banklist;

	public WebElement MOC_Banklist() {
		return MOC_Banklist;
	}
	
	@FindBy(xpath="//input[@id='form_risk_marineBean_bankCode']")
	WebElement MOC_Bank;
	
	public WebElement MOC_Bank() {
		return MOC_Bank;
	}

	@FindAll({ @FindBy(xpath = "//i[@id='idPlus_CoversAccordionosinfo']") })
	WebElement MOC_CoInsursance_Menu;

	public WebElement MOC_CoInsursance_Menu() {
		return MOC_CoInsursance_Menu;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_coins_add']") })
	WebElement MOC_add_CoInsurance_Button;

	public WebElement MOC_add_CoInsurance_Button() {
		return MOC_add_CoInsurance_Button;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Our Sum Insured FC')]//following-sibling::div[1]") })
	WebElement MOC_get_Our_Sum_Insured_Amount;

	public WebElement MOC_get_Our_Sum_Insured_Amount() {
		return MOC_get_Our_Sum_Insured_Amount;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='coinsCustCodeDesc']"),
			@FindBy(xpath = "//input[@name='coinsCustCodeDesc']") })
	WebElement MOC_coinsurance_Name_Field;

	public WebElement MOC_coinsurance_Name_Field() {
		return MOC_coinsurance_Name_Field;
	}

//coinsurance 
	@FindAll({
			@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li//div[contains(text(),' ')]"),
			@FindBy(xpath = "//ul[@id='ui-id-3']//li[1]//div[1]") })
	WebElement MOC_select_Coinsurance;

	public WebElement MOC_select_Coinsurance() {
		return MOC_select_Coinsurance;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='coinsSharePrec']"), @FindBy(xpath = "//input[@name='coinsSharePrec']") })
	WebElement MOC_coinsurance_Share_Percentage_Field;

	public WebElement MOC_coinsurance_Share_Percentage_Field() {
		return MOC_coinsurance_Share_Percentage_Field;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Total Premium FC')]//following-sibling::div[1]") })
	WebElement MOC_get_Total_Premium_FC;

	public WebElement MOC_get_Total_Premium_FC() {
		return MOC_get_Total_Premium_FC;
	}

	@FindAll({ @FindBy(xpath = "(//div[contains(text(),'Our Share ')]//following-sibling::div[1])[2]") })
	WebElement MOC_get_Our_Share;

	public WebElement MOC_get_Our_Share() {
		return MOC_get_Our_Share;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Our  Premium FC')]//following-sibling::div[1]") })
	WebElement MOC_get_Our_Premium;

	public WebElement MOC_get_Our_Premium() {
		return MOC_get_Our_Premium;
	}

	@FindBy(xpath = "//td[@id='totalCur1Val3']")
	WebElement MOC_CoInsurer_Share_SI;

	public WebElement MOC_CoInsurer_Share_SI() {
		return MOC_CoInsurer_Share_SI;
	}

	@FindAll({ @FindBy(xpath = "//div[contains(text(),'Total Sum Insured FC')]//following-sibling::div[1]") })
	WebElement MOC_get_Total_Sum_Insured;

	public WebElement MOC_get_Total_Sum_Insured() {
		return MOC_get_Total_Sum_Insured;
	}

	@FindBy(xpath = "//td[@id='totalCur1Val5']")
	WebElement MOC_CoInsurer_Share_Premium;

	public WebElement MOC_CoInsurer_Share_Premium() {
		return MOC_CoInsurer_Share_Premium;
	}

	@FindBy(xpath = "//input[@id='coinsLeadYN']")
	WebElement MOC_Coins_LeaderYN;

	public WebElement MOC_Coins_LeaderYN() {
		return MOC_Coins_LeaderYN;
	}

	@FindAll({ @FindBy(xpath = "//button[contains(text(),' Save')]"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[4]") })
	WebElement MOC_Save_Coinsurance_Details;

	public WebElement MOC_Save_Coinsurance_Details() {
		return MOC_Save_Coinsurance_Details;
	}

	@FindBy(xpath = "//button[@id='btn_saveRisk']")
	WebElement MOC_Save_Risk;
						
	public WebElement MOC_Save_Risk() {
		return MOC_Save_Risk;
	}

	@FindBy(xpath = "//button[@id='btn_app_basis']")
	WebElement MOC_Applicable_Incoterms;

	public WebElement MOC_Applicable_Incoterms() {
		return MOC_Applicable_Incoterms;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr[1]//td[1]//input)[1]")
	WebElement MOC_CC_Checkbox;

	public WebElement MOC_CC_Checkbox() {
		return MOC_CC_Checkbox;
	}

	@FindBy(xpath="(//table[@id='tbl_bov_all_enterues_for_select']//tr[6]//td[1]//input)[1]")
	WebElement MOC_CPT_Checkbox;
	
	public WebElement MOC_CPT_Checkbox() {
		return MOC_CPT_Checkbox;
	}
	
	@FindBy(xpath="(//table[@id='tbl_bov_all_enterues_for_select']//tr[6]//td[3]//input)[1]")
	WebElement MOC_CPT_Value;
	
	public WebElement MOC_CPT_Value() {
		return MOC_CPT_Value;
	}
	
	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr[1]//td[3]//input)[1]")
	WebElement MOC_CC_Value;

	public WebElement MOC_CC_Value() {
		return MOC_CC_Value;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr[3]//td[1]//input)[1]")
	WebElement MOC_CFR_Checkbox;

	public WebElement MOC_CFR_Checkbox() {
		return MOC_CFR_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr[3]//td[3]//input)[1]")
	WebElement MOC_CFR_Value;

	public WebElement MOC_CFR_Value() {
		return MOC_CFR_Value;
	}

	@FindBy(xpath = "//button[@onclick='saveBOV();']")
	WebElement MOC_Save_Close;

	public WebElement MOC_Save_Close() {
		return MOC_Save_Close;
	}

	@FindBy(xpath = "(//div[@class='btn-group'])[2]")
	WebElement MOC_Applicable_Conveyance;

	public WebElement MOC_Applicable_Conveyance() {
		return MOC_Applicable_Conveyance;
	}

	@FindBy(xpath = "(//ul[@class='multiselect-container dropdown-menu'])[2]//li[2]//input")
	WebElement MOC_BySea;

	public WebElement MOC_BySea() {
		return MOC_BySea;
	}

	@FindBy(xpath = "(//ul[@class='multiselect-container dropdown-menu'])[2]//li[3]//input")
	WebElement MOC_ByAir;

	public WebElement MOC_ByAir() {
		return MOC_ByAir;
	}
	
	@FindBy(xpath="(//ul[@class='multiselect-container dropdown-menu'])[2]//li[3]//input")
	WebElement MOC_ByLand;
	
	public WebElement MOC_ByLand() {
		return MOC_ByLand;
	}

	@FindBy(xpath = "(//ul[@class='multiselect-container dropdown-menu'])[2]//li[5]//input")
	WebElement MOC_By_Air_Sea_Land;

	public WebElement MOC_By_Air_Sea_Land() {
		return MOC_By_Air_Sea_Land;
	}
	
	@FindBy(xpath = "(//div[@class='btn-group'])[3]")
	WebElement MOC_ImportsFrm;

	public WebElement MOC_ImportsFrm() {
		return MOC_ImportsFrm;
	}

	@FindBy(xpath="//div[@class='btn-group open']//ul//li//a//label[normalize-space()='A.G.C.C.']")
	WebElement MOC_AGCC;

	public WebElement MOC_AGCC() {
		return MOC_AGCC;
	}

	@FindBy(xpath = "//div[@class='btn-group open']//ul//li//a//label[normalize-space()='Abha/SaudiArabia']")
	WebElement MOC_Abha_SaudiArabia;

	public WebElement MOC_Abha_SaudiArabia() {
		return MOC_Abha_SaudiArabia;
	}

	@FindBy(xpath = "//div[@class='btn-group open']//ul//li//a//label[normalize-space()='AbuDhabi/U.A.E.']")
	WebElement MOC_AbuDhabi_UAE;

	public WebElement MOC_AbuDhabi_UAE() {
		return MOC_AbuDhabi_UAE;
	}
	
	@FindBy(xpath="//div[@id='sel_port_fm1']//input[@type='checkbox' and not(@value='multiselect-all')]")
	List<WebElement> Add_Port_FM;
	
	public List<WebElement> Add_Port_FM() {
		return Add_Port_FM;
	}
	
	@FindBy(xpath="//div[@id='sel_port_to1']//input[@type='checkbox' and not(@value='multiselect-all')]")
	List<WebElement> Add_Port_To;
	
	public List<WebElement> Add_Port_To() {
		return Add_Port_To;
	}

	@FindBy(xpath = "//div[@id='sel_port_to1']//div//button[normalize-space()='ADD']")
	WebElement MOC_ExportsTo;

	public WebElement MOC_ExportsTo() {
		return MOC_ExportsTo;
	}
	
	@FindBy(xpath="//*[@id='sel_port_to1']")
	WebElement MOC_exports;
	
	public WebElement MOC_exports() {
		return MOC_exports;
	}

	@FindBy(xpath = "//div[@class='btn-group open']//ul//li//a//label[normalize-space()='Abudhabi']")
	WebElement MOC_Abudhabi;

	public WebElement MOC_Abudhabi() {
		return MOC_Abudhabi;
	}

	@FindBy(xpath = "//div[@class='btn-group open']//ul//li//a//label[normalize-space()='Aden/Yemen']")
	WebElement MOC_Aden_Yemen;

	public WebElement MOC_Aden_Yemen() {
		return MOC_Aden_Yemen;
	}

	@FindBy(xpath = "//div[@class='btn-group open']//ul//li//a//label[normalize-space()='Afghanistan']")
	WebElement MOC_Afghanistan;

	public WebElement MOC_Afghanistan() {
		return MOC_Afghanistan;
	}
	
	@FindBy(xpath="//div[@class='btn-group open']//ul//li//a//label[normalize-space()='Comoros']")
	WebElement MOC_Comoros;
	
	public WebElement MOC_Comoros() {
		return MOC_Comoros;
	}

	@FindBy(xpath = "//button[@id='btn_goods']")
	WebElement MOC_Goods;

	public WebElement MOC_Goods() {
		return MOC_Goods;
	}

	@FindBy(xpath = "//table[@id='tbl_bov_all_enterues_for_select']//tr[1]//td[1]//input")
	WebElement MOC_Alcoholic_Beverages_Checkbox;

	public WebElement MOC_Alcoholic_Beverages_Checkbox() {
		return MOC_Alcoholic_Beverages_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[3]//select)[1]")
	WebElement MOC_Alcoholic_Beverages_Clauses;

	public WebElement MOC_Alcoholic_Beverages_Clauses() {
		return MOC_Alcoholic_Beverages_Clauses;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[4]//input[1])[1]")
	WebElement MOC_Alcoholic_Beverages_Rate;

	public WebElement MOC_Alcoholic_Beverages_Rate() {
		return MOC_Alcoholic_Beverages_Rate;
	}

	@FindBy(xpath = "//table[@id='tbl_bov_all_enterues_for_select']//tr[2]//td[1]//input")
	WebElement MOC_Building_Materials_Checkbox;

	public WebElement MOC_Building_Materials_Checkbox() {
		return MOC_Building_Materials_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[3]//select)[2]")
	WebElement MOC_Building_Materials_Clauses;

	public WebElement MOC_Building_Materials_Clauses() {
		return MOC_Building_Materials_Clauses;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[4]//input[1])[2]")
	WebElement MOC_Building_Materials_Rate;

	public WebElement MOC_Building_Materials_Rate() {
		return MOC_Building_Materials_Rate;
	}

	@FindBy(xpath = "//table[@id='tbl_bov_all_enterues_for_select']//tr[4]//td[1]//input")
	WebElement MOC_Cereals_Checkbox;

	public WebElement MOC_Cereals_Checkbox() {
		return MOC_Cereals_Checkbox;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[3]//select)[4]")
	WebElement MOC_Cereals_Clauses;

	public WebElement MOC_Cereals_Clauses() {
		return MOC_Cereals_Clauses;
	}

	@FindBy(xpath = "(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[4]//input[1])[4]")
	WebElement MOC_Cereals_Rate;

	public WebElement MOC_Cereals_Rate() {
		return MOC_Cereals_Rate;
	}

	@FindBy(xpath = "//button[normalize-space()='Save & Close']")
	WebElement MOC_Goods_Save;

	public WebElement MOC_Goods_Save() {
		return MOC_Goods_Save;
	}
	
	@FindBy(xpath="//input[@id='checkAllBasis']")
	WebElement MC_All_INCOTERMS_Checkbox;
	
	public WebElement MC_All_INCOTERMS_Checkbox() {
		return MC_All_INCOTERMS_Checkbox;
	}
	
	@FindBy(xpath="(//table[@id='tbl_port_fm']//i)[1]")
	WebElement ImportFm_del;

	public WebElement ImportFm_del() {
		return ImportFm_del;
	}
	
	@FindBy(xpath="(//table[@id='tbl_port_to']//i)[1]")
	WebElement ImportTo_Del;

	public WebElement ImportTo_Del() {
		return ImportTo_Del;
	}

	@FindBy(xpath="(//table[@id='tbl_goods']//i)[1]")
	WebElement Goods_Del;

	public WebElement Goods_Del() {
		return Goods_Del;
	}

	@FindBy(xpath="(//table[@id='tbl_goods']//i)[2]")
	WebElement Goods_Update;

	public WebElement Goods_Update() {
		return Goods_Update;
	}
	
	@FindBy(xpath="//input[@id='basicPerValue']")
	WebElement Goods_Rate_Update;

	public WebElement Goods_Rate_Update() {
		return Goods_Rate_Update;
	}

	@FindBy(xpath="//select[@id='clausesDdropDown_new']")
	WebElement Goods_Clauses_Update;

	public WebElement Goods_Clauses_Update() {
		return Goods_Clauses_Update;
	}

	@FindBy(xpath="//button[@id='btn_proc']")
	WebElement Goods_Update_close;

	public WebElement Goods_Update_close() {
		return Goods_Update_close;
	}
	
	@FindBy(xpath="//table[@id='tbl_bov_all_enterues_for_select']//tr[6]//td[1]//input")
	WebElement MOC_Foodstuffs;

	public WebElement MOC_Foodstuffs() {
		return MOC_Foodstuffs;
	}

	@FindBy(xpath="(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[3]//select)[6]")
	WebElement MOC_FoodStuff_Clauses;

	public WebElement MOC_FoodStuff_Clauses() {
		return MOC_FoodStuff_Clauses;
	}

	@FindBy(xpath="(//table[@id='tbl_bov_all_enterues_for_select']//tr//td[4]//input[1])[6]")
	WebElement MOC_FoodStuff_Rate;

	public WebElement MOC_FoodStuff_Rate() {
		return MOC_FoodStuff_Rate;
	}
	
	@FindAll({@FindBy(xpath="//table[@id='dashboard_search_tbl']//td[text()='Marine Open Cover']/preceding-sibling::td//input"),
			@FindBy(xpath="//td[text()='Marine Open Cover']/preceding-sibling::td//input[@id='tranRecId']")})
	WebElement MOC_Select;

	public WebElement MOC_Select() {
		return MOC_Select;
	}

	@FindBy(xpath="//td[text()='Marine Open Cover']/preceding-sibling::td[2]")
	WebElement MOC_Select_Policy;

	public WebElement MOC_Select_Policy() {
		return MOC_Select_Policy;
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
//

}
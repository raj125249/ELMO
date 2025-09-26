package org.pages;

import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Policy_RI_Ceding_Page extends BasicFunctions {

	public Issue_Policy_RI_Ceding_Page() {
		PageFactory.initElements(driver, this);
	}

// Ri Ceding Basis
	@FindAll({ @FindBy(xpath = "//select[@name='riCedingBasis']"), @FindBy(xpath = "//select[@id='sel_riCedingBasis']"),
			@FindBy(xpath = "//input[@id='s2id_autogen2_search']") })
	WebElement select_RI_ceding_Basis;

	public WebElement select_RI_ceding_Basis() {
		return select_RI_ceding_Basis;
	}

//Spcl Treaty Acceptance
	@FindAll({ @FindBy(xpath = "//input[@id='ttySplAppr_disp0']"),
			@FindBy(xpath = "(//input[@name='prod.ttySplAppr'])[2]") })
	WebElement special_Tty_No_Option;

	public WebElement special_Tty_No_Option() {
		return special_Tty_No_Option;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='ttySplAppr_disp1']"),
			@FindBy(xpath = "(//input[@name='prod.ttySplAppr'])[1]") })
	WebElement special_Tty_Yes_Option;

	public WebElement special_Tty_Yes_Option() {
		return special_Tty_Yes_Option;
	}

	@FindAll({ @FindBy(xpath = "//textarea[@id='speReason']"), @FindBy(xpath = "//textarea[@name='speReason']") })
	WebElement Spcl_Tty_Reason;

	public WebElement get_Spcl_Tty_Reason() {
		return Spcl_Tty_Reason;
	}

	@FindAll({ @FindBy(xpath = "//button[@onclick='saveSpecialReason();']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[2]") })
	WebElement Spcl_Tty_Save;

	public WebElement get_Spcl_Tty_Save() {
		return Spcl_Tty_Save;
	}

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement data_saved_success;

	public WebElement data_saved_success() {
		return data_saved_success;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='specialClose']"),
			@FindBy(xpath = "//button[@onclick='cancelSpecialReason();']") })
	WebElement Spcl_Tty_Cancel;

	public WebElement get_Spcl_Tty_Cancel() {
		return Spcl_Tty_Cancel;
	}

	@FindBy(xpath = "//button[@id='btn_proceed']")
	WebElement proceed_Button;

	public WebElement proceed_Button() {
		return proceed_Button;
	}

	@FindBy(xpath = "//td[contains(text(),'Excess of Treaty')]//following-sibling::td[2]")
	WebElement get_Excess_Treaty_SI_Amount;

	public WebElement get_Excess_Treaty_SI_Amount() {
		return get_Excess_Treaty_SI_Amount;
	}

	@FindBy(xpath = "//td[contains(text(),'Excess of Treaty')]//following-sibling::td[4]")
	WebElement get_Excess_Traety_Premium_Amount;

	public WebElement get_Excess_Traety_Premium_Amount() {
		return get_Excess_Traety_Premium_Amount;
	}

//Prop FAC

	@FindBy(xpath = "//button[@id='btn_prop_fac']")
	WebElement Prop_FAC;

	public WebElement Prop_FAC() {
		return Prop_FAC;
	}

	@FindBy(xpath = "//input[@onclick='checkAll(this.checked);']")
	WebElement FAC_Placement_CheckBox;

	public WebElement FAC_Placement_CheckBox() {
		return FAC_Placement_CheckBox;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='facPerc']"), @FindBy(xpath = "//input[@class='form-control perc']") })
	WebElement Fac_Percentage;

	public WebElement Fac_Percentage() {
		return Fac_Percentage;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_save&Add']"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[3]") })
	WebElement Save_Add_Participant;

	public WebElement Save_Add_Participant() {
		return Save_Add_Participant;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_save&Close']]"),
			@FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm mr-10'])[4]") })
	WebElement FAC_Percentage_Save_Close;

	public WebElement FAC_Percentage_Save_Close() {
		return FAC_Percentage_Save_Close;
	}

	@FindAll({ @FindBy(xpath = "//button[@id='btn_fac_cancel']") })
	WebElement FAC_Percentage_Cancel;

	public WebElement FAC_Percentage_Cancel() {
		return FAC_Percentage_Cancel;
	}

	@FindBy(xpath = "//*[@id='OR_CUST_NAME']")
	WebElement FAC_Participant_Name;

	public WebElement FAC_Participant_Name() {
		return FAC_Participant_Name;
	}

	@FindAll({ @FindBy(xpath = "//ul[@id='ui-id-7']//li[1]//div[1]"),
			@FindBy(xpath = "//li[@class='ui-menu-item']//div[1]") })
	WebElement Select_FAC_Participant_Name;

	public WebElement Select_FAC_Participant_Name() {
		return Select_FAC_Participant_Name;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_qfcSharePerc']") })
	WebElement FAC_Participant_Share_Percentage;

	public WebElement FAC_Participant_Share_Percentage() {
		return FAC_Participant_Share_Percentage;
	}

	@FindAll({ @FindBy(xpath = "//div[@id='saveDiv']//button[normalize-space()='Save & Close']") })
	WebElement FAC_Participant_Save_Close;

	public WebElement FAC_Participant_Save_Close() {
		return FAC_Participant_Save_Close;
	}
	
	@FindBy(xpath="//button[normalize-space()='RI Allocation']")
	WebElement RI_Allocation;
	
	public WebElement RI_Allocation() {
		return RI_Allocation;
	}

	@FindAll({ @FindBy(xpath = "(//*[text()=' Cancel'])[3]") })
	WebElement FAC_Participant_Cancel;

	public WebElement FAC_Participant_Cancel() {
		return FAC_Participant_Cancel;
	}

	@FindBy(xpath = "//table[@id='ttyPerilTbl']//tfoot//td[10]")
	WebElement RICeding_Total_Premium;

	public WebElement RICeding_Total_Premium() {
		return RICeding_Total_Premium;
	}

	@FindBy(xpath = "//table[@id='ttyPerilTbl']//tfoot//td[8]")
	WebElement RICeding_Total_SI;

	public WebElement RICeding_Total_SI() {
		return RICeding_Total_SI;
	}
}
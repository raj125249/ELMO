package org.pages;

import org.common.BaseClass;
import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Policy_Customer_Info_Page extends BasicFunctions {

	public Issue_Policy_Customer_Info_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//input[@name='customerName']"), @FindBy(xpath = "//input[@id='OR_CUST_NAME']") })
	WebElement customer_Name_Field;

	public WebElement customer_Name_Field() {
		return customer_Name_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='AS_CUST_CODE']"), @FindBy(xpath = "//input[@name='assuredCode']")})
	WebElement Insured_Code_Field;

	public WebElement Insured_Code_Field() {
		return Insured_Code_Field;
	}
	@FindBy(xpath="//ul[@id='ui-id-2']//li[1]//div[1]")
	WebElement select_insured;
	
	public WebElement select_insured() {
		return select_insured;
	}
	
	@FindBy(xpath="//ul[@id='ui-id-4']//li[1]//div[1]")
	WebElement select_Intoducer;
	
	public WebElement select_Intoducer() {
		return select_Intoducer;
	}
	
	@FindBy(xpath="//ul[@id='ui-id-5']//li[1]//div[1]")
	WebElement select_processor;
	//  //ul[@id='ui-id-2']//li[1]//div[1]
	public WebElement select_processor() {
		return select_processor;
	}
	
	@FindAll({ @FindBy(xpath = "//input[@id='civilId']"), @FindBy(xpath = "(//input[@name='civilId'])[1]") })
	WebElement passport_Number_Field;

	public WebElement passport_Number_Field() {
		return passport_Number_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='quotationValidity']"),	@FindBy(xpath = "//input[@name='quotationValidity']") })
	WebElement quotation_Valid_Days;

	public WebElement quotation_Valid_Days() {
		return quotation_Valid_Days;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='custType']"), @FindBy(xpath = "//select[@name='custType']") })
	WebElement Business_Source_Dropdown;

	public WebElement Business_Source_Dropdown() {
		return Business_Source_Dropdown;
	}

	@FindAll({  @FindBy(xpath = "//select[@id='sel_Scheme']"), @FindBy(xpath = "//select[@name='schemeCode']") })
	WebElement Types_of_Policy_Dropdown;

	public WebElement Types_of_Policy_Dropdown() {
		return Types_of_Policy_Dropdown;
	}
	
	@FindBy(xpath="//select[@id='id_policyType']")
	WebElement Floating_Policy_Type;
	
	public WebElement Floating_Policy_Type() {
		return Floating_Policy_Type;
	}
	
	@FindBy(xpath="//select[@id='id_declFrq']")
	WebElement Declaration_Frequency;
	
	public WebElement Declaration_Frequency() {
		return Declaration_Frequency;
	}
	
	@FindBy(xpath="//div[@id='s2id_sel_scheme']//a//span[1]")
	WebElement Ren_Policy_Type;
	
	public WebElement Ren_Policy_Type() {
		return Ren_Policy_Type;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='sel_SiCurr']"), @FindBy(xpath = "//select[@name='siCurr']") })
	WebElement Sum_Insured_Currency_Dropdown;

	public WebElement Sum_Insured_Currency_Dropdown() {
		return Sum_Insured_Currency_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='premCurr']"), @FindBy(xpath = "//select[@id='sel_PremCurr']") })
	WebElement Premium_Currency_Dropdown;

	public WebElement Premium_Currency_Dropdown() {
		return Premium_Currency_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='mobileNo']"), @FindBy(xpath = "//input[@name='mobileNo']") })
	WebElement Contact_Number_Field;

	public WebElement Contact_Number_Field() {
		return Contact_Number_Field;
	}

	@FindAll({ @FindBy(xpath = "//textarea[@name='interest']"), @FindBy(xpath = "//textarea[@id='interestId']") })
	WebElement Business_Field;

	public WebElement Business_Field() {
		return Business_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='IndemPeriod']"), @FindBy(xpath = "//input[@name='IndemPeriod']") })
	WebElement indeminity_Field;

	public WebElement indeminity_Field() {
		return indeminity_Field;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='IndemPeriodUnit']"),  @FindBy(xpath = "//select[@name='IndemPeriodUnit']") })
	WebElement indeminity_Period_Unit_Dropdown;

	public WebElement indeminity_Period_Unit_Dropdown() {
		return indeminity_Period_Unit_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@name='mtDmPlcyNo']"), @FindBy(xpath = "//input[@id='mtDmPlcyNo']") })
	WebElement material_Policy_Damage_Number;

	public WebElement material_Policy_Damage_Number() {
		return material_Policy_Damage_Number;
	}
	
	@FindBy(xpath ="//input[@id='asociatnName']")
	WebElement Condominium_Association_Name;

	public WebElement Condominium_Association_Name() {
		return Condominium_Association_Name;
	}
	
	@FindBy(xpath="//input[@id='Ans01Y']")
	WebElement condominium_DN_1Y;
	
	public WebElement condominium_DN_1Y() {
		return condominium_DN_1Y;
	}
	
	@FindBy(xpath="//input[@id='Ans01N']")
	WebElement condominium_DN_1N;
	
	public WebElement condominium_DN_1N() {
		return condominium_DN_1N;
	}
	
	@FindBy(xpath="//input[@id='Ans02Y']")
	WebElement condominium_DN_2Y;
	
	public WebElement condominium_DN_2Y() {
		return condominium_DN_2Y;
	}
	
	@FindBy(xpath="//input[@id='Ans02N']")
	WebElement condominium_DN_2N;
	
	public WebElement condominium_DN_2N() {
		return condominium_DN_2N;
	}
	
	@FindBy(xpath="//input[@id='Ans03Y']")
	WebElement condominium_DN_3Y;
	
	public WebElement condominium_DN_3Y() {
		return condominium_DN_3Y;
	}
	
	@FindBy(xpath="//input[@id='Ans03N']")
	WebElement condominium_DN_3N;
	
	public WebElement condominium_DN_3N() {
		return condominium_DN_3N;
	}
	
	
	@FindBy(xpath="//input[@id='AS_CUST_NAME_EDIT']")
	WebElement Ren_Insured_ID;
	
	public WebElement Ren_Insured_ID() {
		return Ren_Insured_ID;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='AG_CUST_NAME']"), @FindBy(xpath = "//input[@name='agentName']") })
	WebElement introducer_Name_Field;

	public WebElement introducer_Name_Field() {
		return introducer_Name_Field;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='SAG_CUST_NAME']"), @FindBy(xpath = "//input[@name='subAgentName']") })
	WebElement Processor_Name_Field;

	public WebElement Processor_Name_Field() {
		return Processor_Name_Field;
	}

	@FindBy(xpath = "//button[@id='btn_proceed']")
	WebElement proceed_Button;

	public WebElement proceed_Button() {
		return proceed_Button;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='id_coins_perc']"), @FindBy(xpath = "//input[@name='coinsSharePerc']") })
	WebElement co_insurance_Share_Percentage;

	public WebElement co_insurance_Share_Percentage() {
		return co_insurance_Share_Percentage;
	}

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement get_Error_Msg;

	public WebElement get_Error_Msg() {
		return get_Error_Msg;
	}

	@FindAll({ @FindBy(xpath = "//textarea[@name='territorialLimit']"),	@FindBy(xpath = "//textarea[@id='territorialLimit']") })
	WebElement territorial_Limits;

	public WebElement territorial_Limits() {
		return territorial_Limits;
	}

	@FindAll({ @FindBy(xpath = "//select[@id='prodType_ID']"), @FindBy(xpath = "//select[@name='prodType']") })
	WebElement product_Type_Dropdown;

	public WebElement product_Type_Dropdown() {
		return product_Type_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='policyFmDt']"), @FindBy(xpath = "//input[@name='policyStartDate']") })
	WebElement policy_From_Date;

	public WebElement policy_From_Date() {
		return policy_From_Date;
	}
	
	@FindBy(xpath="//input[@id='policyToDt']")
	WebElement policy_To_Date;
	
	public WebElement policy_To_Date() {
		return policy_To_Date;
	}
	
	@FindBy(xpath = "//*[@class='row mt-10 mb-10']//div[2]//b")
	WebElement Certificate_Quote;

	public WebElement Certificate_Quote() {
		return Certificate_Quote;
	}
	
	@FindBy(xpath = "(//div[@class='ui-pnotify-text'])[2]")
	//@FindBy(xpath="//div[@class='ui-pnotify-text' and @aria-role='alert']/text()")
	WebElement DN_AlertMSG;

	public WebElement DN_AlertMSG() {
		return DN_AlertMSG;
	}
	
	@FindBy(xpath = "(//div[@class='col-md-2']//b)[1]")
	WebElement Cust_QuoteNo;

	public WebElement Cust_QuoteNo() {
		return Cust_QuoteNo;
	}
	
	

}

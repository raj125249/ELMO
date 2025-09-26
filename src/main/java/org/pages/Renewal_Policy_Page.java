package org.pages;

import org.common.BasicFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Renewal_Policy_Page extends BasicFunctions{

	public Renewal_Policy_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//table[@id='polDueForRenTbl']//tr[1]//td[2]") })
	WebElement get_Renewal_Policy_Number;

	public WebElement get_Renewal_Policy_Number() {
		return get_Renewal_Policy_Number;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='polDueForRenTbl']//tr[1]//td[5]") })
	WebElement get_Renewal_Policy_Type;

	public WebElement get_Renewal_Policy_Type() {
		return get_Renewal_Policy_Type;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='polDueForRenTbl']//tr[1]//td[13]//select") })
	WebElement Renewal_Status_Dropdown;

	public WebElement Renewal_Status_Dropdown() {
		return Renewal_Status_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='polDueForRenTbl']//tr[1]//td[17]//i[6]"),
			@FindBy(xpath = "//i[@title='Generate Renewal Quotation']") })
	WebElement generate_Review_Quotation;

	public WebElement generate_Review_Quotation() {
		return generate_Review_Quotation;
	}
	
	@FindBy(xpath="//input[@id='fmDt']")
	WebElement Expiry_FMDT;
	
	public WebElement Expiry_FMDT() {
		return Expiry_FMDT;
	}
	
	@FindBy(xpath="//input[@id='toDt']")
	WebElement Expiry_ToDT;
	
	public WebElement Expiry_ToDT() {
		return Expiry_ToDT;
	}
	
	@FindBy(xpath="//select[@id='sel_search_policy']")
	WebElement Select_Search_Policy;
	
	public WebElement Select_Search_Policy() {
		return Select_Search_Policy;
	}
	
	@FindBy(xpath="//input[@id='ren_policyNo']")
	WebElement Search_Enter_Policy;
	
	public WebElement Search_Enter_Policy() {
		return Search_Enter_Policy;
	}

	@FindBy(xpath="//a[@id='renewal_search_btn']")
	WebElement Renewal_Search;
	
	public WebElement Renewal_Search() {
		return Renewal_Search;
	}
	
	@FindBy(xpath="//table[@id='polDueForRenTbl']//tbody//tr//td//input[1]")
	WebElement Renewal_Policy_Checkbox;
	
	public WebElement Renewal_Policy_Checkbox() {
		return Renewal_Policy_Checkbox;
	}
	
	@FindBy(xpath="((//table[@id='polDueForRenTbl']//tbody//td)//i[5])[1]")
	WebElement Generate_Renewal_Quotation;
	
	public WebElement Generate_Renewal_Quotation() {
		return Generate_Renewal_Quotation;
	}
		
	@FindBy(xpath="(//div[@class='col-md-2']//b)[1]")
	WebElement Renewal_Quotation_No;
	
	public WebElement Renewal_Quotation_No() {
		return Renewal_Quotation_No;
	}
	
	@FindBy(xpath="//input[@id='sumInsured']")
	WebElement EDIT_SI_Value;
	
	public WebElement EDIT_SI_Value() {
		return EDIT_SI_Value;
	}
	
	@FindBy(xpath = "//input[@id='rate']")
	WebElement EDIT_SI_Rate;

	public WebElement EDIT_SI_Rate() {
		return EDIT_SI_Rate;
	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
}
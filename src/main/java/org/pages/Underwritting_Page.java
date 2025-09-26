package org.pages;

import org.common.BasicFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Underwritting_Page extends BasicFunctions {

	public Underwritting_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Menus']")
	WebElement menu_Button;

	public WebElement menu_Button() {
		return menu_Button;
	}
	
	@FindBy(xpath="//*[text()='CI']")
	WebElement CI_Menu;
	
	public WebElement CI_Menu() {
		return CI_Menu;
	}
	
	@FindBy(xpath = "(//li[normalize-space(@class)='dropdown nav-profile']//following::span[1])[1]")
	WebElement userNameField;

	public WebElement userNameField() {
		return userNameField;
	}
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement User_logout;

	public WebElement User_logout() {
		return User_logout;
	}

	@FindBy(xpath = "//span[text()=' Commercial Underwriting ']")
	WebElement commercial_Underwriting_Button;

	public WebElement commercial_Underwriting_Button() {
		return commercial_Underwriting_Button;
	}
		
	@FindBy(xpath="//span[text()=' Personal Underwriting ']")
	WebElement Personal_Underwriting_Button;
	
	public WebElement Personal_Underwriting_Button() {
		return Personal_Underwriting_Button;
	}
	
	@FindBy(xpath="//span[text()=' Renewals ']")
	WebElement Renewals_Menu;
	
	public WebElement Renewals_Menu() {
		return Renewals_Menu;
	}
	
	@FindBy(xpath="//span[text()=' Policy Due For Renewal']")
	WebElement Policy_Due_For_Renewal;
	
	public WebElement Policy_Due_For_Renewal(){
		return Policy_Due_For_Renewal;
	}	
	
	@FindBy(xpath="//span[text()=' Policy Due For Renewal Batch']")
	WebElement Policy_Due_For_RenewalBatch;
	
	public WebElement Policy_Due_For_RenewalBatch() {
		return Policy_Due_For_RenewalBatch;
	}
	
	@FindBy(xpath = "//span[text()=' Fire Personal']")
	WebElement Fire_Personal_Menu;

	public WebElement Fire_Personal_Menu() {
		return Fire_Personal_Menu;
	}
	
	@FindBy(xpath = "//span[text()=' Fire Commercial']")
	WebElement Fire_Commercial_Menu;

	public WebElement Fire_Commercial_Menu() {
		return Fire_Commercial_Menu;
	}

	@FindBy(xpath ="//span[text()=' Hunters/Shooters Master']")
	WebElement Hunters_Shooters_Master;

	public WebElement Hunters_Shooters_Master() {
		return Hunters_Shooters_Master;
	}

	@FindBy(xpath ="//span[text()=' Marine Open Cover']")
	WebElement Marine_Open_Cover;

	public WebElement Marine_Open_Cover() {
		return Marine_Open_Cover;
	}
	
	@FindBy(xpath ="//span[text()=' Marine Certificate']")
	WebElement Marine_Certificate;

	public WebElement Marine_Certificate() {
		return Marine_Certificate;
	}
	
	@FindBy(xpath ="//span[text()=' Marine Individual']")
	WebElement Marine_Individual;

	public WebElement Marine_Individual() {
		return Marine_Individual;
	}
	
	@FindBy(xpath ="//span[text()=' Hunters/Shooter Certificate']")
	WebElement Hunters_Shooter_Certificate;

	public WebElement Hunters_Shooter_Certificate() {
		return Hunters_Shooter_Certificate;
	}	

	@FindBy(xpath = "//span[text()=' Liability Commercial']")
	WebElement Liability_Commercial_Menu;

	public WebElement Liability_Commercial_Menu() {
		return Liability_Commercial_Menu;
	}

	@FindBy(xpath = "//span[text()=' Engineering']")
	WebElement Engineering_Commercial_Menu;

	public WebElement Engineering_Commercial_Menu() {
		return Engineering_Commercial_Menu;
	}

	@FindBy(xpath = "//span[text()=' Accident']")
	WebElement Accident_Commercial_Menu;

	public WebElement Accident_Commercial_Menu() {
		return Accident_Commercial_Menu;
	}

	@FindBy(xpath = "//span[text()=' Non Marine Liability']")
	WebElement non_Marine_Liablity_Menu;

	public WebElement non_Marine_Liablity_Menu() {
		return non_Marine_Liablity_Menu;
	}

	@FindBy(xpath = "//span[text()=' Marine Hull']")
	WebElement Marine_Hull;

	public WebElement Marine_Hull() {
		return Marine_Hull;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='coverInfo_search']"),
			@FindBy(xpath = "//div[@id='plugin_search']//input") })
	WebElement search_Field;

	public WebElement search_Field() {
		return search_Field;
	}

	@FindAll({ @FindBy(xpath = "//table[@id='polDueForRenTbl']//tr[1]//td[17]//i[6]"),
			@FindBy(xpath = "//i[@title='Generate Renewal Quotation']")})
	WebElement generate_Review_Quatation;

	public WebElement generate_Review_Quatation() {
		return generate_Review_Quatation;
	}

	@FindBy(xpath = "//button[@id='btn_edit']")
	WebElement edit_Button;

	public WebElement edit_Button() {
		return edit_Button;
	}

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'Annual Contract Works Certificate')]") })
	WebElement Annual_Contract_Works_Certificate;

	public WebElement Annual_Contract_Works_Certificate() {
		return Annual_Contract_Works_Certificate;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='txt_openPolicyNo']") })
	WebElement Policy_No_Field;

	public WebElement Policy_No_Field() {
		return Policy_No_Field;
	}
	
	@FindBy(xpath="//button[@id='btn_crtCert']")
	WebElement Create_Certificate;
	
	public WebElement Create_Certificate() {
		return Create_Certificate;
	}

	@FindAll({ @FindBy(xpath = "(//button[@class='btn btn-greensea btn-sm '])[2]"),
			@FindBy(xpath = "//button[contains(@onclick,'createSingleCertificate')]") })
	WebElement create_Single_Certificate_Button;

	public WebElement create_Single_Certificate_Button() {
		return create_Single_Certificate_Button;
	}
	
	@FindBy(xpath="//div[@id='div_tbl_search']")
	WebElement Actions_Search;

	public WebElement Actions_Search() {
		return Actions_Search;
	}
	
	@FindBy(xpath="//table[@id='WorkflowQueryTable']//td//span[@id='btn_view']")
	WebElement Action_Icon;

	public WebElement Action_Icon() {
		return Action_Icon;
	}
	
	@FindBy(xpath="//textarea[@id='remarksTemp']")
	WebElement Approval_Remarks;

	public WebElement Approval_Remarks() {
		return Approval_Remarks;
	}
	
	@FindBy(xpath="//button[@id='btn_approve']")
	WebElement WF_ApprovalButton;

	public WebElement WF_ApprovalButton() {
		return WF_ApprovalButton;
	}
	
	@FindBy(xpath="//button[@id='btn_reject']")
	WebElement WF_RejectButton;

	public WebElement WF_RejectButton() {
		return WF_RejectButton;
	}
	
	@FindBy(xpath="//span[@id='span_TotalMyRequest']")
	WebElement My_Request_Tab;

	public WebElement My_Request_Tab() {
		return My_Request_Tab;
	}
	
	@FindBy(xpath="//span[@id='span_TotalPendingAction']")
	WebElement My_Action_Tab;

	public WebElement My_Action_Tab() {
		return My_Action_Tab;
	}
	
	@FindBy(xpath="//span[normalize-space()='Reinsurance']")
	WebElement Reinsurance_Menu;

	public WebElement Reinsurance_Menu() {
		return Reinsurance_Menu;
	}	
	
	@FindBy(xpath="//span[normalize-space()='RI Allocation']")
	WebElement RI_Allocation;

	public WebElement RI_Allocation() {
		return RI_Allocation;
	}
	
	@FindBy(xpath="//span[normalize-space()='RI Confirmation Log']")
	WebElement RI_Confirmation_Log;

	public WebElement RI_Confirmation_Log() {
		return RI_Confirmation_Log;
	}
	
	@FindBy(xpath="//input[@id='txt_openPolicyNo']")
	WebElement Open_Policy_Number;
	
	public WebElement Open_Policy_Number() {
		return Open_Policy_Number;
	}	
	
	@FindBy(xpath="//li[@class='ui-menu-item']//div")
	WebElement Open_Policy_number_click;
	
	public WebElement Open_Policy_number_click() {
		return Open_Policy_number_click;
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
	
	
	
	
}
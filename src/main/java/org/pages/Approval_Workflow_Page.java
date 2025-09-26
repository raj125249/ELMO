package org.pages;

import org.common.BasicFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Approval_Workflow_Page extends BasicFunctions {
	
	public Approval_Workflow_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[@class='ui-pnotify-title']")
	WebElement WF_Success_Msg;
	
	public WebElement WF_Success_Msg() {
		return WF_Success_Msg;
	}
	
	@FindBy(xpath="//div[text()='RI Confirmed successfully and Moved to Underwriting Approval']")
	WebElement RI_Confirmed_Msg;
	
	public WebElement RI_Confirmed_Msg() {
		return RI_Confirmed_Msg;
	}
	
	@FindBy(xpath = "//ul[@id='WorkflowTreeViewId_0']//ul//a[text()='Demands and Needs ']")
	WebElement Demands_Needs_ActionsTab;

	public WebElement Demands_Needs_ActionsTab() {
		return Demands_Needs_ActionsTab;
	}
	
	
	

}

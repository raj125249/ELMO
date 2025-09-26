package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.testng.annotations.Test;

public class Change_in_ownership_Endorsement extends BaseClass {

	@Test(dataProvider = "Change_in_Ownership")

	public void tc001(String S_No, String Search_Policy, String Policy_Query, String Policy_ID, String Type_of_Policy,
			String Insured_Query, String Insured_ID, String Endorsement_Type, String Remarks, String PO_Box_Number,
			String Address, String Doc_type, String Run_Flag)
			throws IOException, InterruptedException, ClassNotFoundException, AWTException {
		
		Robot rb = new Robot();
		Global_Search_Page GSP = new Global_Search_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(get_DB_Data(Policy_Query, Policy_ID), Keys.ENTER);

		// Get Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		String PolicyNo = GSP.Policy_Number().getText();
		System.out.println("Policy Number: " + PolicyNo);

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String PolicyType = GSP.Policy_Type().getText();
		System.out.println("Type of Policy: " + PolicyType);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
		String InsuredName = GSP.Insured_Name().getText();
		System.out.println("Insured Name: "+InsuredName);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

		// Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: "+Product_Type);

		// Select Endorsement Type
		webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
		selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
		GSP.proceed_Button().click();

		Endorsement_Information_Page obj1 = new Endorsement_Information_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Edit_Insured()));
		obj1.Edit_Insured().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Edit_Insured()));
		obj1.Select_Edit_Insured().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.remarks_Field()));
		obj1.remarks_Field().sendKeys(Remarks);

		// Enter PO BOx Number
		webDriverWait(ExpectedConditions.visibilityOf(obj1.po_Box_Field()));
		obj1.po_Box_Field().clear();
		obj1.po_Box_Field().sendKeys(PO_Box_Number);

		// enter Address
		webDriverWait(ExpectedConditions.visibilityOf(obj1.address_Field()));
		obj1.address_Field().clear();
		obj1.address_Field().sendKeys(Address);

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.proceed_Button()));
		obj1.proceed_Button().click();

//Policy Documents Upload
		// scrollDownJavaSc(GSP.Policy_Document_Dropdown());
		webDriverWait(ExpectedConditions.visibilityOf(obj1.Policy_Document_Dropdown()));
		selectByVisibleText(obj1.Policy_Document_Dropdown(), Doc_type);

		rb.delay(7000);

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.upload_File()));
		obj1.upload_File().click();
		StringSelection ss1 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
		rb.delay(2000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(3000);

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.proceed_Button()));
		obj1.proceed_Button().click();
		
		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.approve_Non_Financial_Endorsement()));
		javaScribtClick(obj1.approve_Non_Financial_Endorsement());

		webDriverWait(ExpectedConditions.visibilityOf(obj1.get_Policy()));
		String policyNumber = obj1.get_Policy().getText();
		System.out.println("Policy Number is: "+policyNumber);
		
//		Customer Name Verification
		String customerName = obj1.customer_Name().getText();
		System.out.println("Customer Name is: " + customerName);

		webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Close_Button()));
		obj1.Close_Button().click();		
		
	}
}
package org.testFunctions;

import java.awt.AWTException;

import org.common.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Non_Financial_Endorsement extends BaseClass {

	@Test(dataProvider = "Non_Financial_Endorsement")
	public void tc_001(String S_No, String Search_Policy, String Policy_Number, String Type_of_Policy,
			String Insured_Name, String Endorsement_Type, String Remarks, String PO_Box_Numer, String Address)
			throws AWTException, InterruptedException {
		Global_Search_Page GSP = new Global_Search_Page();

		Endorsement_Information_Page EIP = new Endorsement_Information_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(Policy_Number);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		// Policy Number Verification
		String policy_Number = GSP.Policy_Number().getText();
		System.out.println("Policy Number is: " + policy_Number);

		if (policy_Number.contains(Policy_Number)) {
			Assert.assertEquals(policy_Number, Policy_Number);
			System.out.println("Policy Number Verification is Pass");

		} else {

			Assert.fail();
			System.out.println("Policy Number Verification Failed");

		}

		// Get Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
		String policy_type = GSP.Policy_Type().getText();
		System.out.println(policy_type);
		if (policy_type.contains(Type_of_Policy)) {

			Assert.assertEquals(policy_type, Type_of_Policy);
			System.out.println("Policy Type Verified");

		} else {

			Assert.fail();
			System.out.println("Policy Type Verification Failed");

		}

		// Insured Name Verification

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
		String insured_Name = GSP.Insured_Name().getText();
		System.out.println(insured_Name);
		if (insured_Name.contains(Insured_Name)) {

			Assert.assertEquals(insured_Name, Insured_Name);
			System.out.println("Insured Name Verification Passed");
		} else {

			Assert.fail();
			System.out.println("Insured Name Verification Failed");

		}

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
		GSP.endorsement_Button().click();

//		Get Product
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
		String Product_Type = GSP.get_Product().getText();
		System.out.println("Product Type is: " + Product_Type);

		// Select Endorsement Type
		webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
		selectByVisibleText(GSP.endorsement_Type_Dropdown(), Endorsement_Type);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
		GSP.proceed_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
		String endorsement_Type = EIP.get_Endorsement_Type().getText();
		System.out.println("Endorsement Type is: " + endorsement_Type);

//		Endorsement Type Verification
		if (endorsement_Type.contains(Endorsement_Type)) {
			Assert.assertEquals(endorsement_Type, Endorsement_Type);
			System.out.println("Endorsement Type Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Endorsement Type Verification Failed");
		}

//		Get Policy Number 
		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
		String policy_No = EIP.get_Policy_Number().getText();

//		Policy Number Verification
		if (policy_No.contains(Policy_Number)) {
			Assert.assertEquals(policy_No, Policy_Number);
			System.out.println("Policy Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Policy Number Verification Failed");
		}

//		Get Customer name
		webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
		String customer_Name = EIP.customer_Name().getText();
		String customer = customer_Name.replace(" - ", "-");
		System.out.println("Customer name is: " + customer);

//		Enter Remarks
		webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
		EIP.remarks_Field().sendKeys(Remarks);

//		Enter PO BOx Number
		webDriverWait(ExpectedConditions.visibilityOf(EIP.po_Box_Field()));
		EIP.po_Box_Field().clear();
		EIP.po_Box_Field().sendKeys(PO_Box_Numer);

//		Change Address
		webDriverWait(ExpectedConditions.visibilityOf(EIP.address_Field()));
		EIP.address_Field().clear();
		EIP.address_Field().sendKeys(Address);

		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();

		Thread.sleep(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
		EIP.proceed_Button().click();

//		Approve Endorsement
		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
		javaScribtClick(EIP.approve_Non_Financial_Endorsement());

		webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy()));
		String policyNumber = EIP.get_Policy().getText();
		System.out.println("Policy Number is: " + policy_Number);

		if (policyNumber.contains(Policy_Number)) {

			Assert.assertEquals(policyNumber, Policy_Number);
			System.out.println("Policy Number Verification Passed");

		} else {

			Assert.fail();
			System.out.println("Policy Number Verification Failed");
		}

//		Customer Name Verification
		String customerName = EIP.customer_Name().getText();
		System.out.println("Customer Name is: " + customerName);

		webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
		EIP.Close_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
		selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

		// Enter Policy Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
		GSP.Policy_Number_Field().sendKeys(Policy_Number);

		webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
		GSP.policy_Search_Button().click();
		webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
		// Policy Number Verification
		String Policy_No = GSP.Policy_Number().getText();
		System.out.println("Policy Number is: " + Policy_No);

		if (Policy_No.contains(Policy_Number)) {
			Assert.assertEquals(Policy_No, Policy_Number);
			System.out.println("Policy Number Verification is Pass");

		} else {

			Assert.fail();
			System.out.println("Policy Number Verification Failed");

		}

//		Click Policy Details Menu
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Details_Menu()));
		GSP.policy_Details_Menu().click();

//		Get Po Box Number
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_po_Box_Number()));
		String PO_Box_No = GSP.get_po_Box_Number().getText();

//		PO Box Number Verification
		if (PO_Box_No.contains(PO_Box_Numer)) {
			Assert.assertEquals(PO_Box_No, PO_Box_Numer);
			System.out.println("PO Box Number Verification Passed");
		} else {
			Assert.fail();
			System.out.println("PO Box Number Verification Failed");
		}

//		Get Address
		webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Address()));
		String Customer_Address = GSP.get_Address().getText();

		if (Customer_Address.contains(Address)) {
			Assert.assertEquals(Customer_Address, Address);
			System.out.println("Customer Address Verification Passed");
		} else {
			Assert.fail();
			System.out.println("Customer Address Verification Failed");
		}

	}

}

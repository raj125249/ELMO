package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.common.BaseClass;
import org.common.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Issue_Policy_Customer_Info extends BaseClass {

	@Test(dataProvider = "Issue_Policy")
	public void tc_001(String S_No, String Policy_Type, String Types_of_Policy, String Business_Source,
			String Floatingtype, String Floating_Policy, String Insured_Query, String Insured_ID,
			String Quotation_Validity_Days, String Co_Insurance_Share_Percentage, String Sum_Insured_Currency,
			String Premium_Currency, String Contact_Number, String Business_Occupation, String Territorial_Limits,
			String Product_Type, String Indeminity_Field, String Material_Policy_Damage_Number, String Introducer_Name,
			String Processor_Name, String Risk_Description, String Occupancy_Type, String Description,
			String Risk_Catagory, String Location, String Cyber_Risk, String Limit_Per_AOA, String Select_Reference,
			String Inward_SI, String Inward_Premium, String Multiple_Risk, String Multiple_SMI,
			String Sum_Insured_Amount, String Sum_Insured_Rate, String Sum_Insured_Premium, String SMI_Discount,
			String SMI_Loadings, String Discount_Rate, String Loading_Rate, String Edit_SMI, String Edit_SI,
			String Edit_SI_RATE, String Del_SMI, String Policy_Discount, String Policy_Discount_Rate,
			String Policy_Loading, String Policy_Loading_Rate, String Policy_Deductible,
			String Policy_Deductible_Calctype, String Policy_Deductible_RateValue, String Split_YN,
			String Add_Insured_Query, String Add_Insured_ID, String Ins_Type, String AddIns_MobileNo,
			String AddIns_EmailID, String AddIns_IDType, String AddIns_IdNo, String AddIns_POBox,
			String Add_Ins_Relation, String Add_Ins_Address, String Add_Surveyor_Query, String Add_Surveyor_ID,
			String Surveyor_Risk, String Survey_Doc_type, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Coinsurer_Share, String Doc_type, String Special_Tty, String RI_Ceding_Basic, String Add_FAC,
			String FAC_Percentage_Value, String FAC_Participant_Query, String FAC_ID,
			String FAC_Participant_Share_Percentage_Value, String RI_Login_User, String Mode_Of_Pay, String Cash_Type,
			String Cheque_No, String Bank_Name, String Account_Number, String Insured_Billing_Account, String Remarks,
			String Approve_Policy,

			String Policy_Endorsements, String Non_Financial_Endors, String Financial_Endors,
			String Change_Policy_Endors, String Extension_Policy_Endors, String Reduction_Policy_Endors,
			String FAC_Endors, String Discount_Loadings_Endors, String Policy_Cancellation_Endors,
			String Policy_Reinstatement_Endors, String PO_Box_Numer, String Address, String Edit_SI_Value,
			String Edit_SI_Rate, String Financial_Add_FAC,

			String Run_Flag) 
					throws IOException, InterruptedException, AWTException, ClassNotFoundException {
		
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		
//		Enter Insured Name
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Insured_Code_Field()));
		cus.Insured_Code_Field().sendKeys(get_DB_Data(Insured_Query, Insured_ID));
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_insured()));
		cus.select_insured().click();

//		Get ID Card Number
		webDriverWait(ExpectedConditions.visibilityOf(cus.passport_Number_Field()));
		String ID_Card_Number = getAtrributeValue(cus.passport_Number_Field(), "value");
		System.out.println("ID Card Number is: " + ID_Card_Number);

//		Enter Quotation Validity Days
//		webDriverWait(ExpectedConditions.visibilityOf(obj.quotation_Valid_Days()));
//		obj.quotation_Valid_Days().clear();
//		obj.quotation_Valid_Days().sendKeys(Quotation_Validity_Days);

//		Select Business Source
		webDriverWait(ExpectedConditions.visibilityOf(cus.Business_Source_Dropdown()));
		selectByVisibleText(cus.Business_Source_Dropdown(), Business_Source);
		System.out.println("Business Source: " + Business_Source);

//		Select Type of Policy
		webDriverWait(ExpectedConditions.visibilityOf(cus.Types_of_Policy_Dropdown()));
		selectByVisibleText(cus.Types_of_Policy_Dropdown(), Types_of_Policy);

//		Enter Co-insurance share percentage
		if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Broker with Elmo Leader")
				|| Business_Source.equals("Broker with Elmo Follower")
				|| Business_Source.equals("Direct with Elmo Follower")
				|| Business_Source.equals("Salesman with Elmo Leader")
				|| Business_Source.equals("Introducers with Elmo Leader")
				|| Business_Source.equals("Branches with Elmo Leader")
				|| Business_Source.equals("Staff with Elmo Leader")
				|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {
			webDriverWait(ExpectedConditions.visibilityOf(cus.co_insurance_Share_Percentage()));
			cus.co_insurance_Share_Percentage().sendKeys(Co_Insurance_Share_Percentage);
			System.out.println("Co-Insurance share percentage: " + Co_Insurance_Share_Percentage);
		}

//		Select Sum Insured Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Sum_Insured_Currency_Dropdown()));
		selectByVisibleText(cus.Sum_Insured_Currency_Dropdown(), Sum_Insured_Currency);

//		Select Premium Currency
		webDriverWait(ExpectedConditions.visibilityOf(cus.Premium_Currency_Dropdown()));
		selectByVisibleText(cus.Premium_Currency_Dropdown(), Premium_Currency);

//		Enter Contact Number		
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.Contact_Number_Field()));
		cus.Contact_Number_Field().click();
		cus.Contact_Number_Field().sendKeys(Keys.CONTROL + "a");
		cus.Contact_Number_Field().sendKeys(Keys.DELETE);
		cus.Contact_Number_Field().sendKeys(Contact_Number);
		System.out.println("Contact number: " + Contact_Number);

//		if (Policy_Type.equals("Fire Commercial") && Floating_Policy.equals("Yes")) {
//			webDriverWait(ExpectedConditions.elementToBeClickable(cus.Floating_Policy_Type()));
//			selectByVisibleText(cus.Floating_Policy_Type(), Floatingtype);
//			System.out.println("Floating type is: " + Floatingtype);

//			webDriverWait(ExpectedConditions.elementToBeClickable(objec.Floating_Policy_Type()));
//			Select dropdownValues = new Select(objec.Floating_Policy_Type());
//			List<WebElement> Floating_Policy = dropdownValues.getOptions();
//			Random randomFloatingpolicytype = new Random();
//			int randomIndexFloatingtype = randomFloatingpolicytype.nextInt(Floating_Policy.size());
//			dropdownValues.selectByIndex(randomIndexFloatingtype);
//			WebElement Floatingtypevalue = dropdownValues.getFirstSelectedOption();
//			Floatingtype = Floatingtypevalue.getText();
//			System.out.println("Selected Floating Type: " + Floatingtype);
//
//			if (Floatingtype.equals("Declaration Policy") || Floatingtype.equals("Floating with Declaration Policy")) {
//				webDriverWait(ExpectedConditions.elementToBeClickable(objec.Declaration_Frequency()));
//				Select dropdown = new Select(objec.Declaration_Frequency());
//				List<WebElement> Declaration_Frequency_Dropdown = dropdown.getOptions();
//				List<WebElement> validOptions = new ArrayList<>();
//				for (WebElement option : Declaration_Frequency_Dropdown) {
//					if (!option.getText().toLowerCase().contains("select")) {
//						validOptions.add(option);
//					}
//				}
//				if (!validOptions.isEmpty()) {
//					Random randomDeclarationFrequency = new Random();
//					int randomIndexOfDeclarationFrequency = randomDeclarationFrequency.nextInt(validOptions.size());
//					dropdown.selectByIndex(Declaration_Frequency_Dropdown
//							.indexOf(validOptions.get(randomIndexOfDeclarationFrequency)));
//					String Frequncy = validOptions.get(randomIndexOfDeclarationFrequency).getText();
//					System.out.println("Declaration Frequency: " + Frequncy);
//				}
//			}
//		}

//		Enter Business occupation
		webDriverWait(ExpectedConditions.visibilityOf(cus.Business_Field()));
		cus.Business_Field().sendKeys(Business_Occupation);
		System.out.println("Business/Occupation: " + Business_Occupation);

//		select Territorial Limit
		if (Policy_Type.equals("Accident Commercial")) {
			webDriverWait(ExpectedConditions.visibilityOf(cus.territorial_Limits()));
			cus.territorial_Limits().sendKeys(Territorial_Limits);
			System.out.println("Territorial Limits: " + Territorial_Limits);
		}

//		Select Product Type
		// if (Policy_Type.equals("Engineering Commercial")
		// && !(Types_of_Policy.equals("Plant and Equipment All Risks Insurance"))) {
		webDriverWait(ExpectedConditions.visibilityOf(cus.product_Type_Dropdown()));
		selectByVisibleText(cus.product_Type_Dropdown(), Product_Type);
		System.out.println("Product type: " + Product_Type);
//		}

//		select indemnity validation
		if (Types_of_Policy.equals("Business Interruption Insurance") || Types_of_Policy.equals("SME Package Insurance")
				|| Types_of_Policy.equals("Hotel Plan Insurance")
				|| Types_of_Policy.equals("Engineering BI Insurance")) {

			webDriverWait(ExpectedConditions.visibilityOf(cus.indeminity_Field()));
			cus.indeminity_Field().sendKeys(Indeminity_Field);
			System.out.println("Indemnity Field: " + Indeminity_Field);

			// rb.delay(3000);
//			webDriverWait(ExpectedConditions.visibilityOf(objec.indeminity_Period_Unit_Dropdown()));
//			selectByVisibleText(objec.indeminity_Period_Unit_Dropdown(), );
//			System.out.println("Indemnity Period Unit Dropdown = " +);

			webDriverWait(ExpectedConditions.visibilityOf(cus.indeminity_Period_Unit_Dropdown()));
			Select dropdown = new Select(cus.indeminity_Period_Unit_Dropdown());
			List<WebElement> Indeminity_Period_Unit_Dropdown = dropdown.getOptions();
			List<WebElement> validOptions = new ArrayList<>();
			for (WebElement option : Indeminity_Period_Unit_Dropdown) {
				if (!option.getText().toLowerCase().contains("select")) {
					validOptions.add(option);
				}
			}
			if (!validOptions.isEmpty()) {
				Random randomIndemnity_Unit = new Random();
				int randomIndexOfIndemnityUnit = randomIndemnity_Unit.nextInt(validOptions.size());
				dropdown.selectByIndex(
						Indeminity_Period_Unit_Dropdown.indexOf(validOptions.get(randomIndexOfIndemnityUnit)));
				String Indemnity_Period_Unit = validOptions.get(randomIndexOfIndemnityUnit).getText();
				System.out.println("Indemnity Period Unit Value is: " + Indemnity_Period_Unit);
			}
			webDriverWait(ExpectedConditions.visibilityOf(cus.material_Policy_Damage_Number()));
			cus.material_Policy_Damage_Number().sendKeys(Material_Policy_Damage_Number);
			System.out.println("Material Policy Damage Number: " + Material_Policy_Damage_Number);
		}

//		Enter Introducer Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
		cus.introducer_Name_Field().sendKeys(Introducer_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_Intoducer()));
		cus.select_Intoducer().click();
		System.out.println("Introducer Name: " + Introducer_Name);

//		Enter Processor Name
		webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
		cus.Processor_Name_Field().sendKeys(Processor_Name);
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.select_processor()));
		cus.select_processor().click();
		System.out.println("Processor Name: " + Processor_Name);

//		Enter Proceed Button
		webDriverWait(ExpectedConditions.elementToBeClickable(cus.proceed_Button()));
		cus.proceed_Button().click();
		System.out.println("proceed to Risk info page");
		
		
		
	}

}

package org.testFunctions;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Issue_Policy_Additional_Info extends BaseClass {
	// public static String AddInsname;

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
			throws InterruptedException, AWTException, ClassNotFoundException, IOException {

		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Commercial_Login CLP = new Commercial_Login();
		Robot rb = new Robot();

		//Add policy Discounts and Loadings to the policy.
				try {
					webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
					String policy_Fees = apin.get_Policy_Fees().getText();
					System.out.println("Policy Fees is: " + policy_Fees);

				} catch (Exception e) {

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discounts_Loadings_Panel()));
					javaScribtClick(apin.Policy_Discounts_Loadings_Panel());
					try {
						webDriverWait(ExpectedConditions.visibilityOf(apin.get_Policy_Fees()));
						String policy_Fees = apin.get_Policy_Fees().getText();
						System.out.println("Policy Fees is: " + policy_Fees);
					} catch (Exception e2) {
					}
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
				apin.Add_Policy_DL().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
				selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Discount);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discount_Checkbox()));
				apin.Policy_Discount_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Discount_Rate()));
				apin.Policy_Discount_Rate().sendKeys(Policy_Discount_Rate, Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
				apin.Policy_DL_Save_Button().click();

				// Add Policy Loadings
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
				apin.Add_Policy_DL().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
				selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Loading);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Loading_Checkbox()));
				apin.Policy_Loading_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Loading_Rate()));
				apin.Policy_Loading_Rate().sendKeys(Policy_Loading_Rate, Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
				apin.Policy_DL_Save_Button().click();

				// Add Policy Deductibles
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Policy_DL()));
				apin.Add_Policy_DL().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Dropdown()));
				selectByVisibleText(apin.Policy_DL_Dropdown(), Policy_Deductible);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Checkbox()));
				apin.Policy_Deductible_Checkbox().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Caltype()));
				selectByVisibleText(apin.Policy_Deductible_Caltype(), Policy_Deductible_Calctype);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_Deductible_Rate()));
				apin.Policy_Deductible_Rate().sendKeys(Policy_Deductible_RateValue, Keys.TAB);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Policy_DL_Save_Button()));
				apin.Policy_DL_Save_Button().click();

				rb.delay(5000);

		// Introducer/processor commission
				String user_Profile_Name2 = apin.userNameField().getText();
				System.out.println("User Profile Name is: " + user_Profile_Name2);

				if (CLP.Login_User_Name.contains("Juan Siracusa")) {

					webDriverWait(ExpectedConditions.visibilityOf(apin.introducerEditBtn()));
					apin.introducerEditBtn().click();

					webDriverWait(ExpectedConditions.visibilityOf(apin.commAmtFC()));
					apin.commAmtFC().click();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].value='10';", apin.commAmtFC());
					rb.delay(2000);

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
					apin.updateBtn().click();

					// success msg is mapped as same for upload documents in policy level
					webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
					String success_Msg = apin.DocumentUploadSuccess().getText();
					System.out.println("Introducer Updated Message: " + success_Msg);
					rb.delay(5000);

					webDriverWait(ExpectedConditions.visibilityOf(apin.Intorducer_commAmtFC()));
					String Int_comm_Amount = apin.Intorducer_commAmtFC().getText();
					System.out.println("Introducer commission amount: " + Int_comm_Amount);

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.processorEditButton()));
					apin.processorEditButton().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.commAmtFC()));
					apin.commAmtFC().click();
					js.executeScript("arguments[0].value='10';", apin.commAmtFC());
					rb.delay(2000);

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.updateBtn()));
					apin.updateBtn().click();

					webDriverWait(ExpectedConditions.visibilityOf(apin.DocumentUploadSuccess()));
					String success_Msg2 = apin.DocumentUploadSuccess().getText();
					System.out.println("Processor Updated Message: " + success_Msg2);
					rb.delay(5000);

					webDriverWait(ExpectedConditions.visibilityOf(apin.Processor_commAmtFC()));
					String Pro_comm_Amount = apin.Processor_commAmtFC().getText();
					System.out.println("Processor commission amount: " + Pro_comm_Amount);

				} else {
					System.out.println("Introducer-Processor update is not Applicable");
				}
				rb.delay(5000);

		//Coinsurance Section
				if (Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct with Elmo Follower")
						|| Business_Source.equals("Broker with Elmo Leader")
						|| Business_Source.equals("Broker with Elmo Follower")
						|| Business_Source.equals("Salesman with Elmo Leader")
						|| Business_Source.equals("Introducers with Elmo Leader")
						|| Business_Source.equals("Branches with Elmo Leader")
						|| Business_Source.equals("Staff with Elmo Leader")
						|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")) {

					rb.delay(3000);
					// Click Co Insurance Menu
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.co_Insursance_Menu()));
					apin.co_Insursance_Menu().click();

					rb.delay(3000);
					// Click Add Co insurance Menu
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
					apin.add_Co_Insurance_Button().click();

					// Get Total Sum Insured
					webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Sum_Insured()));
					String text = apin.get_Total_Sum_Insured().getText();
					double Total_Sum_Insured = string_To_double_Convert(text);

//					Get Total Premium
					webDriverWait(ExpectedConditions.visibilityOf(apin.get_Total_Premium_FC()));
					String Total_Premium_FC = apin.get_Total_Premium_FC().getText();
					double Total_Premium_Amount = string_To_double_Convert(Total_Premium_FC);
					System.out.println("Total Premium Amount is: " + Total_Premium_Amount);

//					Get Our Share
					webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Share()));
					String text2 = apin.get_Our_Share().getText();
					double ourshare = string_To_double_Convert(text2);

					double premium = Total_Premium_Amount * ourshare / 100;
					String Premium_Amount = String.format("%.2f", premium);
					System.out.println("Our Premium Amount is: " + Premium_Amount);

//					get Our Premium
					webDriverWait(ExpectedConditions.visibilityOf(apin.get_Our_Premium()));
					String text3 = apin.get_Our_Premium().getText();
					String our_Premium = text3.replace(",", "");
					System.out.println("our Premium is: " + our_Premium);

					if (our_Premium.contains(Premium_Amount)) {
						Assert.assertEquals(our_Premium, Premium_Amount);
						System.out.println("Premium Amount Verification Passed");
					} else {
						Assert.fail();
						System.out.println("Premium Amount Verification Failed");
					}

		//Insurer Premium
					double text4 = string_To_double_Convert(text3);
					double insurer_Premium = Total_Premium_Amount - text4;
					String Remaining_Premium = String.format("%.2f", insurer_Premium);
					System.out.println("Insurer Premium Amount is: " + Remaining_Premium);

//					Enter Co insurer
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
					apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
					rb.delay(5000);
					apin.select_Coinsurance().click();
					String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
					System.out.println("Coinsurer Name: " + coinsurer);
					rb.delay(3000);

//					Enter Share
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
					apin.coinsurance_Share_Percentage_Field().click();
					apin.coinsurance_Share_Percentage_Field().sendKeys(Coinsurer_Share, Keys.TAB);
					rb.delay(3000);

					if (Business_Source.equals("Direct with Elmo Follower")
							|| Business_Source.equals("Broker with Elmo Follower")) {
						webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
						apin.Coins_LeaderYN().click();
					}

//					Save Details
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
					apin.Save_Coinsurance_Details().click();

//					Get Insurer Premium
					webDriverWait(ExpectedConditions.visibilityOf(apin.co_Insurer_Share_Premium()));
					scrollDownJavaSc(apin.co_Insurer_Share_Premium());
					String text5 = apin.co_Insurer_Share_Premium().getText();
					String Coinsurer_Premium_Amount = text5.replace(",", "");
					System.out.println("Co insurer Premium Amount is: " + Coinsurer_Premium_Amount);

//					Premium Amount Verification
					if (Coinsurer_Premium_Amount.contains(Remaining_Premium)) {
						Assert.assertEquals(Coinsurer_Premium_Amount, Remaining_Premium);
						System.out.println("Premium Amount Verification Passed");
					} else {
						// Assert.fail();
						System.out.println("Premium Amount Verification Failed");
					}
				}

		//Add Insured
				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Additional_Insured_Menu()));
				apin.Additional_Insured_Menu().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Additional_Insured()));
				apin.Add_Additional_Insured().click();

//				if ((Split_YN.equals("Yes")) && (Business_Source.equals("Direct with Elmo Follower")
//						|| Business_Source.equals("Direct with Elmo Leader") || Business_Source.equals("Direct"))) {
		//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//					selectByVisibleText(obj1.Split_YN(), Split_YN);
//					System.out.println("Split invoice is: " + Split_YN);
//					rb.delay(5000);
		//
//					webDriverWait(ExpectedConditions.visibilityOf(obj1.Yes_AddInsured_Name()));
//					obj1.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
//					rb.delay(2000);
//					obj1.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
//					obj1.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
////					webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
////					obj1.Select_Add_Insured_Name().click();
//					String AddInsured = getAtrributeValue(obj1.Yes_AddInsured_Name(), "value");
//					System.out.println("Add Insured Name :" + AddInsured);
		//
//					webDriverWait(ExpectedConditions.visibilityOf(obj1.Add_Ins_Billing_Account()));
//					rb.delay(3000);
//					selectByIndex(obj1.Add_Ins_Billing_Account(), 1);
//					String AddIns_BillAcct = getAtrributeValue(obj1.Add_Ins_Billing_Account(), "value");
//					System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);
		//
//				} else if ((Split_YN.equals("No")) && (Business_Source.equals("Direct") || Business_Source.equals("Broker")
//						|| Business_Source.equals("Salesman") || Business_Source.equals("Introducers")
//						|| Business_Source.equals("Branches") || Business_Source.equals("Staff")
//						|| Business_Source.equals("Direct with Elmo Leader")
//						|| Business_Source.equals("Broker with Elmo Leader")
//						|| Business_Source.equals("Broker with Elmo Follower")
//						|| Business_Source.equals("Direct with Elmo Follower")
//						|| Business_Source.equals("Salesman with Elmo Leader")
//						|| Business_Source.equals("Introducers with Elmo Leader")
//						|| Business_Source.equals("Branches with Elmo Leader")
//						|| Business_Source.equals("Staff with Elmo Leader")
//						|| Business_Source.equals("Tied Insurance Intermediary with Elmo Leader")
//						|| Business_Source.equals("Tied Insurance Intermediary"))) {
		//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Split_YN()));
//					selectByVisibleText(obj1.Split_YN(), Split_YN);
//					System.out.println("Split invoice is:" + Split_YN);
//					rb.delay(5000);
		//
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj1.No_AddInsured_Name()));
//					obj1.No_AddInsured_Name().sendKeys("John");
//					String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
//					System.out.println("Add Insured Name: " + AddInsname);
//				}

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Split_YN()));
				selectByIndex(apin.Split_YN(), 1);
				String Splitvalue = first_Selected_Value(apin.Split_YN());
				// String Splitvalue = obj1.Split_YN().getAttribute("value");
				System.out.println("Split Invoice value: " + Splitvalue);

				if (Splitvalue.equals("Yes")) {

					webDriverWait(ExpectedConditions.visibilityOf(apin.Yes_AddInsured_Name()));
					apin.Yes_AddInsured_Name().sendKeys(get_DB_Data(Add_Insured_Query, Add_Insured_ID));
					rb.delay(2000);
					apin.Yes_AddInsured_Name().sendKeys(Keys.ARROW_DOWN);
					apin.Yes_AddInsured_Name().sendKeys(Keys.ENTER);
//					webDriverWait(ExpectedConditions.elementToBeClickable(obj1.Select_Add_Insured_Name()));
//					obj1.Select_Add_Insured_Name().click();
					String AddInsured = getAtrributeValue(apin.Yes_AddInsured_Name(), "value");
					System.out.println("Add Insured Name: " + AddInsured);

					webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Billing_Account()));
					rb.delay(3000);
					selectByIndex(apin.Add_Ins_Billing_Account(), 1);
					String AddIns_BillAcct = getAtrributeValue(apin.Add_Ins_Billing_Account(), "value");
					System.out.println("Add Insured Billing Account: " + AddIns_BillAcct);

				} else if (Splitvalue.equals("No")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.No_AddInsured_Name()));
					apin.No_AddInsured_Name().sendKeys("John");
					// String AddInsname = getAtrributeValue(obj1.No_AddInsured_Name(), "value");
					System.out.println("Add Insured Name: " + "John");
				}

				webDriverWait(ExpectedConditions.visibilityOf(apin.Insured_Type()));
				selectByVisibleText(apin.Insured_Type(), Ins_Type);
				System.out.println("Add Insured Type: " + Ins_Type);

				webDriverWait(ExpectedConditions.visibilityOf(apin.Add_Ins_Id_Types()));
				if (apin.Add_Ins_Id_Types() == null) {
					selectByVisibleText(apin.Add_Ins_Id_Types(), AddIns_IDType);
					System.out.println("AddIns ID Type: " + AddIns_IDType);
				} else {
					String AddInsID = getAtrributeValue(apin.Add_Ins_Id_Types(), "value");
					System.out.println("AddIns ID Type: " + AddInsID);
				}

				webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Id_No()));
				if (apin.AddIns_Id_No() == null) {
					apin.AddIns_Id_No().sendKeys(AddIns_IdNo);
					System.out.println("AddIns ID No: " + AddIns_IdNo);
				} else {
					String AddInsIDNo = getAtrributeValue(apin.AddIns_Id_No(), "value");
					System.out.println("AddIns ID No: " + AddInsIDNo);
				}

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Ins_Mobile_No()));
				apin.Add_Ins_Mobile_No().click();
//				if (obj11.Add_Ins_Mobile_No() == null) {
				apin.Add_Ins_Mobile_No().sendKeys(AddIns_MobileNo);
//				}else{
				String AddIns_MobNum = getAtrributeValue(apin.Add_Ins_Mobile_No(), "value");
				System.out.println("Add Ins Mobile No: " + AddIns_MobNum);
//				}

				webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_PO_Box()));
				apin.AddIns_PO_Box().click();
				if (apin.AddIns_PO_Box() == null) {
					apin.AddIns_PO_Box().sendKeys(AddIns_POBox);
					System.out.println("AddIns PO Box: " + AddIns_POBox);
				} else {
					String PO_Box = getAtrributeValue(apin.AddIns_PO_Box(), "value");
					System.out.println("AddIns PO Box: " + PO_Box);
				}

				webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Email_Id()));
				apin.AddIns_Email_Id().click();
				String EmailID = getAtrributeValue(apin.AddIns_Email_Id(), "value");
				// if (EmailID == null) {
				apin.AddIns_Email_Id().sendKeys(AddIns_EmailID);
				System.out.println("AddIns Email Id: " + AddIns_EmailID);
				// }else {

				webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Relation()));
				selectByVisibleText(apin.AddIns_Relation(), Add_Ins_Relation);
				System.out.println("AddIns Relation: " + Add_Ins_Relation);

				webDriverWait(ExpectedConditions.visibilityOf(apin.AddIns_Address()));
				apin.AddIns_Address().click();
				// if (obj11.AddIns_Address() == null) {
				apin.AddIns_Address().sendKeys(Add_Ins_Address);
				// System.out.println("AddIns Address: " + Add_Ins_Address);
				// }else {
				String AddIns_Add = getAtrributeValue(apin.AddIns_Address(), "value");
				System.out.println("AddIns Address: " + AddIns_Add);
				// }

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.get_AddIns_Save()));
				apin.get_AddIns_Save().click();
				System.out.println("Add Insured Details saved successfully");

		//survey details	
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Survey_Details_Menu()));
				apin.Survey_Details_Menu().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Surveyor_Button()));
				apin.Add_Surveyor_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Survey_Date()));
				apin.Survey_Date().click();
				keyPress(KeyEvent.VK_CONTROL);
				keyPress(KeyEvent.VK_A);
				keyRelease(KeyEvent.VK_CONTROL);
				keyRelease(KeyEvent.VK_A);

				keyPress(KeyEvent.VK_BACK_SPACE);
				keyRelease(KeyEvent.VK_BACK_SPACE);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				// Get the current date
				LocalDate currentDate = LocalDate.now();

				// Add one day to the current date to get the next date
				LocalDate nextDate = currentDate.plusDays(8);

				// Format the next date to the desired format
				String formattedNextDate = nextDate.format(formatter);
				apin.Survey_Date().sendKeys(formattedNextDate, Keys.TAB);

				webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Name()));
				Select dropdown = new Select(apin.Surveyor_Name());
				List<WebElement> SurveyorName = dropdown.getOptions();
				List<WebElement> validOptions = new ArrayList<>();
				for (WebElement option : SurveyorName) {
					if (!option.getText().toLowerCase().contains("select")) {
						validOptions.add(option);
					}
				}
				if (!validOptions.isEmpty()) {
					Random Surveyorname = new Random();
					int randomIndexOfSurveyorName = Surveyorname.nextInt(validOptions.size());
					dropdown.selectByIndex(SurveyorName.indexOf(validOptions.get(randomIndexOfSurveyorName)));
					String Surveyor_Name = validOptions.get(randomIndexOfSurveyorName).getText();
					System.out.println("Surveyor Name: " + Surveyor_Name);
				}

				webDriverWait(ExpectedConditions.visibilityOf(apin.get_Surveyor_Remarks()));
				apin.get_Surveyor_Remarks().sendKeys("testing");

				webDriverWait(ExpectedConditions.visibilityOf(apin.get_Surveyor_Risk()));
				apin.get_Surveyor_Risk().sendKeys(Surveyor_Risk);

				// Survey Upload docs
				webDriverWait(ExpectedConditions.visibilityOf(apin.Surveyor_Doctype()));
				selectByVisibleText(apin.Surveyor_Doctype(), Survey_Doc_type);

				// upload Surveyor doc in policy level
				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Surveyor_Upload()));
				apin.Surveyor_Upload().click();
				StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				rb.delay(5000);

				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);

				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);

				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				rb.delay(10000);

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_surveyor()));
				apin.Save_surveyor().click();

		//Terms and Conditions
				rb.delay(5000);

				try {

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Terms_Conditions()));
					apin.Add_Terms_Conditions().click();
					System.out.println("Add Terms and condition is Enabled");

				} catch (Exception e) {

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Panel()));
					apin.Terms_Conditions_Panel().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Add_Terms_Conditions()));
					apin.Add_Terms_Conditions().click();

				}

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Terms_Conditions_Checkbox()));
				javaScribtClick(apin.Terms_Conditions_Checkbox());

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Terms_Conditions()));
				apin.Save_Terms_Conditions().click();

				rb.delay(3000);

		//Policy Documents Upload
				// scrollDownJavaSc(obj.Policy_Document_Dropdown());
				webDriverWait(ExpectedConditions.visibilityOf(apin.Policy_Document_Dropdown()));
				selectByVisibleText(apin.Policy_Document_Dropdown(), Doc_type);

				rb.delay(7000);

				webDriverWait(ExpectedConditions.elementToBeClickable(apin.upload_File()));
				apin.upload_File().click();
				StringSelection ss1 = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
				rb.delay(2000);

				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);

				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);

				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				rb.delay(7000);

				// Click proceed
				webDriverWait(ExpectedConditions.elementToBeClickable(apin.proceed_Button()));
				apin.proceed_Button().click();
				rb.delay(10000);
		
	}
}
package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.testng.annotations.Test;

public class MarineHull_Endorsement extends BaseClass {

	public static String Endor_Pol;
	public static String OurShare;
	public static String Mode_Of_Pay;
	public static String Net_To_Customer;

	@Test(dataProvider = "Marine_Hull_Endorsement")

	public void tc001(String S_No, String Search_Policy, String Policy_Query, String Policy_Number, String Remarks,
			String Contact_No, String Email_ID, String Address, String Coinsurer_Name_Query, String Coinsurer_ID,
			String Non_Financial_Endor, String Change_PolicyPeriod_Endor, String Extension_PolicyPeriod_Endor,
			String Reduction_PolicyPeriod_Endor, String Financial_Endorse, String Change_BS_Endor,
			String Policy_Cancellation_Endor, String Policy_Reinstatement_Endor, String Cash_Type, String Cheque_No,
			String Bank_Name, String Account_Number, String Insured_Billing_Account, String Policy_Endorsement,
			String Run_Flag)
			throws AWTException, ClassNotFoundException, IOException, InterruptedException, ParseException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		PersonalUW_Login PLP = new PersonalUW_Login();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Issue_MarineHull_Policy Pol = new Issue_MarineHull_Policy();

//Policy Endorsements validation.
		if (Policy_Endorsement.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

			if (Pol.Policy_Number == null) {
				String Endorse_Policy = "SELECT * FROM (SELECT TPI_POLICY_NO FROM T_POL_INFO WHERE TPI_STATUS = 'A' AND NOT EXISTS (SELECT 1 FROM Q_POL_INFO WHERE \r\n"
						+ "QPI_TRAN_TYPE='REN' and QPI_OLD_POLICY_NO = TPI_POLICY_NO) AND TPI_BDM_USER IS NULL AND (TPI_END_TYPE != '008' \r\n"
						+ "OR TPI_END_TYPE IS NULL) and (tpi_prod_code in(0603)) ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = '1'";
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(get_DB_Data(Endorse_Policy, "TPI_POLICY_NO"));
				// GSP.Policy_Number_Field().sendKeys("01141002144");
			} else {
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Pol.Policy_Number);
			}

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
			Endor_Pol = GSP.Policy_Number().getText();
			System.out.println("Endorsment Policy: " + Endor_Pol);

			Thread.sleep(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
			GSP.endorsement_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
			String Policytype = GSP.Policy_Type().getText();
			System.out.println("Type of Policy: " + Policytype);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
			String Insured = GSP.Insured_Name().getText();
			System.out.println("Insured Name: " + Insured);

			if (Non_Financial_Endor.equals("Yes")) {

				// Select Endorsement Type
				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Non Financial");

				webDriverWait(ExpectedConditions.visibilityOf(EIP.Org_Policy_Start_Date()));
				String Policy_Start_Date = EIP.Org_Policy_Start_Date().getAttribute("value");
				System.out.println("Policy Start Date: " + Policy_Start_Date);

				webDriverWait(ExpectedConditions.visibilityOf(EIP.Org_Policy_End_Date()));
				String Policy_End_Date = EIP.Org_Policy_End_Date().getAttribute("value");
				System.out.println("Policy End Date: " + Policy_End_Date);

				webDriverWait(ExpectedConditions.visibilityOf(EIP.End_From_Date()));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date startDate = dateFormat.parse(Policy_Start_Date);
				Date endDate = dateFormat.parse(Policy_End_Date);
				// Generate random date between startDate and endDate
				Date randomDate = getRandomDate(startDate, endDate);
				// Format and print random date
				String endfmdate = dateFormat.format(randomDate);
				EIP.End_From_Date().clear();
				EIP.End_From_Date().sendKeys(endfmdate);
				System.out.println("Endrosement from date: " + endfmdate);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + endorsement_Type);

//				Get Policy Number 
				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Policy_Number()));
				Endor_Pol = EIP.get_Policy_Number().getText();

//				Get Customer name
				webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
				String customer_Name = EIP.customer_Name().getText();
				String customer = customer_Name.replace(" - ", "-");
				System.out.println("Customer name is: " + customer);

//				Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys("Remarks");

//				Enter Contact Details
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Contact_No()));
				EIP.Contact_No().clear();
				EIP.Contact_No().sendKeys("Contact_No");

//				Enter Email ID
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Email_Id()));
				EIP.Email_Id().clear();
				EIP.Email_Id().sendKeys("Email_ID");

//				Change Address
				webDriverWait(ExpectedConditions.visibilityOf(EIP.address_Field()));
				EIP.address_Field().clear();
				EIP.address_Field().sendKeys("Address");

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Risk page

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.EditRisk_Button()));
				ris.EditRisk_Button().click();

				Thread.sleep(1000);
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add pol info
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// RI Ceding page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				try {
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();
				} catch (Exception e) {
				}

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
				javaScribtClick(EIP.approve_Non_Financial_Endorsement());

//non-financial endorsement ends here			
			}

			if (Change_PolicyPeriod_Endor.equals("Yes")) {

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Change in Policy Period");

				// Enter Endorsement From Date
				webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
				GSP.effective_From_Date().click();
				keyPress(KeyEvent.VK_CONTROL);
				keyPress(KeyEvent.VK_A);
				keyRelease(KeyEvent.VK_CONTROL);
				keyRelease(KeyEvent.VK_A);

				keyPress(KeyEvent.VK_BACK_SPACE);
				keyRelease(KeyEvent.VK_BACK_SPACE);
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				// Get the current date
				LocalDate currentDate1 = LocalDate.now();
				// Add one day to the current date to get the next date
				LocalDate nextDate1 = currentDate1.plusDays(20);
				// Format the next date to the desired format
				String formattedNextDate1 = nextDate1.format(formatter1);
				GSP.effective_From_Date().sendKeys(formattedNextDate1);

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				try {

					webDriverWait(ExpectedConditions.visibilityOf(EIP.Change_PolicyPeriod_Validation()));
					String Change_Period = EIP.Change_PolicyPeriod_Validation().getText();
					System.out.println(Change_Period);

					if (EIP.Change_PolicyPeriod_Validation().isEnabled()) {
						System.out.println("Change Period validation Msg: " + Change_Period);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_Pol, Keys.ENTER);
					}

				} catch (Exception e) {

					webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
					String endorsement_Type = EIP.get_Endorsement_Type().getText();
					System.out.println("Endorsement Type is: " + endorsement_Type);

					// Get Customer name
					webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
					String customer_Name = EIP.customer_Name().getText();
					String customer = customer_Name.replace(" - ", "-");
					System.out.println("Customer name is: " + customer);

					// Enter Remarks
					webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
					EIP.remarks_Field().sendKeys(Remarks);

					// Click Proceed Button
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					// Risk Edit if needed
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					// add polinfo page
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
					EIP.proceed_Button().click();

					// Approve Endorsement
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
					javaScribtClick(EIP.approve_Endorsement_Button());

//					Customer Name Verification
					String customerName = EIP.customer_Name().getText();
					System.out.println("Customer Name is: " + customerName);

					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
					EIP.Close_Button().click();

					rb.delay(3000);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

					webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
					selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_Pol);
					System.out.println("Policy Number is: " + Endor_Pol);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();
//					if (Policy_No.contains(Policy_Number)) {
//						Assert.assertEquals(Policy_No, Policy_Number);
//						System.out.println("Policy Number Verification is Pass");
//					} else {
//						Assert.fail();
//						System.out.println("Policy Number Verification Failed");
//					}

//					Click Policy Details Menu
//					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Details_Menu()));
//					GSP.policy_Details_Menu().click();

				}
//Change_PolicyPeriod_Endor ends here				
			}

			if (Extension_PolicyPeriod_Endor.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				// Select Endorsement Type
				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Extension of Policy Period");

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
				String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
				System.out.println("Policy Start Date: " + ActualPolicyStartDate);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
				String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
				System.out.println("Policy End Date: " + ActualPolicyEndDate);

				// Enter Endorsement To Date
				webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
				LocalDateTime newDate = date.plusDays(15);
				String newDateString = newDate.format(formatter1);
				GSP.effective_To_Date().sendKeys(newDateString);
				System.out.println("Endorsement Effective to Date: " + newDateString);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

				// Get Customer name
				webDriverWait(ExpectedConditions.visibilityOf(EIP.customer_Name()));
				String customer_Name = EIP.customer_Name().getText();
				String customer = customer_Name.replace(" - ", "-");
				System.out.println("Customer name is: " + customer);

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Risk Edit if needed
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add polinfo page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);
				System.out.println("Policy Number is: " + Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

//Extension_PolicyPeriod_Endor ends here				
			}

			if (Reduction_PolicyPeriod_Endor.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Reduction of Policy Period");

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
				String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
				System.out.println("Policy Start Date: " + ActualPolicyStartDate);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
				String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
				System.out.println("Policy End Date: " + ActualPolicyEndDate);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
				GSP.effective_To_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
				LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
				LocalDateTime newDate = date.plusDays(-30);
				String newDateString = newDate.format(formatter1);
				GSP.effective_To_Date().sendKeys(newDateString);
				System.out.println("Endorsement Effective to Date: " + newDateString);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Risk Edit if needed
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add polinfo page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);
				System.out.println("Policy Number is: " + Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

//Reduction_PolicyPeriod_Endor ends here				
			}

			if (Financial_Endorse.equals("Yes")) {

//Financial_Endorse ends here				
			}

			if (Change_BS_Endor.equals("Yes")) {

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Change in Source of Business");

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
				String ActualPolicyStartDate = GSP.policy_Start_Date().getAttribute("value");
				System.out.println("Policy Start Date: " + ActualPolicyStartDate);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
				String ActualPolicyEndDate = GSP.policy_To_Date().getAttribute("value");
				System.out.println("Policy End Date: " + ActualPolicyEndDate);

//				webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_To_Date()));
//				GSP.effective_To_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//				LocalDateTime date = LocalDateTime.parse(ActualPolicyEndDate, formatter1);
//				LocalDateTime newDate = date.plusDays(-30);
//				String newDateString = newDate.format(formatter1);
//				GSP.effective_To_Date().sendKeys(newDateString);
//				System.out.println("Endorsement Effective to Date: " + newDateString);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

				// Select the BS type
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Select_BS()));
				Select select = new Select(EIP.Select_BS());
				java.util.List<WebElement> options = select.getOptions();
				Random random = new Random();
				int randomIndex = 1 + random.nextInt(options.size() - 1);
				select.selectByIndex(randomIndex);
				String BS = options.get(randomIndex).getText();
				System.out.println("Selected option: " + BS);

				if (BS.contains("with Elmo Leader")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Coin_Percent()));
					EIP.Coin_Percent().sendKeys("70");
					OurShare = EIP.Coin_Percent().getAttribute("value");
					System.out.println("Coinsurance Ourshare value: " + OurShare);
				} else if (BS.contains("with Elmo Follower")) {
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Coin_Percent()));
					EIP.Coin_Percent().sendKeys("30");
					OurShare = EIP.Coin_Percent().getAttribute("value");
					System.out.println("Coinsurance Ourshare value: " + OurShare);
				}

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

				if (BS.equals("Branches") || BS.equals("Branches with Elmo Leader")
						|| BS.equals("Direct with Elmo Leader") || BS.equals("Direct with Elmo Follower")
						|| BS.equals("Staff with Elmo Leader") || BS.equals("Salesman with Elmo Leader")
						|| BS.equals("Salesman") || BS.equals("Introducers")
						|| BS.equals("Introducers with Elmo Leader") || BS.equals("Staff") || BS.equals("Direct")) {

//					Enter Introducer Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
					cus.introducer_Name_Field().sendKeys("M00");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
					String Introducer = EIP.select_Intoducer().getText();
					EIP.select_Intoducer().click();
					System.out.println("Introducer Name: " + Introducer);

//					Enter Processor Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
					cus.Processor_Name_Field().sendKeys("PROFLIM01");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
					String Processor = EIP.select_processor().getText();
					EIP.select_processor().click();
					System.out.println("Processor Name: " + Processor);

				} else if (BS.equals("Broker with Elmo Leader") || BS.equals("Broker with Elmo Follower")
						|| BS.equals("Broker")) {

//					Enter Introducer Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
					cus.introducer_Name_Field().sendKeys("SPIRINS01");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
					String Introducer = EIP.select_Intoducer().getText();
					EIP.select_Intoducer().click();
					System.out.println("Introducer Name: " + Introducer);

//					Enter Processor Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
					cus.Processor_Name_Field().sendKeys("GERPRIL01");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
					String Processor = EIP.select_processor().getText();
					EIP.select_processor().click();
					System.out.println("Processor Name: " + Processor);

				} else if (BS.equals("Tied Insurance Intermediary with Elmo Leader")
						|| BS.equals("Tied Insurance Intermediary")) {

//					Enter Introducer Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.introducer_Name_Field()));
					cus.introducer_Name_Field().sendKeys("PROFLIM01");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_Intoducer()));
					String Introducer = EIP.select_Intoducer().getText();
					EIP.select_Intoducer().click();
					System.out.println("Introducer Name: " + Introducer);

//					Enter Processor Name
					webDriverWait(ExpectedConditions.visibilityOf(cus.Processor_Name_Field()));
					cus.Processor_Name_Field().sendKeys("M0010");
					webDriverWait(ExpectedConditions.elementToBeClickable(EIP.select_processor()));
					String Processor = EIP.select_processor().getText();
					EIP.select_processor().click();
					System.out.println("Processor Name: " + Processor);
				}

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// enter coinsurance information page

				if (BS.equals("Direct with Elmo Leader") || BS.equals("Direct with Elmo Follower")
						|| BS.equals("Broker with Elmo Leader") || BS.equals("Broker with Elmo Follower")
						|| BS.equals("Salesman with Elmo Leader") || BS.equals("Introducers with Elmo Leader")
						|| BS.equals("Branches with Elmo Leader") || BS.equals("Staff with Elmo Leader")
						|| BS.equals("Tied Insurance Intermediary with Elmo Leader")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.co_Insursance_Menu()));
					apin.co_Insursance_Menu().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.add_Co_Insurance_Button()));
					apin.add_Co_Insurance_Button().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Name_Field()));
					apin.coinsurance_Name_Field().sendKeys(get_DB_Data(Coinsurer_Name_Query, Coinsurer_ID));
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.select_Coinsurance()));
					rb.delay(5000);
					apin.select_Coinsurance().click();
					String coinsurer = getAtrributeValue(apin.coinsurance_Name_Field(), "value");
					System.out.println("Coinsurer Name: " + coinsurer);
					rb.delay(3000);

					webDriverWait(ExpectedConditions.elementToBeClickable(apin.coinsurance_Share_Percentage_Field()));
					apin.coinsurance_Share_Percentage_Field().click();
					int Ourshare = Integer.parseInt(OurShare);
					int coin_share = 100 - Ourshare;
					apin.coinsurance_Share_Percentage_Field().sendKeys(String.valueOf(coin_share), Keys.TAB);
					System.out.println("coinsurer share percentage: " + coin_share);

					if (BS.equals("Direct with Elmo Follower") || BS.equals("Broker with Elmo Follower")) {
						webDriverWait(ExpectedConditions.elementToBeClickable(apin.Coins_LeaderYN()));
						apin.Coins_LeaderYN().click();
					}

//					Save Details
					webDriverWait(ExpectedConditions.elementToBeClickable(apin.Save_Coinsurance_Details()));
					apin.Save_Coinsurance_Details().click();

				}

				// add polinfo page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);
				System.out.println("Policy Number is: " + Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

//Change_BS_Endor ends here		
			}

			if (Policy_Cancellation_Endor.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Policy Cancellation");

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys(Remarks);

				// Risk page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add pol info page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);
				System.out.println("Policy Number is: " + Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

//Policy_Cancellation_Endor	ends here		
			}

			if (Policy_Reinstatement_Endor.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Policy Re-Instatement");

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				String Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

				// Click Proceed Button
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys("Remarks");

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Risk page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// add pol info page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				// Ri ceding page
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ra.mode_of_Pay_Dropdown()));
//				selectByIndex(ra.mode_of_Pay_Dropdown(), 3);
//				Mode_Of_Pay = first_Selected_Value(ra.mode_of_Pay_Dropdown());
//				System.out.println(Mode_Of_Pay);
				Select modelist = new Select(ra.mode_of_Pay_Dropdown());
				List<WebElement> ModeOfPay = modelist.getOptions();
				List<WebElement> Options = new ArrayList<>();
				for (WebElement options : ModeOfPay) {
					if (!options.getText().toLowerCase().contains("select")) {
						Options.add(options);
					}
				}
				if (!Options.isEmpty()) {
					Random ModeofPay = new Random();
					int randomPayMode = ModeofPay.nextInt(Options.size());
					modelist.selectByIndex(ModeOfPay.indexOf(Options.get(randomPayMode)));
					Mode_Of_Pay = Options.get(randomPayMode).getText();
					System.out.println("Mode of Pay: " + Mode_Of_Pay);
				}

				if (Mode_Of_Pay.equals("Cash") || Mode_Of_Pay.equals("Cash sale combined")) {
					// Click Cash Analysis
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Analysis_Button()));
					ra.cash_Analysis_Button().click();

					// Click Add New Button
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.add_New_Button()));
					ra.add_New_Button().click();

					// Click Check Box
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.cash_Code_Checkbox()));
					ra.cash_Code_Checkbox().click();

					// Select cash Type
					webDriverWait(ExpectedConditions.visibilityOf(ra.cash_Type_Dropdown()));
					selectByVisibleText(ra.cash_Type_Dropdown(), Cash_Type);

					if (Cash_Type.equals("CHEQUE")) {
						// Enter Cheque No
						webDriverWait(ExpectedConditions.visibilityOf(ra.cheque_Ref_Num()));
						ra.cheque_Ref_Num().sendKeys(Cheque_No);

						// Select Bank Name
						webDriverWait(ExpectedConditions.visibilityOf(ra.Bank_Name_Dropdown()));
						selectByVisibleText(ra.Bank_Name_Dropdown(), Bank_Name);

						// Enter Account Number
						webDriverWait(ExpectedConditions.visibilityOf(ra.account_Number_Field()));
						ra.account_Number_Field().sendKeys(Account_Number);

						// Enter Cheque Date
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.cheque_End_Date()));
						ra.cheque_End_Date().click();

						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						LocalDateTime now = LocalDateTime.now();
						ra.cheque_End_Date().sendKeys(dtf.format(now));

						// Enter Amount
						webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
						ra.amount_Field().sendKeys(Net_To_Customer);
					} else if (Cash_Type.equals("CASH")) {
						// Enter Amount
						webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
						ra.amount_Field().sendKeys(Net_To_Customer);
					}

					// Save the details
					webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
					ra.save_Cash_Analysis().click();

				} else if (Mode_Of_Pay.equals("Credit")) {
					webDriverWait(ExpectedConditions.visibilityOf(ra.Insured_Billing_Account()));
					rb.delay(2000);
					selectByIndex(ra.Insured_Billing_Account(), 1);
				}

				// Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Endorsement_Button()));
				javaScribtClick(EIP.approve_Endorsement_Button());

//				Customer Name Verification
				String customerName = EIP.customer_Name().getText();
				System.out.println("Customer Name is: " + customerName);

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.Close_Button()));
				EIP.Close_Button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
				selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

				// Enter Policy Number
				webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
				GSP.Policy_Number_Field().sendKeys(Endor_Pol);
				System.out.println("Policy Number is: " + Endor_Pol);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
				GSP.policy_Search_Button().click();

//Policy_Reinstatement_Endor ends here		
			}

		}
	}
}
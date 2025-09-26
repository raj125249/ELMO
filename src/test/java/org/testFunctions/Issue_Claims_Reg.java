package org.testFunctions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

import org.common.BaseClass;
import org.common.BasicFunctions;
import org.common.ReadExcelData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.pages.Issue_Claims_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Login_Page;
import org.pages.Global_Search_Page;
import org.pages.Underwritting_Page;
import org.testng.annotations.Test;

public class Issue_Claims_Reg extends BaseClass {

	public static StringSelection upload;
	public static String Esti_WF_User;
	public static String Esti_RefNo;
	public static String Clm_Status;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static String USER;
	public static String Password;
	public static String Our_Percentage;
	public static List<WebElement> Clm_MyAction;
	public static String Clm_Coin_Act;
	public static String Clm_FAC_Act;

	@Test(dataProvider = "Claims")
	public void tc_001(String S_No, String Intimation_Mode, String Intimated_By, String Claim_Policy_Query,
			String Policy_No, String Handler_Change, String Loss_Details, String Clm_Inti_TPrecovery,
			String Clm_Handler, String Doc_type, String CauseofLoss, String NatureofLoss, String coin_share,
			String Estimate_Watchlist, String Esti_Claimant_Change, String OurSI_Exceed, String Inti_Estimate_Amount,
			String Deductible, String Settle_MOPay, String Rec_Settle_MOPay, String Rec_Cash_Type, String Revise_MOP,
			String Cheque_No, String Bank_Name, String Account_Number, String SEPA_ACNO, String SEPA_Swift_Code,
			String SEPA_IABN, String SEPA_BankName, String SEPA_EMAILID, String SEPA_BICcode, String SEPA_MobileNO,
			String Clm_Subrogation, String Run_Flag) throws Exception {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		Login_Claims CLP = new Login_Claims();
		Issue_Claims_Page CLM = new Issue_Claims_Page();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_Add()));
		CLM.Clm_Inti_Add().click();

//Claim intimation page
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_Mode()));
		selectByVisibleText(CLM.Clm_Inti_Mode(), Intimation_Mode);
		System.out.println("Claims intimatin mode: " + Intimation_Mode);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_IntimatedBy()));
		selectByVisibleText(CLM.Clm_Inti_IntimatedBy(), Intimated_By);
		System.out.println("claims intimated by: " + Intimated_By);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_intimation_Date()));
		String Intimation_Date = CLM.Clm_intimation_Date().getAttribute("value");
		System.out.println("claim intimation date: " + Intimation_Date);

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Inti_PolicyNo()));
		CLM.Clm_Inti_PolicyNo().sendKeys(get_DB_Data(Claim_Policy_Query, Policy_No), Keys.TAB);
		String Clms_Policy_number = CLM.Clm_Inti_PolicyNo().getAttribute("value");
		System.out.println("policy Number: " + Clms_Policy_number);

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Inti_PolicyType()));
		String Clms_PolicyType = first_Selected_Value(CLM.Clm_Inti_PolicyType());
		System.out.println("claims type of policy: " + Clms_PolicyType);

		Thread.sleep(2000);
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Inti_Policy_Startdate()));
		String Pol_Startdate = getAtrributeValue(CLM.Clm_Inti_Policy_Startdate(), "value");
		System.out.println("Policy Startdate: " + Pol_Startdate);

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Inti_Policy_Enddate()));
		String Pol_Enddate = getAtrributeValue(CLM.Clm_Inti_Policy_Enddate(), "value");
		System.out.println("Policy EndDate: " + Pol_Enddate);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_LossDate()));
		String LossDate = BasicFunctions.getValidLossDate(Pol_Startdate, Pol_Enddate, Intimation_Date);
		CLM.Clm_Inti_LossDate().sendKeys(LossDate);
		System.out.println("Loss Date: " + LossDate);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_LossDetails()));
		CLM.Clm_Inti_LossDetails().sendKeys(Loss_Details);
		System.out.println("Claims Loss Details: " + Loss_Details);

		if (Clm_Inti_TPrecovery.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_TPRecovery_Yes()));
			CLM.Clm_Inti_TPRecovery_Yes().click();
			System.out.println("Claim Intimation Third Party Recovery: YES");
		}

		if (Handler_Change.equals("Yes")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_HandlerBy()));
			selectByVisibleText(CLM.Clm_Inti_HandlerBy(), Clm_Handler);
		} else if (Handler_Change.equals("No")) {
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_HandlerBy()));
		}

		String handler_id = first_Selected_Value(CLM.Clm_Inti_HandlerBy());
		System.out.println("Claims Handler: " + handler_id);

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Document_Dropdown()));
		selectByVisibleText(CLM.Clm_Document_Dropdown(), Doc_type);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.upload_File()));
		CLM.upload_File().click();
		upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
		rb.delay(5000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		rb.delay(10000);

		rb.delay(3000);

//		if (!(handler_id.equals(CLP.Loginuser))) {
//			rb.delay(3000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_Saveoption()));
//			CLM.Clm_Inti_Saveoption().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_Succ_Msg()));
//			String Intimation_succMSG = CLM.Clm_Inti_Succ_Msg().getText();
//			System.out.println("Claims Intimation reference msg: " + Intimation_succMSG);
//			String refno = Intimation_succMSG.replaceAll("[^0-9]", "");
//			System.out.println("claims refno: " + refno);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
//			uwp.userNameField().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
//			uwp.User_logout().click();
//
//			String username_Query = "select Cl_handled_by from t_claim_log where cl_policy_no='" + Clms_Policy_number
//					+ "' and cl_id='" + refno + "' and rownum=1";
//			String handler = get_DB_Data(username_Query, "Cl_handled_by");
//			String password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + handler
//					+ "') USER_PASSWORD FROM DUAL";
//			String handler_password = get_DB_Data(password_Query, "USER_PASSWORD");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
//			LP.username_Field().click();
//
//			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
//			LP.username_Field().sendKeys(handler);
//
//			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
//			LP.password_Field().sendKeys(handler_password);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
//			LP.login_Button().click();
//
//			rb.delay(5000);
//			CLP.Loginuser = LP.User_Profile_Name().getText();
//			System.out.println("User Profile Name is: " + CLP.Loginuser);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_Search()));
//			CLM.Clm_Inti_Search().sendKeys(refno, Keys.ENTER);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_EditIcon()));
//			CLM.Clm_Inti_EditIcon().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_LossDetails()));
//			CLM.Clm_Inti_LossDetails().clear();
//			CLM.Clm_Inti_LossDetails().sendKeys("building damage");
//			System.out.println("Claims Loss Details: " + "building damage");
//		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Inti_RegisterClaim()));
		CLM.Clm_Inti_RegisterClaim().click();

//Claims Registration page
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Regis_CauseofLoss()));
		selectByIndex(CLM.Clm_Regis_CauseofLoss(), 2);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Regis_NatureofLoss()));
		rb.delay(2000);
		selectByIndex(CLM.Clm_Regis_NatureofLoss(), 1);

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Regis_RiskID()));
		selectByIndex(CLM.Clm_Regis_RiskID(), 1);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Regis_CoverID()));
		selectByIndex(CLM.Clm_Regis_CoverID(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Regis_Liability()));
		selectByIndex(CLM.Clm_Regis_Liability(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Register()));
		CLM.Claim_Register().click();

		try {
			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Register_Confirmation()));
			CLM.Claim_Register_Confirmation().click();
		} catch (Exception e) {
		}

//Claims Details Page

		rb.delay(7000);
		String Login_User = LP.User_Profile_Name().getText();
		System.out.println("User Profile Name is: " + Login_User);

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_No()));
		String Clm_No = CLM.Claim_No().getText();
		System.out.println("Claim Number: " + Clm_No);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_PolicyNo()));
		String Clm_Pol_No = CLM.Claim_PolicyNo().getText();
		System.out.println("Claim Policy Number: " + Clm_Pol_No);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_BS()));
		String Clm_BS = CLM.Claims_BS().getText();
		System.out.println("Claim Business Source: " + Clm_BS);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Product()));
		String Clm_Product = CLM.Claims_Product().getText();
		System.out.println("Claim Product: " + Clm_Product);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_PolicyType()));
		String Clm_Policytype = CLM.Claims_PolicyType().getText();
		System.out.println("Claim Policy Type: " + Clm_Policytype);

		try {

			webDriverWait(ExpectedConditions.visibilityOf(CLM.CLM_FAC_Applicable()));
			Clm_FAC_Act = CLM.CLM_FAC_Applicable().getText();
			System.out.println("Claim: " + Clm_FAC_Act);

			webDriverWait(ExpectedConditions.visibilityOf(CLM.CLM_Coin_Applicable()));
			Clm_Coin_Act = CLM.CLM_Coin_Applicable().getText();
			System.out.println("Claim: " + Clm_Coin_Act);

		} catch (Exception e) {

		}

//Claims add Risk information page
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Add()));
		CLM.Clm_Risk_Add().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Cover()));
		selectByIndex(CLM.Clm_Risk_Cover(), 1);

		rb.delay(3000);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_SMI_Code()));
		selectByIndex(CLM.Clm_Risk_SMI_Code(), 1); // need to handle on the second level.

//		if (!Clm_Product.equals("International Commercial") && Clm_Product.equals("Credit Personal")) {
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_SMI_Code()));
//			selectByIndex(CLM.Clm_Risk_SMI_Code(), 1); // need to handle on the second level.
//
//		}

//		if (Estimate_Watchlist="Yes") {
//			
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Initial_Esti_Customer_Code()));
//			CLM.Clm_Initial_Esti_Customer_Code().clear();
//			CLM.Clm_Initial_Esti_Customer_Code().sendKeys(get_DB_Data( , ));
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Select_Customer_Code()));
//			rb.delay(5000);
//			CLM.Clm_Select_Customer_Code().click();
//			String WatchList_Claimant = CLM.Clm_Initial_Esti_Customer_Code().getAttribute("value");
//			System.out.println("Watchlist claimant: "+WatchList_Claimant);
//			
//		}else if (Estimate_Watchlist="No") {
//			
//			if (Esti_Claimant_Change="Yes") {
//				
//			} else if (Esti_Claimant_Change="No"){ 
//
//			}
//			
//		}

//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Initial_Esti_Customer_Code()));
//		CLM.Clm_Initial_Esti_Customer_Code().clear();
//		CLM.Clm_Initial_Esti_Customer_Code().sendKeys("433950M");
//		rb.delay(7000);
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Select_Esti_Customer_Code()));
//		CLM.Clm_Select_Esti_Customer_Code().click();

		Thread.sleep(3000);
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Risk_SI_Value()));
		String Claims_SILImit_Value = CLM.Clm_Risk_SI_Value().getAttribute("value");
		System.out.println("Claims Risk SI Limit: " + Claims_SILImit_Value);

//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Percentage()));
//		String Text = CLM.Clm_Our_Percentage().getText();
//		Our_Percentage = Text.replaceAll("[^\\d]", "") + "%";
//		System.out.println("claims our percentage: " + Our_Percentage);

		if (Clm_BS.contains("with Elmo Leader")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Percentage()));
			String Text = CLM.Clm_Our_Percentage().getText();
			Our_Percentage = Text.replaceAll("[^\\d]", "") + "%";
			System.out.println("claims our percentage: " + Our_Percentage);

			if (coin_share.equals("No")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Coin_100share()));
				CLM.Clm_Esti_Coin_100share().click();
			} else if (coin_share.equals("Yes")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Coin_Ourshare()));
				CLM.Clm_Risk_Coin_Ourshare().click();
			}
		}
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_RIsk_Estimate_Code()));
		selectByIndex(CLM.Clm_RIsk_Estimate_Code(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Estimate_Amount()));
		CLM.Clm_Risk_Estimate_Amount().clear();
		CLM.Clm_Risk_Estimate_Amount().sendKeys(Inti_Estimate_Amount, Keys.TAB);
		System.out.println("Claims estimate value: " + Inti_Estimate_Amount);

		if (Deductible.equals("Yes")) {

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Deductible_Checkbox()));
			CLM.Deductible_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Deductible_1CheckBox()));
			CLM.Deductible_1CheckBox().click();
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Liability_Type()));
		selectByIndex(CLM.Clm_Liability_Type(), 1);

		// Claims Intimation Doc Upload
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Document_Dropdown()));
		selectByVisibleText(CLM.Clm_Document_Dropdown(), Doc_type);

		rb.delay(7000);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.upload_File()));
		CLM.upload_File().click();

		upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
		SwingUtilities.invokeLater(() -> {
			try {
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
			} catch (// IllegalState
			Exception e) {
				// e.printStackTrace(); // Log the exception for debugging
			}
		});

//		upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
		rb.delay(5000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(10000);

		System.out.println("Document upload successful");
		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
		CLM.Clm_Risk_Save().click();

		try {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_OurSI_Exceed_Msg()));
			String text2 = CLM.Clm_OurSI_Exceed_Msg().getText();
			System.out.println("Claims Our SI limit validation msg: " + text2);
			String Our_SI_Limit = text2.replaceAll("[^0-9]", "");
			System.out.println("Claims our si limit amount: " + Our_SI_Limit);

			if (OurSI_Exceed.equals("Yes")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Exceed_Confirmation()));
				CLM.Clm_Our_Exceed_Confirmation().click();
			} else {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Exceed_Close()));
				CLM.Clm_Our_Exceed_Close().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Estimate_Amount()));
				int a = Integer.parseInt(Our_SI_Limit);
				int result = a - 20;
				String SIvalue = String.valueOf(result);
				CLM.Clm_Risk_Estimate_Amount().clear();
				CLM.Clm_Risk_Estimate_Amount().sendKeys(SIvalue, Keys.TAB);
				System.out.println("claims our si limit: " + SIvalue);
			}

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
			CLM.Clm_Risk_Save().click();

		} catch (Exception e) {

		}

		try {
			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Risk_Coin_limitValidation()));
			CLM.Clm_Risk_Coin_limitValidation().getText();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Coin_limitValidation_Yes()));
			CLM.Clm_Risk_Coin_limitValidation_Yes().click();

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
			CLM.Clm_Risk_Save().click();
		} catch (Exception e) {

		}

		try {
			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Risk_WF_Msg()));
			String Risk_Estimate_WF = CLM.Clm_Risk_WF_Msg().getText();
			System.out.println("Estimate WF Msg: " + Risk_Estimate_WF);
			Esti_RefNo = extractWorkflowReference(Risk_Estimate_WF);
			System.out.println("Estimate WF refno: " + Esti_RefNo);

			Pattern pattern = Pattern.compile("sent to ([\\w\\s]+) for the amount.*Workflow Reference No (\\d+)");
			Matcher matcher = pattern.matcher(Risk_Estimate_WF);

			// boolean found = false;

			while (matcher.find()) {
				// found = true;
				Esti_WF_User = matcher.group(1).trim();
				Esti_RefNo = matcher.group(2);

				System.out.println("User: " + Esti_WF_User);
				System.out.println("Reference No: " + Esti_RefNo);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
					+ Esti_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
			App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
			WF_Description = get_DB_Data(username_Query, "WF_DESC");

			password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
					+ "') USER_PASSWORD FROM DUAL";
			App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

			rb.delay(7000);
			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().sendKeys(App_User);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
			LP.password_Field().sendKeys(App_Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
			CLM.Clm_Myactions_Tab().click();

			Clm_MyAction = CLM.Clm_MyAction_SubSection();

			for (WebElement Clm_MyAction_Section : Clm_MyAction) {
				String SubsectionText = Clm_MyAction_Section.getText().trim();

				if (WF_Description.equals(SubsectionText)) {
					Clm_MyAction_Section.click();
					System.out.println("Claims WF Section: " + WF_Description);
					break;
				}
			}

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
			CLM.Clm_Myactionstab_Search().sendKeys(Esti_RefNo);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
			CLM.Clm_Approver_Viewoption().click();

			rb.delay(20000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
			CLM.Clm_Approve_Remarks().sendKeys("test");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
			CLM.Clm_WF_Approve().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_WF_msg()));
			CLM.Clm_WF_msg().getText();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			String userQuery = "select user_id from m_user where user_name='" + Login_User + "' and rownum=1";
			USER = get_DB_Data(userQuery, "user_id");
			String PasswordQuery = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + USER
					+ "') USER_PASSWORD FROM DUAL";
			Password = get_DB_Data(PasswordQuery, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().click();

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(USER);

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

//global search for the claim
			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
			GSP.Claim_Number_Feild().sendKeys(Clm_No);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
			GSP.Claim_Search_button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
			GSP.Claim_GoTo().click();
		} catch (Exception e) {
		}

		try {

			if (Clm_FAC_Act.equals("FAC is Applicable")) {

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().sendKeys("juans");

				String password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD('juans') USER_PASSWORD FROM DUAL";
				String password = get_DB_Data(password_Query, "USER_PASSWORD");

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
				LP.password_Field().sendKeys(password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(5000);
				Login_User = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + Login_User);

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
				uwp.menu_Button().click();
				rb.delay(2000);

				scrollDownJavaSc(uwp.Reinsurance_Menu());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Reinsurance_Menu()));
				uwp.Reinsurance_Menu().click();
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.RI_Allocation()));
				uwp.RI_Allocation().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No()));
				CLM.RI_Allocation_Claim_No().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No_Search()));
				CLM.RI_Allocation_Claim_No_Search().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1stRiskinfo_Grid()));
				CLM.Clm_1stRiskinfo_Grid().click();

				scrollDownJavaSc(CLM.Clm_1st_estimate());
				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1st_estimate()));
				CLM.Clm_1st_estimate().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Estimate_RI()));
				CLM.Claim_Estimate_RI().click();

				scrollDownJavaSc(CLM.Claims_Estimate_Approve_FAC());
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_FAC_Grid_Table()));
				CLM.Clm_FAC_Grid_Table().click();

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_FAC()));
				CLM.Claims_Estimate_Approve_FAC().click();

				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("FAC approve text: " + alertText);
				acceptAlert(); // alert.accept();
				rb.delay(5000);
				System.out.println("FAC got approved successfully");

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_App_Tty()));
				CLM.Clm_Esti_App_Tty().click();
				rb.delay(2000);

				Alert alert2 = driver.switchTo().alert();
				String alertText2 = alert2.getText();
				System.out.println("Treaty Approve text: " + alertText2);
				acceptAlert(); // alert2.accept();
				System.out.println("Treaty got approved successfully");

				if (coin_share.equals("No")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_Coins()));
					CLM.Claims_Estimate_Approve_Coins().click();
					rb.delay(2000);

					Alert alert3 = driver.switchTo().alert();
					String alertText3 = alert3.getText();
					System.out.println("Treaty Approve text: " + alertText3);
					acceptAlert(); // alert2.accept();
					System.out.println("Treaty got approved successfully");
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_RI_Page_Close()));
				CLM.Clm_Esti_RI_Page_Close().click();

				rb.delay(5000);
				scrollUpJavaSc(uwp.userNameField());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().click();

				// original user id to be handled
				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(USER);

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(Password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
				GSP.Claim_Number_Feild().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
				GSP.Claim_Search_button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
				GSP.Claim_GoTo().click();

			}
		} catch (Exception e) {
		}

//Settlement section.
		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(2000);
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement()));
		CLM.Clm_Settlement().click();
		scrollDownJavaSc(CLM.Clm_Settlement());

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Payamt1()));
		CLM.Clm_Setl_Payamt1().clear();
		CLM.Clm_Setl_Payamt1().sendKeys("265", Keys.TAB);

		rb.delay(20000);
		if (Settle_MOPay.equals("SEPA")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Payment()));
			CLM.Clm_SEPA_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Bank_AC()));
			Select select = new Select(CLM.Clm_SEPA_Bank_AC());
			List<WebElement> options = select.getOptions();

			boolean allNullOrSelect = true;

			for (WebElement option : options) {
				String optionText = option.getText().trim();
				if (!optionText.equals("select") && !optionText.contains("NULL")) {
					allNullOrSelect = false;
					break; // If we find a valid value, break the loop
				}
			}

			if (allNullOrSelect) {
				// Perform action if the dropdown contains only 'select' or 'NULL' values
				System.out.println("Accounting field contains only 'select' or 'NULL'. Performing other action.");

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Edit_Assured()));
				CLM.Clm_Edit_Assured().click();

				// Add your custom code here for handling this case
				// For example, showing another field, disabling it, etc.
			} else {
				// If valid values are present, select a value from the dropdown
				String valueToSelect = "SomeValue"; // Replace with the value you want to select
				select.selectByIndex(1); // You can also use selectByValue() or selectByIndex() if needed
				// System.out.println("Selected value: " + valueToSelect);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_ACNO()));
			CLM.Clm_SEPA_Payment().click();
			String ClmSEPA_ACNO = getAtrributeValue(CLM.Clm_SEPA_ACNO(), "value");
			// if (CLM.Clm_SEPA_ACNO() == null) {
			CLM.Clm_SEPA_ACNO().sendKeys(SEPA_ACNO);
			System.out.println("SEPA account number: " + SEPA_ACNO);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_SwiftCode()));
			CLM.Clm_SEPA_SwiftCode().click();
			String ClmSEPA_Swiftcode = getAtrributeValue(CLM.Clm_SEPA_SwiftCode(), "value");
			// if (CLM.Clm_SEPA_SwiftCode() == null) {
			CLM.Clm_SEPA_SwiftCode().sendKeys(SEPA_Swift_Code);
			System.out.println("SEPA swift code: " + SEPA_Swift_Code);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_IBAN()));
			CLM.Clm_SEPA_IBAN().click();
			String ClmSEPA_IBAN = getAtrributeValue(CLM.Clm_SEPA_IBAN(), "value");
			// if (CLM.Clm_SEPA_IBAN() == null) {
			CLM.Clm_SEPA_IBAN().sendKeys(SEPA_IABN);
			System.out.println("Claims SEPA IBAN: " + SEPA_IABN);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Bankname()));
			CLM.Clm_SEPA_Bankname().click();
			String Clm_SEPABANK = getAtrributeValue(CLM.Clm_SEPA_Bankname(), "value");
			// if (CLM.Clm_SEPA_Bankname() == null) {
			CLM.Clm_SEPA_Bankname().sendKeys(SEPA_BankName);
			System.out.println("claims SEPA bankname: " + SEPA_BankName);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_EmailID()));
			CLM.Clm_SEPA_EmailID().click();
			String Clm_Sepa_EMAIL_ID = getAtrributeValue(CLM.Clm_SEPA_EmailID(), "value");
			// if (CLM.Clm_SEPA_EmailID() == null) {
			CLM.Clm_SEPA_EmailID().sendKeys(SEPA_EMAILID);
			System.out.println("Claims SEPA Email ID: " + SEPA_EMAILID);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_BICcode()));
			CLM.Clm_SEPA_BICcode().click();
			String Clm_SEPABIC = getAtrributeValue(CLM.Clm_SEPA_BICcode(), "value");
			// if (CLM.Clm_SEPA_BICcode() == null) {
			CLM.Clm_SEPA_BICcode().sendKeys(SEPA_BICcode);
			System.out.println("claims SEPA BIC Code: " + SEPA_BICcode);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_MbNo()));
			CLM.Clm_SEPA_MbNo().click();
			String Clm_SEPAMBNO = getAtrributeValue(CLM.Clm_SEPA_MbNo(), "value");
			// if (CLM.Clm_SEPA_MbNo() == null) {
			CLM.Clm_SEPA_MbNo().sendKeys(SEPA_MobileNO);
			System.out.println("Claims SEPA mobile no: " + SEPA_MobileNO);
			// } else {

		} else if (Settle_MOPay.equals("Credit") || Settle_MOPay.equals("Debit")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Credit_Payment()));
			CLM.Clm_Credit_Payment().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setle_InsBilling()));
			rb.delay(2000);
			selectByIndex(CLM.Clm_Setle_InsBilling(), 1);

		} else if (Settle_MOPay.equals("Cheque")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payment()));
			CLM.Clm_Cheque_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payee_Name()));
			String Clm_PayeeName = getAtrributeValue(CLM.Clm_Cheque_Payee_Name(), "Value");
			System.out.println("claims cheque payee name: " + Clm_PayeeName);
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement_Remarks()));
		CLM.Clm_Settlement_Remarks().sendKeys("Settlement");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Save()));
		CLM.Clm_Setl_Save().click();

		if (Clm_Subrogation.equals("Yes")) {

			rb.delay(10000);
			scrollUpJavaSc(CLM.Clm_Subrogation_Checkbox());
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation_Checkbox()));
			CLM.Clm_Subrogation_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation()));
			CLM.Clm_Subrogation().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_printCheckbox()));
			CLM.Clm_Subro_printCheckbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Print()));
			CLM.Clm_Subro_Print().click();

			Set<String> windows = driver.getWindowHandles();
			String parentWindowHandler = driver.getWindowHandle();
			for (String handle : windows) {
				driver.switchTo().window(handle);

				if (!(handle.equals(parentWindowHandler))) {
					System.out.println(driver.getTitle());
					// driver.close();
				}
			}
			driver.switchTo().window(parentWindowHandler);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_PrintHistory()));
			CLM.Clm_Subro_PrintHistory().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Mail()));
			CLM.Clm_Subro_Mail().click();

			scrollDownJavaSc(CLM.Clm_Subro_Mail());
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailTO()));
			CLM.Clm_Subro_MailTO().sendKeys("puneeth.madhraju@anoudtechnologies.com");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailCC()));
			CLM.Clm_Subro_MailCC().sendKeys("anilkumar.ustlamuri@anoudtechnologies.com");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_FetchTemplate()));
			CLM.Clm_Subro_FetchTemplate().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_ChooseTemplate()));
			selectByIndex(CLM.Clm_Subro_ChooseTemplate(), 1);

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Apply_Template()));
			CLM.Clm_Subro_Apply_Template().click();

			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailSubject()));
			CLM.Clm_Subro_MailSubject().sendKeys("Subrogation sent from: " + Clm_No);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Send_Email()));
			CLM.Clm_Subro_Send_Email().click();

			rb.delay(10000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Documents()));
			CLM.Clm_Subro_Documents().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Doclist()));
			selectByVisibleText(CLM.Clm_Subro_Doclist(), "SUBROGATION FORM RECEIVED");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.upload_File()));
			CLM.upload_File().click();
			upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
			rb.delay(5000);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			rb.delay(10000);

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Close()));
			CLM.Clm_Subro_Close().click();
		}

		rb.delay(3000);
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_setlGrid1()));
//		CLM.Clm_setlGrid1().click();
//		rb.delay(3000);

		scrollUpJavaSc(CLM.Clm_Settlement());
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement_Select_CheckBox()));
		CLM.Clm_Settlement_Select_CheckBox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Approve()));
		CLM.Clm_Setl_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement_WF_msg()));
		String text = CLM.Clm_Settlement_WF_msg().getText();
		System.out.println("Claims 1st level settlement approval msg: " + text);
		String Clm_Set_WF_refNo1 = extractWorkflowReference(text);
		System.out.println("Workflow Reference Number: " + Clm_Set_WF_refNo1);

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Set_WF_refNo1 + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");
		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
		LP.username_Field().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Thread.sleep(5000);
		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Set_WF_refNo1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setl_2WF_Msg()));
		String Clm_Setl_2ndWFmsg = CLM.Clm_Setl_2WF_Msg().getText();
		System.out.println("Claim settlement second level approve msg: " + Clm_Setl_2ndWFmsg);
		String Clm_Setl_2refno = extractWorkflowReference(Clm_Setl_2ndWFmsg);
		System.out.println("Claim settlement second level WF refno: " + Clm_Setl_2refno);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Setl_2refno + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");

		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Setl_2refno);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(USER);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
		GSP.Claim_Number_Feild().sendKeys(Clm_No);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
		GSP.Claim_Search_button().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
		GSP.Claim_GoTo().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Status()));
		Clm_Status = CLM.Claim_Status().getText();
		System.out.println("Claims status: " + Clm_Status);

		if (Clm_Status.equals("WithDrawn") || Clm_Status.equals("Settled") || Clm_Status.equals("Rejected")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_ReOpen()));
			CLM.Clm_ReOpen().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Reason_WSC()));
			selectByIndex(CLM.Reason_WSC(), 1);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Remarks()));
			CLM.Clm_Remarks().sendKeys("Test");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_ReOpen_Save()));
			CLM.Clm_ReOpen_Save().click();
		}

//
		System.out.println("Adding an Secondary ESTIMATE");
		scrollDownJavaSc(CLM.Clm_Risk_Add());
		rb.delay(2500);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Add()));
		CLM.Clm_Esti_Add().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_SMI()));
		selectByIndex(CLM.Clm_Esti_SMI(), 1);

		if (Clm_BS.contains("with Elmo Leader")) {

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Coin_100share()));
			CLM.Clm_Esti_Coin_100share().click();

		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Type()));
		selectByVisibleText(CLM.Clm_Esti_Type(), "Payment"); // Recovery,Reversal of Payment,Reversal of Recovery
		System.out.println("Payment");

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Code()));
		selectByIndex(CLM.Clm_Esti_Code(), 2);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_PayAmount()));
		CLM.Clm_Esti_PayAmount().sendKeys("8000", Keys.TAB);
		System.out.println("2nd estimate amount = 8000");

		if (Deductible.equals("Yes")) {

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Deductible_Checkbox()));
			CLM.Deductible_Checkbox().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Deductible_1CheckBox()));
			CLM.Deductible_1CheckBox().click();
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Liability()));
		selectByIndex(CLM.Clm_Esti_Liability(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
		CLM.Clm_Risk_Save().click();

		try {
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_OurSI_Exceed_Msg()));
			String text2 = CLM.Clm_OurSI_Exceed_Msg().getText();
			System.out.println("Claims Our SI limit validation msg: " + text2);
			String Our_SI_Limit = text2.replaceAll("[^0-9]", "");
			System.out.println("Claims our si limit amount: " + Our_SI_Limit);

			if (OurSI_Exceed.equals("Yes")) {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Exceed_Confirmation()));
				CLM.Clm_Our_Exceed_Confirmation().click();
			} else {
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Our_Exceed_Close()));
				CLM.Clm_Our_Exceed_Close().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Estimate_Amount()));
				int a = Integer.parseInt(Our_SI_Limit);
				int result = a - 20;
				String SIvalue = String.valueOf(result);
				CLM.Clm_Risk_Estimate_Amount().sendKeys(SIvalue, Keys.TAB);
				System.out.println("claims our si limit: " + SIvalue);
			}

			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
			CLM.Clm_Risk_Save().click();

		} catch (Exception e) {
		}

		try {
			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Esti_WF_Msg()));
			String Estimate_WF = CLM.Clm_Esti_WF_Msg().getText();
			System.out.println("Estimate WF Msg: " + Estimate_WF);
			Pattern pattern = Pattern.compile("sent to ([\\w\\s]+) for the amount.*Workflow Reference No (\\d+)");
			Matcher matcher = pattern.matcher(Estimate_WF);

			boolean found = false;

			while (matcher.find()) {
				found = true;
				Esti_WF_User = matcher.group(1).trim();
				Esti_RefNo = matcher.group(2);

				System.out.println("User: " + Esti_WF_User);
				System.out.println("Reference No: " + Esti_RefNo);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
					+ Esti_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
			App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
			WF_Description = get_DB_Data(username_Query, "WF_DESC");

			password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
					+ "') USER_PASSWORD FROM DUAL";
			App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().sendKeys(App_User);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
			LP.password_Field().sendKeys(App_Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
			CLM.Clm_Myactions_Tab().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
			CLM.Clm_Myactionstab_Search().sendKeys(Esti_RefNo);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
			CLM.Clm_Approver_Viewoption().click();

			rb.delay(20000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
			CLM.Clm_Approve_Remarks().sendKeys("test");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
			CLM.Clm_WF_Approve().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_WF_msg()));
			CLM.Clm_WF_msg().getText();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

//			String userQuery = "select user_id from m_user where user_name='" + Login_User + "' and rownum=1";
//			USER = get_DB_Data(userQuery, "user_id");
//			String PasswordQuery = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + USER
//					+ "') USER_PASSWORD FROM DUAL";
//			Password = get_DB_Data(PasswordQuery, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().click();

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(USER);

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			// global search for the claim
			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
			GSP.Claim_Number_Feild().sendKeys(Clm_No);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
			GSP.Claim_Search_button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
			GSP.Claim_GoTo().click();

		} catch (Exception e) {
		}

		try {

			if (Clm_FAC_Act.equals("FAC is Applicable")) {

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().sendKeys("juans");

				String password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD('juans') USER_PASSWORD FROM DUAL";
				String password = get_DB_Data(password_Query, "USER_PASSWORD");

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
				LP.password_Field().sendKeys(password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(5000);
				Login_User = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + Login_User);

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
				uwp.menu_Button().click();
				rb.delay(2000);

				scrollDownJavaSc(uwp.Reinsurance_Menu());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Reinsurance_Menu()));
				uwp.Reinsurance_Menu().click();
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.RI_Allocation()));
				uwp.RI_Allocation().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No()));
				CLM.RI_Allocation_Claim_No().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No_Search()));
				CLM.RI_Allocation_Claim_No_Search().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1stRiskinfo_Grid()));
				CLM.Clm_1stRiskinfo_Grid().click();

				// need to change the Estimate srno
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_2nd_Estimate()));
				CLM.Clm_2nd_Estimate().click();

				scrollUpJavaSc(CLM.Clm_Estimate_R1());
				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Estimate_RI()));
				CLM.Claim_Estimate_RI().click();

				rb.delay(15000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_FAC()));
				CLM.Claims_Estimate_Approve_FAC().click();

				// need to handle the switch alert
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("FAC approve text: " + alertText);
				rb.delay(3000);
				alert.accept();
				System.out.println("FAC got approved successfully");

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_App_Tty()));
				CLM.Clm_Esti_App_Tty().click();
				rb.delay(2000);

				Alert alert2 = driver.switchTo().alert();
				String alertText2 = alert.getText();
				System.out.println("Treaty Approve text: " + alertText2);
				alert2.accept();
				System.out.println("Treaty got approved successfully");

				if (coin_share.equals("No")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_Coins()));
					CLM.Claims_Estimate_Approve_Coins().click();
					rb.delay(2000);

					Alert alert3 = driver.switchTo().alert();
					String alertText3 = alert3.getText();
					System.out.println("Treaty Approve text: " + alertText3);
					acceptAlert(); // alert2.accept();
					System.out.println("Treaty got approved successfully");
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_RI_Page_Close()));
				CLM.Clm_Esti_RI_Page_Close().click();

				rb.delay(5000);
				scrollUpJavaSc(uwp.userNameField());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().click();

				// original user id to be handled
				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(USER);

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(Password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
				GSP.Claim_Number_Feild().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
				GSP.Claim_Search_button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
				GSP.Claim_GoTo().click();
			}

		} catch (Exception e) {
		}

		// 2nd Settlement
		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(2000);
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement()));
		CLM.Clm_Settlement().click();
		scrollDownJavaSc(CLM.Clm_Settlement());

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Payamt2()));
		CLM.Clm_Setl_Payamt2().click();
		rb.delay(3000);
		CLM.Clm_Setl_Payamt2().clear();
		CLM.Clm_Setl_Payamt2().sendKeys("50", Keys.TAB);

		if (Settle_MOPay.equals("SEPA")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Payment()));
			CLM.Clm_SEPA_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Payment()));
			CLM.Clm_SEPA_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Bank_AC()));
			Select select = new Select(CLM.Clm_SEPA_Bank_AC());
			List<WebElement> options = select.getOptions();

			boolean allNullOrSelect = true;

			for (WebElement option : options) {
				String optionText = option.getText().trim();
				if (!optionText.equals("select") && !optionText.contains("NULL")) {
					allNullOrSelect = false;
					break; // If we find a valid value, break the loop
				}
			}

			if (allNullOrSelect) {
				// Perform action if the dropdown contains only 'select' or 'NULL' values
				System.out.println("Accounting field contains only 'select' or 'NULL'. Performing other action.");

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Edit_Assured()));
				CLM.Clm_Edit_Assured().click();

				// Add your custom code here for handling this case
				// For example, showing another field, disabling it, etc.
			} else {
				// If valid values are present, select a value from the dropdown
				String valueToSelect = "SomeValue"; // Replace with the value you want to select
				select.selectByIndex(1); // You can also use selectByValue() or selectByIndex() if needed
				// System.out.println("Selected value: " + valueToSelect);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_ACNO()));
			CLM.Clm_SEPA_Payment().click();
			String ClmSEPA_ACNO = getAtrributeValue(CLM.Clm_SEPA_ACNO(), "value");
			// if (CLM.Clm_SEPA_ACNO() == null) {
			CLM.Clm_SEPA_ACNO().sendKeys(SEPA_ACNO);
			System.out.println("SEPA account number: " + SEPA_ACNO);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_SwiftCode()));
			CLM.Clm_SEPA_SwiftCode().click();
			String ClmSEPA_Swiftcode = getAtrributeValue(CLM.Clm_SEPA_SwiftCode(), "value");
			// if (CLM.Clm_SEPA_SwiftCode() == null) {
			CLM.Clm_SEPA_SwiftCode().sendKeys(SEPA_Swift_Code);
			System.out.println("SEPA swift code: " + SEPA_Swift_Code);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_IBAN()));
			CLM.Clm_SEPA_IBAN().click();
			String ClmSEPA_IBAN = getAtrributeValue(CLM.Clm_SEPA_IBAN(), "value");
			// if (CLM.Clm_SEPA_IBAN() == null) {
			CLM.Clm_SEPA_IBAN().sendKeys(SEPA_IABN);
			System.out.println("Claims SEPA IBAN: " + SEPA_IABN);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Bankname()));
			CLM.Clm_SEPA_Bankname().click();
			String Clm_SEPABANK = getAtrributeValue(CLM.Clm_SEPA_Bankname(), "value");
			// if (CLM.Clm_SEPA_Bankname() == null) {
			CLM.Clm_SEPA_Bankname().sendKeys(SEPA_BankName);
			System.out.println("claims SEPA bankname: " + SEPA_BankName);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_EmailID()));
			CLM.Clm_SEPA_EmailID().click();
			String Clm_Sepa_EMAIL_ID = getAtrributeValue(CLM.Clm_SEPA_EmailID(), "value");
			// if (CLM.Clm_SEPA_EmailID() == null) {
			CLM.Clm_SEPA_EmailID().sendKeys(SEPA_EMAILID);
			System.out.println("Claims SEPA Email ID: " + SEPA_EMAILID);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_BICcode()));
			CLM.Clm_SEPA_BICcode().click();
			String Clm_SEPABIC = getAtrributeValue(CLM.Clm_SEPA_BICcode(), "value");
			// if (CLM.Clm_SEPA_BICcode() == null) {
			CLM.Clm_SEPA_BICcode().sendKeys(SEPA_BICcode);
			System.out.println("claims SEPA BIC Code: " + SEPA_BICcode);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_MbNo()));
			CLM.Clm_SEPA_MbNo().click();
			String Clm_SEPAMBNO = getAtrributeValue(CLM.Clm_SEPA_MbNo(), "value");
			// if (CLM.Clm_SEPA_MbNo() == null) {
			CLM.Clm_SEPA_MbNo().sendKeys(SEPA_MobileNO);
			System.out.println("Claims SEPA mobile no: " + SEPA_MobileNO);
			// } else {

		} else if (Settle_MOPay.equals("Credit") || Settle_MOPay.equals("Debit")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Credit_Payment()));
			CLM.Clm_Credit_Payment().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setle_InsBilling()));
			rb.delay(2000);
			selectByIndex(CLM.Clm_Setle_InsBilling(), 1);

		} else if (Settle_MOPay.equals("Cheque")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payment()));
			CLM.Clm_Cheque_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payee_Name()));
			String Clm_PayeeName = getAtrributeValue(CLM.Clm_Cheque_Payee_Name(), "Value");
			System.out.println("claims cheque payee name: " + Clm_PayeeName);
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement_Remarks()));
		CLM.Clm_Settlement_Remarks().sendKeys("Settlement");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Save()));
		CLM.Clm_Setl_Save().click();

//		if (Clm_Subrogation.equals("Yes")) {
//
//			rb.delay(10000);
//			scrollUpJavaSc(CLM.Clm_Subrogation_Checkbox());
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation_Checkbox2()));
//			CLM.Clm_Subrogation_Checkbox2().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation()));
//			CLM.Clm_Subrogation().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_printCheckbox()));
//			CLM.Clm_Subro_printCheckbox().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Print()));
//			CLM.Clm_Subro_Print().click();
//
//			Set<String> windows = driver.getWindowHandles();
//			String parentWindowHandler = driver.getWindowHandle();
//			for (String handle : windows) {
//				driver.switchTo().window(handle);
//
//				if (!(handle.equals(parentWindowHandler))) {
//					System.out.println(driver.getTitle());
//					// driver.close();
//				}
//			}
//			driver.switchTo().window(parentWindowHandler);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_PrintHistory()));
//			CLM.Clm_Subro_PrintHistory().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Mail()));
//			CLM.Clm_Subro_Mail().click();
//
//			scrollDownJavaSc(CLM.Clm_Subro_Mail());
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailTO()));
//			CLM.Clm_Subro_MailTO().sendKeys("puneeth.madhiraju@anoudtechnologies.com");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailCC()));
//			CLM.Clm_Subro_MailCC().sendKeys("anilkumar.ustlamuri@anoudtechnologies.com");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_FetchTemplate()));
//			CLM.Clm_Subro_FetchTemplate().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_ChooseTemplate()));
//			selectByIndex(CLM.Clm_Subro_ChooseTemplate(), 1);
//
//			rb.delay(2000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Apply_Template()));
//			CLM.Clm_Subro_Apply_Template().click();
//
//			rb.delay(2000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailSubject()));
//			CLM.Clm_Subro_MailSubject().sendKeys("Subrogation sent from: " + Clm_No);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Send_Email()));
//			CLM.Clm_Subro_Send_Email().click();
//
//			rb.delay(10000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Documents()));
//			CLM.Clm_Subro_Documents().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Doclist()));
//			selectByVisibleText(CLM.Clm_Subro_Doclist(), "SUBROGATION FORM RECEIVED");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.upload_File()));
//			CLM.upload_File().click();
//			upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
//			rb.delay(5000);
//
//			rb.keyPress(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_V);
//
//			rb.keyRelease(KeyEvent.VK_CONTROL);
//			rb.keyRelease(KeyEvent.VK_V);
//
//			rb.keyPress(KeyEvent.VK_ENTER);
//			rb.keyRelease(KeyEvent.VK_ENTER);
//			rb.delay(10000);
//
//			rb.delay(3000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Close()));
//			CLM.Clm_Subro_Close().click();
//
//		}

		rb.delay(5000);

		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Payamt2_SelectBox()));
		javaScribtClick(CLM.Clm_Setl_Payamt2_SelectBox());

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Approve()));
		CLM.Clm_Setl_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement_WF_msg()));
		String text1 = CLM.Clm_Settlement_WF_msg().getText();
		System.out.println("Claims 1st level settlement approval msg: " + text1);
		String Clm_Set_WF_refNo11 = extractWorkflowReference(text1);
		System.out.println("Workflow Reference Number: " + Clm_Set_WF_refNo11);

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Set_WF_refNo11 + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");
		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
		LP.username_Field().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Thread.sleep(5000);
		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Set_WF_refNo11);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setl_2WF_Msg()));
		String Clm_Setl_2ndWFmsg1 = CLM.Clm_Setl_2WF_Msg().getText();
		System.out.println("Claim settlement second level approve msg: " + Clm_Setl_2ndWFmsg1);
		String Clm_Setl_2refno1 = extractWorkflowReference(Clm_Setl_2ndWFmsg1);
		System.out.println("Claim settlement second level WF refno: " + Clm_Setl_2refno1);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Setl_2refno1 + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");

		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Setl_2refno1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(USER);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
		GSP.Claim_Number_Feild().sendKeys(Clm_No);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
		GSP.Claim_Search_button().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
		GSP.Claim_GoTo().click();

		try {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
			GSP.Claim_GoTo().click();
		} catch (Exception e) {
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Status()));
		Clm_Status = CLM.Claim_Status().getText();
		System.out.println("Claims status: " + Clm_Status);

		if (Clm_Status.equals("WithDrawn") || Clm_Status.equals("Settled") || Clm_Status.equals("Rejected")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_ReOpen()));
			CLM.Clm_ReOpen().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Reason_WSC()));
			selectByIndex(CLM.Reason_WSC(), 1);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Remarks()));
			CLM.Clm_Remarks().sendKeys("Test");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_ReOpen_Save()));
			CLM.Clm_ReOpen_Save().click();
		}

//Recovery Payment.
		System.out.println("Recovery ESTIMATE");
		scrollDownJavaSc(CLM.Clm_Risk_Add());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Add()));
		CLM.Clm_Esti_Add().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_SMI()));
		selectByIndex(CLM.Clm_Esti_SMI(), 1);

		if (Clm_BS.contains("with Elmo Leader")) {
			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Coin_100share()));
			CLM.Clm_Esti_Coin_100share().click();
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Type()));
		selectByVisibleText(CLM.Clm_Esti_Type(), "Recovery"); // Recovery,Reversal of Payment,Reversal of Recovery
		System.out.println("Recovery");

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Code()));
		selectByIndex(CLM.Clm_Esti_Code(), 2);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_RecAmount()));
		CLM.Clm_Esti_RecAmount().sendKeys("500", Keys.TAB);
		System.out.println("3rd Recovery Estimate amount =500");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Liability()));
		selectByIndex(CLM.Clm_Esti_Liability(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Risk_Save()));
		CLM.Clm_Risk_Save().click();

		try {

			if (Clm_FAC_Act.equals("FAC is Applicable")) {

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().sendKeys("juans");

				String password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD('juans') USER_PASSWORD FROM DUAL";
				String password = get_DB_Data(password_Query, "USER_PASSWORD");

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
				LP.password_Field().sendKeys(password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(5000);
				Login_User = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + Login_User);

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
				uwp.menu_Button().click();
				rb.delay(2000);

				scrollDownJavaSc(uwp.Reinsurance_Menu());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Reinsurance_Menu()));
				uwp.Reinsurance_Menu().click();
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.RI_Allocation()));
				uwp.RI_Allocation().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No()));
				CLM.RI_Allocation_Claim_No().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No_Search()));
				CLM.RI_Allocation_Claim_No_Search().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1stRiskinfo_Grid()));
				CLM.Clm_1stRiskinfo_Grid().click();

				scrollDownJavaSc(CLM.Clm_3rd_Estimate());
				rb.delay(5000);// need to change the Estimate srno
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_3rd_Estimate()));
				CLM.Clm_3rd_Estimate().click();

				scrollUpJavaSc(CLM.Clm_Estimate_R1());
				rb.delay(15000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Estimate_RI()));
				CLM.Claim_Estimate_RI().click();

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_FAC()));
				CLM.Claims_Estimate_Approve_FAC().click();

				// need to handle the switch alert
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("FAC approve text: " + alertText);
				rb.delay(3000);
				alert.accept();
				System.out.println("FAC got approved successfully");

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_App_Tty()));
				CLM.Clm_Esti_App_Tty().click();
				rb.delay(2000);

				Alert alert2 = driver.switchTo().alert();
				String alertText2 = alert.getText();
				System.out.println("Treaty Approve text: " + alertText2);
				alert2.accept();
				System.out.println("Treaty got approved successfully");

				if (coin_share.equals("No")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_Coins()));
					CLM.Claims_Estimate_Approve_Coins().click();
					rb.delay(2000);

					Alert alert3 = driver.switchTo().alert();
					String alertText3 = alert3.getText();
					System.out.println("Treaty Approve text: " + alertText3);
					acceptAlert(); // alert2.accept();
					System.out.println("Treaty got approved successfully");
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_RI_Page_Close()));
				CLM.Clm_Esti_RI_Page_Close().click();
			}

		} catch (Exception e) {

		}

//		rb.delay(5000);
//		scrollUpJavaSc(uwp.userNameField());
//		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
//		uwp.userNameField().click();
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
//		uwp.User_logout().click();
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
//		LP.username_Field().click();
//
//		// original user id to be handled
//		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
//		LP.username_Field().sendKeys(USER);
//
//		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
//		LP.password_Field().sendKeys(Password);
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
//		LP.login_Button().click();
//
//		rb.delay(2000);
//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
//		GSP.global_Search_Button().click();
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
//		GSP.Claim_Number_Feild().sendKeys(Clm_No);
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
//		GSP.Claim_Search_button().click();
//
//		rb.delay(3000);
//		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
//		GSP.Claim_GoTo().click();

//		try {
//
//			rb.delay(2000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
//			GSP.Claim_GoTo().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
//			GSP.Claim_GoTo().click();
//
//		} catch (Exception e) {
//		}

		// 3rd Settlement
		rb.delay(2000);
		scrollDownJavaSc(CLM.Clm_Settlement());
		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement()));
		CLM.Clm_Settlement().click();
		scrollDownJavaSc(CLM.Clm_Settlement());

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Recamt()));
		CLM.Clm_Setl_Recamt().click();
		rb.delay(3000);
		CLM.Clm_Setl_Recamt().clear();
		CLM.Clm_Setl_Recamt().sendKeys("150", Keys.TAB);

		if (Rec_Settle_MOPay.equals("Debit")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Debit_Payment()));
			CLM.Clm_Debit_Payment().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setle_InsBilling()));
			rb.delay(2000);
			selectByIndex(CLM.Clm_Setle_InsBilling(), 1);

		} else if (Rec_Settle_MOPay.equals("Receipt")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Receipt_payment()));
			CLM.Clm_Receipt_payment().click();

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
			selectByVisibleText(ra.cash_Type_Dropdown(), Rec_Cash_Type);

			if (Rec_Cash_Type.equals("CHEQUE")) {
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
				ra.amount_Field().sendKeys("150");
			} else if (Rec_Cash_Type.equals("CASH")) {
				// Enter Amount
				webDriverWait(ExpectedConditions.visibilityOf(ra.amount_Field()));
				ra.amount_Field().sendKeys("150");
			}

			// Save the details
			webDriverWait(ExpectedConditions.elementToBeClickable(ra.save_Cash_Analysis()));
			ra.save_Cash_Analysis().click();

		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement_Remarks()));
		CLM.Clm_Settlement_Remarks().sendKeys("Settlement");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Save()));
		CLM.Clm_Setl_Save().click();

		rb.delay(5000);
// clm settlment approval
		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_setl_Recamt_SelectBox()));
		CLM.Clm_setl_Recamt_SelectBox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Approve()));
		CLM.Clm_Setl_Approve().click();

		scrollUpJavaSc(CLM.Clm_WithDraw_Settlement());
		rb.delay(5000);
		System.out.println("Claims status: " + Clm_Status);

//Revise the Estimate
		System.out.println("Rivising the existing ESTIMATE");
		scrollDownJavaSc(CLM.Clm_Esti_Add());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_2Esti_Revision()));
		CLM.Clm_2Esti_Revision().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Revise_Payment()));
		CLM.Clm_Revise_Payment().sendKeys("9000");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Revise_Reason()));
		selectByIndex(CLM.Clm_Revise_Reason(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Revise_Save()));
		CLM.Clm_Revise_Save().click();

		try {
			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Esti_WF_Msg()));
			String Estimate_WF = CLM.Clm_Esti_WF_Msg().getText();
			System.out.println("Estimate WF Msg: " + Estimate_WF);
			Pattern pattern = Pattern.compile("sent to ([\\w\\s]+) for the amount.*Workflow Reference No (\\d+)");
			Matcher matcher = pattern.matcher(Estimate_WF);

			boolean found = false;

			while (matcher.find()) {
				found = true;
				Esti_WF_User = matcher.group(1).trim();
				Esti_RefNo = matcher.group(2);

				System.out.println("User: " + Esti_WF_User);
				System.out.println("Reference No: " + Esti_RefNo);
			}

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

			username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
					+ Esti_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
			App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
			WF_Description = get_DB_Data(username_Query, "WF_DESC");

			password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User
					+ "') USER_PASSWORD FROM DUAL";
			App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().sendKeys(App_User);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
			LP.password_Field().sendKeys(App_Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
			CLM.Clm_Myactions_Tab().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
			CLM.Clm_Myactionstab_Search().sendKeys(Esti_RefNo);

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
			CLM.Clm_Approver_Viewoption().click();

			rb.delay(20000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
			CLM.Clm_Approve_Remarks().sendKeys("test");

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
			CLM.Clm_WF_Approve().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_WF_msg()));
			CLM.Clm_WF_msg().getText();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
			uwp.userNameField().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
			uwp.User_logout().click();

//			String userQuery = "select user_id from m_user where user_name='" + Login_User + "' and rownum=1";
//			USER = get_DB_Data(userQuery, "user_id");
//			String PasswordQuery = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + USER
//					+ "') USER_PASSWORD FROM DUAL";
//			Password = get_DB_Data(PasswordQuery, "USER_PASSWORD");

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
			LP.username_Field().click();

			webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
			LP.username_Field().sendKeys(USER);

			webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
			LP.password_Field().sendKeys(Password);

			webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
			LP.login_Button().click();

			// global search for the claim
			rb.delay(2000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
			GSP.Claim_Number_Feild().sendKeys(Clm_No);

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
			GSP.Claim_Search_button().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
			GSP.Claim_GoTo().click();

		} catch (Exception e) {
		}

		try {

			if (Clm_FAC_Act.equals("FAC is Applicable")) {

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().sendKeys("juans");

				String password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD('juans') USER_PASSWORD FROM DUAL";
				String password = get_DB_Data(password_Query, "USER_PASSWORD");

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.password_Field()));
				LP.password_Field().sendKeys(password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(5000);
				Login_User = LP.User_Profile_Name().getText();
				System.out.println("User Profile Name is: " + Login_User);

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.menu_Button()));
				uwp.menu_Button().click();
				rb.delay(2000);

				scrollDownJavaSc(uwp.Reinsurance_Menu());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.Reinsurance_Menu()));
				uwp.Reinsurance_Menu().click();
				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.RI_Allocation()));
				uwp.RI_Allocation().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No()));
				CLM.RI_Allocation_Claim_No().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.RI_Allocation_Claim_No_Search()));
				CLM.RI_Allocation_Claim_No_Search().click();

				rb.delay(10000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1stRiskinfo_Grid()));
				CLM.Clm_1stRiskinfo_Grid().click();

				// need to change the Estimate srno
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_2nd_Estimate()));
				CLM.Clm_2nd_Estimate().click();

				scrollUpJavaSc(CLM.Clm_Estimate_R1());
				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Estimate_RI()));
				CLM.Claim_Estimate_RI().click();

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_FAC()));
				CLM.Claims_Estimate_Approve_FAC().click();

				// need to handle the switch alert
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("FAC approve text: " + alertText);
				rb.delay(3000);
				alert.accept();
				System.out.println("FAC got approved successfully");

				rb.delay(5000);
				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_App_Tty()));
				CLM.Clm_Esti_App_Tty().click();
				rb.delay(2000);

				Alert alert2 = driver.switchTo().alert();
				String alertText2 = alert.getText();
				System.out.println("Treaty Approve text: " + alertText2);
				alert2.accept();
				System.out.println("Treaty got approved successfully");

				if (coin_share.equals("No")) {

					webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claims_Estimate_Approve_Coins()));
					CLM.Claims_Estimate_Approve_Coins().click();
					rb.delay(2000);

					Alert alert3 = driver.switchTo().alert();
					String alertText3 = alert3.getText();
					System.out.println("Treaty Approve text: " + alertText3);
					acceptAlert(); // alert2.accept();
					System.out.println("Treaty got approved successfully");
				}

				webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_RI_Page_Close()));
				CLM.Clm_Esti_RI_Page_Close().click();

				rb.delay(5000);
				scrollUpJavaSc(uwp.userNameField());
				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
				uwp.userNameField().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
				uwp.User_logout().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
				LP.username_Field().click();

				// original user id to be handled
				webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
				LP.username_Field().sendKeys(USER);

				webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
				LP.password_Field().sendKeys(Password);

				webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
				LP.login_Button().click();

				rb.delay(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
				GSP.global_Search_Button().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
				GSP.Claim_Number_Feild().sendKeys(Clm_No);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
				GSP.Claim_Search_button().click();

				rb.delay(3000);
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
				GSP.Claim_GoTo().click();
			}

		} catch (Exception e) {
		}

// Revise settlement	
		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement()));
		CLM.Clm_Settlement().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Revise_Setl()));
		CLM.Clm_Revise_Setl().click();
		CLM.Clm_Revise_Setl().clear();
		rb.delay(3000);
		CLM.Clm_Revise_Setl().sendKeys("200");

		if (Revise_MOP.equals("SEPA")) {
			scrollDownJavaSc(CLM.Clm_SEPA_Payment());
			rb.delay(5000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Payment()));
			CLM.Clm_SEPA_Payment().click();

			rb.delay(3000);
			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_ACNO()));
			CLM.Clm_SEPA_Payment().click();
			String ClmSEPA_ACNO = getAtrributeValue(CLM.Clm_SEPA_ACNO(), "value");
			// if (CLM.Clm_SEPA_ACNO() == null) {
			CLM.Clm_SEPA_ACNO().sendKeys(SEPA_ACNO);
			System.out.println("SEPA account number: " + SEPA_ACNO);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_SwiftCode()));
			CLM.Clm_SEPA_SwiftCode().click();
			String ClmSEPA_Swiftcode = getAtrributeValue(CLM.Clm_SEPA_SwiftCode(), "value");
			// if (CLM.Clm_SEPA_SwiftCode() == null) {
			CLM.Clm_SEPA_SwiftCode().sendKeys(SEPA_Swift_Code);
			System.out.println("SEPA swift code: " + SEPA_Swift_Code);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_IBAN()));
			CLM.Clm_SEPA_IBAN().click();
			String ClmSEPA_IBAN = getAtrributeValue(CLM.Clm_SEPA_IBAN(), "value");
			// if (CLM.Clm_SEPA_IBAN() == null) {
			CLM.Clm_SEPA_IBAN().sendKeys(SEPA_IABN);
			System.out.println("Claims SEPA IBAN: " + SEPA_IABN);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_Bankname()));
			CLM.Clm_SEPA_Bankname().click();
			String Clm_SEPABANK = getAtrributeValue(CLM.Clm_SEPA_Bankname(), "value");
			// if (CLM.Clm_SEPA_Bankname() == null) {
			CLM.Clm_SEPA_Bankname().sendKeys(SEPA_BankName);
			System.out.println("claims SEPA bankname: " + SEPA_BankName);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_EmailID()));
			CLM.Clm_SEPA_EmailID().click();
			String Clm_Sepa_EMAIL_ID = getAtrributeValue(CLM.Clm_SEPA_EmailID(), "value");
			// if (CLM.Clm_SEPA_EmailID() == null) {
			CLM.Clm_SEPA_EmailID().sendKeys(SEPA_EMAILID);
			System.out.println("Claims SEPA Email ID: " + SEPA_EMAILID);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_BICcode()));
			CLM.Clm_SEPA_BICcode().click();
			String Clm_SEPABIC = getAtrributeValue(CLM.Clm_SEPA_BICcode(), "value");
			// if (CLM.Clm_SEPA_BICcode() == null) {
			CLM.Clm_SEPA_BICcode().sendKeys(SEPA_BICcode);
			System.out.println("claims SEPA BIC Code: " + SEPA_BICcode);
			// } else {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_SEPA_MbNo()));
			CLM.Clm_SEPA_MbNo().click();
			String Clm_SEPAMBNO = getAtrributeValue(CLM.Clm_SEPA_MbNo(), "value");
			// if (CLM.Clm_SEPA_MbNo() == null) {
			CLM.Clm_SEPA_MbNo().sendKeys(SEPA_MobileNO);
			System.out.println("Claims SEPA mobile no: " + SEPA_MobileNO);
			// } else {

		} else if (Revise_MOP.equals("Credit") || Revise_MOP.equals("Debit")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Credit_Payment()));
			CLM.Clm_Credit_Payment().click();

			webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setle_InsBilling()));
			rb.delay(2000);
			selectByIndex(CLM.Clm_Setle_InsBilling(), 1);

		} else if (Revise_MOP.equals("Cheque")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payment()));
			CLM.Clm_Cheque_Payment().click();

			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Cheque_Payee_Name()));
			String Clm_PayeeName = getAtrributeValue(CLM.Clm_Cheque_Payee_Name(), "Value");
			System.out.println("claims cheque payee name: " + Clm_PayeeName);
		}

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Settlement_Remarks()));
		CLM.Clm_Settlement_Remarks().sendKeys("Settlement");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Save()));
		CLM.Clm_Setl_Save().click();

//		if (Clm_Subrogation.equals("Yes")) {
//
//			rb.delay(10000);
//			scrollUpJavaSc(CLM.Clm_Subrogation_Checkbox());
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation_Checkbox()));
//			CLM.Clm_Subrogation_Checkbox().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subrogation()));
//			CLM.Clm_Subrogation().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_printCheckbox()));
//			CLM.Clm_Subro_printCheckbox().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Print()));
//			CLM.Clm_Subro_Print().click();
//
//			Set<String> windows = driver.getWindowHandles();
//			String parentWindowHandler = driver.getWindowHandle();
//			for (String handle : windows) {
//				driver.switchTo().window(handle);
//
//				if (!(handle.equals(parentWindowHandler))) {
//					System.out.println(driver.getTitle());
//					// driver.close();
//				}
//			}
//			driver.switchTo().window(parentWindowHandler);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_PrintHistory()));
//			CLM.Clm_Subro_PrintHistory().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Mail()));
//			CLM.Clm_Subro_Mail().click();
//
//			scrollDownJavaSc(CLM.Clm_Subro_Mail());
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailTO()));
//			CLM.Clm_Subro_MailTO().sendKeys("puneeth.madhiraju@anoudtechnologies.com");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailCC()));
//			CLM.Clm_Subro_MailCC().sendKeys("anilkumar.ustlamuri@anoudtechnologies.com");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_FetchTemplate()));
//			CLM.Clm_Subro_FetchTemplate().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_ChooseTemplate()));
//			selectByIndex(CLM.Clm_Subro_ChooseTemplate(), 1);
//
//			rb.delay(2000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Apply_Template()));
//			CLM.Clm_Subro_Apply_Template().click();
//
//			rb.delay(2000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_MailSubject()));
//			CLM.Clm_Subro_MailSubject().sendKeys("Subrogation sent from: " + Clm_No);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Send_Email()));
//			CLM.Clm_Subro_Send_Email().click();
//
//			rb.delay(10000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Documents()));
//			CLM.Clm_Subro_Documents().click();
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Doclist()));
//			selectByVisibleText(CLM.Clm_Subro_Doclist(), "SUBROGATION FORM RECEIVED");
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.upload_File()));
//			CLM.upload_File().click();
//			upload = new StringSelection(System.getProperty("user.dir") + "\\Files\\Certificate.xls");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
//			rb.delay(5000);
//
//			rb.keyPress(KeyEvent.VK_CONTROL);
//			rb.keyPress(KeyEvent.VK_V);
//
//			rb.keyRelease(KeyEvent.VK_CONTROL);
//			rb.keyRelease(KeyEvent.VK_V);
//
//			rb.keyPress(KeyEvent.VK_ENTER);
//			rb.keyRelease(KeyEvent.VK_ENTER);
//			rb.delay(10000);
//
//			rb.delay(3000);
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Subro_Close()));
//			CLM.Clm_Subro_Close().click();
//
//		}

		rb.delay(5000);
//Revised settlement
		scrollDownJavaSc(CLM.Clm_Settlement());
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Revise_Setl_CheckBox()));
		CLM.Clm_Revise_Setl_CheckBox().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Setl_Approve()));
		CLM.Clm_Setl_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Settlement_WF_msg()));
		String text11 = CLM.Clm_Settlement_WF_msg().getText();
		System.out.println("Claims 1st level settlement approval msg: " + text11);
		String Clm_Set_WF_refNo111 = extractWorkflowReference(text11);
		System.out.println("Workflow Reference Number: " + Clm_Set_WF_refNo111);

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Set_WF_refNo111 + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");
		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.username_Field()));
		LP.username_Field().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Thread.sleep(5000);
		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Set_WF_refNo111);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		webDriverWait(ExpectedConditions.visibilityOf(CLM.Clm_Setl_2WF_Msg()));
		String Clm_Setl_2ndWFmsg11 = CLM.Clm_Setl_2WF_Msg().getText();
		System.out.println("Claim settlement second level approve msg: " + Clm_Setl_2ndWFmsg11);
		String Clm_Setl_2refno11 = extractWorkflowReference(Clm_Setl_2ndWFmsg11);
		System.out.println("Claim settlement second level WF refno: " + Clm_Setl_2refno11);

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
				+ Clm_Setl_2refno11 + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
		App_User = get_DB_Data(username_Query, "TC_RESP_USER_ID");
		WF_Description = get_DB_Data(username_Query, "WF_DESC");

		password_Query = "SELECT PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD ('" + App_User + "') USER_PASSWORD FROM DUAL";
		App_Password = get_DB_Data(password_Query, "USER_PASSWORD");

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(App_User);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(App_Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactions_Tab()));
		CLM.Clm_Myactions_Tab().click();

		Clm_MyAction = CLM.Clm_MyAction_SubSection();

		for (WebElement Clm_MyAction_Section : Clm_MyAction) {
			String SubsectionText = Clm_MyAction_Section.getText().trim();

			if (WF_Description.equals(SubsectionText)) {
				Clm_MyAction_Section.click();
				System.out.println("Claims WF Section: " + WF_Description);
				break;
			}
		}
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Myactionstab_Search()));
		CLM.Clm_Myactionstab_Search().sendKeys(Clm_Setl_2refno11);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approver_Viewoption()));
		CLM.Clm_Approver_Viewoption().click();

		rb.delay(20000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Approve_Remarks()));
		CLM.Clm_Approve_Remarks().sendKeys("test");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WF_Approve()));
		CLM.Clm_WF_Approve().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
		uwp.userNameField().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
		uwp.User_logout().click();

		webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
		LP.username_Field().sendKeys(USER);

		webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
		LP.password_Field().sendKeys(Password);

		webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
		LP.login_Button().click();

		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
		GSP.global_Search_Button().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Number_Feild()));
		GSP.Claim_Number_Feild().sendKeys(Clm_No);

		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_Search_button()));
		GSP.Claim_Search_button().click();

		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Claim_GoTo()));
		GSP.Claim_GoTo().click();

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Claim_Status()));
		Clm_Status = CLM.Claim_Status().getText();
		System.out.println("Claims status: " + Clm_Status);

//Estimate closed
		System.out.println("Closing an existing ESTIMATE");
		rb.delay(3000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_1stRiskinfo_Grid()));
		CLM.Clm_1stRiskinfo_Grid().click();

		scrollDownJavaSc(CLM.Clm_Esti_Table());
		rb.delay(2000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Close()));
		CLM.Clm_Esti_Close().click();

		rb.delay(5000);
		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Close_Reason()));
		selectByIndex(CLM.Clm_Esti_Close_Reason(), 1);

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Close_Remarks()));
		CLM.Clm_Esti_Close_Remarks().sendKeys("Close Estimate");

		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Esti_Close_save()));
		CLM.Clm_Esti_Close_save().click();

//		scrollDownJavaSc(CLM.Clm_Esti_Add());
//
//		scrollUpJavaSc(CLM.Clm_WithDraw_Settlement());
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_WithDraw_Settlement()));
//		javaScribtClick(CLM.Clm_WithDraw_Settlement());
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Withdraw_Option()));
//		CLM.Clm_Withdraw_Option().click();
//
//		try {
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_withdraw_confirmation_Msg()));
//			String Withdraw_Confirm_Msg = CLM.Clm_withdraw_confirmation_Msg().getText();
//			System.out.println(Withdraw_Confirm_Msg);
//
//			webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_withdraw_yes()));
//			CLM.Clm_withdraw_yes().click();
//		} catch (Exception e) {
//		}
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Reason_WSC()));
//		selectByIndex(CLM.Reason_WSC(), 2);
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Remarks()));
//		CLM.Clm_Remarks().sendKeys("Withdraw Process");
//
//		webDriverWait(ExpectedConditions.elementToBeClickable(CLM.Clm_Withdraw_Save()));
//		CLM.Clm_Withdraw_Save().click();
	}
}
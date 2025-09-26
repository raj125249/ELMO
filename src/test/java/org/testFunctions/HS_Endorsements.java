package org.testFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.Approval_Workflow_Page;
import org.pages.Endorsement_Information_Page;
import org.pages.Global_Search_Page;
import org.pages.Issue_Claims_Page;
import org.pages.Issue_Policy_Additional_Info_Page;
import org.pages.Issue_Policy_Customer_Info_Page;
import org.pages.Issue_Policy_RA_Slip_Page;
import org.pages.Issue_Policy_RI_Ceding_Page;
import org.pages.Issue_Policy_Risk_Information_Page;
import org.pages.Login_Page;
import org.pages.Underwritting_Page;
import org.testng.annotations.Test;

public class HS_Endorsements extends BaseClass {

	public static String annual_Sum_Insured_Premium;
	public static String OurSI;
	public static String policy_Type;
	public static String Risk_TODate;
	public static String Quote_Number;
	public static String username_Query;
	public static String password_Query;
	public static String App_User;
	public static String App_Password;
	public static String WF_Description;
	public static String Policy_Number;
	public static String RI_Password;
	//public static String Floatingtype;
	public static List<WebElement> MyAction;
	public static String Endor_Pol;
	public static String Endorsement_Type;
	public static List<WebElement> checkboxes;
	public static String Mode_Of_Pay;

	@Test(dataProvider = "HS_Endorsements")

	public void tc001(String S_no, String Policy_No, String Remarks, String RI_Login_User, String Policy_Endorsements, String Non_Financial_Endors,
			String Financial_Endors, String Change_Policy_Endors, String Extension_Policy_Endors,
			String Reduction_Policy_Endors, String Policy_Cancellation_Endors, String Policy_Reinstatement_Endors,

			String Run_Flag) throws AWTException, InterruptedException, ClassNotFoundException, IOException {

		Robot rb = new Robot();
		Login_Page LP = new Login_Page();
		PersonalUW_Login PLP = new PersonalUW_Login();
		HS_HSOC_Policy HSOC = new HS_HSOC_Policy();
		HS_Master_Policy HSM = new HS_Master_Policy();
		Endorsement_Information_Page EIP = new Endorsement_Information_Page();
		Global_Search_Page GSP = new Global_Search_Page();
		Underwritting_Page uwp = new Underwritting_Page();
		Issue_Policy_Customer_Info_Page cus = new Issue_Policy_Customer_Info_Page();
		Issue_Policy_Risk_Information_Page ris = new Issue_Policy_Risk_Information_Page();
		Issue_Policy_Additional_Info_Page apin = new Issue_Policy_Additional_Info_Page();
		Issue_Policy_RI_Ceding_Page ri = new Issue_Policy_RI_Ceding_Page();
		Issue_Policy_RA_Slip_Page ra = new Issue_Policy_RA_Slip_Page();
		Issue_Claims_Page WFA = new Issue_Claims_Page();
		Approval_Workflow_Page AWF = new Approval_Workflow_Page();

		// Policy Endorsements validation
		if (Policy_Endorsements.equals("Yes")) {

			webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
			GSP.global_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
			selectByVisibleText(GSP.Search_Policy_Dropdown(), "Policy No");

			if (HSOC.Policy_Number == null || HSM.HS_Policy_Number == null) {
				String Endorse_Policy = "SELECT * FROM (SELECT TPI_POLICY_NO FROM T_POL_INFO WHERE TPI_STATUS = 'A' AND NOT EXISTS (SELECT 1 FROM Q_POL_INFO WHERE \r\n"
						+ "QPI_TRAN_TYPE='REN' and QPI_OLD_POLICY_NO = TPI_POLICY_NO) AND TPI_BDM_USER IS NULL AND (TPI_END_TYPE != '008' \r\n"
						+ "OR TPI_END_TYPE IS NULL) and (tpi_prod_code in(0501)) ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = '1'";
				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
				// GSP.Policy_Number_Field().sendKeys(get_DB_Data(Endorse_Policy,
				// "TPI_POLICY_NO"));
				GSP.Policy_Number_Field().sendKeys("03356000254");
			} else {

				if (HSOC.Policy_Number == null) {
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(HSM.HS_Policy_Number);
				} else if (HSM.HS_Policy_Number == null) {
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(HSOC.Policy_Number);
				}
			}

			webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
			GSP.policy_Search_Button().click();

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number()));
			Endor_Pol = GSP.Policy_Number().getText();
			System.out.println("Endorsment Policy: " + Endor_Pol);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Type()));
			String Policytype = GSP.Policy_Type().getText();
			System.out.println("Type of Policy: " + Policytype);

			webDriverWait(ExpectedConditions.visibilityOf(GSP.Insured_Name()));
			String Insured = GSP.Insured_Name().getText();
			System.out.println("Insured Name: " + Insured);

			
			if (Non_Financial_Endors.equals("Yes")) {

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
				GSP.endorsement_Button().click();

				// Get Product
				webDriverWait(ExpectedConditions.visibilityOf(GSP.get_Product()));
				String Product_Type1 = GSP.get_Product().getText();
				System.out.println("Product Type is: " + Product_Type1);

				// Select Endorsement Type
				webDriverWait(ExpectedConditions.visibilityOf(GSP.endorsement_Type_Dropdown()));
				selectByVisibleText(GSP.endorsement_Type_Dropdown(), "Non Financial");

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Start_Date()));
				String Pol_Start_Date = GSP.policy_Start_Date().getAttribute("value");
				System.out.println("Actual Policy Start Date: " + Pol_Start_Date);

				webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_To_Date()));
				String Pol_To_Date = GSP.policy_To_Date().getAttribute("value");
				System.out.println("Actual Policy To Date: " + Pol_To_Date);

				webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
				GSP.proceed_Button().click();

				try {

					if (GSP.Endor_Date_validation().isDisplayed()) {

						webDriverWait(ExpectedConditions.visibilityOf(GSP.Endor_Date_validation()));
						String Error = GSP.Endor_Date_validation().getText();
						System.out.println(Error);

						webDriverWait(ExpectedConditions.visibilityOf(GSP.effective_From_Date()));
						GSP.effective_From_Date().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
						LocalDateTime date = LocalDateTime.parse(Pol_Start_Date, formatter);
						LocalDateTime newDate = date.plusDays(30);
						String newDateString = newDate.format(formatter);
						GSP.effective_From_Date().sendKeys(newDateString);
						System.out.println("Endorsement Effective From Date: " + newDateString);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.proceed_Button()));
						GSP.proceed_Button().click();
					}

				} catch (Exception e) {

				}

				webDriverWait(ExpectedConditions.visibilityOf(EIP.get_Endorsement_Type()));
				Endorsement_Type = EIP.get_Endorsement_Type().getText();
				System.out.println("Endorsement Type is: " + Endorsement_Type);

//			Enter Remarks
				webDriverWait(ExpectedConditions.visibilityOf(EIP.remarks_Field()));
				EIP.remarks_Field().sendKeys("change in details");

//			Enter PO BOx Number
				webDriverWait(ExpectedConditions.visibilityOf(EIP.po_Box_Field()));
				EIP.po_Box_Field().clear();
				EIP.po_Box_Field().sendKeys("5645364");

//			Change Address
				webDriverWait(ExpectedConditions.visibilityOf(EIP.address_Field()));
				EIP.address_Field().clear();
				EIP.address_Field().sendKeys("Maltese");

				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

//			edit risk in endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(ris.Endo_edit_risk()));
				ris.Endo_edit_risk().click();

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.risk_Description_Field()));
				ris.risk_Description_Field().clear();
				ris.risk_Description_Field().sendKeys("Risk");

				webDriverWait(ExpectedConditions.elementToBeClickable(ris.save_Button()));
				ris.save_Button().click();

				Thread.sleep(2000);
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
				EIP.proceed_Button().click();

//			Approve Endorsement
				webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
				javaScribtClick(EIP.approve_Non_Financial_Endorsement());

				try {

					webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
					ra.Summary_Policy_PrintDocs().click();

					rb.delay(3000);
					List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
					System.out.println("Print document List: " + listCheckBoxes1.size());
					for (int i = 0; i < listCheckBoxes1.size(); i++) {
						listCheckBoxes1.get(i).click();
					}
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
					GSP.Print_Docs().click();
					Set<String> windows1 = driver.getWindowHandles();
					String parentWindowHandler1 = driver.getWindowHandle();
					for (String handle : windows1) {
						driver.switchTo().window(handle);
						if (!(handle.equals(parentWindowHandler1))) {
							System.out.println(driver.getTitle());
							// driver.close();
						}
					}
					driver.switchTo().window(parentWindowHandler1);
					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Policy_Print_Close()));
					GSP.Policy_Print_Close().click();

					webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
					GSP.global_Search_Button().click();

//			webDriverWait(ExpectedConditions.visibilityOf(GSP.Search_Policy_Dropdown()));
//			selectByVisibleText(GSP.Search_Policy_Dropdown(), Search_Policy);

					// Enter Policy Number
					webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
					GSP.Policy_Number_Field().sendKeys(Endor_Pol);

					webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
					GSP.policy_Search_Button().click();

				} catch (Exception e) {

					// non-financial RI WF
					if (ra.RI_Approval_Msg().isDisplayed()) {
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Approval_Msg()));
						String RI_Special_Treaty = ra.RI_Approval_Msg().getText();
						System.out.println("RI Special Treaty WF MSG: " + RI_Special_Treaty);

						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
						ra.user_Profile().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
						ra.logout_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
						LP.username_Field().sendKeys(RI_Login_User);

						String RI_password_Query = "SELECT USER_NAME,PKG_USER_PASSWORD.FN_DECRYPT_PASSWORD (USER_ID) USER_PASSWORD FROM m_user where USER_ID = '"
								+ RI_Login_User + "'";
						RI_Password = get_DB_Data(RI_password_Query, "USER_PASSWORD");

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(RI_Password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						String RI_User_Name = get_DB_Data(RI_password_Query, "USER_NAME");
						System.out.println("RI user name: " + RI_User_Name);

//				Click Menu Button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.menu_Button()));
						ra.menu_Button().click();

//				Click RI Confirmation Log
						scrollDownJavaSc(ra.Reinsurance_Menu());
						ra.Reinsurance_Menu().click();
						rb.delay(1000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.RI_Confirmation_Menu()));
						ra.RI_Confirmation_Menu().click();

//				Search Quote Number 
						webDriverWait(ExpectedConditions.visibilityOf(ra.search_Enq_Field()));
						ra.search_Enq_Field().sendKeys(Endor_Pol);
						rb.delay(3000);

//				Click Proportional RI Button
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.proportional_RI_Button()));
						ra.proportional_RI_Button().click();
						rb.delay(3000);

//				Enter Remarks
						webDriverWait(ExpectedConditions.visibilityOf(ra.remarks_Field()));
						ra.remarks_Field().sendKeys(Remarks);

//				Click Confirm RI Button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.confirm_RI_Button()));
						ra.confirm_RI_Button().click();

//				Click Yes button
						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.yes_Button()));
						ra.yes_Button().click();

						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(ra.user_Profile()));
						ra.user_Profile().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.logout_Button()));
						ra.logout_Button().click();

						webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.global_Search_Button()));
						javaScribtClick(ra.global_Search_Button());

//				Enter Quote Number
						webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
						GSP.Policy_Number_Field().sendKeys(Endor_Pol);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.policy_Search_Button()));
						GSP.policy_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.endorsement_Button()));
						GSP.endorsement_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.proceed_Button()));
						EIP.proceed_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(EIP.approve_Non_Financial_Endorsement()));
						javaScribtClick(EIP.approve_Non_Financial_Endorsement());

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.Summary_Policy_PrintDocs()));
						ra.Summary_Policy_PrintDocs().click();

						rb.delay(3000);
						List<WebElement> listCheckBoxes1 = GSP.Print_CheckBox();
						System.out.println("Print document List: " + listCheckBoxes1.size());
						for (int i = 0; i < listCheckBoxes1.size(); i++) {
							listCheckBoxes1.get(i).click();
//						}
							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Print_Docs()));
							GSP.Print_Docs().click();
							Set<String> windows1 = driver.getWindowHandles();
							String parentWindowHandler1 = driver.getWindowHandle();
							for (String handle : windows1) {
								driver.switchTo().window(handle);
								if (!(handle.equals(parentWindowHandler1))) {
									System.out.println(driver.getTitle());
									// driver.close();
								}
							}

							webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
							GSP.global_Search_Button().click();

							webDriverWait(ExpectedConditions.visibilityOf(GSP.Policy_Number_Field()));
							GSP.Policy_Number_Field().sendKeys(Endor_Pol);

							webDriverWait(ExpectedConditions.visibilityOf(GSP.policy_Search_Button()));
							GSP.policy_Search_Button().click();
						}
					} else if (ra.Quotation_SI_WFMSG().isDisplayed()) {

						webDriverWait(ExpectedConditions.elementToBeClickable(ra.Quotation_SI_WFMSG()));
						String SILevelMSG = ra.Quotation_SI_WFMSG().getText();
						System.out.println("SI level WF msg: " + SILevelMSG);
						String SI_WF_RefNo = extractWorkflowReference(SILevelMSG);
						System.out.println("Workflow Reference Number: " + SI_WF_RefNo);

						webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
						uwp.userNameField().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
						uwp.User_logout().click();

						username_Query = "SELECT TC_TRANS_ID, TC_RESP_USER_ID, TC_WF_CODE, WF_DESC FROM T_TRANS_CONTROL, M_WORKFLOW WHERE TC_TRANS_ID='"
								+ SI_WF_RefNo + "' and WF_CODE = TC_WF_CODE and tc_status='P' AND ROWNUM=1";
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
						webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactions_Tab()));
						WFA.Clm_Myactions_Tab().click();

						MyAction = WFA.Clm_MyAction_SubSection();

						for (WebElement MyAction_Section : MyAction) {
							String SubsectionText = MyAction_Section.getText().trim();

							if (WF_Description.equals(SubsectionText)) {
								MyAction_Section.click();
								System.out.println("Claims WF Section: " + WF_Description);
								break;
							}
						}

						rb.delay(3000);
						webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Myactionstab_Search()));
						WFA.Clm_Myactionstab_Search().sendKeys(SI_WF_RefNo);

						webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approver_Viewoption()));
						WFA.Clm_Approver_Viewoption().click();

						rb.delay(20000);
						webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_Approve_Remarks()));
						WFA.Clm_Approve_Remarks().sendKeys("test");

						webDriverWait(ExpectedConditions.elementToBeClickable(WFA.Clm_WF_Approve()));
						WFA.Clm_WF_Approve().click();

						rb.delay(5000);
						webDriverWait(ExpectedConditions.elementToBeClickable(uwp.userNameField()));
						uwp.userNameField().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(uwp.User_logout()));
						uwp.User_logout().click();

						webDriverWait(ExpectedConditions.visibilityOf(LP.username_Field()));
						LP.username_Field().sendKeys(PLP.Loginuser);

						webDriverWait(ExpectedConditions.visibilityOf(LP.password_Field()));
						LP.password_Field().sendKeys(PLP.Loginuser_password);

						webDriverWait(ExpectedConditions.elementToBeClickable(LP.login_Button()));
						LP.login_Button().click();

						rb.delay(2000);
						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.global_Search_Button()));
						GSP.global_Search_Button().click();

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Number_Field()));
						GSP.Quote_Number_Field().sendKeys(Quote_Number);

						webDriverWait(ExpectedConditions.elementToBeClickable(GSP.Quote_Search_Button()));
						GSP.Quote_Search_Button().click();
					}

				}
// nonfinancial endorsement ends here		
			}
			
			
			
			
			
			
			
			
			
			
		}
	}
}

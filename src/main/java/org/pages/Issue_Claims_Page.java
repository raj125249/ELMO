package org.pages;

import java.util.List;

import org.common.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Issue_Claims_Page extends BaseClass {

	public Issue_Claims_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='clm_search']//input")
	WebElement Clm_Inti_Search;

	public WebElement Clm_Inti_Search() {
		return Clm_Inti_Search;
	}

	@FindBy(xpath = "//button[@id='btn_clm_intimate']")
	WebElement Clm_Inti_Add;

	public WebElement Clm_Inti_Add() {
		return Clm_Inti_Add;
	}

	@FindBy(xpath = "//table[@id='claimIntmLogGrid']//tr//td[14]//a")
	WebElement Clm_Inti_EditIcon;

	public WebElement Clm_Inti_EditIcon() {
		return Clm_Inti_EditIcon;
	}

	@FindBy(xpath = "//table[@id='claimIntmLogGrid']//tr//td[13]//a")
	WebElement Clm_Inti_ClmNo;

	public WebElement Clm_Inti_ClmNo() {
		return Clm_Inti_ClmNo;
	}

	@FindBy(xpath = "//select[@id='intmMode']")
	WebElement Clm_Inti_Mode;

	public WebElement Clm_Inti_Mode() {
		return Clm_Inti_Mode;
	}

	@FindBy(xpath = "//select[@id='intmFrom']")
	WebElement Clm_Inti_IntimatedBy;

	public WebElement Clm_Inti_IntimatedBy() {
		return Clm_Inti_IntimatedBy;
	}

	@FindBy(xpath = "//input[@id='lossDt']")
	WebElement Clm_Inti_LossDate;

	public WebElement Clm_Inti_LossDate() {
		return Clm_Inti_LossDate;
	}

	@FindBy(xpath = "//input[@id='intmDt']")
	WebElement Clm_intimation_Date;

	public WebElement Clm_intimation_Date() {
		return Clm_intimation_Date;
	}

	@FindBy(xpath = "//select[@id='schemes']")
	WebElement Clm_Inti_PolicyType;

	public WebElement Clm_Inti_PolicyType() {
		return Clm_Inti_PolicyType;
	}

	@FindBy(xpath = "//input[@id='policyNo']")
	WebElement Clm_Inti_PolicyNo;

	public WebElement Clm_Inti_PolicyNo() {
		return Clm_Inti_PolicyNo;
	}

	@FindBy(xpath = "//input[@id='hid_policyStartDate']")
	WebElement Clm_Inti_Policy_Startdate;

	public WebElement Clm_Inti_Policy_Startdate() {
		return Clm_Inti_Policy_Startdate;
	}

	@FindBy(xpath = "//input[@id='hid_policyEndDate']")
	WebElement Clm_Inti_Policy_Enddate;

	public WebElement Clm_Inti_Policy_Enddate() {
		return Clm_Inti_Policy_Enddate;
	}

	@FindBy(xpath = "//textarea[@id='lossDetail']")
	WebElement Clm_Inti_LossDetails;

	public WebElement Clm_Inti_LossDetails() {
		return Clm_Inti_LossDetails;
	}

	@FindBy(xpath = "//input[@id='recoveryYn1']")
	WebElement Clm_Inti_TPRecovery_Yes;

	public WebElement Clm_Inti_TPRecovery_Yes() {
		return Clm_Inti_TPRecovery_Yes;
	}

	@FindBy(xpath = "//input[@id='recoveryYn0']")
	WebElement Clm_Inti_TPRecovery_No;

	public WebElement Clm_Inti_TPRecovery_No() {
		return Clm_Inti_TPRecovery_No;
	}

	@FindBy(xpath = "//select[@id='sel_receivedBy']")
	WebElement Clm_Inti_ReceivedBy;

	public WebElement Clm_Inti_ReceivedBy() {
		return Clm_Inti_ReceivedBy;
	}

	@FindBy(xpath = "//select[@id='sel_handledBy']")
	WebElement Clm_Inti_HandlerBy;

	public WebElement Clm_Inti_HandlerBy() {
		return Clm_Inti_HandlerBy;
	}

	@FindAll({ @FindBy(xpath = "//select[@name='docCode']"), @FindBy(xpath = "//select[@id='sel_docId']") })
	WebElement Clm_Document_Dropdown;

	public WebElement Clm_Document_Dropdown() {
		return Clm_Document_Dropdown;
	}

	@FindAll({ @FindBy(xpath = "//span[@class='btn btn-file btn-blue  btn-sm dmsFile']"),
			@FindBy(xpath = "//*[@class='col-md-1 right']") })
	WebElement upload_File;

	public WebElement upload_File() {
		return upload_File;
	}

	@FindBy(xpath = "//div[@aria-role='alert']")
	WebElement DocumentUploadSuccess;

	public WebElement DocumentUploadSuccess() {
		return DocumentUploadSuccess;
	}

	@FindBy(xpath = "//button[contains(text(), 'Save & Close')]")
	WebElement Clm_Inti_Saveoption;

	public WebElement Clm_Inti_Saveoption() {
		return Clm_Inti_Saveoption;
	}

	@FindBy(xpath = "//button[@id='saveAndProceed']")
	WebElement Clm_Inti_RegisterClaim;

	public WebElement Clm_Inti_RegisterClaim() {
		return Clm_Inti_RegisterClaim;
	}

	@FindBy(xpath = "//div[@class='ui-pnotify-text']")
	WebElement Clm_Inti_Succ_Msg;

	public WebElement Clm_Inti_Succ_Msg() {
		return Clm_Inti_Succ_Msg;
	}

	@FindBy(xpath = "//select[@id='causeOfLoss']")
	WebElement Clm_Regis_CauseofLoss;

	public WebElement Clm_Regis_CauseofLoss() {
		return Clm_Regis_CauseofLoss;
	}

	@FindBy(xpath = "//select[@id='natureOfLoss']")
	WebElement Clm_Regis_NatureofLoss;

	public WebElement Clm_Regis_NatureofLoss() {
		return Clm_Regis_NatureofLoss;
	}

	@FindBy(xpath = "//select[@id='polRiskSrNo']")
	WebElement Clm_Regis_RiskID;

	public WebElement Clm_Regis_RiskID() {
		return Clm_Regis_RiskID;
	}

	@FindBy(xpath = "//select[@id='polCoverCode']")
	WebElement Clm_Regis_CoverID;

	public WebElement Clm_Regis_CoverID() {
		return Clm_Regis_CoverID;
	}

	@FindBy(xpath = "//select[@id='claimLiabInd']")
	WebElement Clm_Regis_Liability;

	public WebElement Clm_Regis_Liability() {
		return Clm_Regis_Liability;
	}

	@FindBy(xpath = "//button[@id='btn_proceed']")
	WebElement Claim_Register;

	public WebElement Claim_Register() {
		return Claim_Register;
	}

	@FindBy(xpath = "(//button[@id='btn_clm_ok'])[2]")
	WebElement Claim_Register_Confirmation;

	public WebElement Claim_Register_Confirmation() {
		return Claim_Register_Confirmation;
	}

	@FindBy(xpath = "(//table[@id='clmHdrTbl'])[1]//tbody//tr[1]//td[2]")
	WebElement Claim_No;

	public WebElement Claim_No() {
		return Claim_No;
	}

	@FindBy(xpath = "(//div[@class='col-md-2'])[1]//h1//font")
	WebElement Claim_Status;

	public WebElement Claim_Status() {
		return Claim_Status;
	}

	@FindBy(xpath = "//button[@id='wsClaimsHeaderInfoId']")
	WebElement Clm_WithDraw_Settlement;

	public WebElement Clm_WithDraw_Settlement() {
		return Clm_WithDraw_Settlement;
	}

	@FindBy(xpath = "//button[@id='rejectClaimsHeaderInfoId']")
	WebElement Clm_Reject;

	public WebElement Clm_Reject() {
		return Clm_Reject;
	}

	@FindBy(xpath = "//label[text()='WithDraw']//preceding::input[@id='withdrSetl1']")
	WebElement Clm_Withdraw_Option;

	public WebElement Clm_Withdraw_Option() {
		return Clm_Withdraw_Option;
	}

	@FindBy(xpath = "//label[text()='Settle']//preceding::input[@id='withdrSetl2']")
	WebElement Clm_Settle_Option;

	public WebElement Clm_Settle_Option() {
		return Clm_Settle_Option;
	}

	@FindBy(xpath = "//div[contains(text(), 'Proceed with Withdraw ?')]")
	WebElement Clm_withdraw_confirmation_Msg;

	public WebElement Clm_withdraw_confirmation_Msg() {
		return Clm_withdraw_confirmation_Msg;
	}

	@FindBy(xpath = "//textarea[@id='closeRemarks']")
	WebElement Clm_Remarks;

	public WebElement Clm_Remarks() {
		return Clm_Remarks;
	}

	@FindBy(xpath = "(//button[@id='btn_proc'])[5]")
	WebElement Clm_withdraw_yes;

	public WebElement Clm_withdraw_yes() {
		return Clm_withdraw_yes;
	}

	@FindBy(xpath = "(//button[@id='btn_close'])[4]")
	WebElement Clm_withdraw_No;

	public WebElement Clm_withdraw_No() {
		return Clm_withdraw_No;
	}

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Clm_Withdraw_Save;

	public WebElement Clm_Withdraw_Save() {
		return Clm_Withdraw_Save;
	}

	@FindBy(xpath = "//button[@id='clm_close']")
	WebElement Clm_Withdraw_Close;

	public WebElement Clm_Withdraw_Close() {
		return Clm_Withdraw_Close;
	}

	@FindBy(xpath = "//button[@id='btn_view_acnt']")
	WebElement Clm_View_Accounting;

	public WebElement Clm_View_Accounting() {
		return Clm_View_Accounting;
	}

	@FindBy(xpath = "//button[@id='btn_report']")
	WebElement Clm_Print;

	public WebElement Clm_Print() {
		return Clm_Print;
	}

	@FindBy(xpath = "//button[@id='addclaimRiskLegalHearings']")
	WebElement Clm_Hearings;

	public WebElement Clm_Hearings() {
		return Clm_Hearings;
	}

	@FindBy(xpath = "//select[@id='closeReasonCode']")
	WebElement Reason_WSC;

	public WebElement Reason_WSC() {
		return Reason_WSC;
	}

	@FindBy(xpath = "//button[@id='btn_ri_summ']")
	WebElement Clm_RI;

	public WebElement Clm_RI() {
		return Clm_RI;
	}

	@FindBy(xpath = "//button[@id='claim_reopen']")
	WebElement Clm_ReOpen;

	public WebElement Clm_ReOpen() {
		return Clm_ReOpen;
	}

	@FindBy(xpath = "//button[normalize-space()='Re Open']")
	WebElement Clm_ReOpen_Save;

	public WebElement Clm_ReOpen_Save() {
		return Clm_ReOpen_Save;
	}

	@FindBy(xpath = "//button[@id='view_upload_doc']")
	WebElement Clm_Upload_Doc;

	public WebElement Clm_Upload_Doc() {
		return Clm_Upload_Doc;
	}

	@FindBy(xpath = "//button[@id='hisClaimsHeaderInfoId']")
	WebElement Clm_StatusHistory;

	public WebElement Clm_StatusHistory() {
		return Clm_StatusHistory;
	}

	@FindBy(xpath = "//span[normalize-space()='FAC is Applicable']")
	WebElement CLM_FAC_Applicable;

	public WebElement CLM_FAC_Applicable() {
		return CLM_FAC_Applicable;
	}

	@FindBy(xpath = "//span[normalize-space()='CoInsurance is Applicable']")
	WebElement CLM_Coin_Applicable;

	public WebElement CLM_Coin_Applicable() {
		return CLM_Coin_Applicable;
	}

	@FindBy(xpath = "(//table[@id='clmHdrTbl'])[1]//tbody//tr[1]//td[4]")
	WebElement Claim_PolicyNo;

	public WebElement Claim_PolicyNo() {
		return Claim_PolicyNo;
	}

	@FindBy(xpath = "(//table[@id='clmHdrTbl'])[1]//tbody//tr[5]//td[2]")
	WebElement Claims_BS;

	public WebElement Claims_BS() {
		return Claims_BS;
	}

	@FindBy(xpath = "((//table[@id='clmHdrTbl'])[1]//tbody//tr//td[normalize-space()='Product'])//following-sibling::td[1]")
	WebElement Claims_Product;

	public WebElement Claims_Product() {
		return Claims_Product;
	}

	@FindBy(xpath = "((//table[@id='clmHdrTbl'])[1]//tbody//tr//td[normalize-space()='Type of Policy'])//following-sibling::td[1]")
	WebElement Claims_PolicyType;

	public WebElement Claims_PolicyType() {
		return Claims_PolicyType;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])")
	WebElement Claims_OS_InfoTable;

	public WebElement Claims_OS_InfoTable() {
		return Claims_OS_InfoTable;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[1]")
	WebElement ClaimsOS_PaymentOS;

	public WebElement ClaimsOS_PaymentOS() {
		return ClaimsOS_PaymentOS;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[2]")
	WebElement ClaimsOS_RecoveryOS;

	public WebElement ClaimsOS_RecoveryOS() {
		return ClaimsOS_RecoveryOS;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[3]")
	WebElement ClaimsOS_Coin_PaymentOS;

	public WebElement ClaimsOS_Coin_PaymentOS() {
		return ClaimsOS_Coin_PaymentOS;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[4]")
	WebElement ClaimsOS_Coin_RecoveryOS;

	public WebElement ClaimsOS_Coin_RecoveryOS() {
		return ClaimsOS_Coin_RecoveryOS;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[5]")
	WebElement ClaimsOS_TotalOS;

	public WebElement ClaimsOS_TotalOS() {
		return ClaimsOS_TotalOS;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[6]")
	WebElement ClaimsOS_Paid;

	public WebElement ClaimsOS_Paid() {
		return ClaimsOS_Paid;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[7]")
	WebElement ClaimsOS_Recovery;

	public WebElement ClaimsOS_Recovery() {
		return ClaimsOS_Recovery;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[8]")
	WebElement ClaimsOS_Coin_Paid;

	public WebElement ClaimsOS_Coin_Paid() {
		return ClaimsOS_Coin_Paid;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[9]")
	WebElement ClaimsOS_Coin_Recovered;

	public WebElement ClaimsOS_Coin_Recovered() {
		return ClaimsOS_Coin_Recovered;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[10]")
	WebElement ClaimsOS_Total_Settled;

	public WebElement ClaimsOS_Total_Settled() {
		return ClaimsOS_Total_Settled;
	}

	@FindBy(xpath = "(//table[@id='claimOsInfoTable'])//tbody//tr//td[11]")
	WebElement ClaimsOS_Incurred;

	public WebElement ClaimsOS_Incurred() {
		return ClaimsOS_Incurred;
	}

	@FindBy(xpath = "//button[@id='addRiskClaimsInfoId']")
	WebElement Clm_Risk_Add;

	public WebElement Clm_Risk_Add() {
		return Clm_Risk_Add;
	}

	@FindBy(xpath = "//select[@id='polCoverCode']")
	WebElement Clm_Risk_Cover;

	public WebElement Clm_Risk_Cover() {
		return Clm_Risk_Cover;
	}

	@FindBy(xpath = "//select[@id='polSmiCode']")
	WebElement Clm_Risk_SMI_Code;

	public WebElement Clm_Risk_SMI_Code() {
		return Clm_Risk_SMI_Code;
	}

	@FindBy(xpath = "//input[@id='ourShareYn0']")
	WebElement Clm_Risk_Coin_100share;

	public WebElement Clm_Risk_Coin_100share() {
		return Clm_Risk_Coin_100share;
	}

	@FindBy(xpath = "//input[@id='ourShareYn1']")
	WebElement Clm_Risk_Coin_Ourshare;

	public WebElement Clm_Risk_Coin_Ourshare() {
		return Clm_Risk_Coin_Ourshare;
	}

	// readonly mode xpath
	@FindBy(xpath = "(//div[4]/input[2]/@value)/preceding::input[1]")
	WebElement Clm_Risk_SI_Value;

	public WebElement Clm_Risk_SI_Value() {
		return Clm_Risk_SI_Value;
	}

	@FindBy(xpath = "//select[@id='iniEstCode']")
	WebElement Clm_RIsk_Estimate_Code;

	public WebElement Clm_RIsk_Estimate_Code() {
		return Clm_RIsk_Estimate_Code;
	}

	@FindBy(xpath = "(//label[@class='checkbox checkbox-custom-alt']//following::i[1])[1]")
	WebElement Deductible_Checkbox;

	public WebElement Deductible_Checkbox() {
		return Deductible_Checkbox;
	}

	@FindBy(xpath = "//table[@class='table table-bordered']//tbody//tr//td//input[@id='checkDedFlag_0']")
	WebElement Deductible_1CheckBox;

	public WebElement Deductible_1CheckBox() {
		return Deductible_1CheckBox;
	}

	@FindBy(xpath = "//span[@id='coInsClaimOurShare']")
	WebElement Clm_Our_Percentage;

	public WebElement Clm_Our_Percentage() {
		return Clm_Our_Percentage;
	}

	@FindBy(xpath = "//select[@id='claimLiabTyp']")
	WebElement Clm_Liability_Type;

	public WebElement Clm_Liability_Type() {
		return Clm_Liability_Type;
	}

	@FindBy(xpath = "//input[@id='iniEstAmt']")
	WebElement Clm_Risk_Estimate_Amount;

	public WebElement Clm_Risk_Estimate_Amount() {
		return Clm_Risk_Estimate_Amount;
	}

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Clm_Risk_Save;

	public WebElement Clm_Risk_Save() {
		return Clm_Risk_Save;
	}

	@FindBy(xpath = "(//div[normalize-space(@class)='col-md-12 BodyContect'])[3]")
	WebElement Clm_OurSI_Exceed_Msg;

	public WebElement Clm_OurSI_Exceed_Msg() {
		return Clm_OurSI_Exceed_Msg;
	}

	@FindBy(xpath = "(//button[@id='btn_proc'])[8]")
	WebElement Clm_Our_Exceed_Confirmation;

	public WebElement Clm_Our_Exceed_Confirmation() {
		return Clm_Our_Exceed_Confirmation;
	}

	@FindBy(xpath = "(//button[@id='btn_close'])[4]")
	WebElement Clm_Our_Exceed_Close;

	public WebElement Clm_Our_Exceed_Close() {
		return Clm_Our_Exceed_Close;
	}

	@FindBy(xpath = "(//div[@class='col-md-12 BodyContect'])[3]")
	WebElement Clm_Risk_Coin_limitValidation;

	public WebElement Clm_Risk_Coin_limitValidation() {
		return Clm_Risk_Coin_limitValidation;
	}
	
	@FindBy(xpath="//input[@id='iniEstCustName_DISP']")
	WebElement Clm_Initial_Esti_Customer_Code;
	
	public WebElement Clm_Initial_Esti_Customer_Code() {
		return Clm_Initial_Esti_Customer_Code;
	}
	
	@FindBy(xpath="//ul[normalize-space(@class)='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li//div")
	WebElement Clm_Select_Customer_Code;
	
	public WebElement Clm_Select_Customer_Code() {
		return Clm_Select_Customer_Code;
	}
	
	@FindBy(xpath="//input[@id='estCustCodeAuto']")
	WebElement Clm_Esti_Customer_Code;
	
	public WebElement Clm_Esti_Customer_Code() {
		return Clm_Esti_Customer_Code;
	}

	@FindBy(xpath = "(//button[@id='btn_proc'])[8]")
	WebElement Clm_Risk_Coin_limitValidation_Yes;

	public WebElement Clm_Risk_Coin_limitValidation_Yes() {
		return Clm_Risk_Coin_limitValidation_Yes;
	}

	@FindBy(xpath = "(//button[@id='btn_close'])[4]")
	WebElement Clm_Risk_Coin_limitValidation_No;

	public WebElement Clm_Risk_Coin_limitValidation_No() {
		return Clm_Risk_Coin_limitValidation_No;
	}

	@FindBy(xpath = "//div[@id='ClmPolRiskSuccessDiv']")
	WebElement Clm_Risk_WF_Msg;

	public WebElement Clm_Risk_WF_Msg() {
		return Clm_Risk_WF_Msg;
	}

	@FindBy(xpath = "//div[@id='ClaimEstimateErrorDiv']")
	WebElement Clm_Esti_WF_Msg;

	public WebElement Clm_Esti_WF_Msg() {
		return Clm_Esti_WF_Msg;
	}

	@FindBy(xpath = "//button[@id='addViewClaimEstInfoId']")
	WebElement Clm_Esti_Add;

	public WebElement Clm_Esti_Add() {
		return Clm_Esti_Add;
	}

	@FindBy(xpath = "//select[@id='estSmiCode']")
	WebElement Clm_Esti_SMI;

	public WebElement Clm_Esti_SMI() {
		return Clm_Esti_SMI;
	}

	@FindBy(xpath = "//label[normalize-space(text())='100% Share']")
	WebElement Clm_Esti_Coin_100share;

	public WebElement Clm_Esti_Coin_100share() {
		return Clm_Esti_Coin_100share;
	}

	@FindBy(xpath = "//label[normalize-space(text())='Our Share']")
	WebElement Clm_ESti_Coin_Ourshare;

	public WebElement Clm_ESti_Coin_Ourshare() {
		return Clm_ESti_Coin_Ourshare;
	}

	@FindBy(xpath = "//input[@id='estCustCodeAuto']")
	WebElement Clm_Esti_Claimant;

	public WebElement Clm_Esti_Claimant() {
		return Clm_Esti_Claimant;
	}

	@FindBy(xpath = "//select[@id='estType']")
	WebElement Clm_Esti_Type;

	public WebElement Clm_Esti_Type() {
		return Clm_Esti_Type;
	}

	@FindBy(xpath = "//select[@id='estCode']")
	WebElement Clm_Esti_Code;

	public WebElement Clm_Esti_Code() {
		return Clm_Esti_Code;
	}

	@FindBy(xpath = "//input[@id='estPayAmount']")
	WebElement Clm_Esti_PayAmount;

	public WebElement Clm_Esti_PayAmount() {
		return Clm_Esti_PayAmount;
	}

	@FindBy(xpath = "//input[@id='estRecAmount']")
	WebElement Clm_Esti_RecAmount;

	public WebElement Clm_Esti_RecAmount() {
		return Clm_Esti_RecAmount;
	}

	@FindBy(xpath = "//select[@id='claimLiabTypEstLvl']")
	WebElement Clm_Esti_Liability;

	public WebElement Clm_Esti_Liability() {
		return Clm_Esti_Liability;
	}

	@FindBy(xpath = "//button[@id='btn_estSave']")
	WebElement Clm_Esti_Save;

	public WebElement Clm_Esti_Save() {
		return Clm_Esti_Save;
	}

	@FindBy(xpath = "//div[@id='ClaimEstimateErrorDiv']")
	WebElement Clm_Estimate_WF_MSG;

	public WebElement Clm_Estimate_WF_MSG() {
		return Clm_Estimate_WF_MSG;
	}

	@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//td[12]")
	WebElement Clm_Estimate_Status;

	public WebElement Clm_Estimate_Status() {
		return Clm_Estimate_Status;
	}

	@FindBy(xpath = "//input[@id='txt_outstandAmnt']")
	WebElement Clm_OutStanding_Amount;

	public WebElement Clm_OutStanding_Amount() {
		return Clm_OutStanding_Amount;
	}

	@FindBy(xpath = "//input[@id='txt_setldAmnt']")
	WebElement Clm_Settled_Amount;

	public WebElement Clm_Settled_Amount() {
		return Clm_Settled_Amount;
	}

	@FindBy(xpath = "//button[@id='claimSettlmentInfoId']")
	WebElement Clm_Settlement;

	public WebElement Clm_Settlement() {
		return Clm_Settlement;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='1']//following::td[text()='Pending'][1])//preceding::td[3]//input[contains(@id, 'setlPaidAmt_')]")
	WebElement Clm_Setl_Payamt1;

	public WebElement Clm_Setl_Payamt1() {
		return Clm_Setl_Payamt1;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='1']//following::td[text()='Pending'][1])//following::td[4]//input[contains(@id, 'setlSelectYn')]")
	WebElement Clm_Setl_Payamt1_SelectBox;

	public WebElement Clm_Setl_Payamt1_SelectBox() {
		return Clm_Setl_Payamt1_SelectBox;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='2']//following::td[text()='Pending'][1])//preceding::td[3]//input[contains(@id, 'setlPaidAmt_')]")
	WebElement Clm_Setl_Payamt2;

	public WebElement Clm_Setl_Payamt2() {
		return Clm_Setl_Payamt2;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='2']//following::td[text()='Pending'][1])//following::td[4]//input[contains(@id, 'setlSelectYn')]")
	WebElement Clm_Setl_Payamt2_SelectBox;

	public WebElement Clm_Setl_Payamt2_SelectBox() {
		return Clm_Setl_Payamt2_SelectBox;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='3']//following::td[text()='Pending'][1])//preceding::td[2]//input[contains(@id, 'setlRecAmt_')]")
	WebElement Clm_Setl_Recamt;

	public WebElement Clm_Setl_Recamt() {
		return Clm_Setl_Recamt;
	}

	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='3']//following::td[text()='Pending'][1])//following::td[4]//input[contains(@id, 'setlSelectYn')]")
	WebElement Clm_setl_Recamt_SelectBox;

	public WebElement Clm_setl_Recamt_SelectBox() {
		return Clm_setl_Recamt_SelectBox;
	}

	@FindBy(xpath = "//input[@id='subroSelectYn_1']")
	WebElement Clm_Subrogation_Checkbox;

	public WebElement Clm_Subrogation_Checkbox() {
		return Clm_Subrogation_Checkbox;
	}
	
	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='2']//following::td[text()='Pending'][1])//following::td[2]//input[contains(@id, 'subroSelectYn')]")
	WebElement Clm_Subrogation_Checkbox2;

	public WebElement Clm_Subrogation_Checkbox2() {
		return Clm_Subrogation_Checkbox2;
	}
	
	@FindBy(xpath = "(//table[@id='claimSettlementGrid']//td[2][text()='2']//following::td[text()='Pending'][1])//following::td[2]//input[contains(@id, 'subroSelectYn')]")
	WebElement Clm_Subrogation_Checkbox3;

	public WebElement Clm_Subrogation_Checkbox3() {
		return Clm_Subrogation_Checkbox3;
	}

	@FindBy(xpath = "//button[@id='btn_printSubroForm']")
	WebElement Clm_Subrogation;

	public WebElement Clm_Subrogation() {
		return Clm_Subrogation;
	}

	@FindBy(xpath = "//input[@id='typeRec_0']")
	WebElement Clm_Subro_printCheckbox;

	public WebElement Clm_Subro_printCheckbox() {
		return Clm_Subro_printCheckbox;
	}

	@FindBy(xpath = "//button[@id='printReport']")
	WebElement Clm_Subro_Print;

	public WebElement Clm_Subro_Print() {
		return Clm_Subro_Print;
	}

	@FindBy(xpath = "//button[@id='printHistory']")
	WebElement Clm_Subro_PrintHistory;

	public WebElement Clm_Subro_PrintHistory() {
		return Clm_Subro_PrintHistory;
	}

	@FindBy(xpath = "//button[@id='idSendMail']")
	WebElement Clm_Subro_Mail;

	public WebElement Clm_Subro_Mail() {
		return Clm_Subro_Mail;
	}

	@FindBy(xpath = "//input[@id='recipient']")
	WebElement Clm_Subro_MailTO;

	public WebElement Clm_Subro_MailTO() {
		return Clm_Subro_MailTO;
	}

	@FindBy(xpath = "//input[@id='ccrecipient']")
	WebElement Clm_Subro_MailCC;

	public WebElement Clm_Subro_MailCC() {
		return Clm_Subro_MailCC;
	}

	@FindBy(xpath = "//input[@id='subject']")
	WebElement Clm_Subro_MailSubject;

	public WebElement Clm_Subro_MailSubject() {
		return Clm_Subro_MailSubject;
	}

	@FindBy(xpath = "//button[normalize-space()='Fetch Template']")
	WebElement Clm_Subro_FetchTemplate;

	public WebElement Clm_Subro_FetchTemplate() {
		return Clm_Subro_FetchTemplate;
	}

	@FindBy(xpath = "//select[@id='chooseTemplate']")
	WebElement Clm_Subro_ChooseTemplate;

	public WebElement Clm_Subro_ChooseTemplate() {
		return Clm_Subro_ChooseTemplate;
	}

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement Clm_Subro_Apply_Template;

	public WebElement Clm_Subro_Apply_Template() {
		return Clm_Subro_Apply_Template;
	}

	@FindBy(xpath = "//button[normalize-space()='Send E-mail']")
	WebElement Clm_Subro_Send_Email;

	public WebElement Clm_Subro_Send_Email() {
		return Clm_Subro_Send_Email;
	}

	@FindBy(xpath = "//button[@id='showDmsPage']")
	WebElement Clm_Subro_Documents;

	public WebElement Clm_Subro_Documents() {
		return Clm_Subro_Documents;
	}

	@FindBy(xpath = "//select[@id='sel_docId']")
	WebElement Clm_Subro_Doclist;

	public WebElement Clm_Subro_Doclist() {
		return Clm_Subro_Doclist;
	}

	@FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
	WebElement Clm_Subro_Close;

	public WebElement Clm_Subro_Close() {
		return Clm_Subro_Close;
	}

	//@FindAll({ @FindBy(xpath = "//input[@id='ClaimSetlForm_setlModeOfPay2']"),
			@FindBy(xpath = "//label[text()='SEPA']") //})
	WebElement Clm_SEPA_Payment;

	public WebElement Clm_SEPA_Payment() {
		return Clm_SEPA_Payment;
	}
	
	@FindBy(xpath="//select[@id='setlInsBankAcnt']")
	WebElement Clm_SEPA_Bank_AC;
	
	public WebElement Clm_SEPA_Bank_AC() {
		return Clm_SEPA_Bank_AC;
	}
	
	@FindBy(xpath="//table[@id='claimEstimatesGrid']//tbody")
	WebElement Clm_Esti_Table;
	
	public WebElement Clm_Esti_Table() {
		return Clm_Esti_Table;
	}

	@FindBy(xpath = "//input[@id='ClaimSetlForm_setlModeOfPay3']")
	WebElement Clm_Cheque_Payment;

	public WebElement Clm_Cheque_Payment() {
		return Clm_Cheque_Payment;
	}

	@FindBy(xpath = "//input[@id='setlPayeeName']")
	WebElement Clm_Cheque_Payee_Name;

	public WebElement Clm_Cheque_Payee_Name() {
		return Clm_Cheque_Payee_Name;
	}

	@FindBy(xpath = "//input[@id='ClaimSetlForm_setlModeOfPay0']")
	WebElement Clm_Credit_Payment;

	public WebElement Clm_Credit_Payment() {
		return Clm_Credit_Payment;
	}

	@FindBy(xpath = "//input[@id='ClaimSetlForm_setlModeOfPay4']")
	WebElement Clm_Debit_Payment;

	public WebElement Clm_Debit_Payment() {
		return Clm_Debit_Payment;
	}

	@FindBy(xpath = "//input[@id='ClaimSetlForm_setlModeOfPay1']")
	WebElement Clm_Receipt_payment;

	public WebElement Clm_Receipt_payment() {
		return Clm_Receipt_payment;
	}

	@FindBy(xpath = "//textarea[@id='setlRemarks']")
	WebElement Clm_Settlement_Remarks;

	public WebElement Clm_Settlement_Remarks() {
		return Clm_Settlement_Remarks;
	}

	@FindBy(xpath = "//button[@id='btn_setlSave']")
	WebElement Clm_Setl_Save;

	public WebElement Clm_Setl_Save() {
		return Clm_Setl_Save;
	}

	@FindBy(xpath = "//select[@id='setlInsBillAcnt']")
	WebElement Clm_Setle_InsBilling;

	public WebElement Clm_Setle_InsBilling() {
		return Clm_Setle_InsBilling;
	}

	@FindBy(xpath = "//input[@id='setlAccNumber']")
	WebElement Clm_SEPA_ACNO;

	public WebElement Clm_SEPA_ACNO() {
		return Clm_SEPA_ACNO;
	}

	@FindBy(xpath = "//input[@id='setlIbanNo']")
	WebElement Clm_SEPA_IBAN;

	public WebElement Clm_SEPA_IBAN() {
		return Clm_SEPA_IBAN;
	}

	@FindBy(xpath = "//input[@id='setlSwiftCode']")
	WebElement Clm_SEPA_SwiftCode;

	public WebElement Clm_SEPA_SwiftCode() {
		return Clm_SEPA_SwiftCode;
	}

	@FindBy(xpath = "//input[@id='setlBankName']")
	WebElement Clm_SEPA_Bankname;

	public WebElement Clm_SEPA_Bankname() {
		return Clm_SEPA_Bankname;
	}

	@FindBy(xpath = "//input[@id='setlEmailId']")
	WebElement Clm_SEPA_EmailID;

	public WebElement Clm_SEPA_EmailID() {
		return Clm_SEPA_EmailID;
	}

	@FindBy(xpath = "//input[@id='setlBicCode']")
	WebElement Clm_SEPA_BICcode;

	public WebElement Clm_SEPA_BICcode() {
		return Clm_SEPA_BICcode;
	}

	@FindBy(xpath = "//input[@id='setlMobileNo']")
	WebElement Clm_SEPA_MbNo;

	public WebElement Clm_SEPA_MbNo() {
		return Clm_SEPA_MbNo;
	}

	@FindBy(xpath = "//button[@id='addViewClaimSetlInfoId']")
	WebElement Clm_Setl_Approve;

	public WebElement Clm_Setl_Approve() {
		return Clm_Setl_Approve;
	}

	@FindBy(xpath = "(//button[contains(text(),'RI')])[2]")
	WebElement Clm_Settlement_RI;

	public WebElement Clm_Settlement_RI() {
		return Clm_Settlement_RI;
	}

	@FindBy(xpath = "//span[@id='span_TotalPendingAction']")
	WebElement Clm_Myactions_Tab;

	public WebElement Clm_Myactions_Tab() {
		return Clm_Myactions_Tab;
	}

	@FindBy(xpath = "//span[@id='span_TotalMyRequest']")
	WebElement Clm_MyRequest_Tab;

	public WebElement Clm_MyRequest_Tab() {
		return Clm_MyRequest_Tab;
	}

	@FindBy(xpath = "//ul[@id='WorkflowTreeViewId_0']")
	WebElement Clm_MyAction_Section;

	public WebElement Clm_MyAction_Section() {
		return Clm_MyAction_Section;
	}

	@FindBy(xpath = "//ul[@id='WorkflowTreeViewId_0']//a")
	List<WebElement> Clm_MyAction_SubSection;

	public List<WebElement> Clm_MyAction_SubSection() {
		return Clm_MyAction_SubSection;
	}

	@FindBy(xpath = "//div[@id='div_tbl_search']//input")
	WebElement Clm_Myactionstab_Search;

	public WebElement Clm_Myactionstab_Search() {
		return Clm_Myactionstab_Search;
	}

	@FindBy(xpath = "//table[@id='WorkflowQueryTable']//span")
	WebElement Clm_Approver_Viewoption;

	public WebElement Clm_Approver_Viewoption() {
		return Clm_Approver_Viewoption;
	}

	@FindBy(xpath = "//textarea[@id='remarksTemp']")
	WebElement Clm_Approve_Remarks;

	public WebElement Clm_Approve_Remarks() {
		return Clm_Approve_Remarks;
	}

	@FindBy(xpath = "//button[@id='btn_approve']")
	WebElement Clm_WF_Approve;

	public WebElement Clm_WF_Approve() {
		return Clm_WF_Approve;
	}

	@FindBy(xpath = "//button[@id='btn_reject']")
	WebElement Clm_WF_Reject;

	public WebElement Clm_WF_Reject() {
		return Clm_WF_Reject;
	}

	@FindBy(xpath = "//ul[@class='actionMessage']")
	WebElement Clm_WF_msg;

	public WebElement Clm_WF_msg() {
		return Clm_WF_msg;
	}

	@FindBy(xpath = "//table[@id='claimIntmLogGrid']//td[13]//a")
	WebElement Clm_Inti_CLMNO;

	public WebElement Clm_Inti_CLMNO() {
		return Clm_Inti_CLMNO;
	}

	@FindBy(xpath = "//div[@id='ClaimSettlmentSucessDiv']")
	WebElement Clm_Settlement_WF_msg;

	public WebElement Clm_Settlement_WF_msg() {
		return Clm_Settlement_WF_msg;
	}

	@FindBy(xpath = "//table[@id='claimSettlementGrid']//tbody//tr//td[13]//input[1]")
	WebElement Clm_Settlement_Select_CheckBox;

	public WebElement Clm_Settlement_Select_CheckBox() {
		return Clm_Settlement_Select_CheckBox;
	}

	@FindAll({ @FindBy(xpath = "//div[@class='ui-pnotify-text']"), @FindBy(xpath = "//div[@aria-role='alert']") })
	WebElement Clm_Esti_FACApprove_Error;

	public WebElement Clm_Esti_FACApprove_Error() {
		return Clm_Esti_FACApprove_Error;
	}

	@FindBy(xpath = "//input[@id='claimNo']")
	WebElement RI_Allocation_Claim_No;

	public WebElement RI_Allocation_Claim_No() {
		return RI_Allocation_Claim_No;
	}

	@FindBy(xpath = "//input[@id='txt_policyno_facPlace']")
	WebElement RI_Allocation_policy_No;

	public WebElement RI_Allocation_policy_No() {
		return RI_Allocation_policy_No;
	}

	@FindBy(xpath = "//a[@title='Search Claim']")
	WebElement RI_Allocation_Claim_No_Search;

	public WebElement RI_Allocation_Claim_No_Search() {
		return RI_Allocation_Claim_No_Search;
	}

	@FindBy(xpath = "//select[@id='endSrNos']")
	WebElement RI_Allocation_TransType;

	public WebElement RI_Allocation_TransType() {
		return RI_Allocation_TransType;
	}

	@FindBy(xpath = "//button[@id='btn_searchPlacement']")
	WebElement RI_Allocation_TransType_Search;

	public WebElement RI_Allocation_TransType_Search() {
		return RI_Allocation_TransType_Search;
	}

	@FindBy(xpath = "//button[@title='Estimate RI Summary']")
	WebElement Claim_Estimate_RI;

	public WebElement Claim_Estimate_RI() {
		return Claim_Estimate_RI;
	}

	@FindBy(xpath = "//div[@id='propFacAllocationLiId']//button[@id='btn_payDel']")
	WebElement Claims_Estimate_Approve_FAC;

	public WebElement Claims_Estimate_Approve_FAC() {
		return Claims_Estimate_Approve_FAC;
	}

	@FindBy(xpath = "//div[@id='propTreatyAllocationLiId']//button[@id='btn_payDel']")
	WebElement Clm_Esti_App_Tty;

	public WebElement Clm_Esti_App_Tty() {
		return Clm_Esti_App_Tty;
	}

	@FindBy(xpath = "//div[@id='coinsAllocationLiId']//button[@id='btn_payDel']")
	WebElement Claims_Estimate_Approve_Coins;

	public WebElement Claims_Estimate_Approve_Coins() {
		return Claims_Estimate_Approve_Coins;
	}

	@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//tr//td[text()='1']")
	WebElement Clm_1st_estimate;

	public WebElement Clm_1st_estimate() {
		return Clm_1st_estimate;
	}

	@FindBy(xpath = "//table[@id='claimRisksGrid']//tbody//tr//td[1][normalize-space()='1']")
	WebElement Clm_1stRiskinfo_Grid;

	public WebElement Clm_1stRiskinfo_Grid() {
		return Clm_1stRiskinfo_Grid;
	}

	@FindBy(xpath = "(//button[@class='modal-close'])[2]")
	WebElement Clm_Esti_RI_Page_Close;

	public WebElement Clm_Esti_RI_Page_Close() {
		return Clm_Esti_RI_Page_Close;
	}

	@FindBy(xpath = "//table[@id='claimSettlementGrid']//tbody//tr")
	WebElement Clm_setlGrid1;

	public WebElement Clm_setlGrid1() {
		return Clm_setlGrid1;
	}

	@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//tr//td[6]")
	WebElement Clm_Estimate_R1;

	public WebElement Clm_Estimate_R1() {
		return Clm_Estimate_R1;
	}

	@FindBy(xpath = "//ul[@class='actionMessage']//li//span")
	WebElement Clm_Setl_2WF_Msg;

	public WebElement Clm_Setl_2WF_Msg() {
		return Clm_Setl_2WF_Msg;
	}

	@FindBy(xpath = "//table[@id='claimRiFacGrid']//tbody")
	WebElement Clm_FAC_Grid_Table;

	public WebElement Clm_FAC_Grid_Table() {
		return Clm_FAC_Grid_Table;
	}

	@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//tr//td[text()='2']")
	WebElement Clm_2nd_Estimate;

	public WebElement Clm_2nd_Estimate() {
		return Clm_2nd_Estimate;
	}

	@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//tr//td[text()='3']")
	WebElement Clm_3rd_Estimate;

	public WebElement Clm_3rd_Estimate() {
		return Clm_3rd_Estimate;
	}

	@FindBy(xpath="(//i[@title='Revision'])[2]")
	//@FindBy(xpath = "//table[@id='claimEstimatesGrid']//tbody//tr[2]//td[text()='2']//following::td[13]//span//i[@title='Revision']")
	// @FindBy(xpath="//table[@id='claimEstimatesGrid']//tr[2]//td[14]//a[@title='Revision']")
	WebElement Clm_2Esti_Revision;

	public WebElement Clm_2Esti_Revision() {
		return Clm_2Esti_Revision;
	}

	@FindBy(xpath = "//input[@id='revisionEstPayAmount']")
	WebElement Clm_Revise_Payment;

	public WebElement Clm_Revise_Payment() {
		return Clm_Revise_Payment;
	}

	@FindBy(xpath = "//select[@id='reasonToRevise']")
	WebElement Clm_Revise_Reason;

	public WebElement Clm_Revise_Reason() {
		return Clm_Revise_Reason;
	}

	@FindBy(xpath = "//button[normalize-space()='Revise']")
	WebElement Clm_Revise_Save;

	public WebElement Clm_Revise_Save() {
		return Clm_Revise_Save;
	}

	@FindBy(xpath = "//table[@id='claimSettlementGrid']//tbody//tr[1]//td[6]//input[1]")
	WebElement Clm_Revise_Setl;

	public WebElement Clm_Revise_Setl() {
		return Clm_Revise_Setl;
	}

	@FindBy(xpath = "//table[@id='claimSettlementGrid']//tbody//tr[1]//td[6]//input[1]//following::td[7]//input[1]")
	WebElement Clm_Revise_Setl_CheckBox;

	public WebElement Clm_Revise_Setl_CheckBox() {
		return Clm_Revise_Setl_CheckBox;
	}

	@FindBy(xpath = "(//i[normalize-space(@title)='Close Estimate'])[3]")
	WebElement Clm_Esti_Close;

	public WebElement Clm_Esti_Close() {
		return Clm_Esti_Close;
	}

	@FindBy(xpath = "//select[@id='closeReasonCode']")
	WebElement Clm_Esti_Close_Reason;

	public WebElement Clm_Esti_Close_Reason() {
		return Clm_Esti_Close_Reason;
	}

	@FindBy(xpath = "//textarea[@id='closeRemarks']")
	WebElement Clm_Esti_Close_Remarks;

	public WebElement Clm_Esti_Close_Remarks() {
		return Clm_Esti_Close_Remarks;
	}

	@FindBy(xpath = "//button[@onclick='saveClaimsEstCloseInfo();']")
	WebElement Clm_Esti_Close_save;

	public WebElement Clm_Esti_Close_save() {
		return Clm_Esti_Close_save;
	}

	@FindBy(xpath="//input[@id='setlCustCodeAuto']")
	WebElement Clm_Setl_Customer_Code;
	
	public WebElement Clm_Setl_Customer_Code() {
		return Clm_Setl_Customer_Code;
	}
		
	@FindBy(xpath="//span[@id='assured_span']")
	WebElement Clm_Edit_Assured;
	
	public WebElement Clm_Edit_Assured() {
		return Clm_Edit_Assured;
	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}
	
//	@FindBy(xpath="")
//	WebElement ;
//	
//	public WebElement () {
//		return ;
//	}

}
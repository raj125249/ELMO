package org.common;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
//import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends BasicFunctions {
	public static String currentUrl;

	@BeforeSuite
	public void initDriver() throws Exception {

		Robot rb = new Robot();
		//startRecording();

		rb.delay(000);
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--Incognito");
		driver = new ChromeDriver(options);
		// Init Driver // driver = new ChromeDriver(); // Maximize window
		driver.manage().window().maximize();
//		Dimension screenSize = driver.manage().window().getSize();
//        int width = (int) (screenSize.width * 0.9);
//        int height = (int) (screenSize.height * 0.9);
//        driver.manage().window().setSize(new Dimension(width, height));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='90%'");

		// Delete Cookies
		driver.manage().deleteAllCookies();
		// Load URl // driver.get(ReadExcelData.readExcel("Url", 1, 1));

		List<String> urlsToNavigate = new ArrayList<>();

		// Setup to read Excel file
		File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = book.getSheetAt(0);

//		// Reading the data
//		for (Row row : sheet) {
//			Cell flagCell = row.getCell(2);
//			if (flagCell != null && "Y".equalsIgnoreCase(flagCell.getStringCellValue())) {
//				Cell urlCell = row.getCell(1);
//				if (urlCell != null) {
//					urlsToNavigate.add(urlCell.getStringCellValue());
//				}
//			}
//		}

		// Iterate through each row in the sheet
		for (Row row : sheet) {
			// Ensure the row is not null before accessing any cells
			if (row != null) {
				// Access the 'flag' cell (assumed to be at column index 2)
				Cell flagCell = row.getCell(2);

				// Only proceed if the flag cell is not null and has the value 'Y'
				if (flagCell != null && "Y".equalsIgnoreCase(flagCell.getStringCellValue())) {
					// Access the 'URL' cell (assumed to be at column index 1)
					Cell urlCell = row.getCell(1);

					// Ensure the URL cell is not null before adding its value to the list
					if (urlCell != null) {
						// Add the URL to the list
						urlsToNavigate.add(urlCell.getStringCellValue());
					} else {
						System.out.println("URL cell is null for row: " + row.getRowNum());
					}
				}
			}
		}

		fileInputStream.close();

		for (String url : urlsToNavigate) {
			driver.get(url);
		}

		ScreenRecorderUtil.startRecord("main");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		currentUrl = driver.getCurrentUrl();
		
		
	}
			
	@BeforeMethod
    public void beforeEachTestMethod() {
		DriverManager.setDriver(driver);
    }

	@AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed: " + result.getMethod().getMethodName());
        }
    }
	
	@DataProvider(name = "Comm_UW_Login", parallel = true)
	public Object[][] Comm_UW_Login() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Comm_UW_Login");

		return testData;
	}

	@DataProvider(name = "Personal_Login")
	public Object[][] Personal_Login() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Personal_Login");

		return testData;
	}

	@DataProvider(name = "Login_Claims")
	public Object[][] Login_Claims() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Login_Claims");

		return testData;
	}

	@DataProvider(name = "Issue_Policy")
	public Object[][] Issue_Policy() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Issue_Policy");

		return testData;
	}

	@DataProvider(name = "Issue_Policy_Reg", parallel = true)
	public Object[][] Issue_Policy_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Issue_Policy_Reg");

		return testData;
	}

	@DataProvider(name = "Change_in_Policy_Period_Endo")
	public Object[][] Change_in_Policy_Period_Endo() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Change_in_Policy_Period_Endo");

		return testData;
	}

	@DataProvider(name = "Change_in_Policy_Period_Reg")
	public Object[][] Change_in_Policy_Period_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Change_in_Policy_Period_Reg");

		return testData;
	}

	@DataProvider(name = "Reduction_Policy_Period")
	public Object[][] Reduction_Policy_Period() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Reduction_Policy_Period");

		return testData;
	}

	@DataProvider(name = "Reduction_Policy_Period_Reg")
	public Object[][] Reduction_Policy_Period_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Reduction_Policy_Period_Reg");

		return testData;
	}

	@DataProvider(name = "Extension_Policy_Period_Reg")
	public Object[][] Extension_Policy_Period_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Extension_Policy_Period_Reg");

		return testData;
	}

	@DataProvider(name = "Extension_Policy_Period")
	public Object[][] Extension_Policy_Period() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Extension_Policy_Period");

		return testData;
	}

	@DataProvider(name = "Financial_Endorsement")
	public Object[][] Financial_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Financial_Endorsement");

		return testData;
	}

	@DataProvider(name = "Addition_of_SMI_Endorsement")
	public Object[][] Addition_of_SMI_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Addition_of_SMI_Endorsement");

		return testData;
	}
	
	@DataProvider(name = "HS_Endorsements")
	public Object[][] HS_Endorsements() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"HS_Endorsements");

		return testData;
	}
	

	@DataProvider(name = "Addition_of_SMI_Reg")
	public Object[][] Addition_of_SMI_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Addition_of_SMI_Reg");

		return testData;
	}

	@DataProvider(name = "Deletion_of_SMI_Endorsement")
	public Object[][] Deletion_of_SMI_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Deletion_of_SMI_Endorsement");

		return testData;
	}

	@DataProvider(name = "Deletion_of_SMI_Reg")
	public Object[][] Deletion_of_SMI_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Deletion_of_SMI_Reg");

		return testData;
	}

	@DataProvider(name = "Addition_of_Risk_Endorsement")
	public Object[][] Addition_of_Risk_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Addition_of_Risk_Endorsement");

		return testData;
	}

	@DataProvider(name = "Addition_of_Risk_Reg")
	public Object[][] Addition_of_Risk_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Addition_of_Risk_Reg");

		return testData;
	}

	@DataProvider(name = "Change_in_Ownership")
	public Object[][] Change_in_Ownership() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Change_in_Ownership");

		return testData;
	}

	@DataProvider(name = "Deletion_of_Risk_Reg")
	public Object[][] Deletion_of_Risk_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Deletion_of_Risk_Reg");

		return testData;
	}

	@DataProvider(name = "Deletion_of_Risk_Endorsement")
	public Object[][] Deletion_of_Risk_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Deletion_of_Risk_Endorsement");

		return testData;
	}

	@DataProvider(name = "Renewal_Policy")
	public Object[][] Renewal_Policy() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Renewal_Policy");

		return testData;
	}

	@DataProvider(name = "Non_Financial_Endorsement")
	public Object[][] Non_Financial() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Non_Financial_Endorsement");

		return testData;
	}

	@DataProvider(name = "Non_Financial_Endorsement_Reg")
	public Object[][] Non_Financial_Endorsement_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Non_Financial_Endorsement_Reg");

		return testData;
	}

	@DataProvider(name = "Policy_Cancellation")
	public Object[][] Policy_Cancellation() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Policy_Cancellation");

		return testData;
	}

	@DataProvider(name = "Policy_Cancellation_Reg")
	public Object[][] Policy_Cancellation_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Policy_Cancellation_Reg");

		return testData;
	}

	@DataProvider(name = "Policy_Re_Instatement")
	public Object[][] Policy_Re_Instatement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Policy_Re_Instatement");

		return testData;
	}

	@DataProvider(name = "Policy_Re_Instatement_Reg")
	public Object[][] Policy_Re_Instatement_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Policy_Re_Instatement_Reg");

		return testData;
	}

	@DataProvider(name = "Annual_Contract_Certificate")
	public Object[][] Annual_Contract_Works_Certificate() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Annual_Contract_Certificate");

		return testData;
	}

	@DataProvider(name = "Annual_Contract_Certificate_Reg")
	public Object[][] Annual_Contract_Certificate_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Annual_Contract_Certificate_Reg");

		return testData;
	}

	@DataProvider(name = "Change_in_Coinsurance")
	public Object[][] Change_in_Coinsurance() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Change_in_Coinsurance");

		return testData;
	}

	@DataProvider(name = "Discounts_Loadings_Endorsements")
	public Object[][] Discounts_Loadings_Endorsements() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Discounts_Loadings_Endorsements");

		return testData;
	}

	@DataProvider(name = "FAC_Treaty_Endorsement")
	public Object[][] FAC_Treaty_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"FAC_Treaty_Endorsement");

		return testData;
	}

	@DataProvider(name = "MOC_Policy")
	public Object[][] MOC_Policy() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"MOC_Policy");

		return testData;
	}

	@DataProvider(name = "Marine_Hull")
	public Object[][] Marine_Hull() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Marine_Hull");

		return testData;
	}

	@DataProvider(name = "Marine_Individual")
	public Object[][] Marine_Individual() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Marine_Individual");

		return testData;
	}

	@DataProvider(name = "Claims")
	public Object[][] Claims() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Claims");

		return testData;
	}

	@DataProvider(name = "HS_OP")
	public Object[][] HS_OP() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"HS_OP");

		return testData;
	}

	@DataProvider(name = "Policy_Reg")
	public Object[][] Policy_Reg() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Policy_Reg");

		return testData;
	}

	@DataProvider(name = "Condominium")
	public Object[][] Condominium() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Condominium");

		return testData;
	}

	@DataProvider(name = "Marine_Hull_Endorsement")
	public Object[][] Marine_Hull_Endorsement() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Marine_Hull_Endorsement");

		return testData;
	}
	
	@DataProvider(name = "Condominium_Endors")
	public Object[][] Condominium_Endors() {

		Object[][] testData = ReadData.testData(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx",
				"Condominium_Endors");

		return testData;
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
//		driver.close();
//		driver.quit();
		ScreenRecorderUtil.stopRecord();
//		stopRecording();
//		moveRecordingToNewFolder();
		
		//DriverManager.quitDriver();
		
	}
}
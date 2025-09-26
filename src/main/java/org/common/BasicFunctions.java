package org.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicFunctions {

	public static WebDriver driver;
	public static Actions act;
	public static FileInputStream fis = null;
	public static FileOutputStream fos = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;

	public static void textSend(WebElement refName, String textValue) {
		refName.sendKeys(textValue);
	}

	public static void buttonClick(WebElement refName) {
		refName.click();
	}

	public static String getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public static String getAtrributeValue(WebElement refName, String AttributeValue) {
		String attribute = refName.getAttribute(AttributeValue);
		return attribute;
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void implicityWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void mouseOver(WebElement refName) {
		act = new Actions(driver);
		act.moveToElement(refName).perform();
	}

	public static void rightClick(WebElement refName) {
		act = new Actions(driver);
		act.contextClick(refName).perform();
	}

	public static void doubleClick(WebElement refName) {
		act = new Actions(driver);
		act.doubleClick(refName).perform();
	}

	public static void dragAndDrop(WebElement refNameSource, WebElement refNameTarget) {
		act = new Actions(driver);
		act.dragAndDrop(refNameSource, refNameTarget).perform();
	}

	public static void keyPress(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);
	}

	public static void keyRelease(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);
	}

	public static void javaScribtClick(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].click()", element);
	}

	public static void textSendJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].seAttribute('value','+" + data + "+')", element);
	}

	// getAttribute Using JavaScript
	public static void getAttributeJavaScript(WebElement refName) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		Object executeScript = jk.executeScript("return arguments[0].getttribute('value')", refName);
		System.out.println(executeScript);
	}

	// scroll Down using JavaScript
	public static void scrollDownJavaSc(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// scroll Up using JavaScript
	public static void scrollUpJavaSc(Object object) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(false);", object);
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static void promptAlert(String value) {
		Alert text = driver.switchTo().alert();
		text.sendKeys(value);
		text.accept();
	}

	public static void alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
	}

	// Define the extractWorkflowReference method
	public static String extractWorkflowReference(String text) {
		// Regex to find the Workflow Reference No followed by a number
		String regex = "Workflow Reference No (\\d+)";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return matcher.group(1); // Return the first capturing group (the number)
		}
		return "Not found";
	}

	public static void selectByIndex(WebElement refName, int string) {
		Select select = new Select(refName);
		select.selectByIndex(string);
	}

	public static void selectByValue(WebElement refName, String value) {
		Select select = new Select(refName);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement refName, String text) {
		Select select = new Select(refName);
		select.selectByVisibleText(text);
	}

	public static String first_Selected_Value(WebElement refName) {
		Select select = new Select(refName);
		WebElement selectedOption = select.getFirstSelectedOption();
		String selectedOptionText = selectedOption.getText();
		return selectedOptionText;
	}

	public static void retrive_Data(String Query, String Coloumn) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Connection connection =
		// DriverManager.getConnection("jdbc:rhealthprodtest281122:thin:rhealth-test.cqwtcxi6usi5.ap-south-1.rds.amazonaws.com:3306:xe",
		// "rhealthtestuser", "general123$");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://rhealth-test.cqwtcxi6usi5.ap-south-1.rds.amazonaws.com:3306/rhealthprodtest281122",
				"rhealthtestuser", "general123$");
		String query = Query;

		PreparedStatement prepareStatement = connection.prepareStatement(query);

		ResultSet executeQuery = prepareStatement.executeQuery();
		while (executeQuery.next()) {
			String string = executeQuery.getString(Coloumn);
			System.out.println(string);
		}
		connection.close();
	}

	public static String get_DB_Data(String query, String Col_Name) throws IOException, ClassNotFoundException {
		String data = null;
		List<DBCredentials> dbCredentialsList = new ArrayList<>();

		// Load the Excel file
		File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test_Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheetAt(0);

		// Read the data
		for (Row row : sheet) {
			Cell flagCell = row.getCell(2);
			if (flagCell != null && "Y".equalsIgnoreCase(flagCell.getStringCellValue())) {

				String dbUrl = row.getCell(3).getStringCellValue();
				String dbUser = row.getCell(4).getStringCellValue();
				String dbPassword = row.getCell(5).getStringCellValue();
				dbCredentialsList.add(new DBCredentials(dbUrl, dbUser, dbPassword));
			}
		}
		fileInputStream.close();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connect to each database
		for (DBCredentials creds : dbCredentialsList) {
			try (Connection connection = DriverManager.getConnection(creds.getUrl(), creds.getUser(),
					creds.getPassword())) {
				System.out.println("Connected to the database successfully: " + creds.getUrl());

				// Execute the query
				try (PreparedStatement prepareStatement = connection.prepareStatement(query);
						ResultSet executeQuery = prepareStatement.executeQuery()) {
					while (executeQuery.next()) {
						data = executeQuery.getString(Col_Name);

						// System.out.println(string);
					}
				}
			} catch (Exception e) {
				System.out.println("Connection failed: " + e.getMessage());
			}
		}
		return data;
	}

	// Helper class to hold DB credentials
	static class DBCredentials {
		private String url;
		private String user;
		private String password;

		public DBCredentials(String url, String user, String password) {
			this.url = url;
			this.user = user;
			this.password = password;
		}

		public String getUrl() {
			return url;
		}

		public String getUser() {
			return user;
		}

		public String getPassword() {
			return password;
		}
	}

	public static double string_To_double_Convert(String str_Value) {
		String replace = str_Value.replace(",", "");
		double parseDouble = Double.parseDouble(replace);
		return parseDouble;
	}

	public static void webDriverWait(ExpectedCondition<WebElement> ExpectedConditions) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions);
	}

	public static void fluentWait(Class<? extends Throwable> exceptionType,
			Function<? super WebDriver, Object> ExpectedConditions) {
		FluentWait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(exceptionType);
		wait.until(ExpectedConditions);
	}

	public static void SetStatus(String sheetName, int rowNum, String colName, String value) throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\ExcelUtils\\Test Case.xlsx");
		workbook = new XSSFWorkbook(fis);
		fis.close();
		int colNum = -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		for (int i = 1; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				colNum = i;
			}
		}
		row = sheet.getRow(rowNum);
		if (row == null)
			row = sheet.createRow(rowNum);

		cell = row.getCell(colNum);
		if (cell == null)
			cell = row.createCell(colNum);
		cell.setCellValue(value);
		fos = new FileOutputStream(System.getProperty("user.dir") + "\\ExcelUtils\\Test Case.xlsx");
		workbook.write(fos);
		fos.close();
	}

	public static String readExcel(String sheetname, int rowno, int cellno) throws IOException {
		String data = null;
		File file = new File(System.getProperty("user.dir") + "\\ExcelUtils\\Test Case.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			data = dateFormat.format(dateCellValue);
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			data = String.valueOf(l);

		}
		return data;
	}

//randam dates in between the 2dates
	public static Date getRandomDate(Date startDate, Date endDate) {
		// Use Calendar to manipulate the Date objects
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		long startMillis = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long endMillis = calendar.getTimeInMillis();
		// Generate a random time within the range of startMillis and endMillis
		Random random = new Random();
		long randomMillis = startMillis + (long) (random.nextDouble() * (endMillis - startMillis));
		// Return the random Date
		return new Date(randomMillis);
	}

//random date in between 3 dates
	public static String getValidLossDate(String policyStart, String policyEnd, String intimationDate)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date startDate = sdf.parse(policyStart);
		Date endDate = sdf.parse(policyEnd);
		Date intimDate = sdf.parse(intimationDate);
		// Pick the earlier of endDate and intimationDate
		Date latestAllowedDate = endDate.before(intimDate) ? endDate : intimDate;
		long startMillis = startDate.getTime();
		long endMillis = latestAllowedDate.getTime();
		// Generate a random time between startMillis and endMillis
		long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis));
		Date randomDate = new Date(randomMillis);
		return sdf.format(randomDate);
	}

	public static void screenshot(String location) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File defaultLocation = tks.getScreenshotAs(OutputType.FILE);
		System.out.println(defaultLocation);
		FileUtils.copyFile(defaultLocation, new File(location));
	}

//	// Utility method to get checkboxes excluding the "Select All"
//    public static List<WebElement> getValidCheckboxes(WebDriver driver) {
//        // XPath to select all checkboxes inside label that do NOT contain 'Select All' text
//        // This assumes structure: <label><input type='checkbox' /> Some Text </label>
//        List<WebElement> checkboxes = driver.findElements(By.xpath("//label[not(contains(normalize-space(.), 'Select All'))]/input[@type='checkbox']"));
//
//        // If your checkbox and label are structured differently, update the XPath accordingly.
//
//        // Optionally, filter only visible and enabled checkboxes
//        return checkboxes.stream()
//                .filter(WebElement::isDisplayed)
//                .filter(WebElement::isEnabled)
//                .collect(Collectors.toList());
//    }
//
//    // Utility method to click a random checkbox from the list
//    public static void clickRandomCheckbox(List<WebElement> checkboxes) {
//        int randomIndex = new Random().nextInt(checkboxes.size());
//        WebElement checkboxToClick = checkboxes.get(randomIndex);
//        checkboxToClick.click();
//        System.out.println("Clicked checkbox at index: " + randomIndex);
//    }

//	public static void pressWindowsAltRClick() throws Exception {
//		Robot robot = new Robot();
//		 // Press Windows key + Alt key + R key
//		robot.keyPress(KeyEvent.VK_WINDOWS); // Press Windows
//        robot.keyPress(KeyEvent.VK_ALT);   // Press Alt
//        robot.keyPress(KeyEvent.VK_R);  }   // Press R
//
//        public static void pressWindowsAltRRelease() throws Exception {
//    		Robot robot = new Robot();
////        // Release the keys in the reverse order
//        robot.keyRelease(KeyEvent.VK_WINDOWS); // Release Windows
//        robot.keyRelease(KeyEvent.VK_ALT); // Release Alt
//        robot.keyRelease(KeyEvent.VK_R);   // Release R
//	}

//	public static void startRecording() throws Exception {
//		Robot robot = new Robot();
//
//		// Simulate Windows + Alt + R
//		robot.keyPress(KeyEvent.VK_WINDOWS); // Windows key press
//		robot.keyPress(KeyEvent.VK_ALT); // Alt key press
//		robot.keyPress(KeyEvent.VK_R); // R key press
//		robot.keyRelease(KeyEvent.VK_R); // R key release
//		robot.keyRelease(KeyEvent.VK_ALT); // Alt key release
//		robot.keyRelease(KeyEvent.VK_WINDOWS); // Windows key release
//	}
//
//	public static void stopRecording() throws Exception {
//		Robot robot = new Robot();
//
//		// Simulate Windows + Alt + R (to stop recording)
//		robot.keyPress(KeyEvent.VK_WINDOWS); // Windows key press
//		robot.keyPress(KeyEvent.VK_ALT); // Alt key press
//		robot.keyPress(KeyEvent.VK_R); // R key press
//		robot.keyRelease(KeyEvent.VK_R); // R key release
//		robot.keyRelease(KeyEvent.VK_ALT); // Alt key release
//		robot.keyRelease(KeyEvent.VK_WINDOWS); // Windows key release
//	}

	// Function to move the recorded file to your project folder (assuming Xbox Game
	// Bar)
//    public static void moveRecordingToProjectFolder() {
//        // Define the folder paths (adjust these to your system)
//        String captureFolder = System.getProperty("user.dir") + "\\UAT_Elmo_Corporate\\test-recordings";
//        String projectFolder = System.getProperty("user.dir"); // Current working directory (project folder)
//
//        // List all files in the Captures folder
//        File captureDir = new File(captureFolder);
//        if (captureDir.exists() && captureDir.isDirectory()) {
//            File[] files = captureDir.listFiles((dir, name) -> name.endsWith(".mp4")); // Assuming the recording is saved as .mp4
//            if (files != null && files.length > 0) {
//                File lastFile = files[files.length - 1]; // Get the most recent file (the last recorded file)
//
//                // Move the file to the project folder
//                File destination = new File(captureFolder + "\\recording_" + lastFile.getName());
//                if (lastFile.renameTo(destination)) {
//                    System.out.println("Recording moved to: " + destination.getAbsolutePath());
//                } else {
//                    System.out.println("Failed to move the recording.");
//                }
//            } else {
//                System.out.println("No recordings found.");
//            }
//        } else {
//            System.out.println("Capture folder not found.");
//        }
//    }

//	public static void moveRecordingToNewFolder() {
//		// Create a new folder within the project directory
//		String projectFolder = System.getProperty("user.dir") + "\\git\\corporate\\UAT_Elmo_Corporate\\";
//		// Current// working // directory // (project // folder)
//		//String newFolderPath = projectFolder + "Recordings"; // New folder for recordings
//
//		File newFolder = new File(projectFolder);
//		if (!newFolder.exists()) {
//			newFolder.mkdir(); // Create the new folder if it doesn't exist
//			System.out.println("New folder created: " + projectFolder);
//		}
//
//		// Define the folder where Xbox Game Bar stores recordings (adjust as needed for
//		// other tools)
//		String captureFolder = System.getProperty("user.dir") + projectFolder; // Xbox Game Bar default
//
//		File captureDir = new File(captureFolder);
//		if (captureDir.exists() && captureDir.isDirectory()) {
//			// List all files in the Captures folder
//			File[] files = captureDir.listFiles((dir, name) -> name.endsWith(".mp4")); // Assuming .mp4 format
//			if (files != null && files.length > 0) {
//				File lastFile = files[files.length - 1]; // Get the most recent file (the last recorded file)
//
//				// Move the file to the new folder inside the project
//				File destination = new File(projectFolder + "recording_" + lastFile.getName());
//				if (lastFile.renameTo(destination)) {
//					System.out.println("Recording moved to: " + destination.getAbsolutePath());
//				} else {
//					System.out.println("Failed to move the recording.");
//				}
//			} else {
//				System.out.println("No recordings found.");
//			}
//		} else {
//			System.out.println("Capture folder not found.");
//		}
//	}

}
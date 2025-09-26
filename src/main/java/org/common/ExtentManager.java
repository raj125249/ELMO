package org.common;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class ExtentManager extends BasicFunctions {
	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Puneeth");
		extent.setSystemInfo("Organization", "Anoud Technology");
		extent.setSystemInfo("Build No", "DEMO");

		return extent;
	}

	public static String captureScreenshot() throws Exception {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + fileName;
		FileUtils.copyFile(screenshot, new File(path));
		return path;
	}

	// Logs a clean test step (counted as a step)
	public static void logTestStep(ExtentTest test, String stepDescription) {
		test.info(MarkupHelper.createLabel(stepDescription, ExtentColor.BLUE));
	}

	// Logs console output in a collapsible section (not counted as step)
	public static void logConsoleText(ExtentTest test, String consoleText) {
		test.info("<details><summary><b><font color='black'>Console Output: Click to See</font></b></summary><pre>" +
				consoleText + "</pre></details>");
	}

}

//	static ExtentReports extent2 = ExtentManager.createInstance("extentReport.html");
//  static ExtentTest test;

//  public static void main(String[] args) {
//      // Start test
//      test = extent.createTest("Console Log Test");
//
//      // Your console text (can be loaded from a file or String variable)
//      String consoleText = "Login user id: samueld\n"
//              + "Connected to the database successfully: jdbc:oracle:thin:@172.16.45.11:1521/elmprddb\n"
//              + "User Profile Name is: Samuel Debono\n"
//              + "Application log in successful\n"
//              + " ... (rest of your console text) ...";
//
//      // Log entire console text in report as info (HTML tags supported)
//      test.info("<pre>" + consoleText + "</pre>");
//
//      // Flush report to write content to file
//      extent.flush();
//  }

//  ExtentReports extent2 = ExtentManager.createInstance("extentReport.html");
//  ExtentTest test = extent.createTest("Sample Test");
//
//  // Log console text
//  test.info("<pre>" + consoleText + "</pre>");
//
//  // At end of tests
//  extent.flush();
	
//    private void logConsoleTextForTest(ExtentTest test, String consoleText) {
//        // Assuming ExtentManager.logConsoleText handles adding console logs in a formatted way
//        ExtentManager.logConsoleText(test, consoleText);
//    }
//	 private String name;
//
//	    public void SpecializedScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
//	            throws IOException, AWTException {
//	        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
//	        this.name = name;
//	    }
//	    @Override
//	    protected File createMovieFile(Format fileFormat) throws IOException {
//	        if (!movieFolder.exists()) {
//	            movieFolder.mkdirs();
//	        } else if (!movieFolder.isDirectory()) {
//	            throw new IOException("\"" + movieFolder + "\" is not a directory.");
//	        }
//
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
//
//	        return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
//	    }
//}
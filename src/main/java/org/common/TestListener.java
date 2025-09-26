package org.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.output.TeeOutputStream;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {

	static String fileName = "Extent_" + new Date().toString().replace(":", "_").replace(" ", "_") + ".html";
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();
	private static ThreadLocal<ByteArrayOutputStream> consoleBuffer = new ThreadLocal<>();
	private static ThreadLocal<PrintStream> originalSysOut = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
		testReport.set(test);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(new TeeOutputStream(baos, System.out));
		originalSysOut.set(System.out);
		System.setOut(ps);
		consoleBuffer.set(baos);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>TEST CASE PASSED: " + result.getMethod().getMethodName().toUpperCase() + "</b>";
		testReport.get().pass(MarkupHelper.createLabel(logText, ExtentColor.GREEN));

		attachScreenshot();
		logConsoleOutput();
	}

//	public void onTestFailure(ITestResult result) {
//		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//		testReport.get().fail("<details><summary><b><font color='red'>Exception Occurred</font></b></summary>" +
//				exceptionMessage.replace(",", "<br>") + "</details>");
//		attachScreenshot();
//		testReport.get().log(Status.FAIL, MarkupHelper.createLabel("TEST CASE FAILED", ExtentColor.RED));
//		logConsoleOutput();
//	}
	
	public void onTestFailure(ITestResult result) {
	    ExtentTest test = testReport.get();
	    String methodName = result.getMethod().getMethodName();

	    // Log the main test failure step — this is the only step counted
	    String failureText = "<b>TEST CASE FAILED: " + methodName.toUpperCase() + "</b>";
	    Markup failureMarkup = MarkupHelper.createLabel(failureText, ExtentColor.RED);
	    test.log(Status.FAIL, failureMarkup);

	    // Log the exception in collapsible format (not counted as step)
	    Throwable throwable = result.getThrowable();
	    if (throwable != null) {
	        String exceptionDetails = Arrays.toString(throwable.getStackTrace()).replace(",", "<br>");
	        test.info("<details><summary><b><font color='red'>Exception Occurred: Click to See</font></b></summary><pre>" 
	                + exceptionDetails + "</pre></details>");
	    }
	    
	    try {
	    	WebDriver driver = DriverManager.getDriver();
	        if (driver != null) {
	            String currentUrl = driver.getCurrentUrl();
	            test.info("<b>Failure Page URL:</b> <a href='" + currentUrl + "' target='_blank'>" + currentUrl + "</a>");
	        } else {
	            test.warning("WebDriver instance is null, cannot capture current URL");
	        }
	    } catch (Exception e) {
	        test.warning("Failed to capture current URL: " + e.getMessage());
	    }
 
	    try {
	    	WebDriver driver = DriverManager.getDriver();
	        if (driver != null) {
	            byte[] pageSource = driver.getPageSource().getBytes(StandardCharsets.UTF_8);
	            test.info("Page source at failure:<br><pre>" + pageSource + "</pre>");
	        }
	    } catch (Exception e) {
	        test.warning("Failed to capture page source: " + e.getMessage());
	    }
	    
	    
	    // Attach screenshot (as info, not counted as step)
	    attachScreenshot();
	    // Log captured console output (as HTML, not counted as step)
	    logConsoleOutput();
	}
		
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>TEST CASE SKIPPED: " + result.getMethod().getMethodName().toUpperCase() + "</b>";
		testReport.get().skip(MarkupHelper.createLabel(logText, ExtentColor.ORANGE));
		logConsoleOutput();
	}

	public void onFinish(ITestContext context) {
		if (extent != null) extent.flush();
	}

	// Utility to attach screenshot without incrementing step count
	private void attachScreenshot() {
		try {
			String screenshotPath = ExtentManager.captureScreenshot();
			testReport.get().info("Screenshot:",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			testReport.get().warning("Failed to attach screenshot: " + e.getMessage());
		}
	}

	// Logs console output after each test
	private void logConsoleOutput() {
		if (originalSysOut.get() != null) System.setOut(originalSysOut.get());

		ByteArrayOutputStream baos = consoleBuffer.get();
		if (baos != null) {
			String consoleText = baos.toString().trim();
			if (!consoleText.isEmpty()) {
				ExtentManager.logConsoleText(testReport.get(), consoleText);
			}
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	}

}
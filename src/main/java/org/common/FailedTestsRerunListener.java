package org.common;

import java.io.File;
import java.util.Collections;
import org.testng.IExecutionListener;
import org.testng.TestNG;

public class FailedTestsRerunListener implements IExecutionListener {
	@Override
	public void onExecutionStart() {
		System.out.println("TestNG execution started");
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("TestNG execution finished");
		// Path to the failed tests XML file
		String failedTestXML = "test-output/testng-failed.xml";

		File failedXMLFile = new File(failedTestXML);
		if (failedXMLFile.exists() && failedXMLFile.length() > 0) {
			System.out.println("Failed test XML found. Rerunning failed tests...");
			TestNG testng = new TestNG();
			testng.setTestSuites(Collections.singletonList(failedTestXML));
			testng.run();
		} else {
			System.out.println("No failed tests detected, no rerun needed.");
		}
	}
}

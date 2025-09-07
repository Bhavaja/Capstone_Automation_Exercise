package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void startTest(String testName, String description) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest(testName, description);
        extentTest.set(test);
    }

    public static void endTest() {
        ExtentManager.getInstance().flush();
    }

}

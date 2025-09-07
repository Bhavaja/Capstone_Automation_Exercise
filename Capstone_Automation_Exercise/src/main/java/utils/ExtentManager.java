package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

    // This method will create and return the ExtentReports instance
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    // Create the ExtentReports object and attach reporter
    private static void createInstance() {
        try {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
            spark.loadXMLConfig("C:\\Users\\bhava\\eclipse-workspace\\Capstone_Automation_Exercise\\src\\test\\resources\\extent-config.xml");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Set system info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Bhavaja");
            extent.setSystemInfo("Browser", "Chrome");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

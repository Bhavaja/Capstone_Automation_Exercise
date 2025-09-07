package listeners;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.ScreenshotUtil;


public class ExtentTestListener implements ITestListener{
	
	ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // To get WebDriver from your test classes dynamically
    private WebDriver getDriver(ITestResult result) {
        Object testClass = result.getInstance();
        Class<?> clazz = testClass.getClass();
        while (clazz != null) { // loop through class hierarchy
            try {
                Field driverField = clazz.getDeclaredField("driver");
                driverField.setAccessible(true);
                return (WebDriver) driverField.get(testClass);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass(); // check parent class
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return null;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = getDriver(result);
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().log(Status.PASS, "Test Passed")
              .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriver(result);
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable())
              .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver driver = getDriver(result);
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().log(Status.SKIP, "Test Skipped")
              .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

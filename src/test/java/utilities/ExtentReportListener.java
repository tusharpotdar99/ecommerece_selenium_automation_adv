package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    ExtentReports extentReports =
            ExtentReportManager.createReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        test = extentReports.createTest(testName);

        test.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extentReports.flush();
    }
}
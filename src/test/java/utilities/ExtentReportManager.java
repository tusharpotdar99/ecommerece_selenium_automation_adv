package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports createReport() {

        String reportPath = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportPath);

        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Selenium Automation Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        ExtentReports extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);

        extentReports.setSystemInfo("Tester", "Tushar");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");

        return extentReports;
    }
}
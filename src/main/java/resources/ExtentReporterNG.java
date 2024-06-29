package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{
    public static ExtentReports getReportObject()
    {
        String reportPath = System.getProperty("user.dir") +"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Ctruh Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports eReports = new ExtentReports();
        eReports.attachReporter(reporter);
        eReports.setSystemInfo("Tester","Arunprasadh");
        eReports.setSystemInfo("OS","Windows-10");
        eReports.setSystemInfo("Browser","Chrome");
        eReports.createTest(reportPath);
        return eReports;
    }

}

package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ExtentReportManager{

    public static ExtentReports extentReports;
    public static ExtentReports createInstance(String filePath, String reportName, String documentTitle){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportNameWithTimeStamp(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        String formattedTime = customFormat.format(currentDate);
        String reportName = "TestReport"+formattedTime+".html";
        return reportName;
    }

    //report custom logging (for making more presentive)
    public static void logPassDetails(String log){
        SetupForReport.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailureDetails(String log){
        SetupForReport.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logExceptionDetails(String log){
        SetupForReport.extentTest.get().fail(log);
    }
    public static void logInfoDetails(String log){
        SetupForReport.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log){
        SetupForReport.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
    public static void logJson(String json){
        SetupForReport.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    public static void logHeaders(List<Header> headersList){
        //changing header key-value pair to two dimensional string array
        String [][] arrayHeaders = headersList.stream().
            map(header -> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
        SetupForReport.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }

}

package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class SetupForReport implements ITestListener{

    private static ExtentReports extentReports;
    //ThreadLocal is used to keep execution separately when run in parallel
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context){
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir")+"\\reports\\"+fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "Test_API_Auto_Report",
                "Test ExecutionReport");
    }
    public void onFinish(ITestContext context){
        if(extentReports!=null)
            extentReports.flush();

    }

    //overriding below onTestStart which is present inside ITestListener interface
    //Also, below method will run automatically when @Test annotated method starts execution

    public void onTestStart(ITestResult result){
        //below method is used to display the testcase package and method name in the report
        ExtentTest test = extentReports.createTest("Test Name "+result.getClass().getName()
                +" - "+result.getMethod().getMethodName());

        //Setting up the ThreadLocal
        extentTest.set(test);
        //so using above we have set it for a thread(i.e for a Test case under execution)
    }

    public void onTestFailure(ITestResult result){
        //printing the error code message
        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());

        //adding a button in the report, on clicking of which will open details error log
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",","<br>");
        String formattedTrace = "<details>\n" +
                "  <summary>Click here to view Log Details</summary>\n" +
                "  "+stackTrace+"\n" +
                "</details>\n";
        ExtentReportManager.logExceptionDetails(formattedTrace);
    }

}

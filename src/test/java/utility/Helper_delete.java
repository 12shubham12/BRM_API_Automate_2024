package utility;

import api.endpoints.BaseClass;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Helper_delete extends BaseClass{

    static FileReader fr;   //reads the file
    static BufferedReader br;  //creates a buffering character input stream
    static StringBuffer sb;    //constructs a string buffer with no characters
    public static String line, BAno, cusID,MSISDNSP,MSISDN, MSISDN2,rchg_amt,SA_Pre_Malay, pkgName,PkgName,
            unique_ID, SA_Pre_MYLSIM, SA_Pre_SP,MSISDN_New,OldpkgName,unique_ID2,MSISDN_Loan,CUSID_LOAN,LRID;
    public static Random random = new Random();

    public static String getCurrentDateTime(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }

    public static String getSystemDateTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss", Locale.ENGLISH);
        String formatted = format1.format(cal.getTime());
        return formatted;
    }

//Function to read the details from excel and return payload for createSA_Pre_Malay
    public static String readPayload_Pre_SA(String f1,String val1,String f2,String val2,String f3,String val3,
                                            String f4,String val4,String f5, String val5,String f6,String val6,String f7,
                                            String f8,String val8,String f9, String val9) throws IOException {

        File file = new File(BaseClass.config.getPrepaidCreateSAXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String createSA_Pre_Malay_Payload = sb.toString().replaceAll(f1, SA_Pre_Malay = val1 + random.nextInt())
                .replaceAll(f2, val2 + random.nextInt())
                .replaceAll(f3, val3)
                .replaceAll(f4, val4)
                .replaceAll(f5, MSISDN2 = val5 +""+ random.nextInt())
                .replaceAll(f6, val6 +""+ random.nextInt())
                .replaceAll(f7, MSISDN2)
                .replaceAll(f8, val8)
                .replaceAll(f9, val9);

        return createSA_Pre_Malay_Payload;
    }

//Function to read the details from excel and return payload for createSA_Pre_Malay_Loan
    public static String readPayload_Pre_SA_Loan(String f1,String val1,String f2,String val2,String f3,String val3,
                                                 String f4,String val4,String f5, String val5,String f6,String val6,String f7,
                                                 String f8,String val8,String f9, String val9) throws IOException {

        File file = new File(BaseClass.config.getPrepaidCreateSAXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String createSA_Pre_Malay_Payload_Loan = sb.toString().replaceAll(f1, val1 + random.nextInt())
                .replaceAll(f2, CUSID_LOAN=val2 + random.nextInt())
                .replaceAll(f3, val3)
                .replaceAll(f4, val4)
                .replaceAll(f5, MSISDN_Loan = val5 +""+ random.nextInt())
                .replaceAll(f6, val6 +""+ random.nextInt())
                .replaceAll(f7, MSISDN_Loan)
                .replaceAll(f8, val8)
                .replaceAll(f9, val9);

        return createSA_Pre_Malay_Payload_Loan;
    }

//Function to return payload for request loan
    public static String requestLoan_Pre(String f1, String val1, String f2, String val2,
                                         String f3, int val3) throws IOException {

        File file = new File(BaseClass.config.getreqLoanXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String reqLoan_Pre_Payload= sb.toString().replaceAll(f1, MSISDN_Loan)
                .replaceAll(f2, LRID=val2+""+ random.nextInt())
                .replaceAll(f3, String.valueOf(val3));

        return reqLoan_Pre_Payload;
    }

//Function to return payload for CreateSA_MY_LSIM
public static String readPayload_Pre_SA_MY_LSIM(String f1,String val1,String f2,String val2,String f3,String val3,
                                                String f4,String val4,String f5, String val5,String f6,String f7,
                                                String val7,String f8,String val8,String f9, String val9,
                                                String f10,String val10) throws IOException {

    File file = new File(BaseClass.config.getPrepaidCreateSA_MY_LSIM_XMLFile());
    fr = new FileReader(file);
    br = new BufferedReader(fr);
    sb = new StringBuffer();
    {
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    while ((line = br.readLine()) != null) {
        sb.append(line);      //appends line to string buffer
        sb.append("\n");     //line feed
    }
    fr.close();

    String createSA_Pre_MY_LSIM_Payload = sb.toString().replaceAll(f1, SA_Pre_MYLSIM = val1 + random.nextInt())
            .replaceAll(f2, val2 + random.nextInt())
            .replaceAll(f3, val3)
            .replaceAll(f4, MSISDN = val4 +""+ random.nextInt())
            .replaceAll(f5, val5 +""+ random.nextInt())
            .replaceAll(f6, MSISDN)
            .replaceAll(f7, val7)
            .replaceAll(f8, val8)
            .replaceAll(f9, val9)
            .replaceAll(f10, val10);

    return createSA_Pre_MY_LSIM_Payload;
}

//Function to return payload for Recharge_Pre_Malay
    public static String readPayload_Recharge(String f1,String f2,String val2,String f3, double val3,
                                          String f4, String val4, String f5, double val5,
                                          String f6, double val6) throws IOException {

        File file = new File(BaseClass.config.getRechargeXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String RCHG_Pre_Malay_Payload= sb.toString().replaceAll(f1, MSISDN2)
                .replaceAll(f2, val2)
                .replaceAll(f3, rchg_amt=String.valueOf((int)val3)) //to convert double to int and then to String
                .replaceAll(f4, val4)
                .replaceAll(f5, String.valueOf((int)val5))
                .replaceAll(f6, String.valueOf((int)val6));

        return RCHG_Pre_Malay_Payload;
    }

    public static String readPayload_MultipleOff_Pre(String f1,String val1,String f2,String val2,String f3, String val3,
                                                      String f4, double val4, String f5, String val5, String f6, String val6,
                                                      String f7, double val7, String f8, String val8)
                                                      throws IOException {

        File file = new File(BaseClass.config.getPurSingleOfferXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String PurMultipleOff_Pre_Malay_Payload= sb.toString().replaceAll(f1, SA_Pre_Malay)
                .replaceAll(f2, MSISDN2)
                .replaceAll(f3, pkgName=val3)
                .replaceAll(f4, unique_ID=String.valueOf((int)val4))
                .replaceAll(f5, val5)
                .replaceAll(f6, PkgName=val6)
                .replaceAll(f7, unique_ID2=String.valueOf(val7))
                .replaceAll(f8, val8);

        return PurMultipleOff_Pre_Malay_Payload;
    }

//Function to read the details from excel and return payload for Change Single Offer
    public static String readPayload_ChgSingleOff_Pre(String f1,String val1,String f2,String val2,
                                                      String f3, String val3, String f4, String val4,
                                                      String f5, String val5, String f6, double val6,
                                                      String f7, String val7)
            throws IOException {

        File file = new File(BaseClass.config.getChgSingleOfferXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String ChgSingleOff_Pre_Malay_Payload= sb.toString().replaceAll(f1, SA_Pre_Malay)
                .replaceAll(f2, MSISDN2)
                .replaceAll(f3, PkgName)
                .replaceAll(f4, val4)
                .replaceAll(f5, val5)
                .replaceAll(f6, String.valueOf(val6))
                .replaceAll(f7, val7);

        return ChgSingleOff_Pre_Malay_Payload;
    }

//Function to read the details from excel and return payload for cancel Single offer
    public static String readPayload_CanSingleOff_Pre(String f1,String val1,String f2,String val2,
                                                      String f3, String val3, String f4, String val4,
                                                      String f5, String val5, String f6, double val6)
            throws IOException {

        File file = new File(BaseClass.config.getCanSingleOfferXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String CanSingleOff_Pre_Malay_Payload= sb.toString().replaceAll(f1, SA_Pre_Malay)
                .replaceAll(f2, MSISDN2)
                .replaceAll(f3, pkgName)
                .replaceAll(f4, val4)
                .replaceAll(f5, unique_ID)
                .replaceAll(f6, String.valueOf((int)val6));

        return CanSingleOff_Pre_Malay_Payload;
    }

//Function to read the details from excel and return payload for createSA_Pre_SP
    public static String readPayload_PreSA_SP(String f1,String val1,String f2,String val2,
                                              String f3, String val3,String f4,String val4,String f5,
                                              String f6,String val6,String f7, String val7) throws IOException {

        File file = new File(BaseClass.config.getPrepaidCreateSA_SP_XMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String createSA_Pre_SP_Payload = sb.toString().replaceAll(f1, SA_Pre_SP = val1+""+random.nextInt())
                .replaceAll(f2, val2 + random.nextInt())
                .replaceAll(f3, MSISDNSP = val3 +""+ random.nextInt())
                .replaceAll(f4, val4 +""+ random.nextInt())
                .replaceAll(f5, MSISDNSP)
                .replaceAll(f6, val6)
                .replaceAll(f7, val7);

        return createSA_Pre_SP_Payload;
    }
//Function to return payload for update Service Preference Pre SP
    public static String updateSrvPref_SP_Pre(String f1,String f2, double val2, String f3, double val3,
                                              String f4, String val4, String f5, String val5) throws IOException {

        File file = new File(BaseClass.config.getupdateSrvPref_SPXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String updateSrvPref_SP_Pre_Payload= sb.toString().replaceAll(f1, MSISDNSP)
                .replaceAll(f2, String.valueOf(val2))
                .replaceAll(f3, String.valueOf(val3))
                .replaceAll(f4, MSISDN_New=MSISDNSP+"1")
                .replaceAll(f5, val5);

        return updateSrvPref_SP_Pre_Payload;
    }

//Function to return payload for update Address Pre SP
    public static String updateAdd_SP_Pre(String f1, String val1, String f2, String val2) throws IOException {

        File file = new File(BaseClass.config.getupdateAdd_SPXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String updateAdd_SP_Pre_Payload= sb.toString().replaceAll(f1, val1)
                .replaceAll(f2, val2);

        return updateAdd_SP_Pre_Payload;
    }

//Function to return payload for update Acc Profile Pre SP
    public static String updateAccProf_SP_Pre(String f1, String val1, String f2, String val2) throws IOException {

        File file = new File(BaseClass.config.getupdateAccProf_SPXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String updateAccProf_SP_Pre_Payload= sb.toString().replaceAll(f1, val1)
                .replaceAll(f2, val2);

        return updateAccProf_SP_Pre_Payload;
    }

//Function to return payload for update Service Status
    public static String updateSrvStatus_Pre(String f1, String val1, String f2, String val2,
                                             String f3, int val3, String f4, int val4) throws IOException {

        File file = new File(BaseClass.config.getupdateSrvStatusXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String updateSrvStatus_Pre_Payload= sb.toString().replaceAll(f1, MSISDN)
                .replaceAll(f2, val2)
                .replaceAll(f3, String.valueOf(val3))
                .replaceAll(f4, String.valueOf(val4));

        return updateSrvStatus_Pre_Payload;
    }
//Function to return payload for update Service Status Loan
    public static String updtSrvSts_Pre_Loan(String f1, String val1, String f2, String val2,
                                             String f3, int val3, String f4, int val4) throws IOException {

        File file = new File(BaseClass.config.getupdateSrvStatusXMLFile());
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String updtSrvSts_Loan_Pre_Payload= sb.toString().replaceAll(f1, MSISDN_Loan)
                .replaceAll(f2, val2)
                .replaceAll(f3, String.valueOf(val3))
                .replaceAll(f4, String.valueOf(val4));

        return updtSrvSts_Loan_Pre_Payload;
    }

    //this method is used for logging the details in the report
    //print request details
    public static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification =
                SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("EndPoint URL is "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logJson("Request Body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }
    //print response details
    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is "+response.getStatusCode());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logJson("Request Body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
}

package testcases;

import endpoints.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.Helper_delete;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class PurchaseMultipleOffer_Pre extends Helper_delete{

    static String pkgID,PkgID;
    static double d,user_id;

    public static Response performMultiple_PO_Pre(String endPoint, Map<String,String> headers) throws IOException {

        RequestSpecification requestSpecification= RestAssured.given().log().all().
                baseUri(endPoint).
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                body(readPayload_MultipleOff_Pre("SA_Pre_Malay", SA_Pre_Malay,
                        "MSISDN", MSISDN2,
                        "Pkg_Name", BaseClass.excel.
                                getPurMultipleOff_Pre_Details("purchaseMultipleOffer_Pre", 1, 0),
                        "UniqueId", BaseClass.excel.
                                getPurMultipleOff_NumericDetail("purchaseMultipleOffer_Pre", 1, 1),
                        "Bundle_Name", BaseClass.excel.
                                getPurMultipleOff_Pre_Details("purchaseMultipleOffer_Pre", 1, 2),
                        "PkgName2", BaseClass.excel.
                                getPurMultipleOff_Pre_Details("purchaseMultipleOffer_Pre", 1, 3),
                        "UniqueID2", BaseClass.excel.
                                getPurMultipleOff_NumericDetail("purchaseMultipleOffer_Pre", 1, 4),
                        "BundleName2", BaseClass.excel.
                                getPurMultipleOff_Pre_Details("purchaseMultipleOffer_Pre", 1, 5)));

        Response response = requestSpecification.put("/account/purchaseOffer");

        //adding below 3 lines to print the details in report
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        /*String response_String = response.asString();
        ExcelData_Writer.writeToExcelSheet(response_String, "Create_PreSA_Malay"); */

        //to save the response in json file
        String responseAsString = response.asString();

        String[] responseAsStringArray = responseAsString.split(",");
        File targetFileForString = new File("./ResponseFiles/api_data"+ "MultiplePurOffPre_Malay"
                +Helper_delete.getCurrentDateTime()+".json");

        //to get the packageId from response of purchaseOffer
        pkgID = responseAsStringArray[5].substring(12,17);
        PkgID= responseAsStringArray[24].substring(12,17);

        Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));
        return response;
    }
}

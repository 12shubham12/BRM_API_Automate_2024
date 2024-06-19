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

import static testcases.PurchaseMultipleOffer_Pre.PkgID;

public class ChgSingleOff_Pre extends Helper_delete{

    public static Response performSingle_CHGO_Pre(String endPoint, Map<String,String> headers) throws IOException {

        RequestSpecification requestSpecification= RestAssured.given().log().all().
                baseUri(endPoint).
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                body(readPayload_ChgSingleOff_Pre("SA_Pre_Malay", SA_Pre_Malay,
                        "MSISDN", MSISDN2,
                        "OldPackageName", PkgName,
                        "Package_Id", PkgID,
                        "NewPackage", BaseClass.excel.
                                getChgSingleOff_Pre_Details("chgSingleOffer_Pre", 1, 0),
                        "UniqID", BaseClass.excel.
                                getChgSingleOff_NumericDetail("chgSingleOffer_Pre", 1, 1),
                       "NewBundle", BaseClass.excel.
                                getChgSingleOff_Pre_Details("chgSingleOffer_Pre", 1, 2)));

        Response response = requestSpecification.put("/account/changeOffer");

        //adding below 3 lines to print the details in report
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        /*String response_String = response.asString();
        ExcelData_Writer.writeToExcelSheet(response_String, "Create_PreSA_Malay"); */

        String responseAsString = response.asString();

        String[] responseAsStringArray = responseAsString.split(",");
        File targetFileForString = new File("./ResponseFiles/api_data"+ "ChgSingleOffPre_Malay"
                +Helper_delete.getCurrentDateTime()+".json");


        Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));
        return response;
    }
}

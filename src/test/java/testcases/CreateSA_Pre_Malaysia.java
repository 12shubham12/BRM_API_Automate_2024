package testcases;

import api.endpoints.BaseClass;
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


public class CreateSA_Pre_Malaysia extends Helper_delete{

    public static Response createPreSA_maly(String endPoint,Map<String,String> headers) throws IOException {
        RequestSpecification requestSpecification =
         RestAssured.given().log().all().
                baseUri(endPoint).
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                body(readPayload_Pre_SA("PRE_SA", BaseClass.excel.
                                getPre_SA_No("Pre_SA_Details",1,0),
                        "CID", BaseClass.excel.getPre_SA_No("Pre_SA_Details",1,1),
                        "date1", getSystemDateTime(),
                        "date2", getSystemDateTime(),
                        "MSISDN1", "6016", "IMSI", "9812","MSISDN2",
                        "Package", BaseClass.excel.getPre_SA_No("Pre_SA_Details",1,2),
                        "Bundle", BaseClass.excel.getPre_SA_No("Pre_SA_Details",1,3)));

                Response response = requestSpecification.post("/account/createSubscriber");
                //adding below 3 lines to print the details in report
                printRequestLogInReport(requestSpecification);
                printResponseLogInReport(response);
                /*String response_String = response.asString();
                ExcelData_Writer.writeToExcelSheet(response_String, "Create_PreSA_Malay");
                 */
                String responseAsString = response.asString();

                String[] responseAsStringArray = responseAsString.split(",");
                File targetFileForString = new File("./ResponseFiles/api_data"+"CreateSA_Pre_Malay"
                        +Helper_delete.getCurrentDateTime()+".json");

                Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));
                return response;
    }
}

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


public class CreateSA_Pre_SP extends Helper_delete{

    static String SA_SP;

    public static Response createPreSA_SP(String endPoint,Map<String,String> headers) throws IOException {
        RequestSpecification requestSpecification =
         RestAssured.given().log().all().
                baseUri(endPoint).
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                body(readPayload_PreSA_SP("SA_Pre_SP", BaseClass.excel.
                                getPre_SA_No("Pre_SA_SP",1,0),
                        "CUSTIDSP", BaseClass.excel.getPre_SA_No("Pre_SA_SP",1,1),
                        "MSISDN", "6016", "IMSI", "9812","MSISDN",
                        "Package", BaseClass.excel.getPre_SA_No("Pre_SA_SP",1,2),
                        "Bundle", BaseClass.excel.getPre_SA_No("Pre_SA_SP",1,3)));

                Response response = requestSpecification.post("/account/createSubscriber");
                //adding below 3 lines to print the details in report
                printRequestLogInReport(requestSpecification);
                printResponseLogInReport(response);
                /*String response_String = response.asString();
                ExcelData_Writer.writeToExcelSheet(response_String, "Create_PreSA_Malay");
                 */
                String responseAsString = response.asString();

                String[] responseAsStringArray = responseAsString.split(",");
                File targetFileForString = new File("./ResponseFiles/api_data"+"CreateSA_Pre_SP"
                        +Helper_delete.getCurrentDateTime()+".json");

                
                Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));
                return response;
    }
}

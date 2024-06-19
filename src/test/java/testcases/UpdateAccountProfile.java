package testcases;

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

public class UpdateAccountProfile extends Helper_delete{

    public static Response updateAccProfSP_Pre(String endPoint, Map<String,String> headers) throws IOException {

        RequestSpecification requestSpecification= RestAssured.given().log().all().
                baseUri(endPoint).
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                body(updateAccProf_SP_Pre("SA_PRE_SP", SA_Pre_SP,
                        "Rdate", Helper_delete.getSystemDateTime()));

                Response response = requestSpecification.put("/account/updateAccountProfile");

        //adding below 3 lines to print the details in report
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        /*String response_String = response.asString();
        ExcelData_Writer.writeToExcelSheet(response_String, "Create_PreSA_Malay"); */

        String responseAsString = response.asString();

        String[] responseAsStringArray = responseAsString.split(",");
        File targetFileForString = new File("./ResponseFiles/api_data"+ "updateAccProf_SP_Pre"
                +Helper_delete.getCurrentDateTime()+".json");

        Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));
        return response;
    }
}

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

import static utility.Helper_delete.*;

public class GetAccInfo_Pre_Malay {
    public static Response getAccInfoPre_Malay(String endPoint, Map<String,String> headers) throws IOException {
        RequestSpecification requestSpecification = RestAssured.given().
                headers("X-Telenor-CorrelationId", Helper_delete.getCurrentDateTime(),
                        "X-Telenor-SystemIdentifier", "BRM").
                contentType(ContentType.JSON).
                baseUri(endPoint).
                when();
        Response response = requestSpecification.get("/account/getAccountInfo?dataListOption=All&msisdn="+MSISDN2);

        //adding below 3 lines to print the details in report
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        /*String response_String = response.asString();
        ExcelData_Writer.writeToExcelSheet(response_String, "AccInfoPre_malay");
        */
        String responseAsString = response.asString();

        String[] responseAsStringArray = responseAsString.split(",");
        File targetFileForString = new File("./ResponseFiles/api_data"+"getAccInfo_Pre_Malay"
                +Helper_delete.getCurrentDateTime()+".json");

        Files.write(targetFileForString.toPath(), List.of(responseAsStringArray));

        return response;
    }
}

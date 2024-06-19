package testcases;

import endpoints.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Helper;

import java.io.IOException;

import static io.restassured.RestAssured.with;
import static utility.Helper.*;


public class Create_SA_Post extends BaseClass {

    //Method to create SA after reading data from excel
    @Test(invocationCount = 1)
    public void createSAPost() throws IOException {

        Response response = with().
                body(Helper.readPayload_Post_SA("POST_SA", BaseClass.excel.
                                getPost_SA_No("Post_SA_Details", 0, 0),
                        "BA", BAno, "CID", cusID, "date1", getSystemDateTime(),
                        "date2", getSystemDateTime(),
                        "MSISDN1", "6016", "IMSI", "9812", "MSISDN2",
                        "Package", BaseClass.excel.getPost_SA_No("Post_SA_Details", 0, 1),
                        "Bundle", BaseClass.excel.getPost_SA_No("Post_SA_Details", 0, 2))).
                post("/account/createSubscriber");

        //Not sure how to validate SA number
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
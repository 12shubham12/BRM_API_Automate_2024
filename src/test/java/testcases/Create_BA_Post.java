package testcases;

import endpoints.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Helper;

import java.io.IOException;

import static io.restassured.RestAssured.with;

public class Create_BA_Post extends BaseClass {

    //Method to create BA after reading data from excel
    @Test(invocationCount = 1)
    public void createBA() throws IOException {

        Response response = with().
        body(Helper.readPayload_BA("BA", BaseClass.excel.getBA_No("BA_Detail",0,0), "CID", BaseClass.excel.getCID_No("BA_Detail",0,1))).
        post("/account/createAccount");

        //Not sure how to validate BA number
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}

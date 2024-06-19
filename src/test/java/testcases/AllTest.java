package testcases;

import endpoints.BaseClass;
import endpoints.EndPointURLs;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static utility.Helper_delete.MSISDN2;
import static utility.Helper_delete.rchg_amt;

public class AllTest extends BaseClass {

    @Test(priority = 1)
    public void createSA_Pre_Malay() throws IOException {
        Response response = CreateSA_Pre_Malaysia.createPreSA_maly(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void createPreSA_maly_LSIM() throws IOException {
        Response response = CreateSA_Pre_Malaysia_LooseSIM.createPreSA_MY_LSIM(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void recharge_Vouch_Malay() throws IOException {
        Response response = RechargeVoucher_Malay.performRecharge(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
        //To validate other values in the response
        response.then().body("msisdn", equalTo(MSISDN2))
                       .body("actualAmount", equalTo(Math.negateExact(Integer.parseInt(rchg_amt))));
        //Method: Math.negateExact() is used as in response we get actualAmount as -25 and rchg_amt is +25
    }
    @Test(priority = 4)
    public void getBal_Pre_Malay() throws IOException {
        Response response = Getbalances_Pre_Malay.getBalPre_Malay(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 5)
    public void getAccinfo_pre_Malay() throws IOException {
        Response response = GetAccInfo_Pre_Malay.getAccInfoPre_Malay(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 6)
    public void performMultiple_PO_Pre() throws IOException {
        Response response = PurchaseMultipleOffer_Pre.performMultiple_PO_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 12)
    public void performSingle_CHGO_Pre() throws IOException {
        Response response = ChgSingleOff_Pre.performSingle_CHGO_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 7)
    public void performSingle_CANO_Pre() throws IOException {
        Response response = CanSingleOff_Pre.performSingle_CANO_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 8)
    public void createPreSA_SP() throws IOException {
        Response response = CreateSA_Pre_SP.createPreSA_SP(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 9)
    public void updateSrvPrefSP_Pre() throws IOException {
        Response response = updateServicePreferenceSP_Pre.updateSrvPrefSP_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 10)
    public void updateAddressSP_Pre() throws IOException {
        Response response = UpdateAddresses.updateAddSP_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 11)
    public void updateAccProfSP_Pre() throws IOException {
        Response response = UpdateAccountProfile.updateAccProfSP_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 13)
    public void updateSrvStsTo116_Pre() throws IOException {
        Response response = UpdateServiceStsToActv.updateSrvStsToActv_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 14)
    public void updateSrvStsTo117_Pre() throws IOException {
        Response response = UpdateServiceStsToBarred.updateSrvStsToBar_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 15)
    public void updateSrvStsTo118_Pre() throws IOException {
        Response response = UpdateServiceStsToSuspnd.updateSrvStsToSuspnd_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 16)
    public void updateSrvStsTo120_Pre() throws IOException {
        Response response = UpdateServiceStsToBlock.updateSrvStsToBlock_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 17)
    public void updateSrvStsTo116From120_Pre() throws IOException {
        Response response = UpdateSrvStsBlockToActv.updateSrvStsToReActv_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 18)
    public void createPreSA_Maly_Loan() throws IOException {
        Response response = CreateSA_Pre_Malay_Loan.createPreSA_Maly_Loan(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 19)
    public void updtSrvStsToActv_Pre_Loan() throws IOException {
        Response response = UpdtSrvStsToActv_Loan.updtSrvStsToActv_Pre_Loan(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 20)
    public void requestLoan_Pre() throws IOException {
        Response response = RequestLoan.requestLoan_Pre(EndPointURLs.base_url, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}

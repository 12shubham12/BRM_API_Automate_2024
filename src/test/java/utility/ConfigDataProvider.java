package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider(){
        File src = new File("./Config/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);
        }
        catch(Exception e){
            System.out.println("Not able to load Configfile "+e.getMessage());
        }
    }

    public String getPosptaidCreateBAXMLFile(){
        return pro.getProperty("Postpaid_CreateBA_xml");
    }

    public String getPosptaidCreateSAXMLFile(){
        return pro.getProperty("Postpaid_CreateSA_xml");
    }

    public String getPrepaidCreateSAXMLFile(){
        return pro.getProperty("Prepaid_CreateSA_xml");
    }
    public String getPrepaidCreateSA_MY_LSIM_XMLFile(){
        return pro.getProperty("Prepaid_CreateSA_Maly_LSIM_xml");
    }
    public String getPrepaidCreateSA_SP_XMLFile(){
        return pro.getProperty("Prepaid_CreateSA_SP_xml");
    }
    public String getRechargeXMLFile(){
        return pro.getProperty("Prepaid_RCH_xml");
    }
    public String getPurSingleOfferXMLFile(){
        return pro.getProperty("Prepaid_PurMultipleOffer_Pre");
    }
    public String getChgSingleOfferXMLFile(){
        return pro.getProperty("Prepaid_ChgSingleOffer_Pre");
    }
    public String getCanSingleOfferXMLFile(){
        return pro.getProperty("Prepaid_CanSingleOffer_Pre");
    }
    public String getupdateSrvPref_SPXMLFile(){
        return pro.getProperty("Prepaid_updateSrvPref_SP_xml");
    }
    public String getupdateAdd_SPXMLFile(){
        return pro.getProperty("Prepaid_updateAddresses_SP_xml");
    }
    public String getupdateAccProf_SPXMLFile(){
        return pro.getProperty("Prepaid_updateAccProf_SP_xml");
    }
    public String getupdateSrvStatusXMLFile(){
        return pro.getProperty("Prepaid_updateSrvStatus_xml");
    }
    public String getreqLoanXMLFile(){
        return pro.getProperty("Prepaid_reqLoan_xml");
    }
}

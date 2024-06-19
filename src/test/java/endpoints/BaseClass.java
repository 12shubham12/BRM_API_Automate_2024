package endpoints;


import org.testng.annotations.BeforeClass;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseClass {

    public static ConfigDataProvider config;
    public static ExcelDataProvider excel;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        config = new ConfigDataProvider();
        excel = new ExcelDataProvider();
    }

    public static void jdbcConnection(String CUSTOM_ID){
        String url = "jdbc:oracle:thin:@100.76.214.109:1521/PINPDB";
        String username = "pin";
        String password="passw0rd";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, username,password);
            //Establishing the connection
            Statement statement = connection.createStatement();
            //Run the query
            statement.executeQuery
                    ("update PROFILE_TAB_CUSTOMER_DET_T set subs_tenure=120 where cust_id='"+CUSTOM_ID+"'");
            ResultSet resultSet1 = statement.executeQuery
                    ("select * from PROFILE_TAB_CUSTOMER_DET_T where cust_id='"+CUSTOM_ID+"'");

            while(resultSet1.next()){
                System.out.println(resultSet1.getInt(1)+"|"+resultSet1.getString(2)+"|"+
                        resultSet1.getInt(20));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
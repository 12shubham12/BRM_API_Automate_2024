package testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//We have downloaded and added Ojdbc jar to the project, for connecting to Database

public class JDBC_Connection_Delete {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@100.76.214.109:1521/PINPDB";
        String username = "pin";
        String password="passw0rd";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, username,password);
            //Establishing the connection
            Statement statement = connection.createStatement();
            //Run the query
            ResultSet resultSet = statement.executeQuery("select * from account_t where poid_id0='7501893'");

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+
                        resultSet.getString(3));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

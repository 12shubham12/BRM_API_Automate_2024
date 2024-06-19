package testcases;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;

public class Connection_Delete_2 {

    public static void main(String[] args) {
        String host = "lhr-190.snlhrprshared1.gbucdsint02lhr.oraclevcn.com";
        String user = "digistdevops";
        String password = "C1g2b3u4#";

        try {
            // Specify the URL of the XML file on the server
            String xmlUrl = "cd /home/digistdevops/ST_QA_Seagull/seagull/diameter/scenario/data_21SEP_SH.xml";
            // Fetch XML file from the server
            InputStream inputStream = new URL(xmlUrl).openStream();
            // Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            // Your XML processing logic here
            // ...
            System.out.println("XML file processed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package utility;

import api.endpoints.BaseClass;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helper{

    public static Random random = new Random();

    static FileReader fr;   //reads the file
    static BufferedReader br;  //creates a buffering character input stream
    static StringBuffer sb;    //constructs a string buffer with no characters
    public static String line, BAno, cusID, s;

    //code to extract date
    public static String getCurrentDateTime(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }

    public static String getSystemDateTime() {
        DateFormat customFormat = new SimpleDateFormat("dd-MMM-YYYY hh:mm:ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }

    //code to read xml File or input payload
    public static String readPayload_BA(String field1,String val1,String field2,String val2) throws IOException {
        File file1 = new File(BaseClass.config.getPosptaidCreateBAXMLFile());
        fr = new FileReader(file1);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String ss= sb.toString().replaceAll(field1, BAno=val1+random.nextInt())
                .replaceAll(field2, cusID=val2+random.nextInt());
        return ss;

        //test
    }

    public static String readPayload_Post_SA(String f1,String val1,String f2,String val2,String f3, String val3,
                                             String f4, String val4, String f5, String val5, String f6, String val6,
                                             String f7, String val7, String f8,
                                             String f9, String val9, String f10, String val10) throws IOException {

        File file2 = new File(BaseClass.config.getPosptaidCreateSAXMLFile());
        fr = new FileReader(file2);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String ss_SA= sb.toString().replaceAll(f1, val1+random.nextInt())
                .replaceAll(f2, BAno)
                .replaceAll(f3,cusID)
                .replaceAll(f4, val5)
                .replaceAll(f5, val5)
                .replaceAll(f6, s=val6+random.nextInt())
                .replaceAll(f7, val7+random.nextInt())
                .replaceAll(f8, s)
                .replaceAll(f9, val9)
                .replaceAll(f10, val10);

        return ss_SA;
    }

    public static String readPayload_Pre_SA(String f1,String val1,String f2,String val2,String f3,String val3,
                                            String f4,String val4,String f5, String val5,String f6,String val6,String f7,
                                            String f8,String val8,String f9, String val9) throws IOException {

        File file2 = new File(BaseClass.config.getPrepaidCreateSAXMLFile());
        fr = new FileReader(file2);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String ss_PreSA = sb.toString().replaceAll(f1, val1 + random.nextInt())
                .replaceAll(f2, val2 + random.nextInt())
                .replaceAll(f3, val3)
                .replaceAll(f4, val4)
                .replaceAll(f5, s = val5 + random.nextInt())
                .replaceAll(f6, val6 + random.nextInt())
                .replaceAll(f7, s)
                .replaceAll(f8, val8)
                .replaceAll(f9, val9);

        return ss_PreSA;
    }

    public static String readPayload_Recharge(String f1,String val1,String f2,String val2,String f3, double val3,
                                              String f4, String val4, String f5, double val5,
                                              String f6, double val6) throws IOException {

        File file2 = new File(BaseClass.config.getRechargeXMLFile());
        fr = new FileReader(file2);
        br = new BufferedReader(fr);
        sb = new StringBuffer();
        {
            try {
                fr = new FileReader(file2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while ((line = br.readLine()) != null) {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();

        String ss_RCHG= sb.toString().replaceAll(f1, s)
                .replaceAll(f2, val2)
                .replaceAll(f3, String.valueOf((int)val3)) //to convert double to int and then to String
                .replaceAll(f4, val4)
                .replaceAll(f5, String.valueOf((int)val5))
                .replaceAll(f6, String.valueOf((int)val6));

        return ss_RCHG;
    }

}
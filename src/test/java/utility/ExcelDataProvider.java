package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    public ExcelDataProvider(){
        File src = new File("./TestData/Data.xlsx");
        try{
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            System.out.println("Unable to read Excel File "+e.getMessage());
        }
    }
    //method to read the data from the excel
    public String getBA_No(String sheetName,int row,int column){
    return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getCID_No(String sheetName,int row,int column){
    return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getPost_SA_No(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getPre_SA_No(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getRCH_Details(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getRCH_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public String getPurMultipleOff_Pre_Details(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getPurMultipleOff_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public String getCanSingleOff_Pre_Details(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getCanSingleOff_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public String getChgSingleOff_Pre_Details(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getChgSingleOff_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public double getupdateSevPref_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public String getupdateSevPref_Detail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getupdateAdd_Detail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public String getupdateSrvSts_Detail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public double getupdateSrvSts_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
    public String getreqLoan_Detail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public double getreqLoan_NumericDetail(String sheetName,int row,int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

}

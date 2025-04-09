package com.SprintDemo.Data;

import com.SprintDemo.utilites.LogsUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader
{
static FileInputStream fis=null;
public FileInputStream getFileInputStram()
{
String filepath="D:\\Sprint task\\practiseAutomationProject\\src\\main\\java\\com\\SprintDemo\\Data\\Regesteration data.xlsx";
       // "D:\\Sprint task\\practiseAutomationProject\\src\\main\\java\\com\\SprintDemo\\Data\\Regesteration data.xlsx";
try {
    fis=new FileInputStream(filepath);
} catch (FileNotFoundException e) {
    LogsUtil.error("Errol file is occured",e.getMessage());

}
return fis;
}
public  Object[][] getExcelData() throws IOException {
    fis=getFileInputStram();
    XSSFWorkbook wb=new XSSFWorkbook(fis);
    XSSFSheet sheet=wb.getSheetAt(0);
    int TotalNumberRow=sheet.getLastRowNum()+1;
    int TotalNumberColumn=12;
    String[][] arrayExcelData=new String[TotalNumberRow][TotalNumberColumn];
    for (int i=0;i<TotalNumberRow;i++){
        for (int j=0;j<TotalNumberColumn;j++)
        {
            XSSFRow row=sheet.getRow(i);
            arrayExcelData[i][j] =row.getCell(j).toString();
        }
    }
    wb.close();
    return arrayExcelData;
}
}

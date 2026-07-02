package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilityAdv {

    private Workbook workbook;
    private Sheet sheet;
    FileInputStream fileInputStream;

    public ExcelUtilityAdv(String filePath, String sheetName) throws IOException{
         fileInputStream= new FileInputStream(filePath);
         workbook = WorkbookFactory.create(fileInputStream);
         sheet = workbook.getSheet(sheetName);

    }

    public int getRowCount(){
        return sheet.getLastRowNum();
    }

    public int getColumnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

    public String getCellData(int row, int column){
        return sheet.getRow(row).getCell(column).toString();
    }

}

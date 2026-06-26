package utilities;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;

import java.io.IOException;

@Slf4j
public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException{
        String path = "testData/testdata1.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);

        String logindata[][] = new String[totalrows][totalcols];

        for(int i = 1; i< totalrows; i++){
            for(int j = 0; j<totalcols; j++){
                logindata[i-1][j] = xlutil.getCellData("Sheet1",i, j);
            }
        }
        return logindata;
    }

}

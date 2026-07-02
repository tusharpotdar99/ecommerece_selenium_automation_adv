package DataProviders;


import org.testng.annotations.DataProvider;
import utilities.ExcelUtilityAdv;

import java.io.IOException;

public class LoginDataProvider {

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getLoginData() throws IOException{
        String path = System.getProperty("user.dir") + "/testData/LoginData.xlsx";

        ExcelUtilityAdv excel = new ExcelUtilityAdv(path, "Sheet1");

        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows][cols];

        for(int i = 1; i<= rows; i++){
            for(int j = 0; j < cols; j++){
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        return data;
    }



}

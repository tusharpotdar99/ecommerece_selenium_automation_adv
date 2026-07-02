package utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class TestDataGenerator {

    private static final String filePath = System.getProperty("user.dir") + "/testData/RegistrationData.xlsx";


    private static final String sheetName = "Users";

    private TestDataGenerator() {
    }

    public static RegistrationData generateUser() {

        String sequence = String.format("%04d", getNextSequence());

        return new RegistrationData(
                "UserFirstName" + sequence,
                "UserLastName" + sequence,
                "user" + sequence + "@gmail.com",
                "TestUser@" + sequence
        );
    }

    private static int getNextSequence() {

        File file = new File(filePath);

        if (!file.exists()) {
            return 1;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null || sheet.getLastRowNum() == 0) {
                return 1;
            }

            Row lastRow = sheet.getRow(sheet.getLastRowNum());

            String email = lastRow.getCell(2).getStringCellValue();

            String number = email
                    .replace("user", "")
                    .replace("@gmail.com", "");

            return Integer.parseInt(number) + 1;

        } catch (IOException e) {

            throw new RuntimeException("Unable to determine next sequence.", e);
        }
    }
}
package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreen {

    public static String captureScreen(WebDriver driver, String testName) throws IOException {
        String targetFilePath = System.getProperty("user.dir") + "\\screenShots\\"+testName + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(targetFilePath);
        FileUtils.copyFile(sourceFile, targetFile);
        return targetFilePath;
    }

}

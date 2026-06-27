package utilities;

import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")){
            if(inputStream == null){
                throw new RuntimeException("config.properties file not found");
            }
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    private ConfigReader(){}

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static String getApplicationUrl(){
        return getProperty("app_url");
    }

    public static String getUsername() {
        return getProperty("email");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getInvalidUser(){
        return getProperty("invalidemail");
    }

    public static String getInvalidPassword(){
        return getProperty("invalidpassword");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }


}

package utilities;

import org.apache.commons.lang3.RandomStringUtils;


public final class RandomDataUtils {

    private RandomDataUtils(){

    }
    public String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber(){
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric(){
        String generatedstring = RandomStringUtils.randomAlphabetic(3);
        String generatednumber = RandomStringUtils.randomNumeric(3);
        return (generatedstring+"@"+generatednumber);
    }
}

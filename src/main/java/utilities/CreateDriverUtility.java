package utilities;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriverUtility {

    public WebDriver createDriver() throws IOException, ParseException {

        WebDriver driver;
        JSONFileReaderUtility jsonFileReaderUtility = new JSONFileReaderUtility();
        Object testParamsObj = jsonFileReaderUtility.createJsonFileObject("configs\\testParams.json");
        
        JSONObject testParams = (JSONObject) testParamsObj;
        String selectedBrowser = (String) testParams.get("browser");

        Object configsObj = jsonFileReaderUtility.createJsonFileObject("configs\\configurations.json");
       
        JSONObject configs = (JSONObject) configsObj;
        String chromeDriverFilePath = (String) configs.get("chromeDriverPath");
        String firefoxDriverFilePath = (String) configs.get("firefoxDriverPath");
        String firefoxBinaryPath = (String) configs.get("firefoxBinaryPath");

        switch (selectedBrowser) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
                driver = new ChromeDriver();
                break;

            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", firefoxDriverFilePath);
                driver = new FirefoxDriver();
                break;

            default:
                System.setProperty("webdriver.gecko.driver", firefoxDriverFilePath);
                driver = new FirefoxDriver();
                break;
        }

        return driver;

    }
}

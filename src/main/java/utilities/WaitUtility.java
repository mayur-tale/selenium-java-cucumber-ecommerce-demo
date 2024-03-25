package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitUtility {

    
    WebDriverWait wait;

    public WebDriverWait createWait(WebDriver driver){

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait;
    }

}

package pageMethods;

import java.io.IOException;

import java.time.Duration;

import pageLocators.*;
import utilities.CreateDriverUtility;
import utilities.WaitUtility;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*++++ This class uses the option of storing element locators in java ENUMs - pageLocators.HomePageElements
  ++++ Once we import the ENUM, all the element locators are readily available to use for action methods 
  ++++ All other page method classes are using PageFactory instead of ENUM
 */

public class HomePageMethods {

    WebDriver driver;
    public HomePageMethods(WebDriver driver) throws IOException, ParseException{
        super();
         this.driver = driver;
    }
    
    
    

    public void launchHomePage(){
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://shop.demoqa.com/");

    }

    public void clickSearchButton(){

        driver.findElement(HomePageElements.SEARCH_ON_HOME.getLocator()).click();
        
    }

    public void enterTextInSearchBoxAndSubmit(String searchText){

        driver.findElement(HomePageElements.SEARCH_AFTER_CLICKING_SEARCH.getLocator()).clear();
        driver.findElement(HomePageElements.SEARCH_AFTER_CLICKING_SEARCH.getLocator()).sendKeys(searchText);
        driver.findElement(HomePageElements.SEARCH_AFTER_CLICKING_SEARCH.getLocator()).sendKeys(Keys.ENTER);
    }

    public void clickViewCartIcon(){

        WaitUtility waitUntil = new WaitUtility();
        WebDriverWait wait =  waitUntil.createWait(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.VIEW_CART.getLocator()));
        driver.findElement(HomePageElements.VIEW_CART.getLocator()).click();
    }
}

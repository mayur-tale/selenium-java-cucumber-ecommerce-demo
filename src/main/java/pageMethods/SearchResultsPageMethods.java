package pageMethods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class SearchResultsPageMethods {

/*++++ This class uses the option of storing element locators in Selenium PageFactory
  ++++ All the element locators and action methods are defined in the same page class
 */
    WaitUtility waitUtil = new WaitUtility();
    WebDriverWait wait;

    public SearchResultsPageMethods(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = waitUtil.createWait(driver);
    }

    @FindBy(xpath = "//div[contains(@class,\"noo-product-inner\")]/h3/a")   
    private WebElement firstSearchResult_ViewDetailsButton;

    @FindBy(xpath = "//div[contains(@class,\"remove-form\")]")
    private WebElement searchResult_GhostElement;

    @FindAll(@FindBy(xpath = "//div[contains(@class,\"noo-product-thumbnail\")]")) 
    private List<WebElement> searchResult_ListOfAllViewDetailsButtons;

    @FindBy(xpath = "//select[contains(@data-attribute_name,\"attribute_pa_color\")]")
    private WebElement productDetails_SelectColorDropdown;

    @FindBy(xpath = "//select[contains(@data-attribute_name,\"attribute_pa_size\")]")
    private WebElement productDetails_SelectSizeDropdown;

    @FindBy(xpath = "//button[contains(.,\"Add to cart\")]")
    private WebElement productDetails_AddToCartButton;

    

    public void clickFirstSearchResult(){

        wait.until(ExpectedConditions.invisibilityOf(searchResult_GhostElement));
        wait.until(ExpectedConditions.visibilityOf(firstSearchResult_ViewDetailsButton));
        firstSearchResult_ViewDetailsButton.click();
    
    }

    public void selectColourOnDetailsPage(String colour){
        wait.until(ExpectedConditions.visibilityOf(productDetails_SelectColorDropdown));
        Select colourDropdown = new Select(productDetails_SelectColorDropdown);
        colourDropdown.selectByVisibleText(colour);
    }

    public void selectSizeOnDetailsPage(String size){
        wait.until(ExpectedConditions.visibilityOf(productDetails_SelectSizeDropdown));
        Select sizeDropdown = new Select(productDetails_SelectSizeDropdown);
        sizeDropdown.selectByVisibleText(size);
    }

    public void clickAddToCartButton(){

        wait.until(ExpectedConditions.visibilityOf(productDetails_AddToCartButton));
        productDetails_AddToCartButton.click();
    }

}

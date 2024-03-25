package pageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class CheckoutPageMethods {

    WaitUtility waitUtil = new WaitUtility();
    WebDriverWait wait;

    public CheckoutPageMethods (WebDriver driver){

        PageFactory.initElements(driver, this);
        wait = waitUtil.createWait(driver);
    }

    @FindBy(xpath = "//input[contains(@name,\"billing_first_name\")]")
    private WebElement checkout_billingDetails_FirstName;

    @FindBy(xpath = "//input[contains(@name,\"billing_last_name\")]")
    private WebElement checkout_billingDetails_LastName;

    @FindBy(xpath = "//select[contains(@name,\"billing_country\")]")
    private WebElement checkout_billingDetails_Country;

    @FindBy(xpath = "//input[contains(@name,\"billing_address_1\")]")
    private WebElement checkout_billingDetails_BillingAddressLine1;

    @FindBy(xpath = "//input[contains(@name,\"billing_city\")]")
    private WebElement checkout_billingDetails_BillingCity;

    @FindBy(xpath = "//select[contains(@name,\"billing_state\")]")
    private WebElement checkout_billingDetails_State;

    @FindBy(xpath = "//input[contains(@name,\"billing_postcode\")]")
    private WebElement checkout_billingDetails_BillingPostcode;

    @FindBy(xpath = "//input[contains(@name,\"billing_phone\")]")
    private WebElement checkout_billingDetails_BillingPhone;

    @FindBy(xpath = "//input[contains(@name,\"billing_email\")]")
    private WebElement checkout_billingDetails_BillingEmail;

    @FindBy(xpath = "//input[contains(@name,\"terms\")]")
    private WebElement checkout_billingDetails_TermsCheckbox;

    @FindBy(xpath = "//button[contains(.,\"Place order\")]")
    private WebElement checkout_PlaceOrderButton;

    public void enterTextInField(String text, WebElement el){
        wait.until(ExpectedConditions.visibilityOf(el));
        el.clear();
        el.sendKeys(text);
    }

    public void enterBillingFirstName(String firstName){
        this.enterTextInField(firstName, checkout_billingDetails_FirstName);
    }

    public void enterBillingLastName(String lastName){
        this.enterTextInField(lastName, checkout_billingDetails_LastName);
    }

    public void selectBillingCountry(String country){
        Select select = new Select(checkout_billingDetails_Country);
        select.selectByVisibleText(country);
    }

    public void enterBillingAddLine1(String addLine1){
        this.enterTextInField(addLine1, checkout_billingDetails_BillingAddressLine1);
    }

    public void enterBillingCity(String city){
        this.enterTextInField(city, checkout_billingDetails_BillingCity);
    }

    public void selectBillingState(String state){
        Select select = new Select(checkout_billingDetails_State);
        select.selectByVisibleText(state);
    }

    public void enterBillingPhone(String phone){
        this.enterTextInField(phone, checkout_billingDetails_BillingPhone);
    }

    public void enterBillingPostCode(String postCode){
        this.enterTextInField(postCode, checkout_billingDetails_BillingPostcode);
    }

    public void enterBillingEmail(String email){
        this.enterTextInField(email, checkout_billingDetails_BillingEmail);
    }

    public void clickTermsCheckbox(){
        wait.until(ExpectedConditions.visibilityOf(checkout_billingDetails_TermsCheckbox));
        checkout_billingDetails_TermsCheckbox.click();
    }

    public void clickPlaceOrderButton(){
        wait.until(ExpectedConditions.visibilityOf(checkout_PlaceOrderButton));
        checkout_PlaceOrderButton.click();
    }

}

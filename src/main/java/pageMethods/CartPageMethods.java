package pageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class CartPageMethods {

    WaitUtility waitUtil = new WaitUtility();
    WebDriverWait wait;

    public CartPageMethods (WebDriver driver){

        PageFactory.initElements(driver, this);
        wait = waitUtil.createWait(driver);
    }

    @FindBy(xpath = "//a[contains(.,\"Proceed to checkout\")]")
    private WebElement cart_CheckoutButton;

    public void clickCartCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOf(cart_CheckoutButton));
        cart_CheckoutButton.click();
    }
}

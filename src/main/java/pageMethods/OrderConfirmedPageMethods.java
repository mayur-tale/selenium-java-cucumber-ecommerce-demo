package pageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import utilities.WaitUtility;

public class OrderConfirmedPageMethods {

    WaitUtility waitUtil = new WaitUtility();
    WebDriverWait wait;

    public OrderConfirmedPageMethods (WebDriver driver){

        PageFactory.initElements(driver, this);
        wait = waitUtil.createWait(driver);
    }

    @FindBy(xpath = "//p[contains(.,\"order has been received\")]")
    private WebElement confirmation_OrderReceivedMessage;

    public void verifyOrderConfirmedMessage(){
        wait.until(ExpectedConditions.visibilityOf(confirmation_OrderReceivedMessage));
        Assert.assertTrue(confirmation_OrderReceivedMessage.getText().contains("order has been received"));
    }
}

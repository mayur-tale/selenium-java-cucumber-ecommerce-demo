package pageLocators;

import org.openqa.selenium.By;
/* ++++ This enum only includes the locators for Home Page
 * ++++ Rest of the locators are defined using pageFatory @FindBy in individual page classes
 */
public enum HomePageElements {

    SEARCH_ON_HOME(By.xpath("//a[contains(.,'Search')]")),
    SEARCH_AFTER_CLICKING_SEARCH(By.xpath("//input[@type='search']")),
    VIEW_CART(By.xpath("//span[contains(.,\"Cart\")]"));

    private final By locator;

    HomePageElements (By locator){
        this.locator = locator;
    }

    public By getLocator(){
        return locator;
    }

}

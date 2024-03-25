package stepDefinitions;


import pageMethods.*;
import utilities.CreateDriverUtility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    public Steps() throws IOException, ParseException {
        super();
    }
    CreateDriverUtility createDriverUtility = new CreateDriverUtility();
    WebDriver driver = createDriverUtility.createDriver();
    HomePageMethods homePageMethods = new HomePageMethods(driver);
    

    SearchResultsPageMethods searchResultsPageMethods = new SearchResultsPageMethods(driver);
    CartPageMethods cartPageMethods = new CartPageMethods(driver);
    CheckoutPageMethods checkoutPageMethods = new CheckoutPageMethods(driver);
    OrderConfirmedPageMethods orderConfirmedPageMethods = new OrderConfirmedPageMethods(driver);
    
    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        homePageMethods.launchHomePage();
    }

    @When("User searches for product type {string} in the Home Page")
    public void user_searches_for_product_type_in_the_home_page(String string) {
        homePageMethods.clickSearchButton();
        homePageMethods.enterTextInSearchBoxAndSubmit(string);
    }

    @Then("User is shown search results")
    public void user_is_shown_search_results() {

    }

    @When("User adds the first item in the results to cart with colour {string} and size {string}")
    public void user_adds_the_first_item_in_the_results_to_cart_with_colour_and_size(String colour, String size) {
        searchResultsPageMethods.clickFirstSearchResult();
        searchResultsPageMethods.selectColourOnDetailsPage(colour);
        searchResultsPageMethods.selectSizeOnDetailsPage(size);
        searchResultsPageMethods.clickAddToCartButton();
    }

    @When("User views the Cart")
    public void user_views_the_cart() {
        homePageMethods.clickViewCartIcon();
    }

    @Then("User can see the selected product in Cart")
    public void user_can_see_the_selected_product_in_cart() {

    }

    @When("User selects the checkout option")
    public void user_selects_the_checkout_option() {
        cartPageMethods.clickCartCheckoutButton();
    }

    @Then("User is shown the checkout Page")
    public void user_is_shown_the_checkout_page() {

    }

    @When("User enters the first name {string} in the form")
    public void user_enters_the_first_name_in_the_form(String firstName) {
        checkoutPageMethods.enterBillingFirstName(firstName);
    }

    @When("User enters the last name {string} in the form")
    public void user_enters_the_last_name_in_the_form(String lastName) {
        checkoutPageMethods.enterBillingLastName(lastName);
    }

    @When("User selects the country {string} in the form")
    public void user_selects_the_country_in_the_form(String country) {
        checkoutPageMethods.selectBillingCountry(country);
    }

    @When("User enters the street address line one {string} in the form")
    public void user_enters_the_street_address_line_one_in_the_form(String addLine1) {
        checkoutPageMethods.enterBillingAddLine1(addLine1);
    }

    @When("User enters the town {string} in the form")
    public void user_enters_the_town_in_the_form(String city) {
        checkoutPageMethods.enterBillingCity(city);
    }

    @When("User enters the state {string} in the form")
    public void user_enters_the_state_in_the_form(String state) {
        checkoutPageMethods.selectBillingState(state);
    }

    @When("User enters the postcode {string} in the form")
    public void user_enters_the_postcode_in_the_form(String postCode) {
        checkoutPageMethods.enterBillingPostCode(postCode);
    }

    @When("User enters the phone {string} in the form")
    public void user_enters_the_phone_in_the_form(String phone) {
        checkoutPageMethods.enterBillingPhone(phone);
    }

    @When("User enters the email {string} in the form")
    public void user_enters_the_email_in_the_form(String email) {
        checkoutPageMethods.enterBillingEmail(email);
    }

    @When("User selects the terms and conditions checkbox")
    public void user_selects_the_terms_and_conditions_checkbox() {
        checkoutPageMethods.clickTermsCheckbox();
    }

    @When("User clicks the Place Order button")
    public void user_clicks_the_place_order_button() {
        checkoutPageMethods.clickPlaceOrderButton();
    }

    @Then("User is shown the Order Received screen with order details")
    public void user_is_shown_the_order_received_screen_with_order_details() {
        orderConfirmedPageMethods.verifyOrderConfirmedMessage();
    }

}

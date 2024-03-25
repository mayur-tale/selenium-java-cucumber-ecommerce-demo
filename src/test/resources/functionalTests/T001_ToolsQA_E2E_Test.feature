Feature: Verify that a user is able to add a product to cart and checkout

  Scenario Outline: User is able to search add and checkout listed products
    Given User is on the Home Page
    When User searches for product type "<Product_Type>" in the Home Page
    Then User is shown search results
    When User adds the first item in the results to cart with colour "<Colour>" and size "<Size>"
    And User views the Cart
    Then User can see the selected product in Cart
    When User selects the checkout option
    Then User is shown the checkout Page
    When User enters the first name "<First_Name>" in the form
    And User enters the last name "<Last_Name>" in the form
    And User selects the country "<Country>" in the form
    And User enters the street address line one "<Street_Add_Ln1>" in the form
    And User enters the town "<Town_City>" in the form
    And User enters the state "<State>" in the form
    And User enters the postcode "<Postcode>" in the form
    And User enters the phone "<Phone>" in the form
    And User enters the email "<Email>" in the form
    And User selects the terms and conditions checkbox
    And User clicks the Place Order button
    Then User is shown the Order Received screen with order details

    Examples:
      | Product_Type | Colour | Size  | First_Name | Last_Name | Country | Street_Add_Ln1 | Town_City | State       | Postcode | Phone    | Email      |
      | bodycon      | White  | Small | Tester     | Doe       | India   | 300 Test Road  | Mumbai    | Maharashtra | 100032   | 99999999 | a@test.com |

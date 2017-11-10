Feature: BestBuy testing
  As a visitor of the ecommerce website
  I want to be able to see and update my account details
  So that my details for ordering and delivery are correct
  //@BestBuy-footerValidation
  Scenario: Best Buy Login
    Given url opened
    Then Sign in to Website
    Then Search for a product
    Then Add product to cart
    Then Proceed to Checkout
    And Select Payment Gateway
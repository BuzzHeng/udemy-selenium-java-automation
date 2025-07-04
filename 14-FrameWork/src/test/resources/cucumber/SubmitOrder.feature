@tag
Feature: Purchase the order from Ecommerce Website

  Background:
    Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." messages is displayed on ConfirmationPage

    Examples:
        | name                | password     | productName |
        | scrashers@gmail.com | @QWE12345qwe | ZARA COAT 3 |
@SubmitOrder
Feature: Purchase the order from Ecommerce website

  Background: 
    Given I landed on Ecommerce Page

 
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with <Email> and <Passsword>
    When I add product <ProductName> to cart
    And checkout <ProductName> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page.

    Examples: 
      | Email                    | Passsword | ProductName     |
      | mithilesh@yopmail.com    | Test@1234 | ZARA COAT 3     |
      | mithilesh@mailinator.com | Test@1234 | ADIDAS ORIGINAL |

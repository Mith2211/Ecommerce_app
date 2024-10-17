@ErrorValidation
Feature: Error Validation

 
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with <Email> and <Passsword>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | Email                    | Passsword |
      | mithilesh@yopmail.com    | Test1234  |
      | mithilesh@mailinator.com | Test1234  |

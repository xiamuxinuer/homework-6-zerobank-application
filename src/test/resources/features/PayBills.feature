@PayBills
Feature:pay bills page
  As a authorized user,i should be able to login to the application pay bills page.

  Background: open login page
    Given the user on zerobank application homepage
    When the user is logged in

  @PaymentCompletedMessage
  Scenario: verify pay bills page
    And the user clicks "Pay Bills"
    Then the user verifies page title is "Zero - Pay Bills"
    And the user select payee option "Bank of America"
    And the user select account option "Checking"
    And the user enters payment info:
      |Amount|Date      |Description|
      |500   |2020-05-15|make payment|
    Then the user clicks pay button
    And the user verifies payment message "The payment was successfully submitted."


@paymentWarningMessage
  Scenario: verify pay bills page warning message

    And the user clicks "Pay Bills"
    Then the user verifies page title is "Zero - Pay Bills"
    And the user select payee option "Bank of America"
    And the user select account option "Checking"
    And the user enters amount and description:
     |Amount      |Description|
     |500         |zero payment|
    Then the user clicks pay button
    And the user verifies warning message message "Please fill out this field."
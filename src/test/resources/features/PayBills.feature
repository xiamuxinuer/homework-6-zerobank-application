@PayBills
Feature:pay bills page
  As a authorized user,i should be able to login to the application pay bills page.

  @PayBillsPage
  Scenario: verify pay bills page
    Given the user on zerobank application homepage
    When the user is logged in
    And the user clicks "Pay Bills"
    Then the user verifies page title is "Zero - Pay Bills"
    And the user select payee option "Bank of America"
    And the user select account option "Checking"
    And the user enters payment info:
      |Amount|Date      |Description|
      |500   |2020-05-15|make payment|
    Then the user cliks pay button
    And the user verifies payment message "The payment was successfully submitted."




@AccountActivity
Feature:account activity page
  As a authorized user,i should be able to login to the application account activity page.

  @accountActivityPage
  Scenario: verify account activity page
    Given the user on zerobank application homepage
    When the user is logged in
    And the user clicks "Account Activity"
    Then the user verifies page title is "Zero - Account Activity"
    And the user verifies Account drop down default option should be "Savings"
    And the user verifies Account drop down should have the following options:"Savings, Checking, Savings, Loan, Credit Card, Brokerage"
   And  the user verifies Transactions table should have column names
  |Date|
  |Description|
  |Deposit|
  |Withdrawal|
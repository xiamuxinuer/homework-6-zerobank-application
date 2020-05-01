@AccountActivity
Feature:account activity page
  As a authorized user,i should be able to login to the application account activity page.

  Background: open login page
    Given the user on zerobank application homepage


  @SavingsLink
  Scenario: Savings account redirect
    When the user is logged in
    And the user clicks "Savings"
    Then the user verifies page title is "Zero - Account Activity"
    And the user verifies Account drop down default option should be "Savings"
    And the user verifies Account drop down should have the following options:"Savings, Checking, Savings, Loan, Credit Card, Brokerage"
   And  the user verifies Transactions table should have column names
  |Date|
  |Description|
  |Deposit|
  |Withdrawal|

@BrokerageLink
  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks "Brokerage"
    Then the user verifies page title is "Zero - Account Activity"
    And the user verifies Account drop down default option should be "Brokerage"

@CheckingLink
  Scenario: Checking account redirect
    Given the user is logged in
   When the user clicks "Checking"
   Then the user verifies page title is "Zero - Account Activity"
   And the user verifies Account drop down default option should be "Checking"

  @CreditLink
  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks "Credit Card"
    Then the user verifies page title is "Zero - Account Activity"
    And the user verifies Account drop down default option should be "Credit Card"

  @loanLink
  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks "Loan"
    Then the user verifies page title is "Zero - Account Activity"
    And the user verifies Account drop down default option should be "Loan"
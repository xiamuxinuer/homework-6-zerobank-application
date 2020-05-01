@AccountSummary
Feature:account summary page
  As a authorized user,i should be able to login to the application account summary page.

 @AccountSummaryPage
  Scenario: verify account summary page
    Given the user on zerobank application homepage
    When the user is logged in
    Then the user verifies page title is "Zero - Account Summary"
    And the user verifies Account summary page should have to following account types "Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts"
    And the user verifies Credit Accounts table must have columns "Account Credit Card Balance"




@FindTransactions
  Feature: Find Transactions in Account Activity

    Background: open login page
      Given the user on zerobank application homepage
      When the user is logged in
      And the user clicks "Account Activity"


   @SearchDateRange
    Scenario: Search date range
      Given the user clicks "Find Transactions"
      When the user enters date range from "2012-09-01" to "2012-09-06"
      And clicks search
      Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
      When the user enters date range from "2012-09-02" to "2012-09-06"
      And clicks search
       And the results table should only not contain transactions dated "2012-09-01"

@SearchDescription
    Scenario: Search description
      Given the user clicks "Find Transactions"
      When the user enters description "ONLINE"
      And clicks search
      Then results table should only show descriptions containing "ONLINE"
     When the user enters description "OFFICE"
       And clicks search
     Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"

@SearchDescriptionCaseInsensitive
    Scenario: Search description case insensitive
      Given the user clicks "Find Transactions"
      When the user enters description "ONLINE"
      And clicks search
      Then results table should only show descriptions containing "ONLINE"
      When the user enters description "online"
      And clicks search
      Then results table should only show descriptions containing "ONLINE"

     @Type
    Scenario: Type
      Given the user clicks "Find Transactions"
      And clicks search
      Then results table should show at least one result under Deposit
      Then results table should show at least one result under Withdrawal
      When user selects type "Deposit"
       And clicks search
      Then results table should show at least one result under Deposit
      But results table should show no result under Withdrawal
      When user selects type "Withdrawal"
       And clicks search
      Then results table should show at least one result under Withdrawal
      But results table should show no result under Deposit

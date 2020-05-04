
Feature: PurchaseForeignCurrency

  Background: open login page
    Given the user on zerobank application homepage
    When the user is logged in

    @AvailableCurrencies
  Scenario: Available currencies

    Given the user clicks "Pay Bills"
      And the user clicks "Purchase Foreign Currency"
    Then following currencies should be available
      |Select One|
      |Australia (dollar)|
      |Canada (dollar)|
      |Switzerland (franc)|
      |China (yuan)|
      |Denmark (krone)|
      |Eurozone (euro)|
      |Great Britain (pound)|
      |Japan (yen)|
      |Mexico (peso)|
      |Norway (krone)|
      |New Zealand (dollar)|
      |Singapore (dollar) |
      |Thailand (baht)    |


@ErrorMessage
  Scenario: Error message for not selecting currency
  Given the user clicks "Pay Bills"
  And the user clicks "Purchase Foreign Currency"
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed "Please, ensure that you have filled all the required fields with valid values."
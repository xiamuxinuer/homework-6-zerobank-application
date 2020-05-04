
Feature: Add new payee under pay bills
  Background: open login page
    Given the user on zerobank application homepage
    When the user is logged in
    And the user clicks "Pay Bills"
  @AddNewPayee
  Scenario: Add a new payee
    Given the user clicks "Add New Payee"
    And creates new payee using following information
      |Payee Name|                             Payee Address                    |Account |Payee details|
      |The Law Offices of Hyde, Price & Scharks|100 Same st, Anytown, USA, 10001|Checking|XYZ account|
    Then user clicks Add button
     Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created."
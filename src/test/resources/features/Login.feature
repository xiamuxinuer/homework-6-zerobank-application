
@Login
Feature:Login functionality
  As a authorized user,i should be able to login to the application.

@LoginWithValidCredential
  Scenario: login with valid credentials
  Given the user on zerobank application homepage
  When the user is logged in
  Then the user verifies page title is "Zero - Account Summary"



  @LoginWithInvalidCredential
  Scenario: login with invalid credentials
    Given the user on zerobank application homepage
    When the user enters invalid credentials username "emma" and password "1234"
    Then the user verifies warning message "Login and/or password are wrong."
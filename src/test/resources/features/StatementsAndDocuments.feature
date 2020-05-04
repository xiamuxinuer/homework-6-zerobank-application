Feature:Statements and Documents details


  Background: open login page
    Given the user on zerobank application homepage
    When the user is logged in


    @RecentStatementsPerYear
  Scenario Outline:Recent statements per year
  Given the user clicks "Online Statements"
  When the user clicks "<year>"
  Then <count> statements should be displayed for that year"<year>"
    Examples:
      | year | count |
      | 2009 | 2   |
      | 2010 | 2   |
      | 2011 | 2   |
      | 2012 | 1   |


    @DownloadStatements
  Scenario Outline:Download statements
  Given the user clicks "Online Statements"
  And the user clicks "<year>"
  When the user clicks on statement "<statement>"
  Then the downloaded file name should contain "<name>"
  And the file type should be pdf
    Examples:| year | statement               | name    |
             | 2009 | Statement 31/11/09(57K) | 31-11-09 |
             | 2010 | Statement 01/12/10(57K) | 01-12-10 |
             | 2011 | Statement 05/12/11(57K) | 05-12-11 |
             | 2012 | Statement 01/10/12(57K) | 01-10-12 |

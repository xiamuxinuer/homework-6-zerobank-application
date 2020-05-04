package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinition {
    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @When("the user clicks {string}")
    public void the_user_clicks(String string) {
        System.out.println("user clicks on :" +string +" link");
        accountActivityPage.navigateTo(string);
    }

    @Then("the user verifies Account drop down default option should be {string}")
    public void the_user_verifies_Account_drop_down_default_option_should_be(String string) {
        System.out.println("user veriyies account drop down option shoule be : " +string);

        Assert.assertEquals(string,accountActivityPage.getSelectedOption());
    }
    @Then("the user verifies Account drop down should have the following options:{string}")
    public void the_user_verifiesAccount_drop_down_should_have_the_following_options(String string) {
        System.out.println("user verify account drop down should have following options: "+string);
        Assert.assertEquals(string,accountActivityPage.getAllOptions());

    }
    @Then("the user verifies Transactions table should have column names")
    public void the_user_verifies_Transactions_table_should_have_column_names(List<String>  dataTable) {

        System.out.println("expected: "+dataTable);
        System.out.println("actual:"+ accountActivityPage.getColumnNames());

      Assert.assertEquals(dataTable.toString().replace(",",""),accountActivityPage.getColumnNames().toString());
      //Assert.assertEquals(dataTable,accountActivityPage.getColumnNames());
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {

        accountActivityPage.enterDate(string,string2);

    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.clickFindButton();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {


        Assert.assertEquals(string2,accountActivityPage.getStartDate());
        Assert.assertEquals(string,accountActivityPage.getEndDate());
        System.out.println("user verify start date and end date:");
    }

    @When("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        Assert.assertFalse(accountActivityPage.getAllDate().contains(string));
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        accountActivityPage.enterDescription(string);
        System.out.println("user enters description: "+string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        System.out.println(accountActivityPage.getAllDescriptions());

        for (String each: accountActivityPage.getAllDescriptions()){
            Assert.assertTrue(each.contains(string));
        }
        System.out.println("user verifies description list contains: "+string);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for (String each: accountActivityPage.getAllDescriptions()){
            Assert.assertFalse(each.contains(string));
        }
        System.out.println("user verifies description list does not contains: "+string);
    }
    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

     Assert.assertTrue(accountActivityPage.getDepositList().size()>=1);
        System.out.println("user verifies results table should show at least one result under Deposit");

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.getWithdrawalList().size()>=1);
        System.out.println("user verifies results table should show at least one result under Withdrawal");
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
          accountActivityPage.selectTransactionType(string);
        System.out.println("user selects transaction type: "+string);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertTrue(accountActivityPage.getWithdrawalList().isEmpty());
        System.out.println("results : Withdrawal table is empty ");
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(accountActivityPage.getDepositList().isEmpty());
        System.out.println("results :  Deposit table is empty ");
    }






}

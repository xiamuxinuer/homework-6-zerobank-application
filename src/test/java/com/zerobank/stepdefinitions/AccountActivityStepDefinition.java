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
        accountActivityPage.navigateTo(string);
    }

    @Then("the user verifies Account drop down default option should be {string}")
    public void the_user_verifies_Account_drop_down_default_option_should_be(String string) {

        Assert.assertEquals(string,accountActivityPage.getSelectedOption());
    }
    @Then("the user verifies Account drop down should have the following options:{string}")
    public void the_user_verifiesAccount_drop_down_should_have_the_following_options(String string) {

        Assert.assertEquals(string,accountActivityPage.getAllOptions());

    }
    @Then("the user verifies Transactions table should have column names")
    public void the_user_verifies_Transactions_table_should_have_column_names(List<String>  dataTable) {

        System.out.println("expected: "+dataTable);
        System.out.println("actual:"+ accountActivityPage.getColumnNames());

      Assert.assertEquals(dataTable.toString().replace(",",""),accountActivityPage.getColumnNames().toString());
      //Assert.assertEquals(dataTable,accountActivityPage.getColumnNames());
    }



}

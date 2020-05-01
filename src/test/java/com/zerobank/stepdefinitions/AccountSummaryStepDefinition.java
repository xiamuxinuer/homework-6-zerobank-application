package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSummaryStepDefinition {
          AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @Then("the user verifies Account summary page should have to following account types {string}")
    public void the_user_verifies_Account_summary_page_should_have_to_following_account_types(String string) {
        System.out.println("expected: "+string);
        System.out.println("actual: "+accountSummaryPage.getAccountTypes());


        Assert.assertEquals(accountSummaryPage.getAccountTypes(),string);
    }

    @Then("the user verifies Credit Accounts table must have columns {string}")
    public void the_user_verifies_Credit_Accounts_table_must_have_columns(String string) {

        System.out.println("expected: "+string);
        System.out.println("actual:"+ accountSummaryPage.getCreditAccountColumns());


       Assert.assertEquals(string,accountSummaryPage.getCreditAccountColumns());
    }


}

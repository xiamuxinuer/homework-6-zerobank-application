package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatementPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OnlineStatementStepDefinition {

    OnlineStatementPage onlineStatementPage=new OnlineStatementPage();


    @Then("{int} statements should be displayed for that year{string}")
    public void statements_should_be_displayed_for_that_year(int count,String string) {

        Assert.assertEquals(count,onlineStatementPage.getStatementCount(string));



    }


}

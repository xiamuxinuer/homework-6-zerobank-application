package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinition {
    PayBillsPage payBillsPage=new PayBillsPage();



    @Then("the user select payee option {string}")
    public void the_user_select_payee_option(String string) {
        System.out.println("select payee option: "+string);
        payBillsPage.setPayeeOption(string);
    }

    @Then("the user select account option {string}")
    public void the_user_select_account_option(String string) {
        System.out.println("select account option: "+string);
       payBillsPage.setAccount(string);
    }



    @Then("the user enters payment info:")
    public void the_user_enters_payment_info(List<Map<String,String>> dataTable) {
        System.out.println("enter amount,date and description");
       payBillsPage.enterPayment(dataTable.get(0).get("Amount"));
       payBillsPage.enterDate(dataTable.get(0).get("Date"));
       payBillsPage.enterDescription(dataTable.get(0).get("Description"));
    }

    @Then("the user cliks pay button")
    public void the_user_cliks_pay_button() {
        System.out.println("click submit");
        payBillsPage.clickPayButton();
    }

    @Then("the user verifies payment message {string}")
    public void the_user_verifies_payment_message(String string) {
        System.out.println("verifies payment completed message: "+string);
        Assert.assertEquals(string,payBillsPage.getPaymentMessage());
    }




}

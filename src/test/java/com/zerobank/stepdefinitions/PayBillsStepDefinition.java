package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("the user clicks pay button")
    public void the_user_cliks_pay_button() {
        System.out.println("click submit");
        payBillsPage.clickPayButton();
    }

    @Then("the user verifies payment message {string}")
    public void the_user_verifies_payment_message(String string) {
        System.out.println("verifies payment completed message: "+string);
        Assert.assertEquals(string,payBillsPage.getPaymentMessage());
    }


    @Then("the user verifies warning message message {string}")
    public void the_user_verifies_warning_message_message(String string) {
        BrowserUtilities.wait(1);
        System.out.println("verifies warning message: "+string);
        Assert.assertEquals(string,payBillsPage.getValidationMessage());
    }

    @Then("the user enters amount and description:")
    public void the_user_enters_amount_and_description(List<Map<String,String>> dataTable) {
        System.out.println("user enters amount and description");
        payBillsPage.enterPayment(dataTable.get(0).get("Amount"));
        payBillsPage.enterDescription(dataTable.get(0).get("Description"));
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(List<Map<String,String>> dataTable) {
        payBillsPage.enterPayeeName(dataTable.get(0).get("Payee Name"));
        payBillsPage.enterPayeeAddress(dataTable.get(0).get("Payee Address"));
        payBillsPage.enterPayeeAccount(dataTable.get(0).get("Account"));
        payBillsPage.enterPayeeDetails(dataTable.get(0).get("Payee details"));
    }
    @Then("user clicks Add button")
    public void user_clicks_Add_button() {
       payBillsPage.clickAddButton();
    }

    @Then("message {string}")
    public void message(String string) {
       Assert.assertEquals(string,payBillsPage.getAlertMessage());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> strings) {

      Assert.assertTrue(payBillsPage.getCurrencyOptions().containsAll(strings));
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        payBillsPage.enterAmount("500");
        payBillsPage.clickCalculate();

    }

//    @Then("error message should be displayed")
//    public void error_message_should_be_displayed() {
//       //Assert.assertFalse(payBillsPage.getPopUpAlert().isEmpty());
//    }

    @Then("error message should be displayed {string}")
    public void error_message_should_be_displayed(String string) {

        Assert.assertEquals(string,payBillsPage.getPopUpAlert());


    }


}

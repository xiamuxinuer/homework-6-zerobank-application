package com.zerobank.stepdefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

   LoginPage loginPage=new LoginPage();


    @Given("the user on zerobank application homepage")
    public void the_user_on_zerobank_application_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtilities.waitForPageToLoad(10);
    }

    @When("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.clickSigninButton();
         loginPage.login();

    }

    @Then("the user verifies page title is {string}")
    public void the_user_verifies_page_title_is(String string) {
        System.out.println("verify pate title is : "+string);
        Assert.assertEquals(Driver.getDriver().getTitle(),string);
    }



    @When("the user enters invalid credentials username {string} and password {string}")
    public void the_user_enters_invalid_credentials_username_and_password(String string, String string2) {
        loginPage.clickSigninButton();
        loginPage.invalidCredentialLogin(string,string2);

    }

    @Then("the user verifies warning message {string}")
    public void the_user_verifies_warning_message(String string) {
        System.out.println("verify warning message: "+string);
        Assert.assertEquals(loginPage.getWarningMessage(),string);
    }




}

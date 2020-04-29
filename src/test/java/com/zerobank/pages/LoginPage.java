package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage  {



    @FindBy(id="user_login")
    public WebElement username;
    @FindBy(id="user_password")
    public WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath="//div[@class='alert alert-error']")
    public WebElement warningMessage;




    public void login(){

        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        //submitButton.click();
        BrowserUtilities.waitForPageToLoad(10);
    }


    public void invalidCredentialLogin(String usernameInput,String passwordInput){
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        submitButton.click();
        BrowserUtilities.waitForPageToLoad(10);
    }


    public String getWarningMessage(){
        return warningMessage.getText().trim();
    }



}

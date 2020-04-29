package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HomePage {

WebDriver driver= Driver.getDriver();
WebDriverWait wait=new  WebDriverWait(driver,15);

@FindBy(id = "signin_button")
  public WebElement signinButton;




    public HomePage(){
        PageFactory.initElements(driver,this);
    }


public void clickSigninButton(){
        signinButton.click();
}


}

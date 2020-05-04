package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
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
    BrowserUtilities.wait(1);
        signinButton.click();
}


public void navigateTo(String pageName){
        BrowserUtilities.wait(1);
        driver.findElement(By.linkText(pageName)).click();
}



}

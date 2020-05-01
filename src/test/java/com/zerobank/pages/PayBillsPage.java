package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends HomePage {
     @FindBy(id="pay_saved_payees")
    protected WebElement payButton;

     @FindBy(xpath = "//div[@id='alert_content']//span")
     protected WebElement paymentCompletedMessage;

    @FindBy(id ="sp_payee")
    protected WebElement selectPayee;
    @FindBy(id="sp_account")
    protected  WebElement selectAccount;

    @FindBy(id="sp_amount")
    protected WebElement paymentAmount;

    @FindBy(id="sp_date")
    protected WebElement date;
    @FindBy(id="sp_description")
    protected  WebElement description;



    public void setPayeeOption(String string){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sp_payee")));
        Select select=new Select(selectPayee);
        select.selectByVisibleText(string);
    }


    public void setAccount(String string){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sp_account")));
        Select select=new Select(selectAccount);
        select.selectByVisibleText(string);
    }



    public void enterPayment(String string){
        paymentAmount.sendKeys(string);
    }
    public void enterDate(String string){
        date.sendKeys(string);
    }

    public void enterDescription(String string){
        description.sendKeys(string);
    }

public void clickPayButton(){
    BrowserUtilities.wait(1);
        payButton.click();
}

public String getPaymentMessage(){
        BrowserUtilities.waitForPageToLoad(10);
        return paymentCompletedMessage.getText().trim();
}

}

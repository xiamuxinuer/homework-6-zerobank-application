package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

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

    @FindBy(id = "alert_content")
    protected  WebElement element;

//[id="np_new_payee_name"]
    @FindBy(id="np_new_payee_name")
    protected WebElement payeeNameInput;
 //id="np_new_payee_address"
    @FindBy(id="np_new_payee_address")
    protected WebElement payeeAddressInput;

//id="np_new_payee_account"
    @FindBy(id="np_new_payee_account")
    protected WebElement payeeAccountInput;
    //id="np_new_payee_details"
    @FindBy(id="np_new_payee_details")
    protected WebElement payeeDetails;

    //id="add_new_payee"
    @FindBy(id="add_new_payee")
    protected WebElement addButton;

    //id="alert_content"

    @FindBy(id="alert_content")
    protected WebElement alertMessage;

//id="pc_currency"
    @FindBy(id="pc_currency")
    protected  WebElement currencyOption;

 //id="pc_amount"

 @FindBy(id="pc_amount")
 protected WebElement amountInput;
//id="pc_calculate_costs"

    @FindBy(id="pc_calculate_costs")
    protected WebElement calculateButton;


    public void clickCalculate(){
        calculateButton.click();
        BrowserUtilities.wait(2);
    }
   public void enterAmount(String string){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pc_amount")));
        BrowserUtilities.wait(1);
       amountInput.sendKeys(string);
       BrowserUtilities.wait(1);
   }

 public String getPopUpAlert(){
       return driver.switchTo().alert().getText();
 }


public List<String> getCurrencyOptions(){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pc_currency")));
    BrowserUtilities.waitForPageToLoad(10);
    Select select=new Select(currencyOption);
    return BrowserUtilities.getTextFromWebElements(select.getOptions());
}



    public void enterPayeeName(String name){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("np_new_payee_name")));
        payeeNameInput.sendKeys(name);
    }


    public void enterPayeeAddress(String address){
        BrowserUtilities.waitForPageToLoad(10);
        payeeAddressInput.sendKeys(address);
    }

    public void enterPayeeAccount(String account){
        BrowserUtilities.waitForPageToLoad(10);
        payeeAccountInput.sendKeys(account);
    }

public void enterPayeeDetails(String details){
    BrowserUtilities.waitForPageToLoad(10);
    payeeDetails.sendKeys(details);
}
public void clickAddButton(){
        addButton.click();
        BrowserUtilities.wait(2);
}
public String getAlertMessage(){
        BrowserUtilities.waitForPageToLoad(10);

        return alertMessage.getText();
}

    public String getValidationMessage(){

        BrowserUtilities.wait(1);
        return date.getAttribute("validationMessage");
    }


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
    BrowserUtilities.wait(1);
}

public String getPaymentMessage(){
        BrowserUtilities.waitForPageToLoad(10);
        return paymentCompletedMessage.getText().trim();
}





}

package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage  extends HomePage{

    @FindBy(id = "aa_accountId")
    protected  WebElement selectId;


@FindBy(xpath = "//div[@id='all_transactions_for_account']//table//thead//tr")
protected List<WebElement> columnNames;

@FindBy(id="aa_fromDate")
protected  WebElement fromDateInput;

@FindBy(id="aa_toDate")
protected WebElement toDateInput;

@FindBy(xpath = "//button[text()='Find']")
protected WebElement findButton;


@FindBy(xpath = "(//tbody)[2]//tr//td[1]")
protected List<WebElement> dateList;

@FindBy(id="aa_description")
protected WebElement descriptionInput;

@FindBy(xpath ="(//tbody)[2]//tr//td[2]")
protected List<WebElement> descriptionList;

@FindBy(xpath = "(//tbody)[2]//tr//td[3]")
protected List<WebElement> depositList;

    @FindBy(xpath = "(//tbody)[2]//tr//td[4]")
    protected List<WebElement> withdrawalList;


    public void selectTransactionType(String string){
        WebElement type=driver.findElement(By.id("aa_type"));
        Select select=new Select(type);
        select.selectByVisibleText(string);
        BrowserUtilities.wait(1);
    }


    public List<String> getWithdrawalList(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody)[2]//tr//td[4]")));
        BrowserUtilities.wait(1);
        return BrowserUtilities.getTextFromWebElements(withdrawalList);
    }


public List<String> getDepositList(){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody)[2]//tr//td[3]")));
    BrowserUtilities.wait(1);
    return BrowserUtilities.getTextFromWebElements(depositList);
}



public void enterDescription(String description){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_description")));
    BrowserUtilities.wait(1);
    descriptionInput.clear();
    descriptionInput.sendKeys(description);
}

public List<String> getAllDescriptions(){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody)[2]//tr//td[2]")));
    BrowserUtilities.wait(1);
    return BrowserUtilities.getTextFromWebElements(descriptionList);
}

public List<String> getAllDate(){
    return BrowserUtilities.getTextFromWebElements(dateList);
}


public String getStartDate(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody)[2]//tr//td[1]")));
    return dateList.get(0).getText();

}
public String getEndDate(){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody)[2]//tr//td[1]")));
    return dateList.get(dateList.size()-1).getText();
}


public void enterDate(String from,String to){
    BrowserUtilities.waitForPageToLoad(15);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate")));
    fromDateInput.clear();
    toDateInput.clear();
    BrowserUtilities.wait(1);
    fromDateInput.sendKeys(from);
    toDateInput.sendKeys(to);
    System.out.println("enter start date: "+from);
    System.out.println("enter end date: "+to);



}
public void clickFindButton(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Find']")));
        BrowserUtilities.wait(1);
    findButton.click();
    System.out.println("click find button");
    BrowserUtilities.wait(3);
}




public String getSelectedOption(){
    BrowserUtilities.wait(1);
   Select select=new Select(selectId);
    return select.getFirstSelectedOption().getText();
}


public String getAllOptions(){
    BrowserUtilities.wait(1);
    Select select=new Select(selectId);
    List<WebElement> allOptions=select.getOptions();
    String allOptionsToString="";
    for (int i = 0; i <allOptions.size(); i++) {
        if (i==allOptions.size()-1){
            allOptionsToString+=allOptions.get(i).getText();
        }else {
            allOptionsToString+=allOptions.get(i).getText()+", ";
        }
    }
   return allOptionsToString;
}

public List<String> getColumnNames(){
     return BrowserUtilities.getTextFromWebElements(columnNames);
}

}

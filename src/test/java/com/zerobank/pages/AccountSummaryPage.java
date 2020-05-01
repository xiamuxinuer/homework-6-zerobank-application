package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountSummaryPage extends HomePage {

@FindBy(xpath = "//h2")
protected List<WebElement> accountTypes;

@FindBy(xpath = "(//table)[3]//thead//tr")
protected List<WebElement> creditAccountColumns;

@FindBy(linkText = "Account Activity")
protected WebElement accountActivityLink;


public String getAccountTypes(){
    BrowserUtilities.waitForPageToLoad(10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2")));
   String types="";
    for (int i = 0; i <accountTypes.size(); i++) {

        if (i==accountTypes.size()-1){
            types+=accountTypes.get(i).getText();
        }
        else {
            types+=accountTypes.get(i).getText()+", ";
        }
   }
    return types;
}

public String getCreditAccountColumns(){
    BrowserUtilities.waitForPageToLoad(10);

    String columnNames="";
    for (int i = 0; i <creditAccountColumns.size(); i++) {

        columnNames+=creditAccountColumns.get(i).getText();
    }



    return columnNames;
}






}

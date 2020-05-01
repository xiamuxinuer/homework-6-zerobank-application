package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage  extends HomePage{

    @FindBy(linkText = "Account Activity")
    protected WebElement accountActivityLink;


    @FindBy(id = "aa_accountId")
    protected  WebElement selectId;


@FindBy(xpath = "//div[@id='all_transactions_for_account']//table//thead//tr")
protected List<WebElement> columnNames;

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

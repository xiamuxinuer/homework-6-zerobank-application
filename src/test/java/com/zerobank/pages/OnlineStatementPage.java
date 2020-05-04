package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OnlineStatementPage extends HomePage {

////*[@id="os_2012"]/table/tbody/tr/td/a

public int getStatementCount(String string){

   String xpath = "//*[@id='os_"+string+"']/table/tbody/tr/td/a";

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    BrowserUtilities.wait(2);

    return driver.findElements(By.xpath(xpath)).size();

}

}

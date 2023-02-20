package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    public WikipediaSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    public WebElement searchBtn;

    @FindBy(css = "span.mw-page-title-main")
    public WebElement mainHeader;

    @FindBy(css = "div.fn")
    public WebElement imageHeader;

}

package com.cydeo.pages.webTablePages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
In this class we will store WebElement common to all pages
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderBtn;

    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement viewAllOrdersBtn;

    @FindBy(xpath = "//button[.='View all products']")
    public WebElement viewAllProductBtn;

    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logoutBtn;

}

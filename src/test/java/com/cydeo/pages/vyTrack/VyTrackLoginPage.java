package com.cydeo.pages.vyTrack;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='_username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='_password']")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement submitBtn;

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submitBtn.click();
    }

}

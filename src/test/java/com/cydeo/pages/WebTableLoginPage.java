package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[name='username']")
    public WebElement usernameBox;

    @FindBy(css = "input[name='password']")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;

    /**
     * This method will accept 2 parameters and login.
     *
     * @param username
     * @param password
     */
    public void login(String username, String password){
        this.usernameBox.sendKeys("Test");
        this.passwordBox.sendKeys("Tester");
        this.loginBtn.click();
    }

    /**
     * This method will log in using credentials from configuration.properties
     */
    public void loginWithConfig(){
        usernameBox.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("webTablePassword"));
        loginBtn.click();
    }

}

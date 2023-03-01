package com.cydeo.pages.vyTrack;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashboardPage {

    public VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutBtn;

    public void logout(){
        fullName.click();
        logoutBtn.click();
    }

}

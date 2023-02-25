package com.cydeo.pages.webTablePages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "select[name='product']")
    public WebElement productDropdown;

    @FindBy(css = "input[name='quantity']")
    public WebElement quantityBox;

    @FindBy(css = "input[name='name']")
    public WebElement costumerNameBox;

    @FindBy(css = "input[name='street']")
    public WebElement streetBox;

    @FindBy(css = "input[name='city']")
    public WebElement cityBox;

    @FindBy(css = "input[name='state']")
    public WebElement stateBox;

    @FindBy(css = "input[name='zip']")
    public WebElement zipcodeBox;

    @FindBy(xpath = "//input[@type='radio']/..")
    public List<WebElement> cardTypesRadios;

    @FindBy(name = "cardNo")
    public WebElement cardNoBox;

    @FindBy(name = "cardExp")
    public WebElement cardExpDateBox;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderBtn;
}

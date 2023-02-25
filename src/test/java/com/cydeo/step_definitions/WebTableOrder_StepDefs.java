package com.cydeo.step_definitions;

import com.cydeo.pages.webTablePages.BasePage;
import com.cydeo.pages.webTablePages.LoginPage;
import com.cydeo.pages.webTablePages.OrderPage;
import com.cydeo.pages.webTablePages.ViewAllOrdersPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDefs {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        loginPage.loginWithConfig();
        basePage.orderBtn.click();
    }

    @When("user select product type {string}")
    public void user_select_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByValue(string);
    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(int integer) {
        orderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        orderPage.quantityBox.sendKeys(String.valueOf(integer));
    }

    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
        orderPage.costumerNameBox.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.streetBox.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.cityBox.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.stateBox.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.zipcodeBox.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        for (WebElement eachRadio : orderPage.cardTypesRadios) {
            if (eachRadio.getText().equals(string)) {
                eachRadio.click();
                break;
            }
        }
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoBox.sendKeys(string);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpDateBox.sendKeys(string);
    }

    @When("user click process order button")
    public void user_click_process_order_button() {
        orderPage.processOrderBtn.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {
        Assert.assertTrue(viewAllOrdersPage.firstRowName.isDisplayed());
        Assert.assertEquals(string, viewAllOrdersPage.firstRowName.getText());
    }


}

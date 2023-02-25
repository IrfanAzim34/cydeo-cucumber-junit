package com.cydeo.step_definitions;

import com.cydeo.pages.webTablePages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefs {

    LoginPage LoginPage = new LoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        LoginPage.usernameBox.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        LoginPage.passwordBox.sendKeys(string);
    }

    @When("user click to login button")
    public void user_click_to_login_button() {
        LoginPage.loginBtn.click();
    }

    @Then("user should see url end with {string}")
    public void user_should_see_url_end_with(String value) {
        BrowserUtils.verifyURLEndWith(value);
    }

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
        LoginPage.login(username,password);
    }

    @Then("user should see url contains {string}")
    public void user_should_see_url_contains(String string) {
        BrowserUtils.verifyURLContains(string);
    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
        LoginPage.login(credentials.get("username"),credentials.get("password"));
    }
}

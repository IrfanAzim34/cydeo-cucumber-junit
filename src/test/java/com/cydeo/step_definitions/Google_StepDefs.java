package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @Given("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitle = "apple - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Titles were not matched!",expectedTitle,actualTitle);
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string + Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedTitle = string + " - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Titles were not matched!",expectedTitle,actualTitle);
    }

}

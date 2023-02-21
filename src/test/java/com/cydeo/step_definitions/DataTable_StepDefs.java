package com.cydeo.step_definitions;

import com.cydeo.pages.DropDownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefs {


    @Then("user should see fruits I like")
    public void usr_should_see_fruits_i_like(List<String> fruits) {
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    DropDownsPage dropDownsPage = new DropDownsPage();
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        List<String> actualMonths = new ArrayList<>(
                BrowserUtils.dropdownOptionsAsString(dropDownsPage.monthDropdown));

        Assert.assertEquals(expectedMonths,actualMonths);
    }

}

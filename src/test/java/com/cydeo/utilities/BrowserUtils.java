package com.cydeo.utilities;
/*
In this class only general utility method that are not related to some specific page.
 */

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /*
    1. Create a new class called BrowserUtils
    2. Create a method to make Task1 logic re-usable
    3. When method is called, it should switch window and verify title.


    Method info:
            • Name: switchWindowAndVerify
            • Return type: void
            • Arg1: WebDriver
            • Arg2: String expectedInUrl
            • Arg3: String expectedTitle

     */

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {

        Set<String> allTabs = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allTabs) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Actual title is not match", actualTitle.contains(expectedTitle));

    }

    /*
    This method accept a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    /**
     * This method will accept a String as expected value and verify actual URL end with value.
     *
     * @param value
     */
    public static void verifyURLEndWith(String value) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(value));
    }

    /**
     * This method will accept a String as expected value and verify actual URL contains this value
     *
     * @param value
     */
    public static void verifyURLContains(String value) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(value));
    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method will accept a dropdown as a WebElement and return all the options' text in a List of String
     * @param dropdownElement
     * @return
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement webElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(webElement.getText());
        }

        return actualOptionsAsString;
    }

}

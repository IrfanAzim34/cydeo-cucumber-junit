package com.cydeo.utilities;
/*
In this class only general utility method that are not related to some specific page.
 */

import org.junit.Assert;

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

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allTabs = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allTabs) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
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
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void sleep(int second){
        try{
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}

Feature: User should be able to login using correct credentials


  Scenario: Positive login scenario#1
    Given user is on the login page of web table app
    When user enters username "Test"
    And user enters password "Tester"
    And user click to login button
    Then user should see url end with "orders"


  Scenario: Positive login scenario#2
    Given user is on the login page of web table app
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains "orders"
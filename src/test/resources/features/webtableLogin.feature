Feature: User should be able to login using correct credentials

  Background: user is on the lgin page
    Given user is on the login page of web table app

  Scenario: Positive login scenario#1
    When user enters username "Test"
    And user enters password "Tester"
    And user click to login button
    Then user should see url end with "orders"


  Scenario: Positive login scenario#2
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains "orders"


  Scenario: Positive login scenario#3
    When user enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains "orders"
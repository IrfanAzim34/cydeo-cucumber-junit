Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user select product type "Familybea"
    And user enters quantity 2
    And user enters costumer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "MasterCard"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user click process order button
    Then user should see "Sherlock Holmes" in first row of the web table


  Scenario Template: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user select product type "<productType>"
    And user enters quantity <quantity>
    And user enters costumer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expiryDate>"
    And user click process order button
    Then user should see "<customerName>" in first row of the web table

    Examples:
      | productType | quantity | customerName    | street    | city   | state   | zipCode | cardType         | cardNumber       | expiryDate |
      | Familybea   | 2        | Sherlock Holmes | London st | London | England | 50505   | MasterCard       | 1111222233334444 | 12/24      |
      | MoneyCog    | 3        | Marie Curie     | London st | London | England | 50505   | Visa             | 1111222233334444 | 12/24      |
      | Screenable  | 10       | Lise Meitner    | London st | London | England | 50505   | American Express | 1111222233334444 | 12/24      |
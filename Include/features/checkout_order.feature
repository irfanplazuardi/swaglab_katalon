Feature: Checkout Item

 
  Scenario Outline: Successfully checkout order item
    Given User login with valid <username> and <password> 
    When  add item to cart
    And Access cart details by click cart icon
    Then Click checkout should successfully checkout item

    Examples: 
      | username  		| password 								|
      | standard_user |qcu24s4901FyWDTwXGr6XA== | 
     
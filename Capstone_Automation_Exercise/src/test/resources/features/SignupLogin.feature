Feature: Signup and Login functionality

  Scenario Outline: Signup with new user
    Given I open the application
    When I navigate to Signup/Login page
    And I enter new name "<name>"
    And I enter new email "<email>"
    And I click on Signup button
    And I fill the signup form with password "<password>" date of birth "<day>" "<month>" "<year>"
    And I enter personal details "<fname>" "<lname>" "<address>" "<country>" "<state>" "<city>" "<zip>" "<mobile>"
    And I click Create Account button
    Then I should see message "<expectedMessage>"

    Examples:
      | name | email             | password  | day | month | year | fname | lname | address     | country | state            | city    | zip    | mobile     | expectedMessage  |
      | Bo | bo123@gmail.com | Bo@123  | 21  | June  | 1996 | Bo | Sharma| Abc colony | India   | Andhra Pradesh   | Tirupati| 517503 | 9876543210 | ACCOUNT CREATED! |

  Scenario Outline: Signup with existing user
    Given I open the application
    When I navigate to Signup/Login page
    And I enter new name "<name>"
    And I enter new email "<email>"
    And I click on Signup button
    Then I should see error message "<expectedMessage>"

    Examples:
      | name  | email            | expectedMessage                  |
      | Diana | diana@gmail.com  | Email Address already exist!     |

  Scenario Outline: Login with valid user
    Given I open the application
    When I navigate to Signup/Login page
    And I enter login email "<email>"
    And I enter login password "<password>"
    And I click on Login button
    Then I should see text containing "<expectedText>"

    Examples:
      | email           | password     | expectedText     |
      | diana@gmail.com | Dimple@123   | Logged in as     |

  Scenario Outline: Login with invalid user
    Given I open the application
    When I navigate to Signup/Login page
    And I enter login email "<email>"
    And I enter login password "<password>"
    And I click on Login button
    Then I should see error message "<expectedMessage>"

    Examples:
      | email          | password   | expectedMessage                       |
      | maxy@gmail.com | Maxy@123   | Your email or password is incorrect!  |

      

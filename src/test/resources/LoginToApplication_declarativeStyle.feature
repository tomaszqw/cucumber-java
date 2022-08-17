Feature: Login action - declarative Gherkin style

  Scenario: Successfully login as a standard user
    Given I go to the login page
    When I try login as a standard user
    Then I should see main page with appropriate products

  Scenario: Login to application as a broken settings user
    Given I go to the login page
    When I try login as a problem user
    Then I should see main page with appropriate products


  Scenario: Try to login as a user with performance glitch
    Given I go to the login page
    When I try login as a user with performance glitch
    Then I should see main page with appropriate products


  Scenario: Try login as a blocked user
    Given I go to the login page
    When I try login as a blocked user
    Then I should see error message that user is blocked

  Scenario: Try login without filling login form
    Given I go to the login page
    When I click login button
    Then I should see error message that username is required

  Scenario: Try login with incorrect password
    Given I go to the login page
    When I fill login form with incorrect password
    Then I should see error message that data is incorrect

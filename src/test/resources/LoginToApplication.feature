Feature: Login action

  Scenario: Successfully login as a standard user
    Given I go to the login page
    When I fill login field with data "standard_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page

  Scenario: Try to login as a locked user
    Given I go to the login page
    When I fill login field with data "locked_out_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page

  Scenario: Login to application as a broken settings user
    Given I go to the login page
    When I fill login field with data "problem_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page

  Scenario: Try to login as a user with performance glitch
    Given I go to the login page
    When I fill login field with data "performance_glitch_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page

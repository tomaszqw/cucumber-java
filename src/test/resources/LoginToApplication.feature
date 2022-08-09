Feature:

  Scenario:
    Given I go to the login page
    When I fill login field with data "standard_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page

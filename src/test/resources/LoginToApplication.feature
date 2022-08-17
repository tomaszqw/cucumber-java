Feature: Login action - imperative Gherkin style

  Scenario: Successfully login as a standard user
    Given I go to the login page
    When I fill login field with data "standard_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page with products
      | Product title                     | Product description                                                                                                                                                    | Product price |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | $29.99        |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99         |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99        |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99        |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | $7.99         |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | $15.99        |

  Scenario: Login to application as a broken settings user
    Given I go to the login page
    When I fill login field with data "problem_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page with products
      | Product title                     | Product description                                                                                                                                                    | Product price |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | $29.99        |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99         |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99        |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99        |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | $7.99         |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | $15.99        |

  Scenario: Try to login as a user with performance glitch
    Given I go to the login page
    When I fill login field with data "performance_glitch_user"
    And I fill password field with data "secret_sauce"
    And I click login button
    Then I should see main page with products
      | Product title                     | Product description                                                                                                                                                    | Product price |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | $29.99        |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99         |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99        |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99        |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | $7.99         |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | $15.99        |

  Scenario Outline: Unsuccessful login attempt
    Given I go to the login page
    When I fill login field with data "<login>"
    And I fill password field with data "<password>"
    And I click login button
    Then I should see login error message "<message>"
    Examples:
      | login           | password          | message                                                                   |
      | locked_out_user | secret_sauce      | Epic sadface: Sorry, this user has been locked out.                       |
      |                 |                   | Epic sadface: Username is required                                        |
      | locked_out_user | incorrectpassword | Epic sadface: Username and password do not match any user in this service |

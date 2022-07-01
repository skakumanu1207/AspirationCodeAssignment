@assignment
Feature: Verify and validate the Aspiration products

  @assignment1
  Scenario: Verify user can able to navigate to Aspiration Products
    Given I launch the Aspiration application using URL "https://www.aspiration.com/"
    When I  Click on Spend And Save Button on Home page
    Then Verify I am on Spend And Save Page
    And verify I see product "Aspiration" on Product Page
    And verify I see product "Aspiration Plus" on Product Page
    And I close the application

  @assignment1
  Scenario: Verify the Sign up process for Aspiration
    Given I launch the Aspiration application using URL "https://www.aspiration.com/"
    When I  Click on Get Started Button on Home page
    Then Verify I see Email address textbox on popup modal
    And I close the application

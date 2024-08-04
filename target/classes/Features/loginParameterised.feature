Feature: Free CRM Login feature

  Scenario Outline: FreeCRM login scenario
    Given User is on the login page
    When User enters <username> and <password>
    And User clicks on login button
    Then User is navigated to Home page

    Examples: 
      | username        | password   |
      | groupautomation | Test@12345 |
      | groupautomation | Test@12345 |

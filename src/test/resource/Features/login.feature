Feature: FreeCRM Login feature

  Scenario: FreeCRM Login test scenario
    Given User is already on Login Page
    When user enters username and password
    And user clicks on login button
    Then user is navigated to Home Page



Feature: FreeCRM Contacts page feature

  @smoke
  Scenario Outline: FreeCRM login scenario
    Given User is on the login page
    When User enters <username> and <password>
    And User clicks on login button
    Then User is navigated to Home page
    Then User clicks on New Contacts menu option under Contacts Menu
    And User input new contacts details <firstname> and <lastname> and <position>
    Then User saves new contact details

    Examples: 
      | username        | password   | firstname | lastname | position       |
      | groupautomation | Test@12345 | Veena     | Verma    | Sr.HR          |
      | groupautomation | Test@12345 | Bharath   | Gopi     | Lead Architect |

Feature: login
  Scenario: the user can log in with valid credentials
    Given We are on the login page
    When The user enters valid credentials
    Then The page navigates to the main page

  Scenario: the user can not log in with invalid credentials
    Given We are on the login page
    When The user enters invalid credentials
    Then The page stays on login page
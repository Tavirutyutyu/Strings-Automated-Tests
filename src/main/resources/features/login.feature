Feature: login
  Scenario: the user can log in with valid credentials
    Given We are on the login page
    When The user enters valid credentials
    Then The page navigates to the main page

  Scenario: the user can not log in with invalid credentials
    Given We are on the login page
    When The user enters invalid credentials
    Then The page shows a popup

  Scenario: the page alerts the user if an input field is left empty
    Given We are on the login page
    When The user leaves username or password field empty
    Then The site puts cursor in first empty input field
Feature: Dark mode
  Scenario: switch to dark mode
    Given We are logged in with "asd" / "password" credentials
      And We are on the main page
      And We are in light mode
    When We click dark mode button
    Then Page changes to dark mode
Feature: make a post
  Scenario: the user can make a post
    Given We are logged in with "asd" : "12345" credentials
    When The user makes a post with text "text"
    Then The post "text" appears on the feed
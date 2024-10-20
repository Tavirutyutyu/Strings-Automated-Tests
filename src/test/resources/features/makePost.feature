Feature: make a post
  @DeletePost
  Scenario: the user can make a post
    Given We are logged in with "asd" : "12345" credentials
    When The user makes a post with text "text"
    Then The post "text" appears on the feed

  Scenario: the user cant post an empty post
    Given  We are logged in with "asd" : "12345" credentials
    When The user makes a post with text ""
    Then The site stays on post creation page
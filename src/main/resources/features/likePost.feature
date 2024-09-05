Feature: like post
  Scenario: The user likes a post that has not been liked
    Given We are logged in with "asd" : "12345" credentials
    And A post "new post" is made
    When The user likes an unliked post "new post"
    Then The hearth icon becomes red at post "new post"

  Scenario: The user unlikes a post that has been liked
    Given We are logged in with "asd" : "12345" credentials
    And A post "another new post" is made and liked
    When The user unlikes a liked post "another new post"
    Then The hearth icon becomes white at post "another new post"
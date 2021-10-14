
Feature: TeamShares
  Scenario: Create Team Share
    When I get token for user with email "admin@admin.com" and password "1qazXSW@"
    Then I create an organization
    Then I create an orgAdmin user
    Then I create a user
    Then I login on Web by orgAdmin
    Then I create a team share and check it exists on Web
    And I delete organization

  Scenario: Can't create a Team Share without name
    When I get token for user with email "admin@admin.com" and password "1qazXSW@"
    Then I create an organization
    Then I create an orgAdmin user
    Then I create a user
    Then I login on Web by orgAdmin
    Then I can't create a team share on Web without name
    And I delete organization
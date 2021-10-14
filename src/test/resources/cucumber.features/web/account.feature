#language:en


  Feature: Accounts

    Scenario: Create Account
      When I get token for user with email "admin@admin.com" and password "1qazXSW@"
      Then I create an organization
      Then I create an orgAdmin user
      Then I login on Web by orgAdmin
      And I create an account on Web and compare the results via API
      And I delete organization

    Scenario: Password mismatch when creating an account
      When I get token for user with email "admin@admin.com" and password "1qazXSW@"
      Then I create an organization
      Then I create an orgAdmin user
      Then I login on Web by orgAdmin
      And I check password mismatch when creating an account
      And I delete organization

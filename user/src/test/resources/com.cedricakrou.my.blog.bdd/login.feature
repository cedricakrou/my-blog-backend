Feature: User login

  Scenario: Login Successfully
    Given I have a user registered.
    When I enter "cedricakrou" and password "Open1234#"
    Then I "account" will be logged in.
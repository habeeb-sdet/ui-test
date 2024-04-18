Feature: amazon site

  Background:
    And And User navigates to "amazon" site

  Scenario Outline: Validate amazon login with different credentials set
    Given User navigates to sign-in page
    And User enters "<username>"
    When User click on continue button
    Then Error message should be displayed
    Examples:
    |username |
    |habeeb   |
    |mohamed  |
Feature: Search Products

  Background:
    Given User navigates to "Sauce lab demo app" site

  Scenario Outline: validate login with invalid credentials
    Given User enters "<username>" and "<password>"
    When User click on login button
    Then Error message should be displayed
    Examples:
    |username      |password      |
    |invaliduser   |secret_sauce  |
    |standard_user |invalid_pwd   |
    |              |secret_sauce  |
    |standard_user |              |

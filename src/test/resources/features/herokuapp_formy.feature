Feature: Herokuapp-formy-project

  Background:
    Given User navigates to "Heroku app formy project" site

  Scenario Outline: Validate checkbox scenarios
    Given User clicks and navigate to "checkbox" page
    When User clicks on "<checkbox>"
    Then "<checkbox>" selection status should be "<status1>"
    When User clicks on "<checkbox>"
    Then "<checkbox>" selection status should be "<status2>"
    Examples:
    |checkbox   |status1 |status2 |
    |Checkbox1  |true    |false   |
    |Checkbox2  |true    |false   |
    |Checkbox3  |true    |false   |
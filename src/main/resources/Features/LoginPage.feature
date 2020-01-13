Feature: Application Login Page

  Background: User navigates to application
    Given User navigates to application login page

  @Case1
  Scenario Outline: Verify user is able to login to application
    Given User enter valid credentials <Username> and <Password>
    Then User should be on home page

    Examples: 
      | Username |
      | uid      |

  @Case2
  Scenario Outline: Verify error message is displayed when user  is not able to login to application
    Given User enter invalid credentials <Username> and <Password>
    Then Error message should be displayed

    Examples: 
      | Username |
      | uid      |

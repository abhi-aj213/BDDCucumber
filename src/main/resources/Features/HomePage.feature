Feature: Application HomePage

  Background: User navigates to application
    Given User navigates to application login page

  @Case3
  Scenario Outline: Verify user is at Homepage
    Given User enter valid credentials <Username> and <Password>

    Examples: 
      | Username |
      | uid      |

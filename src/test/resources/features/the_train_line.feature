Feature: The Train Line
  As a Train Line user
  I want to be able to search journey details between two locations
  So that I can get information on times and prices

  Scenario: Search for journey details between two locations
    Given I am on "https://www.thetrainline.com"
    When I set the journey from "Brighton" to "London"
    Then  I click the button to get times and tickets

Feature: The Train Line
  As a Train Line user
  I want to be able to search for journey details between two locations
  So that I can get information on times and prices


  Background:
    Given I am on the Trainline homepage

  Scenario: Exercise 1 & 2: Search for journey details between two locations
    When I set the journey from "Brighton" to "London"
    Then  I click the button to get times and tickets
    And I see journey information for "Brighton" to "London"

  Scenario: Exercise 3: Search for journey details between two locations
    When I set the journey from "Brighton" to "London"
    And I select the return button
    And I select Tomorrow for outward journey
    And I select Next day for return journey
    Then  I click the button to get times and tickets
    And I see journey information for "Brighton" to "London"

  Scenario: Exercise 5
    When I set the journey from "Brighton" to "London"
    And I select the return button
    And I select the outward journey to be "90" days in the future
    And I select Next day for return journey
    Then  I click the button to get times and tickets
    And I see journey information for "Brighton" to "London"

  Scenario: Plan journey - list times and prices for a single journey for 2 adults and 2 children
    When I set the journey from "Brighton" to "London"
    And I set the number of adults to "2" and the number of children to "2"
    Then  I click the button to get times and tickets
    And I see journey information for "Brighton" to "London"
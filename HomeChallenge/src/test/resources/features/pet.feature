Feature: Validate the correct behavior of the pet API
  As a QA tester
  I need to validate the correct functionality of the pet api
  To ensure its correct execution

  @PT1
  Scenario: Validate with user in login the correct creation of pet
    When the user enters the credentiales
    And the user creates a new pet to the store with new id 15
    And the user obtains for id 15 information about the created pet
    Then he will visualize its correct creation

  @PT2
  Scenario: Delete pet
    When the user enters the credentiales
    And the user creates a new pet to the store with new id 16
    And the user delete new pet for same id 16
    Then he will visualize a delete message

  @PT3
  Scenario: Pet not found
    When the user enters the credentiales
    And the user obtains for id 100000 bad information about pet
    Then he will visualize a error message



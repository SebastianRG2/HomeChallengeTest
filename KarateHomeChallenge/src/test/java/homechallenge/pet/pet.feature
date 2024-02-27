Feature: Pet
  As a QA tester,
  I want to smoke test the successful responses of the pet APIs
  To verify their correct functionality.

  Background:
    * url 'http://localhost:8080/api/v3'
    * def pet =
      """
      {
        "id": 18,
        "name": "doggie",
        "category": {
        "id": 1,
        "name": "Dogs"
         },
         "photoUrls": [
         "url"
          ],
         "tags": [
          {
            "id": 0,
             "name": "Tag"
          }
                ],
          "status": "available"
      }
      """

  Scenario: Test create pet API
    Given path 'pet'
    And request pet
    When method post
    Then status 200

  Scenario: Test put pet API
    Given path 'pet'
    And request pet
    When method put
    Then status 200

  Scenario: Test put and create pet API bad input
    Given path 'pet'
    And request pet
    When method get
    Then status 405

  Scenario: Test delete pet API bad input
    Given path 'pet/' + 18
    When method delete
    Then status 200

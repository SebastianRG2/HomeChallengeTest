Feature: Store
  As a QA tester,
  I want to smoke test the successful responses of the Store APIs
  To verify their correct functionality.

  Background:
    * url 'http://localhost:8080/api/v3'

  Scenario: Test inventory API
    Given path 'store/inventory'
    When method get
    Then status 200

  Scenario: Test store order API and order by id API

    * def order =
      """
      {
        "id": 15,
        "petId": 198772,
        "quantity": 7,
        "shipDate": "2024-02-27T00:12:38.299Z",
        "status": "approved",
        "complete": true
      }
      """

    Given path 'store/order'
    And request order
    When method post
    Then status 200

    * def order = response.id

    Given path 'store/order/' + order
    When method get
    Then status 200



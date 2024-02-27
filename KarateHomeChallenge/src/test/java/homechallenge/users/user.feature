Feature: User
  As a QA tester,
  I want to smoke test the successful responses of the User APIs
  To verify their correct functionality.

  Background:
    * url 'http://localhost:8080/api/v3'

  Scenario: Login
    Given path 'user/login'
    And param username = 'Pepe'
    And param password = '123456'
    When method get
    Then status 200

  Scenario: Logout
    Given path 'user/logout'
    When method get
    Then status 200
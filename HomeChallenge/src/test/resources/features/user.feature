Feature: Validate the correct functioning in login options with user
  As a QA tester
  I need to validate that the login-related options work correctly
  To ensure that the user can log in without problems

  @US1
  Scenario: Login user
    Given that the user register
    When the user enters the credentiales
    Then the user should see their correct login


  @US2
  Scenario: Logout user
    Given that the user register
    When the user enters the credentiales
    And the user logout
    Then he see the message logout






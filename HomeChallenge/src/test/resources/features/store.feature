Feature: Validate the correct functioning in a pet store
  As a QA tester
  I need to check the functionality of the store's orders and inventory
  To ensure proper functioning in the store

  @ST1
  Scenario Outline: Create order and consult in inventory in status approved
    Given the user consults the inventory with status '<status>'
    When the user places another order with status '<status>'
    Then the user should see the increase of orders in the inventory
    Examples:
      | status    |
      | approved  |
      | placed    |
      | delivered |

    @ST2
    Scenario: Message error for bad input
      When the user enters the credentiales
      And the user send bad input for place order
      Then the user should see the bad input message
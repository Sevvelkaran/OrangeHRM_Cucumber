Feature: Assign Leave to Employee in OrangeHRM

  Background:
    Given I am logged into OrangeHRM with url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Assign leave successfully to a valid employee
    When the user navigates to the Leave module
    And the user clicks on Assign Leave
    And the user enters leave details:
      | EmployeeName 	| LeaveType      |	FromDate		|	ToDate			|
      | Trystan Sipes | CAN - Vacation | 2024-12-01 	| 2025-12-05  |

    And the user clicks the Assign button
    Then the leave should be assigned successfully

    
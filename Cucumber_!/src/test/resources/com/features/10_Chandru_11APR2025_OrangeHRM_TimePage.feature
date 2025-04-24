Feature: Manage Timesheets in OrangeHRM

  Background: 
    Given I am logged into OrangeHRM with url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
@Valid
  Scenario: Create a new timesheet for a valid employee
    When I navigate to the Time module
    And I click on Timesheets
    And I search and select "Employee Timesheets"
    And I select an employee
    And I click on "View" to check the employee timesheet
    And I click on "Create Timesheet"
    Then a new timesheet should be created

@Invalid
  Scenario: Display error message for an invalid employee
    When I navigate to the Time module
    And I click on Timesheets
    And I search and select "Employee Timesheets"
    And I enter an invalid employee name
    And I click on "View" to check the employee timesheet
    Then "Invalid Employee Name" message should be displayed and the timesheet should not be created
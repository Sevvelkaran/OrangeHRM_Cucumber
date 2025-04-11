@Performance
Feature: Log time for Employee Trackers in OrangeHRM Application

  @Trackers
  Scenario: Add a new performance tracker with reviewers
    Given The user launches the browser and navigates to the Performance module
    When The user clicks on Configure and selects Trackers
    And The user clicks the Add button
    And The user enters the following tracker details
      | Tracker Name | Employee Name | Reviewers  |
      | Sevvel       | Thoushi F     | Thoushi F  |
    And The user clicks the Save button
    Then The tracker "Sevvel" should be successfully added
    
    
  @TrackersNegative
  Scenario: Add a performance tracker with invalid employee details
    Given The user launches the browser and navigates to the Performance module
    When The user clicks on Configure and selects Trackers
    And The user clicks the Add button
    And The user enters the invalid tracker details
      | Tracker Name | Employee Name | Reviewers  |
      | Sevvel       |               | Thoushi F  |
      #|              | Dharani M     | Thoushi F  |
    And The user clicks the Save button
    Then The system should display an error message indicating "Required" 
  
    
    
    
    #@EmployeeTrackers
    #Scenario: Add Timelog to the Employee Performance Trackers
    #Given The user launches the browser and navigates to the Performance module
    #When the user clicks on Employee Trackers and click View button
    #And The user clicks the Add log button
    #And fills the following Log Details
    #|   Log                                                        |      Comment                                                                                                      |
    #| Ensure all test steps are documented clearly                 |     Well done completing the Performance module.Please ensure documentation is updated and test cases are reviewed|
    #
    #And click Save button
    #Then The log entry should be successfully added
    
    #@EmployeeTrackersNegative
    #Scenario Outline: Add Timelog with missing required fields
    #Given The user launches the browser and navigates to the Performance module
    #When The user clicks on Employee Trackers and clicks the View button
    #And The user clicks the Add Log button
    #And The user enters the following log details
      #| <Log>  | <Comment> |
    #And The user clicks the Save button
    #Then The user should see "Required" message for the empty field
#
    #Examples:
      #| Log                                     | Comment                                     |
      #|                                         | Please ensure test cases are reviewed.      |
      #| Completed the Performance module tasks  |                                             |

@Performance
Feature: Adding Tracker Details in Tracker field

Background:
    Given The user launches the browser and navigates to the Performance module  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

    
  @Trackers
  Scenario: Add a new performance tracker with reviewers
  
    And navigates to the Performance module
   And The user clicks on Configure and selects Trackers
    And The user clicks the Add button
    And The user enters the following tracker details
      | Tracker Name | Employee Name | Reviewers  |
      | Sevvel       |    dhaar      |   laks     |
    And The user clicks the Save button
    Then The tracker "Sevvel" should be successfully added
    
    
  @TrackersNegative
  Scenario: Add a performance tracker with invalid employee details
  
    And navigates to the Performance module
    And The user clicks on Configure and selects Trackers
    And The user clicks the Add button
    And The user enters the invalid tracker details
      | Tracker Name | Employee Name | Reviewers  |
      | Sevvel       |               | Thoushi F  |
      
    And The user clicks the Save button
    Then The system should display an error message indicating "Required" 
  
    
    
    
  
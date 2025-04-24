@PerformanceTrackers
Feature: Thoushika_14APR2025_OrangeHRM_Performance2

Background:
    Given The user launches the browser and navigates to the Performance module  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"


@ManageReviews
  Scenario: Verifying the Job Title and Review Status in Manage Reviews
  When navigates to the Performance module
  And the user clicks Manage Reviews and selects My Reviews
  Then verify the following credentials
    | Job Title   | Review Status |
    | HR Manager  |  Activated    |

 @MyTrackers
 Scenario: Verifying the Tracker name in My Trackers
 When navigates to the Performance module
 And the user clicks My Trackers
 Then verify the Tracker Name in MyPerformance Trackers 
 
 @EmployeeTrackers
 Scenario: Searching the Employee name in Employee Trackers
  When navigates to the Performance module
  And the user clicks Employee Trackers 
  And Enter the Employee Name and Include
  And Click Search
  Then verify the Employee Name is searched in Employee Trackers
  
 
 @EmployeeTrackers
  Scenario: Searching the Employee name in Employee Trackers (Invalid)
  When navigates to the Performance module
  And the user clicks Employee Trackers 
  And Enter the invalid Employee Name and Include
  And Click Search
  Then verify the message "Invalid" is shown in Employee Trackers
  
 
  

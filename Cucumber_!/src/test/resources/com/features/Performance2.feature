@PerformanceTrackers
Feature: Accessing Manage Reviews,Trackers,Employee Trackers Fields

Background:
 #Given The user launches the browser and navigates to the Performance module
 Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login

@ManageReviews
  Scenario: Verifying the Job Title and Review Status in Manage Reviews
  And navigates to the Performance module
  When the user clicks Manage Reviews and selects My Reviews
  Then verify the following credentials
    | Job Title   | Review Status |
    | HR Manager  |  Activated    |

 @MyTrackers
 Scenario: Verifying the Tracker name in My Trackers
 And navigates to the Performance module
 When the user clicks My Trackers
 Then verify the Tracker Name in MyPerformance Trackers 
 
 @EmployeeTrackers
 Scenario: Searching the Employee name in Employee Trackers
  And navigates to the Performance module
  When the user clicks Employee Trackers 
  And Enter the Employee Name and Include
  And Click Search
  Then verify the Employee Name is searched in Employee Trackers
  
 
 @EmployeeTrackers
  Scenario: Searching the Employee name in Employee Trackers (Invalid)
   And navigates to the Performance module
  When the user clicks Employee Trackers 
  And Enter the invalid Employee Name and Include
  And Click Search
  Then verify the message "Invalid" is shown in Employee Trackers
  
 
  
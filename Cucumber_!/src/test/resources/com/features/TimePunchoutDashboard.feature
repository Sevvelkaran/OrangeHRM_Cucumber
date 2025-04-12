@tag
Feature: Dashboard
  I want to go to the dashboard and assert the elements

  @To_Punch_Out
  Scenario: Time at Work
    Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username and password to login
    When The user is on the dashboard and clicks on the clock icon in the Time at Work section
    And The user enters the out time and punches out
    Then Assert that the user is on the Dashboard page
    
    
     @QuickLaunch_Assert
  Scenario Outline: QuickLaunch Assert
  
    And Assert the name Dashboard "<Dashboard>"
    Then the user asserts all the quick Action "<QuickAction>"
    

    Examples: 
      | Dashboard  | QuickAction  |
      | Dashboard  | Assign Leave |
      | Dashboard  | Leave List   |
      | Dashboard  | Timesheets   |
      | Dashboard  | Apply Leave  |
      | Dashboard  | My Leave     |
      | Dashboard  | My Timesheet |
    
    

    
@Admin
Feature: Adding Education Details in Admin Qualifications

Background:
  Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login

  
@DuplicateEducation
  Scenario: Adding an already existing Education Detail should show an error
  
  And the user navigates to the Admin module
    And the user clicks on Qualifications and selects Education
    And clicks the Add button
    And enters the following Education Details
      | Level                        |
      | Information Technology       |
    And clicks to the Save button
  
    And the user navigates to the Admin module
    And the user clicks on Qualifications and selects Education
    And clicks the Add button
    And enters the following Education Details
      | Level                       |
      | Information Technology      |
    And clicks to the Save button
    Then verify that an error message "Already exists" is displayed
    
    @EmptyfieldEducation
    Scenario: Providing an empty value in Education field in Qualifications
     And the user navigates to the Admin module
     And the user clicks on Qualifications and selects Education
     And clicks the Add button
     And enters the following Education Details
       |  Level     |
       |            |
      And clicks to the Save button
     Then verify the error message "Required" is displayed
     

    
@DuplicateMemberships
    Scenario: Adding an already existing Memberships Detail should show an error
    And the user navigates to the Admin module
    And the user clicks the Qualificatins and selects Memberships
    And clicks the Add button
    And enters the following Membership Details
    |      Name                                        | 
    |  Computer Society of India(CSI)                  |
    And clicks to the Save button
    
    
    And the user navigates to the Admin module
    And the user clicks the Qualificatins and selects Memberships
    And clicks the Add button
    And enters the following Membership Details
    |      Name                                         | 
    |   Computer Society of India(CSI)                  |
    And clicks to the Save button
    Then verify that an error message "Already exists" is displayed
    
   
    @EmptyfieldMemberships
    Scenario: Providing an empty value in Memberships field in Qualifications
     And the user navigates to the Admin module
     And the user clicks the Qualificatins and selects Memberships
     And clicks the Add button
     And enters the following Membership Details
       |  Name      |
       |            |
     And clicks to the Save button 
     Then verify the error message "Required" is displayed
    
    
    
  

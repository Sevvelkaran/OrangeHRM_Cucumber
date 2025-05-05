@Admin
Feature: Thoushika_12APR2025_OrangeHRM_Admin

      
  @Education
  Scenario Outline: Adding Education Details in Education field in Qualifications
   Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And the user navigates to the Admin module
    And the user clicks on Qualifications and selects Education
    And clicks the Add button
    And enters the following Education Details
      | Level                        |
      | Information Technology       |
    And clicks to the Save button
    Then verify that the Education Details are successfully added
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |

  @DuplicateEducation
  Scenario Outline: Adding an already existing Education Detail should show an error
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And the user navigates to the Admin module
    And the user clicks on Qualifications and selects Education
    And clicks the Add button
    And enters the following Education Details
      | Level                       |
      | Information Technology      |
    And clicks to the Save button
    Then verify that an error message "Already exists" is displayed
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
    
    @EmptyfieldEducation
    Scenario Outline: Providing an empty value in Education field in Qualifications
     Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
     When The user enters username "<username>" and password "<password>"
     And Clicks on the Login button
     And the user navigates to the Admin module
     And the user clicks on Qualifications and selects Education
     And clicks the Add button
     And enters the following Education Details
       |  Level     |
       |            |
      And clicks to the Save button
     Then verify the error message "Required" is displayed
     Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
     
    @Memberships
    Scenario Outline: Adding Membership Details in Education field in Qualifications
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And the user navigates to the Admin module
    And the user clicks the Qualificatins and selects Memberships
    And clicks the Add button
    And enters the following Membership Details
    |      Name                                        | 
    |  Computer Society of India(CSI)                  |
    And clicks to the Save button
    Then verify that the Memberships Details are successfully added
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
    
    
    @DuplicateMemberships
    Scenario Outline: Adding an already existing Memberships Detail should show an error
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And the user navigates to the Admin module
    And the user clicks the Qualificatins and selects Memberships
    And clicks the Add button
    And enters the following Membership Details
    |      Name                                         | 
    |   Computer Society of India(CSI)                  |
    And clicks to the Save button
    Then verify that an error message "Already exists" is displayed
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
    
   
    @EmptyfieldMemberships
    Scenario Outline: Providing an empty value in Memberships field in Qualifications
     Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
     When The user enters username "<username>" and password "<password>"
     And Clicks on the Login button
     And the user navigates to the Admin module
     And the user clicks the Qualificatins and selects Memberships
     And clicks the Add button
     And enters the following Membership Details
       |  Name      |
       |            |
     And clicks to the Save button 
     Then verify the error message "Required" is displayed
     Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
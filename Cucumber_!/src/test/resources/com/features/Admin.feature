@Admin
Feature: Thoushika_26MAY2025_OrangeHRM_Admin

      
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
     
    

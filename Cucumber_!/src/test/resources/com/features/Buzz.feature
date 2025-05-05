@Buzz
Feature: Thoushika_29APR2025_OrangeHRM_Buzz
  I want to access my Buzz and Post
   
  @Buzz_Post
  Scenario Outline: Access the Buzz and post it 
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    When The user click on Buzz Menu, Assert it to check
    When Once the User is on Buzz page Type in the Field box as "<fieldbox>" and click on post
    
    Examples:  
      |fieldbox               | username       | password       | loginResult     |
      |Selenium Cucumber Java | Admin          | admin123       | valid login     |
    
   
    
  @Buzz_Post_Check
  Scenario Outline: Chech the Post is displayed in the Dashboard
  Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters username "<username>" and password "<password>"
  And Clicks on the Login button
  When the user clicks on Dashboard menu
  And Assert The post to check its pressence
  Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
  
  @Buzz_AdminUserGuide
  Scenario Outline: Accessing the Admin User Guide from the Buzz Module
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And I navigated to the Buzz module and click Help button
    Then I should see the Admin User Guide page opened
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
    
   @Buzz_UpcomingAnniversaries
   Scenario Outline: View Upcoming Work Anniversaries from the Buzz Module
      Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
      When The user enters username "<username>" and password "<password>"
      And Clicks on the Login button
      And I navigated to the Buzz module
      Then  check the Upcoming Work Anniversaries section
      Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
 
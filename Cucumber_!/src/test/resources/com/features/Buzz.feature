@tag
Feature: Thoushika_15APR2025_OrangeHRM_Buzz
  I want to access my Buzz and Post
   
  @Buzz_Post
  Scenario Outline: Access the Buzz and post it 
    Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login
    When The user click on Buzz Menu, Assert it to check
    When Once the User is on Buzz page Type in the Field box as "<fieldbox>" and click on post
    
    Examples:
    
    |fieldbox|
    |Selenium Cucumber Java|
    
  @Buzz_Post_Check
  Scenario: Chech the Post is displayed in the Dashboard
    Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login
  When the user clicks on Dashboard menu
  And Assert The post to check its pressence
  
 
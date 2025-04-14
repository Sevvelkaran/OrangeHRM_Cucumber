@tag
Feature: Buzz
  I want to access my Buzz and Post
   
 Background: 
  Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login


  @Buzz_Post
  Scenario Outline: Access the Buzz and post it 
    When The user click on Buzz Menu, Assert it to check
    When Once the User is on Buzz page Type in the Field box as "<fieldbox>" and click on post
    And Like the Post
    
    Examples:
    
    |fieldbox|
    |Selenium Cucumber Java|
    
  @Buzz_Post_Check
  Scenario: Chech the Post is displayed in the Dashboard
  When the user clicks on Dashboard menu
  And Assert The post to check its pressence
  
  
  #@Buzz_MostLikedPosts
  #Scenario: Checking the Most Liked Posts in Buzz module
  #Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  
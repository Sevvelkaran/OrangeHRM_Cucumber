@tag
Feature: Login 
  I want to login into the OrangeHRM WebPage

Background:

  @ValidCred
  Scenario: Logging in with valid credentials 
      Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
   
    When The user enters username and password 
    And Clicks on the Login button 
    Then Assert them for valid login
    And Logout


  @InvalidCred
  Scenario: Logging in with invalid credentials
      Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  
    When The user enters invalid username and invalid password 
    And Clicks on the Login button 
    Then Assert them for invalid login
    

  @EmptyCred
  Scenario: Logging in with empty credentials
      Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  
    When The user enters Empty username and invalid password as 
    And Clicks on the Login button 
    Then Assert them for empty login



  @ForgotPassword
  Scenario: Forgot Password functionality
      Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  
    When The user clicks on the Forgot Password link
    Then Assert the Forgot Password page is displayed
    
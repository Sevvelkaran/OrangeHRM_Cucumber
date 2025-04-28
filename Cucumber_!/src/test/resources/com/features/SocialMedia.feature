
Feature: Karan_28APR2025_OrangeHRM_SocialMedia
  I want to check whether all the social media icons are redirecting correctly

  @SocialMedia
  Scenario: Verify Social Media Icons Redirection
    Given I want to be on the Login Page of OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    
    When The user clicks on the LinkedIn icon
    And Navigate back to the Login Page

    When The user clicks on the Facebook icon
    And Navigate back to the Login Page

    When The user clicks on the Twitter icon
    And Navigate back to the Login Page

    When The user clicks on the YouTube icon
    And Navigate back to the Login Page

    


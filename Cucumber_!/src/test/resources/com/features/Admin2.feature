@SanityTesting
Feature: Thoushika_27APR2025_OrangeHRM_Admin

Background:
  Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  When The user enters the username and password to login
  
  @Nationalities
  Scenario: Adding Nationality in Nationalities field in Qualifications
    And the user navigates on to the Admin module
    And the user clicks Nationalities
    And clicks the Add button
    And enters the following Nationality
      | Name       |
      | Indian     |
    And clicks to the Save button
   Then verify that the Nationality is successfully added
@SanityTesting
Feature: Thoushika_27APR2025_OrangeHRM_Admin

  @Nationalities
  Scenario Outline: Adding Nationality in Nationalities field in Qualifications
  Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    And the user navigates on to the Admin module
    And the user clicks Nationalities
    And clicks the Add button
    And enters the following Nationality
      | Name       |
      | Indian     |
    And clicks to the Save button
   Then verify that the Nationality is successfully added
   Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
   
   
   @NationalitiesNegative
   Scenario Outline: Leaving Nationality field in Qualifications
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
   And the user navigates on to the Admin module
   And the user clicks Nationalities
   And clicks the Add button
   And enters the following Nationality
      | Name       |
      |            |
   And clicks to the Save button
   Then verify that the Required message is displayed
    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
   
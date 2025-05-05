Feature: Karan_08APR2025_OrangeHRM_Login
  I want to login into the OrangeHRM WebPage

  

  @LoginScenarios
  Scenario Outline: Login functionality with various credentials
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters username "<username>" and password "<password>"
    And Clicks on the Login button
    Then Assert them for <loginResult>

    Examples:
      | username       | password       | loginResult     |
      | Admin          | admin123       | valid login     |
      | invalidUser    | invalidPass    | invalid login   |
      |                | invalidPass    | empty login     |

  @ForgotPassword
  Scenario: Forgot Password functionality
    Given I want to go to OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user clicks on the Forgot Password link
    Then Assert the Forgot Password page is displayed

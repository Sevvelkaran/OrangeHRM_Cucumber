@tag
Feature: Login 
  I want to login into the OrangeHRM WebPage

  @ValidCred
  Scenario Outline: Logging in with valid credentials 
    Given I want to go to OrangeHRM
    When The user enters username as "<UserName>" and password as "<Password>"
    And Clicks on the Login button 
    Then Assert them for valid login

    Examples: 
      | UserName | Password  |
      | Admin    | admin123  |

  @InvalidCred
  Scenario Outline: Logging in with invalid credentials
    Given I want to go to OrangeHRM
    When The user enters invalid username as "<InvalidUserName>" and invalid password as "<InvalidPassword>"
    And Clicks on the Login button 
    Then Assert them for invalid login

    Examples: 
      | InvalidUserName | InvalidPassword |
      | Chandruj        | karan@123       |
      | Thoushika       | Thoushi@123     |
      | Dharani         | Dhar@098        |

  @EmptyCred
  Scenario Outline: Logging in with empty credentials
    Given I want to go to OrangeHRM
    When The user enters invalid username as "<EmptyUserName>" and invalid password as "<EmptyPassword>"
    And Clicks on the Login button 
    Then Assert them for empty login

    Examples:
      | EmptyUserName | EmptyPassword |
      |               | admin123      |
      | Admin         |               |
      |               |               |

  @ForgotPassword
  Scenario: Forgot Password functionality
    Given I want to go to OrangeHRM
    When The user clicks on the Forgot Password link
    Then Assert the Forgot Password page is displayed

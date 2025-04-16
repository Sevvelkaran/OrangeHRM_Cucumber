Feature: Claim feature
@Submit
  Scenario: Submit a new claim
    Given I launch the OrangeHRM app "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I login as Admin
    And I navigate to Claim > Submit Claim
    And I select event and currency and add remarks
    And I click on Create button
@Assign
  Scenario: Assign claim and validate expense
    Given I launch the OrangeHRM app "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I login as Admin
    And I navigate to Claim > Assign Claim
    And I assign a claim for an employee
    
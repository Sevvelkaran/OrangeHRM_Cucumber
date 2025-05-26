Feature: Submit and validate Claim

  @claim
  Scenario: Submit valid claim and verify success
    Given the user opens OrangeHRM login page
    When the user logs in with valid credentials "Admin" and "admin123"
    And navigates to Claim section and submits a claim
    

Feature: Dharani_13APR2025_OrangeHRM_Configuration

@AddOptionalFields 
Scenario: Enable optional fields in PIM configuration
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user clicks the Configuration menu and then clicks Optional Fields
  And the user enables the Show Deprecated Fields option
  And the user clicks the Save button
  Then the Show Deprecated Fields option should remain enabled 
  
  @AddCustomfields
  Scenario: Add Custom fields in PIM configuration
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user clicks the Configuration menu and then clicks Custom Fields
  And the user clicks the Add button
  And the user fills out the Add Custom Field form
  And the user click the save button
  Then the field should be added to the records
  
  
  @AddReportingmethods
  Scenario: Add Reporting methods in PIM configuration
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user clicks the Configuration menu and then clicks Reporting methods
  And the user clicks the Add button
  And the user enters the name of the reporting method
  And the user click the save button
  Then the reporting method should be added to the list
  
  
  @Terminationreason
  Scenario: Add Termination Reson in PIM configuration
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user clicks the Configuration menu and then clicks Termination Reasons
  And the user clicks the Add button
  And the user enters the Termination reason
  And the user click the save button
  Then the Termination Reason should be added to the list